#!/usr/bin/env python3
import argparse
import os
import sys
import textwrap
from PIL import Image

TEST_TEXT = (
    '"Font test"\\n\\n'
    "СЪЕШЬ ЖЕ ЕЩЁ ЭТИХ МЯГКИХ ФРАНЦУЗСКИХ БУЛОК, ДА ВЫПЕЙ ЧАЮ.\n"
    "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG'S TAIL!\n\n"
    " - numbers: 0123456789\n"
    " - symbols: '`*-:?!#()\\/><\".,;^|&%$@_{}[]\n"
r'''

     |\    o
    |  \    o
|\ /    .\ o
| |       (
|/ \     /
    |  /
     |/

'''
)

# Default layout for most games
DEFAULT_LAYOUT = [
    "0123456789",
    "АБВГДЕЖЗИЙ",
    "КЛМНОПРСТУ",
    "ФХЦ ШЩ ЫЬЭ",
    "ЮЯ-.(), …#",
    ":?!ЁU*RDSF",
    "ILVYNG»JQZ"
]

B3D_LAYOUT = [
    "0123456789",
    "АБВГДЕЖЗИЙ",
    "КЛМНОПРСТУ",
    "ФХЦ ШЩ ЫЬЭ",
    "ЮЯ-.(), …#",
    ":?!ЁU*RDSF",
    "ILVG  »JQZ"
]

INPUT_TO_FONT = {
    'A': 'А', 'B': 'В', 'C': 'С', 'D': 'D', 'E': 'Е',
    'F': 'F', 'G': 'G', 'H': 'Н', 'I': 'I', 'J': 'J',
    'K': 'К', 'L': 'L', 'M': 'М', 'N': 'N', 'O': 'О',
    'P': 'Р', 'Q': 'Q', 'R': 'R', 'S': 'S', 'T': 'Т',
    'U': 'U', 'V': 'V', 'W': 'Ш', 'X': 'Х', 'Y': 'Y', 'Z': 'Z',
    'Ъ': 'Ь', 'Ч': '4', '>': '»', '@': '*',
}

def process_text(text):
    # Handle literal and escaped newlines
    text = text.replace("\\n", "\n")
    text = text.upper().replace("...", "…")

    res = []
    open_quote = False

    for char in text:
        if char == '"':
            res.append('«' if not open_quote else '»')
            open_quote = not open_quote
        else:
            res.append(INPUT_TO_FONT.get(char, char))
    return "".join(res)

def get_char_tile(font_img, char, char_coords, game, CHAR_W, CHAR_H):
    # Special Case: Mirrored « (Universal)
    if char in ('«', '<') and '»' in char_coords:
        cx, cy = char_coords['»']
        crop = font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))
        return crop.transpose(Image.Transpose.FLIP_LEFT_RIGHT)

    # Special Case: Vertically mirrored comma for apostrophe
    if char in ("'", "`") and ',' in char_coords:
        cx, cy = char_coords[',']
        crop = font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))
        return crop.transpose(Image.Transpose.FLIP_TOP_BOTTOM)

    # Special Case: Slashes generated from rotated hyphens
    if char in ('/', '\\') and '-' in char_coords:
        cx, cy = char_coords['-']
        crop = font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))
        # Rotate 45 deg counter-clockwise for '/', -45 (or 315) for '\'
        angle = 45 if char == '/' else -45
        return crop.rotate(angle, resample=Image.BICUBIC)

    # Special Case: Semicolon (combined from , and mirrored .)
    if char == ';' and ',' in char_coords and '.' in char_coords:
        # Create a transparent base tile
        semicolon_tile = Image.new('RGBA', (CHAR_W, CHAR_H), (0, 0, 0, 0))

        # Get the comma
        cx_comma, cy_comma = char_coords[',']
        comma_tile = font_img.crop((cx_comma * CHAR_W, cy_comma * CHAR_H, (cx_comma + 1) * CHAR_W, (cy_comma + 1) * CHAR_H))

        # Get the period and mirror it vertically
        cx_dot, cy_dot = char_coords['.']
        dot_tile = font_img.crop((cx_dot * CHAR_W, cy_dot * CHAR_H, (cx_dot + 1) * CHAR_W, (cy_dot + 1) * CHAR_H))
        mirrored_dot = dot_tile.transpose(Image.Transpose.FLIP_TOP_BOTTOM)

        # Composite them (pasting comma over the mirrored dot or vice versa)
        semicolon_tile.paste(mirrored_dot, (0, 0), mirrored_dot if mirrored_dot.mode == 'RGBA' else None)
        semicolon_tile.paste(comma_tile, (0, 0), comma_tile if comma_tile.mode == 'RGBA' else None)
        return semicolon_tile

    # Special Case: B3D Overrides
    if game == 'b3d':
        if char == 'N': # Mirrored И
            cx, cy = char_coords.get('И', (0,0))
            return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.FLIP_LEFT_RIGHT)
        if char == 'Y': # У
            cx, cy = char_coords.get('У', (0,0))
            return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))
        if char == 'Э': # Mirrored Е
            cx, cy = char_coords.get('Е', (0,0))
            return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.FLIP_LEFT_RIGHT)

    # Special Case: C3D Overrides
    if game == 'c3d':
        if char == 'J': # 180 rotated 7
            cx, cy = char_coords.get('7', (0,0))
            return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.FLIP_TOP_BOTTOM)
        if char == 'Z': # Mirrored S
            cx, cy = char_coords.get('S', (0,0))
            return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.FLIP_LEFT_RIGHT)
        if char == 'Q': # 180 rotated Ь
            cx, cy = char_coords.get('Ь', (0,0))
            return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.ROTATE_180)

    if char == '^': # Mirrored Л
        cx, cy = char_coords.get('Л', (0,0))
        return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.FLIP_LEFT_RIGHT)

    if char == '&': # Mirrored В
        cx, cy = char_coords.get('В', (0,0))
        return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.FLIP_LEFT_RIGHT)

    if char == '|': # Rotated -
        cx, cy = char_coords.get('-', (0,0))
        return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H)).transpose(Image.Transpose.ROTATE_90)

    # Standard lookup
    if char in char_coords:
        cx, cy = char_coords[char]
    else:
        cx, cy = char_coords.get(' ', (0, 3)) # Default fallback

    return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))


def wrapByWords(text: str, charLimit: int) -> str:
    if not text:
        return ""

    lines = text.splitlines()
    wrapped_lines = []

    for line in lines:
        if not line:
            wrapped_lines.append("")
        else:
            wrapped = textwrap.fill(
                line,
                width=charLimit,
                fix_sentence_endings=False,
                break_long_words=False
            )
            wrapped_lines.append(wrapped)

    return "\n".join(wrapped_lines)


def renderText(game: str, text: str, scale: int, charLimit: int, addBlackBackground: bool = False) -> Image.Image:
    script_dir = os.path.dirname(os.path.realpath(__file__))
    font_path = os.path.join(script_dir, f"font_{game}.png")

    if not os.path.exists(font_path):
        raise FileNotFoundError(f"Font file not found at {font_path}")

    font_img = Image.open(font_path).convert("RGBA")
    bg_color = font_img.getpixel((0, 0))

    datas = font_img.getdata()
    new_data = []
    for item in datas:
        if item[0:3] == bg_color[0:3]:
            new_data.append((0, 0, 0, 0))
        else:
            new_data.append(item)
    font_img.putdata(new_data)

    current_layout = B3D_LAYOUT if game == 'b3d' else DEFAULT_LAYOUT
    char_coords = {c: (x, y) for y, row in enumerate(current_layout) for x, c in enumerate(row) if c != ' '}
    char_coords[' '] = (3, 3)

    processed_text = process_text(text)
    processed_text = wrapByWords(processed_text, charLimit)
    lines = processed_text.split('\n')

    CHAR_W, CHAR_H = 15, 16
    max_len = max(len(line) for line in lines) if lines else 0

    # Logic for background color
    bg_fill = (0, 0, 0, 255) if addBlackBackground else (0, 0, 0, 0)
    out_img = Image.new("RGBA", (max_len * CHAR_W, len(lines) * CHAR_H), bg_fill)

    for line_idx, line in enumerate(lines):
        for char_idx, char in enumerate(line):
            tile = get_char_tile(font_img, char, char_coords, game, CHAR_W, CHAR_H)
            # Use tile as mask to preserve transparency of the font itself
            # while pasting onto the chosen background
            out_img.paste(tile, (char_idx * CHAR_W, line_idx * CHAR_H), tile)

    if scale != 1:
        new_size = (out_img.width * scale, out_img.height * scale)
        out_img = out_img.resize(new_size, resample=Image.Resampling.NEAREST)

    return out_img

def main():
    parser = argparse.ArgumentParser(description="Render text using sprite sheet fonts.")
    parser.add_argument("--game", choices=['b3d', 'l3d', 'c3d'], required=True, help="Game font to use")
    parser.add_argument("--test", action="store_true", help="Render test sentences")
    parser.add_argument("--output", "-o", type=str, help="Output filename")
    parser.add_argument("--scale", type=int, default=6, help="Scale factor. Default 6")
    parser.add_argument("--limit", type=int, default=300, help="Chars per line. Default 300")
    parser.add_argument("--background", action="store_true", help="Add solid black background")
    parser.add_argument("text", nargs="?", default="", help="Text to render")
    args = parser.parse_args()

    if not args.test and not args.text:
        parser.error("Required: text or --test")

    render_input = TEST_TEXT if args.test else args.text

    try:
        out_img = renderText(args.game, render_input, args.scale, args.limit, args.background)
    except Exception as e:
        print(f"Error: {e}")
        sys.exit(1)

    if args.output:
        out_filename = args.output
    else:
        prefix = "test_" if args.test else "rendered_"
        out_filename = f"{prefix}{args.game}.png"

    out_img.save(out_filename)
    print(f"Successfully rendered {args.game} text to {out_filename}")


if __name__ == "__main__":
    main()


#!/usr/bin/env python3
import argparse
import os
import sys
from PIL import Image

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
    'Ъ': 'Ь', 'Ч': '4',
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
    # 1. Special Case: Mirrored « (Universal)
    if char == '«' and '»' in char_coords:
        cx, cy = char_coords['»']
        crop = font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))
        return crop.transpose(Image.Transpose.FLIP_LEFT_RIGHT)

    # 2. Special Case: Vertically mirrored comma for apostrophe
    if char == "'" and ',' in char_coords:
        cx, cy = char_coords[',']
        crop = font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))
        return crop.transpose(Image.Transpose.FLIP_TOP_BOTTOM)

    # 3. Special Case: B3D Overrides
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

    # 4. Special Case: C3D Overrides
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

    # Standard lookup
    if char in char_coords:
        cx, cy = char_coords[char]
    else:
        cx, cy = char_coords.get(' ', (0, 3)) # Default fallback

    return font_img.crop((cx * CHAR_W, cy * CHAR_H, (cx + 1) * CHAR_W, (cy + 1) * CHAR_H))

def main():
    parser = argparse.ArgumentParser(description="Render text using sprite sheet fonts.")
    parser.add_argument("--game", choices=['b3d', 'l3d', 'c3d'], required=True, help="Game font to use")
    parser.add_argument("--test", action="store_true", help="Render test sentences instead of provided text")
    parser.add_argument("--output", "-o", type=str, help="Output filename")
    parser.add_argument("text", nargs="?", default="", help="Text to render")
    args = parser.parse_args()

    if not args.test and not args.text:
        parser.error("The following arguments are required: text (or use --test)")

    script_dir = os.path.dirname(os.path.realpath(__file__))
    font_path = os.path.join(script_dir, f"font_{args.game}.png")

    if not os.path.exists(font_path):
        print(f"Error: Font file not found at {font_path}")
        sys.exit(1)

    font_img = Image.open(font_path).convert("RGBA")

    bg_color = font_img.getpixel((0, 0))

    datas = font_img.getdata()
    new_data = []
    for item in datas:
        # If the pixel matches the background color exactly, make it fully transparent
        if item[0:3] == bg_color[0:3]:
            new_data.append((0, 0, 0, 0))
        else:
            new_data.append(item)
    font_img.putdata(new_data)

    current_layout = B3D_LAYOUT if args.game == 'b3d' else DEFAULT_LAYOUT

    char_coords = {}
    for y, row in enumerate(current_layout):
        for x, c in enumerate(row):
            if c != ' ' and c not in char_coords:
                char_coords[c] = (x, y)

    char_coords[' '] = (3, 3) # Specific space coordinate

    if args.test:
        render_input = (
            '"Font test"\\n'
            "СЪЕШЬ ЖЕ ЕЩЁ ЭТИХ МЯГКИХ ФРАНЦУЗСКИХ БУЛОК, ДА ВЫПЕЙ ЧАЮ.\n"
            "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG'S TAIL!\n"
            "  (numbers): 0123456789... ?"
        )
    else:
        render_input = args.text

    processed_text = process_text(render_input)
    lines = processed_text.split('\n')

    CHAR_W, CHAR_H = 15, 16
    max_len = max(len(line) for line in lines) if lines else 0
    out_img = Image.new("RGBA", (max_len * CHAR_W, len(lines) * CHAR_H), (0, 0, 0, 0))

    for line_idx, line in enumerate(lines):
        for char_idx, char in enumerate(line):
            tile = get_char_tile(font_img, char, char_coords, args.game, CHAR_W, CHAR_H)
            out_img.paste(tile, (char_idx * CHAR_W, line_idx * CHAR_H))

    # Handle output filename logic
    if args.output:
        out_filename = args.output
    else:
        prefix = "test_" if args.test else "rendered_"
        out_filename = f"{prefix}{args.game}.png"

    out_img.save(out_filename)
    print(f"Successfully rendered {args.game} text to {out_filename}")

if __name__ == "__main__":
    main()

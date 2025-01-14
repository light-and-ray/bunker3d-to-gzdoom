from PIL import Image, ImageDraw, ImageFont

def reconfigureLines(lines: list[list]):
    newLines = []
    for i in range(len(lines[0])):
        newLines.append([lines[0][i], lines[1][i], lines[2][i], lines[3][i]])
    return newLines


def draw_lines(lines, width=1024):
    lines = reconfigureLines(lines)
    # Calculate min and max coordinates
    min_x = min(min(line[0], line[2]) for line in lines)
    max_x = max(max(line[0], line[2]) for line in lines)
    min_y = min(min(line[1], line[3]) for line in lines)
    max_y = max(max(line[1], line[3]) for line in lines)
    height = int((max_y - min_y) / (max_x - min_x) * width)

    # Rescale coordinates
    def rescale(x, y):
        scaled_x = int(((x - min_x) / (max_x - min_x)) * width)
        scaled_y = int(height - ((y - min_y) / (max_y - min_y)) * height)
        return scaled_x, scaled_y

    # Create a new image
    img = Image.new('RGB', (width, height), color = (73, 109, 137))
    draw = ImageDraw.Draw(img)

    # Draw lines
    for i, line in enumerate(lines):
        x1, y1, x2, y2 = line
        scaled_x1, scaled_y1 = rescale(x1, y1)
        scaled_x2, scaled_y2 = rescale(x2, y2)
        draw.line([(scaled_x1, scaled_y1), (scaled_x2, scaled_y2)], fill=(255, 255, 0), width=2)
        draw.circle((scaled_x1, scaled_y1), fill=(0, 255, 0), radius=2)
        draw.circle((scaled_x2, scaled_y2), fill=(0, 255, 0), radius=2)
        midpoint_x = (scaled_x1 + scaled_x2) / 2
        midpoint_y = (scaled_y1 + scaled_y2) / 2
        font = ImageFont.load_default()
        draw.text((midpoint_x-6, midpoint_y-7), str(i), fill=(0, 0, 0), font=font, anchor=None)

    # Save the image
    img.show()
    img.save('lines.png')


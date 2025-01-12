from PIL import Image, ImageDraw

def reconfigureLines(lines: list[list]):
    newLines = []
    for i in range(len(lines[0])):
        newLines.append([lines[0][i], lines[1][i], lines[2][i], lines[3][i]])
    return newLines


def draw_lines(lines, width=1024, height=1024):
    lines = reconfigureLines(lines)
    # Calculate min and max coordinates
    min_x = min(min(d[0], d[2]) for d in lines)
    max_x = max(max(d[0], d[2]) for d in lines)
    min_y = min(min(d[1], d[3]) for d in lines)
    max_y = max(max(d[1], d[3]) for d in lines)

    # Rescale coordinates
    def rescale(x, y):
        scaled_x = int(((x - min_x) / (max_x - min_x)) * 1024)
        scaled_y = int(((y - min_y) / (max_y - min_y)) * 1024)
        return scaled_x, scaled_y

    # Create a new image
    img = Image.new('RGB', (1024, 1024), color = (73, 109, 137))
    d = ImageDraw.Draw(img)

    # Draw lines
    for line in lines:
        x1, y1, x2, y2 = line
        scaled_x1, scaled_y1 = rescale(x1, y1)
        scaled_x2, scaled_y2 = rescale(x2, y2)
        d.line([(scaled_x1, scaled_y1), (scaled_x2, scaled_y2)], fill=(255, 255, 0), width=2)

    # Save the image
    img.show()
    img.save('lines.png')


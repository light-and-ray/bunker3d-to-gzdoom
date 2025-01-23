from PIL import Image, ImageDraw, ImageFont
from ClassesShared import HeightType
import math
import svgwrite
from typing import TYPE_CHECKING
if TYPE_CHECKING:
    from ClassesInterim import MapInterim


def drawMap(map: 'MapInterim', show=True, name=None, resolution=1280, frame=30, wait=False):
    # Calculate min and max coordinates
    min_x = min(min(line.v1.x, line.v2.x) for line in map.lines)
    max_x = max(max(line.v1.x, line.v2.x) for line in map.lines)
    min_y = min(min(line.v1.y, line.v2.y) for line in map.lines)
    max_y = max(max(line.v1.y, line.v2.y) for line in map.lines)
    ratio = (max_y - min_y) / (max_x - min_x)
    height = int((resolution**2 * ratio)**0.5)
    width = int(resolution**2/height)

    # Rescale coordinates
    def rescale(x, y):
        scaled_x = int(((x - min_x) / (max_x - min_x)) * width) + frame
        scaled_y = int(height - ((y - min_y) / (max_y - min_y)) * height) + frame
        return scaled_x, scaled_y

    # Create a new image
    img = Image.new('RGB', (width+frame*2, height+frame*2), color = (73, 109, 137))
    draw = ImageDraw.Draw(img)

    # Draw lines
    for i, line in enumerate(map.lines):
        x1, y1 = line.v1.x, line.v1.y
        x2, y2 = line.v2.x, line.v2.y
        scaled_x1, scaled_y1 = rescale(x1, y1)
        scaled_x2, scaled_y2 = rescale(x2, y2)
        color = None
        if line.height == HeightType.FULL:
            color = (255, 255, 0)
        elif line.height == HeightType.BOTTOM:
            color = (250, 56, 35)
        else:
            color = (10, 99, 207)
        draw.line([(scaled_x1, scaled_y1), (scaled_x2, scaled_y2)], fill=color, width=2)
        draw.circle((scaled_x1, scaled_y1), fill=(0, 255, 0), radius=2)
        draw.circle((scaled_x2, scaled_y2), fill=(0, 255, 0), radius=2)
        midpoint_x = (scaled_x1 + scaled_x2) / 2
        midpoint_y = (scaled_y1 + scaled_y2) / 2

        # Draw normal indicators
        dx = scaled_x2 - scaled_x1
        dy = scaled_y2 - scaled_y1
        length = math.hypot(dx, dy)
        if length > 0:
            normal_x = -dy / length
            normal_y = dx / length
            normal_x *= 5
            normal_y *= 5
            normal_x += midpoint_x
            normal_y += midpoint_y
            draw.line([(midpoint_x, midpoint_y), (normal_x, normal_y)], fill=color, width=1)

        font = ImageFont.load_default()
        draw.text((midpoint_x-6, midpoint_y-7), str(i), fill=(0, 0, 0), font=font, anchor=None)

    # Save the image
    if show:
        img.show()
    if name:
        img.save(f'drawings/{name}.png')
        drawMapSVG(map, name=name, resolution=resolution, frame=frame)

    if wait:
        input("PRESS ANY KEY")




def drawMapSVG(map: 'MapInterim', name, resolution=1280, frame=30):
    # Calculate min and max coordinates
    min_x = min(min(line.v1.x, line.v2.x) for line in map.lines)
    max_x = max(max(line.v1.x, line.v2.x) for line in map.lines)
    min_y = min(min(line.v1.y, line.v2.y) for line in map.lines)
    max_y = max(max(line.v1.y, line.v2.y) for line in map.lines)
    ratio = (max_y - min_y) / (max_x - min_x)
    height = int((resolution**2 * ratio)**0.5)
    width = int(resolution**2/height)

    # Rescale coordinates
    def rescale(x, y):
        scaled_x = ((x - min_x) / (max_x - min_x)) * width + frame
        scaled_y = height - ((y - min_y) / (max_y - min_y)) * height + frame
        return scaled_x, scaled_y

    # Create an SVG file
    svg_filename = f"drawings/{name}.svg" if name else "output.svg"
    dwg = svgwrite.Drawing(svg_filename, (width+frame*2, height+frame*2), debug=True)
    dwg.add(dwg.rect(insert=(0, 0),
                    size=(width+frame*2, height+frame*2),
                    fill='white',
                    fill_opacity=1))
    # Draw lines
    for i, line in enumerate(map.lines):
        x1, y1 = line.v1.x, line.v1.y
        x2, y2 = line.v2.x, line.v2.y
        scaled_x1, scaled_y1 = rescale(x1, y1)
        scaled_x2, scaled_y2 = rescale(x2, y2)
        color = None
        if line.height == HeightType.FULL:
            color = svgwrite.rgb(255, 255, 0, '%')  # Yellow
        elif line.height == HeightType.BOTTOM:
            color = svgwrite.rgb(250, 56, 35, '%')  # Reddish
        else:
            color = svgwrite.rgb(10, 99, 207, '%')  # Blueish

        # Draw line
        dwg.add(dwg.line((scaled_x1, scaled_y1), (scaled_x2, scaled_y2),
                         stroke=color, stroke_width=2, fill='none'))

        # Draw endpoints
        dwg.add(dwg.circle((scaled_x1, scaled_y1), 2, fill='green'))
        dwg.add(dwg.circle((scaled_x2, scaled_y2), 2, fill='green'))

        # Draw normal indicators
        midpoint_x = (scaled_x1 + scaled_x2) / 2
        midpoint_y = (scaled_y1 + scaled_y2) / 2
        dx = scaled_x2 - scaled_x1
        dy = scaled_y2 - scaled_y1
        length = math.hypot(dx, dy)
        if length > 0:
            normal_x = -dy / length
            normal_y = dx / length
            normal_x *= 5
            normal_y *= 5
            normal_x += midpoint_x
            normal_y += midpoint_y
            dwg.add(dwg.line((midpoint_x, midpoint_y), (normal_x, normal_y),
                             stroke=color, stroke_width=1, fill='none'))

        # Draw text (line index)
        dwg.add(dwg.text(str(i), insert=(midpoint_x-8, midpoint_y+4),
                         fill='black', font_size=12, font_family='sans-serif'))

    # Save the SVG
    dwg.save()

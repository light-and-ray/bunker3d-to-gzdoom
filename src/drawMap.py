from ClassesShared import HeightType
import math, os
import svgwrite
from typing import TYPE_CHECKING
if TYPE_CHECKING:
    from ClassesInterim import MapInterim
    from ClassesB3D import MapB3D


def drawMap(map: 'MapInterim|MapB3D', show=False, name=None, resolution=1280, frame=30, wait=False):
    setX = set([line.v1.x for line in map.lines] + [line.v2.x for line in map.lines])
    setY = set([line.v1.y for line in map.lines] + [line.v2.y for line in map.lines])
    if hasattr(map, 'things'):
        setX.update([thing.pos.x for thing in map.things])
        setY.update([thing.pos.y for thing in map.things])
    if hasattr(map, 'triggers'):
        setX.update([trigger.x for trigger in map.triggers])
        setY.update([trigger.y for trigger in map.triggers])
    min_x = min(setX)
    max_x = max(setX)
    min_y = min(setY)
    max_y = max(setY)
    ratio = (max_y - min_y) / (max_x - min_x)
    height = int((resolution**2 * ratio)**0.5)
    width = int(resolution**2/height)

    def rescale(x, y):
        scaled_x = ((x - min_x) / (max_x - min_x)) * width + frame
        scaled_y = height - ((y - min_y) / (max_y - min_y)) * height + frame
        return scaled_x, scaled_y

    svg_filename = f"drawings/{name}.svg" if name else "tmp/tmp.svg"
    dwg = svgwrite.Drawing(svg_filename, (width+frame*2, height+frame*2), debug=True)
    dwg.add(dwg.rect(insert=(0, 0),
                    size=(width+frame*2, height+frame*2),
                    fill=svgwrite.rgb(73, 109, 137),
                    fill_opacity=1))
    # Draw lines
    for i, line in enumerate(map.lines):
        x1, y1 = line.v1.x, line.v1.y
        x2, y2 = line.v2.x, line.v2.y
        scaled_x1, scaled_y1 = rescale(x1, y1)
        scaled_x2, scaled_y2 = rescale(x2, y2)
        color = None
        if line.height == HeightType.FULL:
            color = svgwrite.rgb(255, 255, 0)  # Yellow
        elif line.height in (HeightType.ONLY_BOTTOM, HeightType.BOTTOM):
            color = svgwrite.rgb(250, 56, 35)  # Reddish
        else:
            color = svgwrite.rgb(10, 99, 207)  # Blueish

        # Draw line
        dwg.add(dwg.line((scaled_x1, scaled_y1), (scaled_x2, scaled_y2),
                         stroke=color, stroke_width=2, fill='none'))

        # Draw endpoints
        dwg.add(dwg.circle((scaled_x1, scaled_y1), 2, fill=svgwrite.rgb(0, 255, 0)))
        dwg.add(dwg.circle((scaled_x2, scaled_y2), 2, fill=svgwrite.rgb(0, 255, 0)))

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
        # dwg.add(dwg.text(str(i), insert=(midpoint_x-8, midpoint_y+4),
        #                  fill='black', font_size=12, font_family='sans-serif'))

    if hasattr(map, 'things'):
        for i, thing in enumerate(map.things):
            if not thing: continue
            x, y = rescale(*thing.pos.pair())
            dwg.add(dwg.circle((x, y), 4, fill=svgwrite.rgb(255, 0, 0)))
            dwg.add(dwg.text(str(thing.index), insert=(x, y),
                         fill='black', font_size=12, font_family='sans-serif'))

    if hasattr(map, 'triggers'):
        for i, trigger in enumerate(map.triggers):
            x1, y1 = rescale(trigger.x - 75000, trigger.y - 75000)
            x2, y2 = rescale(trigger.x - 75000, trigger.y + 75000)
            x3, y3 = rescale(trigger.x + 75000, trigger.y + 75000)
            x4, y4 = rescale(trigger.x + 75000, trigger.y - 75000)
            color = svgwrite.rgb(69, 69, 69)
            dwg.add(dwg.line((x1, y1), (x2, y2),
                    stroke=color, stroke_width=0.5, fill='none'))
            dwg.add(dwg.line((x2, y2), (x3, y3),
                    stroke=color, stroke_width=0.5, fill='none'))
            dwg.add(dwg.line((x3, y3), (x4, y4),
                    stroke=color, stroke_width=0.5, fill='none'))
            dwg.add(dwg.line((x4, y4), (x1, y1),
                    stroke=color, stroke_width=0.5, fill='none'))
            x, y = rescale(trigger.x, trigger.y)
            # dwg.add(dwg.text("trig " + str(i), insert=(x, y),
            #  fill='black', font_size=12, font_family='sans-serif'))


    dwg.save()
    if show:
        os.system(f"firefox '{svg_filename}'")
    if wait:
        input("PRESS ANY KEY")

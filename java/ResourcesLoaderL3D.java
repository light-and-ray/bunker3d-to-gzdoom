import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

public class ResourcesLoaderL3D {
   public String ROOT_JAR = "../jars/l3d.d";
   public ArrayList<Integer> DOORS_START_LINE_IDX = new ArrayList<>();
   public ArrayList<Integer> CRATES_START_LINE_IDX = new ArrayList<>();
   public ArrayList<Byte> CRATES_CONTENT = new ArrayList<>();
   public ArrayList<Byte> CRATES_ANGLE = new ArrayList<>();
   public ArrayList<Integer> TEXTURES_W = new ArrayList<>();
   public ArrayList<Integer> TEXTURES_H = new ArrayList<>();
   public ArrayList<int[]> TEXTURES_DATA = new ArrayList<>();
   public short[] FOOTER;
   public ArrayList<ArrayList<Integer>> CIRCLES_IDX = new ArrayList<>();
   public short[] SPRITES_W;
   public short[] SPRITES_H;
   public ArrayList<int[]> SPRITES_DATA_COLOR_1 = new ArrayList<>();
   public ArrayList<int[]> SPRITES_DATA_COLOR_2 = new ArrayList<>();
   public ArrayList<Short> FOE_SPRITES_W = new ArrayList<>();
   public ArrayList<Short> FOE_SPRITES_H = new ArrayList<>();
   public ArrayList<int[]> FOE_SPRITES_DATA_COLOR_1 = new ArrayList<>();
   public ArrayList<int[]> FOE_SPRITES_DATA_COLOR_2 = new ArrayList<>();

}

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;


public class ResourcesLoaderC3D {
   public String ROOT_JAR = "../jars/c3d.d";
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

   public ResourcesLoaderC3D() {
   }

   public BufferedImage readImage(String filePath) {
      try (FileInputStream fileInputStream = new FileInputStream(new File(ROOT_JAR + filePath))) {
          byte[] header = new byte[2];
          fileInputStream.read(header);

          int lengthLowByte = header[0] & 255;
          int lengthHighByte = header[1] & 255;
          int imageDataLength = lengthLowByte | lengthHighByte << 8;

          byte[] imageData = new byte[imageDataLength + 4];
          fileInputStream.read(imageData, 4, imageDataLength);
          imageData[0] = -119; // 0x89
          imageData[1] = 80;   // 'P'
          imageData[2] = 78;   // 'N'
          imageData[3] = 71;   // 'G'

          return ImageIO.read(new ByteArrayInputStream(imageData));
      } catch (IOException e) {
          return null;
      }
   }


   public byte[] readBinary(String fileName) {
      try (FileInputStream fileStream = new FileInputStream(new File(ROOT_JAR + fileName))) {
         // Read the file length (2 bytes)
         int lengthLowByte = fileStream.read();
         int lengthHighByte = fileStream.read();
         int fileLength = (lengthHighByte << 8) | (lengthLowByte & 0xFF);

         byte[] fileData = new byte[fileLength];
         fileStream.read(fileData, 0, fileData.length);
         return fileData;
      } catch (IOException e) {
         return null;
      }
   }

   public static short readShort(byte[] var0, int var1) {
      return (short)(var0[var1] & 255 | (var0[var1 + 1] & 255) << 8);
   }




   public final short[] c = new short[]{3, 62, 121, 180};
   public short[] d;
   public short[] e;
   public short[] f;
   public short[] g;
   public byte[] h;
   public byte[] i;
   public byte[] j;
   public byte[] k;
   public byte[] l;
   public byte[] m;
   public byte[] n;
   public byte[] o;
   public int[][] loadedMap;
   public byte[] q = new byte[]{5, 100, 10, 8};
   public String dataExt = ".b3d";
   public String[] mapFiles = new String[]{"/temple", "/catacomb", "/ground", "/chemical", "/chdepot", "/vine", "/cell", "/hall", "/rooms", "/library", "/vip", "/roof"};
   public String[] spriteFiles = new String[]{"/p", "/r", "/d", "/pp", "/rr", "dd"};
   public byte[][] u = new byte[][]{{1, 1, -1, 1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {1, -1, 1, 1}};
   public byte v;
   public byte w;
   public byte x;
   public byte y;
   public boolean z;
   public short[][][] A = new short[][][]{{{0, 17}, {135, 46}, {-90, 26}, {45, 40}, {180, 17}}, {{-90, 50}, {90, 56}, {0, 122}, {-90, 104}, {180, 122}, {0, 38}, {-90, 92}, {180, 104}, {0, 96}, {-90, 108}, {90, 74}, {0, 104}, {180, 96}, {90, 92}, {0, 113}, {180, 30}, {-90, 35}, {180, 44}, {90, 70}, {0, 44}, {-90, 39}}};
   public byte[][][][] D;
   public byte[][][] E;
   public int[] F;
   public int[] G;
   public int[] H;
   public byte I;
   public int J;
   public int K;
   public int[] L;
   public int[][] M;
   public int[] N;
   public int O;
   public int P;
   public int Q;
   public int R;
   public long S;
   public long T;
   public long U;
   public long V;
   public long W;
   public long X;
   public long Y;
   public long Z;
   public long aa;
   public long ab;
   public long ac;
   public long ad;
   public long ae;
   public long af;
   public long ag;
   public long ah;
   public long ai;
   public long aj;
   public long ak;
   public long al;
   public long am;
   public long an;
   public long ao;
   public long ap;
   public long aq;
   public int ar;
   public int as;
   public int at;
   public int au;
   public int av;
   public int aw;
   public int ax;
   public int ay;
   public int az;
   public int aA;
   public int aB;
   public int aC;
   public int aD;
   public int aE;
   public int aF;
   public int aG;
   public int aH;
   public int aI;
   public int aJ;
   public int aK;
   public int aL;
   public int aM;
   public int aN;
   public int aO;
   public int aP;
   public int aQ;
   public int aR;
   public int aS;
   public int aT;
   public int aU;
   public int aV;
   public int aW;
   public int aX;
   public int aY;
   public int aZ;
   public int ba;
   public int bb;
   public int bc;
   public int bd;
   public int be;
   public int bf;
   public int bg;
   public int bh;
   public int bi;
   public int bj;
   public byte bk;
   public byte bl;
   public boolean bm;
   public boolean bn;
   public boolean bo;
   public boolean bp;
   public boolean bq;
   public boolean br;
   public boolean bs;
   public boolean bt;
   public boolean bu;
   public boolean bv;
   public boolean bw;
   public long[] bx;
   public long[] by;
   public long[] bz;
   public int[] bA;
   public int[] bB;
   public int[] bC;
   public int[] bD;
   public int[] bE;
   public int[] bF;
   public int[] bG;
   public int[][] bH;
   public int[][] bI;
   public short[][] bJ;
   public short[] bK;
   public short[] bL;
   public short[] bM;
   public short[] bN;
   public short[] bO;
   public short[] bP;
   public byte[] bQ;
   public byte[] bR;
   public byte[] bS;
   public byte[] bT;
   public short[][][] bU;
   public boolean[] bV;
   public long bW;
   public long bX;
   public long bY;
   public long bZ;
   public long ca;
   public long cb;
   public long cc;
   public long cd;
   public long ce;
   public long cf;
   public int cg;
   public int ch;
   public int ci;
   public int cj;
   public int ck;
   public int cl;
   public int cm;
   public int cn;
   public int co;
   public int cp;
   public int cq;
   public int cr;
   public boolean cs;
   public long[] ct;
   public long[] cu;
   public long[] cv;
   public long[] cw;
   public int[][] cx;
   public int[][] cy;
   public int[] cz;
   public int[] cA;
   public int[] cB;
   public short[] cC;
   public short[] cD;
   public short[] cE;
   public byte[] cF;
   public byte[] cG;
   public byte[] cH;
   public byte[] cI;
   public byte[] cJ;
   public byte[] cK;
   public byte[] cL;
   public byte[] cM;
   public byte[] cN;
   public byte[] cO;
   public byte[] cP;
   public byte[][] cQ;
   public short[][] cR;
   public boolean[] cS;
   public boolean[] cT;
   public boolean[] cU;
   public boolean[] cV;
   public boolean[] cW;
   public long cX;
   public long cY;
   public long cZ;
   public long da;
   public long db;
   public long dc;
   public long dd;
   public long de;
   public long df;
   public long dg;
   public long dh;
   public long di;
   public long dj;
   public long dk;
   public int dl;
   public byte dm;
   public short[][] dn;
   public short[][] do_;
   public long[] dp;
   public long[] dq;
   public int[] dr;
   public int[] ds;
   public int[] dt;
   public int[] du;
   public int[] dv;
   public int[] dw;
   public int[] dx;
   public int[] dy;
   public int[] dz;
   public int[] dA;
   public int[] dB;
   public int[] dC;
   public int[] dD;
   public int[] dE;
   public int[] dF;
   public int[] dG;
   public int[] dH;
   public int[] dI;
   public int[] dJ;
   public int[] dK;
   public int[] dL;
   public int[] dM;
   public int[] dN;
   public int[] dO;
   public int[][] dP;
   public long[] dQ;
   public long[][] dR;
   public long[][] dS;
   public long[][] dT;
   public long[][] dU;
   public boolean[] dV;
   public byte[] dW;
   public byte[] dX;
   public byte[] dY;
   public byte[] dZ;
   public byte[] ea;
   public byte[] eb;
   public byte[] ec;
   public byte[] ed;
   public byte[] ee;
   public byte[] ef;
   public byte[] eg;
   public byte[] eh;
   public byte[] ei;
   public byte[] ej;
   public byte[] ek;
   public byte[] el;
   public byte[] em;
   public byte[] en;
   public byte[] eo;
   public byte[] ep;
   public byte[] eq;
   public byte[] er;
   public byte[] es;
   public byte[] et;
   public byte[] eu;
   public byte[] ev;
   public byte[] ew;
   public byte[] ex;
   public byte[] ey;
   public byte[] ez;
   public byte[] eA;
   public int[][] eB;
   public int[][] eC;
   public byte[] eD;
   public byte[] eE;
   public byte[] eF;
   public byte[] eG;
   public int[] eH;
   public int[] eI;
   public int[] eJ;
   public int[] eK;
   public int[] eL;
   public int[] eM;
   public int[] eN;
   public boolean eO;
   public int eP;
   public int eQ;
   public int eR;
   public long eT;
   public long eU;
   public long eV;
   public long eW;
   public long eX;
   public int eY;
   public int eZ;
   public int[] fa;
   public short[][] fb;
   public short[][] fc;
   public short[] fd;
   public short[] fe;
   byte[] a;
   public boolean[] ff;
   public Random fg;
   public long fh;
   public long fi;
   public long fj;
   public long fk;
   public long fl;
   public long fm;
   public long fn;
   public int fo;
   public int fp;
   public boolean fq;
   public boolean fr;
   public boolean fs;
   public boolean ft;
   public boolean fu;
   public boolean fv;
   public boolean fw;
   public boolean fx;
   public boolean fy;
   public boolean fz;
   public int[] fA;
   public int[] fB;
   public int fC;
   public int fD = 40;
   public int fE;
   public int fF;
   public int fG;
   public int fH;
   public int fI;
   public int fJ;
   public int fK;
   public int fL;
   public int fM;
   public int fN;
   public int fO;
   public int fP;
   public int fQ;
   public short fR;
   public boolean fS;
   public boolean fT;
   public boolean fU;
   public boolean fV;
   public boolean fW;
   public boolean fX = false;
   public boolean fY;
   public boolean fZ;
   public boolean ga = true;
   public boolean gb = true;
   public boolean gc;
   public int[] gd;
   public int[] ge;
   public int[] gf;
   public int[] gg;
   public int[] gh;
   public int[][] gi;
   public int[][] gj;
   public Timer gk;
   public long gl;
   public long gm;
   public long gn;
   public long go;
   public long gp;
   public long gq;
   public long gr;
   public int gs;
   public int gt;
   public int gu;
   public long gv;
   public long gw;
   public int[] gx;
   public int[] gy;
   public int gz;
   public int gA;
   public int gB;
   public int gC;
   public int gD;
   public int gE;
   public int gF = 100;
   public int gG;
   public int gH;
   public int gI;
   public int gJ;
   public int gK;
   public int gL;
   public int gM;
   public int gN;
   public int gO;
   public int gP;
   public int gQ;
   public int gR;
   public int gS;
   public int gT;
   public int gU;
   public int gV;
   public int gW;
   public int gX;
   public int gY;
   public int gZ;
   public int ha;
   public int hb = 100;
   public int selectedMap;
   public short hd;
   public short he;
   public short hf;
   public short hg;
   public int hh;
   public int hi;
   public byte hj;
   public byte hk;
   public byte hl;
   public byte hm;
   public byte hn;
   public byte ho;
   public byte hp;
   public byte hq;
   public boolean hr;
   public boolean hs;
   public boolean ht;
   public boolean hu;
   public boolean hv;
   public boolean hw;
   public boolean hx;
   public boolean hy;
   public boolean hz;
   public boolean hA;
   public boolean hB;
   public boolean hC;
   public boolean hD;
   public boolean hE;
   public long[] hF;
   public int[][] hG;
   public int[] hH;
   public int[] hI;
   public int[] hJ;
   public int[] hK;
   public short[] hL;
   public short[] hM;
   public short[][] hN;
   public byte[] hO;
   public byte[][] hP;
   public byte[][] hQ;
   public int hR;
   public int hS = 35;
   public boolean hT;
   public boolean[] hU;
   public byte[] hV = new byte[3];
   public long[] hW = new long[3];
   public int hX;
   public int hY;
   public int hZ;
   public int ia;
   public int ib;
   public int ic;
   public int id;
   public int ie;
   public int if_ = 180;
   public int ig = -1;
   public boolean ih;
   public boolean ii;
   public boolean ij;
   public boolean ik;
   public boolean il;
   public boolean im;
   public boolean in;
   public boolean io = false;
   public long ip;
   public long iq;
   public long ir;
   public long is;
   public long it;
   public long iu;
   public long iv;
   public long iw;
   public long ix = 10000L;
   public long iy;
   public long iz;
   public long iA;
   public long iB;
   public long iC;
   public long iD;
   public long iE;
   public long iF;
   public long iG;
   public long iH;
   public long iI;
   public long[] iJ;
   public byte iK = 0;
   public byte iL;
   public byte iM = 0;
   public long iN;
   public long iO;
   public int iP;
   public int iQ;
   public int iR;
   public int iS;
   public int iT;
   public int iU;
   public int iV;
   public int iW;
   public int iX;
   public int iY;
   public int iZ;
   public int ja;
   public int jb;
   public int jc;
   public int jd;
   public int je;
   public int jf;
   public boolean jg;
   public boolean jh;
   public boolean ji;
   public boolean jj;
   public boolean jk;
   public boolean jl;
   public boolean jm;
   public int[][] jn;
   public int[][] jo;
   public int[] jp;
   public int[] jq;
   public int[] jr;
   public int[] js;
   public int[] jt;
   public int[] ju;
   public int[] jv;
   public short[] jw;
   public byte[] jx;
   public String[] jy = new String[]{"000", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "o", "gameover", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
   public InputStream jB;
   public int[] jC;
   public int jD;
   public int jE;
   public boolean jF;
   public int[] jH;
   public int[] jI;
   public int[] jJ;
   public int[][] jK;
   public int jL;

   public BufferedImage B;
   public BufferedImage C;






   public void readMetadata() {
      int var2 = 0;
      byte[] var4 = this.readBinary("/a" + this.dataExt);
      short[] var5 = new short[12];

      for(int var1 = 0; var1 < 12; ++var1) {
         var5[var1] = readShort(var4, var2);
         var2 += 2;
      }

      short var3 = var5[0];
      this.e = new short[var3];

      for(int var6 = 0; var6 < var3; ++var6) {
         this.e[var6] = readShort(var4, var2);
         var2 += 2;
      }

      var3 = var5[1];
      this.f = new short[var3];

      for(int var7 = 0; var7 < var3; ++var7) {
         this.f[var7] = readShort(var4, var2);
         var2 += 2;
      }

      var3 = var5[2];
      this.h = new byte[var3];

      for(int var8 = 0; var8 < var3; ++var8) {
         this.h[var8] = var4[var2];
         ++var2;
      }

      var3 = var5[3];
      this.i = new byte[var3];

      for(int var9 = 0; var9 < var3; ++var9) {
         this.i[var9] = var4[var2];
         ++var2;
      }

      var3 = var5[4];
      this.j = new byte[var3];

      for(int var10 = 0; var10 < var3; ++var10) {
         this.j[var10] = var4[var2];
         ++var2;
      }

      var3 = var5[5];
      this.k = new byte[var3];

      for(int var11 = 0; var11 < var3; ++var11) {
         this.k[var11] = (byte)(readShort(var4, var2) - 128);
         var2 += 2;
      }

      var3 = var5[6];
      this.g = new short[var3];

      for(int var12 = 0; var12 < var3; ++var12) {
         this.g[var12] = (short)(var4[var2] * 2);
         ++var2;
      }

      var3 = var5[7];
      this.l = new byte[var3];

      for(int var13 = 0; var13 < var3; ++var13) {
         this.l[var13] = var4[var2];
         ++var2;
      }

      var3 = var5[8];
      this.m = new byte[var3];

      for(int var14 = 0; var14 < var3; ++var14) {
         this.m[var14] = var4[var2];
         ++var2;
      }

      var3 = var5[9];
      this.n = new byte[var3];

      for(int var15 = 0; var15 < var3; ++var15) {
         this.n[var15] = var4[var2];
         ++var2;
      }

      var3 = var5[10];
      this.o = new byte[var3];

      for(int var16 = 0; var16 < var3; ++var16) {
         this.o[var16] = var4[var2];
         ++var2;
      }

      var3 = var5[11];
      this.a = new byte[var3];

      for(int var17 = 0; var17 < var3; ++var17) {
         this.a[var17] = var4[var2];
         ++var2;
      }

   }


   public void initCosTable() {
      this.fa = new int[91];
      this.fa[1] = 1146;
      int var1 = 1146;

      for(int var2 = 2; var2 <= 90; ++var2) {
         var1 += this.a[var2 - 2];
         this.fa[var2] = this.fa[var2 - 1] + var1;
      }

      this.a = null;
   }

   public long cos(int var1) {
      if (var1 < 0) {
         return -this.cos(-var1);
      } else if (var1 >= 90 & var1 < 180) {
         return (long)this.fa[180 - var1];
      } else if (var1 >= 180 & var1 < 270) {
         return (long)(-this.fa[var1 - 180]);
      } else if (var1 >= 270 & var1 < 360) {
         return (long)(-this.fa[90 - (var1 - 270)]);
      } else {
         return var1 >= 360 ? this.cos(var1 % 360) : (long)this.fa[var1];
      }
   }

   public long sin(int var1) {
      return this.cos(90 - var1);
   }

   public static int abs(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   public static long abs(long var0) {
      return var0 > 0L ? var0 : -var0;
   }

   public int randomInt() {
      return this.fg.nextInt();
   }


   public void loadMap() {
      int var3 = 0;
      int var5 = this.selectedMap == 0 ? 1 : this.selectedMap;
      ResourcesLoaderC3D var10000;
      StringBuffer var10001;
      String var10002;
      if (!this.ji) {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = this.mapFiles[var5 - 1];
      } else {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = "/o";
      }

      byte[] var6;
      short var7 = readShort((byte[])(var6 = var10000.readBinary(var10001.append(var10002).append(this.dataExt).toString())), (int)0);
      short var8 = readShort((byte[])var6, (int)2);
      short var9 = readShort((byte[])var6, (int)4);
      this.loadedMap = new int[6][];
      int var4 = var7 * 4;
      this.loadedMap[0] = new int[var4];
      var3 = 6;

      for(int var2 = 0; var2 < var4; var2 += 4) {
         this.loadedMap[0][var2] = (byte)((var6[var3 + 1] & 240) >> 4);
         this.loadedMap[0][var2 + 1] = (byte)(var6[var3 + 1] & 15);
         this.loadedMap[0][var2 + 2] = (byte)((var6[var3] & 240) >> 4);
         this.loadedMap[0][var2 + 3] = (byte)(var6[var3] & 15);
         var3 += 2;
      }

      this.loadedMap[1] = new int[this.q[0]];
      this.d = new short[5];
      var4 = this.q[0];

      for(int var11 = 0; var11 < var4; ++var11) {
         short var1 = readShort(var6, var3);
         this.d[var11] = var1;
         int[] var22;
         int var24;
         int var26;
         if (var1 >= 128) {
            var22 = this.loadedMap[1];
            var24 = var11;
            var26 = 127 - var1;
         } else {
            var22 = this.loadedMap[1];
            var24 = var11;
            var26 = var1;
         }

         var22[var24] = (byte)var26;
         var3 += 2;
      }

      this.loadedMap[2] = new int[var8];

      for(int var12 = 0; var12 < var8; ++var12) {
         this.loadedMap[2][var12] = var6[var3];
         ++var3;
      }

      var4 = this.q[1];
      this.loadedMap[3] = new int[var4];

      for(int var13 = 0; var13 < var4; ++var13) {
         int[] var23;
         int var25;
         int var27;
         if (var13 != 41 && var13 != 42 && var13 != 60 && var13 != 61 && var13 != 62) {
            var23 = this.loadedMap[3];
            var25 = var13;
            var27 = var6[var3];
         } else {
            var23 = this.loadedMap[3];
            var25 = var13;
            var27 = 128 + var6[var3];
         }

         var23[var25] = var27;
         ++var3;
      }

      this.loadedMap[4] = new int[var9];

      for(int var14 = 0; var14 < var9; ++var14) {
         this.loadedMap[4][var14] = var6[var3];
         ++var3;
      }

      var4 = this.q[2];
      this.loadedMap[5] = new int[var4];

      for(int var15 = 0; var15 < var4; ++var15) {
         this.loadedMap[5][var15] = var6[var3];
         ++var3;
      }

      short[] footer = new short[var4 = this.q[3]];

      for(int var16 = 0; var16 < var4; ++var16) {
         footer[var16] = readShort(var6, var3);
         var3 += 2;
      }

      this.loadMapInner(footer);
      this.k = null;
      this.D = (byte[][][][])null;
      this.L = null;
      System.gc();
   }

   public void loadMapInner(short[] footer) {
      this.FOOTER = footer;
      this.D = new byte[3][][][];
      this.loadMapPart(this.loadedMap[0], this.loadedMap[1], this.i, 0);
      this.loadMapPart(this.loadedMap[2], this.loadedMap[3], this.j, 1);
      this.modifyBigLumps01(this.D[0], this.D[1]);
      this.modifyBigLump1(this.D[1]);
      this.loadMapPart(this.loadedMap[4], this.loadedMap[5], this.h, 2);
      this.loadSpritesPart1(this.D[2]);
      this.loadSpritesPart2(this.D[2]);
      this.loadSpritesPart3(this.D[2]);
      this.loadedMap = (int[][])null;
      this.D[2] = (byte[][][])null;
      // this.c(false);
      // System.gc();
      this.initFloorCeilingColor(footer);
      this.loadTextures(this.D[0], this.D[1], footer);
      this.gC = 12;
      this.gD = 20;
      if (this.selectedMap == 11) {
         this.gC = 6;
         this.gD = 5;
      }

      if (this.selectedMap == 12) {
         this.fH = 2;
         this.fG = 300;
         this.fF = 0;
         this.iK = 1;
      }

      this.fW = false;
      ResourcesLoaderC3D var10000;
      byte var10001;
      if (this.selectedMap != 11 && this.selectedMap != 12) {
         var10000 = this;
         var10001 = 1;
      } else {
         var10000 = this;
         var10001 = 0;
      }

      var10000.ib = var10001;
      this.v = 5;
      this.w = 0;
      if (this.selectedMap != 11 && this.selectedMap != 12) {
         var10000 = this;
         var10001 = 0;
      } else {
         var10000 = this;
         var10001 = 1;
      }

      var10000.y = var10001;
      this.x = 0;
      if (this.selectedMap >= this.hb) {
         this.fU = true;
      }

   }

   public void loadMapPart(int[] var1, int[] var2, byte[] var3, int var4) {
      int var8 = 0;
      int var10 = var2.length;
      this.D[var4] = new byte[var10][][];

      for(int var5 = 0; var5 < var10; ++var5) {
         int var9 = var2[var5] < 0 ? 127 - var2[var5] : var2[var5];
         this.D[var4][var5] = new byte[var9][var3[var5]];

         for(int var6 = 0; var6 < var9; ++var6) {
            byte var11 = var3[var5];

            for(int var7 = 0; var7 < var11; ++var7) {
               this.D[var4][var5][var6][var7] = (byte)var1[var8];
               ++var8;
            }
         }
      }

   }

   public void modifyBigLumps01(byte[][][] var1, byte[][][] var2) {
      boolean var3 = false;
      int var11 = 0;
      int var12 = 0;
      int var17 = var1[0].length + var2[7].length + var2[12].length * 4 + var2[20].length * 3 + var2[33].length * 4 + var2[41].length * 4;
      int var7 = var2[51].length + 1;
      this.bB = new int[var7];
      this.bB[0] = var17 - var2[33].length * 4;

      int var4;
      for(var4 = 1; var4 < var7; ++var4) {
         this.bB[var4] = this.bB[var4 - 1] + var2[51][var4 - 1][2];
      }

      var17 = this.bB[var4 - 1] + var2[33].length * 4;
      this.initMapArrays(var17);
      this.bS = new byte[var17];
      var7 = var2[31].length;

      for(int var19 = 0; var19 < var7; ++var19) {
         this.bS[var2[31][var19][0] + 128] = var2[31][var19][1];
      }

      var7 = var1[0].length;
      int var8 = var2[7].length;

      for(int var20 = 0; var20 < var7; ++var20) {
         if (var11 < var8 && var12 == var2[7][var11][0] + 128) {
            if (var11 != 0) {
               this.dP[2][var12 - 1] = var2[7][var11 - 1][1];
               this.dP[3][var12 - 1] = var2[7][var11 - 1][2];
            }

            this.dP[0][var12] = var2[7][var11][1];
            this.dP[1][var12] = var2[7][var11][2];
            ++var11;
            ++var12;
         }

         long var13 = (long)(var1[0][var20][0] - 7);
         long var15 = (long)(var1[0][var20][1] - 7);
         this.dP[0][var12] = (int)(var13 + (long)this.dP[0][var12 - 1]);
         this.dP[1][var12] = (int)(var15 + (long)this.dP[1][var12 - 1]);
         this.dP[2][var12 - 1] = this.dP[0][var12];
         this.dP[3][var12 - 1] = this.dP[1][var12];
         ++var12;
      }

      this.dP[2][var12 - 1] = var2[7][var11 - 1][1];
      this.dP[3][var12 - 1] = var2[7][var11 - 1][2];

      for(int var18 = 0; var18 < var12; ++var18) {
         for(int var21 = 0; var21 < 4; ++var21) {
            int[] var10000 = this.dP[var21];
            var10000[var18] <<= 16;
         }
      }

      this.gP = var12;
      var12 = 0;
      var11 = 0;
      this.dW = new byte[var17];
      var7 = var1[1].length;
      int var9 = var2[7].length;
      int var10 = var2[10].length;

      for(int var22 = 0; var22 < var7; ++var22) {
         var8 = var1[1][var22].length;

         for(int var5 = 0; var5 < var8; ++var5) {
            if (var11 < var9 && var12 == var2[7][var11][0] + 128) {
               if (var11 != 0) {
                  this.dW[var12 - 1] = var2[7][var11 - 1][4];
               }

               this.dW[var12] = var2[7][var11][3];
               ++var11;
               ++var12;
            }

            byte[] var48;
            int var10001;
            byte[] var10002;
            int var10003;
            if (var1[1][var22][var5] == 15) {
               for(int var6 = 0; var6 < var10; ++var6) {
                  if (var2[10][var6][0] + 128 == var12) {
                     var48 = this.dW;
                     var10001 = var12;
                     var10002 = var2[10][var6];
                     var10003 = 1;
                     break;
                  }
               }
               continue;
            } else {
               var48 = this.dW;
               var10001 = var12;
               var10002 = var1[1][var22];
               var10003 = var5;
            }

            var48[var10001] = var10002[var10003];
            ++var12;
         }
      }

      this.dW[var12 - 1 - var2[8][0][4]] = var2[7][var11 - 1][4];
      var7 = var1[2].length;
      var8 = var2[29].length;

      for(int var23 = 0; var23 < var7; ++var23) {
         for(int var28 = 0; var28 < 5; ++var28) {
            if (var1[2][var23][var28] != 15) {
               if (var1[2][var23][var28] == 7) {
                  var1[2][var23][var28] = -7;
               } else if (var1[2][var23][var28] != 0) {
                  var1[2][var23][var28] = (byte)(var1[2][var23][var28] - 7);
               }
            } else {
               for(int var33 = 0; var33 < var8; ++var33) {
                  if (var2[29][var33][0] == var23 && var2[29][var33][1] == var28) {
                     var1[2][var23][var28] = var2[29][var33][2];
                     break;
                  }
               }
            }
         }
      }

      if (this.selectedMap != 8 && this.selectedMap != 9 && this.selectedMap != 10 && this.selectedMap != 11 && this.selectedMap != 12 && this.selectedMap != 13) {
         for(int var25 = 0; var25 < var7; ++var25) {
            var8 = var1[2][var25].length;

            for(int var30 = 6; var30 < var8; ++var30) {
               var1[2][var25][var30] = (byte)(var1[2][var25][var30] * 3);
            }
         }
      } else {
         for(int var24 = 0; var24 < var7; ++var24) {
            var8 = var1[2][var24].length;

            for(int var29 = 6; var29 < var8; ++var29) {
               byte[] var49;
               int var50;
               byte var51;
               byte var52;
               if ((var24 != 23 || this.selectedMap != 9) && (var24 != 9 || this.selectedMap != 12)) {
                  var49 = var1[2][var24];
                  var50 = var29;
                  var51 = var49[var29];
                  var52 = 6;
               } else {
                  var49 = var1[2][var24];
                  var50 = var29;
                  var51 = var49[var29];
                  var52 = 3;
               }

               var49[var50] = (byte)(var51 * var52);
            }
         }
      }

      var7 = var1[3].length;

      for(int var26 = 0; var26 < var7; ++var26) {
         for(int var31 = 1; var31 <= 2; ++var31) {
            var1[3][var26][var31] = (byte)(var1[3][var26][var31] * 3);
         }
      }

      var7 = var1[4].length;

      for(int var27 = 0; var27 < var7; ++var27) {
         var8 = var1[4][var27].length;

         for(int var32 = 0; var32 < var8; ++var32) {
            var1[4][var27][var32] = (byte)(var1[4][var27][var32] * 3);
         }
      }

   }





   public void initMapArrays(int var1) {
      this.dP = new int[4][var1];
      this.bR = new byte[var1];
   }



   public void modifyBigLump1(byte[][][] bigLump1) {
      this.dn = new short[7][];
      this.do_ = new short[7][];
      this.gS = this.gP;
      this.gT = this.gS + 4 * bigLump1[12].length;
      this.gU = this.gT + 3 * bigLump1[20].length;

      for(int var2 = 0; var2 < 7; ++var2) {
         int var12 = bigLump1[var2].length + bigLump1[var2 + 13].length + bigLump1[var2 + 21].length + bigLump1[var2 + 42].length + bigLump1[var2 + 52].length;
         this.dn[var2] = new short[var12];
         this.do_[var2] = new short[var12];
         int var10 = bigLump1[var2].length;

         int var3;
         for(var3 = 0; var3 < var10; ++var3) {
            this.dn[var2][var3] = (short)(bigLump1[var2][var3][0] + 128);
            this.do_[var2][var3] = (short)(bigLump1[var2][var3][1] + 128);
         }

         var10 = bigLump1[var2 + 13].length + var3;

         int var6;
         for(var6 = var3; var6 < var10; ++var6) {
            byte var13 = bigLump1[var2 + 13][var6 - var3][0];
            this.dn[var2][var6] = (short)(this.gS + var13 * 4);
            this.do_[var2][var6] = (short)(this.dn[var2][var6] + 3);
            int var14;
            short[] var10000;
            int var10001;
            int var10002;
            if (abs(var14 = bigLump1[12][var13][3] % 90) <= 3) {
               var10000 = this.do_[var2];
               var10001 = var6;
               var10002 = var10000[var6] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.dn[var2];
               var10001 = var6;
               var10002 = var10000[var6] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[12][var13][3] = (byte)(bigLump1[12][var13][3] - var14);
         }

         var10 = bigLump1[var2 + 21].length + var6;

         int var7;
         for(var7 = var6; var7 < var10; ++var7) {
            this.dn[var2][var7] = (short)(this.gT + abs(bigLump1[var2 + 21][var7 - var6][0]) % 60 * 3);
            this.do_[var2][var7] = (short)(this.dn[var2][var7] + 2);
            short[] var64;
            int var72;
            int var79;
            if (bigLump1[var2 + 21][var7 - var6][0] < 0) {
               var64 = this.dn[var2];
               var72 = var7;
               var79 = var64[var7] + 2;
            } else {
               if (bigLump1[var2 + 21][var7 - var6][0] < 60) {
                  continue;
               }

               var64 = this.do_[var2];
               var72 = var7;
               var79 = var64[var7] - 2;
            }

            var64[var72] = (short)var79;
         }

         var10 = bigLump1[var2 + 42].length + var7;

         int var8;
         for(var8 = var7; var8 < var10; ++var8) {
            int var53 = 128 + bigLump1[var2 + 42][var8 - var7][0];
            this.dn[var2][var8] = (short)(this.gU + var53 * 4);
            this.do_[var2][var8] = (short)(this.dn[var2][var8] + 3);
            int var55;
            short[] var65;
            int var73;
            int var80;
            if (abs(var55 = bigLump1[41][var53][2] % 90) <= 3) {
               var65 = this.do_[var2];
               var73 = var8;
               var80 = var65[var8] - abs(var55);
            } else {
               if (abs(var55) > 6) {
                  continue;
               }

               var65 = this.dn[var2];
               var73 = var8;
               var80 = var65[var8] + (abs(var55) - 3);
            }

            var65[var73] = (short)var80;
            bigLump1[41][var53][2] = (byte)(bigLump1[41][var53][2] - var55);
         }

         var10 = bigLump1[var2 + 52].length + var8;

         for(int var9 = var8; var9 < var10; ++var9) {
            this.dn[var2][var9] = (short)this.bB[bigLump1[var2 + 52][var9 - var8][0]];
            this.do_[var2][var9] = (short)(this.bB[bigLump1[var2 + 52][var9 - var8][0] + 1] - 1);
         }
      }

      ResourcesLoaderC3D var66;
      byte var74;
      long var81;
      long var10003;
      if (this.selectedMap != 3 && this.selectedMap != 8 && this.selectedMap != 12) {
         var66 = this;
         var74 = bigLump1[8][0][0];
         var81 = (long)bigLump1[8][0][1] * 75000L;
         var10003 = (long)bigLump1[8][0][2] * 75000L;
      } else {
         var66 = this;
         var74 = bigLump1[8][0][0];
         var81 = (long)bigLump1[8][0][1] * 75000L + 32768L;
         var10003 = (long)bigLump1[8][0][2] * 75000L + 32768L;
      }

      var66.initStartingPos(var74, var81, var10003, bigLump1[8][0][3] * 2, bigLump1[8][0][7]);
      this.dm = (byte)(16 + bigLump1[8][0][5]);
      this.dl = bigLump1[8][0][6];
      int var50 = this.gP;
      this.gQ = bigLump1[12].length;
      int var54 = 188 + this.gQ;
      this.cO = new byte[var54];
      this.cx = new int[var54][2];
      this.cW = new boolean[var54];
      this.cJ = new byte[var54];
      this.cK = new byte[var54];
      this.cP = new byte[var54];
      this.cL = new byte[var54];
      int var41 = bigLump1[12].length;

      for(int var26 = 0; var26 < var41; ++var26) {
         int var56 = 128 + bigLump1[12][var26][0] << 16 >> 2;
         int var15 = 128 + bigLump1[12][var26][1] << 16 >> 2;
         int var35 = 188 + var26;
         this.cx[var35][0] = var56;
         this.cx[var35][1] = var15;
         this.cO[var35] = (byte)(this.dm - 1);
         this.cW[var35] = false;
         this.cJ[var35] = (byte)(this.dm + 2 + bigLump1[12][var26][4]);
         byte[] var67;
         byte var82;
         if (this.selectedMap != 12) {
            var67 = this.cK;
            var74 = (byte)var35; // added (byte)
            var82 = (byte)(abs(this.randomInt()) % 3);
         } else {
            var67 = this.cK;
            var74 = (byte)var35; // added (byte)
            var82 = 2;
         }

         var67[var74] = var82;
         if (bigLump1[12][var26][4] > 4) {
            var67 = this.cJ;
            var67[var35] = (byte)(var67[var35] - 4);
            this.cP[var35] = 1;
         }
         CRATES_START_LINE_IDX.add(var50);
         CRATES_CONTENT.add(bigLump1[12][var26][4]);
         CRATES_ANGLE.add(bigLump1[12][var26][3]);
         var50 = this.modifyBigLump1_subfunction1((long)var56, (long)var15, 16384L, 16384L, bigLump1[12][var26][3], var50, bigLump1[12][var26][2], bigLump1[12][var26][2], bigLump1[12][var26][2], bigLump1[12][var26][2], (byte)1, (byte)0);
      }

      this.gR = bigLump1[20].length;
      this.eB = new int[this.gR][2];
      this.eD = new byte[this.gR];
      this.eE = new byte[this.gR];
      this.eH = new int[this.gR];
      this.eI = new int[this.gR];
      this.eF = new byte[this.gR];
      this.eJ = new int[this.gR];
      this.eK = new int[this.gR];
      this.eL = new int[this.gR];
      this.eM = new int[this.gR];
      this.eC = new int[this.gR][2];
      this.eN = new int[this.gR];
      this.eG = new byte[this.gR];
      var41 = bigLump1[20].length;

      for(int var27 = 0; var27 < var41; ++var27) {
         this.eB[var27][0] = 128 + bigLump1[20][var27][0] << 16 >> 2;
         this.eB[var27][1] = 128 + bigLump1[20][var27][1] << 16 >> 2;
         byte[] var69;
         byte var83;
         if (bigLump1[20][var27][2] * bigLump1[20][var27][3] >= 0) {
            this.eD[var27] = 0;
            var69 = this.eE;
            var74 = (byte)var27;
            var83 = 1;
         } else {
            this.eD[var27] = 1;
            var69 = this.eE;
            var74 = (byte)var27;
            var83 = 0;
         }

         var69[var74] = (byte)var83;
         this.eH[var27] = (bigLump1[20][var27][2] << 16) / 127;
         this.eI[var27] = (bigLump1[20][var27][3] << 16) / 127;
         this.eP = this.eI[var27];
         this.eF[var27] = bigLump1[59][var27][3];
         this.eL[var27] = 0;
         this.eM[var27] = 6225920;
         int[] var70;
         if (this.eI[var27] > 0) {
            var70 = this.eJ;
            var74 = (byte)var27; // unsure
            var83 = (byte)65536;
         } else {
            var70 = this.eJ;
            var74 = (byte)var27;
            var83 = (byte)-65536;
         }

         var70[var74] = var83;
         this.eQ = this.eJ[var27];
         this.eK[var27] = (this.eJ[var27] - this.eI[var27]) / this.eF[var27];
         this.eR = this.eJ[var27] - this.eI[var27];
         this.eC[var27][this.eD[var27]] = this.eB[var27][this.eD[var27]] + this.eJ[var27];
         this.eC[var27][this.eE[var27]] = this.eB[var27][this.eE[var27]];
         this.eN[var27] = -1;
         this.eG[var27] = bigLump1[28][var27][0];
         DOORS_START_LINE_IDX.add(var50);
         this.modifyBigLump1_subfunction2(bigLump1[59][var27][0], bigLump1[59][var27][1], bigLump1[59][var27][2], var50);
         this.modifyBigLump1_subfunction3(this.eB[var27], (long)this.eH[var27], (long)this.eJ[var27], this.eD[var27], this.eE[var27], var50, 0);
         var50 = this.modifyBigLump1_subfunction3(this.eB[var27], (long)this.eH[var27], (long)this.eI[var27], this.eD[var27], this.eE[var27], var50, 1);
      }

      this.gP = var50;
      this.bT = new byte[bigLump1[30].length * 7];
      this.bL = new short[32 + bigLump1[30].length];
      int var5 = 0;
      var41 = bigLump1[30].length;

      for(int var28 = 0; var28 < var41; ++var28) {
         this.bL[32 + var28] = 96;
         int var11 = bigLump1[30][var28].length;

         for(int var4 = 0; var4 < var11; ++var4) {
            this.bT[var5] = bigLump1[30][var28][var4];
            ++var5;
         }
      }

      var50 = this.gP;
      var41 = bigLump1[41].length;

      for(int var29 = 0; var29 < var41; ++var29) {
         long var57 = (long)(128 + bigLump1[41][var29][0] << 16 >> 2);
         long var16 = (long)(128 + bigLump1[41][var29][1] << 16 >> 2);
         long var18 = (long)((bigLump1[60][var29][0] << 16) / 42 >> 1);
         long var20 = (long)((bigLump1[60][var29][1] << 16) / 42 >> 1);
         var50 = this.modifyBigLump1_subfunction1(var57, var16, var18, var20, bigLump1[41][var29][2], var50, bigLump1[61][var29][0], bigLump1[61][var29][1], bigLump1[61][var29][2], bigLump1[61][var29][3], bigLump1[62][var29][0], bigLump1[62][var29][1]);
      }

      this.gP = var50;
      if (this.selectedMap == 6) {
         this.bS[621] = 10;
      }

      this.hP = new byte[16][];
      this.hQ = new byte[16][];
      this.hN = new short[16][];
      this.hM = new short[15];
      this.hK = new int[16];
      this.modifyBigLump1_subfunction4(0, 49, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(1, 70, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(2, 72, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(3, 74, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(4, 76, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(5, 78, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(6, 80, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(7, 82, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(8, 84, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(9, 86, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(10, 88, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(11, 90, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(12, 92, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(13, 94, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(14, 96, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(15, 98, (byte[][][])bigLump1);
      if (this.selectedMap == 4) {
         this.modifyBigLump1_subfunction6();
         var66 = this;
         var74 = 0;
      } else {
         var66 = this;
         var74 = 1;
      }

      var66.hx = var74 != 0; // (boolean)var74
      this.hZ = 0;
      var50 = this.gP;
      this.gV = var50;
      var41 = bigLump1[51].length;
      this.bA = new int[var41];

      for(int var30 = 0; var30 < var41; ++var30) {
         long var58 = (long)(128 + bigLump1[51][var30][0] << 16 >> 2);
         long var60 = (long)(128 + bigLump1[51][var30][1] << 16 >> 2);
         long var22 = (long)((bigLump1[51][var30][3] << 16) / 60);
         this.bA[var30] = bigLump1[51][var30][6];
         // circles
         var50 = this.modifyBigLump1_subfunction5(var58, var60, bigLump1[51][var30][2], var22, var50, bigLump1[51][var30][4], bigLump1[51][var30][5], bigLump1[51][var30][7], bigLump1[51][var30][8]);
      }

      this.gP = var50;
      this.gW = var50;
      var41 = bigLump1[33].length;
      this.dR = new long[2][var41];
      this.dT = new long[4][var41];
      this.dS = new long[2][var41];
      this.dN = new int[var41];
      this.dO = new int[var41];
      this.dQ = new long[var41];
      this.dX = new byte[var41];
      this.dU = new long[2][var41];
      this.dV = new boolean[var41];

      for(int var31 = 0; var31 < var41; ++var31) {
         long var59 = (long)(128 + bigLump1[33][var31][0] << 16 >> 2);
         long var61 = (long)(128 + bigLump1[33][var31][1] << 16 >> 2);
         this.dR[0][var31] = var59;
         this.dR[1][var31] = var61;
         this.dN[var31] = bigLump1[33][var31][4];
         this.dV[var31] = false;
         this.dX[var31] = bigLump1[33][var31][9];
         this.dO[var31] = 0;
         long var62 = (long)((bigLump1[33][var31][2] << 16) / 42 >> 1);
         long var63 = (long)((bigLump1[33][var31][3] << 16) / 42 >> 1);
         this.dU[0][var31] = var62;
         this.dU[1][var31] = var63;
         var50 = this.modifyBigLump1_subfunction7(var59, var61, var62, var63, 0, var50, bigLump1[33][var31][5], bigLump1[33][var31][6], bigLump1[33][var31][7], bigLump1[33][var31][8], var31, bigLump1[33][var31][10], this.dX[var31]);
      }

      this.gP = var50;
      this.cQ = new byte[7][];

      for(int var24 = 34; var24 < 41; ++var24) {
         var41 = bigLump1[var24].length;
         this.cQ[var24 - 34] = new byte[var41];

         for(int var32 = 0; var32 < var41; ++var32) {
            this.cQ[var24 - 34][var32] = bigLump1[var24][var32][0];
         }
      }

      this.cR = new short[7][];

      for(int var25 = 63; var25 < 70; ++var25) {
         var41 = bigLump1[var25].length;
         int var49 = bigLump1[var25 - 50].length;
         this.cR[var25 - 63] = new short[var41 + var49];

         int var33;
         for(var33 = 0; var33 < var41; ++var33) {
            this.cR[var25 - 63][var33] = (short)(128 + bigLump1[var25][var33][0]);
         }

         int var36 = var33;

         for(int var34 = 0; var34 < var49; ++var34) {
            this.cR[var25 - 63][var36] = (short)(188 + bigLump1[var25 - 50][var34][0]);
            ++var36;
         }
      }

   }

   public void modifyBigLump1_subfunction4(int var1, int var2, byte[][][] var3) {
      int var4 = var2;
      if (var3[var2].length != 0) {
         int var7 = var3[var2][0].length;
         this.hP[var1] = new byte[var7];

         for(int var6 = 0; var6 < var7; ++var6) {
            this.hP[var1][var6] = var3[var4][0][var6];
         }

         int[] var10000;
         int var10001;
         byte var10002;
         if (this.hP[var1][1] != this.hP[var1][2]) {
            var10000 = this.hK;
            var10001 = var1;
            var10002 = 2;
         } else {
            var10000 = this.hK;
            var10001 = var1;
            var10002 = 1;
         }

         var10000[var10001] = var10002;
         int var8 = var2 == 94 && this.selectedMap == 3 ? 394 : 128;
         var4 = var2 + 1;
         this.hN[var1] = new short[var3[var4].length];
         this.hQ[var1] = new byte[var3[var4].length];
         var7 = var3[var4].length;

         for(int var5 = 0; var5 < var7; ++var5) {
            this.hN[var1][var5] = (short)(var3[var4][var5][0] + var8);
            this.hQ[var1][var5] = 0;
         }

      }
   }

   public void loadSpritesPart1(byte[][][] var1) {
      int var6 = var1[4].length;
      this.cF = new byte[var6];
      this.cC = new short[var6];
      this.cG = new byte[64];
      this.ge = new int[42];
      this.cD = new short[var6];
      this.cH = new byte[var6];
      this.cS = new boolean[var6];
      this.cI = new byte[var6];
      this.cU = new boolean[188 + this.gQ];
      this.cA = new int[64 + this.gQ];
      this.cM = new byte[var6];
      this.cT = new boolean[var6];
      this.cN = new byte[var6];
      this.cV = new boolean[var6];

      for(int var3 = 0; var3 < var6; ++var3) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (var1[4][var3][2] == -1) {
            var10000 = this.cO;
            var10001 = var3;
            var10002 = 10;
         } else {
            var10000 = this.cO;
            var10001 = var3;
            var10002 = 0;
         }

         var10000[var10001] = var10002;
         this.cx[var3][0] = 128 + var1[4][var3][0] << 16 >> 2;
         this.cx[var3][1] = 128 + var1[4][var3][1] << 16 >> 2;
         if (this.selectedMap != 12 && this.selectedMap != 11) {
            var10000 = this.cF;
            var10001 = var3;
            var10002 = var1[4][var3][2];
         } else {
            var10000 = this.cF;
            var10001 = var3;
            var10002 = (byte)(var1[4][var3][2] >> 1);
         }

         var10000[var10001] = var10002;
         this.cC[var3] = (short)(var1[4][var3][3] * 2);
         this.cG[var3] = var1[4][var3][4];
         this.cV[var3] = true;
         if (this.cG[var3] > 0) {
            this.cO[var3] = this.cG[var3];
            if (this.selectedMap == 2 || this.selectedMap == 3 || this.selectedMap == 11) {
               this.cV[var3] = false;
            }
         }

         this.ge[var3] = -1;
         this.cD[var3] = (short)(var1[4][var3][5] + 128);
         this.cS[var3] = true;
         this.cI[var3] = 1;
         this.cH[var3] = 1;
         this.cU[var3] = false;
         this.cW[var3] = true;
         this.cP[var3] = var1[4][var3][6];
         if (this.selectedMap != 12 && this.selectedMap != 7 && this.selectedMap != 4 && this.selectedMap != 5) {
            var10000 = this.cN;
            var10001 = var3;
            var10002 = (byte)(abs(this.randomInt()) % 8);
         } else if (this.selectedMap != 7 && this.selectedMap != 4 && this.selectedMap != 5) {
            var10000 = this.cN;
            var10001 = var3;
            var10002 = (byte)(abs(this.randomInt()) % 2 * 3 + abs(this.randomInt()) % 2 * 4);
         } else {
            var10000 = this.cN;
            var10001 = var3;
            var10002 = 4;
         }

         var10000[var10001] = var10002;
         this.cT[var3] = false;
         if (this.cG[var3] > 0 && (this.cG[var3] != 30 || this.selectedMap != 4 && this.selectedMap != 5 && this.selectedMap != 6 && this.selectedMap != 7 && this.selectedMap != 11 && this.selectedMap != 12)) {
            var10000 = this.cM;
            var10001 = var3;
            var10002 = 0;
         } else {
            var10000 = this.cM;
            var10001 = var3;
            var10002 = 100;
         }

         var10000[var10001] = var10002;
      }

      this.gH = var1[4].length;
      this.hj = var1[8][0][0];
      this.hk = var1[8][0][1];
      this.hl = var1[8][0][2];
      this.hp = var1[8][0][3];
      this.hm = var1[8][0][4];
      this.gI = var1[7].length;
      int var4 = 42;
      int var5 = var1[7].length;

      for(int var7 = 0; var7 < var5; ++var7) {
         this.cO[var4] = this.hj;
         this.cx[var4][0] = 128 + var1[7][var7][0] << 16 >> 2;
         this.cx[var4][1] = 128 + var1[7][var7][1] << 16 >> 2;
         this.cG[var4] = var1[7][var7][2];
         this.cW[var4] = true;
         this.cP[var4] = var1[7][var7][3];
         ++var4;
      }

      var4 = 64;
      var5 = var1[9].length;
      this.cy = new int[var5][4];
      this.cr = var5;
      this.iJ = new long[var5];

      for(int var2 = 0; var2 < var5; ++var2) {
         this.iJ[var2] = 0L;
      }

      for(int var8 = 0; var8 < var5; ++var8) {
         this.cO[var4] = var1[9][var8][0];
         this.cx[var4][0] = 128 + var1[9][var8][1] << 16 >> 2;
         this.cx[var4][1] = 128 + var1[9][var8][2] << 16 >> 2;
         byte[] var14;
         int var18;
         byte var22;
         if (this.selectedMap != 12) {
            var14 = this.cL;
            var18 = var4;
            var22 = (byte)(abs(this.randomInt()) % 3);
         } else {
            var14 = this.cL;
            var18 = var4;
            var22 = 2;
         }

         var14[var18] = var22;
         this.cy[var8][0] = var4;
         this.cy[var8][1] = 1;
         this.cy[var8][2] = var1[9][var8][3];
         this.cy[var8][3] = var1[9][var8][4] * 25;
         this.cW[var4] = true;
         ++var4;
      }

   }

   public void loadSprites_subfunction1(short[] var1, int var2, int var3) {
      this.bO[var2] = var1[var3 + 2];
      this.bP[var2] = var1[var3 + 3];
      int var4 = this.bP[var2] / var1[var3 + 5];
      this.bJ[var1[var3 + 4]][var2] = this.bJ[var1[var3 + 4]][this.L[var1[var3 + 4]]];
      this.bJ[var1[var3 + 4]][this.L[var1[var3 + 4]] + 1] = (short)(this.bJ[var1[var3 + 4]][this.L[var1[var3 + 4]]] + this.bO[var2] * var4);
      int var10002 = this.L[var1[var3 + 4]]++;
      this.bM[var2] = var1[var3 + 4];
      this.bN[var2] = var1[var3 + 5];
      this.bC[var2] = (var1[var3 + 5] << 16 >> 3) * this.bO[var2] / this.bP[var2];
      int[] var10000 = this.bC;
      var10000[var2] >>= 1;
   }


   public void initStartingPos(int var1, long var2, long var4, int var6, int var7) {
      this.hF = new long[2];
      this.hh = var1;
      this.hF[0] = var2;
      this.hF[1] = var4;
      this.gJ = var6;
      this.gK = var7;
   }

   public void initFloorCeilingColor(short[] var1) {
      this.bg = var1[0] << 16 | var1[1] << 8 | var1[2];
      this.bh = var1[3] << 16 | var1[4] << 8 | var1[5];
      this.bg = (int)((long)this.bg | 0L);
      this.bh = (int)((long)this.bh | 0L);
      this.bj = this.bh;
      int var2 = (this.bh & 16711680) >> 16;
      int var3 = (this.bh & '\uff00') >> 8;
      int var4 = this.bh & 255;
      if (this.selectedMap == 12) {
         this.bi = this.combineLayers_subfunction1(0, 0, 0, 0, 1, var2, var3, var4, false);
      }

   }



   public int modifyBigLump1_subfunction1(long var1, long var3, long var5, long var7, int var9, int var10, byte var11, byte var12, byte var13, byte var14, byte var15, byte var16) {
      int var19 = 0;

      for(int var18 = var10; var18 < var10 + 4; ++var18) {
         this.bR[var18] = var15;
         if (var16 != 6) {
            this.bS[var18] = var16;
         }

         for(int var17 = 0; var17 < 4; var17 += 2) {
            int[] var10000;
            int var10001;
            long var10002;
            if (var9 == 0) {
               this.dP[var17][var18] = (int)((long)this.u[var19][var17] * var7 + var1);
               var10000 = this.dP[var17 + 1];
               var10001 = var18;
               var10002 = (long)this.u[var19][var17 + 1] * var5;
            } else {
               this.dP[var17][var18] = (int)(((long)this.u[var19][var17] * var7 * this.sin(var9) >> 16) - ((long)this.u[var19][var17 + 1] * var5 * this.cos(var9) >> 16) + var1);
               var10000 = this.dP[var17 + 1];
               var10001 = var18;
               var10002 = ((long)this.u[var19][var17] * var7 * this.cos(var9) >> 16) + ((long)this.u[var19][var17 + 1] * var5 * this.sin(var9) >> 16);
            }

            var10000[var10001] = (int)(var10002 + var3);
         }

         ++var19;
      }

      this.dW[var10] = var11;
      int var20 = var10 + 1;
      this.dW[var20] = var12;
      ++var20;
      this.dW[var20] = var13;
      ++var20;
      this.dW[var20] = var14;
      if (var16 == 6) {
         this.bS[var20] = 3;
      }

      return var20 + 1;
   }

   public int modifyBigLump1_subfunction7(long var1, long var3, long var5, long var7, int var9, int var10, byte var11, byte var12, byte var13, byte var14, int var15, byte var16, byte var17) {
      int var20 = 0;

      for(int var19 = var10; var19 < var10 + 4; ++var19) {
         this.bR[var19] = 0;

         for(int var18 = 0; var18 < 4; var18 += 2) {
            int[] var10000;
            int var10001;
            long var10002;
            if (var9 == 0) {
               this.dP[var18][var19] = (int)((long)this.u[var20][var18] * var7 + var1);
               var10000 = this.dP[var18 + 1];
               var10001 = var19;
               var10002 = (long)this.u[var20][var18 + 1] * var5;
            } else {
               this.dP[var18][var19] = (int)(((long)this.u[var20][var18] * var7 * this.sin(var9) >> 16) - ((long)this.u[var20][var18 + 1] * var5 * this.cos(var9) >> 16) + var1);
               var10000 = this.dP[var18 + 1];
               var10001 = var19;
               var10002 = ((long)this.u[var20][var18] * var7 * this.cos(var9) >> 16) + ((long)this.u[var20][var18 + 1] * var5 * this.sin(var9) >> 16);
            }

            var10000[var10001] = (int)(var10002 + var3);
         }

         ++var20;
      }

      if (this.dO[var15] == 0) {
         int var21;
         byte var22;
         label100: {
            byte[] var26;
            int var29;
            byte var32;
            label99: {
               var21 = var17 != 1 && var17 != 4 ? -1 : 1;
               if (this.dN[var15] < 0) {
                  var22 = 0;
                  if (var17 == 1) {
                     this.bS[var10] = 3;
                     this.bS[var10 + 1] = 0;
                     this.bS[var10 + 2] = 0;
                     var26 = this.bS;
                     var29 = var10 + 3;
                     var32 = 0;
                     break label99;
                  }

                  if (var17 == 2) {
                     this.bS[var10] = 0;
                     this.bS[var10 + 1] = 0;
                     this.bS[var10 + 2] = 3;
                     var26 = this.bS;
                     var29 = var10 + 3;
                     var32 = 0;
                     break label99;
                  }

                  if (var17 != 3) {
                     if (var17 != 4) {
                        break label100;
                     }

                     this.bS[var10] = 0;
                     this.bS[var10 + 1] = 3;
                     this.bS[var10 + 2] = 0;
                     var26 = this.bS;
                     var29 = var10 + 3;
                     var32 = 0;
                     break label99;
                  }
               } else {
                  var22 = 2;
                  if (var17 == 1) {
                     this.bS[var10] = 0;
                     this.bS[var10 + 1] = 0;
                     this.bS[var10 + 2] = 3;
                     var26 = this.bS;
                     var29 = var10 + 3;
                     var32 = 0;
                     break label99;
                  }

                  if (var17 == 2) {
                     this.bS[var10] = 3;
                     this.bS[var10 + 1] = 0;
                     this.bS[var10 + 2] = 0;
                     var26 = this.bS;
                     var29 = var10 + 3;
                     var32 = 0;
                     break label99;
                  }

                  if (var17 == 3) {
                     this.bS[var10] = 0;
                     this.bS[var10 + 1] = 3;
                     this.bS[var10 + 2] = 0;
                     var26 = this.bS;
                     var29 = var10 + 3;
                     var32 = 0;
                     break label99;
                  }

                  if (var17 != 4) {
                     break label100;
                  }
               }

               this.bS[var10] = 0;
               this.bS[var10 + 1] = 0;
               this.bS[var10 + 2] = 0;
               var26 = this.bS;
               var29 = var10 + 3;
               var32 = 3;
            }

            var26[var29] = var32;
         }

         long[] var27;
         int var30;
         long var33;
         long var10003;
         ResourcesLoaderC3D var10004;
         byte var10005;
         if (var17 > 2) {
            this.dT[0][var15] = (long)this.dP[var22][var10 + 2 + var21];
            this.dT[1][var15] = (long)this.dP[var22 + 1][var10 + 2 + var21];
            var27 = this.dQ;
            var30 = var15;
            var33 = (long)var21;
            var10003 = (long)(this.dP[0][var10] - this.dP[2][var10] >> 1 << 16);
            var10004 = this;
            var10005 = 80;
         } else {
            this.dT[0][var15] = (long)this.dP[var22][var10 + 1 + var21];
            this.dT[1][var15] = (long)this.dP[var22 + 1][var10 + 1 + var21];
            var27 = this.dQ;
            var30 = var15;
            var33 = (long)var21;
            var10003 = (long)(this.dP[0][var10 + 1 + var21] - this.dP[2][var10 + 1 + var21] >> 1 << 16);
            var10004 = this;
            var10005 = 10;
         }

         var27[var30] = var33 * (var10003 / var10004.sin(var10005));
      }

      label80: {
         long[] var28;
         int var31;
         long var34;
         ResourcesLoaderC3D var35;
         int var37;
         label130: {
            byte var38;
            if (this.dN[var15] > 0 && var17 <= 2) {
               this.dS[0][var15] = (this.dQ[var15] * this.sin(this.dO[var15] - 10) >> 16) + this.dT[0][var15];
               var28 = this.dS[1];
               var31 = var15;
               var34 = this.dQ[var15];
               var35 = this;
               var37 = this.dO[var15];
               var38 = 10;
            } else {
               if (this.dN[var15] < 0 && var17 <= 2) {
                  this.dS[0][var15] = (-this.dQ[var15] * this.sin(this.dO[var15] + 10) >> 16) + this.dT[0][var15];
                  var28 = this.dS[1];
                  var31 = var15;
                  var34 = -this.dQ[var15];
                  var35 = this;
                  var37 = this.dO[var15] + 10;
                  break label130;
               }

               if (this.dN[var15] > 0 && var17 > 2) {
                  this.dS[0][var15] = (-this.dQ[var15] * this.sin(this.dO[var15] + 80) >> 16) + this.dT[0][var15];
                  var28 = this.dS[1];
                  var31 = var15;
                  var34 = -this.dQ[var15];
                  var35 = this;
                  var37 = this.dO[var15] + 80;
                  break label130;
               }

               if (this.dN[var15] >= 0 || var17 <= 2) {
                  break label80;
               }

               this.dS[0][var15] = (-this.dQ[var15] * this.sin(this.dO[var15] - 80) >> 16) + this.dT[0][var15];
               var28 = this.dS[1];
               var31 = var15;
               var34 = -this.dQ[var15];
               var35 = this;
               var37 = this.dO[var15];
               var38 = 80;
            }

            var37 -= var38;
         }

         var28[var31] = (var34 * var35.cos(var37) >> 16) + this.dT[1][var15];
      }

      this.dW[var10] = var11;
      int var23 = var10 + 1;
      this.dW[var23] = var12;
      ++var23;
      this.dW[var23] = var13;
      ++var23;
      this.dW[var23] = var14;
      if (var16 == 6) {
         this.bS[var23] = 3;
      }

      return var23 + 1;
   }

   public int modifyBigLump1_subfunction5(long var1, long var3, int var5, long var6, int var8, int var9, byte var10, byte var11, int var12) {
      int var15 = 360 / var5;
      int var14 = var12 * 4;
      ArrayList<Integer> indexes = new ArrayList<>();

      int var13;
      for(var13 = var8; var13 < var8 + var5; ++var13) {
         indexes.add(var13);
         this.dP[0][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.dP[1][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         var14 -= var15;
         this.dP[2][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.dP[3][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         this.bR[var13] = var10;
         this.dW[var13] = (byte)var9;
         this.bS[var13] = var11;
      }
      this.CIRCLES_IDX.add(indexes);

      return var13;
   }

   public void modifyBigLump1_subfunction2(byte var1, byte var2, byte var3, int var4) {
      this.dW[var4] = var1;
      int var5 = var4 + 1;
      this.dW[var5] = var2;
      ++var5;
      this.dW[var5] = var3;
      this.bS[var5] = 3;
   }



   public int modifyBigLump1_subfunction3(int[] var1, long var2, long var4, int var6, int var7, int var8, int var9) {
      if (var9 == 0) {
         this.dP[var6][var8] = var1[var6] + 0;
         this.dP[var7][var8] = (int)((long)var1[var7] - (var2 >> 1));
         this.dP[var6 + 2][var8] = (int)((long)var1[var6] + var4 + 0L);
         this.dP[var7 + 2][var8] = (int)((long)var1[var7] - (var2 >> 1));
      }

      int var11 = var8 + 1;
      this.dP[var6][var11] = this.dP[var6 + 2][var11 - 1];
      this.dP[var7][var11] = this.dP[var7 + 2][var11 - 1];
      this.dP[var6 + 2][var11] = this.dP[var6][var11];
      this.dP[var7 + 2][var11] = (int)((long)this.dP[var7][var11 - 1] + var2);
      ++var11;
      if (var9 == 0) {
         this.dP[var6][var11] = this.dP[var6 + 2][var11 - 1];
         this.dP[var7][var11] = this.dP[var7 + 2][var11 - 1];
         this.dP[var6 + 2][var11] = (int)((long)this.dP[var6][var11] - var4);
         this.dP[var7 + 2][var11] = this.dP[var7][var11];
      }

      return var11 + 1;
   }



   public void modifyBigLump1_subfunction6() {
      for(int var2 = 0; var2 <= 15; ++var2) {
         if (this.hN[var2] != null) {
            for(int var1 = 0; var1 < this.hN[var2].length; ++var1) {
               boolean var3 = true;
               if (this.selectedMap == 4) {
                  for(int var4 = 0; var4 < this.hd; ++var4) {
                     if (this.hM[var4] == this.hN[var2][var1]) {
                        var3 = false;
                     }
                  }
               }

               if (var3) {
                  this.dW[this.hN[var2][var1]] = this.hP[var2][this.hQ[var2][var1]];
               }

               if (var3) {
                  byte[] var10000;
                  int var10001;
                  byte var10002;
                  if (this.hQ[var2][var1] < this.hK[var2]) {
                     var10000 = this.hQ[var2];
                     var10001 = var1;
                     var10002 = (byte)(var10000[var1] + 1);
                  } else {
                     var10000 = this.hQ[var2];
                     var10001 = var1;
                     var10002 = 0;
                  }

                  var10000[var10001] = var10002;
               }
            }
         }
      }

   }



   public void loadSpritesPart2(byte[][][] bigLump2) {
      Object var7 = null;
      Object var8 = null;
      BufferedImage var27 = this.readImage("/e" + this.dataExt);
      ResourcesLoaderC3D var10000;
      StringBuffer var10001;
      String var10002;
      if (this.selectedMap != 1 && this.selectedMap != 3 && this.selectedMap != 8 && this.selectedMap != 5) {
         if (this.selectedMap != 6 && this.selectedMap != 9 && this.selectedMap != 12) {
            var10000 = this;
            var10001 = new StringBuffer();
            var10002 = "/eeee";
         } else {
            var10000 = this;
            var10001 = new StringBuffer();
            var10002 = "/eee";
         }
      } else {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = "/ee";
      }

      BufferedImage var28 = var10000.readImage(var10001.append(var10002).append(this.dataExt).toString());
      int[] var9 = new int[2];
      var27.getRGB(0, 2, 0, 0, var9, 2, 1);
      this.Q = var9[0];
      this.R = var9[1];
      this.bJ = new short[7][];
      this.L = new int[this.bJ.length];
      int var2 = this.bJ.length;
      int var3 = (16 + bigLump2[5].length + 2) * 2;

      for(int var10 = 0; var10 < var2; ++var10) {
         this.bJ[var10] = new short[var3];
         this.L[var10] = 16 + bigLump2[5].length + 2;
         int var4 = this.bJ[var10].length;

         for(int var11 = 0; var11 < var4; ++var11) {
            this.bJ[var10][var11] = 0;
         }
      }

      int var14 = 16 + bigLump2[5].length;
      this.cE = new short[var14];
      this.bM = new short[var14];
      this.bN = new short[var14];
      this.bC = new int[var14];
      this.bO = new short[var14];
      this.bP = new short[var14];
      int var13 = 0;
      var2 = this.e.length;

      for(int var29 = 0; var29 < var2; var29 += 7) {
         this.loadSprites_subfunction1(this.e, var13, var29);
         this.cE[var13] = this.e[var29 + 6];
         ++var13;
      }

      var13 = 16;
      var2 = bigLump2[5].length;

      for(int var12 = 0; var12 < var2; ++var12) {
         int var30 = (bigLump2[5][var12][0] < 0 ? -bigLump2[5][var12][0] : bigLump2[5][var12][0]) * 7;
         this.loadSprites_subfunction1(this.f, var13, var30);
         this.cE[var13] = this.f[var30 + 6];
         ++var13;
      }

      int var16 = this.bJ[0][this.L[0]] + 10;
      int var17 = this.bJ[1][this.L[1]] + 10;
      int var18 = this.bJ[2][this.L[2]] + 10;
      int var19 = this.bJ[3][this.L[3]] + 10;
      int var20 = this.bJ[4][this.L[4]] + 10;
      int var21 = this.bJ[5][this.L[5]] + 10;
      int var22 = this.bJ[6][this.L[6]] + 10;
      this.loadSprites_subfunction2(var16, var17, bigLump2[1].length, var18, var19, var21, var20, var22);
      var13 = 0;
      short var23 = 0;
      var2 = this.e.length;

      for(int var31 = 0; var31 < var2; var31 += 7) {
         this.FOE_SPRITES_W.add(this.e[var31 + 2]);
         this.FOE_SPRITES_H.add(this.e[var31 + 3]);
         int[] var5 = new int[this.e[var31 + 2] * this.e[var31 + 3]];
         int[] var6 = new int[this.e[var31 + 2] * this.e[var31 + 3]];
         var27.getRGB(0, this.e[var31 + 2], this.e[var31 + 0], this.e[var31 + 1], var5, this.e[var31 + 2], this.e[var31 + 3]);
         var28.getRGB(0, this.e[var31 + 2], this.e[var31 + 0], this.e[var31 + 1], var6, this.e[var31 + 2], this.e[var31 + 3]);
         this.combineLayers(var5, var6, this.bI, var23, bigLump2[0][0], bigLump2[0][1]);
         this.FOE_SPRITES_DATA_COLOR_1.add(var5);
         this.FOE_SPRITES_DATA_COLOR_2.add(var6);
         var23 = (short)(var23 + 97);
         // int var15 = this.bP[var13] / this.bN[var13];
         // b and a are not used 9n the extractor
         // if (this.bM[var13] == 0) {
         //    this.b(var13, var15, var5);
         // } else if (this.bM[var13] == 1) {
         //    this.a(var13, var15, var5);
         // }
         ++var13;
      }

   }

   public void loadSpritesPart3(byte[][][] bigLump2) {
      int var2 = 0;
      if (this.selectedMap == 2) {
         for(int var3 = 0; var3 < 3; ++var3) {
            long[] var10000;
            int var10001;
            long var10002;
            if (var3 != 1) {
               var10000 = this.hW;
               var10001 = var3;
               var10002 = -29992L;
            } else {
               var10000 = this.hW;
               var10001 = 1;
               var10002 = 29992L;
            }

            var10000[var10001] = var10002;
         }
      }

      this.hV[0] = 0;
      this.hV[1] = 11;
      this.hV[2] = 9;
      int var7 = bigLump2[5].length;
      this.SPRITES_W = new short[var7];
      this.SPRITES_H = new short[var7];

      for(int var5 = 0; var5 <= 2; ++var5) {
         BufferedImage var10 = this.readImage(this.spriteFiles[var5] + this.dataExt);
         BufferedImage var11 = this.readImage(this.spriteFiles[var5 + 3] + this.dataExt);

         for(int var4 = 0; var4 < var7; ++var4) {
            if (var5 == 0) {
               if (bigLump2[5][var4][0] < 0 || bigLump2[5][var4][0] > 82 && bigLump2[5][var4][0] != 122) {
                  continue;
               }
            } else if (var5 == 1) {
               if (bigLump2[5][var4][0] >= 0) {
                  continue;
               }

               bigLump2[5][var4][0] = (byte)(-bigLump2[5][var4][0]);
            } else if (bigLump2[5][var4][0] <= 82) {
               continue;
            }

            int var14 = bigLump2[5][var4][0] * 7;
            int[] var8 = new int[this.f[var14 + 2] * this.f[var14 + 3]];
            int[] var9 = new int[this.f[var14 + 2] * this.f[var14 + 3]];
            this.SPRITES_W[var4] = this.i[var14 + 2];
            this.SPRITES_H[var4] = this.i[var14 + 3];
            var10.getRGB(0, this.f[var14 + 2], this.f[var14 + 0], this.f[var14 + 1], var8, this.f[var14 + 2], this.f[var14 + 3]);
            var11.getRGB(0, this.f[var14 + 2], this.f[var14 + 0], this.f[var14 + 1], var9, this.f[var14 + 2], this.f[var14 + 3]);
            int var12 = 1552 + var4 * 97;
            this.combineLayers(var8, var9, this.bI, (short)var12, bigLump2[6][var4], bigLump2[1][var4]);
            this.SPRITES_DATA_COLOR_1.add(var8);
            this.SPRITES_DATA_COLOR_2.add(var9);

            // var2 = 16 + var4;
            // int var6 = this.bP[var2] / this.bN[var2];
            // if (this.bM[var2] == 0) {
            //    this.b(var2, var6, var8);
            // } else if (this.bM[var2] == 1) {
            //    this.a(var2, var6, var8);
            // } else if (this.bM[var2] == 2) {
            //    this.c(var2, var6, var8);
            // } else if (this.bM[var2] == 3) {
            //    this.d(var2, var6, var8);
            // } else if (this.bM[var2] == 4) {
            //    this.f(var2, var6, var8);
            // } else if (this.bM[var2] == 5) {
            //    this.e(var2, var6, var8);
            // } else if (this.bM[var2] == 6) {
            //    this.g(var2, var6, var8);
            // }

            // this.E = (byte[][][])null;
            // System.gc();
         }
      }

   }


   public void combineLayers(int[] layer1, int[] layer2, int[][] colorData, short startIndex, byte[] palette1, byte[] palette2) {
      byte var11 = 0;
      byte var12 = 1;
      int var13 = layer1.length;
      byte[] var14 = new byte[256];
      int[] var15 = new int[97];
      short var17 = startIndex;
      short var18 = 0;

      for(int i = 0; i < var13; ++i) {
         int var16;
         if ((var16 = layer1[i]) == this.Q) {
            layer1[i] = -1;
         } else {
            int var10 = var16 & 255;
            if ((var11 = var14[var10]) > 0) {
               layer1[i] = var15[var11];
            } else {
               var14[var10] = var12;
               var15[var12] = var18;
               ++var12;
               int var19 = palette1[0] == 0 && palette1[1] == 0 && palette1[2] == 0 && palette1[3] == 0 && palette1[4] == 0 ? var16 : this.combineLayers_subfunction1(palette1[0], palette1[1], palette1[2], palette1[3], palette1[4], var10, var10, var10, false);
               int var20 = palette2[0] == 0 && palette2[1] == 0 && palette2[2] == 0 && palette2[3] == 0 && palette2[4] == 0 ? var16 : this.combineLayers_subfunction1(palette2[0], palette2[1], palette2[2], palette2[3], palette2[4], var10, var10, var10, false);
               colorData[0][var17] = (int)((long)var19 | 0L);
               colorData[1][var17] = (int)((long)var20 | 0L);
               layer1[i] = var18++;
               ++var17;
            }
         }
      }

      this.E = new byte[32][32][32];
      var15 = new int[97];

      for(int i = 0; i < var13; ++i) {
         int var26;
         if ((var26 = layer2[i]) != this.Q) {
            int var8 = (var26 & 16711680) >> 19;
            int var9 = (var26 & '\uff00') >> 11;
            int var22 = (var26 & 255) >> 3;
            if ((var11 = this.E[var8][var9][var22]) > 0) {
               layer1[i] = var15[var11];
            } else {
               this.E[var8][var9][var22] = var12;
               var15[var12] = var18;
               ++var12;
               if (layer2[i] != this.Q) {
                  colorData[0][var17] = (int)((long)var26 | 0L);
                  colorData[1][var17] = (int)((long)var26 | 0L);
               }

               layer1[i] = var18++;
               ++var17;
            }
         }
      }

   }


   public int combineLayers_subfunction1(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
      int[] var11 = new int[3];
      byte var13;
      byte var14;
      byte var15;
      short var16;
      short var18;
      int var10000;
      if (var9) {
         var18 = 255;
         var11[0] = var8 + (var1 << 4);
         var11[1] = var8 + (var2 << 4);
         var11[2] = var8 + (var3 << 4);
         var13 = 16;
         var14 = 8;
         var15 = 0;
         var16 = 128;
         var10000 = var5 << 4;
      } else {
         var18 = 15;
         var11[0] = (var6 >> 4) + var1;
         var11[1] = (var7 >> 4) + var2;
         var11[2] = (var8 >> 4) + var3;
         var13 = 20;
         var14 = 12;
         var15 = 4;
         var16 = 7;
         var10000 = var5;
      }

      int var17 = var10000;
      int var12 = (var11[0] + var11[1] + var11[2]) / 3;

      for(int var10 = 0; var10 <= 2; ++var10) {
         // unsure
         var11[var10] = combineLayers_subfunction2((int)(var11[var10] + var17), var18);
         var11[var10] = combineLayers_subfunction2((int)(var12 + (var11[var10] - var12) * (var4 + var16) / var16), var18);
      }

      return var11[0] << var13 | var11[1] << var14 | var11[2] << var15;
   }

   public static int combineLayers_subfunction2(int var0, int var1) {
      if (var0 > var1) {
         return var1;
      } else {
         return var0 < 0 ? 0 : var0;
      }
   }



   public void loadSprites_subfunction2(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      this.bI = new int[2][(16 + var3) * 97];
      this.bF = new int[97];
      this.dY = new byte[var1];
      this.dZ = new byte[var1];
      this.ea = new byte[var1];
      this.eb = new byte[var1];
      this.ec = new byte[var1];
      this.ed = new byte[var1];
      this.ee = new byte[var2];
      this.ef = new byte[var2];
      this.eg = new byte[var4];
      this.eh = new byte[var4];
      this.ei = new byte[var5];
      this.ej = new byte[var5];
      this.ek = new byte[var5];
      this.el = new byte[var5];
      this.em = new byte[var6];
      this.en = new byte[var6];
      this.eo = new byte[var6];
      this.ep = new byte[var6];
      this.eq = new byte[var7];
      this.er = new byte[var7];
      this.es = new byte[var8];
      this.et = new byte[var8];
      this.eu = new byte[var8];
      this.ev = new byte[var8];
      this.ew = new byte[var8];
      this.ex = new byte[var8];
      this.ey = new byte[var8];
      this.ez = new byte[var8];
   }






   public void loadTextures_subfunction6(byte[][][] var1, byte[][][] var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = var2[9][var3][0];
      byte var9 = var1[2][var3][5];
      int var10 = this.k[6 * var8] + 128;
      if (this.O != var3 && var5 != var6) {
         if (var4 == 0) {
            if (var9 != 12) {
               this.B = this.readImage("/" + String.valueOf(var10) + this.dataExt);
            } else {
               BufferedImage var11 = this.readImage("/" + String.valueOf(var10) + this.dataExt);
               int width = var11.getWidth();
               int height = var11.getHeight();
               BufferedImage transformedImage = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
               Graphics2D g2d = transformedImage.createGraphics();
               g2d.translate(height / 2, width / 2); // move to the center of the new image
               g2d.rotate(Math.PI / 2); // rotate 90 degrees clockwise
               g2d.scale(-1, 1); // reflect about vertical center
               g2d.translate(-width / 2, -height / 2); // adjust translation
               g2d.drawImage(var11, 0, 0, null);
               g2d.dispose();
               this.B = transformedImage;
            }
         } else {
            this.C = this.readImage("/" + String.valueOf(var10) + this.dataExt);
         }
      }

      if (this.O != var3) {
         BufferedImage var10000;
         int[] var10001;
         if (var4 == 0) {
            var10000 = this.B;
            var10001 = this.H;
         } else {
            this.F = new int[this.J * this.K];
            var10000 = this.C;
            var10001 = this.F;
         }

         var10000.getRGB(0, this.J, var1[4][var3][0], var1[4][var3][1], var10001, this.J, this.K);
         ResourcesLoaderC3D var14;
         if (var4 != 0) {
            var14 = this;
            var10001 = this.F;
         } else {
            var14 = this;
            var10001 = this.H;
         }

         var14.loadTextures_subfunction1(var10001, var1, var3);
         if (var4 == 0 && var7 == var3) {
            this.O = var3;
            this.G = new int[this.J * this.K];
            this.loadTextures_subfunction7((int[])this.G, (int[])this.H, 0, 0, this.J, this.J, this.K);
         }

      } else {
         int var13 = this.G.length;

         for(int var12 = 0; var12 < var13; ++var12) {
            this.H[var12] = this.G[var12];
         }

      }
   }

   public void loadTextures_subfunction1(int[] var1, byte[][][] var2, int var3) {
      byte var4 = var2[2][var3][0];
      byte var5 = var2[2][var3][1];
      byte var6 = var2[2][var3][2];
      byte var7 = var2[2][var3][3];
      byte var8 = var2[2][var3][4];
      if (var4 != 0 || var5 != 0 || var6 != 0 || var7 != 0 || var8 != 0) {
         this.loadTextures_subfunction3(var1, var4, var5, var6, var7, var8, false);
      }

   }

   public void loadTextures_subfunction3(int[] var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      int var12 = 1;
      int var13 = 0;
      int var14 = var1.length;
      int[] var15 = new int[257];
      int[] var16 = new int[257];

      for(int var8 = 0; var8 < var14; ++var8) {
         int var18;
         if ((var18 = var1[var8]) != this.Q && var18 != this.R) {
            int var9 = (var18 & 16711680) >> 16;
            int var10 = (var18 & '\uff00') >> 8;
            int var11 = var18 & 255;
            if ((var13 = var15[var11]) > 0) {
               var1[var8] = var16[var13];
            } else {
               var15[var11] = var12;
               var1[var8] = this.combineLayers_subfunction1(var2, var3, var4, var5, var6, var9, var10, var11, var7);
               var16[var12] = var1[var8];
               ++var12;
            }
         }
      }

   }

   public void loadTextures(byte[][][] bigLump0, byte[][][] bigLump1, short[] footer) {
      int var20 = 0;
      this.M = new int[bigLump1[9].length][];
      this.N = new int[bigLump1[9].length];
      int var19 = bigLump1.length;

      for(int var4 = 0; var4 < var19; ++var4) {
         if (var4 != 9 && var4 != 32) {
            bigLump1[var4] = (byte[][])null;
         }
      }

      bigLump0[0] = (byte[][])null;
      System.gc();
      var19 = bigLump0[4].length;

      for(int var31 = 0; var31 < var19; ++var31) {
         byte var24 = bigLump1[9][var31][0];
         if (bigLump0[4][var31][2] == 0) {
            bigLump0[4][var31][2] = (byte)(this.k[6 * var24 + 3] + 128);
         }

         if (bigLump0[4][var31][3] == 0) {
            bigLump0[4][var31][3] = (byte)(this.k[6 * var24 + 4] + 128);
         }
      }

      var19 = bigLump1[9].length;
      this.hG = new int[4][];

      for(int var32 = 0; var32 <= 6; ++var32) {
         System.gc();
         BufferedImage var39 = this.readImage("/" + String.valueOf(var32) + this.dataExt);

         for(int var5 = 0; var5 < var19; ++var5) {
            byte var26 = bigLump1[9][var5][0];
            int var21 = this.k[6 * var26] + 128;
            int var22 = bigLump0[4][var5][2] * 2;
            int var23 = bigLump0[4][var5][3] * 2;
            if (var21 == var32) {
               label187: {
                  this.M[var20] = new int[var22 * var23];
                  this.N[var5] = var20;
                  int var27 = (this.k[6 * var26 + 1] + 128 + bigLump0[4][var5][0]) * 2;
                  int var28 = (this.k[6 * var26 + 2] + 128 + bigLump0[4][var5][1]) * 2;
                  var39.getRGB(0, var22, var27, var28, this.M[var20], var22, var23);
                  BufferedImage var10000;
                  int[] var10001;
                  byte var10002;
                  byte var10003;
                  int var10004;
                  int var10005;
                  byte var10006;
                  byte var10007;
                  if (bigLump1[9][var5][0] == 16) {
                     this.hG[0] = new int[784];
                     var10000 = var39;
                     var10001 = this.hG[0];
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (bigLump1[9][var5][0] == 74) {
                     this.hG[1] = new int[784];
                     var10000 = var39;
                     var10001 = this.hG[1];
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (bigLump1[9][var5][0] == 75) {
                     this.hG[2] = new int[784];
                     var10000 = var39;
                     var10001 = this.hG[2];
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (bigLump1[9][var5][0] == 97) {
                     this.hG[3] = new int[784];
                     var10000 = var39;
                     var10001 = this.hG[3];
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else {
                     if (bigLump1[9][var5][0] != 7) {
                        break label187;
                     }

                     this.hH = new int[676];
                     var10000 = var39;
                     var10001 = this.hH;
                     var10002 = 0;
                     var10003 = 26;
                     var10004 = var27;
                     var10005 = var28;
                     var10006 = 26;
                     var10007 = 26;
                  }

                  var10000.getRGB(var10002, var10003, var10004, var10005, var10001, var10006, var10007);
               }

               this.loadTextures_subfunction1(this.M[var20], bigLump0, var5);
               ++var20;
            }
         }
      }

      this.bE = new int[bigLump0[3].length + 1];
      int var17 = 0;
      this.bE[0] = 0;
      this.bD = new int[bigLump0[3].length + 1];
      this.bK = new short[bigLump0[3].length * 9];
      int var10 = footer[6] * 2 * 2;
      int var11 = footer[7] * 2 * 2;
      this.loadTextures_subfunction2(var10, var11);
      int var14 = 0;
      this.O = -1;
      byte var7 = -1;
      byte var9 = 0;
      var19 = bigLump0[3].length;

      for(int var33 = 0; var33 < var19; ++var33) {
         byte var8 = var7;
         byte var6 = bigLump1[32][var33][0];
         this.P = bigLump1[9][var6][0];
         var9 = var33 != var19 - 1 ? bigLump1[32][var33 + 1][0] : -1;
         var7 = bigLump1[9][var6][0];
         this.J = bigLump0[4][var6][2] * 2;
         this.K = bigLump0[4][var6][3] * 2;
         this.I = bigLump0[2][var6][5];
         if (this.I >= 1 && this.I <= 5) {
            this.J *= 2;
         }

         if (this.I >= 4 && this.I <= 9) {
            this.K *= 2;
         }

         int var15 = this.J;
         int var16 = this.K;
         this.H = new int[var15 * var16];
         if (bigLump0[3][var33][3] != 1 && bigLump0[3][var33][3] != 2) {
            ResourcesLoaderC3D var43;
            int[] var46;
            if (this.k[6 * var7] + 128 > 6) {
               this.loadTextures_subfunction6((byte[][][])bigLump0, (byte[][][])bigLump1, var6, 0, var8, var7, var9);
               var43 = this;
               var46 = this.H;
            } else {
               var43 = this;
               var46 = this.M[this.N[var6]];
            }

            var43.loadTextures_subfunction8(var46, var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], 0, 0);
         }

         int var12 = bigLump0[3][var33][1] * 2;
         int var13 = bigLump0[3][var33][2] == 0 ? this.J : bigLump0[3][var33][2] * 2;
         int var40 = 0;
         var40 = bigLump0[3][var33][0] == bigLump0[3][var33][1] ? var13 : (bigLump0[3][var33][3] != 2 ? this.J : 96);
         byte var25 = bigLump0[3][var33][0];
         if (bigLump0[3][var33][3] == 1) {
            var14 = this.loadTextures_subfunction19(bigLump1[32][var33][0], bigLump1[32][var33][1], (byte)var33, (byte)var12, (byte)var13, (short)140, var14, (short)26, (byte)(var12 + 23));
         } else if (bigLump0[3][var33][3] == 2) {
            var14 = this.loadTextures_subfunction19(bigLump1[32][var33][0], bigLump1[32][var33][1], (byte)var33, (byte)var12, (byte)var13, (short)((byte)var40), var14, (short)0, (byte)var12);
         } else {
            var14 = this.loadTextures_subfunction19((byte)var25, (byte)var33, (byte)var33, (byte)var12, (byte)var13, (short)((byte)var40), var14, (short)0, (byte)var12);

            for(int var34 = 1; var34 <= 3 && bigLump1[32][var33][var34] != var6; ++var34) {
               var6 = bigLump1[32][var33][var34];
               this.J = bigLump0[4][var6][2] * 2;
               this.K = bigLump0[4][var6][3] * 2;
               this.I = bigLump0[2][var6][5];
               if (this.I >= 1 && this.I <= 5) {
                  this.J *= 2;
               }

               if (this.I >= 4 && this.I <= 9) {
                  this.K *= 2;
               }

               ResourcesLoaderC3D var44;
               int[] var47;
               if (this.k[6 * bigLump1[9][var6][0]] + 128 > 6) {
                  this.loadTextures_subfunction6((byte[][][])bigLump0, (byte[][][])bigLump1, var6, var34, -1, -2, -1);
                  var44 = this;
                  var47 = this.F;
               } else {
                  var44 = this;
                  var47 = this.M[this.N[var6]];
               }

               var44.loadTextures_subfunction8(var47, var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], bigLump0[2][var6][6] * 2, bigLump0[2][var6][7] * 2);
            }

            label162: {
               this.bE[var33] = this.bE[var17];
               this.bE[var17 + 1] = this.bE[var17] + var13 * 12;
               ++var17;
               int[] var45;
               int[] var48;
               int var49;
               int var50;
               int var51;
               byte var52;
               byte var53;
               int var54;
               int[] var10008;
               boolean var10009;
               if (bigLump0[3][var33][3] != 0) {
                  loadTextures_subfunction18(this.dr, this.ds, this.bE[var33], var12, var13, 12, 0, var15, this.H, true);
                  var45 = this.dt;
                  var48 = this.du;
                  var49 = this.bE[var33];
                  var50 = var12;
                  var51 = var13;
                  var52 = 12;
                  var53 = 2;
                  var54 = var15;
                  var10008 = this.H;
                  var10009 = true;
               } else {
                  int var42 = (this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12 || this.selectedMap == 13) && var16 == 192 ? 8 : 0;
                  loadTextures_subfunction18(this.dr, this.ds, this.bE[var33], var12, var13, 12, var42, var15, this.H, true);
                  loadTextures_subfunction18(this.dt, this.du, this.bE[var33], var12, var13, 12, var42 + 2, var15, this.H, true);
                  loadTextures_subfunction18(this.dv, this.dw, this.bE[var33], var12, var13, 12, var42 + 6, var15, this.H, false);
                  loadTextures_subfunction18(this.dx, this.dy, this.bE[var33], var12, var13, 12, var42 + 4, var15, this.H, false);
                  if (this.selectedMap != 8 && this.selectedMap != 9 && this.selectedMap != 10 && this.selectedMap != 11 && this.selectedMap != 12 && this.selectedMap != 13) {
                     break label162;
                  }

                  loadTextures_subfunction18(this.dz, this.dA, this.bE[var33], var12, var13, 12, 0, var15, this.H, true);
                  loadTextures_subfunction18(this.dB, this.dC, this.bE[var33], var12, var13, 12, 2, var15, this.H, true);
                  loadTextures_subfunction18(this.dD, this.dE, this.bE[var33], var12, var13, 12, 6, var15, this.H, false);
                  var45 = this.dF;
                  var48 = this.dG;
                  var49 = this.bE[var33];
                  var50 = var12;
                  var51 = var13;
                  var52 = 12;
                  var53 = 4;
                  var54 = var15;
                  var10008 = this.H;
                  var10009 = false;
               }

               loadTextures_subfunction18(var45, var48, var49, var50, var51, var52, var53, var54, var10008, var10009);
               this.TEXTURES_W.add(var15);
               this.TEXTURES_H.add(var16);
               this.TEXTURES_DATA.add(this.H);

            }

            // this.H = null;
            // System.gc();
         }
      }

      // this.F = null;
      // this.G = null;
      // this.H = null;
      // this.G = null;
      // this.M = (int[][])null;
      // this.N = null;
      // this.B = null;
      // this.C = null;
      // System.gc();
   }

   public static void loadTextures_subfunction18(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, boolean var9) {
      int var17 = var3 + var4;
      if (var9) {
         int var13;
         int var18 = (var13 = var6 * var5) + var5;
         int var15 = var3 + var13 * var7;
         int var16 = var7 * var5;
         int var12 = 0;

         for(int var10 = var3; var10 < var17; ++var10) {
            int var14 = var15;

            for(int var11 = var13; var11 < var18; ++var11) {
               var0[var2 + var12] = (int)((long)var8[var14] | 0L);
               var1[var2 + var12] = (int)((long)var8[var14 + var16] | 0L);
               ++var12;
               var14 += var7;
            }

            ++var15;
         }
      } else {
         int var22 = (var6 + 2) * var5 - 1;
         boolean var26 = false;
         int var24 = var3 + var22 * var7;
         int var25 = var7 * var5;
         int var21 = 0;

         for(int var19 = var3; var19 < var3 + var4; ++var19) {
            int var23 = var24;

            for(int var20 = var22; var20 > var22 - var5; --var20) {
               var0[var2 + var21] = (int)((long)var8[var23] | 0L);
               var1[var2 + var21] = (int)((long)var8[var23 - var25] | 0L);
               ++var21;
               var23 -= var7;
            }

            ++var24;
         }
      }

   }



   public void loadTextures_subfunction8(int[] var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
      if (var5 == 0) {
         if (this.P != 3 && this.P != 4 && this.P != 9 && this.P != 10 && this.P != 13 && this.P != 14 && this.P != 15 && this.P != 16 && this.P != 17 && this.P != 18 && this.P != 22 && this.P != 23 && this.P != 55 && this.P != 77 && this.P != 86 && this.P != 19 && this.P != 29 && this.P != 50 && this.P != 51 && this.P != 52 && this.P != 53 && this.P != 54 && this.P != 24 && this.P != 25 && this.P != 26 && this.P != 29 && this.P != 88 && this.P != 107) {
            this.loadTextures_subfunction9(this.H, var1, var6, var7, var2, var3, var4);
         } else {
            this.loadTextures_subfunction9(this.H, var1, var6, var7, var2, var3, var4);
            if (this.P == 4) {
               this.loadTextures_subfunction7((int[])this.H, (int[])this.H, 0, 0, var2, var2, var2 >> 1);
            } else {
               this.loadTextures_subfunction7((int[])this.H, (int[])this.H, 0, 0, var2, var2, var2);
            }
         }
      } else if (var5 != 1) {
         if (var5 == 2) {
            this.loadTextures_subfunction10(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 3) {
            this.loadTextures_subfunction11(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 4) {
            this.loadTextures_subfunction12(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 5) {
            this.loadTextures_subfunction13(this.H, var1, var6, var7, var2, var3, var4, var5);
         } else if (var5 == 6) {
            this.loadTextures_subfunction14(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 7) {
            this.loadTextures_subfunction15(this.H, var1, var6, var7, var2, var3, var4);
            this.loadTextures_subfunction14(this.H, this.H, var6, var7, var2, var3, var4);
         } else if (var5 == 10) {
            this.loadTextures_subfunction16(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 11) {
            this.loadTextures_subfunction13(this.H, var1, var6, var7, var2, var3, var4, var5);
         } else {
            if (var5 == 12) {
               this.loadTextures_subfunction15(this.H, var1, var6, var7, var2, var3, var4);
            }

         }
      } else {
         if (this.P == 55 || this.P == 104) {
            this.loadTextures_subfunction7((int[])var1, (int[])var1, 0, 0, var3, var3, var4);
         }

         this.loadTextures_subfunction17(this.H, var1, var6, var7, var2, var3, var4);
      }
   }

   public void loadTextures_subfunction7(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var15;
            int[] var10000;
            int var10001;
            label26: {
               int var13;
               if ((var13 = var2[var10]) != this.Q) {
                  if (var13 != this.R) {
                     var10000 = var1;
                     var10001 = var8;
                     var15 = var13;
                     break label26;
                  }

                  var10000 = var1;
                  var10001 = var8;
                  var15 = this.bg;
               } else {
                  var10000 = var1;
                  var10001 = var8;
                  var15 = this.bh;
               }

               var15 &= 16777215;
            }

            var10000[var10001] = var15;
            ++var10;
         }

         var11 += var5;
      }

   }

   public void loadTextures_subfunction9(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.Q) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   public void loadTextures_subfunction17(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;
      int var16 = var4 + var7;

      for(int var10 = var4; var10 < var16; ++var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.Q) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 += var5;
      }

   }

   public void loadTextures_subfunction15(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var13 = var6 - 1;
      int var11 = 0;
      int var16 = var4 + var7;

      for(int var10 = var4; var10 < var16; ++var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.Q) {
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 += var5;
      }

   }

   public void loadTextures_subfunction10(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = (var4 + var7 - 1) * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;

      for(int var10 = var4 + var7 - 1; var10 >= var4; --var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.Q) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 -= var5;
      }

   }

   public void loadTextures_subfunction11(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.Q) {
               var1[var8] = var13;
               var1[var8 + var6] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   public void loadTextures_subfunction12(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var14 = var5 * var7;
      int var10 = 0;
      int var15 = var4 + var7;

      for(int var9 = var4; var9 < var15; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.Q) {
               var1[var8] = var13;
               var1[var8 + var6] = var13;
               var1[var8 + var14] = var13;
               var1[var8 + var14 + var6] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   public void loadTextures_subfunction13(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var15;
      int var16;
      int var17;
      int var18;
      label34: {
         var16 = 0;
         var17 = 0;
         var18 = 0;
         var15 = var4 * var5 + var3;
         int var10000;
         int var10001;
         if (var8 == 5) {
            var17 = (var16 = var15 + (2 * var6 - 1)) + (2 * var7 - 1) * var5;
            var10000 = var15;
            var10001 = 2 * var7;
         } else {
            if (var8 != 11) {
               break label34;
            }

            var17 = (var16 = var15 + (var7 - 1)) + (var7 - 1) * var5;
            var10000 = var15;
            var10001 = var7;
         }

         var18 = var10000 + (var10001 - 1) * var5;
      }

      int var14 = 0;
      int var21 = var4 + var7;

      for(int var13 = var4; var13 < var21; ++var13) {
         int var19 = var15 + var6;
         int var10 = var16;
         int var11 = var17;
         int var12 = var18;

         for(int var9 = var15; var9 < var19; ++var9) {
            int var20;
            if ((var20 = var2[var14]) != this.Q) {
               var1[var9] = var20;
               var1[var10] = var20;
               var1[var11] = var20;
               var1[var12] = var20;
            }

            ++var14;
            var10 += var5;
            --var11;
            var12 -= var5;
         }

         var15 += var5;
         --var16;
         var17 -= var5;
         ++var18;
      }

   }

   public void loadTextures_subfunction14(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var9 = var5 * var7;
      int var11 = 0;
      int var15 = var4 + var7;

      for(int var10 = var4; var10 < var15; ++var10) {
         int var13 = var12 + var6;

         for(int var8 = var12; var8 < var13; ++var8) {
            int var14;
            if ((var14 = var2[var11]) != this.Q) {
               var1[var8] = var14;
               var1[var8 + var9] = var14;
            }

            ++var11;
         }

         var12 += var5;
      }

   }

   public void loadTextures_subfunction16(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + (var3 + var5 - 1);
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 - var6;

         for(int var8 = var11; var8 > var12; --var8) {
            int var13;
            if ((var13 = var2[var10]) != this.Q) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

      var11 = var4 * var5 + var3;
      var10 = 0;

      for(int var16 = var4; var16 < var14; ++var16) {
         int var19 = var11 + var6;

         for(int var15 = var11; var15 < var19; ++var15) {
            int var20;
            if ((var20 = var2[var10]) != this.Q) {
               var1[var15] = var20;
            }

            ++var10;
         }

         var11 += var5;
      }

   }



   public int loadTextures_subfunction19(byte var1, byte var2, byte var3, byte var4, byte var5, short var6, int var7, short var8, byte var9) {
      this.bD[var3] = var7;
      int var10 = this.loadTextures_subfunction20((byte)0, var1, (short)var8, var7);
      var10 = this.loadTextures_subfunction20(var9, var2, (short)0, var10);
      var10 = this.loadTextures_subfunction20((byte)(var9 + var5), var1, (short)((byte)(var4 + var5)), var10);
      this.bD[var3 + 1] = var10;
      this.bL[var3] = var6;
      return var10;
   }

   public int loadTextures_subfunction20(byte var1, byte var2, short var3, int var4) {
      this.bK[var4] = (short)var1;
      int var5 = var4 + 1;
      this.bK[var5] = (short)var2;
      ++var5;
      this.bK[var5] = var3;
      ++var5;
      return var5;
   }


   public void loadTextures_subfunction2(int var1, int var2) {
      this.dr = new int[var1];
      this.ds = new int[var1];
      this.dt = new int[var1];
      this.du = new int[var1];
      this.dv = new int[var2];
      this.dw = new int[var2];
      this.dx = new int[var2];
      this.dy = new int[var2];
      if (this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12 || this.selectedMap == 13) {
         this.dz = new int[var1];
         this.dA = new int[var1];
         this.dB = new int[var1];
         this.dC = new int[var1];
         this.dD = new int[var1];
         this.dE = new int[var1];
         this.dF = new int[var1];
         this.dG = new int[var1];
      }

   }









}

/*
 * Decompiled a.class from b3d
 * And partially deobfuscated
 * I'm not going to 100% deobfuscate and port it
 * If you are, please note, I could broke sth accidentally
 */
import GlomoReg.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.control.VolumeControl;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordStore;

public final class b3d_a extends Canvas {
   private byte c;
   private i d;
   private boolean e;
   private int f = 10;
   private int g = 10;
   private int h = 10;
   private final short[] i = new short[]{1, 81, 161};
   private short[] unusedMapRawLump1;
   private short[] FOE_METADATA;       // i +   0  1  2  3  4  5  6
                                       // val   x  y  w  h
   private short[] l;
   private short[] m;
   private byte[] n;
   private byte[] o;
   private byte[] p;
   private byte[] q;
   private byte[] r;
   private byte[] s;
   private byte[] t;
   private byte[] u;
   /*
                  loadedMap
        -----------------------------------
        | header, 3 shorts: A, B, C       |
        -----------------------------------
    0   | 5 shorts, can be negative       |
        -----------------------------------
    1   | A*4 nibbles as bytes            |
        -----------------------------------
    2   | B bytes                         |
        -----------------------------------
    3   | 72 bytes                        |
        -----------------------------------
    4   | C bytes                         |
        -----------------------------------
    5   | 10 bytes                        |
        -----------------------------------
        | footer, 8 shorts                |
        -----------------------------------
   */
   private byte[][] loadedMap;
   private byte[] lumpsSizes = new byte[]{5, 72, 10, 8};
   private String dataExt = ".b3d";
   private String[] mapFiles = new String[]{"/d", "/b", "/o", "/x", "/m", "/t", "/g", "/y", "/l"};
   private byte[] z;
   private String[] spriteFiles = new String[]{"/p", "/r", "/pp", "/rr"};
   private byte[][] B = new byte[][]{{1, 1, -1, 1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {1, -1, 1, 1}};
   private Image C;
   private Image D;
   private byte[][][][] E;
   private byte[][][] F;
   private int[] G;
   private int[] H;
   private int[] I;
   private byte J;
   private int K;
   private int L;
   private int[] M;
   private int[][] N;
   private int[] O;
   private int P;
   private int Q;
   private int BACKGROUND_COLOR;
   private long S;
   private long T;
   private long U;
   private long V;
   private long W;
   private long X;
   private long Y;
   private long Z;
   private long aa;
   private long ab;
   private long ac;
   private long ad;
   private long ae;
   private long af;
   private long ag;
   private long ah;
   private long ai;
   private long aj;
   private long ak;
   private long al;
   private long am;
   private long an;
   private long ao;
   private long ap;
   private int aq;
   private int ar;
   private int as;
   private int at;
   private int au;
   private int av;
   private int aw;
   private int ax;
   private int ay;
   private int az;
   private int aA;
   private int aB;
   private int aC;
   private int aD;
   private int aE;
   private int aF;
   private int aG;
   private int aH;
   private int aI;
   private int aJ;
   private int aK;
   private int aL;
   private int aM;
   private int aN;
   private int aO;
   private int aP;
   private int aQ;
   private int aR;
   private int aS;
   private int aT;
   private int aU;
   private int aV;
   private int aW;
   private byte aX;
   private byte aY;
   private boolean aZ;
   private boolean ba;
   private boolean bb;
   private boolean bc;
   private boolean bd;
   private long[] be;
   private long[] bf;
   private long[] bg;
   private int[] bh;
   private int[] bi;
   private int[] bj;
   private int[] bk;
   private int[] bl;
   private int[] bm;
   private int[] bn;
   private int[][] bo;
   private int[][] bp;
   private short[][] bq;
   private short[] br;
   private short[] bs;
   private short[] bt;
   private short[] bu;
   private short[] foeW;
   private short[] foeH;
   private byte[] bx;
   private byte[] by;
   private byte[] bz;
   private byte[] bA;
   private short[][][] bB;
   private boolean[] bC;
   private long bD;
   private long bE;
   private long bF;
   private long bG;
   private int bH;
   private int bI;
   private int bJ;
   private int bK;
   private int bL;
   private int bM;
   private int bN;
   private boolean bO;
   private long[] bP;
   private long[] bQ;
   private long[] bR;
   private long[] bS;
   private int[][] bT;
   private int[] bU;
   private int[] bV;
   private short[] bW;
   private short[] bX;
   private short[] bY;
   private byte[] bZ;
   private byte[] ca;
   private byte[] cb;
   private byte[] cc;
   private byte[] cd;
   private byte[] ce;
   private byte[] cf;
   private byte[] cg;
   private byte[] ch;
   private byte[][] ci;
   private boolean[] cj;
   private boolean[] ck;
   private boolean[] cl;
   private boolean[] cm;
   private long cn;
   private long co;
   private long cp;
   private long cq;
   private long cr;
   private long cs;
   private long ct;
   private long cu;
   private long cv;
   private long cw;
   private long cx;
   private long cy;
   private long cz;
   private long cA;
   private int cB;
   private byte cC;
   private short[][] cD;
   private short[][] cE;
   private long cF;
   private long[] cG;
   private long[] cH;
   private int[] cI;
   private int[] cJ;
   private int[] cK;
   private int[] cL;
   private int[] cM;
   private int[] cN;
   private int[] cO;
   private int[] cP;
   private int[] cQ;
   private int[] cR;
   private int[] cS;
   private int[] cT;
   private int[] cU;
   private int[] cV;
   private int[][] cW;
   private byte[] cX;
   private byte[] cY;
   private byte[] cZ;
   private byte[] da;
   private byte[] db;
   private byte[] dc;
   private byte[] dd;
   private byte[] de;
   private byte[] df;
   private byte[] dg;
   private byte[] dh;
   private byte[] di;
   private byte[] dj;
   private byte[] dk;
   private byte[] dl;
   private byte[] dm;
   private byte[] dn;
   private byte[] do;
   private int[][] dp;
   private int[][] dq;
   private byte[] dr;
   private byte[] ds;
   private byte[] dt;
   private byte[] du;
   private int[] dv;
   private int[] dw;
   private int[] dx;
   private int[] dy;
   private int[] dz;
   private int[] dA;
   private int[] dB;
   private boolean dC;
   private d dD;
   private long dE;
   private long dF;
   private long dG;
   private long dH;
   private long dI;
   private int dJ;
   private int dK;
   private int[] dL;
   private short[][] dM;
   private short[][] dN;
   private short[] dO;
   private short[] dP;
   byte[] a;
   private boolean[] dQ;
   private Random dR;
   private long dS;
   private long dT;
   private long dU;
   private long dV;
   private long dW;
   private long dX;
   private long dY;
   private int dZ;
   private int ea;
   private boolean eb;
   private boolean ec;
   private int[] ed;
   private boolean ee;
   private int ef;
   private int eg;
   private int[][] eh;
   private int[] ei;
   private int ej;
   private int ek;
   private int el;
   private int em;
   private int en;
   private int eo;
   private int ep;
   private int eq;
   private int er;
   private boolean es;
   private boolean et;
   private boolean eu;
   private int[] ev;
   private int[] ew;
   private int[][] ex;
   private Timer ey;
   private int ez;
   private int eA;
   private int eB;
   private long eC;
   private long eD;
   private long eE;
   private long eF;
   private long eG;
   private long eH;
   private long eI;
   private long eJ;
   private int eK;
   private int eL;
   private int eM;
   private int eN;
   private int eO;
   private int eP;
   private int eQ;
   private int eR;
   private int eS;
   private int eT;
   private int eU;
   private int eV;
   private int eW;
   private int eX;
   private int eY;
   private int eZ;
   private int fa;
   private int fb;
   private int fc;
   private int fd;
   private int fe;
   private int ff;
   private int fg;
   private int fh;
   private int fi;
   private int selectedMap;
   private int fk;
   private byte fl;
   private byte fm;
   private byte fn;
   private byte fo;
   private byte fp;
   private byte fq;
   private boolean fr;
   private boolean fs;
   private boolean ft;
   private boolean fu;
   private boolean fv;
   private boolean fw;
   private boolean fx;
   private boolean fy;
   private long[] fz;
   private int[] fA;
   private int[] fB;
   private int[] fC;
   private short[] fD;
   private short[][] fE;
   private byte[] fF;
   private byte[][] fG;
   private byte[][] fH;
   private int fI;
   private boolean fJ;
   private int fK;
   private int fL;
   private int fM;
   private boolean fN;
   private long fO;
   private long fP;
   private long fQ;
   private long fR;
   private long fS;
   private long fT;
   private long fU;
   private long fV;
   private long fW;
   private long fX;
   private boolean[] fY;
   private boolean[] fZ;
   private int ga;
   private int gb;
   private int gc;
   private long gd;
   private long ge;
   private boolean gf;
   private boolean gg;
   private long gh;
   private long gi;
   private int gj;
   private int gk;
   private int gl;
   private int gm;
   private int gn;
   private int go;
   private int gp;
   private int gq;
   private int gr;
   private int gs;
   private int gt;
   private int gu;
   private int gameLogoW;
   private int gameLogoH;
   private int companyLogoW;
   private int companyLogoH;
   private boolean gz;
   private boolean gA;
   private boolean gB;
   private boolean gC;
   private boolean gD;
   private boolean gE;
   private boolean gF;
   private int[][] letterImages;
   private int[] gH;
   private int[] gameLogoImage;
   private int[] gJ;
   private int[] gK;
   private int[] gL;
   private int[] gM;
   private int[] gN;
   private short[] gO;
   private byte[] gP;
   private String gQ = "ввести номер";
   private String gR = "ввести номер";
   private String gS;
   private String gT;
   private String[] gU;
   private byte[][] gV = new byte[1][];
   private byte[][] gW;
   private byte[][] gX = new byte[1][];
   private byte[][] gY;
   private byte[][] gZ = new byte[1][];
   private int ha;
   private int hb;
   private String[][] hc = new String[][]{{" активация", " серийный номер", " выбор страны", " назад"}, {"для активации", "нажми", "активировать", "либо", "отправь sms", "с кодом", "активации", "", " далее"}, {"на номер ", "стоимость sms:", "", "", " активировать", " код активации", " серийный номер", " выбор страны", " назад в меню"}, {"sms успешно", "отправлено.", "в течение", "пары минут", "ты получишь sms", "содержащее", "серийный номер.", "", " далее"}, {"для завершения", "активации", "введи в", "соответствующем", "пункте меню", "полученный", "серийный номер.", "", " ок"}, {"введи серийный", "номер:", " ", " ок", " отмена", " очистить"}, {"регистрация", "завершена", "успешно", "", " ок"}, {"введен", "неверный", "серийный номер.", "ввести", "еще раз?", "", " да", " нет"}, {"выбери свою", "страну:"}, {"для продолжения", "игры необходимо", "активировать", "игру.", "активировать", "сейчас?", "", " да", " нет"}, {"подари друзьям", "бесплатную", "ссылку на игру", " ", " отправить", " очистить", " назад в меню"}, {"игра успешно", "отправлена.", "", " ок"}, {"качай новые", "игры бесплатно", "на нашем сайте", "", " перейти", " назад в меню"}};
   private byte[][] hd = new byte[][]{{0, 3}, {8, 8}, {4, 8}, {8, 8}, {8, 8}, {2, 5}, {4, 4}, {6, 7}, {2, 2}, {7, 8}, {3, 6}, {3, 3}, {4, 5}};
   private byte he;
   private byte hf;
   private byte hg;
   private byte hh;
   private byte hi;
   private byte hj;
   private boolean hk = true;
   private boolean hl;
   private byte[][][] hm;
   private int hn = 0;
   Display b;
   private String[] ho = new String[]{"0", "1", "2", "3", "x", "4", "5", "6", "y", "7", "s"};
   private Player hp;
   private VolumeControl hq;
   private InputStream hr;
   private int[] hs;
   private int ht;
   private int hu;
   private boolean hv;
   private RecordStore hw;
   private int[] hx;
   private int[] hy;
   private int[] hz;
   private int hA;

   public a() {
      this.setFullScreenMode(true);
      this.dR = new Random();
      this.ey = new Timer();
      this.gi = System.currentTimeMillis();
      this.b = Display.getDisplay(Bunker3D.b());
      this.d = Bunker3D.b().a();
      this.gS = GlomoReg.i.b().d().toLowerCase();
      this.gT = GlomoReg.i.b().e().toLowerCase();
      this.R();
      this.gX[0] = this.b(this.gS);
      this.gZ[0] = this.b(this.gR);
      this.gV[0] = this.b(this.gQ);
      this.c = (byte)(GlomoReg.i.e() ? 0 : 1);
      this.fg = 1;
      this.fN = false;
      this.companyLogoW = 0;
      this.companyLogoH = 0;
      this.gameLogoW = 0;
      this.gameLogoH = 0;
      this.Z();
      this.a(this.hc);
      this.fY = new boolean[10];
      this.fZ = new boolean[10];
      this.hs = new int[3];
      this.hv = true;
      this.hA = 0;

      try {
         this.ab();
      } catch (Exception var2) {
      }
   }

   public final void paint(Graphics var1) {
      this.h(var1);
      if (this.fg == 3 && !this.fw) {
         if (this.gA) {
            this.a(false, var1);
         }

         if (this.gB && this.gF) {
            d(var1);
            this.gC = true;
            if (this.gD) {
               this.gD = false;
            }
         } else {
            if (this.gB && this.gC) {
               var1.setColor(0, 0, 0);
               var1.fillRect(0, 0, 240, 44);
               var1.fillRect(0, 256, 240, 44);
               this.gC = false;
            }

            this.b(var1);
         }
      }

      int var2;
      if (this.fg == 3 && this.fw) {
         this.E();
         d(var1);
         int var3 = this.gL[22];
         int var4 = this.gK[22] + this.selectedMap;

         for(var2 = this.gK[22]; var2 < var4; ++var2) {
            var3 += this.t[var2];
         }

         this.a(var3, var4, var4, 240 - this.t[var2] * 15 >> 1, 6, var1);
         this.a(true);
         this.c(true);
         this.fy = true;
         this.fw = false;
      }

      label83: {
         a var10000;
         byte var10001;
         if (this.gB && this.gF && !this.fy) {
            this.gm = 17 + (this.gu >> 2);
            var2 = this.gm == 17 ? 20 : (this.gm == 18 ? 40 : 33);
            this.a(this.gL[this.gm], this.gK[this.gm], this.gK[this.gm] + this.s[this.gm] - 1, var2, 6, var1);
            var10000 = this;
            var10001 = 0;
         } else {
            if (!this.gB || this.fy) {
               break label83;
            }

            var10000 = this;
            var10001 = 44;
         }

         var10000.b(var10001, (Graphics)var1);
      }

      this.ey.schedule(new b(this, (c)null), 0L);
   }

   private int a() {
      return abs(this.F());
   }

   private void a(Graphics var1) {
      var1.setColor(128, 128, 128);
      int var2 = this.a() % (this.g + 1);
      int var3 = this.gB ? this.h + 44 : this.h;

      for(int var4 = 0; var4 < var2; ++var4) {
         int var5 = this.a() % 240;
         int var6 = this.a() % (300 - (var3 << 1)) + var3;
         int var7 = var5 + this.F() % this.h;
         int var8 = var6 + this.F() % this.h;
         var1.drawLine(var5, var6, var7, var8);
      }

   }

   private void b(Graphics var1) {
      a var10000;
      if (this.fr) {
         this.fs = true;
         this.b.numColors();
         boolean var3 = false;
         Runtime.getRuntime().totalMemory();
         this.eW = 6;
         this.eU = 12;
         this.eV = 3;
         this.fI = var1.getClipHeight();
         if (this.FOE_METADATA == null) {
            this.readMetadata();
         }

         this.s();
         this.loadMap();
         this.n();
         this.t();
         this.dN = new short[7][];

         for(int var2 = 0; var2 < 7; ++var2) {
            this.w(var2);
         }

         this.p();
         if (this.gB) {
            this.fk = 0;
         }

         this.dD = new d(this, this.dN[this.fk][0], (c)null);

         for(int var6 = 1; var6 < this.dN[this.fk].length; ++var6) {
            d.a(this.dD, this.dN[this.fk][var6]);
         }

         this.q();
         this.es = false;
         this.ej = this.ek;
         this.en = 0;
         if (!this.gB) {
            this.a(true, var1);
         }

         this.o();
         this.u();
         this.ft = false;
         this.fu = false;
         this.fh = -1;
         this.fi = -1;
         this.eo = 0;
         this.ep = -1;
         this.et = true;
         this.ev = new int[9];
         this.ew = new int[9];
         this.ec = false;
         this.aq = -1;
         this.bN = -1;
         this.ar = -1;
         this.dC = false;
         if (this.gB) {
            d(var1);
         }

         this.fr = false;
         this.gF = true;
         this.eH = System.currentTimeMillis();
         this.fK = -10000;
         this.J();
         this.L();
         byte var10001;
         if (this.selectedMap == 1) {
            this.es = false;
            var10000 = this;
            var10001 = 1;
         } else {
            var10000 = this;
            var10001 = 6;
         }

         var10000.em = var10001;
         this.D(this.selectedMap);
         if (this.gB) {
            return;
         }
      }

      this.gA = false;
      if (this.ec) {
         this.e(var1);
      } else {
         if (this.bn == null) {
            this.bn = new int['챪'];
         }

         int var12;
         int var10004;
         if (this.et && !this.gB) {
            Image var7;
            Image var9;
            int[] var10;
            short var10005;
            short var10006;
            boolean var10007;
            label135: {
               this.ex = new int[9][];
               var7 = this.readImage("/w" + this.dataExt);
               this.ev[0] = this.m[this.ek * 8 + 2];
               this.ew[0] = this.m[this.ek * 8 + 3];
               this.ex[0] = new int[this.ev[0] * this.ew[0]];
               this.a(var7, this.ex[0], this.ev[0], this.ew[0], this.m[this.ek * 8], this.m[this.ek * 8 + 1], false);
               this.ev[1] = this.m[this.ek * 8 + 4 + 2];
               this.ew[1] = this.m[this.ek * 8 + 4 + 3];
               this.ex[1] = new int[this.ev[1] * this.ew[1]];
               this.a(var7, this.ex[1], this.ev[1], this.ew[1], this.m[this.ek * 8 + 4], this.m[this.ek * 8 + 4 + 1], false);
               int[][] var10002;
               byte var10003;
               if (this.ek == 0) {
                  this.ex[2] = new int[this.ev[0] * this.ew[0]];
                  this.a(var7, this.ex[2], this.ev[0], this.ew[0], this.m[this.ek * 8], this.m[this.ek * 8 + 1], true);
                  this.ex[3] = new int[this.ev[1] * this.ew[1]];
                  var10000 = this;
                  var9 = var7;
                  var10002 = this.ex;
                  var10003 = 3;
               } else {
                  if (this.ek == 1) {
                     this.ev[2] = this.m[26];
                     this.ew[2] = this.m[27];
                     this.ex[2] = new int[this.ev[2] * this.ew[2]];
                     var10000 = this;
                     var9 = var7;
                     var10 = this.ex[2];
                     var12 = this.ev[2];
                     var10004 = this.ew[2];
                     var10005 = this.m[24];
                     var10006 = this.m[25];
                     var10007 = false;
                     break label135;
                  }

                  this.ex[2] = new int[this.ev[1] * this.ew[1]];
                  var10000 = this;
                  var9 = var7;
                  var10002 = this.ex;
                  var10003 = 2;
               }

               var10 = var10002[var10003];
               var12 = this.ev[1];
               var10004 = this.ew[1];
               var10005 = this.m[this.ek * 8 + 4];
               var10006 = this.m[this.ek * 8 + 4 + 1];
               var10007 = true;
            }

            var10000.a(var9, var10, var12, var10004, var10005, var10006, var10007);
            if (this.ek == 2) {
               this.ev[4] = this.m[26];
               this.ew[4] = this.m[27];
               this.ex[4] = new int[this.ev[4] * this.ew[4]];
               this.a(var7, this.ex[4], this.ev[4], this.ew[4], this.m[24], this.m[25], false);
            }

            this.ev[6] = this.m[30];
            this.ew[6] = this.m[31];
            this.ex[6] = new int[this.ev[6] * this.ew[6]];
            this.a(var7, this.ex[6], this.ev[6], this.ew[6], this.m[28], this.m[29], false);
            this.ev[7] = this.m[34];
            this.ew[7] = this.m[35];
            this.ex[7] = new int[this.ev[7] * this.ew[7]];
            this.a(var7, this.ex[7], this.ev[7], this.ew[7], this.m[32], this.m[33], false);
            this.ev[8] = this.m[38];
            this.ew[8] = this.m[39];
            this.ex[8] = new int[this.ev[8] * this.ew[8]];
            this.a(var7, this.ex[8], this.ev[8], this.ew[8], this.m[36], this.m[37], false);
            this.c(var1);
            this.et = false;
         }

         this.bo = new int[2][240];
         this.bC = new boolean[240];
         this.bx = new byte[240];
         this.ay = -1;
         this.az = 240;
         this.f();
         this.eI = (this.fz[0] << 16) / 75000L;
         this.eJ = (this.fz[1] << 16) / 75000L;
         this.e();
         this.a(this.dD);
         if (!this.gB) {
            int var8 = this.ci[this.fk].length;
            if (this.selectedMap != 9) {
               this.bH = 0;
               this.bO = false;
               this.z(var8);
            }

            this.bH = 0;
            this.bO = true;
            this.z(var8);
         }

         if (!this.gB && this.fv) {
            this.C();
         }

         if (this.eK < this.fi) {
            this.D();
         }

         var1.drawRGB(this.bn, 240 * (3 - this.gc), 240, 0, 44, 240, 212, false);
         if (!this.gB) {
            if (this.eL != this.fh) {
               this.a(this.eL, 189, (Graphics)var1);
            }

            if (this.eK != this.fi) {
               this.a(this.eK, 6, (Graphics)var1);
            }
         }

         if (!this.gB) {
            int var11;
            int var13;
            if (this.eq == 53 && this.eL > 0) {
               if (this.ek == 1) {
                  var10000 = this;
                  var11 = this.ek;
                  var13 = this.en;
                  var12 = 0;
                  var10004 = this.en * 2;
               } else {
                  if (this.ek == 2) {
                     var10000 = this;
                     var11 = this.ek;
                     var13 = this.en;
                     var12 = 0;
                  } else if (this.en == 0) {
                     var10000 = this;
                     var11 = this.ek;
                     var13 = 0;
                     var12 = 0;
                  } else if (this.eu) {
                     var10000 = this;
                     var11 = this.ek;
                     var13 = this.en;
                     var12 = 0;
                  } else {
                     var10000 = this;
                     var11 = this.ek;
                     var13 = 0;
                     var12 = this.en;
                  }

                  var10004 = 0;
               }
            } else {
               var10000 = this;
               var11 = this.ek;
               var13 = 0;
               var12 = 0;
               var10004 = this.eo;
            }

            var10000.a(var11, var13, var12, var10004, var1);
         }

         if (this.ft) {
            var1.drawRGB(this.fA, 0, 28, 210, 224, 28, 30, false);
         }

         if (this.fu) {
            var1.drawRGB(this.fB, 0, 26, 2, 228, 26, 26, false);
         }

         this.fh = this.eL;
         this.fi = this.eK;
         if (this.ee) {
            this.ef = this.eg % 4;
            this.a(this.ef, var1);
            this.eK -= this.fq;
            if (this.eK <= 0 && !this.ec) {
               this.eK = 0;
               this.G();
               this.eK = this.eM;
               this.eL = this.eN;
               this.ek = this.eO;
               return;
            }

            if (this.eg == 23) {
               this.eg = 0;
               this.ee = false;
               this.ef = 0;
               return;
            }

            ++this.eg;
         }

      }
   }

   private void b() {
      this.eh = new int[4][];

      int var2;
      for(var2 = 0; var2 < 4; ++var2) {
         this.eh[var2] = new int[480];
      }

      for(var2 = 0; var2 < 4; ++var2) {
         for(int var3 = 0; var3 < 240; var3 += 2) {
            this.eh[var2][var3 + 1] = -16777216 + ((var2 << 5) + 50 << 8 | 0 | 0);
            this.eh[var2][var3 + 240] = -16777216 + ((var2 << 5) + 50 << 8 | 0 | 0);
         }
      }

   }

   private void a(int var1, Graphics var2) {
      for(int var3 = 44; var3 < 256; var3 += 2) {
         var2.drawRGB(this.eh[var1], 0, 240, 0, var3, 240, 2, true);
      }

   }

   private static short readShort(byte[] data, int offset) {
      return (short)(data[offset] & 255 | (data[offset + 1] & 255) << 8);
   }

   private byte[] readBinary(String fileName) {
      try {
         InputStream fileStream = this.getClass().getResourceAsStream(fileName);
         // Read the file length (2 bytes)
         int lengthLowByte = fileStream.read() & 255;
         int lengthHighByte = fileStream.read() & 255;
         int fileLength = lengthLowByte | lengthHighByte << 8;

         byte[] fileData = new byte[fileLength];
         fileStream.read(fileData, 0, fileData.length);
         return fileData;
      } catch (Exception var5) {
         return null;
      }
   }

   private void readMetadata() {
      int pos = 0;
      byte[] metadataFile = this.readBinary("/a" + this.dataExt);
      short[] header = new short[12];

      int i;
      for(i = 0; i < 12; ++i) {
         header[i] = readShort(metadataFile, pos);
         pos += 2;
      }

      short length = header[0];
      this.FOE_METADATA = new short[length];

      for(i = 0; i < length; ++i) {
         this.FOE_METADATA[i] = readShort(metadataFile, pos);
         pos += 2;
      }

      length = header[1];
      this.l = new short[length];

      for(i = 0; i < length; ++i) {
         this.l[i] = (short)metadataFile[pos];
         ++pos;
      }

      length = header[2];
      this.n = new byte[length];

      for(i = 0; i < length; ++i) {
         this.n[i] = metadataFile[pos];
         ++pos;
      }

      length = header[3];
      this.o = new byte[length];

      for(i = 0; i < length; ++i) {
         this.o[i] = metadataFile[pos];
         ++pos;
      }

      length = header[4];
      this.p = new byte[length];

      for(i = 0; i < length; ++i) {
         this.p[i] = metadataFile[pos];
         ++pos;
      }

      length = header[5];
      this.q = new byte[length];

      for(i = 0; i < length; ++i) {
         this.q[i] = metadataFile[pos];
         ++pos;
      }

      length = header[6];
      this.m = new short[length];

      for(i = 0; i < length; ++i) {
         short[] var10000;
         int var10001;
         int var10002;
         if (metadataFile[pos] >= 0) {
            var10000 = this.m;
            var10001 = i;
            var10002 = metadataFile[pos];
         } else {
            var10000 = this.m;
            var10001 = i;
            var10002 = 256 + metadataFile[pos];
         }

         var10000[var10001] = (short)(var10002 * 2);
         ++pos;
      }

      length = header[7];
      this.r = new byte[length];

      for(i = 0; i < length; ++i) {
         this.r[i] = metadataFile[pos];
         ++pos;
      }

      length = header[8];
      this.s = new byte[length];

      for(i = 0; i < length; ++i) {
         this.s[i] = metadataFile[pos];
         ++pos;
      }

      length = header[9];
      this.t = new byte[length];

      for(i = 0; i < length; ++i) {
         this.t[i] = metadataFile[pos];
         ++pos;
      }

      length = header[10];
      this.u = new byte[length];

      for(i = 0; i < length; ++i) {
         this.u[i] = metadataFile[pos];
         ++pos;
      }

      length = header[11];
      this.a = new byte[length];

      for(i = 0; i < length; ++i) {
         this.a[i] = metadataFile[pos];
         ++pos;
      }

   }

   private void loadMap() {
      boolean var3 = false;
      int selectedMapFileIdx = this.selectedMap == 0 ? 1 : this.selectedMap;
      byte[] mapFile = this.readBinary(this.mapFiles[selectedMapFileIdx - 1] + this.dataExt);
      short headerNumberA = readShort((byte[])mapFile, 0);
      short headerNumberB = readShort((byte[])mapFile, 2);
      short headerNumberC = readShort((byte[])mapFile, 4);
      this.loadedMap = new byte[6][];
      int lump0Size = headerNumberA * 4;
      this.loadedMap[0] = new byte[lump0Size];
      int pos = 6;
      int i;

      for (i = 0; i < lump0Size; i += 4) {
         byte highNibble1 = (byte) ((mapFile[pos + 1] & 0xF0) >> 4);
         byte lowNibble1 = (byte) (mapFile[pos + 1] & 0x0F);

         byte highNibble2 = (byte) ((mapFile[pos] & 0xF0) >> 4);
         byte lowNibble2 = (byte) (mapFile[pos] & 0x0F);

         loadedMap[0][i] = highNibble1;
         loadedMap[0][i + 1] = lowNibble1;
         loadedMap[0][i + 2] = highNibble2;
         loadedMap[0][i + 3] = lowNibble2;

         pos += 2;
      }

      // this.lumpsSizes = {5, 72, 10, 8}
      this.loadedMap[1] = new byte[this.lumpsSizes[0]];
      this.unusedMapRawLump1 = new short[5];
      byte size = this.lumpsSizes[0]; // 5

      for(i = 0; i < size; ++i) {
         short rawValue = readShort(mapFile, pos);
         this.unusedMapRawLump1[i] = rawValue;
         int value;
         if (rawValue >= 128) {
            value = 127 - rawValue;
         } else {
            value = rawValue;
         }
         this.loadedMap[1][i] = (byte)value;
         pos += 2;
      }

      this.loadedMap[2] = new byte[headerNumberB];

      for(i = 0; i < headerNumberB; ++i) {
         this.loadedMap[2][i] = mapFile[pos];
         ++pos;
      }

      size = this.lumpsSizes[1]; // 72
      this.loadedMap[3] = new byte[size];

      for(i = 0; i < size; ++i) {
         this.loadedMap[3][i] = mapFile[pos];
         ++pos;
      }

      this.loadedMap[4] = new byte[headerNumberC];

      for(i = 0; i < headerNumberC; ++i) {
         this.loadedMap[4][i] = mapFile[pos];
         ++pos;
      }

      size = this.lumpsSizes[2]; // 10
      this.loadedMap[5] = new byte[size];

      for(i = 0; i < size; ++i) {
         this.loadedMap[5][i] = mapFile[pos];
         ++pos;
      }

      short[] footer = new short[size = this.lumpsSizes[3]]; // 8

      for(i = 0; i < size; ++i) {
         footer[i] = readShort(mapFile, pos);
         pos += 2;
      }

      this.a(footer);
      this.q = null;
      this.E = (byte[][][][])null;
      this.M = null;
      System.gc();
   }

   private void a(short[] footer) {
      this.E = new byte[3][][][];
      this.loadMapPart((byte[])this.loadedMap[0], (byte[])this.loadedMap[1], (byte[])this.o, 0);
      this.loadMapPart((byte[])this.loadedMap[2], (byte[])this.loadedMap[3], (byte[])this.p, 1);
      this.modifyBigLumps01(this.E[0], this.E[1]);
      this.modifyBigLump1(this.E[1]);
      if (!this.gB) {
         this.loadMapPart((byte[])this.loadedMap[4], (byte[])this.loadedMap[5], (byte[])this.n, 2);
         this.b(this.E[2]);
         // E[2][0] - palettes ?
         this.readFoe(this.E[2]);
         this.d(this.E[2]);
      }

      this.loadedMap = (byte[][])null;
      this.E[2] = (byte[][][])null;
      this.c(false);
      System.gc();
      this.b(footer);
      this.a(this.E[0], this.E[1], footer);
      this.gf = false;
      this.M();
      if (this.selectedMap == 9) {
         this.b();
      }

      this.eg = 0;
      this.ee = false;
      this.ef = 0;
   }

   private void loadMapPart(byte[] lumpA, byte[] lumpB, byte[] mapMetadata, int E_idx) {
      int pos = 0;
      int lumpBSize = lumpB.length;
      this.E[E_idx] = new byte[lumpBSize][][];

      for(int i = 0; i < lumpBSize; ++i) {
         int lumpFragmentSize = lumpB[i] < 0 ? 127 - lumpB[i] : lumpB[i];
         this.E[E_idx][i] = new byte[lumpFragmentSize][mapMetadata[i]];

         for(int j = 0; j < lumpFragmentSize; ++j) {
            byte var11 = mapMetadata[i];

            for(int k = 0; k < var11; ++k) {
               this.E[E_idx][i][j][k] = lumpA[pos];
               ++pos;
            }
         }
      }
   }

   private void modifyBigLumps01(byte[][][] bigLump0, byte[][][] bigLump1) {
      boolean var3 = false;
      int lineSeqIdx = 0;
      int lineIdx = 0;
      int totalNumberOfLines = bigLump0[0].length + bigLump1[7].length + bigLump1[12].length * 4 + bigLump1[20].length * 3 + bigLump1[33].length * 4 + bigLump1[41].length * 4;

      int length = bigLump1[51].length + 1;
      this.bi = new int[length];
      this.bi[0] = totalNumberOfLines;

      int i;
      for(i = 1; i < length; ++i) {
         this.bi[i] = this.bi[i - 1] + bigLump1[51][i - 1][2];
      }

      totalNumberOfLines = this.bi[i - 1];
      this.initMapArrays(totalNumberOfLines);
      this.bz = new byte[totalNumberOfLines];
      length = bigLump1[31].length;

      for(i = 0; i < length; ++i) {
         this.bz[bigLump1[31][i][0] + 128] = bigLump1[31][i][1];
      }

      length = bigLump0[0].length;
      int var8 = bigLump1[7].length;

      for(i = 0; i < length; ++i) {
         if (lineSeqIdx < var8 && lineIdx == bigLump1[7][lineSeqIdx][0] + 128) {
            if (lineSeqIdx != 0) {
               this.cW[2][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][1];
               this.cW[3][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][2];
            }

            this.cW[0][lineIdx] = bigLump1[7][lineSeqIdx][1];
            this.cW[1][lineIdx] = bigLump1[7][lineSeqIdx][2];
            ++lineSeqIdx;
            ++lineIdx;
         }

         long var13 = (long)(bigLump0[0][i][0] - 7);
         long var15 = (long)(bigLump0[0][i][1] - 7);
         this.cW[0][lineIdx] = (int)(var13 + (long)this.cW[0][lineIdx - 1]);
         this.cW[1][lineIdx] = (int)(var15 + (long)this.cW[1][lineIdx - 1]);
         this.cW[2][lineIdx - 1] = this.cW[0][lineIdx];
         this.cW[3][lineIdx - 1] = this.cW[1][lineIdx];
         ++lineIdx;
      }

      this.cW[2][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][1];
      this.cW[3][lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][2];

      for(int var18 = 0; var18 < lineIdx; ++var18) {
         for(i = 0; i < 4; ++i) {
            int[] var10000 = this.cW[i];
            var10000[var18] <<= 16;
         }
      }

      this.eX = lineIdx;
      lineIdx = 0;
      lineSeqIdx = 0;
      this.cX = new byte[totalNumberOfLines];
      length = bigLump0[1].length;
      int var9 = bigLump1[7].length;
      int var10 = bigLump1[10].length;

      int var5;
      int var6;
      for(i = 0; i < length; ++i) {
         var8 = bigLump0[1][i].length;

         label159:
         for(var5 = 0; var5 < var8; ++var5) {
            if (lineSeqIdx < var9 && lineIdx == bigLump1[7][lineSeqIdx][0] + 128) {
               if (lineSeqIdx != 0) {
                  this.cX[lineIdx - 1] = bigLump1[7][lineSeqIdx - 1][4];
               }

               this.cX[lineIdx] = bigLump1[7][lineSeqIdx][3];
               ++lineSeqIdx;
               ++lineIdx;
            }

            int var10001;
            byte[] var10002;
            byte[] var19;
            int var10003;
            if (bigLump0[1][i][var5] == 15) {
               var6 = 0;

               while(true) {
                  if (var6 >= var10) {
                     continue label159;
                  }

                  if (bigLump1[10][var6][0] + 128 == lineIdx) {
                     var19 = this.cX;
                     var10001 = lineIdx;
                     var10002 = bigLump1[10][var6];
                     var10003 = 1;
                     break;
                  }

                  ++var6;
               }
            } else {
               var19 = this.cX;
               var10001 = lineIdx;
               var10002 = bigLump0[1][i];
               var10003 = var5;
            }

            var19[var10001] = var10002[var10003];
            ++lineIdx;
         }
      }

      this.cX[lineIdx - 1 - bigLump1[8][0][4]] = bigLump1[7][lineSeqIdx - 1][4];
      length = bigLump0[2].length;
      var8 = bigLump1[29].length;

      for(i = 0; i < length; ++i) {
         for(var5 = 0; var5 < 5; ++var5) {
            if (bigLump0[2][i][var5] != 15) {
               if (bigLump0[2][i][var5] == 7) {
                  bigLump0[2][i][var5] = -7;
               } else if (bigLump0[2][i][var5] != 0) {
                  bigLump0[2][i][var5] = (byte)(bigLump0[2][i][var5] - 7);
               }
            } else {
               for(var6 = 0; var6 < var8; ++var6) {
                  if (bigLump1[29][var6][0] == i && bigLump1[29][var6][1] == var5) {
                     bigLump0[2][i][var5] = bigLump1[29][var6][2];
                     break;
                  }
               }
            }
         }
      }

      for(i = 0; i < length; ++i) {
         var8 = bigLump0[2][i].length;

         for(var5 = 6; var5 < var8; ++var5) {
            bigLump0[2][i][var5] = (byte)(bigLump0[2][i][var5] * 3);
         }
      }

      length = bigLump0[3].length;

      for(i = 0; i < length; ++i) {
         for(var5 = 1; var5 <= 2; ++var5) {
            bigLump0[3][i][var5] = (byte)(bigLump0[3][i][var5] * 3);
         }
      }

      length = bigLump0[4].length;

      for(i = 0; i < length; ++i) {
         var8 = bigLump0[4][i].length;

         for(var5 = 0; var5 < var8; ++var5) {
            bigLump0[4][i][var5] = (byte)(bigLump0[4][i][var5] * 3);
         }
      }

   }

   private void modifyBigLump1(byte[][][] bigLump1) {
      this.cD = new short[7][];
      this.cE = new short[7][];
      this.fa = this.eX;
      this.fb = this.fa + 4 * bigLump1[12].length;
      this.fc = this.fb + 3 * bigLump1[20].length;

      int var2;
      int var3;
      int var6;
      int var10;
      int var12;
      int var14;
      int var10001;
      int var10002;
      for(var2 = 0; var2 < 7; ++var2) {
         var12 = bigLump1[var2].length + bigLump1[var2 + 13].length + bigLump1[var2 + 21].length + bigLump1[var2 + 42].length + bigLump1[var2 + 52].length;
         this.cD[var2] = new short[var12];
         this.cE[var2] = new short[var12];
         var10 = bigLump1[var2].length;

         for(var3 = 0; var3 < var10; ++var3) {
            this.cD[var2][var3] = (short)(bigLump1[var2][var3][0] + 128);
            this.cE[var2][var3] = (short)(bigLump1[var2][var3][1] + 128);
         }

         var10 = bigLump1[var2 + 13].length + var3;

         byte var13;
         short[] var10000;
         for(var6 = var3; var6 < var10; ++var6) {
            var13 = bigLump1[var2 + 13][var6 - var3][0];
            this.cD[var2][var6] = (short)(this.fa + var13 * 4);
            this.cE[var2][var6] = (short)(this.cD[var2][var6] + 3);
            if (abs(var14 = bigLump1[12][var13][3] % 90) <= 3) {
               var10000 = this.cE[var2];
               var10001 = var6;
               var10002 = var10000[var6] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cD[var2];
               var10001 = var6;
               var10002 = var10000[var6] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[12][var13][3] = (byte)(bigLump1[12][var13][3] - var14);
         }

         var10 = bigLump1[var2 + 21].length + var6;

         int var7;
         for(var7 = var6; var7 < var10; ++var7) {
            this.cD[var2][var7] = (short)(this.fb + abs(bigLump1[var2 + 21][var7 - var6][0]) % 60 * 3);
            this.cE[var2][var7] = (short)(this.cD[var2][var7] + 2);
            if (bigLump1[var2 + 21][var7 - var6][0] < 0) {
               var10000 = this.cD[var2];
               var10001 = var7;
               var10002 = var10000[var7] + 2;
            } else {
               if (bigLump1[var2 + 21][var7 - var6][0] < 60) {
                  continue;
               }

               var10000 = this.cE[var2];
               var10001 = var7;
               var10002 = var10000[var7] - 2;
            }

            var10000[var10001] = (short)var10002;
         }

         var10 = bigLump1[var2 + 42].length + var7;

         int var8;
         for(var8 = var7; var8 < var10; ++var8) {
            var13 = bigLump1[var2 + 42][var8 - var7][0];
            this.cD[var2][var8] = (short)(this.fc + var13 * 4);
            this.cE[var2][var8] = (short)(this.cD[var2][var8] + 3);
            if (abs(var14 = bigLump1[41][var13][2] % 90) <= 3) {
               var10000 = this.cE[var2];
               var10001 = var8;
               var10002 = var10000[var8] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cD[var2];
               var10001 = var8;
               var10002 = var10000[var8] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[41][var13][2] = (byte)(bigLump1[41][var13][2] - var14);
         }

         var10 = bigLump1[var2 + 52].length + var8;

         for(int var9 = var8; var9 < var10; ++var9) {
            this.cD[var2][var9] = (short)this.bi[bigLump1[var2 + 52][var9 - var8][0]];
            this.cE[var2][var9] = (short)(this.bi[bigLump1[var2 + 52][var9 - var8][0] + 1] - 1);
         }
      }

      this.fillThisFields(bigLump1[8][0][0], (long)bigLump1[8][0][1] * 75000L, (long)bigLump1[8][0][2] * 75000L, bigLump1[8][0][3] * 2, bigLump1[8][0][7]);
      this.cC = (byte)(16 + bigLump1[8][0][5]);
      this.cB = bigLump1[8][0][6];
      var12 = this.eX;
      this.eY = bigLump1[12].length;
      int var24 = 48 + this.eY;
      this.cg = new byte[var24];
      this.bT = new int[var24][2];
      this.cm = new boolean[var24];
      this.cd = new byte[var24];
      this.ch = new byte[var24];
      var10 = bigLump1[12].length;

      byte[] var26;
      for(var3 = 0; var3 < var10; ++var3) {
         var14 = 128 + bigLump1[12][var3][0] << 16 >> 2;
         int var15 = 128 + bigLump1[12][var3][1] << 16 >> 2;
         var6 = 48 + var3;
         this.bT[var6][0] = var14;
         this.bT[var6][1] = var15;
         this.cg[var6] = (byte)(this.cC - 1);
         this.cm[var6] = false;
         this.cd[var6] = (byte)(this.cC + 2 + bigLump1[12][var3][4]);
         if (bigLump1[12][var3][4] > 3) {
            var26 = this.cd;
            var26[var6] = (byte)(var26[var6] - 4);
            this.ch[var6] = 1;
         }

         var12 = this.modifyBigLump1_subfunction1((long)var14, (long)var15, 16384L, 16384L, bigLump1[12][var3][3], var12, bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], (byte)1, (byte)0);
      }

      this.eZ = bigLump1[20].length;
      this.dp = new int[this.eZ][2];
      this.dr = new byte[this.eZ];
      this.ds = new byte[this.eZ];
      this.dv = new int[this.eZ];
      this.dw = new int[this.eZ];
      this.dt = new byte[this.eZ];
      this.dx = new int[this.eZ];
      this.dy = new int[this.eZ];
      this.dz = new int[this.eZ];
      this.dA = new int[this.eZ];
      this.dq = new int[this.eZ][2];
      this.dB = new int[this.eZ];
      this.du = new byte[this.eZ];
      var10 = bigLump1[20].length;

      for(var3 = 0; var3 < var10; ++var3) {
         this.dp[var3][0] = 128 + bigLump1[20][var3][0] << 16 >> 2;
         this.dp[var3][1] = 128 + bigLump1[20][var3][1] << 16 >> 2;
         byte var28;
         if (bigLump1[20][var3][2] * bigLump1[20][var3][3] >= 0) {
            this.dr[var3] = 0;
            var26 = this.ds;
            var10001 = var3;
            var28 = 1;
         } else {
            this.dr[var3] = 1;
            var26 = this.ds;
            var10001 = var3;
            var28 = 0;
         }

         var26[var10001] = var28;
         this.dv[var3] = (bigLump1[20][var3][2] << 16) / 127;
         this.dw[var3] = (bigLump1[20][var3][3] << 16) / 127;
         this.dt[var3] = bigLump1[59][var3][3];
         this.dz[var3] = 0;
         this.dA[var3] = 6225920;
         int[] var27;
         if (this.dw[var3] > 0) {
            var27 = this.dx;
            var10001 = var3;
            var10002 = 65536;
         } else {
            var27 = this.dx;
            var10001 = var3;
            var10002 = -65536;
         }

         var27[var10001] = var10002;
         this.dy[var3] = (this.dx[var3] - this.dw[var3]) / this.dt[var3];
         this.dq[var3][this.dr[var3]] = this.dp[var3][this.dr[var3]] + this.dx[var3];
         this.dq[var3][this.ds[var3]] = this.dp[var3][this.ds[var3]];
         this.dB[var3] = -1;
         this.du[var3] = bigLump1[28][var3][0];
         byte var10003;
         byte var30;
         byte var31;
         if (!this.gB || var3 != 0 && var3 != 1) {
            var30 = bigLump1[59][var3][0];
            var31 = bigLump1[59][var3][1];
            var10003 = bigLump1[59][var3][2];
         } else {
            var30 = 7;
            var31 = bigLump1[59][var3][1];
            var10003 = 7;
         }

         this.modifyBigLump1_subfunction2(var30, var31, var10003, var12);
         this.modifyBigLump1_subfunction3(this.dp[var3], (long)this.dv[var3], (long)this.dx[var3], this.dr[var3], this.ds[var3], var12, 0);
         var12 = this.modifyBigLump1_subfunction3(this.dp[var3], (long)this.dv[var3], (long)this.dw[var3], this.dr[var3], this.ds[var3], var12, 1);
      }

      this.eX = var12;
      this.bA = new byte[bigLump1[30].length * 7];
      this.bs = new short[32 + bigLump1[30].length];
      int var5 = 0;
      var10 = bigLump1[30].length;

      int var11;
      for(var3 = 0; var3 < var10; ++var3) {
         this.bs[32 + var3] = 96;
         var11 = bigLump1[30][var3].length;

         for(int var4 = 0; var4 < var11; ++var4) {
            this.bA[var5] = bigLump1[30][var3][var4];
            ++var5;
         }
      }

      var12 = this.eX;
      var10 = bigLump1[41].length;

      long var16;
      long var25;
      for(var3 = 0; var3 < var10; ++var3) {
         var25 = (long)(128 + bigLump1[41][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[41][var3][1] << 16 >> 2);
         long var18 = (long)((bigLump1[60][var3][0] << 16) / 42 >> 1);
         long var20 = (long)((bigLump1[60][var3][1] << 16) / 42 >> 1);
         var12 = this.modifyBigLump1_subfunction1(var25, var16, var18, var20, bigLump1[41][var3][2], var12, bigLump1[61][var3][0], bigLump1[61][var3][1], bigLump1[61][var3][2], bigLump1[61][var3][3], bigLump1[62][var3][0], bigLump1[62][var3][1]);
      }

      this.eX = var12;
      this.fG = new byte[2][];
      this.fH = new byte[2][];
      this.fE = new short[2][];
      this.modifyBigLump1_subfunction4(0, 49, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(1, 70, (byte[][][])bigLump1);
      var12 = this.eX;
      this.fd = var12;
      var10 = bigLump1[51].length;
      this.bh = new int[var10];

      for(var3 = 0; var3 < var10; ++var3) {
         var25 = (long)(128 + bigLump1[51][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[51][var3][1] << 16 >> 2);
         long var22 = (long)((bigLump1[51][var3][3] << 16) / 60);
         this.bh[var3] = bigLump1[51][var3][6];
         var12 = this.modifyBigLump1_subfunction5(var25, var16, bigLump1[51][var3][2], var22, var12, bigLump1[51][var3][4], bigLump1[51][var3][5], bigLump1[51][var3][7], bigLump1[51][var3][8]);
      }

      this.eX = var12;
      this.ci = new byte[7][];

      for(var2 = 63; var2 < 70; ++var2) {
         var10 = bigLump1[var2].length;
         var11 = bigLump1[var2 - 50].length;
         this.ci[var2 - 63] = new byte[var10 + var11];

         for(var3 = 0; var3 < var10; ++var3) {
            this.ci[var2 - 63][var3] = bigLump1[var2][var3][0];
         }

         var6 = var3;

         for(var3 = 0; var3 < var11; ++var3) {
            this.ci[var2 - 63][var6] = (byte)(48 + bigLump1[var2 - 50][var3][0]);
            ++var6;
         }
      }

   }

   private void modifyBigLump1_subfunction4(int var1, int var2, byte[][][] var3) {
      int var4 = var2;
      if (var3[var2].length != 0) {
         int var7 = var3[var2][0].length;
         this.fG[var1] = new byte[var7];

         for(int var6 = 0; var6 < var7; ++var6) {
            this.fG[var1][var6] = var3[var4][0][var6];
         }

         a var10000;
         byte var10001;
         if (this.fG[var1][1] != this.fG[var1][2]) {
            var10000 = this;
            var10001 = 2;
         } else {
            var10000 = this;
            var10001 = 1;
         }

         var10000.ff = var10001;
         int var8 = this.fG[var1][0] < 10 ? 128 : 299;
         var4 = var2 + 1;
         this.fE[var1] = new short[var3[var4].length];
         this.fH[var1] = new byte[var3[var4].length];
         var7 = var3[var4].length;

         for(int var5 = 0; var5 < var7; ++var5) {
            this.fE[var1][var5] = (short)(var3[var4][var5][0] + var8);
            this.fH[var1][var5] = 0;
         }

      }
   }

   private void b(byte[][][] var1) {
      int var5 = var1[4].length;
      this.bZ = new byte[var5];
      this.bW = new short[var5];
      this.ca = new byte[32];
      this.bX = new short[var5];
      this.cb = new byte[var5];
      this.cj = new boolean[var5];
      this.cc = new byte[var5];
      this.cl = new boolean[48 + this.eY];
      this.ce = new byte[var5];
      this.ck = new boolean[var5];
      this.cf = new byte[var5];
      this.z = new byte[var5];
      this.ei = new int[var5];

      int var2;
      for(var2 = 0; var2 < var5; ++var2) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (var1[4][var2][2] == -1) {
            var10000 = this.cg;
            var10001 = var2;
            var10002 = 10;
         } else {
            var10000 = this.cg;
            var10001 = var2;
            var10002 = 0;
         }

         var10000[var10001] = var10002;
         this.bT[var2][0] = 128 + var1[4][var2][0] << 16 >> 2;
         this.bT[var2][1] = 128 + var1[4][var2][1] << 16 >> 2;
         this.ei[var2] = -1;
         this.bZ[var2] = var1[4][var2][2];
         this.bW[var2] = (short)(var1[4][var2][3] * 2);
         this.ca[var2] = var1[4][var2][4];
         this.bX[var2] = (short)(var1[4][var2][5] + 128);
         this.cj[var2] = true;
         this.cc[var2] = 1;
         this.cb[var2] = 1;
         this.cl[var2] = false;
         this.cm[var2] = true;
         this.ch[var2] = var1[4][var2][6];
         this.cf[var2] = var1[4][var2][7];
         this.ck[var2] = false;
         byte var6;
         if (this.ca[var2] <= 0) {
            var10000 = this.z;
            var10001 = var2;
            var6 = (byte)(abs(this.F()) & 1);
         } else {
            var10000 = this.z;
            var10001 = var2;
            var6 = 0;
         }

         var10000[var10001] = var6;
         if (this.ca[var2] > 0 && (this.ca[var2] != 32 || this.selectedMap != 9)) {
            var10000 = this.ce;
            var10001 = var2;
            var10002 = 0;
         } else {
            var10000 = this.ce;
            var10001 = var2;
            var10002 = 100;
         }

         var10000[var10001] = var10002;
      }

      this.eP = var1[4].length;
      this.fl = var1[8][0][0];
      this.fm = var1[8][0][1];
      this.fn = var1[8][0][2];
      this.fp = var1[8][0][3];
      this.fo = var1[8][0][4];
      this.eQ = var1[7].length;
      int var3 = 16;
      int var4 = var1[7].length;

      for(var2 = 0; var2 < var4; ++var2) {
         this.cg[var3] = this.fl;
         this.bT[var3][0] = 128 + var1[7][var2][0] << 16 >> 2;
         this.bT[var3][1] = 128 + var1[7][var2][1] << 16 >> 2;
         this.ca[var3] = var1[7][var2][2];
         this.cm[var3] = true;
         this.ch[var3] = var1[7][var2][3];
         ++var3;
      }

      var3 = 32;
      var4 = var1[9].length;

      for(var2 = 0; var2 < var4; ++var2) {
         this.cg[var3] = var1[9][var2][0];
         this.bT[var3][0] = 128 + var1[9][var2][1] << 16 >> 2;
         this.bT[var3][1] = 128 + var1[9][var2][2] << 16 >> 2;
         this.cm[var3] = true;
         ++var3;
      }

   }

   private void a(short[] foeMData, int segNum, int offset) {
      this.foeW[segNum] = foeMData[offset + 2];
      this.foeH[segNum] = foeMData[offset + 3];
      int var4 = this.foeH[segNum] / foeMData[offset + 5];
      this.bq[foeMData[offset + 4]][segNum] = this.bq[foeMData[offset + 4]][this.M[foeMData[offset + 4]]];
      this.bq[foeMData[offset + 4]][this.M[foeMData[offset + 4]] + 1] = (short)(this.bq[foeMData[offset + 4]][this.M[foeMData[offset + 4]]] + this.foeW[segNum] * var4);
      int var10002 = this.M[foeMData[offset + 4]]++;
      this.bt[segNum] = foeMData[offset + 4];
      this.bu[segNum] = foeMData[offset + 5];
      this.bj[segNum] = (foeMData[offset + 5] << 16 >> 3) * this.foeW[segNum] / this.foeH[segNum];
      int[] var10000 = this.bj;
      var10000[segNum] >>= 1;
   }

   private void a(int var1, int var2, int[] var3) {
      a(this.de, this.df, this.bq[1][var1], this.foeW[var1], var2, 0, var3, false);
   }

   private void b(int var1, int var2, int[] var3) {
      a(this.cY, this.cZ, this.bq[0][var1], this.foeW[var1], var2, 0, var3, true);
      a(this.da, this.db, this.bq[0][var1], this.foeW[var1], var2, 4, var3, false);
      a(this.dc, this.dd, this.bq[0][var1], this.foeW[var1], var2, 2, var3, false);
   }

   private void c(int var1, int var2, int[] var3) {
      a(this.dg, this.dh, this.bq[this.bt[var1]][var1], this.foeW[var1], var2, 0, var3, true);
   }

   private void d(int var1, int var2, int[] var3) {
      a(this.di, this.dj, this.bq[this.bt[var1]][var1], this.foeW[var1], var2, 2, var3, false);
      a(this.dk, this.dl, this.bq[this.bt[var1]][var1], this.foeW[var1], var2, 0, var3, false);
   }

   private void e(int var1, int var2, int[] var3) {
      a(this.dm, this.dn, this.bq[this.bt[var1]][var1], this.foeW[var1], var2, 0, var3, true);
   }

   private void readFoe(byte[][][] var1) {
      Image layer1 = null;
      Image layer2 = null;
      layer1 = this.readImage("/e" + this.dataExt);
      layer2 = this.readImage("/ee" + this.dataExt);
      int[] tmp = new int[1];
      layer1.getRGB(tmp, 0, 1, 0, 0, 1, 1);
      this.BACKGROUND_COLOR = tmp[0];
      this.bq = new short[6][];
      this.M = new int[this.bq.length];
      int length = this.bq.length;
      int var3 = (16 + var1[5].length + 2) * 2;

      int offset;
      for(offset = 0; offset < length; ++offset) {
         this.bq[offset] = new short[var3];
         this.M[offset] = 16 + var1[5].length + 2;
         int var4 = this.bq[offset].length;

         for(int var11 = 0; var11 < var4; ++var11) {
            this.bq[offset][var11] = 0;
         }
      }

      int totalSegments = 16 + var1[5].length;
      this.bY = new short[totalSegments];
      this.bt = new short[totalSegments];
      this.bu = new short[totalSegments];
      this.bj = new int[totalSegments];
      this.foeW = new short[totalSegments];
      this.foeH = new short[totalSegments];
      int segNum = 0;
      length = this.FOE_METADATA.length;

      for(offset = 0; offset < length; offset += 7) {
         this.a(this.FOE_METADATA, segNum, offset);
         this.bY[segNum] = this.FOE_METADATA[offset + 6];
         ++segNum;
      }

      segNum = 16;
      length = var1[5].length;

      for(int var12 = 0; var12 < length; ++var12) {
         if ((offset = (var1[5][var12][0] >= 50 ? var1[5][var12][0] - 50 : var1[5][var12][0]) * 7) / 7 >= 8) {
            short[] var10000 = this.l;
            var10000[offset] = (short)(var10000[offset] << 1);
            var10000 = this.l;
            var10000[offset + 1] = (short)(var10000[offset + 1] << 1);
            var10000 = this.l;
            var10000[offset + 2] = (short)(var10000[offset + 2] << 1);
            var10000 = this.l;
            var10000[offset + 3] = (short)(var10000[offset + 3] << 1);
         }

         this.a(this.l, segNum, offset);
         this.bY[segNum] = this.l[offset + 6];
         ++segNum;
      }

      int var16 = this.bq[0][this.M[0]] + 10;
      int var17 = this.bq[1][this.M[1]] + 10;
      int var18 = this.bq[2][this.M[2]] + 10;
      int var19 = this.bq[3][this.M[3]] + 10;
      int var20 = this.bq[4][this.M[4]] + 10;
      this.a(var16, var17, var1[1].length, var18, var19, var20);
      segNum = 0;
      short var21 = 0;
      length = this.FOE_METADATA.length;

      for(offset = 0; offset < length; offset += 7) {
         int[] layer1Cut = new int[this.FOE_METADATA[offset + 2] * this.FOE_METADATA[offset + 3]];
         int[] layer2Cut = new int[this.FOE_METADATA[offset + 2] * this.FOE_METADATA[offset + 3]];
         layer1.getRGB(layer1Cut, 0, this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 0], this.FOE_METADATA[offset + 1], this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 3]);
         layer2.getRGB(layer2Cut, 0, this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 0], this.FOE_METADATA[offset + 1], this.FOE_METADATA[offset + 2], this.FOE_METADATA[offset + 3]);
         this.combineLayers(layer1Cut, layer2Cut, this.bp, var21, var1[0][0], var1[0][1]);
         var21 = (short)(var21 + 50);
         int var15 = this.foeH[segNum] / this.bu[segNum];
         if (this.bt[segNum] == 0) {
            this.b(segNum, var15, layer1Cut);
         } else if (this.bt[segNum] == 1) {
            this.a(segNum, var15, layer1Cut);
         }

         ++segNum;
      }

   }

   private void d(byte[][][] var1) {
      int[][] var8 = new int[var1[5].length][];
      int[][] var9 = new int[var1[5].length][];
      boolean var2 = false;
      int var7 = var1[5].length;

      int var4;
      for(int spriteFileNum = 0; spriteFileNum <= 1; ++spriteFileNum) {
         Image backLayer = this.readImage(this.spriteFiles[spriteFileNum] + this.dataExt);
         Image frontLayer = this.readImage(this.spriteFiles[spriteFileNum + 2] + this.dataExt);

         for(var4 = 0; var4 < var7; ++var4) {
            if (spriteFileNum == 0) {
               if (var1[5][var4][0] >= 50) {
                  continue;
               }
            } else {
               if (var1[5][var4][0] < 50) {
                  continue;
               }

               var1[5][var4][0] = (byte)(var1[5][var4][0] - 50);
            }

            int var3 = var1[5][var4][0] * 7;
            var8[var4] = new int[this.l[var3 + 2] * this.l[var3 + 3]];
            var9[var4] = new int[this.l[var3 + 2] * this.l[var3 + 3]];
            backLayer.getRGB(var8[var4], 0, this.l[var3 + 2], this.l[var3 + 0], this.l[var3 + 1], this.l[var3 + 2], this.l[var3 + 3]);
            if (var1[5][var4][0] == 26) {
               int var12 = this.l[var3 + 2] * this.l[var3 + 3];

               for(int var13 = 0; var13 < var12; ++var13) {
                  if (var8[var4][var13] != this.BACKGROUND_COLOR) {
                     var8[var4][var13] = 176;
                  }
               }
            } else {
               backLayer.getRGB(var8[var4], 0, this.l[var3 + 2], this.l[var3 + 0], this.l[var3 + 1], this.l[var3 + 2], this.l[var3 + 3]);
            }

            frontLayer.getRGB(var9[var4], 0, this.l[var3 + 2], this.l[var3 + 0], this.l[var3 + 1], this.l[var3 + 2], this.l[var3 + 3]);
         }
      }

      short var15 = 800;
      var7 = var1[5].length;

      for(var4 = 0; var4 < var7; ++var4) {
         this.combineLayers(var8[var4], var9[var4], this.bp, var15, var1[6][var4], var1[1][var4]);
         var15 = (short)(var15 + 50);
      }

      var7 = 16 + var1[5].length;

      for(int var14 = 16; var14 < var7; ++var14) {
         int var6 = this.foeH[var14] / this.bu[var14];
         if (this.bt[var14] == 0) {
            this.b(var14, var6, var8[var14 - 16]);
         } else if (this.bt[var14] == 1) {
            this.a(var14, var6, var8[var14 - 16]);
         } else if (this.bt[var14] == 2) {
            this.c(var14, var6, var8[var14 - 16]);
         } else if (this.bt[var14] == 3) {
            this.d(var14, var6, var8[var14 - 16]);
         } else if (this.bt[var14] == 4) {
            this.e(var14, var6, var8[var14 - 16]);
         }
      }

      this.F = (byte[][][])null;
      System.gc();
   }

   private void a(byte[][][] var1, byte[][][] var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = var2[9][var3][0];
      byte var9 = var1[2][var3][5];
      byte var10 = this.q[6 * var8];
      Image var11;
      if (this.P != var3 && var5 != var6) {
         if (var4 == 0) {
            if (var9 != 12) {
               this.C = this.readImage("/" + String.valueOf(var10) + this.dataExt);
            } else {
               var11 = this.readImage("/" + String.valueOf(var10) + this.dataExt);
               this.C = Image.createImage(var11, 0, 0, var11.getWidth(), var11.getHeight(), 5);
            }
         } else {
            this.D = this.readImage("/" + String.valueOf(var10) + this.dataExt);
         }
      }

      if (this.P != var3) {
         Image var10000;
         int[] var10001;
         if (var4 == 0) {
            var10000 = this.C;
            var10001 = this.I;
         } else {
            this.G = new int[this.K * this.L];
            var10000 = this.D;
            var10001 = this.G;
         }

         var10000.getRGB(var10001, 0, this.K, var1[4][var3][0], var1[4][var3][1], this.K, this.L);
         if (!this.gB) {
            a var15;
            if (var4 != 0) {
               var15 = this;
               var10001 = this.G;
            } else {
               var15 = this;
               var10001 = this.I;
            }

            var15.a(var10001, var1, var2, var3);
         }

         if (this.q[6 * var2[9][var3][0] + 5] == 2) {
            var11 = this.readImage("/" + String.valueOf(var10) + var10 + this.dataExt);
            int[] var14 = new int[9216];
            var11.getRGB(var14, 0, 96, 0, 0, 96, 96);
            this.b(this.I, var14, 0, 0, 96, 96, 96);
         }

         if (var4 == 0 && var7 == var3) {
            this.P = var3;
            this.H = new int[this.K * this.L];
            this.b(this.H, this.I, 0, 0, this.K, this.K, this.L);
         }

      } else {
         int var13 = this.H.length;

         for(int var12 = 0; var12 < var13; ++var12) {
            this.I[var12] = this.H[var12];
         }

      }
   }

   private void a(int[] var1, byte[][][] var2, byte[][][] var3, int var4) {
      byte var5 = var2[2][var4][0];
      byte var6 = var2[2][var4][1];
      byte var7 = var2[2][var4][2];
      byte var8 = var2[2][var4][3];
      byte var9 = var2[2][var4][4];
      boolean var10 = var3[9][var4][0] == 1 || var3[9][var4][0] == 11 || var3[9][var4][0] == 15;
      if (var5 != 0 || var6 != 0 || var7 != 0 || var8 != 0 || var9 != 0) {
         this.a(var1, var5, var6, var7, var8, var9, var10);
      }

   }

   private void a(byte[][][] E0, byte[][][] E1, short[] footer) {
      int var20 = 0;
      this.N = new int[E1[9].length][];
      this.O = new int[E1[9].length];
      int length = E1.length;

      int i;
      for(i = 0; i < length; ++i) {
         if (i != 9 && i != 32) {
            E1[i] = (byte[][])null;
         }
      }

      E0[0] = (byte[][])null;
      System.gc();
      length = E0[4].length;

      for(i = 0; i < length; ++i) {
         byte var24 = E1[9][i][0];
         if (E0[4][i][2] == 0) {
            E0[4][i][2] = this.q[6 * var24 + 3];
         }

         if (E0[4][i][3] == 0) {
            E0[4][i][3] = this.q[6 * var24 + 4];
         }
      }

      length = E1[9].length;

      int j;
      int[] var10001;
      int var10004;
      byte var10006;
      for(i = 0; i <= 1; ++i) {
         Image layer1 = this.readImage("/" + String.valueOf(i) + this.dataExt);
         Image layer2 = null;
         if (i == 0) {
            layer2 = this.readImage("/" + String.valueOf(i) + i + this.dataExt);
            int[] tmp = new int[1];
            layer1.getRGB(tmp, 0, 1, 0, 0, 1, 1);
            this.BACKGROUND_COLOR = tmp[0];
         }

         for(j = 0; j < length; ++j) {
            byte var36 = E1[9][j][0];
            byte var21 = this.q[6 * var36];
            int var22 = E0[4][j][2] * 2;
            int var23 = E0[4][j][3] * 2;
            if (var21 == i) {
               int var27;
               int var28;
               label153: {
                  this.N[var20] = new int[var22 * var23];
                  this.O[j] = var20;
                  var27 = (this.q[6 * var36 + 1] + E0[4][j][0]) * 2;
                  var28 = (this.q[6 * var36 + 2] + E0[4][j][1]) * 2;
                  layer1.getRGB(this.N[var20], 0, var22, var27, var28, var22, var23);
                  Image var10000;
                  byte var10002;
                  byte var10003;
                  int var10005;
                  byte var10007;
                  boolean var29;
                  if (E1[9][j][0] == 44) {
                     var29 = false;
                     this.fA = new int[840];
                     var10000 = layer1;
                     var10001 = this.fA;
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 2;
                     var10005 = var28;
                     var10006 = 28;
                     var10007 = 30;
                  } else {
                     if (E1[9][j][0] != 39) {
                        break label153;
                     }

                     var29 = false;
                     this.fB = new int[676];
                     var10000 = layer1;
                     var10001 = this.fB;
                     var10002 = 0;
                     var10003 = 26;
                     var10004 = var27 + 4;
                     var10005 = var28 + 4;
                     var10006 = 26;
                     var10007 = 26;
                  }

                  var10000.getRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007);
               }

               if (!this.gB) {
                  this.a(this.N[var20], E0, E1, j);
               }

               if (this.q[6 * E1[9][j][0] + 5] == 2) {
                  int[] var37 = new int[var22 * var23];
                  layer2.getRGB(var37, 0, var22, var27, var28, var22, var23);
                  this.b(this.N[var20], var37, 0, 0, var22, var22, var23);
               }

               ++var20;
            }
         }
      }

      this.bl = new int[E0[3].length + 1];
      int var17 = 0;
      this.bl[0] = 0;
      this.bk = new int[E0[3].length + 1];
      this.br = new short[E0[3].length * 9];
      int var10 = footer[6] * 2 * 2;
      int var11 = footer[7] * 2 * 2;
      this.d(var10, var11);
      int var14 = 0;
      this.P = -1;
      byte var7 = -1;
      boolean var9 = false;
      length = E0[3].length;

      for(i = 0; i < length; ++i) {
         byte var8 = var7;
         byte var6 = E1[32][i][0];
         this.Q = E1[9][var6][0];
         byte var31 = i != length - 1 ? E1[32][i + 1][0] : -1;
         var7 = E1[9][var6][0];
         this.K = E0[4][var6][2] * 2;
         this.L = E0[4][var6][3] * 2;
         this.J = E0[2][var6][5];
         if (this.J >= 1 && this.J <= 5) {
            this.K *= 2;
         }

         if (this.J >= 4 && this.J <= 9) {
            this.L *= 2;
         }

         int var15 = this.K;
         int var16 = this.L;
         this.I = new int[var15 * var16];
         if (E0[3][i][3] != 1 && E0[3][i][3] != 2) {
            if (this.q[6 * var7] > 1) {
               this.a((byte[][][])E0, (byte[][][])E1, var6, 0, var8, var7, var31);
            } else {
               this.a(this.N[this.O[var6]], var15, E0[4][var6][2] * 2, E0[4][var6][3] * 2, E0[2][var6][5], 0, 0);
            }
         }

         int var12 = E0[3][i][1] * 2;
         int var13 = E0[3][i][2] == 0 ? this.K : E0[3][i][2] * 2;
         boolean var33 = false;
         int var34 = E0[3][i][0] == E0[3][i][1] ? var13 : (E0[3][i][3] != 2 ? this.K : 96);
         byte var35 = E0[3][i][0];
         if (E0[3][i][3] == 1) {
            var14 = this.a(E1[32][i][0], E1[32][i][1], (byte)i, (byte)var12, (byte)var13, (short)140, var14, (short)26, (byte)(var12 + 23));
         } else if (E0[3][i][3] == 2) {
            var14 = this.a(E1[32][i][0], E1[32][i][1], (byte)i, (byte)var12, (byte)var13, (short)((byte)var34), var14, (short)0, (byte)var12);
         } else {
            var14 = this.a((byte)var35, (byte)i, (byte)i, (byte)var12, (byte)var13, (short)((byte)var34), var14, (short)0, (byte)var12);

            for(j = 1; j <= 3 && E1[32][i][j] != var6; ++j) {
               var6 = E1[32][i][j];
               this.K = E0[4][var6][2] * 2;
               this.L = E0[4][var6][3] * 2;
               this.J = E0[2][var6][5];
               if (this.J >= 1 && this.J <= 5) {
                  this.K *= 2;
               }

               if (this.J >= 4 && this.J <= 9) {
                  this.L *= 2;
               }

               a var38;
               if (this.q[6 * E1[9][var6][0]] > 1) {
                  this.a((byte[][][])E0, (byte[][][])E1, var6, j, -1, -2, -1);
                  var38 = this;
                  var10001 = this.G;
               } else {
                  var38 = this;
                  var10001 = this.N[this.O[var6]];
               }

               var38.a(var10001, var15, E0[4][var6][2] * 2, E0[4][var6][3] * 2, E0[2][var6][5], E0[2][var6][6] * 2, E0[2][var6][7] * 2);
            }

            this.bl[i] = this.bl[var17];
            this.bl[var17 + 1] = this.bl[var17] + var13 * 12;
            ++var17;
            int[] var10008;
            boolean var10009;
            int[] var39;
            int var40;
            int var41;
            byte var42;
            int var43;
            if (E0[3][i][3] != 0) {
               a(this.cI, this.cJ, this.bl[i], var12, var13, 12, 0, var15, this.I, true);
               var39 = this.cK;
               var10001 = this.cL;
               var40 = this.bl[i];
               var41 = var12;
               var10004 = var13;
               var42 = 12;
               var10006 = 2;
               var43 = var15;
               var10008 = this.I;
               var10009 = true;
            } else {
               a(this.cI, this.cJ, this.bl[i], var12, var13, 12, 0, var15, this.I, true);
               a(this.cK, this.cL, this.bl[i], var12, var13, 12, 2, var15, this.I, true);
               a(this.cM, this.cN, this.bl[i], var12, var13, 12, 6, var15, this.I, false);
               var39 = this.cO;
               var10001 = this.cP;
               var40 = this.bl[i];
               var41 = var12;
               var10004 = var13;
               var42 = 12;
               var10006 = 4;
               var43 = var15;
               var10008 = this.I;
               var10009 = false;
            }

            a(var39, var10001, var40, var41, var10004, var42, var10006, var43, var10008, var10009);
         }
      }

      this.G = null;
      this.H = null;
      this.I = null;
      this.N = (int[][])null;
      this.O = null;
      this.C = null;
      this.D = null;
      System.gc();
   }

   private static void a(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, boolean var9) {
      int var17 = var3 + var4;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      if (var9) {
         int var18 = (var13 = var6 * var5) + var5;
         var15 = var3 + var13 * var7;
         var16 = var7 * var5;
         var12 = 0;

         for(var10 = var3; var10 < var17; ++var10) {
            var14 = var15;

            for(var11 = var13; var11 < var18; ++var11) {
               var0[var2 + var12] = (int)((long)var8[var14] | 0L);
               var1[var2 + var12] = (int)((long)var8[var14 + var16] | 0L);
               ++var12;
               var14 += var7;
            }

            ++var15;
         }
      } else {
         var13 = (var6 + 2) * var5 - 1;
         boolean var19 = false;
         var15 = var3 + var13 * var7;
         var16 = var7 * var5;
         var12 = 0;

         for(var10 = var3; var10 < var3 + var4; ++var10) {
            var14 = var15;

            for(var11 = var13; var11 > var13 - var5; --var11) {
               var0[var2 + var12] = (int)((long)var8[var14] | 0L);
               var1[var2 + var12] = (int)((long)var8[var14 - var16] | 0L);
               ++var12;
               var14 -= var7;
            }

            ++var15;
         }
      }

   }

   private static void a(byte[] var0, byte[] var1, int var2, int var3, int var4, int var5, int[] var6, boolean var7) {
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      if (var7) {
         var13 = (var11 = var5 * var4) * var3;
         var14 = var3 * var4;
         var10 = 0;
         var15 = var11 + var4;

         for(var8 = 0; var8 < var3; ++var8) {
            var12 = var13;

            for(var9 = var11; var9 < var15; ++var9) {
               var0[var2 + var10] = (byte)var6[var12];
               var1[var2 + var10] = (byte)var6[var12 + var14];
               ++var10;
               var12 += var3;
            }

            ++var13;
         }
      } else {
         var13 = (var11 = (var5 + 2) * var4 - 1) * var3;
         var14 = var3 * var4;
         var10 = 0;
         var15 = var11 - var4;

         for(var8 = 0; var8 < var3; ++var8) {
            var12 = var13;

            for(var9 = var11; var9 > var15; --var9) {
               var0[var2 + var10] = (byte)var6[var12];
               var1[var2 + var10] = (byte)var6[var12 - var14];
               ++var10;
               var12 -= var3;
            }

            ++var13;
         }
      }

   }

   private int a(byte var1, byte var2, byte var3, byte var4, byte var5, short var6, int var7, short var8, byte var9) {
      this.bk[var3] = var7;
      int var10 = this.a((byte)0, var1, (short)var8, var7);
      var10 = this.a(var9, var2, (short)0, var10);
      var10 = this.a((byte)(var9 + var5), var1, (short)((byte)(var4 + var5)), var10);
      this.bk[var3 + 1] = var10;
      this.bs[var3] = var6;
      return var10;
   }

   private int a(byte var1, byte var2, short var3, int var4) {
      this.br[var4] = (short)var1;
      int var5 = var4 + 1;
      this.br[var5] = (short)var2;
      ++var5;
      this.br[var5] = var3;
      ++var5;
      return var5;
   }

   private void a(int[] var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      int var10 = 1;
      boolean var11 = false;
      int var12 = var1.length;
      int[] var13 = new int[257];
      int[] var14 = new int[257];

      for(int var8 = 0; var8 < var12; ++var8) {
         int var16;
         if ((var16 = var1[var8]) != this.BACKGROUND_COLOR) {
            int var9 = var16 & 255;
            int var17;
            if ((var17 = var13[var9]) > 0) {
               var1[var8] = var14[var17];
            } else {
               var13[var9] = var10;
               var1[var8] = this.transformColor(var2, var3, var4, var5, var6, var9, var7);
               var14[var10] = var1[var8];
               ++var10;
            }
         }
      }

   }

   private int transformColor(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      int[] var9 = new int[3];
      byte var11;
      byte var12;
      byte var13;
      short var14;
      short var16;
      int var10000;
      if (var7) {
         var16 = 255;
         var9[0] = var6 + (var1 << 4);
         var9[1] = var6 + (var2 << 4);
         var9[2] = var6 + (var3 << 4);
         var11 = 16;
         var12 = 8;
         var13 = 0;
         var14 = 128;
         var10000 = var5 << 4;
      } else {
         var16 = 15;
         var9[0] = (var6 >> 4) + var1;
         var9[1] = (var6 >> 4) + var2;
         var9[2] = (var6 >> 4) + var3;
         var11 = 20;
         var12 = 12;
         var13 = 4;
         var14 = 7;
         var10000 = var5;
      }

      int var15 = var10000;
      int var10 = (var9[0] + var9[1] + var9[2]) / 3;

      for(int var8 = 0; var8 <= 2; ++var8) {
         var9[var8] = a((int)(var9[var8] + var15), var16);
         var9[var8] = a((int)(var10 + (var9[var8] - var10) * (var4 + var14) / var14), var16);
      }

      return var9[0] << var11 | var9[1] << var12 | var9[2] << var13;
   }

   private static int a(int var0, int var1) {
      if (var0 > var1) {
         return var1;
      } else {
         return var0 < 0 ? 0 : var0;
      }
   }

   private void combineLayers(int[] layer1, int[] layer2, int[][] colorData, short startIndex, byte[] palette1, byte[] palette2) {
      boolean isBackground = false;
      byte colorIndex = 1;
      int layerLength = layer1.length;
      byte[] colorMap = new byte[256];
      int[] colorIndices = new int[50];
      short dataIndex = startIndex;
      short uniqueColorIndex = 0;

      int i;
      int colorValue;
      int pixel;

      for(i = 0; i < layerLength; ++i) {
         pixel = layer1[i];
         if (pixel == this.BACKGROUND_COLOR) {
            layer1[i] = -1;
         } else {
            colorValue = pixel & 255;
            if (colorMap[colorValue] > 0) {
               layer1[i] = colorIndices[colorMap[colorValue]];
            } else {
               colorMap[colorValue] = colorIndex;
               colorIndices[colorIndex] = uniqueColorIndex;
               ++colorIndex;
               int color1 = this.transformColor(palette1[0], palette1[1], palette1[2], palette1[3], palette1[4], colorValue, false);
               int color2 = this.transformColor(palette2[0], palette2[1], palette2[2], palette2[3], palette2[4], colorValue, false);
               colorData[0][dataIndex] = (int)((long)color1 | 0L);
               colorData[1][dataIndex] = (int)((long)color2 | 0L);
               layer1[i] = uniqueColorIndex++;
               ++dataIndex;
            }
         }
      }

      this.F = new byte[32][32][32];
      colorIndices = new int[50];

      for(i = 0; i < layerLength; ++i) {
         if ((pixel = layer2[i]) != this.BACKGROUND_COLOR) {
            int red = (pixel & 0xFF0000) >> 19;
            int green = (pixel & 0x00FF00) >> 11;
            int blue = (pixel & 0x0000FF) >> 3;
            if (this.F[red][green][blue] > 0) {
               layer1[i] = colorIndices[this.F[red][green][blue]];
            } else {
               this.F[red][green][blue] = colorIndex;
               colorIndices[colorIndex] = uniqueColorIndex;
               ++colorIndex;
               if (layer2[i] != this.BACKGROUND_COLOR) {
                  colorData[0][dataIndex] = (int)((long)pixel | 0L);
                  colorData[1][dataIndex] = (int)((long)pixel | 0L);
               }

               layer1[i] = uniqueColorIndex++;
               ++dataIndex;
            }
         }
      }

   }

   private void a(int[] var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
      if (var5 == 0) {
         if (this.Q != 15 && this.Q != 60) {
            this.b(this.I, var1, var6, var7, var2, var3, var4);
         } else {
            this.a(this.I, var1, var6, var7, var2, var3, var4);
         }
      } else if (var5 == 1) {
         this.c(this.I, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 2) {
         this.d(this.I, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 3) {
         this.e(this.I, var1, var6, var7, var2, var3, var4);
      } else {
         if (var5 != 5) {
            if (var5 == 6) {
               this.f(this.I, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 == 10) {
               this.g(this.I, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 != 11) {
               return;
            }
         }

         this.a(this.I, var1, var6, var7, var2, var3, var4, var5);
      }
   }

   private void a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            int[] var10000;
            int var10001;
            int var10002;
            if ((var13 = var2[var10]) != this.BACKGROUND_COLOR) {
               var10000 = var1;
               var10001 = var8;
               var10002 = var13;
            } else {
               var10000 = var1;
               var10001 = var8;
               var10002 = this.aW & 16777215;
            }

            var10000[var10001] = var10002;
            ++var10;
         }

         var11 += var5;
      }

   }

   private void b(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.BACKGROUND_COLOR) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   private void c(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;
      int var16 = var4 + var7;

      for(int var10 = var4; var10 < var16; ++var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.BACKGROUND_COLOR) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 += var5;
      }

   }

   private void d(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = (var4 + var7 - 1) * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;

      for(int var10 = var4 + var7 - 1; var10 >= var4; --var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.BACKGROUND_COLOR) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 -= var5;
      }

   }

   private void e(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.BACKGROUND_COLOR) {
               var1[var8] = var13;
               var1[var8 + var6] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   private void a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
            if ((var20 = var2[var14]) != this.BACKGROUND_COLOR) {
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

   private void f(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var9 = var5 * var7;
      int var11 = 0;
      int var15 = var4 + var7;

      for(int var10 = var4; var10 < var15; ++var10) {
         int var13 = var12 + var6;

         for(int var8 = var12; var8 < var13; ++var8) {
            int var14;
            if ((var14 = var2[var11]) != this.BACKGROUND_COLOR) {
               var1[var8] = var14;
               var1[var8 + var9] = var14;
            }

            ++var11;
         }

         var12 += var5;
      }

   }

   private void g(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + (var3 + var5 - 1);
      int var10 = 0;
      int var14 = var4 + var7;

      int var8;
      int var9;
      int var12;
      int var13;
      for(var9 = var4; var9 < var14; ++var9) {
         var12 = var11 - var6;

         for(var8 = var11; var8 > var12; --var8) {
            if ((var13 = var2[var10]) != this.BACKGROUND_COLOR) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

      var11 = var4 * var5 + var3;
      var10 = 0;

      for(var9 = var4; var9 < var14; ++var9) {
         var12 = var11 + var6;

         for(var8 = var11; var8 < var12; ++var8) {
            if ((var13 = var2[var10]) != this.BACKGROUND_COLOR) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   private int modifyBigLump1_subfunction1(long var1, long var3, long var5, long var7, int var9, int var10, byte var11, byte var12, byte var13, byte var14, byte var15, byte var16) {
      int var19 = 0;

      int var18;
      for(var18 = var10; var18 < var10 + 4; ++var18) {
         this.by[var18] = var15;
         if (var16 != 6) {
            this.bz[var18] = var16;
         }

         for(int var17 = 0; var17 < 4; var17 += 2) {
            int[] var10000;
            int var10001;
            long var10002;
            if (var9 == 0) {
               this.cW[var17][var18] = (int)((long)this.B[var19][var17] * var7 + var1);
               var10000 = this.cW[var17 + 1];
               var10001 = var18;
               var10002 = (long)this.B[var19][var17 + 1] * var5;
            } else {
               this.cW[var17][var18] = (int)(((long)this.B[var19][var17] * var7 * this.s(var9) >> 16) - ((long)this.B[var19][var17 + 1] * var5 * this.r(var9) >> 16) + var1);
               var10000 = this.cW[var17 + 1];
               var10001 = var18;
               var10002 = ((long)this.B[var19][var17] * var7 * this.r(var9) >> 16) + ((long)this.B[var19][var17 + 1] * var5 * this.s(var9) >> 16);
            }

            var10000[var10001] = (int)(var10002 + var3);
         }

         ++var19;
      }

      this.cX[var10] = var11;
      var18 = var10 + 1;
      this.cX[var18] = var12;
      ++var18;
      this.cX[var18] = var13;
      ++var18;
      this.cX[var18] = var14;
      if (var16 == 6) {
         this.bz[var18] = 3;
      }

      return var18 + 1;
   }

   private int modifyBigLump1_subfunction5(long var1, long var3, int var5, long var6, int var8, int var9, byte var10, byte var11, int var12) {
      int var15 = 360 / var5;
      int var14 = var12 * 4;

      int var13;
      for(var13 = var8; var13 < var8 + var5; ++var13) {
         this.cW[0][var13] = (int)((var6 * this.r(var14) >> 16) + var1);
         this.cW[1][var13] = (int)((var6 * this.s(var14) >> 16) + var3);
         var14 -= var15;
         this.cW[2][var13] = (int)((var6 * this.r(var14) >> 16) + var1);
         this.cW[3][var13] = (int)((var6 * this.s(var14) >> 16) + var3);
         this.by[var13] = var10;
         this.cX[var13] = (byte)var9;
         this.bz[var13] = var11;
      }

      return var13;
   }

   private void modifyBigLump1_subfunction2(byte var1, byte var2, byte var3, int var4) {
      this.cX[var4] = var1;
      int var5 = var4 + 1;
      this.cX[var5] = var2;
      ++var5;
      this.cX[var5] = var3;
      this.bz[var5] = 3;
   }

   private void fillThisFields(int var1, long var2, long var4, int var6, int var7) {
      this.fz = new long[2];
      this.fk = var1;
      this.fz[0] = var2;
      this.fz[1] = var4;
      this.eR = var6;
      this.eS = var7;
   }

   private void b(short[] var1) {
      a var10000;
      int var10001;
      if (!this.gB) {
         this.aV = var1[0] << 16 | var1[1] << 8 | var1[2];
         var10000 = this;
         var10001 = var1[3] << 16 | var1[4] << 8 | var1[5];
      } else {
         this.aV = 4210752;
         var10000 = this;
         var10001 = 6316128;
      }

      var10000.aW = var10001;
      this.aV = (int)((long)this.aV | 0L);
      this.aW = (int)((long)this.aW | 0L);
   }

   private void a(d var1) {
      if (this.ay <= this.az) {
         a var10000;
         d var10001;
         if (d.a(var1)) {
            if (d.b(var1) != null) {
               this.a(d.b(var1));
            }

            if (this.ay > this.az) {
               return;
            }

            if (this.a((int)d.c(var1))) {
               this.b(d.c(var1));
            }

            if (d.d(var1) == null) {
               return;
            }

            var10000 = this;
            var10001 = d.d(var1);
         } else {
            if (d.d(var1) != null) {
               this.a(d.d(var1));
            }

            if (d.b(var1) == null) {
               return;
            }

            var10000 = this;
            var10001 = d.b(var1);
         }

         var10000.a(var10001);
      }
   }

   private boolean a(int var1) {
      boolean var2 = this.a((int)2, (int)var1, 0);
      boolean var3 = this.a((int)2, (int)var1, 2);
      if (!var2 && !var3) {
         return false;
      } else if (var2 && !this.a((int)1, (int)var1, 0)) {
         return false;
      } else {
         return !var3 || this.a((int)0, (int)var1, 2);
      }
   }

   private boolean a(int var1, int var2, int var3) {
      return (this.be[var1] * (long)this.cW[var3][var2] >> 16) + (this.bf[var1] * (long)this.cW[var3 + 1][var2] >> 16) + this.bg[var1] <= 0L;
   }

   private void e() {
      this.be = new long[3];
      this.bf = new long[3];
      this.bg = new long[3];
      this.be[0] = -this.r(this.eR + 135);
      this.bf[0] = this.s(this.eR + 135);
      this.be[1] = this.r(this.eR + 45);
      this.bf[1] = -this.s(this.eR + 45);
      this.be[2] = -this.r(this.eR + 180);
      this.bf[2] = this.s(this.eR + 180);

      for(int var1 = 0; var1 < 3; ++var1) {
         this.bg[var1] = -(this.be[var1] * this.eI >> 16) - (this.bf[var1] * this.eJ >> 16);
      }

      this.an = this.be[2];
      this.ao = this.bf[2];
      this.ap = this.bg[2];
   }

   private void f() {
      this.S = -this.r(this.eR);
      this.T = this.s(this.eR);
      this.U = this.T;
      this.V = -this.S;
   }

   private void b(int var1) {
      this.as = this.bz[var1];
      this.au = var1;
      this.av = this.cX[var1];
      if (this.as != 1) {
         this.c(var1);
         this.g();
         if (this.i()) {
            a var10000;
            byte var10001;
            if (this.aa <= this.ab) {
               var10000 = this;
               var10001 = -1;
            } else {
               var10000 = this;
               var10001 = 1;
            }

            var10000.aB = var10001;
            this.j();
         }
      }
   }

   private void g() {
      a var10000;
      byte var10001;
      if (this.aa < 6552L && this.ab > 6552L) {
         this.ac = (6552L - this.aa << 16) / (this.ab - this.aa);
         this.aa = 6552L;
         this.W += (this.X - this.W) * this.ac >> 16;
         var10000 = this;
         var10001 = 1;
      } else if (this.aa > 6552L && this.ab < 6552L) {
         this.ac = (6552L - this.ab << 16) / (this.aa - this.ab);
         this.ab = 6552L;
         this.X += (this.W - this.X) * this.ac >> 16;
         var10000 = this;
         var10001 = 2;
      } else {
         var10000 = this;
         var10001 = 3;
      }

      var10000.aA = var10001;
   }

   private void h() {
      if (this.aA == 1) {
         this.al += (this.am - this.al) * this.ac >> 16;
      } else {
         if (this.aA == 2) {
            this.am -= (this.am - this.al) * this.ac >> 16;
         }

      }
   }

   private void c(int var1) {
      long var2 = ((long)this.cW[0][var1] * 75000L >> 16) - this.fz[0];
      long var4 = ((long)this.cW[1][var1] * 75000L >> 16) - this.fz[1];
      this.W = (var2 * this.U >> 16) + (var4 * this.V >> 16);
      this.aa = (var2 * this.S >> 16) + (var4 * this.T >> 16);
      var2 = ((long)this.cW[2][var1] * 75000L >> 16) - this.fz[0];
      var4 = ((long)this.cW[3][var1] * 75000L >> 16) - this.fz[1];
      this.X = (var2 * this.U >> 16) + (var4 * this.V >> 16);
      this.ab = (var2 * this.S >> 16) + (var4 * this.T >> 16);
   }

   private boolean i() {
      this.W = 7864320L * this.W / this.aa + 7831552L;
      this.X = 7864320L * this.X / this.ab + 7831552L;
      this.aw = (int)(this.W >> 16);
      this.ax = (int)(this.X >> 16);
      if (this.aw >= this.ax) {
         return false;
      } else if (this.aw >= this.az) {
         return false;
      } else if (this.ax <= this.ay) {
         return false;
      } else {
         this.Z = 283701411840L / this.ab + 7110656L;
         this.Y = 283701411840L / this.aa + 7110656L;
         return true;
      }
   }

   private void d(int var1) {
      byte var5 = this.do[var1];
      this.at = this.bs[this.av];
      a var10000;
      int[] var10001;
      if (this.as != 2 && this.as != 5 && this.as != 7) {
         this.cQ = this.cP;
         this.cR = this.cO;
         this.cS = this.cN;
         var10000 = this;
         var10001 = this.cM;
      } else {
         this.cQ = this.cL;
         this.cR = this.cK;
         this.cS = this.cJ;
         var10000 = this;
         var10001 = this.cI;
      }

      var10000.cT = var10001;
      int var12;
      if (var5 != -90 && var5 != 0) {
         var10000 = this;
         var12 = (int)(a(((long)(this.cW[1][var1] - this.cW[3][var1]) << 16) / this.s(var5)) * 75000L >> 16 >> 16);
      } else {
         int[][] var10002;
         byte var10003;
         if (var5 == -90) {
            var10000 = this;
            var12 = this.cW[2][var1];
            var10002 = this.cW;
            var10003 = 0;
         } else {
            var10000 = this;
            var12 = this.cW[1][var1];
            var10002 = this.cW;
            var10003 = 3;
         }

         var12 = abs(var12 - var10002[var10003][var1]) >> 16;
      }

      var10000.aU = var12;
      if (this.at == 48) {
         this.aU *= 2;
      }

      if (this.aU == 0) {
         this.aU = 1;
      }

      if (this.at == 24) {
         this.aU *= 4;
      }

      this.al = 0L;
      this.am = (long)(this.at * this.aU - 1 << 16);
      int var2;
      int var7;
      int var8;
      if (var1 >= this.fb && var1 < this.fc) {
         label145: {
            var7 = (var1 - this.fb) / 3;
            var8 = (var1 - this.fb) % 3;
            if (this.as != 3 && this.as != 7) {
               if (var8 == 0) {
                  this.al = (long)this.dz[var7];
                  break label145;
               }

               if (var8 != 2) {
                  break label145;
               }
            } else if (var8 != 0) {
               if (var8 == 2) {
                  this.al = (long)this.dz[var7];
               }
               break label145;
            }

            this.am = (long)this.dA[var7];
         }
      } else if (var1 >= this.fd) {
         var7 = this.bi.length;
         var8 = 0;

         for(var2 = 1; var2 < var7; ++var2) {
            if (var1 < this.bi[var2]) {
               var8 = var2 - 1;
               break;
            }
         }

         int var9 = var1 - this.bi[var8];
         int var10 = this.at / this.bh[var8];
         this.al = (long)(var9 * var10 << 16);
         this.am = (long)(var9 * var10 + var10 - 1 << 16);
      }

      if (this.as == 3 || this.as == 7) {
         long var11 = this.am;
         this.am = this.al;
         this.al = var11;
      }

      this.h();
      this.ad = (this.am << 16) / this.ab - (this.al << 16) / this.aa;
      this.ae = this.X - this.W;
      this.af = 4294967296L / this.ab - 4294967296L / this.aa;
      long var13;
      long var15;
      if (this.aB == 1) {
         this.aj = this.Y;
         this.ag = (this.af << 16) / this.ae;
         this.ah = (this.ad << 16) / this.ae;
         this.ak = (this.al << 16) / this.aa;
         var10000 = this;
         var15 = 4294967296L;
         var13 = this.aa;
      } else {
         this.aj = this.Z;
         this.ag = -(this.af << 16) / this.ae;
         this.ah = -(this.ad << 16) / this.ae;
         this.ak = (this.am << 16) / this.ab;
         var10000 = this;
         var15 = 4294967296L;
         var13 = this.ab;
      }

      var10000.ai = var15 / var13;
      int var6 = this.av < 32 ? 1 : 7;

      for(var7 = 0; var7 < var6; ++var7) {
         int[] var14;
         if (var6 == 1) {
            var14 = this.bk;
            var12 = this.av;
         } else {
            var14 = this.bk;
            var12 = this.bA[(this.av - 32) * var6 + var7];
         }

         int var3 = var14[var12];

         for(var2 = 0; var2 < 3; ++var2) {
            for(int var4 = 0; var4 < 3; ++var4) {
               this.bB[var7][var2][var4] = this.br[var3];
               ++var3;
            }
         }
      }

   }

   private void j() {
      long var6;
      a var10000;
      int var10001;
      int var25;
      byte var35;
      boolean var36;
      boolean var37;
      int var38;
      int var39;
      label416: {
         label415: {
            var37 = false;
            var38 = this.aV;
            var39 = this.aW;
            var35 = this.by[this.au];
            var36 = false;
            var25 = 0;
            int var20 = (int)(this.Y >> 16);
            int var21 = (int)(this.Z >> 16);
            long var2 = (long)(this.ax - this.aw);
            long var4 = (long)(var21 - var20 << 16);
            var6 = (this.aB == 1 ? var4 : -var4) / var2;
            if (this.aB == 1) {
               if (this.ax >= this.az) {
                  this.ax = this.az - 1;
               }

               if (var35 != 0) {
                  break label416;
               }

               if (this.aw <= this.ay + 1) {
                  this.ay = this.ax;
               }

               if (this.ax < this.az - 1) {
                  break label416;
               }

               if (this.aw >= 0) {
                  var10000 = this;
                  var10001 = this.aw;
                  break label415;
               }

               var10000 = this;
            } else {
               if (this.aw <= this.ay) {
                  this.aw = this.ay + 1;
               }

               if (var35 != 0) {
                  break label416;
               }

               if (this.aw <= this.ay + 1) {
                  if (this.ax <= 239) {
                     var10000 = this;
                     var10001 = this.ax;
                  } else {
                     var10000 = this;
                     var10001 = 239;
                  }

                  var10000.ay = var10001;
               }

               if (this.ax < this.az - 1) {
                  break label416;
               }

               if (this.aw >= 0) {
                  var10000 = this;
                  var10001 = this.aw;
                  break label415;
               }

               var10000 = this;
            }

            var10001 = 0;
         }

         var10000.az = var10001;
      }

      int var24 = this.av < 32 ? 1 : 7;
      byte var26;
      int var41;
      if (this.aB == 1) {
         var26 = 1;
         this.bK = this.aw;
         var41 = this.ax;
      } else {
         var26 = -1;
         this.bK = this.ax;
         var41 = this.aw;
      }

      int var27 = var41;
      if (this.aq == -1 && this.au >= this.fa && this.au < this.fb) {
         this.dZ = (int)(a((long)this.cW[0][this.au] - this.eI) >> 16);
         this.ea = (int)(a((long)this.cW[1][this.au] - this.eJ) >> 16);
         if (this.dZ <= 2 && this.ea <= 2) {
            var37 = true;
         }
      }

      int var34 = var27 + var26;

      while(true) {
         while(true) {
            while(this.bK != var34) {
               if (this.bK >= 0 && this.bK <= 239) {
                  int var10002;
                  int[] var44;
                  label388: {
                     byte var42;
                     int[][] var43;
                     label387: {
                        if (var35 == 0) {
                           if (this.bC[this.bK]) {
                              this.bK += var26;
                              ++var25;
                              continue;
                           }

                           if (!var36) {
                              this.d(this.au);
                              var36 = true;
                           }

                           this.bC[this.bK] = true;
                           if (var25 != 0) {
                              this.aj += (long)var25 * var6;
                              this.ak += (long)var25 * this.ah;
                              this.ai += (long)var25 * this.ag;
                              var25 = 0;
                           }

                           if (this.bx[this.bK] == 0) {
                              var43 = this.bo;
                              var42 = 0;
                              break label387;
                           }

                           var10000 = this;
                        } else {
                           if (this.bC[this.bK] || this.bx[this.bK] == var35) {
                              this.bK += var26;
                              ++var25;
                              continue;
                           }

                           if (!var36) {
                              this.d(this.au);
                              var36 = true;
                           }

                           if (this.bx[this.bK] * var35 == 2) {
                              this.bC[this.bK] = true;
                           }

                           if (var25 != 0) {
                              this.aj += (long)var25 * var6;
                              this.ak += (long)var25 * this.ah;
                              this.ai += (long)var25 * this.ag;
                              var25 = 0;
                           }

                           if (this.bx[this.bK] == 0) {
                              if (var35 == 1) {
                                 var44 = this.bo[0];
                                 var10001 = this.bK;
                                 var10002 = (int)this.ai;
                              } else {
                                 var44 = this.bo[0];
                                 var10001 = this.bK;
                                 var10002 = -((int)this.ai);
                              }

                              var44[var10001] = var10002;
                              this.bx[this.bK] = var35;
                              break label388;
                           }

                           var10000 = this;
                        }

                        var43 = var10000.bo;
                        var42 = 1;
                     }

                     var43[var42][this.bK] = (int)this.ai;
                  }

                  int var13;
                  int var11 = (var13 = (int)((this.ak << 16) / this.ai >> 16)) % this.at;
                  int var12 = var24 == 7 ? var13 / this.at % var24 : 0;
                  if (var11 < 0 || var12 < 0) {
                     var11 = 0;
                     var12 = 0;
                  }

                  if (this.as != 0) {
                     label448: {
                        if (this.as != 5 && this.as != 10) {
                           if (this.as == 15) {
                              var41 = this.at - 1 - var11;
                           } else {
                              if (this.as == 20) {
                                 if (var12 != 0) {
                                    break label448;
                                 }
                              } else if (this.as != 25 || var12 != this.aU - 1) {
                                 break label448;
                              }

                              var41 = var11 % 24;
                           }
                        } else {
                           if (var13 / this.at != 1) {
                              break label448;
                           }

                           var41 = this.at - 1 - var11;
                        }

                        var11 = var41;
                     }
                  }

                  int var18 = this.at != 140 ? this.at : 96;
                  this.aD = 0;

                  for(int var8 = 2; var8 >= 0; --var8) {
                     if (var11 >= this.bB[var12][var8][0]) {
                        this.aD = this.bl[this.bB[var12][var8][1]] + (var11 - this.bB[var12][var8][0] + this.bB[var12][var8][2]) % var18 * 12;
                        break;
                     }
                  }

                  this.aC = this.aD << 16;
                  this.aE = this.aD + 11;
                  int var23 = (int)(this.aj >> 16);
                  int var22 = 217 - var23;
                  int var28;
                  if ((var28 = 108 - var22) == 0) {
                     this.ak += this.ah;
                     this.ai += this.ag;
                     this.bK += var26;
                  } else {
                     int var16;
                     label332: {
                        label331: {
                           int var29;
                           int var14 = (var29 = var28 + 1) >> 2;
                           int var15 = var29 - (var14 << 2);
                           this.aF = 3014656 / var28;
                           this.aG = this.bK + var22 * 240;
                           this.aN = this.bK + var23 * 240;
                           this.aO = this.bK + '쭰';
                           int var17 = (var16 = var14 * 240) + 240;
                           if (var15 == 0) {
                              this.aH = this.aG + var16;
                              this.aI = this.aH + var16;
                              this.aJ = this.aI + var16;
                              this.aM = this.aN - var16;
                              var10000 = this;
                              var10001 = this.aM;
                              var10002 = var16;
                           } else {
                              if (var15 == 1) {
                                 this.aH = this.aG + var16;
                                 this.aI = this.aH + var16;
                                 this.aJ = this.aI + var17;
                                 this.aM = this.aN - var16;
                                 this.aL = this.aM - var16;
                                 var10000 = this;
                                 var10001 = this.aL;
                                 var10002 = var17;
                                 break label331;
                              }

                              if (var15 == 2) {
                                 this.aH = this.aG + var16;
                                 this.aI = this.aH + var17;
                                 this.aJ = this.aI + var16;
                                 var10000 = this;
                                 var10001 = this.aN;
                                 var10002 = var16;
                              } else {
                                 if (var15 != 3) {
                                    break label332;
                                 }

                                 this.aH = this.aG + var17;
                                 this.aI = this.aH + var17;
                                 this.aJ = this.aI + var16;
                                 var10000 = this;
                                 var10001 = this.aN;
                                 var10002 = var17;
                              }

                              var10000.aM = var10001 - var10002;
                              var10000 = this;
                              var10001 = this.aM;
                              var10002 = var17;
                           }

                           var10000.aL = var10001 - var10002;
                           var10000 = this;
                           var10001 = this.aL;
                           var10002 = var16;
                        }

                        var10000.aK = var10001 - var10002;
                     }

                     if (var23 > 0) {
                        label319: {
                           label318: {
                              int var30 = this.bK;
                              int var31 = this.aG - 240;
                              int var32 = this.aN + 240;
                              int var33 = this.aO;
                              if (this.by[this.au] == 0) {
                                 if (this.bx[this.bK] == 0) {
                                    while(var30 < var31) {
                                       this.bn[var30] = var38;
                                       this.bn[var31] = var38;
                                       this.bn[var32] = var39;
                                       this.bn[var33] = var39;
                                       var30 += 240;
                                       var31 -= 240;
                                       var32 += 240;
                                       var33 -= 240;
                                    }

                                    if (var30 != var31) {
                                       break label319;
                                    }

                                    this.bn[var30] = var38;
                                    var44 = this.bn;
                                    var10001 = var32;
                                    var10002 = var39;
                                    break label318;
                                 }

                                 if (this.bx[this.bK] != 1) {
                                    while(var32 < var33) {
                                       this.bn[var32] = var39;
                                       this.bn[var33] = var39;
                                       var32 += 240;
                                       var33 -= 240;
                                    }

                                    if (var32 != var33) {
                                       break label319;
                                    }

                                    var44 = this.bn;
                                    var10001 = var32;
                                    var10002 = var39;
                                    break label318;
                                 }

                                 while(var30 < var31) {
                                    this.bn[var30] = var38;
                                    this.bn[var31] = var38;
                                    var30 += 240;
                                    var31 -= 240;
                                 }

                                 if (var30 != var31) {
                                    break label319;
                                 }
                              } else {
                                 if (this.by[this.au] == 1) {
                                    while(var32 < var33) {
                                       this.bn[var32] = var39;
                                       this.bn[var33] = var39;
                                       var32 += 240;
                                       var33 -= 240;
                                    }

                                    if (var32 != var33) {
                                       break label319;
                                    }

                                    var44 = this.bn;
                                    var10001 = var32;
                                    var10002 = var39;
                                    break label318;
                                 }

                                 while(var30 < var31) {
                                    this.bn[var30] = var38;
                                    this.bn[var31] = var38;
                                    var30 += 240;
                                    var31 -= 240;
                                 }

                                 if (var30 != var31) {
                                    break label319;
                                 }
                              }

                              var44 = this.bn;
                              var10001 = var30;
                              var10002 = var38;
                           }

                           var44[var10001] = var10002;
                        }
                     }

                     this.aZ = true;
                     this.ba = true;
                     this.bb = true;
                     if (this.aH - this.aG != var16) {
                        this.aZ = false;
                     }

                     if (this.aI - this.aH != var16) {
                        this.ba = false;
                     }

                     if (this.aJ - this.aI != var16) {
                        this.bb = false;
                     }

                     this.aj += var6;
                     if (var35 == 1) {
                        ++this.aE;
                        int var19 = this.aD;
                        this.aD = this.aE;
                        this.aE = var19;
                        this.aC = (this.aD << 16) - 1;
                        this.aF = -this.aF;
                     }

                     label269: {
                        this.bc = true;
                        this.bd = true;
                        boolean var46;
                        if (this.aG >= this.bK) {
                           this.f(this.aG + var16);
                           this.bc = true;
                           var10000 = this;
                           var46 = true;
                        } else {
                           int var40;
                           if (this.aG < this.bK && this.aH >= this.bK) {
                              this.h(this.aH + this.bK - this.aG);
                              var40 = this.aG + var16;
                              this.aG = this.bK;
                              this.aN = this.bK + '쭰';
                              this.f(var40);
                              this.bc = true;
                              var10000 = this;
                              var46 = true;
                           } else if (this.aH < this.bK && this.aI >= this.bK) {
                              this.j(this.aI + this.bK - this.aH);
                              var40 = this.aH + var16;
                              this.aH = this.bK;
                              this.aM = this.bK + '쭰';
                              this.h(var40);
                              this.bc = false;
                              var10000 = this;
                              var46 = true;
                           } else {
                              if (this.aI >= this.bK || this.aJ < this.bK) {
                                 break label269;
                              }

                              label257: {
                                 if (var35 == 0) {
                                    if (this.bx[this.bK] == 0) {
                                       this.k(this.aJ + this.bK - this.aI);
                                       break label257;
                                    }

                                    if (this.bx[this.bK] != 1) {
                                       this.b(this.aJ + this.bK - this.aI, this.cP);
                                       break label257;
                                    }
                                 } else if (var35 == 1) {
                                    this.b(this.aJ + this.bK - this.aI, this.cI);
                                    break label257;
                                 }

                                 this.a(this.aJ + this.bK - this.aI, this.cL);
                              }

                              var40 = this.aI + var16;
                              this.aI = this.bK;
                              this.aL = this.bK + '쭰';
                              this.j(var40);
                              this.bc = false;
                              var10000 = this;
                              var46 = false;
                           }
                        }

                        var10000.bd = var46;
                     }

                     if (this.aJ >= this.bK) {
                        label452: {
                           int[] var10003;
                           int[] var10004;
                           int[] var45;
                           int[] var47;
                           if (var35 == 0 && this.bx[this.bK] == 0) {
                              this.a(this.cI, this.cJ, this.cK, this.cL);
                              var10000 = this;
                              var47 = this.cT;
                              var45 = this.cS;
                              var10003 = this.cR;
                              var10004 = this.cQ;
                           } else {
                              if (var35 == 0 && this.bx[this.bK] == 1 || var35 == 2) {
                                 this.a(this.cI, this.cJ, this.cK, this.cL);
                                 break label452;
                              }

                              if (var35 == 0 && this.bx[this.bK] == 2) {
                                 var10000 = this;
                                 var47 = this.cT;
                                 var45 = this.cS;
                                 var10003 = this.cR;
                                 var10004 = this.cQ;
                              } else {
                                 var10000 = this;
                                 var47 = this.cL;
                                 var45 = this.cK;
                                 var10003 = this.cJ;
                                 var10004 = this.cI;
                              }
                           }

                           var10000.b(var47, var45, var10003, var10004);
                        }
                     }

                     this.ak += this.ah;
                     this.ai += this.ag;
                     this.bK += var26;
                     if (var37 && this.bK >= 92 && this.bK <= 148) {
                        this.aq = this.au;
                     }
                  }
               } else {
                  this.bK += var26;
                  ++var25;
               }
            }

            return;
         }
      }
   }

   private void a(int[] var1, int[] var2, int[] var3, int[] var4) {
      if (this.bc && !this.aZ) {
         this.bn[this.aG] = var1[this.aE];
      }

      if (this.bd && !this.ba) {
         this.bn[this.aH] = var2[this.aE];
      }

      if (!this.bb) {
         this.bn[this.aI] = var3[this.aE];
      }

      int[] var10000;
      int var10001;
      if (this.aJ == this.bK + 25920) {
         var10000 = this.bn;
         var10001 = this.aJ;
      } else {
         var10000 = this.bn;
         var10001 = this.aJ - 240;
      }

      var10000[var10001] = var4[this.aE];
   }

   private void b(int[] var1, int[] var2, int[] var3, int[] var4) {
      if (this.bc && !this.aZ) {
         this.bn[this.aN] = var1[this.aE];
      }

      if (this.bd && !this.ba) {
         this.bn[this.aM] = var2[this.aE];
      }

      if (!this.bb) {
         this.bn[this.aL] = var3[this.aE];
      }

      int[] var10000;
      int var10001;
      if (this.aK == this.bK + 26160) {
         var10000 = this.bn;
         var10001 = this.aK;
      } else {
         var10000 = this.bn;
         var10001 = this.aK + 240;
      }

      var10000[var10001] = var4[this.aE];
   }

   private void e(int var1) {
      int var2;
      for(var2 = this.aD; this.aG < var1; this.aC += this.aF) {
         var2 = this.aC >> 16;
         this.bn[this.aG] = this.cI[var2];
         this.bn[this.aH] = this.cJ[var2];
         this.bn[this.aI] = this.cK[var2];
         this.bn[this.aJ] = this.cL[var2];
         this.bn[this.aK] = this.cQ[var2];
         this.bn[this.aL] = this.cR[var2];
         this.bn[this.aM] = this.cS[var2];
         this.bn[this.aN] = this.cT[var2];
         this.aG += 240;
         this.aH += 240;
         this.aI += 240;
         this.aJ += 240;
         this.aK -= 240;
         this.aL -= 240;
         this.aM -= 240;
         this.aN -= 240;
      }

      this.aD = var2;
   }

   private void f(int var1) {
      if (this.by[this.au] == 0) {
         if (this.bx[this.bK] == 0) {
            this.e(var1);
            return;
         }

         if (this.bx[this.bK] != 1) {
            this.b(var1, this.cM, this.cN, this.cO, this.cP);
            return;
         }
      } else if (this.by[this.au] == 1) {
         this.b(var1, this.cL, this.cK, this.cJ, this.cI);
         return;
      }

      this.a(var1, this.cI, this.cJ, this.cK, this.cL);
   }

   private void g(int var1) {
      int var2;
      for(var2 = this.aD; this.aH < var1; this.aC += this.aF) {
         var2 = this.aC >> 16;
         this.bn[this.aH] = this.cJ[var2];
         this.bn[this.aI] = this.cK[var2];
         this.bn[this.aJ] = this.cL[var2];
         this.bn[this.aK] = this.cQ[var2];
         this.bn[this.aL] = this.cR[var2];
         this.bn[this.aM] = this.cS[var2];
         this.aH += 240;
         this.aI += 240;
         this.aJ += 240;
         this.aK -= 240;
         this.aL -= 240;
         this.aM -= 240;
      }

      this.aD = var2;
   }

   private void h(int var1) {
      if (this.by[this.au] == 0) {
         if (this.bx[this.bK] == 0) {
            this.g(var1);
            return;
         }

         if (this.bx[this.bK] != 1) {
            this.b(var1, this.cN, this.cO, this.cP);
            return;
         }
      } else if (this.by[this.au] == 1) {
         this.b(var1, this.cK, this.cJ, this.cI);
         return;
      }

      this.a(var1, this.cJ, this.cK, this.cL);
   }

   private void i(int var1) {
      int var2;
      for(var2 = this.aD; this.aI < var1; this.aC += this.aF) {
         var2 = this.aC >> 16;
         this.bn[this.aI] = this.cK[var2];
         this.bn[this.aJ] = this.cL[var2];
         this.bn[this.aK] = this.cQ[var2];
         this.bn[this.aL] = this.cR[var2];
         this.aI += 240;
         this.aJ += 240;
         this.aK -= 240;
         this.aL -= 240;
      }

      this.aD = var2;
   }

   private void j(int var1) {
      if (this.by[this.au] == 0) {
         if (this.bx[this.bK] == 0) {
            this.i(var1);
            return;
         }

         if (this.bx[this.bK] != 1) {
            this.b(var1, this.cO, this.cP);
            return;
         }
      } else if (this.by[this.au] == 1) {
         this.b(var1, this.cJ, this.cI);
         return;
      }

      this.a(var1, this.cK, this.cL);
   }

   private void k(int var1) {
      int var2;
      for(var2 = this.aD; this.aJ < var1; this.aC += this.aF) {
         var2 = this.aC >> 16;
         this.bn[this.aJ] = this.cL[var2];
         this.bn[this.aK] = this.cQ[var2];
         this.aJ += 240;
         this.aK -= 240;
      }

      this.aD = var2;
   }

   private void a(int var1, int[] var2, int[] var3, int[] var4, int[] var5) {
      int var6;
      for(var6 = this.aD; this.aG < var1; this.aC += this.aF) {
         var6 = this.aC >> 16;
         this.bn[this.aG] = var2[var6];
         this.bn[this.aH] = var3[var6];
         this.bn[this.aI] = var4[var6];
         this.bn[this.aJ] = var5[var6];
         this.aG += 240;
         this.aH += 240;
         this.aI += 240;
         this.aJ += 240;
      }

      this.aD = var6;
   }

   private void b(int var1, int[] var2, int[] var3, int[] var4, int[] var5) {
      int var6 = this.aD;

      for(int var7 = this.aO - var1 + this.bK; this.aN > var7; this.aC += this.aF) {
         var6 = this.aC >> 16;
         this.bn[this.aN] = var2[var6];
         this.bn[this.aM] = var3[var6];
         this.bn[this.aL] = var4[var6];
         this.bn[this.aK] = var5[var6];
         this.aK -= 240;
         this.aL -= 240;
         this.aM -= 240;
         this.aN -= 240;
      }

      this.aD = var6;
   }

   private void a(int var1, int[] var2, int[] var3, int[] var4) {
      int var5;
      for(var5 = this.aD; this.aH < var1; this.aC += this.aF) {
         var5 = this.aC >> 16;
         this.bn[this.aH] = var2[var5];
         this.bn[this.aI] = var3[var5];
         this.bn[this.aJ] = var4[var5];
         this.aH += 240;
         this.aI += 240;
         this.aJ += 240;
      }

      this.aD = var5;
   }

   private void b(int var1, int[] var2, int[] var3, int[] var4) {
      int var5 = this.aD;

      for(int var6 = this.aO - var1 + this.bK; this.aM > var6; this.aC += this.aF) {
         var5 = this.aC >> 16;
         this.bn[this.aM] = var2[var5];
         this.bn[this.aL] = var3[var5];
         this.bn[this.aK] = var4[var5];
         this.aK -= 240;
         this.aL -= 240;
         this.aM -= 240;
      }

      this.aD = var5;
   }

   private void a(int var1, int[] var2, int[] var3) {
      int var4;
      for(var4 = this.aD; this.aI < var1; this.aC += this.aF) {
         var4 = this.aC >> 16;
         this.bn[this.aI] = var2[var4];
         this.bn[this.aJ] = var3[var4];
         this.aI += 240;
         this.aJ += 240;
      }

      this.aD = var4;
   }

   private void b(int var1, int[] var2, int[] var3) {
      int var4 = this.aD;

      for(int var5 = this.aO - var1 + this.bK; this.aL > var5; this.aC += this.aF) {
         var4 = this.aC >> 16;
         this.bn[this.aL] = var2[var4];
         this.bn[this.aK] = var3[var4];
         this.aK -= 240;
         this.aL -= 240;
      }

      this.aD = var4;
   }

   private void a(int var1, int[] var2) {
      int var3;
      for(var3 = this.aD; this.aJ < var1; this.aC += this.aF) {
         var3 = this.aC >> 16;
         this.bn[this.aJ] = var2[var3];
         this.aJ += 240;
      }

      this.aD = var3;
   }

   private void b(int var1, int[] var2) {
      int var3 = this.aD;

      for(int var4 = this.aO - var1 + this.bK; this.aK > var4; this.aC += this.aF) {
         var3 = this.aC >> 16;
         this.bn[this.aK] = var2[var3];
         this.aK -= 240;
      }

      this.aD = var3;
   }

   private boolean l(int var1) {
      return (this.an * (long)this.bT[var1][0] >> 16) + (this.ao * (long)this.bT[var1][1] >> 16) + this.ap <= 0L;
   }

   private void m(int var1) {
      int var3;
      if (var1 < this.eP && this.cg[var1] < 8 && !this.cl[var1]) {
         label94: {
            a var10000;
            byte var10001;
            byte var10002;
            byte var10003;
            byte var10004;
            if ((var3 = (var3 = (this.eR < 0 ? 360 - abs(this.eR) % 360 : this.eR % 360) - this.bW[var1]) < 0 ? 360 - abs(var3) % 360 : var3 % 360) >= 0 && var3 < 45 || var3 >= 315 && var3 < 360) {
               var10000 = this;
               var10001 = 4;
               var10002 = 5;
               var10003 = 1;
               var10004 = 0;
            } else if (var3 >= 45 && var3 < 135) {
               var10000 = this;
               var10001 = 6;
               var10002 = 7;
               var10003 = 3;
               var10004 = 2;
            } else if (var3 >= 135 && var3 < 225) {
               var10000 = this;
               var10001 = 1;
               var10002 = 0;
               var10003 = 4;
               var10004 = 5;
            } else {
               if (var3 < 225 || var3 >= 315) {
                  break label94;
               }

               var10000 = this;
               var10001 = 3;
               var10002 = 2;
               var10003 = 6;
               var10004 = 7;
            }

            var10000.a(var10001, var10002, var10003, var10004, var1);
         }
      }

      this.n(var1);
      if (this.bG >= 6552L) {
         this.k();
         int var2 = (int)(this.bD >> 16);
         var3 = (int)(this.bE >> 16);
         if (var2 <= 239) {
            if (var3 >= 0) {
               if (var3 != var2) {
                  this.bQ[this.bH] = this.bD;
                  this.bR[this.bH] = this.bE;
                  this.bS[this.bH] = this.bF;
                  this.bV[this.bH] = var1;
                  this.bU[this.bH] = this.bH;
                  this.bP[this.bH] = this.bG;
                  ++this.bH;
               }
            }
         }
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      byte[] var10000;
      int var10001;
      int var10002;
      if (this.cc[var5] == 1) {
         if (this.cj[var5]) {
            var10000 = this.cg;
            var10001 = var5;
            var10002 = var1;
         } else {
            var10000 = this.cg;
            var10001 = var5;
            var10002 = var2;
         }
      } else if (this.cj[var5]) {
         var10000 = this.cg;
         var10001 = var5;
         var10002 = var3;
      } else {
         var10000 = this.cg;
         var10001 = var5;
         var10002 = var4;
      }

      var10000[var10001] = (byte)var10002;
   }

   private void n(int var1) {
      long var2 = ((long)this.bT[var1][0] * 75000L >> 16) - this.fz[0];
      long var4 = ((long)this.bT[var1][1] * 75000L >> 16) - this.fz[1];
      this.bG = (var2 * this.S >> 16) + (var4 * this.T >> 16);
      int[] var10000;
      byte var10001;
      if (this.bO) {
         var10000 = this.bj;
         var10001 = this.cg[var1];
      } else {
         var10000 = this.bj;
         var10001 = this.fo;
      }

      long var6 = (long)var10000[var10001];
      this.bD = (var2 * this.U >> 16) + (var4 * this.V >> 16) - (var6 * 75000L >> 16);
      this.bE = (var2 * this.U >> 16) + (var4 * this.V >> 16) + (var6 * 75000L >> 16);
   }

   private void k() {
      this.bD = 7864320L * this.bD / this.bG + 7831552L;
      this.bF = 283701411840L / this.bG + 7110656L;
      this.bE = 7864320L * this.bE / this.bG + 7831552L;
   }

   private void l() {
      int[] var6 = new int[this.bH];

      int var1;
      for(var1 = 0; var1 < this.bH; var6[var1] = var1++) {
      }

      for(var1 = 0; var1 < this.bH; ++var1) {
         for(int var2 = var1 + 1; var2 < this.bH; ++var2) {
            int var5 = var6[var2];
            int var4 = var6[var1];
            if (this.bP[var5] > this.bP[var4]) {
               var6[var1] = var5;
               var6[var2] = var4;
            }
         }

         this.o(var6[var1]);
      }

   }

   private void o(int var1) {
      boolean var25 = false;
      this.bD = this.bQ[var1];
      this.bE = this.bR[var1];
      this.bF = this.bS[var1];
      this.bI = this.bV[var1];
      a var10000;
      byte var10001;
      if (this.bO) {
         var10000 = this;
         var10001 = this.cg[this.bI];
      } else {
         var10000 = this;
         var10001 = this.fo;
      }

      var10000.bM = var10001;
      short var19 = this.foeW[this.bM];
      int var20 = this.foeH[this.bM] / this.bu[this.bM];
      short var21 = this.bq[this.bt[this.bM]][this.bM];
      if (this.bt[this.bM] == 3 && var19 == 96) {
         this.bt[this.bM] = 5;
      }

      this.bG = this.bP[var1];
      this.bJ = this.bt[this.bM];

      int var14;
      int var26;
      for(var26 = var14 = this.bM * 50; var26 < var14 + 50; ++var26) {
         this.bm[var26 - var14] = this.bp[this.ch[this.bI]][var26];
      }

      int var9 = (int)(this.bD >> 16);
      int var10 = (int)(this.bE >> 16);
      long var2 = (long)((var19 - 1 << 16) / (var10 - var9));
      long var6 = 0L;
      long var4 = 4294967296L / this.bG;
      int var22 = 0;
      int var12 = (int)(this.bF >> 16);
      int var13 = 217 - var12;
      int var23;
      if ((var23 = 108 - var13) != 0) {
         this.aF = (var20 * 4 - 1 << 16) / var23;
         int var24;
         int var15 = (var24 = var23 + 1) >> 2;
         int var16 = var24 - (var15 << 2);
         int var17;
         int var18 = (var17 = var15 * 240) + 240;
         if (var10 > 239) {
            var10 = 239;
         }

         if (!this.cl[this.bI] && this.bI < 32) {
            this.dZ = (int)(a((long)this.bT[this.bI][0] - this.eI) >> 16);
            this.ea = (int)(a((long)this.bT[this.bI][1] - this.eJ) >> 16);
            if (this.dZ <= this.er && this.ea <= this.er) {
               var25 = true;
            }
         }

         var10000 = this;
         int var27 = var9;

         while(true) {
            var10000.bK = var27;
            if (this.bK > var10) {
               return;
            }

            if (this.bK < 0) {
               ++var22;
            } else {
               label159: {
                  byte var28;
                  label141: {
                     if (this.bo[1][this.bK] != 0) {
                        if (var4 <= (long)this.bo[1][this.bK]) {
                           ++var22;
                           break label159;
                        }

                        if (var4 <= (long)abs(this.bo[0][this.bK])) {
                           if (this.bo[0][this.bK] > 0) {
                              var10000 = this;
                              var28 = 1;
                           } else {
                              var10000 = this;
                              var28 = 2;
                           }
                           break label141;
                        }

                        var10000 = this;
                     } else {
                        if (var4 <= (long)abs(this.bo[0][this.bK])) {
                           ++var22;
                           break label159;
                        }

                        var10000 = this;
                     }

                     var28 = 0;
                  }

                  var10000.aX = var28;
                  if (var22 != 0) {
                     var6 += (long)var22 * var2;
                     var22 = 0;
                  }

                  label133: {
                     int var10002;
                     label132: {
                        int var8 = (int)(var6 >> 16) % var19;
                        this.aD = var21 + var8 * var20;
                        this.aE = this.aD + var20 - 1;
                        this.aC = this.aD << 16;
                        this.aG = this.bK + var13 * 240;
                        this.aN = this.bK + var12 * 240;
                        this.aO = this.bK + '쭰';
                        if (var16 == 0) {
                           this.aH = this.aG + var17;
                           this.aI = this.aH + var17;
                           this.aJ = this.aI + var17;
                           this.aM = this.aN - var17;
                           var10000 = this;
                           var27 = this.aM;
                           var10002 = var17;
                        } else {
                           if (var16 == 1) {
                              this.aH = this.aG + var17;
                              this.aI = this.aH + var17;
                              this.aJ = this.aI + var18;
                              this.aM = this.aN - var17;
                              this.aL = this.aM - var17;
                              var10000 = this;
                              var27 = this.aL;
                              var10002 = var18;
                              break label132;
                           }

                           if (var16 == 2) {
                              this.aH = this.aG + var17;
                              this.aI = this.aH + var18;
                              this.aJ = this.aI + var17;
                              var10000 = this;
                              var27 = this.aN;
                              var10002 = var17;
                           } else {
                              if (var16 != 3) {
                                 break label133;
                              }

                              this.aH = this.aG + var18;
                              this.aI = this.aH + var18;
                              this.aJ = this.aI + var17;
                              var10000 = this;
                              var27 = this.aN;
                              var10002 = var18;
                           }

                           var10000.aM = var27 - var10002;
                           var10000 = this;
                           var27 = this.aM;
                           var10002 = var18;
                        }

                        var10000.aL = var27 - var10002;
                        var10000 = this;
                        var27 = this.aL;
                        var10002 = var17;
                     }

                     var10000.aK = var27 - var10002;
                  }

                  this.aZ = true;
                  this.ba = true;
                  this.bb = true;
                  if (this.aH - this.aG != var17) {
                     this.aZ = false;
                  }

                  if (this.aI - this.aH != var17) {
                     this.ba = false;
                  }

                  if (this.aJ - this.aI != var17) {
                     this.bb = false;
                  }

                  label117: {
                     this.bL = 1;
                     byte var29;
                     if (this.aG >= this.bK) {
                        this.bL = 1;
                        var10000 = this;
                        var27 = this.aG + var17;
                        var29 = 1;
                     } else if (this.aG < this.bK && this.aH >= this.bK) {
                        this.bL = 2;
                        this.b(this.aH + this.bK - this.aG, 2);
                        var26 = this.aG + var17;
                        this.aG = this.bK;
                        this.aN = this.bK + '쭰';
                        var10000 = this;
                        var27 = var26;
                        var29 = 1;
                     } else if (this.aH < this.bK && this.aI >= this.bK) {
                        this.bL = 3;
                        this.b(this.aI + this.bK - this.aH, 3);
                        var26 = this.aH + var17;
                        this.aH = this.bK;
                        this.aM = this.bK + '쭰';
                        var10000 = this;
                        var27 = var26;
                        var29 = 2;
                     } else {
                        if (this.aI >= this.bK || this.aJ < this.bK) {
                           break label117;
                        }

                        this.bL = 4;
                        this.b(this.aJ + this.bK - this.aI, 4);
                        var26 = this.aI + var17;
                        this.aI = this.bK;
                        this.aL = this.bK + '쭰';
                        var10000 = this;
                        var27 = var26;
                        var29 = 3;
                     }

                     var10000.b(var27, var29);
                  }

                  var6 += var2;
                  if (var25 && this.bK >= 92 && this.bK <= 148) {
                     this.bN = this.bI;
                  }
               }
            }

            var10000 = this;
            var27 = this.bK + 1;
         }
      }
   }

   private void b(int var1, int var2) {
      this.aY = 0;
      a var10000;
      int var10001;
      byte[] var10002;
      byte[] var10003;
      byte[] var10004;
      byte[] var10005;
      if (this.bJ == 0) {
         int var3 = this.aC;
         this.aP = this.aG;
         this.aQ = this.aH;
         this.aR = this.aI;
         this.aS = this.aJ;
         this.b(var1, this.da, this.db, this.dc, this.dd, false, var2);
         this.aC = var3;
         this.aG = this.aP;
         this.aH = this.aQ;
         this.aI = this.aR;
         this.aJ = this.aS;
         this.aY = 1;
         var10000 = this;
         var10001 = var1;
         var10002 = this.cY;
         var10003 = this.cZ;
         var10004 = this.cY;
         var10005 = this.cZ;
      } else {
         if (this.bJ == 1) {
            this.b(var1, this.de, this.df, false, var2);
            return;
         }

         if (this.bJ == 2) {
            this.a(var1, this.dg, this.dh, true, var2);
            return;
         }

         if (this.bJ == 3) {
            this.b(var1, this.di, this.dj, this.dk, this.dl, false, var2);
            return;
         }

         if (this.bJ == 4) {
            this.aY = 1;
            var10000 = this;
            var10001 = var1;
            var10002 = this.dm;
            var10003 = this.dn;
            var10004 = this.dm;
            var10005 = this.dn;
         } else {
            if (this.bJ != 5) {
               return;
            }

            var10000 = this;
            var10001 = var1;
            var10002 = this.di;
            var10003 = this.dj;
            var10004 = this.dk;
            var10005 = this.dl;
         }
      }

      var10000.a(var10001, var10002, var10003, var10004, var10005, true, var2);
   }

   private void a(int var1, byte[] var2, byte[] var3, boolean var4, int var5) {
      if (this.bL != 4) {
         int var6 = var4 ? 2 : 1;
         if (var5 == 1 && this.aX != var6) {
            while(this.aG < var1) {
               this.aD = this.aC >> 16;
               this.aT = var2[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aG] = this.bm[this.aT];
               }

               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aH] = this.bm[this.aT];
               }

               this.aG += 240;
               this.aH += 240;
               this.aC += this.aF;
            }

            if (!this.aZ && var2[this.aE] != -1) {
               this.bn[this.aG] = this.bm[var2[this.aE]];
            }

            if (!this.ba && var3[this.aE] != -1) {
               this.bn[this.aH] = this.bm[var3[this.aE]];
            }
         }

         if (var5 == 2 && this.aX != var6) {
            while(this.aH < var1) {
               this.aD = this.aC >> 16;
               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aH] = this.bm[this.aT];
               }

               this.aH += 240;
               this.aC += this.aF;
            }

            if (this.bL == 2) {
               return;
            }

            if (!this.ba && var3[this.aE] != -1) {
               this.bn[this.aH] = this.bm[var3[this.aE]];
            }
         }

         if (var5 == 3 && this.aX != var6) {
            this.aC += (var1 - this.aI) / 240 * this.aF;
         }

      }
   }

   private void a(int var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5, boolean var6, int var7) {
      int var8 = var6 ? 2 : 1;
      if (var7 == 1 && this.aX != var8) {
         while(true) {
            if (this.aG >= var1) {
               if (this.aY == 0 && !this.aZ && var2[this.aE] != -1) {
                  this.bn[this.aG] = this.bm[var2[this.aE]];
               }

               if (this.aY == 0 && !this.ba && var3[this.aE] != -1) {
                  this.bn[this.aH] = this.bm[var3[this.aE]];
               }

               if (!this.bb && var4[this.aE] != -1) {
                  this.bn[this.aI] = this.bm[var4[this.aE]];
               }

               if (this.aJ != this.bK + 25920 || var5[this.aE] == -1) {
                  return;
               }
               break;
            }

            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aJ] = this.bm[this.aT];
            }

            this.aT = var4[this.aD];
            if (this.aT != -1) {
               this.bn[this.aI] = this.bm[this.aT];
            }

            if (this.aY == 0) {
               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aH] = this.bm[this.aT];
               }

               this.aT = var2[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aG] = this.bm[this.aT];
               }
            }

            this.aG += 240;
            this.aH += 240;
            this.aI += 240;
            this.aJ += 240;
            this.aC += this.aF;
         }
      } else if (var7 == 2 && this.aX != var8) {
         while(this.aH < var1) {
            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aJ] = this.bm[this.aT];
            }

            this.aT = var4[this.aD];
            if (this.aT != -1) {
               this.bn[this.aI] = this.bm[this.aT];
            }

            if (this.aY == 0) {
               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aH] = this.bm[this.aT];
               }
            }

            this.aH += 240;
            this.aI += 240;
            this.aJ += 240;
            this.aC += this.aF;
         }

         if (this.bL == 2) {
            return;
         }

         if (this.aY == 0 && !this.ba && var3[this.aE] != -1) {
            this.bn[this.aH] = this.bm[var3[this.aE]];
         }

         if (!this.bb && var4[this.aE] != -1) {
            this.bn[this.aI] = this.bm[var4[this.aE]];
         }

         if (this.aJ != this.bK + 25920 || var5[this.aE] == -1) {
            return;
         }
      } else if (var7 == 3 && this.aX != var8) {
         while(this.aI < var1) {
            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aJ] = this.bm[this.aT];
            }

            this.aT = var4[this.aD];
            if (this.aT != -1) {
               this.bn[this.aI] = this.bm[this.aT];
            }

            this.aI += 240;
            this.aJ += 240;
            this.aC += this.aF;
         }

         if (this.bL == 3) {
            return;
         }

         if (!this.bb && var4[this.aE] != -1) {
            this.bn[this.aI] = this.bm[var4[this.aE]];
         }

         if (this.aJ != this.bK + 25920 || var5[this.aE] == -1) {
            return;
         }
      } else {
         if (var7 != 4 || this.aX == var8) {
            return;
         }

         while(this.aJ < var1) {
            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aJ] = this.bm[this.aT];
            }

            this.aJ += 240;
            this.aC += this.aF;
         }

         if (this.bL == 4) {
            return;
         }

         if (this.aJ != this.bK + 25920 || var5[this.aE] == 0) {
            return;
         }
      }

      this.bn[this.aJ] = this.bm[var5[this.aE]];
   }

   private void b(int var1, byte[] var2, byte[] var3, boolean var4, int var5) {
      int var6 = this.aO - var1 + this.bK;
      if (this.bL != 4) {
         int var7 = var4 ? 2 : 1;
         if (var5 == 1 && this.aX != var7) {
            while(this.aN > var6) {
               this.aD = this.aC >> 16;
               this.aT = var2[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aN] = this.bm[this.aT];
               }

               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aM] = this.bm[this.aT];
               }

               this.aM -= 240;
               this.aN -= 240;
               this.aC += this.aF;
            }

            if (!this.aZ && var2[this.aE] != -1) {
               this.bn[this.aN] = this.bm[var2[this.aE]];
            }

            if (!this.ba && var3[this.aE] != -1) {
               this.bn[this.aM] = this.bm[var3[this.aE]];
            }
         }

         if (var5 == 2 && this.aX != var7) {
            while(this.aM > var6) {
               this.aD = this.aC >> 16;
               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aM] = this.bm[this.aT];
               }

               this.aM -= 240;
               this.aC += this.aF;
            }

            if (this.bL == 2) {
               return;
            }

            if (!this.ba && var3[this.aE] != -1) {
               this.bn[this.aM] = this.bm[var3[this.aE]];
            }
         }

         if (var5 == 3 && this.aX != var7) {
            this.aC += (this.aL - var6) / 240 * this.aF;
         }

      }
   }

   private void b(int var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5, boolean var6, int var7) {
      int var8 = this.aO - var1 + this.bK;
      int var9 = var6 ? 2 : 1;
      if (var7 == 1 && this.aX != var9) {
         while(true) {
            if (this.aN <= var8) {
               if (this.aY == 0 && !this.aZ && var2[this.aE] != -1) {
                  this.bn[this.aN] = this.bm[var2[this.aE]];
               }

               if (this.aY == 0 && !this.ba && var3[this.aE] != -1) {
                  this.bn[this.aM] = this.bm[var3[this.aE]];
               }

               if (!this.bb && var4[this.aE] != -1) {
                  this.bn[this.aL] = this.bm[var4[this.aE]];
               }

               if (this.aK != this.bK + 26160 || var5[this.aE] == -1) {
                  return;
               }
               break;
            }

            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aK] = this.bm[this.aT];
            }

            this.aT = var4[this.aD];
            if (this.aT != -1) {
               this.bn[this.aL] = this.bm[this.aT];
            }

            if (this.aY == 0) {
               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aM] = this.bm[this.aT];
               }

               this.aT = var2[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aN] = this.bm[this.aT];
               }
            }

            this.aK -= 240;
            this.aL -= 240;
            this.aM -= 240;
            this.aN -= 240;
            this.aC += this.aF;
         }
      } else if (var7 == 2 && this.aX != var9) {
         while(this.aM > var8) {
            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aK] = this.bm[this.aT];
            }

            this.aT = var4[this.aD];
            if (this.aT != -1) {
               this.bn[this.aL] = this.bm[this.aT];
            }

            if (this.aY == 0) {
               this.aT = var3[this.aD];
               if (this.aT != -1) {
                  this.bn[this.aM] = this.bm[this.aT];
               }
            }

            this.aK -= 240;
            this.aL -= 240;
            this.aM -= 240;
            this.aC += this.aF;
         }

         if (this.bL == 2) {
            return;
         }

         if (this.aY == 0 && !this.ba && var3[this.aE] != -1) {
            this.bn[this.aM] = this.bm[var3[this.aE]];
         }

         if (!this.bb && var4[this.aE] != -1) {
            this.bn[this.aL] = this.bm[var4[this.aE]];
         }

         if (this.aK != this.bK + 26160 || var5[this.aE] == -1) {
            return;
         }
      } else if (var7 == 3 && this.aX != var9) {
         while(this.aL > var8) {
            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aK] = this.bm[this.aT];
            }

            this.aT = var4[this.aD];
            if (this.aT != -1) {
               this.bn[this.aL] = this.bm[this.aT];
            }

            this.aK -= 240;
            this.aL -= 240;
            this.aC += this.aF;
         }

         if (this.bL == 3) {
            return;
         }

         if (!this.bb && var4[this.aE] != -1) {
            this.bn[this.aL] = this.bm[var4[this.aE]];
         }

         if (this.aK != this.bK + 26160 || var5[this.aE] == -1) {
            return;
         }
      } else {
         if (var7 != 4 || this.aX == var9) {
            return;
         }

         while(this.aK > var8) {
            this.aD = this.aC >> 16;
            this.aT = var5[this.aD];
            if (this.aT != -1) {
               this.bn[this.aK] = this.bm[this.aT];
            }

            this.aK -= 240;
            this.aC += this.aF;
         }

         if (this.bL == 4) {
            return;
         }

         if (this.aK != this.bK + 26160 || var5[this.aE] == -1) {
            return;
         }
      }

      this.bn[this.aK] = this.bm[var5[this.aE]];
   }

   private void m() {
      a var10000;
      if ((this.fY[2] || this.fY[8] || this.fY[1] || this.fY[3]) && this.eC - this.cF > 50L) {
         label98: {
            boolean var10001;
            if (this.gc < 3 && this.gg) {
               ++this.gc;
               if (this.gc != 3) {
                  break label98;
               }

               var10000 = this;
               var10001 = false;
            } else {
               if (this.gc <= -3 || this.gg) {
                  break label98;
               }

               --this.gc;
               if (this.gc != -3) {
                  break label98;
               }

               var10000 = this;
               var10001 = true;
            }

            var10000.gg = var10001;
         }

         this.cF = this.eC;
      }

      long var1;
      long var10002;
      label67: {
         if (this.fY[2]) {
            var10000 = this;
            var1 = this.cn;
            var10002 = this.cp;
         } else {
            if (!this.fY[8]) {
               break label67;
            }

            var10000 = this;
            var1 = this.co;
            var10002 = this.cq;
         }

         var10000.a(var1, var10002, 0);
      }

      label61: {
         byte var10003;
         if (this.fY[1]) {
            var10000 = this;
            var1 = this.cn;
            var10002 = this.cp;
            var10003 = 90;
         } else {
            if (!this.fY[3]) {
               break label61;
            }

            var10000 = this;
            var1 = this.cn;
            var10002 = this.cp;
            var10003 = -90;
         }

         var10000.a(var1, var10002, var10003);
      }

      label55: {
         int var2;
         if (this.fY[7]) {
            var10000 = this;
            var2 = this.eR + this.eV;
         } else {
            if (!this.fY[9]) {
               break label55;
            }

            var10000 = this;
            var2 = this.eR - this.eV;
         }

         var10000.eR = var2;
      }

      if (this.fY[4]) {
         this.eR += this.eT;
      } else if (this.fY[6]) {
         this.eR -= this.eT;
      } else {
         if (this.fL == -10000 && this.gf) {
            this.a(this.ga, this.gd, this.ge, this.gb);
            ++this.ga;
            if (this.ga == 4) {
               this.gf = false;
            }
         }

      }
   }

   private void a(int var1, long var2, long var4, int var6) {
      this.a(var2 >> (var1 >> 1), var4 >> (var1 >> 1), var6);
   }

   private void a(long var1, long var3, int var5) {
      long[] var6 = new long[2];
      int var7 = this.eR + var5;
      var6[0] = this.fz[0] - (var1 * this.r(var7) >> 16);
      var6[1] = this.fz[1] + (var1 * this.s(var7) >> 16);
      if (this.gB) {
         this.fz[0] = var6[0];
         this.fz[1] = var6[1];
      } else if (!this.b(var6)) {
         this.dJ = -1;
         this.ar = -1;
         if (this.a(var6)) {
            this.fz[0] = var6[0];
            this.fz[1] = var6[1];
         } else {
            if (this.dJ >= this.fa && this.dJ < this.fb) {
               this.ar = this.dJ;
            }

            int var8 = 0;

            while(this.dJ != -1) {
               this.a(this.dJ, var3, var7);
               ++var8;
               if (var8 >= 2) {
                  break;
               }
            }

         }
      }
   }

   private boolean a(long[] var1) {
      this.cr = this.fz[0];
      this.cs = this.fz[1];
      this.ct = var1[0];
      this.cu = var1[1];
      int var2 = this.cD[this.fk].length;
      short var10000 = 0;

      while(true) {
         short var3 = var10000;
         if (var10000 >= var2) {
            this.dJ = -1;
            return true;
         }

         short var4 = this.cD[this.fk][var3];
         short var5 = this.cE[this.fk][var3];
         var10000 = var4;

         while(true) {
            short var6 = var10000;
            if (var10000 > var5) {
               var10000 = (short)(var3 + 1);
               break;
            }

            if (this.p(var6)) {
               this.dJ = var6;
               return false;
            }

            var10000 = (short)(var6 + 1);
         }
      }
   }

   private boolean p(int var1) {
      if (this.bz[var1] == 1) {
         return false;
      } else {
         long var2 = (long)(this.cW[1][var1] - this.cW[3][var1]);
         long var4 = (long)(this.cW[2][var1] - this.cW[0][var1]);
         if ((var2 * this.cr >> 16) + (var4 * this.cs >> 16) + (long)this.cV[var1] > 0L) {
            return false;
         } else if ((var2 * this.ct >> 16) + (var4 * this.cu >> 16) + (long)this.cV[var1] < 0L) {
            return false;
         } else {
            this.a((short)((short)var1), (short)((short)(var1 + 1)), 1);
            if ((this.cv * this.ct >> 16) + (this.cw * this.cu >> 16) + this.cz > 0L) {
               return false;
            } else {
               return (this.cx * this.ct >> 16) + (this.cy * this.cu >> 16) + this.cA <= 0L;
            }
         }
      }
   }

   private void a(int var1, long var2, int var4) {
      long[] var6;
      (var6 = new long[2])[0] = this.fz[0];
      var6[1] = this.fz[1];
      long var7 = (long)(this.cW[1][var1] - this.cW[3][var1]);
      long var9 = (long)(this.cW[2][var1] - this.cW[0][var1]);
      long var11 = -(var7 * this.fz[0] >> 16) - (var9 * this.fz[1] >> 16);
      int var5 = this.c(var1, var4) ? 1 : -1;
      long[] var10000;
      byte var10001;
      long var10002;
      if (this.do[var1] != 0) {
         var6[0] -= (long)var5 * var2 * this.r(this.do[var1]) >> 16;
         var10000 = var6;
         var10001 = 1;
         var10002 = (-var11 - (var7 * var6[0] >> 16) << 16) / var9;
      } else {
         var10000 = var6;
         var10001 = 1;
         var10002 = var6[1] + (long)var5 * var2;
      }

      var10000[var10001] = var10002;
      if (this.a(var6)) {
         this.fz[0] = var6[0];
         this.fz[1] = var6[1];
      } else {
         if (this.dJ >= this.fa && this.dJ < this.fb) {
            this.ar = this.dJ;
         }

      }
   }

   private boolean c(int var1, int var2) {
      return this.s(var2 - this.do[var1]) >= 0L;
   }

   private boolean b(long[] var1) {
      long var2 = var1[0];
      long var4 = var1[1];
      int var7 = this.ci[this.fk].length;

      for(int var8 = 0; var8 < var7; ++var8) {
         byte var6 = this.ci[this.fk][var8];
         if (a(var2 - ((long)this.bT[var6][0] * 75000L >> 16)) < 30000L && a(var4 - ((long)this.bT[var6][1] * 75000L >> 16)) < 30000L && this.bY[this.cg[var6]] == 1) {
            if (this.cg[var6] != this.cB && this.cg[var6] != 15) {
               if (var6 >= 48) {
                  if (!this.cl[var6]) {
                     return false;
                  }

                  if (this.cd[var6] == this.cC + 2) {
                     return false;
                  }

                  if (this.cd[var6] == this.cC + 3) {
                     if (this.eL == 777) {
                        return false;
                     }

                     this.eL += 25;
                     this.ft = true;
                     this.eF = this.eC;
                  } else if (this.cd[var6] == this.cC + 4) {
                     if (this.eK == 100) {
                        return false;
                     }

                     this.eK += 25;
                     this.fu = true;
                     this.eG = this.eC;
                  } else if (this.cd[var6] == this.cC + 5) {
                     if (this.eL == 777 && this.eK == 100) {
                        return false;
                     }

                     if (this.eL == 777 && this.eK != 100) {
                        this.cd[var6] = (byte)(this.cC + 3);
                        this.cg[var6] = this.cd[var6];
                        this.eK += 25;
                        if (this.eK > 100) {
                           this.eK = 100;
                        }

                        this.fu = true;
                        this.eG = this.eC;
                        return false;
                     }

                     if (this.eL != 777 && this.eK == 100) {
                        this.cd[var6] = (byte)(this.cC + 4);
                        this.cg[var6] = this.cd[var6];
                        this.eL += 25;
                        if (this.eL > 777) {
                           this.eL = 777;
                        }

                        this.ft = true;
                        this.eF = this.eC;
                        return false;
                     }

                     this.ft = true;
                     this.fu = true;
                     this.eF = this.eC;
                     this.eG = this.eC;
                     this.eL += 25;
                     this.eK += 25;
                  }

                  if (this.eL > 777) {
                     this.eL = 777;
                  }

                  if (this.eK > 100) {
                     this.eK = 100;
                  }

                  this.cd[var6] = (byte)(this.cC + 2);
                  this.cg[var6] = this.cd[var6];
                  return false;
               }

               return true;
            }

            if (this.cf[var6] == 1) {
               if (this.eL == 777) {
                  return false;
               }

               this.eL += 10;
               if (this.eL > 777) {
                  this.eL = 777;
               }

               this.ft = true;
               this.eF = this.eC;
            } else if (this.cf[var6] == 2) {
               if (this.eK == 100) {
                  return false;
               }

               this.eK += 10;
               if (this.eK > 100) {
                  this.eK = 100;
               }

               this.fu = true;
               this.eG = this.eC;
            }

            this.cf[var6] = -1;
            return false;
         }
      }

      return false;
   }

   private void initMapArrays(int var1) {
      this.cW = new int[4][var1];
      this.by = new byte[var1];
   }

   private void d(int var1, int var2) {
      this.cI = new int[var1];
      this.cJ = new int[var1];
      this.cK = new int[var1];
      this.cL = new int[var1];
      this.cM = new int[var2];
      this.cN = new int[var2];
      this.cO = new int[var2];
      this.cP = new int[var2];
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.bp = new int[2][(16 + var3) * 50];
      this.bm = new int[50];
      this.cY = new byte[var1];
      this.cZ = new byte[var1];
      this.da = new byte[var1];
      this.db = new byte[var1];
      this.dc = new byte[var1];
      this.dd = new byte[var1];
      this.de = new byte[var2];
      this.df = new byte[var2];
      this.dg = new byte[var4];
      this.dh = new byte[var4];
      this.di = new byte[var5];
      this.dj = new byte[var5];
      this.dk = new byte[var5];
      this.dl = new byte[var5];
      this.dm = new byte[var6];
      this.dn = new byte[var6];
   }

   private void n() {
      this.cG = new long[this.eX];
      this.cH = new long[this.eX];
      this.cU = new int[this.eX];
      this.cV = new int[this.eX];
      this.do = new byte[this.eX];
      this.bQ = new long[this.cg.length];
      this.bR = new long[this.cg.length];
      this.bS = new long[this.cg.length];
      this.bV = new int[this.cg.length];
      this.bU = new int[this.cg.length];
      this.bP = new long[this.cg.length];
   }

   private void o() {
      this.cG = null;
      this.cH = null;
      System.gc();
      this.bB = new short[7][3][3];
   }

   private void a(boolean var1) {
      this.b(var1);
      this.gameLogoImage = null;
      this.gJ = null;
      if (!this.gB) {
         this.letterImages = (int[][])null;
      }

      this.gH = null;
      this.fD = null;
      this.fF = null;
      this.dN = (short[][])null;
      this.dD = null;
      this.ex = (int[][])null;
      this.cI = null;
      this.cJ = null;
      this.cK = null;
      this.cL = null;
      this.cM = null;
      this.cN = null;
      this.cO = null;
      this.cP = null;
      this.cQ = null;
      this.cR = null;
      this.cS = null;
      this.cT = null;
      this.cY = null;
      this.cZ = null;
      this.da = null;
      this.db = null;
      this.dc = null;
      this.dd = null;
      this.de = null;
      this.df = null;
      this.dg = null;
      this.dh = null;
      this.di = null;
      this.dj = null;
      this.dk = null;
      this.dl = null;
      this.dm = null;
      this.dn = null;
      this.bp = (int[][])null;
      this.dL = null;
      this.cU = null;
      this.cV = null;
      this.do = null;
      this.bQ = null;
      this.bR = null;
      this.bV = null;
      this.bS = null;
      this.bU = null;
      this.bP = null;
      this.bB = (short[][][])null;
      if (!var1) {
         System.gc();
      }

   }

   private void b(boolean var1) {
      this.bn = null;
      this.bo = (int[][])null;
      this.bC = null;
      this.bx = null;
      if (!var1) {
         System.gc();
      }

   }

   private void c(boolean var1) {
      this.FOE_METADATA = null;
      this.l = null;
      this.n = null;
      this.o = null;
      this.p = null;
      if (!this.gB) {
         this.r = null;
         this.gK = null;
         this.s = null;
         this.gL = null;
         this.t = null;
         this.u = null;
      }

      if (var1) {
         System.gc();
      }

   }

   private void p() {
      this.dM = (short[][])null;
      this.dO = null;
      this.dQ = null;
      this.dP = null;
      System.gc();
   }

   private void q() {
      int var2 = this.fb;

      for(int var1 = 0; var1 < this.eZ; ++var1) {
         this.modifyBigLump1_subfunction3(this.dp[var1], (long)this.dv[var1], (long)this.dx[var1], this.dr[var1], this.ds[var1], var2, 0);
         this.modifyBigLump1_subfunction3((short)((short)var2), (short)((short)(var2 + 3)), 1);
         var2 += 3;
      }

   }

   private int modifyBigLump1_subfunction3(int[] var1, long var2, long var4, int var6, int var7, int var8, int var9) {
      if (var9 == 0) {
         this.cW[var6][var8] = var1[var6];
         this.cW[var7][var8] = (int)((long)var1[var7] - (var2 >> 1));
         this.cW[var6 + 2][var8] = (int)((long)var1[var6] + var4);
         this.cW[var7 + 2][var8] = (int)((long)var1[var7] - (var2 >> 1));
      }

      int var10 = var8 + 1;
      this.cW[var6][var10] = this.cW[var6 + 2][var10 - 1];
      this.cW[var7][var10] = this.cW[var7 + 2][var10 - 1];
      this.cW[var6 + 2][var10] = this.cW[var6][var10];
      this.cW[var7 + 2][var10] = (int)((long)this.cW[var7][var10 - 1] + var2);
      ++var10;
      if (var9 == 0) {
         this.cW[var6][var10] = this.cW[var6 + 2][var10 - 1];
         this.cW[var7][var10] = this.cW[var7 + 2][var10 - 1];
         this.cW[var6 + 2][var10] = (int)((long)this.cW[var6][var10] - var4);
         this.cW[var7 + 2][var10] = this.cW[var7][var10];
      }

      return var10 + 1;
   }

   private void d(boolean var1) {
      int var4 = this.fb;

      for(int var2 = 0; var2 < this.eZ; ++var2) {
         label58: {
            byte var10000;
            if (this.dt[var2] == 8) {
               if (!var1) {
                  break label58;
               }

               var10000 = 12;
            } else {
               if (var1) {
                  break label58;
               }

               var10000 = 30;
            }

            byte var3 = var10000;
            if (this.dt[var2] != -1) {
               if (this.dB[var2] == -1) {
                  this.bz[var4 + 1] = 1;
               } else if (this.dB[var2] < this.dt[var2]) {
                  this.dC = true;
                  this.bz[var4 + 1] = 0;
                  this.e(-1, var2);
                  this.modifyBigLump1_subfunction3(this.dp[var2], (long)this.dv[var2], (long)this.dx[var2], this.dr[var2], this.ds[var2], var4, 0);
                  this.modifyBigLump1_subfunction3((short)((short)var4), (short)((short)(var4 + 3)), 1);
               } else {
                  label66: {
                     int var10001;
                     int var10002;
                     int[] var5;
                     if (this.dB[var2] < var3) {
                        var5 = this.dB;
                        var10001 = var2;
                        var10002 = var5[var2] + 1;
                     } else if (this.dB[var2] < var3 + this.dt[var2]) {
                        if (a(this.fz[0] - ((long)this.dq[var2][0] * 75000L >> 16)) >= 75000L || a(this.fz[1] - ((long)this.dq[var2][1] * 75000L >> 16)) >= 75000L) {
                           this.e(1, var2);
                           this.a(this.dp[var2], (long)this.dv[var2], (long)this.dx[var2], this.dr[var2], this.ds[var2], var4, 0);
                           this.a((short)((short)var4), (short)((short)(var4 + 3)), 1);
                           break label66;
                        }

                        var5 = this.dB;
                        var10001 = var2;
                        var10002 = this.dt[var2] - (this.dB[var2] - var3);
                     } else {
                        this.dC = false;
                        var5 = this.dB;
                        var10001 = var2;
                        var10002 = -1;
                     }

                     var5[var10001] = var10002;
                  }
               }
            }
         }

         var4 += 3;
      }

   }

   private void e(int var1, int var2) {
      int[] var10000 = this.dx;
      var10000[var2] += var1 * this.dy[var2];
      this.dz[var2] = (int)((long)this.dz[var2] - (long)(var1 * abs(this.dy[var2])) * 96L);
      this.dA[var2] = (int)((long)this.dA[var2] + (long)(var1 * abs(this.dy[var2])) * 96L);
      int var10002 = this.dB[var2]++;
   }

   private void r() {
      boolean var1 = this.dC;

      for(int var2 = 0; var2 < this.eZ; ++var2) {
         if (a(this.fz[0] - ((long)this.dq[var2][0] * 75000L >> 16)) < 75000L && a(this.fz[1] - ((long)this.dq[var2][1] * 75000L >> 16)) < 75000L) {
            if (var2 == this.eS) {
               ++this.selectedMap;
               if (this.selectedMap == 3 && this.c == 1) {
                  this.gm = 0;
                  this.b(false);
                  this.go = 0;
                  this.gp = 1;
                  this.gz = true;
                  this.gA = false;
                  this.fg = 2;
                  this.gm = 30;
                  this.A(9);
                  this.ex = (int[][])null;
                  System.gc();
                  this.et = true;
                  this.e = true;
                  return;
               }

               if (this.selectedMap != 10) {
                  if (this.hA < this.selectedMap) {
                     this.hA = this.selectedMap;
                  }

                  this.hx[this.selectedMap - 1] = this.ek;
                  this.hy[this.selectedMap - 1] = this.eK;
                  this.hz[this.selectedMap - 1] = this.eL;

                  try {
                     if (this.hp != null) {
                        this.hp.stop();
                     }
                  } catch (Exception var5) {
                  }

                  this.ac();
               }

               this.fw = true;
               this.fr = true;
               this.eO = this.ek;
               this.eM = this.eK;
               this.eN = this.eL;
               this.cl[13] = false;
               this.cl[14] = false;
               return;
            }

            if (this.dB[var2] == -1 && this.dt[var2] != -1 && (this.fk == this.du[var2] || !this.dC)) {
               var1 = true;
               this.dB[var2] = 0;
               if (this.fk != this.du[var2]) {
                  this.dD = null;
                  System.gc();
                  this.fk = this.du[var2];
                  this.dD = new d(this, this.dN[this.fk][0], (c)null);
                  int var3 = this.dN[this.fk].length;

                  for(int var4 = 1; var4 < var3; ++var4) {
                     d.a(this.dD, this.dN[this.fk][var4]);
                  }
               }
            }
         }
      }

      this.dC = var1;
   }

   private void s() {
      this.dL = new int[91];
      this.dL[1] = 1146;
      int var1 = 1146;

      for(int var2 = 2; var2 <= 90; ++var2) {
         var1 += this.a[var2 - 2];
         this.dL[var2] = this.dL[var2 - 1] + var1;
      }

      this.a = null;
   }

   private long r(int var1) {
      if (var1 < 0) {
         return -this.r(-var1);
      } else if (var1 >= 90 & var1 < 180) {
         return (long)this.dL[180 - var1];
      } else if (var1 >= 180 & var1 < 270) {
         return (long)(-this.dL[var1 - 180]);
      } else if (var1 >= 270 & var1 < 360) {
         return (long)(-this.dL[90 - (var1 - 270)]);
      } else {
         return var1 >= 360 ? this.r(var1 % 360) : (long)this.dL[var1];
      }
   }

   private long s(int var1) {
      return this.r(90 - var1);
   }

   private static int abs(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   private static long a(long var0) {
      return var0 > 0L ? var0 : -var0;
   }

   private void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.dE = (long)var1 * (20000L * this.r(this.do[var6]) >> 16) + ((long)this.cW[1][var6] * 75000L >> 16);
      this.dF = (long)var2 * (20000L * this.s(90 - this.do[var6]) >> 16) + ((long)this.cW[0][var6] * 75000L >> 16);
      this.dH = (long)var3 * (20000L * this.s(90 + this.do[var6]) >> 16) + ((long)this.cW[2][var6] * 75000L >> 16);
      this.dG = (long)var4 * (20000L * this.r(90 - this.do[var6]) >> 16) + ((long)this.cW[1][var6] * 75000L >> 16);
      this.dI = (long)var5 * (20000L * this.r(90 + this.do[var6]) >> 16) + ((long)this.cW[3][var6] * 75000L >> 16);
   }

   private void a(short var1, short var2, int var3) {
      short var10000 = var1;

      while(true) {
         short var14 = var10000;
         if (var10000 >= var2) {
            return;
         }

         long var10 = (long)(this.cW[1][var14] - this.cW[3][var14]);
         long var12 = (long)(this.cW[2][var14] - this.cW[0][var14]);
         this.cU[var14] = (int)(-(var10 * (long)this.cW[0][var14] >> 16) - (var12 * (long)this.cW[1][var14] >> 16));
         byte var10002;
         if (var3 == 0 || var3 == 2) {
            label63: {
               byte[] var16;
               short var10001;
               if (var10 == 0L) {
                  var16 = this.do;
                  var10001 = var14;
                  var10002 = -90;
               } else {
                  long var4;
                  long var6 = (var4 = (var12 << 16) / var10) < 0L ? -var4 : var4;
                  this.do[var14] = 0;
                  if (var6 > 3746989L) {
                     var16 = this.do;
                     var10001 = var14;
                     var10002 = 89;
                  } else {
                     byte var17 = this.do[var14];

                     while(true) {
                        byte var15 = var17;
                        if ((this.r(var15) << 16) / this.r(90 - var15) >= var6) {
                           var16 = this.do;
                           var10001 = var14;
                           var10002 = var15;
                           break;
                        }

                        var17 = (byte)(var15 + 1);
                     }
                  }

                  var16[var10001] = var10002;
                  if (var4 >= 0L) {
                     break label63;
                  }

                  var16 = this.do;
                  var10001 = var14;
                  var10002 = (byte)(-this.do[var14]);
               }

               var16[var10001] = var10002;
            }

            if (var3 == 0) {
               this.cG[var14] = var10;
               this.cH[var14] = var12;
            }
         }

         long var8;
         a var18;
         byte var19;
         byte var10003;
         byte var10004;
         byte var10005;
         if (this.cW[1][var14] <= this.cW[3][var14]) {
            var8 = (20000L * this.s(this.do[var14]) >> 16) + ((long)this.cW[0][var14] * 75000L >> 16);
            if (this.do[var14] != -90) {
               var18 = this;
               var19 = 1;
               var10002 = 1;
               var10003 = 1;
               var10004 = -1;
               var10005 = 1;
            } else if (this.cW[0][var14] < this.cW[2][var14]) {
               var18 = this;
               var19 = 1;
               var10002 = 1;
               var10003 = 1;
               var10004 = 1;
               var10005 = 1;
            } else {
               var18 = this;
               var19 = -1;
               var10002 = -1;
               var10003 = -1;
               var10004 = 1;
               var10005 = 1;
            }
         } else {
            var8 = -(20000L * this.s(this.do[var14]) >> 16) + ((long)this.cW[0][var14] * 75000L >> 16);
            var18 = this;
            var19 = -1;
            var10002 = -1;
            var10003 = -1;
            var10004 = 1;
            var10005 = -1;
         }

         var18.b(var19, var10002, var10003, var10004, var10005, var14);
         this.cV[var14] = (int)(-(var10 * var8 >> 16) - (var12 * this.dE >> 16));
         this.cv = var12;
         this.cw = -var10;
         this.cx = -var12;
         this.cy = var10;
         this.cz = (long)((int)(-(var12 * this.dF >> 16) + (var10 * this.dG >> 16)));
         this.cA = (long)((int)((var12 * this.dH >> 16) - (var10 * this.dI >> 16)));
         if (((var12 * (long)this.cW[0][var14] >> 16) * 75000L >> 16) + ((-var10 * (long)this.cW[1][var14] >> 16) * 75000L >> 16) + this.cz >= 0L) {
            this.cv = -var12;
            this.cw = var10;
            this.cx = var12;
            this.cy = -var10;
            this.cz = -this.cz;
            this.cA = -this.cA;
         }

         var10000 = (short)(var14 + 1);
      }
   }

   private void t() {
      this.a((short)0, (short)((short)this.eX), 0);
   }

   private void u(int var1) {
      this.dM = new short[this.eX][];
      this.dO = new short[this.eX];
      int var14 = this.cD[var1].length;
      short var10000 = 0;

      while(true) {
         short var16 = var10000;
         if (var10000 >= var14) {
            return;
         }

         short var19 = this.cD[var1][var16];
         short var20 = this.cE[var1][var16];
         var10000 = var19;

         while(true) {
            short var15 = var10000;
            if (var10000 > var20) {
               var10000 = (short)(var16 + 1);
               break;
            }

            this.dM[var15] = new short[43];
            long var6 = (long)this.cW[0][var15];
            long var8 = (long)this.cW[1][var15];
            long var10 = (long)this.cW[2][var15];
            long var12 = (long)this.cW[3][var15];
            short var23 = 0;
            var10000 = 0;

            while(true) {
               short var18 = var10000;
               if (var10000 >= var14) {
                  var10000 = (short)(var15 + 1);
                  break;
               }

               short var21 = this.cD[var1][var18];
               short var22 = this.cE[var1][var18];
               var10000 = var21;

               while(true) {
                  short var17 = var10000;
                  if (var10000 > var22) {
                     this.dO[var15] = var23;
                     var10000 = (short)(var18 + 1);
                     break;
                  }

                  long var2 = (this.cG[var17] * var6 >> 16) + (this.cH[var17] * var8 >> 16) + (long)this.cU[var17];
                  long var4 = (this.cG[var17] * var10 >> 16) + (this.cH[var17] * var12 >> 16) + (long)this.cU[var17];
                  if (var2 * var4 < 0L) {
                     this.dM[var15][var23] = var17;
                     ++var23;
                  }

                  var10000 = (short)(var17 + 1);
               }
            }
         }
      }
   }

   private void v(int var1) {
      this.dQ = new boolean[this.eX];
      this.dP = new short[this.eX];
      int var2 = this.cD[var1].length;
      short var10000 = 0;

      while(true) {
         short var5 = var10000;
         if (var10000 >= var2) {
            return;
         }

         short var3 = this.cD[var1][var5];
         short var4 = this.cE[var1][var5];
         var10000 = var3;

         while(true) {
            short var6 = var10000;
            if (var10000 > var4) {
               var10000 = (short)(var5 + 1);
               break;
            }

            if (!this.dQ[var6]) {
               this.a(var6, var1);
            }

            var10000 = (short)(var6 + 1);
         }
      }
   }

   private void a(short var1, int var2) {
      int var3 = this.cD[var2].length;
      short var10000 = 0;

      while(true) {
         short var7 = var10000;
         if (var10000 >= var3) {
            this.dP[this.dK] = var1;
            this.dQ[var1] = true;
            ++this.dK;
            return;
         }

         short var4 = this.cD[var2][var7];
         short var5 = this.cE[var2][var7];
         var10000 = var4;

         while(true) {
            short var8 = var10000;
            if (var10000 > var5) {
               var10000 = (short)(var7 + 1);
               break;
            }

            if (!this.dQ[var8]) {
               short var6 = this.dO[var8];

               for(int var9 = 0; var9 < var6; ++var9) {
                  if (this.dM[var8][var9] == var1) {
                     this.a(var8, var2);
                  }
               }
            }

            var10000 = (short)(var8 + 1);
         }
      }
   }

   private void w(int var1) {
      this.dK = 0;
      this.u(var1);
      this.v(var1);
      int var2 = 0;
      short var10000 = 0;

      while(true) {
         short var4 = var10000;
         short var3;
         if (var10000 >= this.cD[var1].length) {
            this.dN[var1] = new short[var2];
            var10000 = 0;

            while(true) {
               var3 = var10000;
               if (var10000 >= var2) {
                  return;
               }

               this.dN[var1][var3] = this.dP[var3];
               var10000 = (short)(var3 + 1);
            }
         }

         var10000 = this.cD[var1][var4];

         while(true) {
            var3 = var10000;
            if (var10000 > this.cE[var1][var4]) {
               var10000 = (short)(var4 + 1);
               break;
            }

            ++var2;
            var10000 = (short)(var3 + 1);
         }
      }
   }

   private void f(int var1, int var2) {
      this.eb = false;
      this.dZ = (int)(a((long)this.bT[var1][0] - this.eI) >> 16);
      this.ea = (int)(a((long)this.bT[var1][1] - this.eJ) >> 16);
      if (this.dZ <= var2 && this.ea <= var2) {
         this.dS = (long)this.bT[var1][0] * 75000L >> 16;
         this.dT = (long)this.bT[var1][1] * 75000L >> 16;
         this.dU = this.fz[1] - this.dT;
         this.dV = this.dS - this.fz[0];
         this.dW = -(this.dU * this.fz[0] >> 16) - (this.dV * this.fz[1] >> 16);
         this.dX = this.dU * 75000L >> 16;
         this.dY = this.dV * 75000L >> 16;
         int var3 = this.cD[this.fk].length;
         short var10000 = 0;

         while(true) {
            short var4 = var10000;
            if (var10000 >= var3) {
               this.eb = true;
               break;
            }

            short var5 = this.cD[this.fk][var4];
            short var6 = this.cE[this.fk][var4];
            var10000 = var5;

            while(true) {
               short var7 = var10000;
               if (var10000 > var6) {
                  var10000 = (short)(var4 + 1);
                  break;
               }

               if (this.by[var7] != 1 && !this.x(var7)) {
                  this.eb = false;
                  return;
               }

               var10000 = (short)(var7 + 1);
            }
         }
      }

   }

   private boolean x(int var1) {
      long var2 = (this.dX * (long)this.cW[0][var1] >> 16) + (this.dY * (long)this.cW[1][var1] >> 16) + this.dW;
      long var4 = (this.dX * (long)this.cW[2][var1] >> 16) + (this.dY * (long)this.cW[3][var1] >> 16) + this.dW;
      if (var2 * var4 < 0L) {
         long var6 = (long)(this.cW[1][var1] - this.cW[3][var1]);
         long var8 = (long)(this.cW[2][var1] - this.cW[0][var1]);
         var2 = (var6 * this.fz[0] >> 16) + (var8 * this.fz[1] >> 16) + ((long)this.cU[var1] * 75000L >> 16);
         var4 = (var6 * this.dS >> 16) + (var8 * this.dT >> 16) + ((long)this.cU[var1] * 75000L >> 16);
         if (var2 * var4 < 0L) {
            return false;
         }
      }

      return true;
   }

   private void y(int var1) {
      for(int var4 = 0; var4 < this.eP; ++var4) {
         if (!this.cl[var4]) {
            byte[] var5;
            byte var9;
            int var10001;
            if ((this.cg[var4] == 9 || this.cg[var4] == 10) && this.ca[var4] <= 0) {
               var5 = this.cg;
               var10001 = var4;
               var9 = 8;
            } else {
               a var10000;
               byte var10002;
               if ((this.ca[var4] != 32 || this.selectedMap != 9) && this.ca[var4] > 0) {
                  var10000 = this;
                  var10001 = var4;
                  var10002 = 0;
               } else {
                  var10000 = this;
                  var10001 = var4;
                  var10002 = 2;
               }

               var10000.f(var10001, var10002);
               int[] var6;
               if (this.selectedMap == 9) {
                  if (this.ca[var4] == 32 && !this.ee && (this.cg[var4] != 33 || this.F() % 7 == 0)) {
                     if (this.cg[var4] < 33) {
                        this.cg[var4] = 33;
                     }

                     if (this.eb) {
                        this.ck[var4] = true;
                        if (this.cg[var4] != 36) {
                           if (this.ei[var4] != 1) {
                              ++this.cg[var4];
                              int var7 = this.ei[var4]++;
                           } else {
                              --this.cg[var4];
                              var6 = this.ei;
                              var6[var4] += 9;
                           }
                        } else {
                           this.cg[var4] = 33;
                           this.ei[var4] = -1;
                           this.ee = true;
                        }
                     } else {
                        if (this.ck[var4]) {
                           var5 = this.cg;
                           var10001 = var4;
                           var10002 = 33;
                        } else {
                           var5 = this.cg;
                           var10001 = var4;
                           var10002 = 32;
                        }

                        var5[var10001] = var10002;
                     }
                  }

                  if (this.ca[var4] == 32) {
                     continue;
                  }
               }

               if (this.ca[var4] > 0) {
                  if (this.eb) {
                     var5 = this.cg;
                     var10001 = var4;
                     var9 = (byte)(this.ca[var4] + 1);
                  } else {
                     if (this.cg[var4] == (byte)(this.ca[var4] + 1)) {
                        continue;
                     }

                     var5 = this.cg;
                     var10001 = var4;
                     var9 = this.ca[var4];
                  }
               } else {
                  if (!this.eb) {
                     this.ck[var4] = false;
                  } else {
                     int var3 = this.F();
                     int var2 = this.dZ + this.ea;
                     if (var3 % 1 == 0 || this.cg[var4] == 8 && this.bZ[var4] != -1 || this.ck[var4]) {
                        this.cg[var4] = 8;
                        this.ck[var4] = true;
                        if (this.F() % 2 == 0) {
                           this.cg[var4] = 9;
                           if (this.F() % 2 == 0) {
                              this.eK -= this.ed[var2] * this.fq;
                              if (this.eK <= 0 && !this.ec) {
                                 this.eK = 0;
                                 this.G();
                                 this.eK = this.eM;
                                 this.eL = this.eN;
                                 this.ek = this.eO;
                                 return;
                              }
                           }
                        }
                        continue;
                     }
                  }

                  if (var1 != 1) {
                     continue;
                  }

                  if (this.bZ[var4] == -1) {
                     var5 = this.cg;
                     var10001 = var4;
                     var9 = 8;
                  } else {
                     if (this.cg[var4] >= 8) {
                        this.cg[var4] = 0;
                     }

                     boolean[] var8;
                     boolean var10;
                     if (this.cj[var4]) {
                        var8 = this.cj;
                        var10001 = var4;
                        var10 = false;
                     } else {
                        var8 = this.cj;
                        var10001 = var4;
                        var10 = true;
                     }

                     var8[var10001] = var10;
                     if (this.cc[var4] == 1) {
                        if (this.cb[var4] < this.bZ[var4]) {
                           var6 = this.bT[var4];
                           var6[0] = (int)((long)var6[0] - (7498L * this.r(this.bW[var4]) >> 16));
                           var6 = this.bT[var4];
                           var6[1] = (int)((long)var6[1] + (7498L * this.s(this.bW[var4]) >> 16));
                           var5 = this.cb;
                           var10001 = var4;
                           var9 = (byte)(var5[var4] + 1);
                        } else if (this.cb[var4] == this.bZ[var4]) {
                           this.cg[var4] = 8;
                           var5 = this.cb;
                           var10001 = var4;
                           var9 = (byte)(var5[var4] + 1);
                        } else {
                           this.cb[var4] = 1;
                           var5 = this.cc;
                           var10001 = var4;
                           var9 = 2;
                        }
                     } else if (this.cb[var4] < this.bZ[var4]) {
                        var6 = this.bT[var4];
                        var6[0] = (int)((long)var6[0] + (7498L * this.r(this.bW[var4]) >> 16));
                        var6 = this.bT[var4];
                        var6[1] = (int)((long)var6[1] - (7498L * this.s(this.bW[var4]) >> 16));
                        var5 = this.cb;
                        var10001 = var4;
                        var9 = (byte)(var5[var4] + 1);
                     } else if (this.cb[var4] == this.bZ[var4]) {
                        this.cg[var4] = 8;
                        var5 = this.cb;
                        var10001 = var4;
                        var9 = (byte)(var5[var4] + 1);
                     } else {
                        this.cb[var4] = 1;
                        var5 = this.cc;
                        var10001 = var4;
                        var9 = 1;
                     }
                  }
               }
            }

            var5[var10001] = var9;
         }
      }

   }

   private void u() {
      this.ed = new int[5];
      this.ed[0] = 10;
      this.ed[1] = 6;
      this.ed[2] = 4;
      this.ed[3] = 2;
      this.ed[4] = 2;
   }

   private void c(Graphics var1) {
      var1.setColor(85, 0, 0);
      var1.drawRect(this.i[this.el], -1, 77, 42);
      var1.setColor(175, 0, 0);
      var1.drawRect(this.i[this.ek], -1, 77, 42);
   }

   private void a(Image var1, int[] var2, int var3, int var4, int var5, int var6, boolean var7) {
      int var8;
      if (var7) {
         int[] var12 = new int[var2.length];
         var1.getRGB(var12, 0, var3, var5, var6, var3, var4);
         int var10 = 0;

         for(var8 = 0; var8 < var4; ++var8) {
            int var11 = (var8 + 1) * var3 - 1;

            for(int var9 = 0; var9 < var3; ++var9) {
               var2[var10] = var12[var11];
               ++var10;
               --var11;
            }
         }
      } else {
         var1.getRGB(var2, 0, var3, var5, var6, var3, var4);
      }

      int var13 = var2.length;

      for(var8 = 0; var8 < var13; ++var8) {
         if (var2[var8] == this.BACKGROUND_COLOR) {
            var2[var8] = 0;
         }
      }

   }

   private void a(int var1, int var2, int var3, int var4, Graphics var5) {
      if (this.ew[var2] > var4 || var2 == 2) {
         label69: {
            a var10000;
            short var10001;
            if (this.ek == 1) {
               this.ez = 207 + abs(this.F()) % 20;
               var10000 = this;
               var10001 = 190;
            } else {
               if (this.ek != 0) {
                  break label69;
               }

               if (this.eu) {
                  var10000 = this;
                  var10001 = 215;
               } else {
                  var10000 = this;
                  var10001 = 0;
               }

               var10000.ez = var10001 + abs(this.F()) % 17;
               var10000 = this;
               var10001 = 195;
            }

            var10000.eA = var10001 - abs(this.F()) % 7;
            this.eB = abs(this.F()) % 3 + 6;
         }

         Graphics var6;
         int[] var7;
         byte var10002;
         int var10003;
         int var10004;
         int var10005;
         int var10006;
         int var10007;
         if (var1 == 0) {
            var5.drawRGB(this.ex[var2], 0, this.ev[var2], 240 - this.ev[var2], 256 - this.ew[var2] + var4, this.ev[var2], this.ew[var2] - var4, true);
            var5.drawRGB(this.ex[var3 + 2], 0, this.ev[var3], 0, 256 - this.ew[var3] + var4, this.ev[var3], this.ew[var3] - var4, true);
            if (var2 == 0 && var3 == 0) {
               return;
            }

            var6 = var5;
            var7 = this.ex[this.eB];
            var10002 = 0;
            var10003 = this.ev[6];
            var10004 = this.ez;
            var10005 = this.eA;
            var10006 = this.ev[6];
            var10007 = this.ew[6];
         } else {
            label61: {
               int[] var8;
               int var10008;
               if (var1 == 1) {
                  if (var2 != 0) {
                     var5.drawRGB(this.ex[var2], 0, this.ev[var2], 240 - this.ev[var2], 256 - this.ew[var2] + var4, this.ev[var2], this.ew[var2] - var4, true);
                     var6 = var5;
                     var7 = this.ex[this.eB];
                     var10002 = 0;
                     var10003 = this.ev[6];
                     var10004 = this.ez;
                     var10005 = this.eA;
                     var10006 = this.ev[6];
                     var10007 = this.ew[6];
                     break label61;
                  }

                  var6 = var5;
                  var7 = this.ex[var2];
                  var10002 = 0;
                  var10003 = this.ev[var2];
                  var10004 = 240 - this.ev[var2];
                  var10005 = 256 - this.ew[var2] + var4;
                  var10006 = this.ev[var2];
                  var8 = this.ew;
                  var10008 = var2;
               } else {
                  label78: {
                     if (var1 != 2) {
                        return;
                     }

                     if (var2 == 0) {
                        if (this.en == 0 || this.eC - this.fT > 500L) {
                           var6 = var5;
                           var7 = this.ex[var2];
                           var10002 = 0;
                           var10003 = this.ev[var2];
                           var10004 = 240 - this.ev[var2];
                           var10005 = 256 - this.ew[var2] + var4;
                           var10006 = this.ev[var2];
                           var8 = this.ew;
                           var10008 = var2;
                           break label78;
                        }

                        var6 = var5;
                     } else {
                        if (this.eC - this.fT > 500L) {
                           var6 = var5;
                           var7 = this.ex[var2];
                           var10002 = 0;
                           var10003 = this.ev[var2];
                           var10004 = 240 - this.ev[var2];
                           var10005 = 256 - this.ew[var2] + var4;
                           var10006 = this.ev[var2];
                           var8 = this.ew;
                           var10008 = var2;
                           break label78;
                        }

                        var6 = var5;
                     }

                     var7 = this.ex[4];
                     var10002 = 0;
                     var10003 = this.ev[4];
                     var10004 = 240 - this.ev[4];
                     var10005 = 256 - this.ew[4] + var4;
                     var10006 = this.ev[4];
                     var8 = this.ew;
                     var10008 = 4;
                  }
               }

               var10007 = var8[var10008] - var4;
            }
         }

         var6.drawRGB(var7, var10002, var10003, var10004, var10005, var10006, var10007, true);
      }
   }

   private void v() {
      if (this.eq == 53 && this.en == 1 || this.ar != -1) {
         if (this.bN != -1 && this.ar == -1) {
            this.x();
         } else if (this.aq != -1 || this.ar != -1) {
            this.w();
         }
      }

      this.aq = -1;
      this.bN = -1;
   }

   private void w() {
      if (this.ar != -1) {
         this.aq = this.ar;
      }

      if (this.aq != -1 && (this.eC - this.fT >= 500L || this.ek != 2)) {
         int var1;
         int var2;
         for(var2 = var1 = this.aq - (this.aq - this.fa) % 4; var2 < var1 + 4; ++var2) {
            this.bz[var2] = 1;
         }

         var2 = this.aq - this.fa >> 2;
         int var3 = 48 + var2;
         this.cl[var3] = true;
         this.cm[var3] = true;
      }
   }

   private void x() {
      if (this.ek != 2 || this.eC - this.fT > 500L) {
         this.cl[this.bN] = true;
      }

   }

   private void b(int var1, int var2, int var3, int var4, int var5) {
      for(int var6 = 0; var6 < this.eP; ++var6) {
         if (this.z[var6] == var1 && this.cl[var6] && this.ca[var6] >= var4 && this.ca[var6] <= var5) {
            byte[] var10000;
            int var10001;
            byte var10002;
            int var10003;
            if (this.ca[var6] == 32 && this.selectedMap == 9) {
               var10000 = this.ce;
               var10001 = var6;
               var10002 = var10000[var6];
               var10003 = 2;
            } else {
               var10000 = this.ce;
               var10001 = var6;
               var10002 = var10000[var6];
               var10003 = t(this.ca[var6]);
            }

            var10000[var10001] = (byte)(var10002 - var10003 * (this.ek + 1));
            if (this.ce[var6] > 0) {
               this.cl[var6] = false;
               if (this.F() % 3 == 0 && this.ca[var6] < 0) {
                  this.cg[var6] = 10;
               }
            }

            if (this.ce[var6] <= 0) {
               this.ce[var6] = 0;
               if (this.cg[var6] >= var2 && (this.cg[var6] < var2 + 2 || var4 == -100)) {
                  if (this.cg[var6] < var3) {
                     ++this.cg[var6];
                  } else if (this.selectedMap == 9 && (var6 == 13 || var6 == 14)) {
                     this.fx = true;
                     this.aa();
                     this.gm = 21;
                     this.gi = this.eC;
                  }
               } else {
                  this.cg[var6] = (byte)var2;
               }

               if (this.bX[var6] != 255) {
                  this.cX[this.bX[var6]] = this.fp;
               }
            }
         }
      }

   }

   private void y() {
      for(int var1 = 48; var1 < 48 + this.eY; ++var1) {
         if (this.cl[var1]) {
            byte[] var10000;
            int var10001;
            byte var10002;
            if (this.cg[var1] < this.cC + 1) {
               var10000 = this.cg;
               var10001 = var1;
               var10002 = (byte)(var10000[var1] + 1);
            } else {
               var10000 = this.cg;
               var10001 = var1;
               var10002 = this.cd[var1];
            }

            var10000[var10001] = var10002;
         }
      }

   }

   private void z() {
      if (!this.fY[0] && this.em >= 5) {
         if (this.fL == -10000 && !this.es) {
            this.eo = 0;
            this.ep = -1;
         }

      } else if (!this.es) {
         if (this.em < 5) {
            ++this.em;
         }

         if (this.em == 5) {
            this.em = 6;
         } else {
            this.ej = (this.ek + 1) % 3;
            this.eo = 0;
            this.ep = -1;
            this.es = true;
         }
      }
   }

   private void b(int var1, int var2, int var3) {
      ++this.ep;
      if (this.ep < var2) {
         this.eo += var1 * 2;
      } else if (this.ep < var3) {
         this.eo -= var1 * 2;
      } else {
         if (this.ep == var3) {
            this.eo -= var1 * 2;
            this.ep = -1;
         }

      }
   }

   private void A() {
      if (this.eL > 0) {
         this.en = 1 - this.en;
         if (this.en == 1 && this.eq == 53) {
            if (this.ek != 2 || this.eC - this.fT > 500L) {
               this.eL -= 1 + this.ek;
            }

            if (this.eL <= 0) {
               this.eL = 0;
               this.fK = -10000;
            }
         }

      }
   }

   private void B() {
      if (this.es) {
         this.b(10, 4, 7);
         if (this.ep == 4) {
            this.el = this.ek;
            this.ek = this.ej;
            this.et = true;
            return;
         }

         if (this.ep == -1) {
            this.es = false;
         }
      }

   }

   private void C() {
      int var1;
      for(var1 = 26032; var1 < 26038; ++var1) {
         this.bn[var1] = 16777215;
         this.bn[var1 + 9] = 16777215;
      }

      for(var1 = 24359; var1 < 25799; var1 += 240) {
         this.bn[var1] = 16777215;
         this.bn[var1 + 2160] = 16777215;
      }

   }

   private void D() {
      boolean var2 = false;

      int var1;
      for(var1 = 0; var1 < 480; ++var1) {
         this.bn[var1] = 10616832;
         this.bn['챟' - var1] = 10616832;
      }

      char var3 = '챟';

      for(var1 = 0; var1 < var3; var1 += 240) {
         this.bn[var1] = 10616832;
         this.bn[var1 + 1] = 10616832;
         this.bn[var1 + 238] = 10616832;
         this.bn[var1 + 239] = 10616832;
      }

   }

   private void E() {
      if (this.u == null) {
         this.readMetadata();
      }

      this.T();
      if (this.letterImages == null) {
         this.initLettersAndGameLogo();
      }

   }

   private static void d(Graphics var0) {
      var0.setColor(0, 0, 0);
      var0.fillRect(0, 0, 240, 300);
   }

   private int F() {
      return this.dR.nextInt();
   }

   private void z(int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         byte var3 = this.ci[this.fk][var2];
         if (this.cm[var3] && (this.cg[var3] == this.fl || this.bO) && (this.bu[this.cg[var3]] != 2 || !this.l(var3) || a((long)this.bT[var3][0] - this.eI) >> 16 < 6L && a((long)this.bT[var3][1] - this.eJ) >> 16 < 6L)) {
            this.m(var3);
         }
      }

      a var10000;
      byte var10001;
      if (this.ek == 0) {
         var10000 = this;
         var10001 = 5;
      } else if (this.ek == 1) {
         var10000 = this;
         var10001 = 2;
      } else {
         var10000 = this;
         var10001 = 1;
      }

      var10000.er = var10001;
      this.l();
   }

   private void a(int var1, int var2, Graphics var3) {
      int var4 = var1;

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         var3.drawRGB(this.gH, 0, 15, var2 + 15 * var5, 274, 15, 14, false);
      }

      for(var5 = 2; var4 != 0; --var5) {
         int var6 = var4 % 10;
         var3.drawRGB(this.gH, var6 * 15 * 14, 15, var2 + 15 * var5, 274, 15, 14, false);
         var4 /= 10;
      }

   }

   private void G() {
      this.D(10);
      this.fD = new short[240];
      this.fF = new byte[240];
      this.fC = new int[8];

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         for(int var2 = 0; var2 < 2; ++var2) {
            this.fC[2 * var1 + var2] = 10616832;
         }
      }

      for(var1 = 0; var1 < 240; var1 += 2) {
         this.fD[var1] = (short)(-(abs(this.F()) % 60));
         this.fF[var1] = (byte)abs(this.F() % 2);
      }

      this.fD[0] = 0;
      this.ec = true;
      this.fJ = false;
      this.fX = this.eC;
   }

   private void e(Graphics var1) {
      for(int var2 = 0; var2 < 240; var2 += 2) {
         Graphics var10000;
         int[] var10001;
         byte var10002;
         byte var10003;
         int var10004;
         short var10005;
         byte var10006;
         int var10007;
         label50: {
            if (this.fF[var2] == 1) {
               if (this.fD[var2] >= -3 && this.fD[var2] <= -1) {
                  var10000 = var1;
                  var10001 = this.fC;
                  var10002 = 0;
                  var10003 = 2;
                  var10004 = var2;
                  var10005 = 0;
                  var10006 = 2;
                  var10007 = 4 + this.fD[var2];
                  break label50;
               }

               if (this.fD[var2] >= 0 && this.fD[var2] <= this.fI - 1 - 4) {
                  var10000 = var1;
                  var10001 = this.fC;
                  var10002 = 0;
                  var10003 = 2;
                  var10004 = var2;
                  var10005 = this.fD[var2];
                  var10006 = 2;
                  var10007 = 4;
                  break label50;
               }

               if (this.fD[var2] < this.fI - 1 - 3 || this.fD[var2] >= this.fI) {
                  continue;
               }
            } else {
               if (this.fD[var2] >= -1 && this.fD[var2] <= -1) {
                  var10000 = var1;
                  var10001 = this.fC;
                  var10002 = 0;
                  var10003 = 2;
                  var10004 = var2;
                  var10005 = 0;
                  var10006 = 2;
                  var10007 = 2 + this.fD[var2];
                  break label50;
               }

               if (this.fD[var2] >= 0 && this.fD[var2] <= this.fI - 1 - 2) {
                  var10000 = var1;
                  var10001 = this.fC;
                  var10002 = 0;
                  var10003 = 2;
                  var10004 = var2;
                  var10005 = this.fD[var2];
                  var10006 = 2;
                  var10007 = 2;
                  break label50;
               }

               if (this.fD[var2] < this.fI - 1 - 1 || this.fD[var2] >= this.fI) {
                  continue;
               }
            }

            var10000 = var1;
            var10001 = this.fC;
            var10002 = 0;
            var10003 = 2;
            var10004 = var2;
            var10005 = this.fD[var2];
            var10006 = 2;
            var10007 = this.fI - this.fD[var2];
         }

         var10000.drawRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007, false);
      }

   }

   private void H() {
      if (!this.fJ) {
         boolean var2 = true;

         for(int var1 = 0; var1 < 240; var1 += 2) {
            if (this.fD[var1] >= 0 && this.fD[var1] < this.fI) {
               var2 = false;
            }

            short[] var10000;
            int var10001;
            short var10002;
            byte var10003;
            if (this.fF[var1] == 1) {
               var10000 = this.fD;
               var10001 = var1;
               var10002 = var10000[var1];
               var10003 = 4;
            } else {
               if (this.fF[var1] != 0) {
                  continue;
               }

               var10000 = this.fD;
               var10001 = var1;
               var10002 = var10000[var1];
               var10003 = 2;
            }

            var10000[var10001] = (short)(var10002 + var10003);
         }

         if (var2) {
            this.fJ = true;
         }

      }
   }

   private void I() {
      boolean var1 = true;
      if (abs(this.F()) % 3 != 0) {
         var1 = false;
      }

      for(int var2 = 16; var2 < 16 + this.eQ; ++var2) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (this.cl[var2]) {
            var10000 = this.cg;
            var10001 = var2;
            var10002 = this.fn;
         } else if (this.ca[var2] == -1) {
            if (!var1) {
               continue;
            }

            if (this.cg[var2] == this.fl) {
               var10000 = this.cg;
               var10001 = var2;
               var10002 = this.fm;
            } else {
               var10000 = this.cg;
               var10001 = var2;
               var10002 = this.fl;
            }
         } else if (this.ca[var2] == -2) {
            if (!var1) {
               continue;
            }

            var10000 = this.cg;
            var10001 = var2;
            var10002 = this.fm;
         } else {
            if (this.ca[var2] == 127 || !var1) {
               continue;
            }

            if (this.cg[var2] == this.fl) {
               this.cg[var2] = this.fm;
               var10000 = this.ch;
               var10001 = this.ca[var2];
               var10002 = 1;
            } else {
               this.cg[var2] = this.fl;
               var10000 = this.ch;
               var10001 = this.ca[var2];
               var10002 = 0;
            }
         }

         var10000[var10001] = var10002;
      }

   }

   private void J() {
      for(int var2 = 0; var2 <= 1; ++var2) {
         if (this.fE[var2] != null) {
            for(int var1 = 0; var1 < this.fE[var2].length; ++var1) {
               this.cX[this.fE[var2][var1]] = this.fG[var2][this.fH[var2][var1]];
               byte[] var10000;
               int var10001;
               byte var10002;
               if (this.fH[var2][var1] < this.ff) {
                  var10000 = this.fH[var2];
                  var10001 = var1;
                  var10002 = (byte)(var10000[var1] + 1);
               } else {
                  var10000 = this.fH[var2];
                  var10001 = var1;
                  var10002 = 0;
               }

               var10000[var10001] = var10002;
            }
         }
      }

   }

   private void K() {
      if (this.em > 4 || this.fg != 3) {
         boolean var1 = !this.fY[5];
         if (this.fL < 0) {
            this.fL = this.getGameAction(this.fL);
            if (this.fL == 0) {
               this.fL = 35;
            }
         }

         a var10000;
         if (this.hk) {
            label92: {
               byte var10001;
               if (this.fL == 1) {
                  var10000 = this;
                  var10001 = 50;
               } else if (this.fL == 6) {
                  var10000 = this;
                  var10001 = 56;
               } else if (this.fL == 2) {
                  var10000 = this;
                  var10001 = 52;
               } else if (this.fL == 5) {
                  var10000 = this;
                  var10001 = 54;
               } else {
                  if (this.fL != 8) {
                     break label92;
                  }

                  var10000 = this;
                  var10001 = 53;
               }

               var10000.fL = var10001;
            }
         }

         if (this.fg == 3 && this.fL >= 48 && this.fL <= 57) {
            if (this.fZ[this.fL - 48]) {
               this.fL = -10000;
               this.fK = -10000;
               return;
            }

            this.fY[this.fL - 48] = true;
         }

         this.fK = this.fL;
         if (this.fg == 3) {
            if (this.fY[4] || this.fY[6]) {
               this.eT = this.eW;
               this.eD = this.eC;
            }

            if (this.es && this.fK == 53) {
               this.fY[5] = false;
            }

            if (this.es || this.fY[5]) {
               this.fY[0] = false;
            }

            if (this.fY[5]) {
               if (this.eL <= 0) {
                  this.fY[5] = false;
               }

               boolean var2;
               if (this.F() % 2 == 0) {
                  var10000 = this;
                  var2 = true;
               } else {
                  var10000 = this;
                  var2 = false;
               }

               var10000.eu = var2;
               if (this.fK == 53 && var1) {
                  this.fT = this.eC;
                  return;
               }
            }
         } else {
            this.C(this.fL);
         }

      }
   }

   private void L() {
      this.I();
      a var10000;
      int var10001;
      if (this.fe != 3) {
         var10000 = this;
         var10001 = this.fe + 1;
      } else {
         var10000 = this;
         var10001 = 0;
      }

      var10000.fe = var10001;
      this.y(this.fe % 2);
      if (!this.ec) {
         byte var1;
         byte var10002;
         byte var10003;
         byte var10004;
         if (this.selectedMap < 7) {
            this.b(0, 10, 12, -100, 0);
            this.b(1, 13, 15, -100, 0);
            var10000 = this;
            var1 = 0;
            var10002 = 28;
            var10003 = 29;
            var10004 = 1;
         } else {
            this.b(0, 10, 12, -100, 0);
            this.b(1, 13, 15, -100, 0);
            this.b(0, 28, 29, 1, 31);
            var10000 = this;
            var1 = 0;
            var10002 = 37;
            var10003 = 38;
            var10004 = 32;
         }

         var10000.b(var1, var10002, var10003, var10004, 100);
      }

   }

   public final void keyPressed(int var1) {
      this.fK = var1;
   }

   public final void keyReleased(int var1) {
      int var2;
      if (this.fg == 3) {
         var2 = var1;
         this.fM = var1;
         if (var1 < 0) {
            var2 = this.getGameAction(var1);
         }

         label64: {
            byte var10000;
            if (var2 == 1) {
               var10000 = 50;
            } else if (var2 == 6) {
               var10000 = 56;
            } else if (var2 == 2) {
               var10000 = 52;
            } else if (var2 == 5) {
               var10000 = 54;
            } else {
               if (var2 != 8) {
                  break label64;
               }

               var10000 = 53;
            }

            var2 = var10000;
         }

         if (var2 == 50) {
            this.gd = this.cn;
            this.ge = this.cp;
            this.gf = true;
            this.ga = 1;
            this.gb = 0;
            this.gc = 0;
         } else if (var2 == 56) {
            this.gd = this.co;
            this.ge = this.cq;
            this.gf = true;
            this.ga = 1;
            this.gb = 0;
            this.gc = 0;
         } else if (var2 == 49) {
            this.gd = this.cn;
            this.ge = this.cp;
            this.gf = true;
            this.ga = 1;
            this.gb = 90;
            this.gc = 0;
         } else if (var2 == 51) {
            this.gd = this.cn;
            this.ge = this.cp;
            this.gf = true;
            this.ga = 1;
            this.gb = -90;
            this.gc = 0;
         } else if (var2 == 53) {
            this.fT = this.eC;
         } else {
            this.gf = false;
         }

         if (var2 >= 48 && var2 <= 57) {
            this.fZ[var2 - 48] = true;
            this.fY[var2 - 48] = false;
         }
      }

      if (!this.N()) {
         this.fK = -10000;
      } else {
         for(var2 = 0; var2 < 9; ++var2) {
            if (this.fY[var2]) {
               this.fK = var2 + 48;
            }
         }

      }
   }

   private void M() {
      for(int var1 = 0; var1 < 9; ++var1) {
         this.fY[var1] = false;
      }

      this.fK = -10000;
      this.eq = -10000;
   }

   private boolean N() {
      if (this.fg == 3) {
         return this.fY[0] || this.fY[1] || this.fY[2] || this.fY[3] || this.fY[4] || this.fY[5] || this.fY[6] || this.fY[7] || this.fY[8] || this.fY[9];
      } else {
         return false;
      }
   }

   private void O() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.fZ[var1] = false;
      }

   }

   private void P() {
      this.U();
      if (this.eC - this.eH > 3000L) {
         this.gF = false;
      }

      if (!this.gF) {
         int var1;
         if ((var1 = this.gu) < this.r.length) {
            if (this.gs != var1) {
               this.fz[0] = (long)this.r[var1] * 75000L >> 1;
               this.fz[1] = (long)this.r[var1 + 1] * 75000L >> 1;
               this.eR = this.r[var1 + 2];
               this.gt = 0;
            }

            int var2;
            int var3 = (var2 = var1 >> 2) != 0 && var2 != 2 ? 1 : 0;
            if ((this.fz[var3] > (long)this.r[var1 + 3] * 75000L >> 1 || var2 == 3) && (this.fz[var3] < (long)this.r[var1 + 3] * 75000L >> 1 || var2 != 3)) {
               this.gt = 0;
               this.gu += 4;
               if (this.gu >= this.r.length) {
                  this.gB = false;
                  if (this.hA == 0) {
                     this.hA = 1;
                     this.hx[0] = 0;
                     this.hy[0] = 69;
                     this.hz[0] = 220;
                     this.ac();
                  }

                  this.letterImages = (int[][])null;
                  this.b(false);
                  this.go = 1;
                  if (this.selectedMap == 0) {
                     this.selectedMap = 1;
                  }

                  this.gp = 8;
                  this.gz = true;
                  this.gA = false;
                  this.fg = 2;
                  this.gm = 1;
               } else {
                  this.eH = this.eC;
                  this.gF = true;
               }
            } else {
               a var10000;
               long var10001;
               long var10002;
               byte var10003;
               if (var2 == 1) {
                  var10000 = this;
                  var10001 = this.cn;
                  var10002 = this.cp;
                  var10003 = -90;
               } else {
                  if (var2 == 3) {
                     var10000 = this;
                     var10001 = this.co;
                     var10002 = this.cq;
                  } else {
                     var10000 = this;
                     var10001 = this.cn;
                     var10002 = this.cp;
                  }

                  var10003 = 0;
               }

               var10000.a(var10001, var10002, var10003);
               this.gs = var1;
               ++this.gt;
            }
         }
      }
   }

   private void initLettersAndGameLogo() {
      Image fontImage = this.readImage("/f" + this.dataExt);
      this.gameLogoW = fontImage.getWidth();
      this.gameLogoH = fontImage.getHeight() - 112;
      this.gameLogoImage = new int[this.gameLogoW * this.gameLogoH];
      fontImage.getRGB(this.gameLogoImage, 0, this.gameLogoW, 0, 112, this.gameLogoW, this.gameLogoH);
      this.letterImages = new int[70][240];
      int var3 = 0;

      for(int var1 = 0; var1 < 7; ++var1) {
         for(int var2 = 0; var2 < 10; ++var2) {
            fontImage.getRGB(this.letterImages[var3], 0, 15, var2 * 15, var1 * 16, 15, 16);
            ++var3;
         }
      }

   }

   private void a(i var1) {
      Vector var2;
      int var3 = (var2 = GlomoReg.i.a()).size();
      this.gU = new String[var3 + 1];

      String var4;
      for(int var5 = 0; var5 < var3; ++var5) {
         var4 = ((GlomoReg.c)var2.elementAt(var5)).a().toLowerCase();
         this.gU[var5] = new String(" " + var4);
      }

      var4 = "назад";
      this.gU[var3] = new String(" " + var4);
      this.gW = this.a(this.gU);
      this.ha = var3;
      this.hi = 0;
      this.hl = var3 > 6;
      this.hj = (byte)(this.hl ? 6 : var3);
      this.hf = (byte)(this.hl ? 8 : this.he + var3);
   }

   private void R() {
      a var10000;
      byte var10001;
      if (this.gT.length() > 14) {
         this.gY = new byte[2][];
         int var1 = this.gT.indexOf(" ", 7);
         String[] var2 = new String[]{this.gT.substring(0, var1), this.gT.substring(var1 + 1)};
         this.gY = this.a(var2);
         var10000 = this;
         var10001 = 1;
      } else {
         this.gY = new byte[1][];
         this.gY[0] = this.b(this.gT);
         var10000 = this;
         var10001 = 0;
      }

      var10000.hb = var10001;
   }

   private void S() {
      try {
         String var3 = GlomoReg.i.f();
         System.out.println("Opening link: " + var3);
         if (Bunker3D.b().platformRequest(var3)) {
            Bunker3D.b().destroyApp(true);
         }

      } catch (IOException var9) {
         var9.printStackTrace();
      } finally {
         ;
      }
   }

   private void a(byte[][] var1, int var2, int var3, int var4, int var5, int var6, Graphics var7) {
      for(int var9 = var2; var9 <= var3; ++var9) {
         if (var1[var9] != null) {
            int var8 = var1[var9].length;

            for(int var10 = 0; var10 < var8; ++var10) {
               Graphics var10000;
               int[][] var10001;
               byte var10002;
               if (var9 + var4 == this.go && var10 == 0) {
                  var10000 = var7;
                  var10001 = this.letterImages;
                  var10002 = 66;
               } else {
                  var10000 = var7;
                  var10001 = this.letterImages;
                  var10002 = var1[var9][var10];
               }

               var10000.drawRGB(var10001[var10002], 0, 15, var5 + 15 * var10, 22 * (var9 - var2 + var6) + this.gj - 5, 15, 16, false);
            }
         }
      }

   }

   private static byte a(char var0) {
      boolean var1 = false;
      short var2 = 0;
      boolean var4 = false;
      short var3 = (short)var0;
      byte var5;
      if (var0 >= '0' && var0 <= '9') {
         var2 = 48;
         var5 = 0;
         var4 = true;
      } else if (var0 >= 1072 && var0 <= 1103 && var0 != 1095 && var0 != 1101) {
         var2 = 1072;
         var5 = 10;
         var4 = true;
      } else if (var0 >= 1040 && var0 <= 1071 && var0 != 1063 && var0 != 1069) {
         var2 = 1040;
         var5 = 10;
         var4 = true;
      } else {
         var4 = false;
         byte var10000;
         switch(var0) {
         case '!':
            var10000 = 52;
            break;
         case '#':
            var10000 = 49;
            break;
         case '(':
            var10000 = 44;
            break;
         case ')':
            var10000 = 45;
            break;
         case '*':
            var10000 = 55;
            break;
         case ',':
            var10000 = 46;
            break;
         case '-':
            var10000 = 42;
            break;
         case '.':
            var10000 = 43;
            break;
         case ':':
            var10000 = 50;
            break;
         case '?':
            var10000 = 51;
            break;
         case 'a':
            var10000 = 10;
            break;
         case 'b':
            var10000 = 12;
            break;
         case 'c':
            var10000 = 27;
            break;
         case 'd':
            var10000 = 57;
            break;
         case 'e':
            var10000 = 15;
            break;
         case 'f':
            var10000 = 59;
            break;
         case 'g':
            var10000 = 65;
            break;
         case 'h':
            var10000 = 23;
            break;
         case 'i':
            var10000 = 60;
            break;
         case 'k':
            var10000 = 20;
            break;
         case 'l':
            var10000 = 61;
            break;
         case 'm':
            var10000 = 22;
            break;
         case 'n':
            var10000 = 25;
            break;
         case 'o':
            var10000 = 24;
            break;
         case 'p':
            var10000 = 26;
            break;
         case 'r':
            var10000 = 56;
            break;
         case 's':
            var10000 = 58;
            break;
         case 't':
            var10000 = 28;
            break;
         case 'u':
            var10000 = 54;
            break;
         case 'v':
            var10000 = 62;
            break;
         case 'w':
            var10000 = 34;
            break;
         case 'x':
            var10000 = 31;
            break;
         case 'y':
            var10000 = 29;
            break;
         case 'z':
            var10000 = 69;
            break;
         case 'Ё':
            var10000 = 53;
            break;
         case 'Ч':
            var10000 = 4;
            break;
         case 'Э':
            var10000 = 3;
            break;
         case 'ч':
            var10000 = 4;
            break;
         case 'э':
            var10000 = 3;
            break;
         case 'ё':
            var10000 = 53;
            break;
         default:
            var10000 = 47;
         }

         var5 = var10000;
      }

      if (var4) {
         var5 += (byte)(var3 - var2);
      }

      return var5;
   }

   private byte[] b(String var1) {
      int var2;
      byte[] var3 = new byte[var2 = var1.length()];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = a(var1.charAt(var4));
      }

      return var3;
   }

   private byte[][] a(String[] var1) {
      int var2;
      byte[][] var3 = new byte[var2 = var1.length][];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = this.b(var1[var4]);
      }

      return var3;
   }

   private void a(String[][] var1) {
      int var2 = var1.length;
      this.hm = new byte[var2][][];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.hm[var3] = this.a(var1[var3]);
      }

   }

   private void A(int var1) {
      this.hg = (byte)var1;
      this.he = this.hd[var1][0];
      this.hf = this.hd[var1][1];
      this.go = this.he;
      this.hh = (byte)this.hm[this.hg].length;
   }

   private void a(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      int var9 = var1;

      for(int var7 = var2; var7 <= var3; ++var7) {
         int var8;
         for(var8 = 0; var8 < this.t[var7]; ++var8) {
            var6.drawRGB(this.letterImages[this.u[var9]], 0, 15, var4 + 15 * var8, 22 * (var7 - var2 + var5) + this.gj - 5, 15, 16, false);
            ++var9;
         }

         if (this.fw) {
            var6.drawRGB(this.letterImages[48], 0, 15, var4 + 15 * var8, 22 * (var7 - var2 + var5) + this.gj - 5, 15, 16, false);
         }
      }

   }

   private void b(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      int var10 = this.gL[22];

      int var7;
      for(var7 = 1; var7 <= this.hn; ++var7) {
         var10 += this.t[this.gK[22] + var7 - 1];
      }

      int var11 = var5;
      int var10000;
      int var10001;
      if (this.hA > 7 && this.hn < this.hA - 7) {
         var10000 = this.gK[22] + 8;
         var10001 = this.hn;
      } else if (this.hA > 8 && this.hn == this.hA - 7) {
         var10000 = this.gK[22] + 7;
         var10001 = this.hn;
      } else {
         var10000 = this.gK[22];
         var10001 = this.hA;
      }

      int var12 = var10000 + var10001;

      int var8;
      for(var7 = this.gK[22] + this.hn; var7 <= var12; ++var7) {
         for(var8 = 0; var8 < this.t[var7]; ++var8) {
            var6.drawRGB(this.letterImages[this.u[var10]], 0, 15, var4 + 15 * var8, 22 * var11 + this.gj - 5, 15, 16, false);
            ++var10;
         }

         ++var11;
      }

      int var9 = var1;

      for(var7 = var2; var7 < var3; ++var7) {
         var9 += this.t[var7];
      }

      if (this.hn == this.hA - 7 || this.hA < 8) {
         for(var8 = 0; var8 < this.t[var7]; ++var8) {
            var6.drawRGB(this.letterImages[this.u[var9]], 0, 15, var4 + 15 * var8, 22 * var11 + this.gj - 5, 15, 16, false);
            ++var9;
         }
      }

   }

   private void T() {
      int var3 = 0;
      this.gK = new int[this.s.length];
      this.gL = new int[this.s.length];

      for(int var1 = 1; var1 < this.gK.length; ++var1) {
         this.gK[var1] = this.gK[var1 - 1] + this.s[var1 - 1];
         this.gL[var1] = this.gL[var1 - 1];

         for(int var2 = 1; var2 <= this.s[var1 - 1]; ++var2) {
            int[] var10000 = this.gL;
            var10000[var1] += this.t[var3];
            ++var3;
         }
      }

   }

   private void f(Graphics var1) {
      byte var3;
      byte var4;
      label121: {
         var3 = 15;
         var4 = 4;
         byte var10000;
         if (this.gm <= 5) {
            var10000 = 21;
         } else if (this.gm == 12) {
            var10000 = 30;
         } else if (this.gm == 14) {
            var10000 = 15;
         } else if (this.gm == 15) {
            var10000 = 30;
         } else if (this.gm == 16) {
            var10000 = 30;
         } else {
            if (this.gm == 21) {
               var3 = 40;
               var4 = 6;
               break label121;
            }

            if (this.gm != 23) {
               break label121;
            }

            var10000 = 2;
         }

         var3 = var10000;
      }

      byte var10001;
      int var6;
      if (this.gm != 1 && this.gm < 30) {
         int var8;
         if (this.gm == 0 && !this.gA) {
            var8 = this.gK[this.gm] + this.s[this.gm];
            var10001 = 2;
         } else {
            var8 = this.gK[this.gm] + this.s[this.gm];
            var10001 = 1;
         }

         int var5 = var8 - var10001;
         if (this.gm == 0 && this.c == 0) {
            var6 = this.gK[this.gm] + 1;
            var8 = this.gL[this.gm] + 9;
         } else {
            var6 = this.gK[this.gm];
            var8 = this.gL[this.gm];
         }

         int var7 = var8;
         this.a(var7, var6, var5, var3, var4, var1);
      } else if (this.gm >= 30) {
         this.a(this.hm[this.hg], 0, this.hh - 1, 0, var3, var4, var1);
         if (this.hg == 8) {
            this.a(this.gW, this.hi, this.hj, 2 - this.hi, var3, var4 + 2, var1);
         }

         if (this.hg == 5) {
            this.a(this.gV, 0, 0, 0, var3 + 15, var4 + 2, var1);
         } else if (this.hg == 2) {
            this.a(this.gX, 0, 0, 0, var3 + 135, var4, var1);
            this.a(this.gY, 0, this.hb, 0, var3, var4 + 2, var1);
         } else if (this.hg == 10) {
            this.a(this.gZ, 0, 0, 0, var3 + 15, var4 + 3, var1);
         }
      } else {
         this.b(this.gL[this.gm], this.gK[this.gm], this.gK[this.gm] + this.s[this.gm] - 1, var3, var4, var1);
      }

      if (this.gm == 3) {
         int var2;
         for(var2 = this.ht != 0 ? 1 : 0; var2 < this.gO.length; ++var2) {
            this.a(this.gO[var2], this.gP[var2], this.gP[var2], 185, 4 + var2 + 0, var1);
         }

         if (this.ht != 0) {
            a var9;
            if (this.ht == 100) {
               this.hs[0] = 1;
               this.hs[1] = 0;
               this.hs[2] = 0;
               var9 = this;
               var10001 = 3;
            } else {
               this.hs[0] = this.ht / 10;
               this.hs[1] = 0;
               var9 = this;
               var10001 = 2;
            }

            var9.hu = var10001;

            for(var2 = this.gP[0]; var2 <= this.gP[0]; ++var2) {
               for(var6 = 0; var6 < this.hu; ++var6) {
                  var1.drawRGB(this.letterImages[this.hs[var6]], 0, 15, 185 + 15 * var6, 22 * (var2 - this.gP[0] + 4 + 0) + this.gj - 5, 15, 16, false);
               }
            }
         }
      }

      if (this.gm <= 5) {
         this.g(var1);
      }

      if (!this.fx) {
         var1.drawRGB(this.gameLogoImage, 0, this.gameLogoW, 240 - this.gameLogoW >> 1, 4 + this.gj, this.gameLogoW, this.gameLogoH, false);
      }

   }

   private void g(Graphics var1) {
      var1.drawRGB(this.letterImages[66], 0, 15, 4, 22 * (this.go + 4 + 0) + this.gj - 5, 15, 16, false);
   }

   private void U() {
      this.gk = 192 + this.F() % 16;
      this.gl = 208 + this.F() % 4;
      if (this.eC - this.gh > 1000L) {
         this.gj = abs(this.F() % 3);
         this.gh = this.eC;
      } else {
         this.gj = 0;
      }
   }

   private void V() {
      long var1;
      label43: {
         var1 = this.eC - this.gi;
         a var10000;
         if (this.fg == 1) {
            this.gE = true;
            if (var1 <= 2000L) {
               break label43;
            }

            if (var1 > 4000L) {
               this.fg = 4;
               this.gi = this.eC;
               break label43;
            }

            var10000 = this;
         } else {
            if (this.fg != 4) {
               break label43;
            }

            this.gE = true;
            if (var1 <= 2000L) {
               break label43;
            }

            if (var1 > 4000L) {
               this.fg = 2;
               break label43;
            }

            var10000 = this;
         }

         var10000.gE = false;
      }

      if (this.fg == 2 && this.fx && var1 > 4000L) {
         if (this.gm == 21) {
            this.gm = 14;
         } else {
            ++this.gm;
            if (this.gm == 17) {
               this.gm = 0;
               this.go = 0;
               this.fx = false;
               this.gA = false;
            }
         }

         this.gi = this.eC;
      }

      this.U();
   }

   private void B(int var1) {
      if (!this.hk) {
         if (this.hg == 5 && this.go == 2) {
            if (var1 >= 48 && var1 <= 57) {
               this.gQ = this.gQ + (char)(var1 - 48 + 48);
               this.gV[0] = this.b(this.gQ);
               return;
            }

            this.hk = true;
            this.go = 3;
            this.he = 3;
         }

         if (this.hg == 10 && this.go == 3) {
            if (var1 >= 48 && var1 <= 57) {
               this.gR = this.gR + (char)(var1 - 48 + 48);
               this.gZ[0] = this.b(this.gR);
               return;
            }

            this.hk = true;
            this.go = 4;
            this.he = 4;
            return;
         }
      } else if (var1 != 50 && this.fL != 1) {
         if (var1 != 56 && this.fL != 6) {
            if (var1 == 53 || this.fL == 8) {
               a var10000;
               byte var10001;
               label197:
               switch(this.hg) {
               case 0:
                  switch(this.go) {
                  case 0:
                     this.A(1);
                     return;
                  case 1:
                     this.A(5);
                     return;
                  case 2:
                     this.A(8);
                     this.a(this.d);
                     return;
                  case 3:
                     this.gm = 0;
                     this.go = 0;
                     this.gp = 1;
                  default:
                     return;
                  }
               case 1:
                  switch(this.go) {
                  case 8:
                     this.A(2);
                  default:
                     return;
                  }
               case 2:
                  switch(this.go) {
                  case 4:
                     if (this.d.d()) {
                        this.A(3);
                     } else {
                        this.A(2);
                     }

                     return;
                  case 5:
                     Alert var3;
                     (var3 = new Alert("Код активации")).setString(GlomoReg.i.c());
                     var3.setType(AlertType.INFO);
                     var3.setTimeout(-2);
                     this.b.setCurrent(var3, this);
                     return;
                  case 6:
                     this.A(5);
                     return;
                  case 7:
                     this.A(8);
                     this.a(this.d);
                     return;
                  case 8:
                     this.gm = 0;
                     this.go = 0;
                     this.gp = 1;
                  default:
                     return;
                  }
               case 3:
                  switch(this.go) {
                  case 8:
                     this.A(4);
                  default:
                     return;
                  }
               case 4:
                  switch(this.go) {
                  case 8:
                     this.A(2);
                  default:
                     return;
                  }
               case 5:
                  switch(this.go) {
                  case 2:
                     this.hk = false;
                     this.gQ = "";
                     this.gV[0] = null;
                     System.gc();
                     return;
                  case 3:
                     if (this.d.a(this.gQ)) {
                        this.c = 0;
                        var10000 = this;
                        var10001 = 6;
                     } else {
                        var10000 = this;
                        var10001 = 7;
                     }

                     var10000.A(var10001);
                     this.gQ = "ввести номер";
                     this.gV[0] = this.b(this.gQ);
                     System.gc();
                     return;
                  case 4:
                     this.A(2);
                     this.gQ = "ввести номер";
                     this.gV[0] = this.b(this.gQ);
                     System.gc();
                     return;
                  case 5:
                     this.go = 2;
                     this.he = 2;
                     this.gQ = "";
                     this.gV[0] = null;
                     System.gc();
                     this.hk = false;
                  default:
                     return;
                  }
               case 6:
                  switch(this.go) {
                  case 4:
                     this.gm = 0;
                     this.go = 0;
                     this.gp = 1;
                  default:
                     return;
                  }
               case 7:
                  switch(this.go) {
                  case 6:
                     var10000 = this;
                     var10001 = 5;
                     break;
                  case 7:
                     var10000 = this;
                     var10001 = 2;
                     break;
                  default:
                     return;
                  }

                  var10000.A(var10001);
                  return;
               case 8:
                  if (this.hi + this.go - 2 < this.ha) {
                     int var2 = GlomoReg.i.b().a() != "-1" ? 2 : 1;
                     if (this.d.a(this.hi + this.go - 2)) {
                        this.gS = GlomoReg.i.b().d().toLowerCase();
                        this.gT = GlomoReg.i.b().e().toLowerCase();
                        this.R();
                        this.gX[0] = this.b(this.gS);
                        this.A(var2);
                     }

                     return;
                  }

                  if (GlomoReg.i.b().a() != "-1") {
                     this.A(2);
                     return;
                  }

                  var10000 = this;
                  break;
               case 9:
                  switch(this.go) {
                  case 7:
                     if (GlomoReg.i.b().a() != "-1") {
                        this.A(1);
                     } else {
                        this.A(8);
                        this.a(this.d);
                     }

                     return;
                  case 8:
                     this.gm = 0;
                     this.go = 0;
                     this.gp = 1;
                  default:
                     return;
                  }
               case 10:
                  byte[] var10002;
                  byte[][] var4;
                  label193: {
                     switch(this.go) {
                     case 3:
                        this.hk = false;
                        this.gR = "";
                        var4 = this.gZ;
                        var10001 = 0;
                        var10002 = null;
                        break label193;
                     case 4:
                        if (this.d.b(this.gR)) {
                           this.A(11);
                        } else {
                           this.gm = 0;
                           this.go = 0;
                           this.gp = 1;
                        }

                        var10000 = this;
                        break;
                     case 5:
                        this.go = 3;
                        this.gR = "";
                        this.gZ[0] = null;
                        System.gc();
                        this.hk = false;
                        return;
                     case 6:
                        this.gm = 0;
                        this.go = 0;
                        this.gp = 1;
                        var10000 = this;
                        break;
                     default:
                        return;
                     }

                     var10000.gR = "ввести номер";
                     var4 = this.gZ;
                     var10001 = 0;
                     var10002 = this.b(this.gR);
                  }

                  var4[var10001] = var10002;
                  System.gc();
                  return;
               case 11:
                  switch(this.go) {
                  case 3:
                     this.gm = 0;
                     this.go = 0;
                     this.gp = 1;
                  default:
                     return;
                  }
               case 12:
                  switch(this.go) {
                  case 4:
                     this.S();
                     return;
                  case 5:
                     var10000 = this;
                     break label197;
                  }
               default:
                  return;
               }

               var10000.gm = 0;
               this.go = 0;
               this.gp = 1;
            }
         } else {
            if (this.go != this.hf) {
               ++this.go;
               return;
            }

            if (this.hg == 8 && this.hj < this.ha && this.hl) {
               ++this.hi;
               ++this.hj;
               return;
            }

            this.go = this.he;
            if (this.hg == 8 && this.hl) {
               this.hi = 0;
               this.hj = 6;
               return;
            }
         }
      } else {
         if (this.go != this.he) {
            --this.go;
            return;
         }

         if (this.hg == 8 && this.hi > 0 && this.hl) {
            --this.hi;
            --this.hj;
            return;
         }

         this.go = this.hf;
         if (this.hg == 8 && this.hl) {
            this.hi = (byte)(this.ha - 6);
            this.hj = (byte)this.ha;
            return;
         }
      }

   }

   private void C(int var1) {
      if (!this.fx) {
         if (this.gm >= 30) {
            this.B(var1);
         } else {
            if (this.fg == 2) {
               this.gn = this.gm;
               int var2 = this.gm != 4 ? 0 : 1;
               if (this.gm >= 6) {
                  if (this.X()) {
                     this.W();
                     return;
                  }
               } else if (this.fL == 50) {
                  if (this.gm == 1) {
                     this.gp = this.go;
                     if (this.go != var2) {
                        --this.go;
                        return;
                     }

                     if (this.hn > 0) {
                        --this.hn;
                        return;
                     }

                     if (this.hA > 7) {
                        this.go = 8;
                        this.hn = this.hA - 7;
                        return;
                     }

                     this.go = this.hA + 1;
                     return;
                  }

                  if (this.gm <= 5) {
                     this.gp = this.go;
                     if (this.go != var2) {
                        --this.go;
                        return;
                     }

                     if (this.gm == 0 && !this.gA) {
                        this.go = this.s[this.gm] - 2 - (1 - this.c);
                        return;
                     }

                     if (this.gm != 0) {
                        this.go = this.s[this.gm] - 1;
                        return;
                     }

                     this.go = this.s[this.gm] - 1 - (1 - this.c);
                     return;
                  }
               } else if (this.fL == 56) {
                  if (this.gm != 1) {
                     if (this.gm <= 5) {
                        this.gp = this.go;
                        if (this.gm == 0 && !this.gA) {
                           if (this.go != this.s[this.gm] - 2 - (1 - this.c)) {
                              ++this.go;
                              return;
                           }

                           this.go = var2;
                           return;
                        }

                        if (this.gm != 0) {
                           if (this.go != this.s[this.gm] - 1) {
                              ++this.go;
                              return;
                           }

                           this.go = var2;
                           return;
                        }

                        if (this.go != this.s[this.gm] - 1 - (1 - this.c)) {
                           ++this.go;
                           return;
                        }

                        this.go = var2;
                        return;
                     }
                  } else {
                     this.gp = this.go;
                     if ((this.go == 8 || this.hA <= 7) && (this.go >= this.hA + 1 || this.hA > 7) && (this.go != 0 || this.hA != 0)) {
                        if (this.hn != this.hA - 7 && this.hA > 7) {
                           ++this.hn;
                           return;
                        }

                        if (this.go != 8 && this.go != this.hA + 1) {
                           return;
                        }

                        this.go = var2;
                        this.hn = 0;
                        return;
                     }

                     ++this.go;
                     return;
                  }
               } else {
                  int var10001;
                  a var8;
                  if (this.fL != 52 && this.fL != 54) {
                     if (this.gm == 0) {
                        if (this.go == 0 && this.c == 1) {
                           this.gm = 30;
                           if (GlomoReg.i.b().a() != "-1") {
                              this.A(1);
                              return;
                           }

                           this.A(8);
                           this.a(this.d);
                           return;
                        }

                        if (this.go == 3 + this.c) {
                           this.gm = 30;
                           this.A(10);
                           return;
                        }

                        if (this.go == 4 + this.c) {
                           this.gm = 30;
                           this.A(12);
                           return;
                        }

                        if (this.go == 5 + this.c) {
                           this.gq = this.go;
                           this.gr = this.gp;
                           this.gm = 4;
                        }

                        if (this.go == 6 + this.c) {
                           if (!this.gA) {
                              return;
                           }

                           this.letterImages = (int[][])null;
                           this.gameLogoImage = null;
                           this.c(false);
                           System.gc();
                           this.fh = -1;
                           this.fi = -1;
                           this.fg = 3;
                           this.Y();
                        }

                        if (this.gm != 4) {
                           this.gq = this.go;
                           this.gr = this.gp;
                           this.gm = this.go - this.c + 1;
                        }
                     } else if (this.gm == 1) {
                        if (this.go == 1 + this.hA && this.hA < 8 || this.go == 8 && this.hA >= 8 && this.hn == this.hA - 7) {
                           this.gm = 0;
                           this.go = 0 + this.c;
                           return;
                        }

                        if (this.go == 0 && this.hn == 0 && !this.fs) {
                           this.gD = true;
                           this.gB = true;
                           this.gs = -1;
                           this.gt = 0;
                           this.gu = 0;
                        } else {
                           this.gB = false;
                           if (this.go == 0 && this.hn == 0) {
                              return;
                           }
                        }

                        try {
                           if (this.hp != null) {
                              this.hp.stop();
                           }
                        } catch (Exception var7) {
                        }

                        this.gameLogoImage = null;
                        System.gc();
                        this.fr = true;
                        this.fw = true;
                        this.fg = 3;
                        if (this.go != 0) {
                           this.ek = this.hx[this.go - 1];
                           this.eK = this.hy[this.go - 1];
                           this.eL = this.hz[this.go - 1];
                           this.eM = this.eK;
                           this.eN = this.eL;
                           var8 = this;
                           var10001 = this.go + this.hn;
                        } else {
                           var8 = this;
                           var10001 = 0;
                        }

                        var8.fj = var10001;
                        this.Y();
                     } else {
                        if (this.gm == 2) {
                           byte var9;
                           if (this.go == 6) {
                              this.go = this.gm - 1 + this.c;
                              var8 = this;
                              var9 = 0;
                           } else if (this.go == 0) {
                              var8 = this;
                              var9 = 6;
                           } else if (this.go == 1) {
                              var8 = this;
                              var9 = 9;
                           } else if (this.go == 2) {
                              var8 = this;
                              var9 = 11;
                           } else if (this.go == 3) {
                              var8 = this;
                              var9 = 12;
                           } else if (this.go == 4) {
                              var8 = this;
                              var9 = 14;
                           } else {
                              if (this.go != 5) {
                                 return;
                              }

                              var8 = this;
                              var9 = 23;
                           }

                           var8.gm = var9;
                           return;
                        }

                        if (this.gm == 3) {
                           if (this.go == 3) {
                              this.go = this.gm - 1 + this.c;
                              this.gm = 0;
                           }

                           return;
                        }

                        if (this.gm == 4) {
                           if (this.go == 1) {
                              try {
                                 if (this.hp != null) {
                                    this.hp.stop();
                                    this.hp.close();
                                 }
                              } catch (Exception var6) {
                              }

                              this.ac();

                              try {
                                 this.hw.closeRecordStore();
                              } catch (Exception var5) {
                              }

                              Bunker3D.b().destroyApp(false);
                           } else {
                              this.gm = 0;
                           }
                        }
                     }

                     if (this.gm == 4 && this.go == 1) {
                        return;
                     }

                     this.W();
                  } else if (this.gm == 3) {
                     if (this.go == 3) {
                        return;
                     }

                     if (this.go != 0) {
                        byte[] var10000;
                        byte var10002;
                        if (this.gO[this.go] == 222) {
                           this.gO[this.go] = 220;
                           var10000 = this.gP;
                           var10001 = this.go;
                           var10002 = 25;
                        } else {
                           this.gO[this.go] = 222;
                           var10000 = this.gP;
                           var10001 = this.go;
                           var10002 = 26;
                        }

                        var10000[var10001] = var10002;
                     }

                     if (this.go == 0 && this.hv) {
                        label275: {
                           if (this.fL == 52) {
                              if (this.ht == 0) {
                                 break label275;
                              }

                              var8 = this;
                              var10001 = this.ht - 10;
                           } else {
                              if (this.ht == 100) {
                                 break label275;
                              }

                              if (this.ht == 0) {
                                 this.ht += 10;
                                 if (this.selectedMap != -1) {
                                    var8 = this;
                                    var10001 = this.selectedMap;
                                 } else {
                                    var8 = this;
                                    var10001 = 9;
                                 }

                                 var8.D(var10001);
                                 if (this.hv) {
                                    break label275;
                                 }

                                 var8 = this;
                                 var10001 = 0;
                              } else {
                                 var8 = this;
                                 var10001 = this.ht + 10;
                              }
                           }

                           var8.ht = var10001;
                        }

                        if (this.hp != null) {
                           this.hq.setLevel(this.ht);
                           if (this.ht == 0) {
                              try {
                                 this.hp.stop();
                              } catch (Exception var4) {
                              }
                           }
                        }
                     }

                     this.gz = true;
                     return;
                  }
               }
            }

         }
      }
   }

   private void W() {
      label14: {
         a var10000;
         int var10001;
         if (this.gn != 0) {
            this.go = this.gq;
            var10000 = this;
            var10001 = this.gr;
         } else {
            this.go = 0;
            this.gp = 1;
            if (this.gm != 4) {
               break label14;
            }

            this.go = 1;
            var10000 = this;
            var10001 = 2;
         }

         var10000.gp = var10001;
      }

      this.gz = true;
   }

   private boolean X() {
      if (this.gm >= 6 && this.gm != 8 && this.gm != 10 && this.gm != 11 && this.gm != 12 && this.gm != 13 && this.gm != 16 && this.gm != 23) {
         ++this.gm;
         return true;
      } else {
         label70: {
            a var10000;
            byte var10001;
            if (this.gm >= 6 && this.gm <= 8) {
               this.go = 0;
               var10000 = this;
               var10001 = 1;
            } else if (this.gm >= 9 && this.gm <= 10) {
               this.go = 1;
               var10000 = this;
               var10001 = 2;
            } else if (this.gm == 11) {
               this.go = 2;
               var10000 = this;
               var10001 = 3;
            } else {
               label71: {
                  if (this.gm >= 12 && this.gm <= 13) {
                     var10000 = this;
                     var10001 = 3;
                  } else {
                     if (this.gm >= 14 && this.gm <= 18) {
                        this.go = 4;
                        var10000 = this;
                        var10001 = 3;
                        break label71;
                     }

                     if (this.gm != 23) {
                        break label70;
                     }

                     var10000 = this;
                     var10001 = 5;
                  }

                  var10000.go = var10001;
                  var10000 = this;
                  var10001 = 4;
               }
            }

            var10000.gp = var10001;
         }

         this.gm = 2;
         return false;
      }
   }

   private void Y() {
      a var10000;
      byte var10001;
      if (this.gP[1] == 25) {
         var10000 = this;
         var10001 = 2;
      } else {
         var10000 = this;
         var10001 = 1;
      }

      var10000.fq = var10001;
      boolean var1;
      if (this.gP[2] == 25) {
         var10000 = this;
         var1 = true;
      } else {
         var10000 = this;
         var1 = false;
      }

      var10000.fv = var1;
   }

   private void h(Graphics var1) {
      if (this.fg != 3) {
         d(var1);
         if (this.fg == 1) {
            if (this.letterImages == null) {
               this.initLettersAndGameLogo();
               Image companyLogo = this.readImage("/n" + this.dataExt);
               this.companyLogoW = companyLogo.getWidth();
               this.companyLogoH = companyLogo.getHeight();
               this.gJ = new int[this.companyLogoW * this.companyLogoH];
               companyLogo.getRGB(this.gJ, 0, this.companyLogoW, 0, 0, this.companyLogoW, this.companyLogoH);
               this.go = 0;
               this.gp = 7;
               this.E();
               this.gm = 0;
               this.gO = new short[3];
               this.gP = new byte[3];

               for(int var2 = 0; var2 < this.gO.length; ++var2) {
                  this.gO[var2] = 220;
                  this.gP[var2] = 25;
               }

               this.gO[0] = 222;
               this.gP[0] = 26;
               if (this.fq == 1) {
                  this.gO[1] = 222;
                  this.gP[1] = 26;
               }

               if (!this.fv) {
                  this.gO[2] = 222;
                  this.gP[2] = 26;
               }

               this.gz = true;
               this.gj = 0;
               this.D(9);
               this.selectedMap = -1;
               this.gi = System.currentTimeMillis();
            } else if (this.gE) {
               var1.drawRGB(this.gJ, 0, this.companyLogoW, 240 - this.companyLogoW >> 1, (300 - this.companyLogoH >> 1) + this.gj, this.companyLogoW, this.companyLogoH, false);
            }
         } else if (this.fg == 4) {
            if (this.gE) {
               var1.drawRGB(this.gameLogoImage, 17 * this.gameLogoW, this.gameLogoW, 240 - this.gameLogoW >> 1, (300 - this.gameLogoH >> 1) + this.gj, this.gameLogoW, this.gameLogoH - 17, false);
            }
         } else if (this.fg == 2) {
            if (this.gz) {
               if (this.gA || this.gp == 8 || this.e) {
                  this.E();
                  this.e = false;
               }

               d(var1);
               this.f(var1);
               this.gz = false;
            } else {
               this.f(var1);
            }
         }

         if (this.fg == 1 || this.fg == 2 || this.fg == 4) {
            this.b(0, (Graphics)var1);
         }

      }
   }

   private void Z() {
      this.gM = new int[300];
      this.gN = new int[300];

      for(int var1 = 0; var1 < 300; ++var1) {
         this.gM[var1] = 6316128;
         this.gN[var1] = 8421504;
      }

   }

   private void b(int var1, Graphics var2) {
      var2.drawRGB(this.gM, 0, 1, this.gk, var1, 1, 299 - (var1 << 1), false);
      var2.drawRGB(this.gN, 0, 1, this.gl, var1, 1, 299 - (var1 << 1), false);
      if (this.a() % this.f == 0) {
         this.a(var2);
      }

   }

   private void aa() {
      if (this.fL == 35 || this.fx) {
         this.b(false);
         this.go = 6 + this.c;
         this.gp = 3;
         this.gz = true;
         this.gA = true;
         this.fg = 2;
         this.gm = 0;
         this.ex = (int[][])null;
         System.gc();
         this.et = true;
      }

   }

   private void a(boolean var1, Graphics var2) {
      try {
         Image uiImage = this.readImage("/i" + this.dataExt);
         var2.drawImage(uiImage, 0, 0, 20);
         var2.drawImage(uiImage, 0, 212, 20);
         if (var1) {
            this.gH = new int[2100];

            for(int var4 = 0; var4 < 10; ++var4) {
               uiImage.getRGB(this.gH, var4 * 15 * 14, 15, var4 * 15, 88, 15, 14);
            }
         }

      } catch (Exception var5) {
      }
   }

   private Image readImage(String fileName) {
      try {
         InputStream fileStream = this.getClass().getResourceAsStream(fileName);
         int lengthLowByte = fileStream.read() & 255;
         int lengthHighByte = fileStream.read() & 255;
         int imageDataLength = lengthLowByte | lengthHighByte << 8;
         byte[] imageData = new byte[imageDataLength + 4];
         fileStream.read(imageData, 4, imageDataLength);
         imageData[0] = -119;
         imageData[1] = 80;
         imageData[2] = 78;
         imageData[3] = 71;
         return Image.createImage(imageData, 0, imageDataLength + 4);
      } catch (Exception e) {
         return null;
      }
   }

   private void D(int var1) {
      if (this.ht != 0) {
         Runtime.getRuntime().totalMemory();
         this.hv = true;

         try {
            if (this.hp != null) {
               this.hp.stop();
               this.hp.close();
            }

            this.hr = null;
            this.hp = null;
            this.hr = this.getClass().getResourceAsStream("/" + this.ho[var1] + ".mid");
            this.hp = Manager.createPlayer(this.hr, "audio/midi");
            this.hp.realize();
            if (var1 != 8) {
               this.hp.setLoopCount(1000);
            }

            this.hq = (VolumeControl)((VolumeControl)this.hp.getControl("VolumeControl"));
            this.hq.setLevel(this.ht);
            this.hp.start();
         } catch (Exception var5) {
            this.hv = false;
            this.ht = 0;
         }
      }
   }

   private void ab() throws Exception {
      this.hw = RecordStore.openRecordStore("a1", true);
      int mapsNum = this.mapFiles.length;
      this.hx = new int[mapsNum];
      this.hy = new int[mapsNum];
      this.hz = new int[mapsNum];

      try {
         RecordEnumeration var2;
         if ((var2 = this.hw.enumerateRecords((RecordFilter)null, (RecordComparator)null, false)).numRecords() != 0) {
            byte[] var10 = var2.nextRecord();
            ByteArrayInputStream var11 = new ByteArrayInputStream(var10);
            DataInputStream var6 = new DataInputStream(var11);
            int var7 = this.hx.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               this.hx[var8] = var6.readInt();
               if (this.hx[var8] != -1) {
                  ++this.hA;
               }

               this.hy[var8] = var6.readInt();
               this.hz[var8] = var6.readInt();
            }

            this.ht = var6.readInt();
            this.fq = var6.readByte();
            this.fv = var6.readBoolean();
         } else {
            this.hA = 0;
            int var4 = this.hx.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               this.hx[var5] = -1;
               this.hy[var5] = -1;
               this.hz[var5] = -1;
            }

            this.b.numColors();
            this.ht = 100;
            this.fq = 1;
            this.fv = true;
         }
      } catch (Exception var9) {
      }
   }

   private void ac() {
      try {
         RecordEnumeration var2;
         if ((var2 = this.hw.enumerateRecords((RecordFilter)null, (RecordComparator)null, false)).numRecords() != 0) {
            int var1 = var2.nextRecordId();
            this.hw.deleteRecord(var1);
         }

         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         DataOutputStream var5 = new DataOutputStream(var4);

         for(int var6 = 0; var6 < this.hx.length; ++var6) {
            var5.writeInt(this.hx[var6]);
            var5.writeInt(this.hy[var6]);
            var5.writeInt(this.hz[var6]);
         }

         var5.writeInt(this.ht);
         var5.writeByte(this.fq);
         var5.writeBoolean(this.fv);
         this.hw.addRecord(var4.toByteArray(), 0, var4.toByteArray().length);
      } catch (Exception var7) {
      }
   }

   static int[][] a(a var0) {
      return var0.cW;
   }

   static int[] b(a var0) {
      return var0.cU;
   }

   static long[] c(a var0) {
      return var0.fz;
   }

   static int a(a var0, int var1) {
      return var0.fM = var1;
   }

   static int d(a var0) {
      return var0.fK;
   }

   static int e(a var0) {
      return var0.fL;
   }

   static int f(a var0) {
      return var0.fM;
   }

   static boolean a(a var0, boolean var1) {
      return var0.fN = var1;
   }

   static int b(a var0, int var1) {
      return var0.fL = var1;
   }

   static int g(a var0) {
      return var0.fg;
   }

   static int c(a var0, int var1) {
      return var0.fK = var1;
   }

   static boolean h(a var0) {
      return var0.fN;
   }

   static void i(a var0) {
      var0.K();
   }

   static long a(a var0, long var1) {
      return var0.eC = var1;
   }

   static long b(a var0, long var1) {
      return var0.fP = var1;
   }

   static long j(a var0) {
      return var0.eC;
   }

   static long k(a var0) {
      return var0.fO;
   }

   static long c(a var0, long var1) {
      return var0.fO = var1;
   }

   static long l(a var0) {
      return var0.fP;
   }

   static long d(a var0, long var1) {
      return var0.cp = var1;
   }

   static long m(a var0) {
      return var0.cp;
   }

   static boolean n(a var0) {
      return var0.gB;
   }

   static long d(a var0, int var1) {
      return var0.cp >>= var1;
   }

   static long e(a var0, long var1) {
      return var0.cn = var1;
   }

   static long f(a var0, long var1) {
      return var0.co = var1;
   }

   static long o(a var0) {
      return var0.cn;
   }

   static long g(a var0, long var1) {
      return var0.cq = var1;
   }

   static boolean p(a var0) {
      return var0.fy;
   }

   static boolean b(a var0, boolean var1) {
      return var0.fy = var1;
   }

   static boolean q(a var0) {
      return var0.fr;
   }

   static void r(a var0) {
      var0.P();
   }

   static long s(a var0) {
      return var0.fQ;
   }

   static void t(a var0) {
      var0.J();
   }

   static long h(a var0, long var1) {
      return var0.fQ = var1;
   }

   static long u(a var0) {
      return var0.fS;
   }

   static void v(a var0) {
      var0.V();
   }

   static long i(a var0, long var1) {
      return var0.fS = var1;
   }

   static boolean w(a var0) {
      return var0.ec;
   }

   static long x(a var0) {
      return var0.fR;
   }

   static void y(a var0) {
      var0.H();
   }

   static long j(a var0, long var1) {
      return var0.fR = var1;
   }

   static long z(a var0) {
      return var0.fX;
   }

   static boolean A(a var0) {
      return var0.fJ;
   }

   static boolean c(a var0, boolean var1) {
      return var0.fr = var1;
   }

   static boolean d(a var0, boolean var1) {
      return var0.fw = var1;
   }

   static Player B(a var0) {
      return var0.hp;
   }

   static long C(a var0) {
      return var0.eF;
   }

   static boolean e(a var0, boolean var1) {
      return var0.ft = var1;
   }

   static long D(a var0) {
      return var0.eG;
   }

   static boolean f(a var0, boolean var1) {
      return var0.fu = var1;
   }

   static int E(a var0) {
      return var0.em;
   }

   static void F(a var0) {
      var0.m();
   }

   static boolean[] G(a var0) {
      return var0.fY;
   }

   static long H(a var0) {
      return var0.eD;
   }

   static int e(a var0, int var1) {
      return var0.eT = var1;
   }

   static int I(a var0) {
      return var0.eU;
   }

   static void J(a var0) {
      var0.r();
   }

   static void K(a var0) {
      var0.z();
   }

   static void L(a var0) {
      var0.aa();
   }

   static int M(a var0) {
      return var0.fj;
   }

   static long N(a var0) {
      return var0.eE;
   }

   static int f(a var0, int var1) {
      return var0.eq = var1;
   }

   static void O(a var0) {
      var0.A();
   }

   static int P(a var0) {
      return var0.en;
   }

   static boolean Q(a var0) {
      return var0.eu;
   }

   static boolean g(a var0, boolean var1) {
      return var0.eu = var1;
   }

   static void R(a var0) {
      var0.v();
   }

   static void S(a var0) {
      var0.y();
   }

   static void T(a var0) {
      var0.L();
   }

   static boolean U(a var0) {
      return var0.es;
   }

   static void a(a var0, int var1, int var2, int var3) {
      var0.b(var1, var2, var3);
   }

   static long k(a var0, long var1) {
      return var0.eE = var1;
   }

   static long V(a var0) {
      return var0.fU;
   }

   static void W(a var0) {
      var0.B();
   }

   static long l(a var0, long var1) {
      return var0.fU = var1;
   }

   static long X(a var0) {
      return var0.fV;
   }

   static void h(a var0, boolean var1) {
      var0.d(var1);
   }

   static long m(a var0, long var1) {
      return var0.fV = var1;
   }

   static long Y(a var0) {
      return var0.fW;
   }

   static long n(a var0, long var1) {
      return var0.fW = var1;
   }

   static void Z(a var0) {
      var0.O();
   }
}

// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Random;
import java.util.Timer;
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

public final class c3d_b extends Canvas {
   private final short[] c = new short[]{3, 62, 121, 180};
   private short[] d;
   private short[] e;
   private short[] f;
   private short[] g;
   private byte[] h;
   private byte[] i;
   private byte[] j;
   private byte[] k;
   private byte[] l;
   private byte[] m;
   private byte[] n;
   private byte[] o;
   private int[][] loadedMap;
   private byte[] q = new byte[]{5, 100, 10, 8};
   private String r = ".b3d";
   private String[] mapFiles = new String[]{"/temple", "/catacomb", "/ground", "/chemical", "/chdepot", "/vine", "/cell", "/hall", "/rooms", "/library", "/vip", "/roof"};
   private String[] spriteFiles = new String[]{"/p", "/r", "/d", "/pp", "/rr", "dd"};
   private byte[][] u = new byte[][]{{1, 1, -1, 1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {1, -1, 1, 1}};
   private byte v;
   private byte w;
   private byte x;
   private byte y;
   private boolean z;
   private short[][][] A = new short[][][]{{{0, 17}, {135, 46}, {-90, 26}, {45, 40}, {180, 17}}, {{-90, 50}, {90, 56}, {0, 122}, {-90, 104}, {180, 122}, {0, 38}, {-90, 92}, {180, 104}, {0, 96}, {-90, 108}, {90, 74}, {0, 104}, {180, 96}, {90, 92}, {0, 113}, {180, 30}, {-90, 35}, {180, 44}, {90, 70}, {0, 44}, {-90, 39}}};
   private Image B;
   private Image C;
   private byte[][][][] D;
   private byte[][][] E;
   private int[] F;
   private int[] G;
   private int[] H;
   private byte I;
   private int J;
   private int K;
   private int[] L;
   private int[][] M;
   private int[] N;
   private int O;
   private int P;
   private int Q;
   private int R;
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
   private long aq;
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
   private int aX;
   private int aY;
   private int aZ;
   private int ba;
   private int bb;
   private int bc;
   private int bd;
   private int be;
   private int bf;
   private int bg;
   private int bh;
   private int bi;
   private int bj;
   private byte bk;
   private byte bl;
   private boolean bm;
   private boolean bn;
   private boolean bo;
   private boolean bp;
   private boolean bq;
   private boolean br;
   private boolean bs;
   private boolean bt;
   private boolean bu;
   private boolean bv;
   private boolean bw;
   private long[] bx;
   private long[] by;
   private long[] bz;
   private int[] bA;
   private int[] bB;
   private int[] bC;
   private int[] bD;
   private int[] bE;
   private int[] bF;
   private int[] bG;
   private int[][] bH;
   private int[][] bI;
   private short[][] bJ;
   private short[] bK;
   private short[] bL;
   private short[] bM;
   private short[] bN;
   private short[] bO;
   private short[] bP;
   private byte[] bQ;
   private byte[] bR;
   private byte[] bS;
   private byte[] bT;
   private short[][][] bU;
   private boolean[] bV;
   private long bW;
   private long bX;
   private long bY;
   private long bZ;
   private long ca;
   private long cb;
   private long cc;
   private long cd;
   private long ce;
   private long cf;
   private int cg;
   private int ch;
   private int ci;
   private int cj;
   private int ck;
   private int cl;
   private int cm;
   private int cn;
   private int co;
   private int cp;
   private int cq;
   private int cr;
   private boolean cs;
   private long[] ct;
   private long[] cu;
   private long[] cv;
   private long[] cw;
   private int[][] cx;
   private int[][] cy;
   private int[] cz;
   private int[] cA;
   private int[] cB;
   private short[] cC;
   private short[] cD;
   private short[] cE;
   private byte[] cF;
   private byte[] cG;
   private byte[] cH;
   private byte[] cI;
   private byte[] cJ;
   private byte[] cK;
   private byte[] cL;
   private byte[] cM;
   private byte[] cN;
   private byte[] cO;
   private byte[] cP;
   private byte[][] cQ;
   private short[][] cR;
   private boolean[] cS;
   private boolean[] cT;
   private boolean[] cU;
   private boolean[] cV;
   private boolean[] cW;
   private long cX;
   private long cY;
   private long cZ;
   private long da;
   private long db;
   private long dc;
   private long dd;
   private long de;
   private long df;
   private long dg;
   private long dh;
   private long di;
   private long dj;
   private long dk;
   private int dl;
   private byte dm;
   private short[][] dn;
   private short[][] do_;
   private long[] dp;
   private long[] dq;
   private int[] dr;
   private int[] ds;
   private int[] dt;
   private int[] du;
   private int[] dv;
   private int[] dw;
   private int[] dx;
   private int[] dy;
   private int[] dz;
   private int[] dA;
   private int[] dB;
   private int[] dC;
   private int[] dD;
   private int[] dE;
   private int[] dF;
   private int[] dG;
   private int[] dH;
   private int[] dI;
   private int[] dJ;
   private int[] dK;
   private int[] dL;
   private int[] dM;
   private int[] dN;
   private int[] dO;
   private int[][] dP;
   private long[] dQ;
   private long[][] dR;
   private long[][] dS;
   private long[][] dT;
   private long[][] dU;
   private boolean[] dV;
   private byte[] dW;
   private byte[] dX;
   private byte[] dY;
   private byte[] dZ;
   private byte[] ea;
   private byte[] eb;
   private byte[] ec;
   private byte[] ed;
   private byte[] ee;
   private byte[] ef;
   private byte[] eg;
   private byte[] eh;
   private byte[] ei;
   private byte[] ej;
   private byte[] ek;
   private byte[] el;
   private byte[] em;
   private byte[] en;
   private byte[] eo;
   private byte[] ep;
   private byte[] eq;
   private byte[] er;
   private byte[] es;
   private byte[] et;
   private byte[] eu;
   private byte[] ev;
   private byte[] ew;
   private byte[] ex;
   private byte[] ey;
   private byte[] ez;
   private byte[] eA;
   private int[][] eB;
   private int[][] eC;
   private byte[] eD;
   private byte[] eE;
   private byte[] eF;
   private byte[] eG;
   private int[] eH;
   private int[] eI;
   private int[] eJ;
   private int[] eK;
   private int[] eL;
   private int[] eM;
   private int[] eN;
   private boolean eO;
   private int eP;
   private int eQ;
   private int eR;
   private a eS;
   private long eT;
   private long eU;
   private long eV;
   private long eW;
   private long eX;
   private int eY;
   private int eZ;
   private int[] fa;
   private short[][] fb;
   private short[][] fc;
   private short[] fd;
   private short[] fe;
   byte[] a;
   private boolean[] ff;
   private Random fg;
   private long fh;
   private long fi;
   private long fj;
   private long fk;
   private long fl;
   private long fm;
   private long fn;
   private int fo;
   private int fp;
   private boolean fq;
   private boolean fr;
   private boolean fs;
   private boolean ft;
   private boolean fu;
   private boolean fv;
   private boolean fw;
   private boolean fx;
   private boolean fy;
   private boolean fz;
   private int[] fA;
   private int[] fB;
   private int fC;
   private int fD = 40;
   private int fE;
   private int fF;
   private int fG;
   private int fH;
   private int fI;
   private int fJ;
   private int fK;
   private int fL;
   private int fM;
   private int fN;
   private int fO;
   private int fP;
   private int fQ;
   private short fR;
   private boolean fS;
   private boolean fT;
   private boolean fU;
   private boolean fV;
   private boolean fW;
   private boolean fX = false;
   private boolean fY;
   private boolean fZ;
   private boolean ga = true;
   private boolean gb = true;
   private boolean gc;
   private int[] gd;
   private int[] ge;
   private int[] gf;
   private int[] gg;
   private int[] gh;
   private int[][] gi;
   private int[][] gj;
   private Timer gk;
   private long gl;
   private long gm;
   private long gn;
   private long go;
   private long gp;
   private long gq;
   private long gr;
   private int gs;
   private int gt;
   private int gu;
   private long gv;
   private long gw;
   private int[] gx;
   private int[] gy;
   private int gz;
   private int gA;
   private int gB;
   private int gC;
   private int gD;
   private int gE;
   private int gF = 100;
   private int gG;
   private int gH;
   private int gI;
   private int gJ;
   private int gK;
   private int gL;
   private int gM;
   private int gN;
   private int gO;
   private int gP;
   private int gQ;
   private int gR;
   private int gS;
   private int gT;
   private int gU;
   private int gV;
   private int gW;
   private int gX;
   private int gY;
   private int gZ;
   private int ha;
   private int hb = 100;
   private int selectedMap;
   private short hd;
   private short he;
   private short hf;
   private short hg;
   private int hh;
   private int hi;
   private byte hj;
   private byte hk;
   private byte hl;
   private byte hm;
   private byte hn;
   private byte ho;
   private byte hp;
   private byte hq;
   private boolean hr;
   private boolean hs;
   private boolean ht;
   private boolean hu;
   private boolean hv;
   private boolean hw;
   private boolean hx;
   private boolean hy;
   private boolean hz;
   private boolean hA;
   private boolean hB;
   private boolean hC;
   private boolean hD;
   private boolean hE;
   private long[] hF;
   private int[][] hG;
   private int[] hH;
   private int[] hI;
   private int[] hJ;
   private int[] hK;
   private short[] hL;
   private short[] hM;
   private short[][] hN;
   private byte[] hO;
   private byte[][] hP;
   private byte[][] hQ;
   private int hR;
   private int hS = 35;
   private boolean hT;
   private boolean[] hU;
   private byte[] hV = new byte[3];
   private long[] hW = new long[3];
   private int hX;
   private int hY;
   private int hZ;
   private int ia;
   private int ib;
   private int ic;
   private int id;
   private int ie;
   private int if_ = 180;
   private int ig = -1;
   private boolean ih;
   private boolean ii;
   private boolean ij;
   private boolean ik;
   private boolean il;
   private boolean im;
   private boolean in;
   private boolean io = false;
   private long ip;
   private long iq;
   private long ir;
   private long is;
   private long it;
   private long iu;
   private long iv;
   private long iw;
   private long ix = 10000L;
   private long iy;
   private long iz;
   private long iA;
   private long iB;
   private long iC;
   private long iD;
   private long iE;
   private long iF;
   private long iG;
   private long iH;
   private long iI;
   private long[] iJ;
   private byte iK = 0;
   private byte iL;
   private byte iM = 0;
   private long iN;
   private long iO;
   private int iP;
   private int iQ;
   private int iR;
   private int iS;
   private int iT;
   private int iU;
   private int iV;
   private int iW;
   private int iX;
   private int iY;
   private int iZ;
   private int ja;
   private int jb;
   private int jc;
   private int jd;
   private int je;
   private int jf;
   private boolean jg;
   private boolean jh;
   private boolean ji;
   private boolean jj;
   private boolean jk;
   private boolean jl;
   private boolean jm;
   private int[][] jn;
   private int[][] jo;
   private int[] jp;
   private int[] jq;
   private int[] jr;
   private int[] js;
   private int[] jt;
   private int[] ju;
   private int[] jv;
   private short[] jw;
   private byte[] jx;
   Display b;
   private String[] jy = new String[]{"000", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011", "012", "o", "gameover", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
   private Player jz;
   private VolumeControl jA;
   private InputStream jB;
   private int[] jC;
   private int jD;
   private int jE;
   private boolean jF;
   private RecordStore jG;
   private int[] jH;
   private int[] jI;
   private int[] jJ;
   private int[][] jK;
   private int jL;

   public b() {
      this.setFullScreenMode(true);
      this.fg = new Random();
      this.gk = new Timer();
      this.iO = System.currentTimeMillis();
      this.b = Display.getDisplay(Castle3D.a());
      this.gY = 1;
      this.ih = false;
      this.jd = 0;
      this.je = 0;
      this.jb = 0;
      this.jc = 0;
      this.Z();
      this.jC = new int[3];
      this.hU = new boolean[10];
      this.jF = true;
      this.jL = 0;

      try {
         this.ab();
      } catch (Exception var2) {
      }
   }

   private void a(int var1) {
      try {
         this.b.vibrate(var1);
      } catch (Exception var3) {
      }
   }

   public final void paint(Graphics var1) {
      this.g(var1);
      if (this.gY == 3 && !this.hB) {
         if (this.jh) {
            this.a(false, var1);
         }

         if (this.ji && this.jm) {
            c(var1);
            this.jj = true;
            if (this.jk) {
               this.jk = false;
            }
         } else {
            if (this.ji && this.jj) {
               var1.setColor(0, 0, 0);
               var1.fillRect(0, 0, 240, 54);
               var1.fillRect(0, 266, 240, 54);
               this.jj = false;
            }

            this.a(var1);
         }
      }

      if (this.gY == 3 && this.hB) {
         this.a(true);
         this.c(true);
         this.H();
         c(var1);
         int var3 = this.jt[22];
         if (this.ji) {
            this.selectedMap = 13;
         }

         int var4 = this.js[22] + this.selectedMap - 1;

         int var2;
         for(var2 = this.js[22]; var2 < var4; ++var2) {
            var3 += this.n[var2];
         }

         this.a(var3, var4, var4, 240 - this.n[var2] * 15 >> 1, 7, var1);
         this.a(true);
         this.c(true);
         this.hE = true;
         this.hB = false;
      }

      label87: {
         c3d_b var10000;
         byte var10001;
         if (this.ji && this.jm && !this.hE) {
            this.iS = 17 + (this.ja >> 2);
            int var5 = this.iS != 17 && this.iS == 18 ? 33 : 20;
            this.a(this.jt[this.iS], this.js[this.iS], this.js[this.iS] + this.m[this.iS] - 1, var5, 6, var1);
            var10000 = this;
            var10001 = 0;
         } else {
            if (!this.ji || this.hE) {
               break label87;
            }

            var10000 = this;
            var10001 = 54;
         }

         var10000.b(var10001, (Graphics)var1);
      }

      this.gk.schedule(new c(this, (d)null), 0L);
   }

   private void a(Graphics var1) {
      if (this.fR == 6) {
         ++this.selectedMap;
         this.hZ = 0;
         if (this.selectedMap != 12) {
            if (this.jL < this.selectedMap) {
               this.jL = this.selectedMap;
            }

            this.jH[this.selectedMap - 1] = this.fH;
            this.jI[this.selectedMap - 1] = this.gz;

            for(int var14 = 0; var14 < 4; ++var14) {
               this.jK[this.selectedMap - 1][var14] = this.gx[var14];
            }

            this.jJ[this.selectedMap - 1] = this.gA;

            try {
               if (this.jz != null) {
                  this.jz.stop();
               }
            } catch (Exception var7) {
            }

            this.ac();
         }

         this.fR = 0;
         this.hB = true;
         this.hr = true;
         this.gG = this.fH;
         this.gE = this.gz;

         for(int var15 = 0; var15 < 4; ++var15) {
            this.gy[var15] = this.gx[var15];
         }

         this.cU[15] = false;
         this.cU[16] = false;
         this.cU[17] = false;
      } else {
         if (this.fR >= 1 && this.fR <= 5) {
            ++this.fR;
         }

         if (this.hr) {
            this.b.numColors();
            boolean var3 = false;
            Runtime.getRuntime().totalMemory();
            this.hR = var1.getClipHeight();
            if (this.e == null) {
               this.readMetadata();
            }

            this.s();
            this.loadMap();
            this.m();
            this.t();
            this.fc = new short[7][];

            for(int var2 = 0; var2 < 7; ++var2) {
               this.y(var2);
            }

            this.o();
            this.eS = new a(this, this.fc[this.hh][0], (d)null);

            for(int var6 = 1; var6 < this.fc[this.hh].length; ++var6) {
               a.a(this.eS, this.fc[this.hh][var6]);
            }

            this.p();
            this.fS = false;
            this.fC = this.fH;
            if (!this.ji) {
               this.a(true, var1);
            }

            if (this.selectedMap == 12) {
               this.v();
               this.w();
            }

            if (this.selectedMap == 1 || this.selectedMap == 2) {
               this.x();
            }

            if (this.selectedMap == 2 || this.selectedMap == 4 || this.selectedMap == 5) {
               this.y();
            }

            this.n();
            this.u();
            this.ht = false;
            this.hu = false;
            this.hv = false;
            this.gZ = -1;
            this.ha = -1;
            this.fL = 0;
            this.fN = -1;
            this.fT = true;
            this.gd = new int[9];
            this.gh = new int[9];
            this.fy = false;
            this.ar = -1;
            this.cq = -1;
            this.as = -1;
            this.eO = false;
            if (this.ji) {
               c(var1);
            }

            this.hr = false;
            this.jm = true;
            this.gr = System.currentTimeMillis();
            this.hX = -10000;
            this.M();
            this.O();
            c3d_b var10000;
            byte var10001;
            if (this.selectedMap == 20) {
               this.fS = false;
               var10000 = this;
               var10001 = 1;
            } else {
               var10000 = this;
               var10001 = 6;
            }

            var10000.fJ = var10001;
            if (this.hA) {
               this.F(this.selectedMap);
            }

            if (this.ji) {
               return;
            }
         }

         this.jh = false;
         if (this.fy) {
            if (this.ij) {
               this.a(0, 6, (Graphics)var1);
               this.ij = false;
            }

            this.d(var1);
         } else {
            if (this.bG == null) {
               this.bG = new int['웊'];
            }

            if (this.fX) {
               this.a(false, var1);
               this.fX = false;
               this.fS = true;
               this.fC = 3;
               this.fL = 0;
               this.fN = -1;
               this.a(this.gx[this.fH], 189, (Graphics)var1);
               this.a(this.gz, 6, (Graphics)var1);
            }

            if (this.fV) {
               this.fV = false;
               var1.drawRGB(this.fB, 0, 56, this.c[1], 0, 56, 41, false);
               var1.setColor(175, 0, 0);
               var1.drawRect(this.c[1], -1, 55, 41);
            }

            if (this.fT && !this.ji) {
               this.gi = new int[9][];
               Image var16 = this.b("/w" + this.r);
               this.gd[0] = this.g[this.fH * 8 + 2];
               this.gh[0] = this.g[this.fH * 8 + 3];
               this.gi[0] = new int[this.gd[0] * this.gh[0]];
               this.a(var16, this.gi[0], this.gd[0], this.gh[0], this.g[this.fH * 8], this.g[this.fH * 8 + 1], false);
               this.gd[1] = this.g[this.fH * 8 + 4 + 2];
               this.gh[1] = this.g[this.fH * 8 + 4 + 3];
               this.gi[1] = new int[this.gd[1] * this.gh[1]];
               this.a(var16, this.gi[1], this.gd[1], this.gh[1], this.g[this.fH * 8 + 4], this.g[this.fH * 8 + 4 + 1], false);
               if (this.fH == 0 || this.fH == 2 && this.fW) {
                  this.gi[2] = new int[this.gd[0] * this.gh[0]];
                  this.a(var16, this.gi[2], this.gd[0], this.gh[0], this.g[this.fH * 8], this.g[this.fH * 8 + 1], true);
                  this.gi[3] = new int[this.gd[1] * this.gh[1]];
                  this.a(var16, this.gi[3], this.gd[1], this.gh[1], this.g[this.fH * 8 + 4], this.g[this.fH * 8 + 4 + 1], true);
               }

               if (this.fH == 2) {
                  this.gd[4] = this.g[34];
                  this.gh[4] = this.g[35];
                  this.gi[4] = new int[this.gd[4] * this.gh[4]];
                  this.a(var16, this.gi[4], this.gd[4], this.gh[4], this.g[32], this.g[33], false);
                  if (this.fW) {
                     this.gd[5] = this.g[34];
                     this.gh[5] = this.g[35];
                     this.gi[5] = new int[this.gd[5] * this.gh[5]];
                     this.a(var16, this.gi[5], this.gd[5], this.gh[5], this.g[32], this.g[33], true);
                  }
               }

               this.gd[6] = this.g[38];
               this.gh[6] = this.g[39];
               this.gi[6] = new int[this.gd[6] * this.gh[6]];
               this.a(var16, this.gi[6], this.gd[6], this.gh[6], this.g[36], this.g[37], false);
               this.gd[7] = this.g[42];
               this.gh[7] = this.g[43];
               this.gi[7] = new int[this.gd[7] * this.gh[7]];
               this.a(var16, this.gi[7], this.gd[7], this.gh[7], this.g[40], this.g[41], false);
               this.gd[8] = this.g[46];
               this.gh[8] = this.g[47];
               this.gi[8] = new int[this.gd[8] * this.gh[8]];
               this.a(var16, this.gi[8], this.gd[8], this.gh[8], this.g[44], this.g[45], false);
               this.b(var1);
               this.fT = false;
            }

            this.bH = new int[2][240];
            this.bV = new boolean[240];
            this.bQ = new byte[240];
            this.az = -1;
            this.aA = 240;
            this.e();
            this.gv = (this.hF[0] << 16) / 75000L;
            this.gw = (this.hF[1] << 16) / 75000L;
            this.d();
            this.a(this.eS);
            this.az = -1;
            this.aA = 240;
            this.c();
            int var17 = this.cR[this.hh].length;
            this.cg = 0;
            this.cs = false;
            this.E(var17);
            this.cg = 0;
            this.cs = true;
            this.E(var17);
            if (!this.ji && this.hy && !this.hD) {
               this.F();
            }

            if (this.gz < this.ha) {
               this.G();
            }

            var1.drawRGB(this.bG, 0, 240, 0, 54, 240, 212, false);
            if (this.selectedMap == 12 && this.fG < 8192) {
               this.a((Graphics)var1, 7680, this.fG);
            }

            if (this.im) {
               this.a((Graphics)var1, (int)15360);
            }

            if (!this.ji) {
               if (this.gx[this.fH] != this.gZ) {
                  this.a(this.gx[this.fH], 189, (Graphics)var1);
               }

               if (this.gz != this.ha) {
                  this.a(this.gz, 6, (Graphics)var1);
               }
            }

            if (!this.ji && !this.hD) {
               if (this.ft || this.fw || this.fx || this.fu) {
                  this.gz = 0;
                  this.a(this.gz, 6, (Graphics)var1);
                  this.fz = false;
                  this.J();
                  this.gz = this.gE;
                  if (this.gz > 100) {
                     this.gF = 200;
                  }

                  for(int var13 = 0; var13 < 4; ++var13) {
                     this.gx[var13] = this.gy[var13];
                  }

                  this.fH = this.gG;
                  if (this.gx[this.fH] > 0) {
                     this.gb = true;
                  }

                  return;
               }

               c3d_b var18;
               int var21;
               int var10002;
               int var10003;
               int var10004;
               label500: {
                  if (this.fO == 53 && this.gx[this.fH] > 0) {
                     if (this.cx[65][0] != 0 && this.cx[65][1] != 0 && this.fK == 0) {
                        this.cx[65][0] = 0;
                        this.cx[65][1] = 0;
                     }

                     if (this.fH == 1) {
                        var18 = this;
                        var21 = this.fH;
                        var10002 = this.fK;
                        var10003 = 0;
                        var10004 = this.fK * 2;
                        break label500;
                     }

                     if (this.fH == 2) {
                        if (this.fW) {
                           var18 = this;
                           var21 = this.fH;
                           var10002 = this.fK;
                           var10003 = 1 - this.fK;
                           var10004 = this.fL;
                        } else {
                           var18 = this;
                           var21 = this.fH;
                           var10002 = this.fK;
                           var10003 = 0;
                           var10004 = this.fL;
                        }
                        break label500;
                     }

                     if (this.fH == 0) {
                        if (this.fK == 0) {
                           var18 = this;
                           var21 = this.fH;
                           var10002 = 0;
                           var10003 = 0;
                           var10004 = this.fL;
                        } else if (this.fY) {
                           var18 = this;
                           var21 = this.fH;
                           var10002 = this.fK;
                           var10003 = 0;
                           var10004 = this.fL;
                        } else {
                           var18 = this;
                           var21 = this.fH;
                           var10002 = 0;
                           var10003 = this.fK;
                           var10004 = this.fL;
                        }
                        break label500;
                     }

                     var18 = this;
                  } else {
                     this.cx[64][0] = 0;
                     this.cx[64][1] = 0;
                     this.cx[65][0] = 0;
                     this.cx[65][1] = 0;
                     if (this.fH != 3) {
                        var18 = this;
                        var21 = this.fH;
                        var10002 = 0;
                        var10003 = 0;
                        var10004 = this.fL;
                        break label500;
                     }

                     if (this.gb || this.fK == 0) {
                        var18 = this;
                        var21 = this.fH;
                        var10002 = 0;
                        var10003 = 0;
                        var10004 = this.fL;
                        break label500;
                     }

                     var18 = this;
                  }

                  var21 = this.fH;
                  var10002 = this.fK;
                  var10003 = 0;
                  var10004 = this.ia;
               }

               var18.a(var21, var10002, var10003, var10004, var1);
               var1.drawRGB(this.jn[this.fH], 0, 24, 156, 281, 24, 25, true);
               if (this.fu) {
                  this.gz = 0;
                  this.a(this.gz, 6, (Graphics)var1);
                  this.fz = false;
                  this.J();
                  this.gz = this.gE;
                  if (this.gz > 100) {
                     this.gF = 200;
                  }

                  for(int var12 = 0; var12 < 4; ++var12) {
                     this.gx[var12] = this.gy[var12];
                  }

                  this.fH = this.gG;
                  if (this.gx[this.fH] > 0) {
                     this.gb = true;
                  }

                  return;
               }

               if (this.fw) {
                  this.gz = 0;
                  this.a(this.gz, 6, (Graphics)var1);
                  this.fz = false;
                  this.J();
                  this.gz = this.gE;
                  if (this.gz > 100) {
                     this.gF = 200;
                  }

                  for(int var11 = 0; var11 < 4; ++var11) {
                     this.gx[var11] = this.gy[var11];
                  }

                  this.fH = this.gG;
                  if (this.gx[this.fH] > 0) {
                     this.gb = true;
                  }

                  return;
               }

               if (this.fx) {
                  this.gz = 0;
                  this.a(this.gz, 6, (Graphics)var1);
                  this.fz = false;
                  this.J();
                  this.gz = this.gE;
                  if (this.gz > 100) {
                     this.gF = 200;
                  }

                  for(int var10 = 0; var10 < 4; ++var10) {
                     this.gx[var10] = this.gy[var10];
                  }

                  this.fH = this.gG;
                  if (this.gx[this.fH] > 0) {
                     this.gb = true;
                  }

                  return;
               }
            }

            if (this.hg == -1 && !this.ji) {
               this.a(var1, this.hn);
            }

            if (this.ht) {
               var1.drawRGB(this.hG[this.hn], 0, 28, 210, 236, 28, 28, false);
               this.a(var1, this.hn);
               if (!this.hA && !this.hu && !this.hU[5]) {
                  this.F(22);
               }
            }

            if (this.hu) {
               var1.drawRGB(this.hH, 0, 26, 2, 238, 26, 26, false);
               if (!this.hA && !this.ht && !this.hU[5]) {
                  this.F(21);
               }
            }

            if (this.hv) {
               var1.drawRGB(this.hI, 0, 28, 210, 236, 28, 28, false);
            }

            c3d_b var19;
            boolean var22;
            if (this.gx[this.fH] > 0 && this.fK != 2) {
               var19 = this;
               var22 = 0;
            } else {
               var19 = this;
               var22 = 1;
            }

            var19.gc = (boolean)var22;
            this.gZ = this.gx[this.fH];
            this.ha = this.gz;
            if (this.hD) {
               var1.setColor(0, 0, 0);
               var1.fillRect(0, 0, 240, 54);
               var1.fillRect(0, 266, 240, 54);
            }

            if (this.fZ) {
               label497: {
                  if (this.fE >= 0 && this.fE <= 3) {
                     var19 = this;
                     var22 = this.fD - 10;
                  } else {
                     if (this.fE < 20 || this.fE > 23) {
                        break label497;
                     }

                     var19 = this;
                     var22 = this.fD + 10;
                  }

                  var19.fD = var22;
               }

               this.fM = this.fE % 4;
               this.a(this.fM, var1);
               this.gz -= this.hq;
               if (this.gz <= 100) {
                  this.gF = 100;
               }

               if (this.gz <= 0 && !this.fy) {
                  this.gz = 0;
                  this.a(this.gz, 6, (Graphics)var1);
                  this.fz = true;
                  this.J();
                  this.gz = this.gE;
                  if (this.gz > 100) {
                     this.gF = 200;
                  }

                  for(int var9 = 0; var9 < 4; ++var9) {
                     this.gx[var9] = this.gy[var9];
                  }

                  this.fH = this.gG;
                  if (this.gx[this.fH] > 0) {
                     this.gb = true;
                  }

                  this.fK = 0;
                  this.fE = 0;
                  this.fZ = false;
                  this.fM = 0;
                  this.fD = 40;
                  return;
               }

               if (this.fE == 23) {
                  this.fE = 0;
                  this.fZ = false;
                  this.fM = 0;
                  this.fD = 40;
               } else {
                  ++this.fE;
               }
            }

            if (this.fv) {
               this.gz -= 50;
               if (this.gz <= 100) {
                  this.gF = 100;
               }

               if (this.gz <= 0 && !this.fy) {
                  this.gz = 0;
                  this.a(this.gz, 6, (Graphics)var1);
                  this.fz = false;
                  this.J();
                  this.gz = this.gE;
                  if (this.gz > 100) {
                     this.gF = 200;
                  }

                  for(int var8 = 0; var8 < 4; ++var8) {
                     this.gx[var8] = this.gy[var8];
                  }

                  this.fH = this.gG;
                  if (this.gx[this.fH] > 0) {
                     this.gb = true;
                  }

                  this.fv = false;
                  this.fK = 0;
                  this.gb = true;
                  this.fK = 0;
                  return;
               }

               this.fv = false;
            }

         }
      }
   }

   private static short readShort(byte[] var0, int var1) {
      return (short)(var0[var1] & 255 | (var0[var1 + 1] & 255) << 8);
   }

   private byte[] readBinary(String var1) {
      try {
         InputStream var4;
         byte[] var2 = new byte[(var4 = this.getClass().getResourceAsStream(var1)).read() & 255 | (var4.read() & 255) << 8];
         var4.read(var2, 0, var2.length);
         return var2;
      } catch (Exception var5) {
         return null;
      }
   }

   private void readMetadata() {
      int var2 = 0;
      byte[] var4 = this.readBinary("/a" + this.r);
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

   private void loadMap() {
      int var3 = 0;
      int var5 = this.selectedMap == 0 ? 1 : this.selectedMap;
      c3d_b var10000;
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
      short var7 = readShort((byte[])(var6 = var10000.readBinary(var10001.append(var10002).append(this.r).toString())), (int)0);
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

   private void loadMapInner(short[] footer) {
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
      this.c(false);
      System.gc();
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
      c3d_b var10000;
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

   private void loadMapPart(int[] var1, int[] var2, byte[] var3, int var4) {
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

   private void modifyBigLumps01(byte[][][] var1, byte[][][] var2) {
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
      this.s(var17);
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

   private void modifyBigLump1(byte[][][] var1) {
      this.dn = new short[7][];
      this.do_ = new short[7][];
      this.gS = this.gP;
      this.gT = this.gS + 4 * var1[12].length;
      this.gU = this.gT + 3 * var1[20].length;

      for(int var2 = 0; var2 < 7; ++var2) {
         int var12 = var1[var2].length + var1[var2 + 13].length + var1[var2 + 21].length + var1[var2 + 42].length + var1[var2 + 52].length;
         this.dn[var2] = new short[var12];
         this.do_[var2] = new short[var12];
         int var10 = var1[var2].length;

         int var3;
         for(var3 = 0; var3 < var10; ++var3) {
            this.dn[var2][var3] = (short)(var1[var2][var3][0] + 128);
            this.do_[var2][var3] = (short)(var1[var2][var3][1] + 128);
         }

         var10 = var1[var2 + 13].length + var3;

         int var6;
         for(var6 = var3; var6 < var10; ++var6) {
            byte var13 = var1[var2 + 13][var6 - var3][0];
            this.dn[var2][var6] = (short)(this.gS + var13 * 4);
            this.do_[var2][var6] = (short)(this.dn[var2][var6] + 3);
            int var14;
            short[] var10000;
            int var10001;
            int var10002;
            if (v(var14 = var1[12][var13][3] % 90) <= 3) {
               var10000 = this.do_[var2];
               var10001 = var6;
               var10002 = var10000[var6] - v(var14);
            } else {
               if (v(var14) > 6) {
                  continue;
               }

               var10000 = this.dn[var2];
               var10001 = var6;
               var10002 = var10000[var6] + (v(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            var1[12][var13][3] = (byte)(var1[12][var13][3] - var14);
         }

         var10 = var1[var2 + 21].length + var6;

         int var7;
         for(var7 = var6; var7 < var10; ++var7) {
            this.dn[var2][var7] = (short)(this.gT + v(var1[var2 + 21][var7 - var6][0]) % 60 * 3);
            this.do_[var2][var7] = (short)(this.dn[var2][var7] + 2);
            short[] var64;
            int var72;
            int var79;
            if (var1[var2 + 21][var7 - var6][0] < 0) {
               var64 = this.dn[var2];
               var72 = var7;
               var79 = var64[var7] + 2;
            } else {
               if (var1[var2 + 21][var7 - var6][0] < 60) {
                  continue;
               }

               var64 = this.do_[var2];
               var72 = var7;
               var79 = var64[var7] - 2;
            }

            var64[var72] = (short)var79;
         }

         var10 = var1[var2 + 42].length + var7;

         int var8;
         for(var8 = var7; var8 < var10; ++var8) {
            int var53 = 128 + var1[var2 + 42][var8 - var7][0];
            this.dn[var2][var8] = (short)(this.gU + var53 * 4);
            this.do_[var2][var8] = (short)(this.dn[var2][var8] + 3);
            int var55;
            short[] var65;
            int var73;
            int var80;
            if (v(var55 = var1[41][var53][2] % 90) <= 3) {
               var65 = this.do_[var2];
               var73 = var8;
               var80 = var65[var8] - v(var55);
            } else {
               if (v(var55) > 6) {
                  continue;
               }

               var65 = this.dn[var2];
               var73 = var8;
               var80 = var65[var8] + (v(var55) - 3);
            }

            var65[var73] = (short)var80;
            var1[41][var53][2] = (byte)(var1[41][var53][2] - var55);
         }

         var10 = var1[var2 + 52].length + var8;

         for(int var9 = var8; var9 < var10; ++var9) {
            this.dn[var2][var9] = (short)this.bB[var1[var2 + 52][var9 - var8][0]];
            this.do_[var2][var9] = (short)(this.bB[var1[var2 + 52][var9 - var8][0] + 1] - 1);
         }
      }

      c3d_b var66;
      byte var74;
      long var81;
      long var10003;
      if (this.selectedMap != 3 && this.selectedMap != 8 && this.selectedMap != 12) {
         var66 = this;
         var74 = var1[8][0][0];
         var81 = (long)var1[8][0][1] * 75000L;
         var10003 = (long)var1[8][0][2] * 75000L;
      } else {
         var66 = this;
         var74 = var1[8][0][0];
         var81 = (long)var1[8][0][1] * 75000L + 32768L;
         var10003 = (long)var1[8][0][2] * 75000L + 32768L;
      }

      var66.a(var74, var81, var10003, var1[8][0][3] * 2, var1[8][0][7]);
      this.dm = (byte)(16 + var1[8][0][5]);
      this.dl = var1[8][0][6];
      int var50 = this.gP;
      this.gQ = var1[12].length;
      int var54 = 188 + this.gQ;
      this.cO = new byte[var54];
      this.cx = new int[var54][2];
      this.cW = new boolean[var54];
      this.cJ = new byte[var54];
      this.cK = new byte[var54];
      this.cP = new byte[var54];
      this.cL = new byte[var54];
      int var41 = var1[12].length;

      for(int var26 = 0; var26 < var41; ++var26) {
         int var56 = 128 + var1[12][var26][0] << 16 >> 2;
         int var15 = 128 + var1[12][var26][1] << 16 >> 2;
         int var35 = 188 + var26;
         this.cx[var35][0] = var56;
         this.cx[var35][1] = var15;
         this.cO[var35] = (byte)(this.dm - 1);
         this.cW[var35] = false;
         this.cJ[var35] = (byte)(this.dm + 2 + var1[12][var26][4]);
         byte[] var67;
         byte var82;
         if (this.selectedMap != 12) {
            var67 = this.cK;
            var74 = var35;
            var82 = (byte)(v(this.I()) % 3);
         } else {
            var67 = this.cK;
            var74 = var35;
            var82 = 2;
         }

         var67[var74] = var82;
         if (var1[12][var26][4] > 4) {
            var67 = this.cJ;
            var67[var35] = (byte)(var67[var35] - 4);
            this.cP[var35] = 1;
         }

         var50 = this.a((long)var56, (long)var15, 16384L, 16384L, var1[12][var26][3], var50, var1[12][var26][2], var1[12][var26][2], var1[12][var26][2], var1[12][var26][2], (byte)1, (byte)0);
      }

      this.gR = var1[20].length;
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
      var41 = var1[20].length;

      for(int var27 = 0; var27 < var41; ++var27) {
         this.eB[var27][0] = 128 + var1[20][var27][0] << 16 >> 2;
         this.eB[var27][1] = 128 + var1[20][var27][1] << 16 >> 2;
         byte[] var69;
         byte var83;
         if (var1[20][var27][2] * var1[20][var27][3] >= 0) {
            this.eD[var27] = 0;
            var69 = this.eE;
            var74 = var27;
            var83 = 1;
         } else {
            this.eD[var27] = 1;
            var69 = this.eE;
            var74 = var27;
            var83 = 0;
         }

         var69[var74] = (byte)var83;
         this.eH[var27] = (var1[20][var27][2] << 16) / 127;
         this.eI[var27] = (var1[20][var27][3] << 16) / 127;
         this.eP = this.eI[var27];
         this.eF[var27] = var1[59][var27][3];
         this.eL[var27] = 0;
         this.eM[var27] = 6225920;
         int[] var70;
         if (this.eI[var27] > 0) {
            var70 = this.eJ;
            var74 = var27;
            var83 = 65536;
         } else {
            var70 = this.eJ;
            var74 = var27;
            var83 = -65536;
         }

         var70[var74] = var83;
         this.eQ = this.eJ[var27];
         this.eK[var27] = (this.eJ[var27] - this.eI[var27]) / this.eF[var27];
         this.eR = this.eJ[var27] - this.eI[var27];
         this.eC[var27][this.eD[var27]] = this.eB[var27][this.eD[var27]] + this.eJ[var27];
         this.eC[var27][this.eE[var27]] = this.eB[var27][this.eE[var27]];
         this.eN[var27] = -1;
         this.eG[var27] = var1[28][var27][0];
         this.a(var1[59][var27][0], var1[59][var27][1], var1[59][var27][2], var50);
         this.a(this.eB[var27], (long)this.eH[var27], (long)this.eJ[var27], this.eD[var27], this.eE[var27], var50, 0);
         var50 = this.a(this.eB[var27], (long)this.eH[var27], (long)this.eI[var27], this.eD[var27], this.eE[var27], var50, 1);
      }

      this.gP = var50;
      this.bT = new byte[var1[30].length * 7];
      this.bL = new short[32 + var1[30].length];
      int var5 = 0;
      var41 = var1[30].length;

      for(int var28 = 0; var28 < var41; ++var28) {
         this.bL[32 + var28] = 96;
         int var11 = var1[30][var28].length;

         for(int var4 = 0; var4 < var11; ++var4) {
            this.bT[var5] = var1[30][var28][var4];
            ++var5;
         }
      }

      var50 = this.gP;
      var41 = var1[41].length;

      for(int var29 = 0; var29 < var41; ++var29) {
         long var57 = (long)(128 + var1[41][var29][0] << 16 >> 2);
         long var16 = (long)(128 + var1[41][var29][1] << 16 >> 2);
         long var18 = (long)((var1[60][var29][0] << 16) / 42 >> 1);
         long var20 = (long)((var1[60][var29][1] << 16) / 42 >> 1);
         var50 = this.a(var57, var16, var18, var20, var1[41][var29][2], var50, var1[61][var29][0], var1[61][var29][1], var1[61][var29][2], var1[61][var29][3], var1[62][var29][0], var1[62][var29][1]);
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
      this.a(0, 49, (byte[][][])var1);
      this.a(1, 70, (byte[][][])var1);
      this.a(2, 72, (byte[][][])var1);
      this.a(3, 74, (byte[][][])var1);
      this.a(4, 76, (byte[][][])var1);
      this.a(5, 78, (byte[][][])var1);
      this.a(6, 80, (byte[][][])var1);
      this.a(7, 82, (byte[][][])var1);
      this.a(8, 84, (byte[][][])var1);
      this.a(9, 86, (byte[][][])var1);
      this.a(10, 88, (byte[][][])var1);
      this.a(11, 90, (byte[][][])var1);
      this.a(12, 92, (byte[][][])var1);
      this.a(13, 94, (byte[][][])var1);
      this.a(14, 96, (byte[][][])var1);
      this.a(15, 98, (byte[][][])var1);
      if (this.selectedMap == 4) {
         this.M();
         var66 = this;
         var74 = 0;
      } else {
         var66 = this;
         var74 = 1;
      }

      var66.hx = (boolean)var74;
      this.hZ = 0;
      var50 = this.gP;
      this.gV = var50;
      var41 = var1[51].length;
      this.bA = new int[var41];

      for(int var30 = 0; var30 < var41; ++var30) {
         long var58 = (long)(128 + var1[51][var30][0] << 16 >> 2);
         long var60 = (long)(128 + var1[51][var30][1] << 16 >> 2);
         long var22 = (long)((var1[51][var30][3] << 16) / 60);
         this.bA[var30] = var1[51][var30][6];
         var50 = this.a(var58, var60, var1[51][var30][2], var22, var50, var1[51][var30][4], var1[51][var30][5], var1[51][var30][7], var1[51][var30][8]);
      }

      this.gP = var50;
      this.gW = var50;
      var41 = var1[33].length;
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
         long var59 = (long)(128 + var1[33][var31][0] << 16 >> 2);
         long var61 = (long)(128 + var1[33][var31][1] << 16 >> 2);
         this.dR[0][var31] = var59;
         this.dR[1][var31] = var61;
         this.dN[var31] = var1[33][var31][4];
         this.dV[var31] = false;
         this.dX[var31] = var1[33][var31][9];
         this.dO[var31] = 0;
         long var62 = (long)((var1[33][var31][2] << 16) / 42 >> 1);
         long var63 = (long)((var1[33][var31][3] << 16) / 42 >> 1);
         this.dU[0][var31] = var62;
         this.dU[1][var31] = var63;
         var50 = this.a(var59, var61, var62, var63, 0, var50, var1[33][var31][5], var1[33][var31][6], var1[33][var31][7], var1[33][var31][8], var31, var1[33][var31][10], this.dX[var31]);
      }

      this.gP = var50;
      this.cQ = new byte[7][];

      for(int var24 = 34; var24 < 41; ++var24) {
         var41 = var1[var24].length;
         this.cQ[var24 - 34] = new byte[var41];

         for(int var32 = 0; var32 < var41; ++var32) {
            this.cQ[var24 - 34][var32] = var1[var24][var32][0];
         }
      }

      this.cR = new short[7][];

      for(int var25 = 63; var25 < 70; ++var25) {
         var41 = var1[var25].length;
         int var49 = var1[var25 - 50].length;
         this.cR[var25 - 63] = new short[var41 + var49];

         int var33;
         for(var33 = 0; var33 < var41; ++var33) {
            this.cR[var25 - 63][var33] = (short)(128 + var1[var25][var33][0]);
         }

         int var36 = var33;

         for(int var34 = 0; var34 < var49; ++var34) {
            this.cR[var25 - 63][var36] = (short)(188 + var1[var25 - 50][var34][0]);
            ++var36;
         }
      }

   }

   private void a(int var1, int var2, byte[][][] var3) {
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

   private void loadSpritesPart1(byte[][][] var1) {
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
            var10002 = (byte)(v(this.I()) % 8);
         } else if (this.selectedMap != 7 && this.selectedMap != 4 && this.selectedMap != 5) {
            var10000 = this.cN;
            var10001 = var3;
            var10002 = (byte)(v(this.I()) % 2 * 3 + v(this.I()) % 2 * 4);
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
            var22 = (byte)(v(this.I()) % 3);
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

   private void a(short[] var1, int var2, int var3) {
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

   private void a(int var1, int var2, int[] var3) {
      a(this.ee, this.ef, this.bJ[1][var1], this.bO[var1], var2, 0, var3, false);
   }

   private void b(int var1, int var2, int[] var3) {
      a(this.dY, this.dZ, this.bJ[0][var1], this.bO[var1], var2, 0, var3, true);
      a(this.ea, this.eb, this.bJ[0][var1], this.bO[var1], var2, 4, var3, false);
      a(this.ec, this.ed, this.bJ[0][var1], this.bO[var1], var2, 2, var3, false);
   }

   private void c(int var1, int var2, int[] var3) {
      a(this.eg, this.eh, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 0, var3, true);
   }

   private void d(int var1, int var2, int[] var3) {
      a(this.ei, this.ej, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 2, var3, false);
      a(this.ek, this.el, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 0, var3, false);
   }

   private void e(int var1, int var2, int[] var3) {
      a(this.em, this.en, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 0, var3, true);
      a(this.eo, this.ep, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 2, var3, true);
   }

   private void f(int var1, int var2, int[] var3) {
      a(this.eq, this.er, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 0, var3, true);
   }

   private void g(int var1, int var2, int[] var3) {
      a(this.es, this.et, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 0, var3, true);
      a(this.eu, this.ev, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 2, var3, true);
      a(this.ew, this.ex, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 6, var3, false);
      a(this.ey, this.ez, this.bJ[this.bM[var1]][var1], this.bO[var1], var2, 4, var3, false);
   }

   private void loadSpritesPart2(byte[][][] var1) {
      Object var7 = null;
      Object var8 = null;
      Image var27 = this.b("/e" + this.r);
      c3d_b var10000;
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

      Image var28 = var10000.b(var10001.append(var10002).append(this.r).toString());
      int[] var9 = new int[2];
      var27.getRGB(var9, 0, 2, 0, 0, 2, 1);
      this.Q = var9[0];
      this.R = var9[1];
      this.bJ = new short[7][];
      this.L = new int[this.bJ.length];
      int var2 = this.bJ.length;
      int var3 = (16 + var1[5].length + 2) * 2;

      for(int var10 = 0; var10 < var2; ++var10) {
         this.bJ[var10] = new short[var3];
         this.L[var10] = 16 + var1[5].length + 2;
         int var4 = this.bJ[var10].length;

         for(int var11 = 0; var11 < var4; ++var11) {
            this.bJ[var10][var11] = 0;
         }
      }

      int var14 = 16 + var1[5].length;
      this.cE = new short[var14];
      this.bM = new short[var14];
      this.bN = new short[var14];
      this.bC = new int[var14];
      this.bO = new short[var14];
      this.bP = new short[var14];
      int var13 = 0;
      var2 = this.e.length;

      for(int var29 = 0; var29 < var2; var29 += 7) {
         this.a(this.e, var13, var29);
         this.cE[var13] = this.e[var29 + 6];
         ++var13;
      }

      var13 = 16;
      var2 = var1[5].length;

      for(int var12 = 0; var12 < var2; ++var12) {
         int var30 = (var1[5][var12][0] < 0 ? -var1[5][var12][0] : var1[5][var12][0]) * 7;
         this.a(this.f, var13, var30);
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
      this.a(var16, var17, var1[1].length, var18, var19, var21, var20, var22);
      var13 = 0;
      short var23 = 0;
      var2 = this.e.length;

      for(int var31 = 0; var31 < var2; var31 += 7) {
         int[] var5 = new int[this.e[var31 + 2] * this.e[var31 + 3]];
         int[] var6 = new int[this.e[var31 + 2] * this.e[var31 + 3]];
         var27.getRGB(var5, 0, this.e[var31 + 2], this.e[var31 + 0], this.e[var31 + 1], this.e[var31 + 2], this.e[var31 + 3]);
         var28.getRGB(var6, 0, this.e[var31 + 2], this.e[var31 + 0], this.e[var31 + 1], this.e[var31 + 2], this.e[var31 + 3]);
         this.a(var5, var6, this.bI, var23, var1[0][0], var1[0][1]);
         var23 = (short)(var23 + 97);
         int var15 = this.bP[var13] / this.bN[var13];
         if (this.bM[var13] == 0) {
            this.b(var13, var15, var5);
         } else if (this.bM[var13] == 1) {
            this.a(var13, var15, var5);
         }

         ++var13;
      }

   }

   private void loadSpritesPart3(byte[][][] var1) {
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
      int var7 = var1[5].length;

      for(int var5 = 0; var5 <= 2; ++var5) {
         Image var10 = this.b(this.spriteFiles[var5] + this.r);
         Image var11 = this.b(this.spriteFiles[var5 + 3] + this.r);

         for(int var4 = 0; var4 < var7; ++var4) {
            if (var5 == 0) {
               if (var1[5][var4][0] < 0 || var1[5][var4][0] > 82 && var1[5][var4][0] != 122) {
                  continue;
               }
            } else if (var5 == 1) {
               if (var1[5][var4][0] >= 0) {
                  continue;
               }

               var1[5][var4][0] = (byte)(-var1[5][var4][0]);
            } else if (var1[5][var4][0] <= 82) {
               continue;
            }

            int var14 = var1[5][var4][0] * 7;
            int[] var8 = new int[this.f[var14 + 2] * this.f[var14 + 3]];
            int[] var9 = new int[this.f[var14 + 2] * this.f[var14 + 3]];
            var10.getRGB(var8, 0, this.f[var14 + 2], this.f[var14 + 0], this.f[var14 + 1], this.f[var14 + 2], this.f[var14 + 3]);
            var11.getRGB(var9, 0, this.f[var14 + 2], this.f[var14 + 0], this.f[var14 + 1], this.f[var14 + 2], this.f[var14 + 3]);
            int var12 = 1552 + var4 * 97;
            this.a(var8, var9, this.bI, (short)var12, var1[6][var4], var1[1][var4]);
            var2 = 16 + var4;
            int var6 = this.bP[var2] / this.bN[var2];
            if (this.bM[var2] == 0) {
               this.b(var2, var6, var8);
            } else if (this.bM[var2] == 1) {
               this.a(var2, var6, var8);
            } else if (this.bM[var2] == 2) {
               this.c(var2, var6, var8);
            } else if (this.bM[var2] == 3) {
               this.d(var2, var6, var8);
            } else if (this.bM[var2] == 4) {
               this.f(var2, var6, var8);
            } else if (this.bM[var2] == 5) {
               this.e(var2, var6, var8);
            } else if (this.bM[var2] == 6) {
               this.g(var2, var6, var8);
            }

            this.E = (byte[][][])null;
            System.gc();
         }
      }

   }

   private void a(byte[][][] var1, byte[][][] var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = var2[9][var3][0];
      byte var9 = var1[2][var3][5];
      int var10 = this.k[6 * var8] + 128;
      if (this.O != var3 && var5 != var6) {
         if (var4 == 0) {
            if (var9 != 12) {
               this.B = this.b("/" + String.valueOf(var10) + this.r);
            } else {
               Image var11 = this.b("/" + String.valueOf(var10) + this.r);
               this.B = Image.createImage(var11, 0, 0, var11.getWidth(), var11.getHeight(), 5);
            }
         } else {
            this.C = this.b("/" + String.valueOf(var10) + this.r);
         }
      }

      if (this.O != var3) {
         Image var10000;
         int[] var10001;
         if (var4 == 0) {
            var10000 = this.B;
            var10001 = this.H;
         } else {
            this.F = new int[this.J * this.K];
            var10000 = this.C;
            var10001 = this.F;
         }

         var10000.getRGB(var10001, 0, this.J, var1[4][var3][0], var1[4][var3][1], this.J, this.K);
         c3d_b var14;
         if (var4 != 0) {
            var14 = this;
            var10001 = this.F;
         } else {
            var14 = this;
            var10001 = this.H;
         }

         var14.a(var10001, var1, var3);
         if (var4 == 0 && var7 == var3) {
            this.O = var3;
            this.G = new int[this.J * this.K];
            this.a((int[])this.G, (int[])this.H, 0, 0, this.J, this.J, this.K);
         }

      } else {
         int var13 = this.G.length;

         for(int var12 = 0; var12 < var13; ++var12) {
            this.H[var12] = this.G[var12];
         }

      }
   }

   private void a(int[] var1, byte[][][] var2, int var3) {
      byte var4 = var2[2][var3][0];
      byte var5 = var2[2][var3][1];
      byte var6 = var2[2][var3][2];
      byte var7 = var2[2][var3][3];
      byte var8 = var2[2][var3][4];
      if (var4 != 0 || var5 != 0 || var6 != 0 || var7 != 0 || var8 != 0) {
         this.a(var1, var4, var5, var6, var7, var8, false);
      }

   }

   private void loadTextures(byte[][][] var1, byte[][][] var2, short[] var3) {
      int var20 = 0;
      this.M = new int[var2[9].length][];
      this.N = new int[var2[9].length];
      int var19 = var2.length;

      for(int var4 = 0; var4 < var19; ++var4) {
         if (var4 != 9 && var4 != 32) {
            var2[var4] = (byte[][])null;
         }
      }

      var1[0] = (byte[][])null;
      System.gc();
      var19 = var1[4].length;

      for(int var31 = 0; var31 < var19; ++var31) {
         byte var24 = var2[9][var31][0];
         if (var1[4][var31][2] == 0) {
            var1[4][var31][2] = (byte)(this.k[6 * var24 + 3] + 128);
         }

         if (var1[4][var31][3] == 0) {
            var1[4][var31][3] = (byte)(this.k[6 * var24 + 4] + 128);
         }
      }

      var19 = var2[9].length;
      this.hG = new int[4][];

      for(int var32 = 0; var32 <= 6; ++var32) {
         System.gc();
         Image var39 = this.b("/" + String.valueOf(var32) + this.r);

         for(int var5 = 0; var5 < var19; ++var5) {
            byte var26 = var2[9][var5][0];
            int var21 = this.k[6 * var26] + 128;
            int var22 = var1[4][var5][2] * 2;
            int var23 = var1[4][var5][3] * 2;
            if (var21 == var32) {
               label187: {
                  this.M[var20] = new int[var22 * var23];
                  this.N[var5] = var20;
                  int var27 = (this.k[6 * var26 + 1] + 128 + var1[4][var5][0]) * 2;
                  int var28 = (this.k[6 * var26 + 2] + 128 + var1[4][var5][1]) * 2;
                  var39.getRGB(this.M[var20], 0, var22, var27, var28, var22, var23);
                  Image var10000;
                  int[] var10001;
                  byte var10002;
                  byte var10003;
                  int var10004;
                  int var10005;
                  byte var10006;
                  byte var10007;
                  if (var2[9][var5][0] == 16) {
                     this.hG[0] = new int[784];
                     var10000 = var39;
                     var10001 = this.hG[0];
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (var2[9][var5][0] == 74) {
                     this.hG[1] = new int[784];
                     var10000 = var39;
                     var10001 = this.hG[1];
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (var2[9][var5][0] == 75) {
                     this.hG[2] = new int[784];
                     var10000 = var39;
                     var10001 = this.hG[2];
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (var2[9][var5][0] == 97) {
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
                     if (var2[9][var5][0] != 7) {
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

                  var10000.getRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007);
               }

               this.a(this.M[var20], var1, var5);
               ++var20;
            }
         }
      }

      this.bE = new int[var1[3].length + 1];
      int var17 = 0;
      this.bE[0] = 0;
      this.bD = new int[var1[3].length + 1];
      this.bK = new short[var1[3].length * 9];
      int var10 = var3[6] * 2 * 2;
      int var11 = var3[7] * 2 * 2;
      this.f(var10, var11);
      int var14 = 0;
      this.O = -1;
      byte var7 = -1;
      byte var9 = 0;
      var19 = var1[3].length;

      for(int var33 = 0; var33 < var19; ++var33) {
         byte var8 = var7;
         byte var6 = var2[32][var33][0];
         this.P = var2[9][var6][0];
         var9 = var33 != var19 - 1 ? var2[32][var33 + 1][0] : -1;
         var7 = var2[9][var6][0];
         this.J = var1[4][var6][2] * 2;
         this.K = var1[4][var6][3] * 2;
         this.I = var1[2][var6][5];
         if (this.I >= 1 && this.I <= 5) {
            this.J *= 2;
         }

         if (this.I >= 4 && this.I <= 9) {
            this.K *= 2;
         }

         int var15 = this.J;
         int var16 = this.K;
         this.H = new int[var15 * var16];
         if (var1[3][var33][3] != 1 && var1[3][var33][3] != 2) {
            c3d_b var43;
            int[] var46;
            if (this.k[6 * var7] + 128 > 6) {
               this.a((byte[][][])var1, (byte[][][])var2, var6, 0, var8, var7, var9);
               var43 = this;
               var46 = this.H;
            } else {
               var43 = this;
               var46 = this.M[this.N[var6]];
            }

            var43.a(var46, var15, var1[4][var6][2] * 2, var1[4][var6][3] * 2, var1[2][var6][5], 0, 0);
         }

         int var12 = var1[3][var33][1] * 2;
         int var13 = var1[3][var33][2] == 0 ? this.J : var1[3][var33][2] * 2;
         int var40 = 0;
         var40 = var1[3][var33][0] == var1[3][var33][1] ? var13 : (var1[3][var33][3] != 2 ? this.J : 96);
         byte var25 = var1[3][var33][0];
         if (var1[3][var33][3] == 1) {
            var14 = this.a(var2[32][var33][0], var2[32][var33][1], (byte)var33, (byte)var12, (byte)var13, (short)140, var14, (short)26, (byte)(var12 + 23));
         } else if (var1[3][var33][3] == 2) {
            var14 = this.a(var2[32][var33][0], var2[32][var33][1], (byte)var33, (byte)var12, (byte)var13, (short)((byte)var40), var14, (short)0, (byte)var12);
         } else {
            var14 = this.a((byte)var25, (byte)var33, (byte)var33, (byte)var12, (byte)var13, (short)((byte)var40), var14, (short)0, (byte)var12);

            for(int var34 = 1; var34 <= 3 && var2[32][var33][var34] != var6; ++var34) {
               var6 = var2[32][var33][var34];
               this.J = var1[4][var6][2] * 2;
               this.K = var1[4][var6][3] * 2;
               this.I = var1[2][var6][5];
               if (this.I >= 1 && this.I <= 5) {
                  this.J *= 2;
               }

               if (this.I >= 4 && this.I <= 9) {
                  this.K *= 2;
               }

               c3d_b var44;
               int[] var47;
               if (this.k[6 * var2[9][var6][0]] + 128 > 6) {
                  this.a((byte[][][])var1, (byte[][][])var2, var6, var34, -1, -2, -1);
                  var44 = this;
                  var47 = this.F;
               } else {
                  var44 = this;
                  var47 = this.M[this.N[var6]];
               }

               var44.a(var47, var15, var1[4][var6][2] * 2, var1[4][var6][3] * 2, var1[2][var6][5], var1[2][var6][6] * 2, var1[2][var6][7] * 2);
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
               if (var1[3][var33][3] != 0) {
                  a(this.dr, this.ds, this.bE[var33], var12, var13, 12, 0, var15, this.H, true);
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
                  a(this.dr, this.ds, this.bE[var33], var12, var13, 12, var42, var15, this.H, true);
                  a(this.dt, this.du, this.bE[var33], var12, var13, 12, var42 + 2, var15, this.H, true);
                  a(this.dv, this.dw, this.bE[var33], var12, var13, 12, var42 + 6, var15, this.H, false);
                  a(this.dx, this.dy, this.bE[var33], var12, var13, 12, var42 + 4, var15, this.H, false);
                  if (this.selectedMap != 8 && this.selectedMap != 9 && this.selectedMap != 10 && this.selectedMap != 11 && this.selectedMap != 12 && this.selectedMap != 13) {
                     break label162;
                  }

                  a(this.dz, this.dA, this.bE[var33], var12, var13, 12, 0, var15, this.H, true);
                  a(this.dB, this.dC, this.bE[var33], var12, var13, 12, 2, var15, this.H, true);
                  a(this.dD, this.dE, this.bE[var33], var12, var13, 12, 6, var15, this.H, false);
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

               a(var45, var48, var49, var50, var51, var52, var53, var54, var10008, var10009);
            }

            this.H = null;
            System.gc();
         }
      }

      this.F = null;
      this.G = null;
      this.H = null;
      this.G = null;
      this.M = (int[][])null;
      this.N = null;
      this.B = null;
      this.C = null;
      System.gc();
   }

   private static void a(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, boolean var9) {
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

   private static void a(byte[] var0, byte[] var1, int var2, int var3, int var4, int var5, int[] var6, boolean var7) {
      if (var7) {
         int var11;
         int var13 = (var11 = var5 * var4) * var3;
         int var14 = var3 * var4;
         int var10 = 0;
         int var15 = var11 + var4;

         for(int var8 = 0; var8 < var3; ++var8) {
            int var12 = var13;

            for(int var9 = var11; var9 < var15; ++var9) {
               var0[var2 + var10] = (byte)var6[var12];
               var1[var2 + var10] = (byte)var6[var12 + var14];
               ++var10;
               var12 += var3;
            }

            ++var13;
         }
      } else {
         int var19;
         int var21 = (var19 = (var5 + 2) * var4 - 1) * var3;
         int var22 = var3 * var4;
         int var18 = 0;
         int var23 = var19 - var4;

         for(int var16 = 0; var16 < var3; ++var16) {
            int var20 = var21;

            for(int var17 = var19; var17 > var23; --var17) {
               var0[var2 + var18] = (byte)var6[var20];
               var1[var2 + var18] = (byte)var6[var20 - var22];
               ++var18;
               var20 -= var3;
            }

            ++var21;
         }
      }

   }

   private int a(byte var1, byte var2, byte var3, byte var4, byte var5, short var6, int var7, short var8, byte var9) {
      this.bD[var3] = var7;
      int var10 = this.a((byte)0, var1, (short)var8, var7);
      var10 = this.a(var9, var2, (short)0, var10);
      var10 = this.a((byte)(var9 + var5), var1, (short)((byte)(var4 + var5)), var10);
      this.bD[var3 + 1] = var10;
      this.bL[var3] = var6;
      return var10;
   }

   private int a(byte var1, byte var2, short var3, int var4) {
      this.bK[var4] = (short)var1;
      int var5 = var4 + 1;
      this.bK[var5] = (short)var2;
      ++var5;
      this.bK[var5] = var3;
      ++var5;
      return var5;
   }

   private void a(int[] var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
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
               var1[var8] = this.a(var2, var3, var4, var5, var6, var9, var10, var11, var7);
               var16[var12] = var1[var8];
               ++var12;
            }
         }
      }

   }

   private int a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
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
         var11[var10] = a((int)(var11[var10] + var17), var18);
         var11[var10] = a((int)(var12 + (var11[var10] - var12) * (var4 + var16) / var16), var18);
      }

      return var11[0] << var13 | var11[1] << var14 | var11[2] << var15;
   }

   private static int a(int var0, int var1) {
      if (var0 > var1) {
         return var1;
      } else {
         return var0 < 0 ? 0 : var0;
      }
   }

   private void a(int[] var1, int[] var2, int[][] var3, short var4, byte[] var5, byte[] var6) {
      byte var11 = 0;
      byte var12 = 1;
      int var13 = var1.length;
      byte[] var14 = new byte[256];
      int[] var15 = new int[97];
      short var17 = var4;
      short var18 = 0;

      for(int var7 = 0; var7 < var13; ++var7) {
         int var16;
         if ((var16 = var1[var7]) == this.Q) {
            var1[var7] = -1;
         } else {
            int var10 = var16 & 255;
            if ((var11 = var14[var10]) > 0) {
               var1[var7] = var15[var11];
            } else {
               var14[var10] = var12;
               var15[var12] = var18;
               ++var12;
               int var19 = var5[0] == 0 && var5[1] == 0 && var5[2] == 0 && var5[3] == 0 && var5[4] == 0 ? var16 : this.a(var5[0], var5[1], var5[2], var5[3], var5[4], var10, var10, var10, false);
               int var20 = var6[0] == 0 && var6[1] == 0 && var6[2] == 0 && var6[3] == 0 && var6[4] == 0 ? var16 : this.a(var6[0], var6[1], var6[2], var6[3], var6[4], var10, var10, var10, false);
               var3[0][var17] = (int)((long)var19 | 0L);
               var3[1][var17] = (int)((long)var20 | 0L);
               var1[var7] = var18++;
               ++var17;
            }
         }
      }

      this.E = new byte[32][32][32];
      var15 = new int[97];

      for(int var21 = 0; var21 < var13; ++var21) {
         int var26;
         if ((var26 = var2[var21]) != this.Q) {
            int var8 = (var26 & 16711680) >> 19;
            int var9 = (var26 & '\uff00') >> 11;
            int var22 = (var26 & 255) >> 3;
            if ((var11 = this.E[var8][var9][var22]) > 0) {
               var1[var21] = var15[var11];
            } else {
               this.E[var8][var9][var22] = var12;
               var15[var12] = var18;
               ++var12;
               if (var2[var21] != this.Q) {
                  var3[0][var17] = (int)((long)var26 | 0L);
                  var3[1][var17] = (int)((long)var26 | 0L);
               }

               var1[var21] = var18++;
               ++var17;
            }
         }
      }

   }

   private void a(int[] var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
      if (var5 == 0) {
         if (this.P != 3 && this.P != 4 && this.P != 9 && this.P != 10 && this.P != 13 && this.P != 14 && this.P != 15 && this.P != 16 && this.P != 17 && this.P != 18 && this.P != 22 && this.P != 23 && this.P != 55 && this.P != 77 && this.P != 86 && this.P != 19 && this.P != 29 && this.P != 50 && this.P != 51 && this.P != 52 && this.P != 53 && this.P != 54 && this.P != 24 && this.P != 25 && this.P != 26 && this.P != 29 && this.P != 88 && this.P != 107) {
            this.b(this.H, var1, var6, var7, var2, var3, var4);
         } else {
            this.b(this.H, var1, var6, var7, var2, var3, var4);
            if (this.P == 4) {
               this.a((int[])this.H, (int[])this.H, 0, 0, var2, var2, var2 >> 1);
            } else {
               this.a((int[])this.H, (int[])this.H, 0, 0, var2, var2, var2);
            }
         }
      } else if (var5 != 1) {
         if (var5 == 2) {
            this.e(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 3) {
            this.f(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 4) {
            this.g(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 5) {
            this.a(this.H, var1, var6, var7, var2, var3, var4, var5);
         } else if (var5 == 6) {
            this.h(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 7) {
            this.d(this.H, var1, var6, var7, var2, var3, var4);
            this.h(this.H, this.H, var6, var7, var2, var3, var4);
         } else if (var5 == 10) {
            this.i(this.H, var1, var6, var7, var2, var3, var4);
         } else if (var5 == 11) {
            this.a(this.H, var1, var6, var7, var2, var3, var4, var5);
         } else {
            if (var5 == 12) {
               this.d(this.H, var1, var6, var7, var2, var3, var4);
            }

         }
      } else {
         if (this.P == 55 || this.P == 104) {
            this.a((int[])var1, (int[])var1, 0, 0, var3, var3, var4);
         }

         this.c(this.H, var1, var6, var7, var2, var3, var4);
      }
   }

   private void a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private void b(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private void d(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private void e(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private void f(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private void g(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private void h(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private void i(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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

   private int a(long var1, long var3, long var5, long var7, int var9, int var10, byte var11, byte var12, byte var13, byte var14, byte var15, byte var16) {
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
               this.dP[var17][var18] = (int)(((long)this.u[var19][var17] * var7 * this.u(var9) >> 16) - ((long)this.u[var19][var17 + 1] * var5 * this.t(var9) >> 16) + var1);
               var10000 = this.dP[var17 + 1];
               var10001 = var18;
               var10002 = ((long)this.u[var19][var17] * var7 * this.t(var9) >> 16) + ((long)this.u[var19][var17 + 1] * var5 * this.u(var9) >> 16);
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

   private int a(long var1, long var3, long var5, long var7, int var9, int var10, byte var11, byte var12, byte var13, byte var14, int var15, byte var16, byte var17) {
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
               this.dP[var18][var19] = (int)(((long)this.u[var20][var18] * var7 * this.u(var9) >> 16) - ((long)this.u[var20][var18 + 1] * var5 * this.t(var9) >> 16) + var1);
               var10000 = this.dP[var18 + 1];
               var10001 = var19;
               var10002 = ((long)this.u[var20][var18] * var7 * this.t(var9) >> 16) + ((long)this.u[var20][var18 + 1] * var5 * this.u(var9) >> 16);
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
         c3d_b var10004;
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

         var27[var30] = var33 * (var10003 / var10004.u(var10005));
      }

      label80: {
         long[] var28;
         int var31;
         long var34;
         c3d_b var35;
         int var37;
         label130: {
            byte var38;
            if (this.dN[var15] > 0 && var17 <= 2) {
               this.dS[0][var15] = (this.dQ[var15] * this.u(this.dO[var15] - 10) >> 16) + this.dT[0][var15];
               var28 = this.dS[1];
               var31 = var15;
               var34 = this.dQ[var15];
               var35 = this;
               var37 = this.dO[var15];
               var38 = 10;
            } else {
               if (this.dN[var15] < 0 && var17 <= 2) {
                  this.dS[0][var15] = (-this.dQ[var15] * this.u(this.dO[var15] + 10) >> 16) + this.dT[0][var15];
                  var28 = this.dS[1];
                  var31 = var15;
                  var34 = -this.dQ[var15];
                  var35 = this;
                  var37 = this.dO[var15] + 10;
                  break label130;
               }

               if (this.dN[var15] > 0 && var17 > 2) {
                  this.dS[0][var15] = (-this.dQ[var15] * this.u(this.dO[var15] + 80) >> 16) + this.dT[0][var15];
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

               this.dS[0][var15] = (-this.dQ[var15] * this.u(this.dO[var15] - 80) >> 16) + this.dT[0][var15];
               var28 = this.dS[1];
               var31 = var15;
               var34 = -this.dQ[var15];
               var35 = this;
               var37 = this.dO[var15];
               var38 = 80;
            }

            var37 -= var38;
         }

         var28[var31] = (var34 * var35.t(var37) >> 16) + this.dT[1][var15];
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

   private int a(long var1, long var3, int var5, long var6, int var8, int var9, byte var10, byte var11, int var12) {
      int var15 = 360 / var5;
      int var14 = var12 * 4;

      int var13;
      for(var13 = var8; var13 < var8 + var5; ++var13) {
         this.dP[0][var13] = (int)((var6 * this.t(var14) >> 16) + var1);
         this.dP[1][var13] = (int)((var6 * this.u(var14) >> 16) + var3);
         var14 -= var15;
         this.dP[2][var13] = (int)((var6 * this.t(var14) >> 16) + var1);
         this.dP[3][var13] = (int)((var6 * this.u(var14) >> 16) + var3);
         this.bR[var13] = var10;
         this.dW[var13] = (byte)var9;
         this.bS[var13] = var11;
      }

      return var13;
   }

   private void a(byte var1, byte var2, byte var3, int var4) {
      this.dW[var4] = var1;
      int var5 = var4 + 1;
      this.dW[var5] = var2;
      ++var5;
      this.dW[var5] = var3;
      this.bS[var5] = 3;
   }

   private void a(int var1, long var2, long var4, int var6, int var7) {
      this.hF = new long[2];
      this.hh = var1;
      this.hF[0] = var2;
      this.hF[1] = var4;
      this.gJ = var6;
      this.gK = var7;
   }

   private void initFloorCeilingColor(short[] var1) {
      this.bg = var1[0] << 16 | var1[1] << 8 | var1[2];
      this.bh = var1[3] << 16 | var1[4] << 8 | var1[5];
      this.bg = (int)((long)this.bg | 0L);
      this.bh = (int)((long)this.bh | 0L);
      this.bj = this.bh;
      int var2 = (this.bh & 16711680) >> 16;
      int var3 = (this.bh & '\uff00') >> 8;
      int var4 = this.bh & 255;
      if (this.selectedMap == 12) {
         this.bi = this.a(0, 0, 0, 0, 1, var2, var3, var4, false);
      }

   }

   private void a(a var1) {
      if (this.az <= this.aA) {
         c3d_b var10000;
         a var10001;
         if (a.a(var1)) {
            if (a.b(var1) != null) {
               this.a(a.b(var1));
            }

            if (this.az > this.aA) {
               return;
            }

            if (this.b(a.c(var1))) {
               this.d(a.c(var1));
            }

            if (a.d(var1) == null) {
               return;
            }

            var10000 = this;
            var10001 = a.d(var1);
         } else {
            if (a.d(var1) != null) {
               this.a(a.d(var1));
            }

            if (a.b(var1) == null) {
               return;
            }

            var10000 = this;
            var10001 = a.b(var1);
         }

         var10000.a(var10001);
      }
   }

   private void c() {
      int var1 = this.cQ[this.hh].length;

      for(int var2 = 0; var2 < var1; ++var2) {
         this.az = -1;
         this.aA = 240;

         for(int var3 = this.gW + 4 * this.cQ[this.hh][var2]; var3 < this.gW + 4 * (this.cQ[this.hh][var2] + 1); ++var3) {
            if (this.az <= this.aA && this.b(var3)) {
               this.d(var3);
            }
         }
      }

   }

   private boolean b(int var1) {
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
      return (this.bx[var1] * (long)this.dP[var3][var2] >> 16) + (this.by[var1] * (long)this.dP[var3 + 1][var2] >> 16) + this.bz[var1] <= 0L;
   }

   private void d() {
      this.bx = new long[3];
      this.by = new long[3];
      this.bz = new long[3];
      this.bx[0] = -this.t(this.gJ + 135);
      this.by[0] = this.u(this.gJ + 135);
      this.bx[1] = this.t(this.gJ + 45);
      this.by[1] = -this.u(this.gJ + 45);
      this.bx[2] = -this.t(this.gJ + 180);
      this.by[2] = this.u(this.gJ + 180);

      for(int var1 = 0; var1 < 3; ++var1) {
         this.bz[var1] = -(this.bx[var1] * this.gv >> 16) - (this.by[var1] * this.gw >> 16);
      }

      this.ao = this.bx[2];
      this.ap = this.by[2];
      this.aq = this.bz[2];
   }

   private void c(int var1) {
      long var2 = this.t(this.gJ + 90);
      long var4 = -this.u(this.gJ + 90);
      long var6 = (var2 * this.gv >> 16) + (var4 * this.gw >> 16);
      long var8 = (long)(this.dP[1][var1] - this.dP[3][var1]);
      long var10 = (long)(this.dP[2][var1] - this.dP[0][var1]);
      long var12;
      long var14 = ((var12 = (long)(-this.dL[var1])) * var4 >> 16) - (var10 * var6 >> 16);
      long var16 = (var8 * var6 >> 16) - (var12 * var2 >> 16);
      long var18;
      c3d_b var10000;
      long var10001;
      if ((var18 = (var8 * var4 >> 16) - (var10 * var2 >> 16)) != 0L) {
         this.ca = (var14 << 16) / var18;
         this.cb = (var16 << 16) / var18;
         long var20 = 58982L;
         this.ca = (this.gv * (65536L - var20) >> 16) + (this.ca * var20 >> 16);
         var10000 = this;
         var10001 = (this.gw * (65536L - var20) >> 16) + (this.cb * var20 >> 16);
      } else {
         this.ca = -10000L;
         var10000 = this;
         var10001 = -10000L;
      }

      var10000.cb = var10001;
   }

   private void e() {
      this.S = -this.t(this.gJ);
      this.T = this.u(this.gJ);
      this.U = this.T;
      this.V = -this.S;
   }

   private void d(int var1) {
      this.at = this.bS[var1];
      this.av = var1;
      this.aw = this.dW[var1];
      if (this.at != 1) {
         this.e(var1);
         this.f();
         if (this.h()) {
            if (this.aa >= 0L && this.ab >= 0L || this.av < this.gW) {
               c3d_b var10000;
               byte var10001;
               if (this.aa <= this.ab) {
                  var10000 = this;
                  var10001 = -1;
               } else {
                  var10000 = this;
                  var10001 = 1;
               }

               var10000.aC = var10001;
               this.i();
            }
         }
      }
   }

   private void f() {
      c3d_b var10000;
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

      var10000.aB = var10001;
   }

   private void g() {
      if (this.aB == 1) {
         this.am += (this.an - this.am) * this.ac >> 16;
      } else {
         if (this.aB == 2) {
            this.an -= (this.an - this.am) * this.ac >> 16;
         }

      }
   }

   private void e(int var1) {
      long var2 = ((long)this.dP[0][var1] * 75000L >> 16) - this.hF[0];
      long var4 = ((long)this.dP[1][var1] * 75000L >> 16) - this.hF[1];
      this.W = (var2 * this.U >> 16) + (var4 * this.V >> 16);
      this.aa = (var2 * this.S >> 16) + (var4 * this.T >> 16);
      var2 = ((long)this.dP[2][var1] * 75000L >> 16) - this.hF[0];
      var4 = ((long)this.dP[3][var1] * 75000L >> 16) - this.hF[1];
      this.X = (var2 * this.U >> 16) + (var4 * this.V >> 16);
      this.ab = (var2 * this.S >> 16) + (var4 * this.T >> 16);
   }

   private boolean h() {
      if (this.aa != 0L && this.ab != 0L) {
         this.W = 7864320L * this.W / this.aa + 7831552L;
         this.X = 7864320L * this.X / this.ab + 7831552L;
         this.ax = (int)(this.W >> 16);
         this.ay = (int)(this.X >> 16);
         if (this.ax >= this.ay) {
            return false;
         } else if (this.ax >= this.aA) {
            return false;
         } else if (this.ay <= this.az) {
            return false;
         } else {
            this.Z = 291730882560L / this.ab + 6914048L;
            this.Y = 291730882560L / this.aa + 6914048L;
            return true;
         }
      } else {
         return false;
      }
   }

   private void f(int var1) {
      byte var5 = this.eA[var1];
      this.au = this.bL[this.aw];
      c3d_b var10000;
      int[] var10001;
      if (this.at != 2 && this.at != 5 && this.at != 7) {
         this.dH = this.dy;
         this.dI = this.dx;
         this.dJ = this.dw;
         var10000 = this;
         var10001 = this.dv;
      } else {
         this.dH = this.du;
         this.dI = this.dt;
         this.dJ = this.ds;
         var10000 = this;
         var10001 = this.dr;
      }

      var10000.dK = var10001;
      int var20;
      if (var5 != -90 && var5 != 0) {
         var10000 = this;
         var20 = (int)(a(((long)(this.dP[1][var1] - this.dP[3][var1]) << 16) / this.u(var5)) * 75000L >> 16 >> 16);
      } else {
         int[][] var10002;
         byte var10003;
         if (var5 == -90) {
            var10000 = this;
            var20 = this.dP[2][var1];
            var10002 = this.dP;
            var10003 = 0;
         } else {
            var10000 = this;
            var20 = this.dP[1][var1];
            var10002 = this.dP;
            var10003 = 3;
         }

         var20 = v(var20 - var10002[var10003][var1]) >> 16;
      }

      var10000.bf = var20;
      if (this.au == 48) {
         this.bf *= 2;
      }

      if (this.bf == 0) {
         this.bf = 1;
      }

      if (this.au == 24) {
         this.bf *= 4;
      }

      this.am = 0L;
      this.an = (long)(this.au * this.bf - 1 << 16);
      if (var1 >= this.gT && var1 < this.gU) {
         label147: {
            int var12 = (var1 - this.gT) / 3;
            int var15 = (var1 - this.gT) % 3;
            if (this.at != 3 && this.at != 7) {
               if (var15 == 0) {
                  this.am = (long)this.eL[var12];
                  break label147;
               }

               if (var15 != 2) {
                  break label147;
               }
            } else if (var15 != 0) {
               if (var15 == 2) {
                  this.am = (long)this.eL[var12];
               }
               break label147;
            }

            this.an = (long)this.eM[var12];
         }
      } else if (var1 >= this.gV && var1 < this.gW) {
         int var7 = this.bB.length;
         int var8 = 0;

         for(int var2 = 1; var2 < var7; ++var2) {
            if (var1 < this.bB[var2]) {
               var8 = var2 - 1;
               break;
            }
         }

         int var9 = var1 - this.bB[var8];
         int var10 = this.au / this.bA[var8];
         this.am = (long)(var9 * var10 << 16);
         this.an = (long)(var9 * var10 + var10 - 1 << 16);
      }

      if (this.at == 3 || this.at == 7) {
         long var13 = this.an;
         this.an = this.am;
         this.am = var13;
      }

      this.g();
      this.ad = (this.an << 16) / this.ab - (this.am << 16) / this.aa;
      this.ae = this.X - this.W;
      this.af = 4294967296L / this.ab - 4294967296L / this.aa;
      long var21;
      long var23;
      if (this.aC == 1) {
         this.aj = this.Y;
         this.ag = (this.af << 16) / this.ae;
         this.ah = (this.ad << 16) / this.ae;
         this.al = (this.am << 16) / this.aa;
         var10000 = this;
         var21 = 4294967296L;
         var23 = this.aa;
      } else {
         this.aj = this.Z;
         this.ag = -(this.af << 16) / this.ae;
         this.ah = -(this.ad << 16) / this.ae;
         this.al = (this.an << 16) / this.ab;
         var10000 = this;
         var21 = 4294967296L;
         var23 = this.ab;
      }

      var10000.ai = var21 / var23;
      int var6 = this.aw < 32 ? 1 : 7;

      for(int var14 = 0; var14 < var6; ++var14) {
         int[] var18;
         int var22;
         if (var6 == 1) {
            var18 = this.bD;
            var22 = this.aw;
         } else {
            var18 = this.bD;
            var22 = this.bT[(this.aw - 32) * var6 + var14];
         }

         int var3 = var18[var22];

         for(int var11 = 0; var11 < 3; ++var11) {
            for(int var4 = 0; var4 < 3; ++var4) {
               this.bU[var14][var11][var4] = this.bK[var3];
               ++var3;
            }
         }
      }

   }

   private void i() {
      boolean var55 = false;
      int var56 = this.bg;
      int var57 = this.bh;
      byte var53 = this.bR[this.av];
      boolean var54 = false;
      int var37 = 0;
      int var26 = (int)(this.Y >> 16);
      int var27 = (int)(this.Z >> 16);
      int var30 = 211 - var26;
      int var31 = 211 - var27;
      int var28 = var30 - (var26 - var30);
      int var29 = var31 - (var27 - var31);
      c3d_b var10000;
      int var10001;
      if (this.aC == 1) {
         var10000 = this;
         var10001 = var28;
      } else {
         var10000 = this;
         var10001 = var29;
      }

      var10000.ak = (long)(var10001 << 16);
      long var1 = (long)(this.ay - this.ax);
      long var3 = (long)(var27 - var26 << 16);
      long var7 = (long)(var29 - var28 << 16);
      long var5;
      long var61;
      if (this.aC == 1) {
         var5 = var3 / var1;
         var61 = var7;
      } else {
         var5 = -var3 / var1;
         var61 = -var7;
      }

      long var9;
      label688: {
         label687: {
            var9 = var61 / var1;
            if (this.aC == 1) {
               if (this.ay >= this.aA) {
                  this.ay = this.aA - 1;
               }

               if (var53 != 0) {
                  break label688;
               }

               if (this.ax <= this.az + 1) {
                  this.az = this.ay;
               }

               if (this.ay < this.aA - 1) {
                  break label688;
               }

               if (this.ax >= 0) {
                  var62 = this;
                  var10001 = this.ax;
                  break label687;
               }

               var62 = this;
            } else {
               if (this.ax <= this.az) {
                  this.ax = this.az + 1;
               }

               if (var53 != 0) {
                  break label688;
               }

               if (this.ax <= this.az + 1) {
                  c3d_b var63;
                  if (this.ay <= 239) {
                     var63 = this;
                     var10001 = this.ay;
                  } else {
                     var63 = this;
                     var10001 = 239;
                  }

                  var63.az = var10001;
               }

               if (this.ay < this.aA - 1) {
                  break label688;
               }

               if (this.ax >= 0) {
                  var62 = this;
                  var10001 = this.ax;
                  break label687;
               }

               var62 = this;
            }

            var10001 = 0;
         }

         var62.aA = var10001;
      }

      int var36 = this.aw < 32 ? 1 : 7;
      byte var38;
      int var64;
      if (this.aC == 1) {
         var38 = 1;
         this.cj = this.ax;
         var64 = this.ay;
      } else {
         var38 = -1;
         this.cj = this.ay;
         var64 = this.ax;
      }

      int var52 = var64 + var38;

      while(this.cj != var52) {
         if (this.cj >= 0 && this.cj <= 239) {
            if (this.av < this.gW) {
               if (var53 == 0) {
                  if (this.bV[this.cj]) {
                     this.cj += var38;
                     ++var37;
                     continue;
                  }

                  if (!var54) {
                     this.f(this.av);
                     var54 = true;
                  }

                  this.bV[this.cj] = true;
                  if (var37 != 0) {
                     this.aj += (long)var37 * var5;
                     this.ak += (long)var37 * var9;
                     this.al += (long)var37 * this.ah;
                     this.ai += (long)var37 * this.ag;
                     var37 = 0;
                  }

                  if (this.bQ[this.cj] == 0) {
                     this.bH[0][this.cj] = (int)this.ai;
                  } else {
                     this.bH[1][this.cj] = (int)this.ai;
                  }
               } else {
                  if (this.bV[this.cj] || this.bQ[this.cj] == var53) {
                     this.cj += var38;
                     ++var37;
                     continue;
                  }

                  if (!var54) {
                     this.f(this.av);
                     var54 = true;
                  }

                  if (this.bQ[this.cj] * var53 == 2) {
                     this.bV[this.cj] = true;
                  }

                  if (var37 != 0) {
                     this.aj += (long)var37 * var5;
                     this.ak += (long)var37 * var9;
                     this.al += (long)var37 * this.ah;
                     this.ai += (long)var37 * this.ag;
                     var37 = 0;
                  }

                  if (this.bQ[this.cj] == 0) {
                     int[] var65;
                     int var10002;
                     if (var53 == 1) {
                        var65 = this.bH[0];
                        var10001 = this.cj;
                        var10002 = (int)this.ai;
                     } else {
                        var65 = this.bH[0];
                        var10001 = this.cj;
                        var10002 = -((int)this.ai);
                     }

                     var65[var10001] = var10002;
                     this.bQ[this.cj] = var53;
                  } else {
                     this.bH[1][this.cj] = (int)this.ai;
                  }
               }
            } else {
               if (!var54) {
                  this.f(this.av);
                  var54 = true;
               }

               if (var37 != 0) {
                  this.aj += (long)var37 * var5;
                  this.ak += (long)var37 * var9;
                  this.al += (long)var37 * this.ah;
                  this.ai += (long)var37 * this.ag;
                  var37 = 0;
               }

               if (((int)this.ai < this.bH[0][this.cj] || this.bQ[this.cj] != 0) && ((int)this.ai < this.bH[1][this.cj] || this.bQ[this.cj] == 0)) {
                  this.cj += var38;
                  ++var37;
                  continue;
               }

               if (this.bQ[this.cj] == 0) {
                  this.bH[0][this.cj] = (int)this.ai;
               } else if ((int)this.ai >= this.bH[0][this.cj]) {
                  this.bH[0][this.cj] = (int)this.ai;
                  this.bH[1][this.cj] = 0;
                  this.bQ[this.cj] = 0;
               } else if ((int)this.ai > this.bH[1][this.cj]) {
                  this.bH[1][this.cj] = (int)this.ai;
               }
            }

            int var17;
            int var15 = (var17 = (int)((this.al << 16) / this.ai >> 16)) % this.au;
            int var16 = var36 == 7 ? var17 / this.au % var36 : 0;
            if (var15 < 0 || var16 < 0) {
               var15 = 0;
               var16 = 0;
            }

            if (this.at != 0) {
               label736: {
                  if (this.at != 5 && this.at != 10) {
                     if (this.at == 15) {
                        var64 = this.au - 1 - var15;
                     } else {
                        if (this.at == 20) {
                           if (var16 != 0) {
                              break label736;
                           }
                        } else if (this.at != 25 || var16 != this.bf - 1) {
                           break label736;
                        }

                        var64 = var15 % 24;
                     }
                  } else {
                     if (var17 / this.au != 1) {
                        break label736;
                     }

                     var64 = this.au - 1 - var15;
                  }

                  var15 = var64;
               }
            }

            int var24 = this.au != 140 ? this.au : 96;
            this.aF = 0;

            for(int var11 = 2; var11 >= 0; --var11) {
               if (var15 >= this.bU[var16][var11][0]) {
                  this.aF = this.bE[this.bU[var16][var11][1]] + (var15 - this.bU[var16][var11][0] + this.bU[var16][var11][2]) % var24 * 12;
                  break;
               }
            }

            this.aD = this.aF << 16;
            this.aE = this.aD;
            this.aG = this.aF + 11;
            int var34 = (int)(this.aj >> 16);
            int var33 = 211 - var34;
            int var35 = (int)(this.ak >> 16);
            int var40 = 105 - var33;
            int var42 = var33 - var35;
            if (var40 == 0) {
               this.al += this.ah;
               this.ai += this.ag;
               this.cj += var38;
            } else {
               if (this.ar == -1) {
                  this.c(this.av);
                  this.fo = (int)(a(this.ca - this.gv) >> 16);
                  this.fp = (int)(a(this.cb - this.gw) >> 16);
                  if (this.fo <= this.fP && this.fp <= this.fP) {
                     var55 = true;
                  }
               }

               int var20;
               int var22;
               int var23;
               int var45;
               label601: {
                  int var95;
                  label600: {
                     int var41;
                     int var18 = (var41 = var40 + 1) >> 2;
                     int var19 = var41 - (var18 << 2);
                     int var43;
                     int var44 = (var43 = var42 + 1) >> 3;
                     var45 = var43 - (var44 << 3);
                     this.aH = 3014656 / var40;
                     this.aI = 3014656 / var42;
                     this.aJ = this.cj + var33 * 240;
                     this.aR = this.aJ;
                     this.aQ = this.cj + var34 * 240;
                     this.aZ = this.cj + '에';
                     this.aY = this.cj + var35 * 240;
                     int var21 = (var20 = var18 * 240) + 240;
                     var23 = (var22 = var44 * 240) + 240;
                     c3d_b var67;
                     if (var19 == 0) {
                        this.aK = this.aJ + var20;
                        this.aL = this.aK + var20;
                        this.aM = this.aL + var20;
                        this.aP = this.aQ - var20;
                        var67 = this;
                        var10001 = this.aP;
                        var95 = var20;
                     } else {
                        if (var19 == 1) {
                           this.aK = this.aJ + var20;
                           this.aL = this.aK + var20;
                           this.aM = this.aL + var21;
                           this.aP = this.aQ - var20;
                           this.aO = this.aP - var20;
                           var69 = this;
                           var10001 = this.aO;
                           var95 = var21;
                           break label600;
                        }

                        if (var19 == 2) {
                           this.aK = this.aJ + var20;
                           this.aL = this.aK + var21;
                           this.aM = this.aL + var20;
                           var67 = this;
                           var10001 = this.aQ;
                           var95 = var20;
                        } else {
                           if (var19 != 3) {
                              break label601;
                           }

                           this.aK = this.aJ + var21;
                           this.aL = this.aK + var21;
                           this.aM = this.aL + var20;
                           var67 = this;
                           var10001 = this.aQ;
                           var95 = var21;
                        }

                        var67.aP = var10001 - var95;
                        var67 = this;
                        var10001 = this.aP;
                        var95 = var21;
                     }

                     var67.aO = var10001 - var95;
                     var69 = this;
                     var10001 = this.aO;
                     var95 = var20;
                  }

                  var69.aN = var10001 - var95;
               }

               label589: {
                  c3d_b var70;
                  int var96;
                  if (var45 == 0) {
                     this.aX = this.aY + var22;
                     this.aW = this.aX + var22;
                     this.aV = this.aW + var22;
                     this.aS = this.aR - var22;
                     this.aT = this.aS - var22;
                     var70 = this;
                     var10001 = this.aT;
                     var96 = var22;
                  } else if (var45 == 1) {
                     this.aX = this.aY + var22;
                     this.aW = this.aX + var22;
                     this.aV = this.aW + var23;
                     this.aS = this.aR - var22;
                     this.aT = this.aS - var22;
                     var70 = this;
                     var10001 = this.aT;
                     var96 = var22;
                  } else {
                     label586: {
                        if (var45 == 2) {
                           this.aX = this.aY + var22;
                           this.aW = this.aX + var22;
                           this.aV = this.aW + var23;
                           this.aS = this.aR - var22;
                           var70 = this;
                           var10001 = this.aS;
                           var96 = var22;
                        } else {
                           if (var45 == 3) {
                              this.aX = this.aY + var22;
                              this.aW = this.aX + var22;
                              this.aV = this.aW + var23;
                              var70 = this;
                              var10001 = this.aR;
                              var96 = var22;
                           } else if (var45 == 4) {
                              this.aX = this.aY + var22;
                              this.aW = this.aX + var23;
                              this.aV = this.aW + var23;
                              var70 = this;
                              var10001 = this.aR;
                              var96 = var22;
                           } else if (var45 == 5) {
                              this.aX = this.aY + var23;
                              this.aW = this.aX + var23;
                              this.aV = this.aW + var22;
                              var70 = this;
                              var10001 = this.aR;
                              var96 = var22;
                           } else {
                              if (var45 == 6) {
                                 this.aX = this.aY + var23;
                                 this.aW = this.aX + var23;
                                 this.aV = this.aW + var22;
                                 this.aS = this.aR - var23;
                                 this.aT = this.aS - var23;
                                 var70 = this;
                                 var10001 = this.aT;
                                 var96 = var22;
                                 break label586;
                              }

                              if (var45 != 7) {
                                 break label589;
                              }

                              this.aX = this.aY + var23;
                              this.aW = this.aX + var23;
                              this.aV = this.aW + var23;
                              var70 = this;
                              var10001 = this.aR;
                              var96 = var23;
                           }

                           var70.aS = var10001 - var96;
                           var70 = this;
                           var10001 = this.aS;
                           var96 = var23;
                        }

                        var70.aT = var10001 - var96;
                        var70 = this;
                        var10001 = this.aT;
                        var96 = var23;
                     }
                  }

                  var70.aU = var10001 - var96;
               }

               if (var34 > 0 && this.av < this.gW) {
                  label744: {
                     int var46 = this.cj;
                     int var50 = this.cj;
                     c3d_b var73;
                     if (this.iK == 0) {
                        var73 = this;
                        var10001 = 180;
                     } else if (this.il && this.iK == this.iM) {
                        var73 = this;
                        var10001 = 360;
                     } else {
                        var73 = this;
                        var10001 = 0;
                     }

                     label563: {
                        label745: {
                           var73.if_ = var10001;
                           if (this.fF + var50 >= 180 && this.fF + var50 < 360) {
                              var50 -= 180;
                              if (this.iK == 3) {
                                 var73 = this;
                                 var10001 = 180;
                                 break label745;
                              }

                              if (this.il && (this.iK + 1) % 4 == this.iM) {
                                 var73 = this;
                                 var10001 = 360;
                                 break label745;
                              }

                              var73 = this;
                           } else {
                              if (this.fF + var50 < 360) {
                                 break label563;
                              }

                              var50 -= 360;
                              if (this.iK == 2) {
                                 var73 = this;
                                 var10001 = 180;
                                 break label745;
                              }

                              if (this.il && (this.iK + 2) % 4 == this.iM) {
                                 var73 = this;
                                 var10001 = 360;
                                 break label745;
                              }

                              var73 = this;
                           }

                           var10001 = 0;
                        }

                        var73.if_ = var10001;
                     }

                     int var47;
                     int var75;
                     if (this.selectedMap == 12 && this.bR[this.av] != 0) {
                        var47 = var46 + 25440;
                        var75 = var50 + '\udf98';
                     } else {
                        var47 = this.aJ - 240;
                        var75 = var50 + (this.aJ - this.cj) / 240 * 540 - 540;
                     }

                     int var51 = var75;
                     int var48 = this.aQ + 240;
                     int var49 = this.aZ;
                     int[] var76;
                     int var99;
                     if (this.selectedMap != 12) {
                        if (this.bR[this.av] == 0) {
                           if (this.bQ[this.cj] != 0) {
                              if (this.bQ[this.cj] == 1) {
                                 while(var46 < var47) {
                                    this.bG[var46] = var56;
                                    this.bG[var47] = var56;
                                    var46 += 240;
                                    var47 -= 240;
                                 }

                                 if (var46 != var47) {
                                    break label744;
                                 }

                                 var76 = this.bG;
                                 var10001 = var46;
                                 var99 = var56;
                              } else {
                                 while(var48 < var49) {
                                    this.bG[var48] = var57;
                                    this.bG[var49] = var57;
                                    var48 += 240;
                                    var49 -= 240;
                                 }

                                 if (var48 != var49) {
                                    break label744;
                                 }

                                 var76 = this.bG;
                                 var10001 = var48;
                                 var99 = var57;
                              }
                           } else {
                              while(var46 < var47) {
                                 this.bG[var46] = var56;
                                 this.bG[var47] = var56;
                                 this.bG[var48] = var57;
                                 this.bG[var49] = var57;
                                 var46 += 240;
                                 var47 -= 240;
                                 var48 += 240;
                                 var49 -= 240;
                              }

                              if (var46 != var47) {
                                 break label744;
                              }

                              this.bG[var46] = var56;
                              var76 = this.bG;
                              var10001 = var48;
                              var99 = var57;
                           }
                        } else if (this.bR[this.av] == 1) {
                           while(var48 < var49) {
                              this.bG[var48] = var57;
                              this.bG[var49] = var57;
                              var48 += 240;
                              var49 -= 240;
                           }

                           if (var48 != var49) {
                              break label744;
                           }

                           var76 = this.bG;
                           var10001 = var48;
                           var99 = var57;
                        } else {
                           while(var46 < var47) {
                              this.bG[var46] = var56;
                              this.bG[var47] = var56;
                              var46 += 240;
                              var47 -= 240;
                           }

                           if (var46 != var47) {
                              break label744;
                           }

                           var76 = this.bG;
                           var10001 = var46;
                           var99 = var56;
                        }
                     } else {
                        label536: {
                           if (this.bR[this.av] == 0) {
                              if (this.bQ[this.cj] == 0) {
                                 while(var46 < var47 + 240) {
                                    this.bG[var46] = this.gf[this.fF + var50 + this.if_];
                                    this.bG[var47] = this.gf[this.fF + var51 + this.if_];
                                    this.bG[var48] = var57;
                                    this.bG[var49] = var57;
                                    var50 += 540;
                                    var51 -= 540;
                                    var46 += 240;
                                    var47 -= 240;
                                    var48 += 240;
                                    var49 -= 240;
                                 }

                                 if (var46 != var47) {
                                    break label744;
                                 }

                                 this.bG[var46] = this.gf[this.fF + var50 + this.if_];
                                 var76 = this.bG;
                                 var10001 = var48;
                                 var99 = var57;
                                 break label536;
                              }

                              if (this.bQ[this.cj] != 1) {
                                 while(var48 < var49) {
                                    this.bG[var48] = var57;
                                    this.bG[var49] = var57;
                                    var48 += 240;
                                    var49 -= 240;
                                 }

                                 if (var48 != var49) {
                                    break label744;
                                 }

                                 var76 = this.bG;
                                 var10001 = var48;
                                 var99 = var57;
                                 break label536;
                              }

                              while(var46 < var47 + 240) {
                                 this.bG[var46] = this.gf[this.fF + var50 + this.if_];
                                 this.bG[var47] = this.gf[this.fF + var51 + this.if_];
                                 var50 += 540;
                                 var51 -= 540;
                                 var46 += 240;
                                 var47 -= 240;
                              }

                              if (var46 != var47) {
                                 break label744;
                              }
                           } else {
                              if (this.bR[this.av] == 1) {
                                 while(var46 < var47 + 240) {
                                    this.bG[var46] = this.gf[this.fF + var50 + this.if_];
                                    this.bG[var47] = this.gf[this.fF + var51 + this.if_];
                                    var50 += 540;
                                    var51 -= 540;
                                    var46 += 240;
                                    var47 -= 240;
                                 }

                                 if (var46 == var47) {
                                    this.bG[var46] = this.gf[this.fF + var46 + this.if_];
                                 }

                                 while(var48 < var49) {
                                    this.bG[var48] = var57;
                                    this.bG[var49] = var57;
                                    var48 += 240;
                                    var49 -= 240;
                                 }

                                 if (var48 != var49) {
                                    break label744;
                                 }

                                 var76 = this.bG;
                                 var10001 = var48;
                                 var99 = var57;
                                 break label536;
                              }

                              while(var46 < var47 + 240) {
                                 this.bG[var46] = this.gf[this.fF + var50 + this.if_];
                                 this.bG[var47] = this.gf[this.fF + var51 + this.if_];
                                 var50 += 540;
                                 var51 -= 540;
                                 var46 += 240;
                                 var47 -= 240;
                              }

                              if (var46 != var47) {
                                 break label744;
                              }
                           }

                           var76 = this.bG;
                           var10001 = var46;
                           var99 = this.gf[this.fF + var50 + this.if_];
                        }
                     }

                     var76[var10001] = var99;
                  }
               }

               this.bm = true;
               this.bn = true;
               this.bo = true;
               this.bp = true;
               this.bq = true;
               this.br = true;
               this.bs = true;
               this.bt = true;
               this.bu = true;
               if (this.aK - this.aJ != var20) {
                  this.bm = false;
               }

               if (this.aL - this.aK != var20) {
                  this.bn = false;
               }

               if (this.aM - this.aL != var20) {
                  this.bo = false;
               }

               if (this.aX - this.aY != var22) {
                  this.bu = false;
               }

               if (this.aW - this.aX != var22) {
                  this.bt = false;
               }

               if (this.aV - this.aW != var22) {
                  this.bs = false;
               }

               if (this.aR - this.aS != var22) {
                  this.bp = false;
               }

               if (this.aS - this.aT != var22) {
                  this.bq = false;
               }

               if (this.aT - this.aU != var22) {
                  this.br = false;
               }

               this.aj += var5;
               this.ak += var9;
               if (var53 == 1) {
                  ++this.aG;
                  int var25 = this.aF;
                  this.aF = this.aG;
                  this.aG = var25;
                  this.aD = (this.aF << 16) - 1;
                  this.aH = -this.aH;
                  this.aI = -this.aI;
               }

               label426: {
                  this.bv = true;
                  this.bw = true;
                  c3d_b var77;
                  if (this.aJ >= this.cj) {
                     this.c(this.aJ + var20, var22);
                     this.bv = true;
                     var77 = this;
                     var10001 = 1;
                  } else if (this.aJ < this.cj && this.aK >= this.cj) {
                     this.j(this.aK + this.cj - this.aJ);
                     int var60 = this.aJ + var20;
                     this.aJ = this.cj;
                     this.aQ = this.cj + '에';
                     this.c(var60, this.aY + var22);
                     this.bv = true;
                     var77 = this;
                     var10001 = 1;
                  } else if (this.aK < this.cj && this.aL >= this.cj) {
                     this.l(this.aL + this.cj - this.aK);
                     int var59 = this.aK + var20;
                     this.aK = this.cj;
                     this.aP = this.cj + '에';
                     this.j(var59);
                     this.bv = false;
                     var77 = this;
                     var10001 = 1;
                  } else {
                     if (this.aL >= this.cj || this.aM < this.cj) {
                        break label426;
                     }

                     label414: {
                        if (var53 == 0) {
                           if (this.bQ[this.cj] == 0) {
                              this.m(this.aM + this.cj - this.aL);
                              break label414;
                           }

                           if (this.bQ[this.cj] != 1) {
                              this.b(this.aM + this.cj - this.aL, this.dy);
                              break label414;
                           }
                        } else if (var53 == 1) {
                           this.b(this.aM + this.cj - this.aL, this.dr);
                           break label414;
                        }

                        this.a(this.aM + this.cj - this.aL, this.du);
                     }

                     int var58 = this.aL + var20;
                     this.aL = this.cj;
                     this.aO = this.cj + '에';
                     this.l(var58);
                     this.bv = false;
                     var77 = this;
                     var10001 = 0;
                  }

                  var77.bw = (boolean)var10001;
               }

               if (this.aM >= this.cj) {
                  label746: {
                     c3d_b var78;
                     int[] var92;
                     int[] var100;
                     int[] var10003;
                     int[] var10004;
                     if (var53 == 0 && this.bQ[this.cj] == 0) {
                        this.a(this.dr, this.ds, this.dt, this.du);
                        if (this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12 || this.selectedMap == 13) {
                           this.a(this.dz, this.dA, this.dB, this.dG, this.dF, this.dE, this.dD);
                        }

                        var78 = this;
                        var92 = this.dK;
                        var100 = this.dJ;
                        var10003 = this.dI;
                        var10004 = this.dH;
                     } else {
                        if (var53 == 0 && this.bQ[this.cj] == 1 || var53 == 2) {
                           this.a(this.dr, this.ds, this.dt, this.du);
                           if (this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12 || this.selectedMap == 13) {
                              this.a(this.dz, this.dA, this.dB, this.dG, this.dF, this.dE, this.dD);
                           }
                           break label746;
                        }

                        if (var53 == 0 && this.bQ[this.cj] == 2) {
                           var78 = this;
                           var92 = this.dK;
                           var100 = this.dJ;
                           var10003 = this.dI;
                           var10004 = this.dH;
                        } else {
                           var78 = this;
                           var92 = this.du;
                           var100 = this.dt;
                           var10003 = this.ds;
                           var10004 = this.dr;
                        }
                     }

                     var78.b(var92, var100, var10003, var10004);
                  }
               }

               this.al += this.ah;
               this.ai += this.ag;
               this.cj += var38;
               int var14;
               if (var55 && this.cj >= 113 && this.cj <= 127 && ((var14 = this.fo + this.fp) <= this.cm || this.ar == -1)) {
                  this.ar = this.av;
                  this.cm = var14;
                  this.bW = this.ca;
                  this.bX = this.cb;
               }
            }
         } else {
            this.cj += var38;
            ++var37;
         }
      }

   }

   private void a(int[] var1, int[] var2, int[] var3, int[] var4, int[] var5, int[] var6, int[] var7) {
      if (!this.bp && this.aR >= 0 && this.aR <= this.bG.length) {
         this.bG[this.aR] = var7[this.aG];
      }

      if (!this.bq && this.aS >= 0 && this.aS <= this.bG.length) {
         this.bG[this.aS] = var6[this.aG];
      }

      if (!this.br && this.aT >= 0 && this.aT <= this.bG.length) {
         this.bG[this.aT] = var5[this.aG];
      }

      if (!this.bs && this.aW >= 0 && this.aW <= this.bG.length) {
         this.bG[this.aW] = var3[this.aG];
      }

      if (!this.bt && (this.aX >= 0 && this.aX < this.bG.length && this.selectedMap != 12 || this.aX >= 0 && this.aX < this.bG.length && this.selectedMap == 12 && var2[this.aG] != 0)) {
         this.bG[this.aX] = var2[this.aG];
      }

      if (!this.bu && (this.aY >= 0 && this.aY < this.bG.length && this.selectedMap != 12 || this.aY >= 0 && this.aY < this.bG.length && this.selectedMap == 12 && var1[this.aG] != 0)) {
         this.bG[this.aY] = var1[this.aG];
      }

      for(int var8 = this.aV; var8 <= this.aU; var8 += 240) {
         if (var8 >= 0) {
            this.bG[var8] = var4[this.aG];
         }
      }

   }

   private void a(int[] var1, int[] var2, int[] var3, int[] var4) {
      if (this.bv && !this.bm) {
         this.bG[this.aJ] = var1[this.aG];
      }

      if (this.bw && !this.bn) {
         this.bG[this.aK] = var2[this.aG];
      }

      if (!this.bo) {
         this.bG[this.aL] = var3[this.aG];
      }

      int[] var10000;
      int var10001;
      if (this.aM == this.cj + 25200) {
         var10000 = this.bG;
         var10001 = this.aM;
      } else {
         var10000 = this.bG;
         var10001 = this.aM - 240;
      }

      var10000[var10001] = var4[this.aG];
   }

   private void b(int[] var1, int[] var2, int[] var3, int[] var4) {
      if (this.bv && !this.bm) {
         this.bG[this.aQ] = var1[this.aG];
      }

      if (this.bw && !this.bn) {
         this.bG[this.aP] = var2[this.aG];
      }

      if (!this.bo) {
         this.bG[this.aO] = var3[this.aG];
      }

      int[] var10000;
      int var10001;
      if (this.aN == this.cj + 25440) {
         var10000 = this.bG;
         var10001 = this.aN;
      } else {
         var10000 = this.bG;
         var10001 = this.aN + 240;
      }

      var10000[var10001] = var4[this.aG];
   }

   private void g(int var1) {
      int var2;
      for(var2 = this.aF; this.aJ < var1; this.aD += this.aH) {
         var2 = this.aD >> 16;
         this.bG[this.aJ] = this.dr[var2];
         this.bG[this.aK] = this.ds[var2];
         this.bG[this.aL] = this.dt[var2];
         this.bG[this.aM] = this.du[var2];
         this.bG[this.aN] = this.dH[var2];
         this.bG[this.aO] = this.dI[var2];
         this.bG[this.aP] = this.dJ[var2];
         this.bG[this.aQ] = this.dK[var2];
         this.aJ += 240;
         this.aK += 240;
         this.aL += 240;
         this.aM += 240;
         this.aN -= 240;
         this.aO -= 240;
         this.aP -= 240;
         this.aQ -= 240;
      }

      this.aF = var2;
   }

   private void b(int var1, int var2) {
      int var3 = 0;
      if (var2 == -1) {
         while(this.aY < var1) {
            var3 = this.aE >> 16;
            if (this.aR >= 0 && this.aR < this.bG.length) {
               this.bG[this.aR] = this.dD[var3];
            }

            if (this.aS >= 0 && this.aS < this.bG.length) {
               this.bG[this.aS] = this.dE[var3];
            }

            if (this.aT >= 0 && this.aT < this.bG.length) {
               this.bG[this.aT] = this.dF[var3];
            }

            if (this.aU >= 0 && this.aU < this.bG.length) {
               this.bG[this.aU] = this.dG[var3];
            }

            if (this.aV >= 0 && this.aV < this.bG.length) {
               this.bG[this.aV] = this.dC[var3];
            }

            if (this.aW >= 0 && this.aW < this.bG.length) {
               this.bG[this.aW] = this.dB[var3];
            }

            if (this.aX >= 0 && this.aX < this.bG.length && this.selectedMap != 12 || this.aX >= 0 && this.aX < this.bG.length && this.selectedMap == 12 && this.dA[var3] != 0) {
               this.bG[this.aX] = this.dA[var3];
            }

            if (this.aY >= 0 && this.aY < this.bG.length && this.selectedMap != 12 || this.aY >= 0 && this.aY < this.bG.length && this.selectedMap == 12 && this.dz[var3] != 0) {
               this.bG[this.aY] = this.dz[var3];
            }

            this.aR -= 240;
            this.aS -= 240;
            this.aT -= 240;
            this.aU -= 240;
            this.aV += 240;
            this.aW += 240;
            this.aX += 240;
            this.aY += 240;
            this.aE += this.aH;
         }
      }

      if (var2 != 0) {
         if (var2 == 1) {
            while(this.aX < var1) {
               var3 = this.aE >> 16;
               this.bG[this.aR] = this.dD[var3];
               this.bG[this.aS] = this.dE[var3];
               this.bG[this.aT] = this.dF[var3];
               this.bG[this.aU] = this.dG[var3];
               this.bG[this.aV] = this.dC[var3];
               this.bG[this.aW] = this.dB[var3];
               if (this.selectedMap != 12 || this.dA[var3] != 0) {
                  this.bG[this.aX] = this.dA[var3];
               }

               this.aR -= 240;
               this.aS -= 240;
               this.aT -= 240;
               this.aU -= 240;
               this.aV += 240;
               this.aW += 240;
               this.aX += 240;
               this.aE += this.aH;
            }
         } else if (var2 == 2) {
            while(this.aW < var1) {
               var3 = this.aE >> 16;
               this.bG[this.aR] = this.dD[var3];
               this.bG[this.aS] = this.dE[var3];
               this.bG[this.aT] = this.dF[var3];
               this.bG[this.aU] = this.dG[var3];
               this.bG[this.aV] = this.dC[var3];
               this.bG[this.aW] = this.dB[var3];
               this.aR -= 240;
               this.aS -= 240;
               this.aT -= 240;
               this.aU -= 240;
               this.aV += 240;
               this.aW += 240;
               this.aE += this.aH;
            }
         } else if (var2 == 3) {
            while(this.aV < var1) {
               var3 = this.aE >> 16;
               if (this.aR >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aR] = this.dD[var3];
               }

               if (this.aS >= 0 && this.aS < this.bG.length) {
                  this.bG[this.aS] = this.dE[var3];
               }

               if (this.aT >= 0 && this.aT < this.bG.length) {
                  this.bG[this.aT] = this.dF[var3];
               }

               if (this.aU >= 0 && this.aU < this.bG.length) {
                  this.bG[this.aU] = this.dG[var3];
               }

               if (this.aV >= 0 && this.aV < this.bG.length) {
                  this.bG[this.aV] = this.dC[var3];
               }

               this.aR -= 240;
               this.aS -= 240;
               this.aT -= 240;
               this.aU -= 240;
               this.aV += 240;
               this.aE += this.aH;
            }
         } else if (var2 == 4) {
            while(this.aU > var1) {
               var3 = this.aE >> 16;
               if (this.aR >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aR] = this.dD[var3];
               }

               if (this.aS >= 0 && this.aS < this.bG.length) {
                  this.bG[this.aS] = this.dE[var3];
               }

               if (this.aT >= 0 && this.aT < this.bG.length) {
                  this.bG[this.aT] = this.dF[var3];
               }

               if (this.aU >= 0 && this.aU < this.bG.length) {
                  this.bG[this.aU] = this.dG[var3];
               }

               this.aR -= 240;
               this.aS -= 240;
               this.aT -= 240;
               this.aU -= 240;
               this.aE += this.aH;
            }
         } else if (var2 == 5) {
            while(this.aT > var1) {
               var3 = this.aE >> 16;
               if (this.aR >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aR] = this.dD[var3];
               }

               if (this.aS >= 0 && this.aS < this.bG.length) {
                  this.bG[this.aS] = this.dE[var3];
               }

               if (this.aT >= 0 && this.aT < this.bG.length) {
                  this.bG[this.aT] = this.dF[var3];
               }

               this.aR -= 240;
               this.aS -= 240;
               this.aT -= 240;
               this.aE += this.aH;
            }
         } else if (var2 == 6) {
            while(this.aS > var1) {
               var3 = this.aE >> 16;
               if (this.aR >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aR] = this.dD[var3];
               }

               if (this.aS >= 0 && this.aS < this.bG.length) {
                  this.bG[this.aS] = this.dE[var3];
               }

               this.aR -= 240;
               this.aS -= 240;
               this.aE += this.aH;
            }
         } else if (var2 == 7) {
            while(this.aR > var1) {
               var3 = this.aE >> 16;
               if (this.aR >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aR] = this.dD[var3];
               }

               this.aR -= 240;
               this.aE += this.aH;
            }
         } else if (var2 == 8) {
            while(this.aU > var1) {
               var3 = this.aE >> 16;
               if (this.aR >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aU] = this.dG[var3];
               }

               this.aU -= 240;
               this.aE += this.aH;
            }
         } else if (var2 == 9) {
            while(this.aT > var1) {
               var3 = this.aE >> 16;
               if (this.aT >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aT] = this.dF[var3];
               }

               this.aT -= 240;
               this.aE += this.aH;
            }
         } else if (var2 == 10) {
            while(this.aS > var1) {
               var3 = this.aE >> 16;
               if (this.aT >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aS] = this.dE[var3];
               }

               this.aS -= 240;
               this.aE += this.aH;
            }
         } else if (var2 == 11) {
            while(this.aV < var1) {
               var3 = this.aE >> 16;
               if (this.aT >= 0 && this.aR < this.bG.length) {
                  this.bG[this.aV] = this.dC[var3];
               }

               this.aV += 240;
               this.aE += this.aH;
            }
         }
      } else {
         while(this.aY < var1) {
            var3 = this.aE >> 16;
            this.bG[this.aR] = this.dD[var3];
            this.bG[this.aS] = this.dE[var3];
            this.bG[this.aT] = this.dF[var3];
            this.bG[this.aU] = this.dG[var3];
            this.bG[this.aV] = this.dC[var3];
            this.bG[this.aW] = this.dB[var3];
            if (this.selectedMap != 12 || this.dA[var3] != 0) {
               this.bG[this.aX] = this.dA[var3];
            }

            if (this.selectedMap != 12 || this.dz[var3] != 0) {
               this.bG[this.aY] = this.dz[var3];
            }

            this.aR -= 240;
            this.aS -= 240;
            this.aT -= 240;
            this.aU -= 240;
            this.aV += 240;
            this.aW += 240;
            this.aX += 240;
            this.aY += 240;
            this.aE += this.aH;
         }
      }

   }

   private void c(int var1, int var2) {
      c3d_b var10000;
      if (this.bR[this.av] == 0) {
         if (this.bQ[this.cj] == 0) {
            if (this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12 || this.selectedMap == 13) {
               this.h(var2);
            }

            this.g(var1);
            return;
         }

         if (this.bQ[this.cj] != 1) {
            this.b(var1, this.dv, this.dw, this.dx, this.dy);
            return;
         }

         if (this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12 || this.selectedMap == 13) {
            this.h(var2);
         }

         var10000 = this;
      } else {
         if (this.bR[this.av] == 1) {
            this.b(var1, this.du, this.dt, this.ds, this.dr);
            return;
         }

         if (this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12 || this.selectedMap == 13) {
            this.h(var2);
         }

         var10000 = this;
      }

      var10000.a(var1, this.dr, this.ds, this.dt, this.du);
   }

   private void h(int var1) {
      c3d_b var10000;
      int var10001;
      byte var10002;
      if (this.aY >= this.cj) {
         var10000 = this;
         var10001 = this.aY + var1;
         var10002 = 0;
      } else if (this.aY < this.cj && this.aX >= this.cj) {
         this.b(this.aX + this.cj - this.aY, 1);
         int var4 = this.aY + var1;
         this.aY = this.cj;
         var10000 = this;
         var10001 = var4;
         var10002 = 0;
      } else if (this.aX < this.cj && this.aW >= this.cj) {
         this.b(this.aW + this.cj - this.aX, 2);
         int var3 = this.aX + var1;
         this.aX = this.cj;
         var10000 = this;
         var10001 = var3;
         var10002 = 1;
      } else if (this.aW < this.cj && this.aV >= this.cj) {
         this.b(this.aV + this.cj - this.aW, 3);
         int var2 = this.aW + var1;
         this.aW = this.cj;
         var10000 = this;
         var10001 = var2;
         var10002 = 2;
      } else {
         if ((this.aV >= this.cj || this.aU - var1 < this.cj) && (this.aU - var1 >= this.cj || this.aT - var1 < this.cj) && (this.aT - var1 >= this.cj || this.aS - var1 < this.cj) && this.aS - var1 < this.cj && this.aR - var1 >= this.cj) {
         }

         var10000 = this;
         var10001 = this.aY + var1;
         var10002 = -1;
      }

      var10000.b(var10001, var10002);
   }

   private void i(int var1) {
      int var2;
      for(var2 = this.aF; this.aK < var1; this.aD += this.aH) {
         var2 = this.aD >> 16;
         this.bG[this.aK] = this.ds[var2];
         this.bG[this.aL] = this.dt[var2];
         this.bG[this.aM] = this.du[var2];
         this.bG[this.aN] = this.dH[var2];
         this.bG[this.aO] = this.dI[var2];
         this.bG[this.aP] = this.dJ[var2];
         this.aK += 240;
         this.aL += 240;
         this.aM += 240;
         this.aN -= 240;
         this.aO -= 240;
         this.aP -= 240;
      }

      this.aF = var2;
   }

   private void j(int var1) {
      if (this.bR[this.av] == 0) {
         if (this.bQ[this.cj] == 0) {
            this.i(var1);
            return;
         }

         if (this.bQ[this.cj] != 1) {
            this.b(var1, this.dw, this.dx, this.dy);
            return;
         }
      } else if (this.bR[this.av] == 1) {
         this.b(var1, this.dt, this.ds, this.dr);
         return;
      }

      this.a(var1, this.ds, this.dt, this.du);
   }

   private void k(int var1) {
      int var2;
      for(var2 = this.aF; this.aL < var1; this.aD += this.aH) {
         var2 = this.aD >> 16;
         this.bG[this.aL] = this.dt[var2];
         this.bG[this.aM] = this.du[var2];
         this.bG[this.aN] = this.dH[var2];
         this.bG[this.aO] = this.dI[var2];
         this.aL += 240;
         this.aM += 240;
         this.aN -= 240;
         this.aO -= 240;
      }

      this.aF = var2;
   }

   private void l(int var1) {
      if (this.bR[this.av] == 0) {
         if (this.bQ[this.cj] == 0) {
            this.k(var1);
            return;
         }

         if (this.bQ[this.cj] != 1) {
            this.b(var1, this.dx, this.dy);
            return;
         }
      } else if (this.bR[this.av] == 1) {
         this.b(var1, this.ds, this.dr);
         return;
      }

      this.a(var1, this.dt, this.du);
   }

   private void m(int var1) {
      int var2;
      for(var2 = this.aF; this.aM < var1; this.aD += this.aH) {
         var2 = this.aD >> 16;
         this.bG[this.aM] = this.du[var2];
         this.bG[this.aN] = this.dH[var2];
         this.aM += 240;
         this.aN -= 240;
      }

      this.aF = var2;
   }

   private void a(int var1, int[] var2, int[] var3, int[] var4, int[] var5) {
      int var6;
      for(var6 = this.aF; this.aJ < var1; this.aD += this.aH) {
         var6 = this.aD >> 16;
         this.bG[this.aJ] = var2[var6];
         this.bG[this.aK] = var3[var6];
         this.bG[this.aL] = var4[var6];
         this.bG[this.aM] = var5[var6];
         this.aJ += 240;
         this.aK += 240;
         this.aL += 240;
         this.aM += 240;
      }

      this.aF = var6;
   }

   private void b(int var1, int[] var2, int[] var3, int[] var4, int[] var5) {
      int var6 = this.aF;

      for(int var7 = this.aZ - var1 + this.cj; this.aQ > var7; this.aD += this.aH) {
         var6 = this.aD >> 16;
         this.bG[this.aQ] = var2[var6];
         this.bG[this.aP] = var3[var6];
         this.bG[this.aO] = var4[var6];
         this.bG[this.aN] = var5[var6];
         this.aN -= 240;
         this.aO -= 240;
         this.aP -= 240;
         this.aQ -= 240;
      }

      this.aF = var6;
   }

   private void a(int var1, int[] var2, int[] var3, int[] var4) {
      int var5;
      for(var5 = this.aF; this.aK < var1; this.aD += this.aH) {
         var5 = this.aD >> 16;
         this.bG[this.aK] = var2[var5];
         this.bG[this.aL] = var3[var5];
         this.bG[this.aM] = var4[var5];
         this.aK += 240;
         this.aL += 240;
         this.aM += 240;
      }

      this.aF = var5;
   }

   private void b(int var1, int[] var2, int[] var3, int[] var4) {
      int var5 = this.aF;

      for(int var6 = this.aZ - var1 + this.cj; this.aP > var6; this.aD += this.aH) {
         var5 = this.aD >> 16;
         this.bG[this.aP] = var2[var5];
         this.bG[this.aO] = var3[var5];
         this.bG[this.aN] = var4[var5];
         this.aN -= 240;
         this.aO -= 240;
         this.aP -= 240;
      }

      this.aF = var5;
   }

   private void a(int var1, int[] var2, int[] var3) {
      int var4;
      for(var4 = this.aF; this.aL < var1; this.aD += this.aH) {
         var4 = this.aD >> 16;
         this.bG[this.aL] = var2[var4];
         this.bG[this.aM] = var3[var4];
         this.aL += 240;
         this.aM += 240;
      }

      this.aF = var4;
   }

   private void b(int var1, int[] var2, int[] var3) {
      int var4 = this.aF;

      for(int var5 = this.aZ - var1 + this.cj; this.aO > var5; this.aD += this.aH) {
         var4 = this.aD >> 16;
         this.bG[this.aO] = var2[var4];
         this.bG[this.aN] = var3[var4];
         this.aN -= 240;
         this.aO -= 240;
      }

      this.aF = var4;
   }

   private void a(int var1, int[] var2) {
      int var3;
      for(var3 = this.aF; this.aM < var1; this.aD += this.aH) {
         var3 = this.aD >> 16;
         this.bG[this.aM] = var2[var3];
         this.aM += 240;
      }

      this.aF = var3;
   }

   private void b(int var1, int[] var2) {
      int var3 = this.aF;

      for(int var4 = this.aZ - var1 + this.cj; this.aN > var4; this.aD += this.aH) {
         var3 = this.aD >> 16;
         this.bG[this.aN] = var2[var3];
         this.aN -= 240;
      }

      this.aF = var3;
   }

   private boolean n(int var1) {
      return (this.ao * (long)this.cx[var1][0] >> 16) + (this.ap * (long)this.cx[var1][1] >> 16) + this.aq <= 0L;
   }

   private void o(int var1) {
      if (var1 < this.gH && (this.cO[var1] < 8 || (this.selectedMap == 2 || this.selectedMap == 3) && this.cO[var1] >= 30 && this.cO[var1] <= 37 || this.selectedMap == 11 && this.cO[var1] >= 47 && this.cO[var1] <= 48 || this.selectedMap == 12 && this.cO[var1] >= 30 && this.cO[var1] <= 32) && !this.cU[var1] && this.cV[var1]) {
         label156: {
            int var3;
            var3 = (var3 = (this.gJ < 0 ? 360 - v(this.gJ) % 360 : this.gJ % 360) - this.cC[var1]) < 0 ? 360 - v(var3) % 360 : var3 % 360;
            c3d_b var10000;
            byte var10001;
            byte var10002;
            byte var10003;
            byte var10004;
            if (this.cO[var1] < 8) {
               if ((var3 < 0 || var3 >= 45) && (var3 < 315 || var3 >= 360)) {
                  if (var3 >= 45 && var3 < 135) {
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
                        break label156;
                     }

                     var10000 = this;
                     var10001 = 3;
                     var10002 = 2;
                     var10003 = 6;
                     var10004 = 7;
                  }
               } else {
                  var10000 = this;
                  var10001 = 4;
                  var10002 = 5;
                  var10003 = 1;
                  var10004 = 0;
               }
            } else if (this.selectedMap < 10) {
               if ((var3 < 0 || var3 >= 45) && (var3 < 315 || var3 >= 360)) {
                  if (var3 >= 45 && var3 < 135) {
                     var10000 = this;
                     var10001 = 34;
                     var10002 = 35;
                     var10003 = 31;
                     var10004 = 30;
                  } else if (var3 >= 135 && var3 < 225) {
                     var10000 = this;
                     var10001 = 37;
                     var10002 = 36;
                     var10003 = 32;
                     var10004 = 33;
                  } else {
                     if (var3 < 225 || var3 >= 315) {
                        break label156;
                     }

                     var10000 = this;
                     var10001 = 31;
                     var10002 = 30;
                     var10003 = 34;
                     var10004 = 35;
                  }
               } else {
                  var10000 = this;
                  var10001 = 32;
                  var10002 = 33;
                  var10003 = 37;
                  var10004 = 36;
               }
            } else if (this.selectedMap == 11) {
               var10000 = this;
               var10001 = 47;
               var10002 = 48;
               var10003 = 47;
               var10004 = 48;
            } else if (!this.fr) {
               var10000 = this;
               var10001 = 30;
               var10002 = 31;
               var10003 = 30;
               var10004 = 31;
            } else {
               var10000 = this;
               var10001 = 30;
               var10002 = 32;
               var10003 = 30;
               var10004 = 32;
            }

            var10000.a(var10001, var10002, var10003, var10004, var1);
         }
      }

      this.p(var1);
      if (this.cf >= 6552L) {
         this.j();
         int var2 = (int)(this.cc >> 16);
         int var6 = (int)(this.cd >> 16);
         if (var2 <= 239) {
            if (var6 >= 0) {
               if (var6 != var2) {
                  this.cu[this.cg] = this.cc;
                  this.cv[this.cg] = this.cd;
                  this.cw[this.cg] = this.ce;
                  this.cB[this.cg] = var1;
                  this.cz[this.cg] = this.cg;
                  this.ct[this.cg] = this.cf;
                  ++this.cg;
               }
            }
         }
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      byte[] var10000;
      int var10001;
      int var10002;
      if (this.cI[var5] == 1) {
         if (this.cS[var5]) {
            var10000 = this.cO;
            var10001 = var5;
            var10002 = var1;
         } else {
            var10000 = this.cO;
            var10001 = var5;
            var10002 = var2;
         }
      } else if (this.cS[var5]) {
         var10000 = this.cO;
         var10001 = var5;
         var10002 = var3;
      } else {
         var10000 = this.cO;
         var10001 = var5;
         var10002 = var4;
      }

      var10000[var10001] = (byte)var10002;
   }

   private void p(int var1) {
      long var2 = ((long)this.cx[var1][0] * 75000L >> 16) - this.hF[0];
      long var4 = ((long)this.cx[var1][1] * 75000L >> 16) - this.hF[1];
      this.cf = (var2 * this.S >> 16) + (var4 * this.T >> 16);
      int[] var10000;
      byte var10001;
      if (this.cs) {
         var10000 = this.bC;
         var10001 = this.cO[var1];
      } else {
         var10000 = this.bC;
         var10001 = this.hm;
      }

      long var6 = (long)var10000[var10001];
      this.cc = (var2 * this.U >> 16) + (var4 * this.V >> 16) - (var6 * 75000L >> 16);
      this.cd = (var2 * this.U >> 16) + (var4 * this.V >> 16) + (var6 * 75000L >> 16);
   }

   private void j() {
      this.cc = 7864320L * this.cc / this.cf + 7831552L;
      this.ce = 291730882560L / this.cf + 6914048L;
      this.cd = 7864320L * this.cd / this.cf + 7831552L;
   }

   private void k() {
      int[] var5 = new int[this.cg];

      for(int var1 = 0; var1 < this.cg; var5[var1] = var1++) {
      }

      this.cl = 10000;

      for(int var6 = 0; var6 < this.cg; ++var6) {
         for(int var2 = var6 + 1; var2 < this.cg; ++var2) {
            int var4 = var5[var2];
            int var3 = var5[var6];
            if (this.ct[var4] > this.ct[var3]) {
               var5[var6] = var4;
               var5[var2] = var3;
            }
         }

         this.q(var5[var6]);
      }

   }

   private void q(int var1) {
      boolean var27 = false;
      this.cc = this.cu[var1];
      this.cd = this.cv[var1];
      this.ce = this.cw[var1];
      this.ch = this.cB[var1];
      c3d_b var10000;
      byte var10001;
      if (this.cs) {
         var10000 = this;
         var10001 = this.cO[this.ch];
      } else {
         var10000 = this;
         var10001 = this.hm;
      }

      var10000.co = var10001;
      short var20 = this.bO[this.co];
      int var21 = this.bP[this.co] / this.bN[this.co];
      short var22 = this.bJ[this.bM[this.co]][this.co];
      this.cf = this.ct[var1];
      this.ci = this.bM[this.co];

      int var15;
      for(int var28 = var15 = this.co * 97; var28 < var15 + 97; ++var28) {
         this.bF[var28 - var15] = this.bI[this.cP[this.ch]][var28];
      }

      int var9 = (int)(this.cc >> 16);
      int var10 = (int)(this.cd >> 16);
      if (this.selectedMap == 12 && this.ch == 19 && this.hD) {
         label279: {
            if (var9 + var10 >> 1 > 127) {
               var10000 = this;
               var10001 = this.gJ - 1;
            } else {
               if (var9 + var10 >> 1 >= 113) {
                  break label279;
               }

               var10000 = this;
               var10001 = this.gJ + 1;
            }

            var10000.gJ = var10001;
         }
      }

      long var2 = (long)((var20 - 1 << 16) / (var10 - var9));
      long var6 = 0L;
      long var4 = 4294967296L / this.cf;
      int var23 = 0;
      int var12 = (int)(this.ce >> 16);
      int var13;
      int var14 = (var13 = 211 - var12) - (var12 - var13);
      int var24;
      if ((var24 = 105 - var13) != 0) {
         this.aH = (var21 * 4 - 1 << 16) / var24;
         int var25;
         int var16 = (var25 = var24 + 1) >> 2;
         int var17 = var25 - (var16 << 2);
         int var18;
         int var19 = (var18 = var16 * 240) + 240;
         if (var10 > 239) {
            var10 = 239;
         }

         boolean var33 = false;
         var10000 = this;
         var10001 = var9;

         while(true) {
            var10000.cj = var10001;
            if (this.cj > var10) {
               if (this.fH == 3 && this.ch < 64 && var33) {
                  int var39 = (int)(a((long)this.cx[this.ch][0] - this.bW) >> 16);
                  int var40 = (int)(a((long)this.cx[this.ch][1] - this.bX) >> 16);
                  if (var39 <= 1 && var40 <= 1) {
                     this.cA[this.cn] = this.ch;
                     ++this.cn;
                  }
               }

               return;
            }

            if (this.cj < 0) {
               ++var23;
            } else {
               label306: {
                  label268: {
                     if (this.bH[1][this.cj] != 0) {
                        if (var4 <= (long)this.bH[1][this.cj]) {
                           ++var23;
                           break label306;
                        }

                        if (var4 <= (long)v(this.bH[0][this.cj])) {
                           if (this.bH[0][this.cj] > 0) {
                              var10000 = this;
                              var10001 = 1;
                           } else {
                              var10000 = this;
                              var10001 = 2;
                           }
                           break label268;
                        }

                        var10000 = this;
                     } else {
                        if (var4 <= (long)v(this.bH[0][this.cj])) {
                           ++var23;
                           break label306;
                        }

                        var10000 = this;
                     }

                     var10001 = 0;
                  }

                  var10000.bk = (byte)var10001;
                  if (var23 != 0) {
                     var6 += (long)var23 * var2;
                     var23 = 0;
                  }

                  int var8 = (int)(var6 >> 16) % var20;
                  this.aF = var22 + var8 * var21;
                  this.aG = this.aF + var21 - 1;
                  this.aD = this.aF << 16;
                  if (!this.cU[this.ch] && this.ch < 64) {
                     this.fo = (int)(a((long)this.cx[this.ch][0] - this.gv) >> 16);
                     this.fp = (int)(a((long)this.cx[this.ch][1] - this.gw) >> 16);
                     if (this.fo <= this.fP && this.fp <= this.fP && (this.fH != 3 || this.ch < 42)) {
                        var27 = true;
                     }
                  }

                  label243: {
                     int var57;
                     label242: {
                        this.aJ = this.cj + var13 * 240;
                        this.aQ = this.cj + var12 * 240;
                        this.aY = this.cj + var14 * 240;
                        this.aR = this.aJ;
                        this.aZ = this.cj + '에';
                        if (var17 == 0) {
                           this.aK = this.aJ + var18;
                           this.aL = this.aK + var18;
                           this.aM = this.aL + var18;
                           this.aP = this.aQ - var18;
                           this.aO = this.aP - var18;
                           this.aN = this.aO - var18;
                           this.aX = this.aY + var18;
                           this.aW = this.aX + var18;
                           this.aV = this.aW + var18;
                           this.aS = this.aR - var18;
                           var10000 = this;
                           var10001 = this.aS;
                           var57 = var18;
                        } else {
                           if (var17 == 1) {
                              this.aK = this.aJ + var18;
                              this.aL = this.aK + var18;
                              this.aM = this.aL + var19;
                              this.aP = this.aQ - var18;
                              this.aO = this.aP - var18;
                              this.aN = this.aO - var19;
                              this.aX = this.aY + var18;
                              this.aW = this.aX + var18;
                              this.aV = this.aW + var19;
                              this.aS = this.aR - var18;
                              this.aT = this.aS - var18;
                              var10000 = this;
                              var10001 = this.aT;
                              var57 = var19;
                              break label242;
                           }

                           if (var17 == 2) {
                              this.aK = this.aJ + var18;
                              this.aL = this.aK + var19;
                              this.aM = this.aL + var18;
                              this.aP = this.aQ - var18;
                              this.aO = this.aP - var19;
                              this.aN = this.aO - var18;
                              this.aX = this.aY + var18;
                              this.aW = this.aX + var19;
                              this.aV = this.aW + var18;
                              var10000 = this;
                              var10001 = this.aR;
                              var57 = var18;
                           } else {
                              if (var17 != 3) {
                                 break label243;
                              }

                              this.aK = this.aJ + var19;
                              this.aL = this.aK + var19;
                              this.aM = this.aL + var18;
                              this.aP = this.aQ - var19;
                              this.aO = this.aP - var19;
                              this.aN = this.aO - var18;
                              this.aX = this.aY + var19;
                              this.aW = this.aX + var19;
                              this.aV = this.aW + var18;
                              var10000 = this;
                              var10001 = this.aR;
                              var57 = var19;
                           }

                           var10000.aS = var10001 - var57;
                           var10000 = this;
                           var10001 = this.aS;
                           var57 = var19;
                        }

                        var10000.aT = var10001 - var57;
                        var10000 = this;
                        var10001 = this.aT;
                        var57 = var18;
                     }

                     var10000.aU = var10001 - var57;
                  }

                  this.bm = true;
                  this.bn = true;
                  this.bo = true;
                  if (this.aK - this.aJ != var18) {
                     this.bm = false;
                  }

                  if (this.aL - this.aK != var18) {
                     this.bn = false;
                  }

                  if (this.aM - this.aL != var18) {
                     this.bo = false;
                  }

                  if (this.aR - this.aS != var18) {
                     this.bp = false;
                  }

                  if (this.aS - this.aT != var18) {
                     this.bq = false;
                  }

                  if (this.aT - this.aU != var18) {
                     this.br = false;
                  }

                  if (this.aX - this.aY != var18) {
                     this.bu = false;
                  }

                  if (this.aW - this.aX != var18) {
                     this.bt = false;
                  }

                  if (this.aV - this.aW != var18) {
                     this.bs = false;
                  }

                  this.ck = 1;
                  if ((this.selectedMap == 2 || this.selectedMap == 3) && this.ch < 42) {
                     this.cV[this.ch] = true;
                  }

                  label213: {
                     byte var58;
                     label311: {
                        int var29;
                        if (this.ci == 5 && (this.selectedMap == 2 || this.selectedMap == 8 || this.selectedMap == 9 || this.selectedMap == 10 || this.selectedMap == 11 || this.selectedMap == 12) || this.ci == 3 && this.selectedMap == 13) {
                           if (this.aY >= this.cj) {
                              this.ck = 1;
                              var10000 = this;
                              var10001 = this.aY + var18;
                              var58 = 1;
                              break label311;
                           }

                           if (this.aY < this.cj && this.aX >= this.cj) {
                              this.ck = 2;
                              this.d(this.aX + this.cj - this.aY, 2);
                              var29 = this.aY + var18;
                              this.aY = this.cj;
                              var10000 = this;
                              var10001 = var29;
                              var58 = 1;
                              break label311;
                           }

                           if (this.aX < this.cj && this.aW >= this.cj) {
                              this.ck = 3;
                              this.d(this.aW + this.cj - this.aX, 3);
                              var29 = this.aX + var18;
                              this.aX = this.cj;
                              var10000 = this;
                              var10001 = var29;
                              var58 = 2;
                              break label311;
                           }

                           if (this.aW >= this.cj || this.aV < this.cj) {
                              break label213;
                           }

                           this.ck = 4;
                           this.d(this.aV + this.cj - this.aW, 4);
                           var29 = this.aW + var18;
                           this.aW = this.cj;
                        } else {
                           if (this.aJ >= this.cj) {
                              this.ck = 1;
                              var10000 = this;
                              var10001 = this.aJ + var18;
                              var58 = 1;
                              break label311;
                           }

                           if (this.aJ < this.cj && this.aK >= this.cj) {
                              this.ck = 2;
                              this.d(this.aK + this.cj - this.aJ, 2);
                              var29 = this.aJ + var18;
                              this.aJ = this.cj;
                              this.aQ = this.cj + '에';
                              var10000 = this;
                              var10001 = var29;
                              var58 = 1;
                              break label311;
                           }

                           if (this.aK < this.cj && this.aL >= this.cj) {
                              this.ck = 3;
                              this.d(this.aL + this.cj - this.aK, 3);
                              var29 = this.aK + var18;
                              this.aK = this.cj;
                              this.aP = this.cj + '에';
                              var10000 = this;
                              var10001 = var29;
                              var58 = 2;
                              break label311;
                           }

                           if (this.aL >= this.cj || this.aM < this.cj) {
                              break label213;
                           }

                           this.ck = 4;
                           this.d(this.aM + this.cj - this.aL, 4);
                           var29 = this.aL + var18;
                           this.aL = this.cj;
                        }

                        this.aO = this.cj + '에';
                        var10000 = this;
                        var10001 = var29;
                        var58 = 3;
                     }

                     var10000.d(var10001, var58);
                  }

                  var6 += var2;
                  byte var38;
                  short var48;
                  if (this.fH == 3) {
                     var38 = 113;
                     var48 = 127;
                  } else {
                     var38 = 92;
                     var48 = 148;
                  }

                  short var30 = var48;
                  var33 = true;
                  int var26;
                  if (var27 && this.cj >= var38 && this.cj <= var30 && (var26 = this.fo + this.fp) < this.cl) {
                     if (this.fH == 3) {
                        this.bY = (long)this.cx[this.ch][0];
                        this.bZ = (long)this.cx[this.ch][1];
                        long var31 = 58982L;
                        this.bY = (this.gv * (65536L - var31) >> 16) + (this.bY * var31 >> 16);
                        this.bZ = (this.gw * (65536L - var31) >> 16) + (this.bZ * var31 >> 16);
                     }

                     this.cq = this.ch;
                     this.cl = var26;
                     if (this.cl < this.cm && this.fH == 3) {
                        this.bW = this.bY;
                        this.bX = this.bZ;
                     }
                  }
               }
            }

            var10000 = this;
            var10001 = this.cj + 1;
         }
      }
   }

   private void d(int var1, int var2) {
      this.bl = 0;
      if (this.ci == 0) {
         int var3 = this.aD;
         this.ba = this.aJ;
         this.bb = this.aK;
         this.bc = this.aL;
         this.bd = this.aM;
         this.c(var1, this.ea, this.eb, this.ec, this.ed, false, var2);
         this.aD = var3;
         this.aJ = this.ba;
         this.aK = this.bb;
         this.aL = this.bc;
         this.aM = this.bd;
         this.bl = 1;
         this.a(var1, this.dY, this.dZ, this.dY, this.dZ, true, var2);
      } else if (this.ci == 1) {
         this.b(var1, this.ee, this.ef, false, var2);
      } else if (this.ci == 2) {
         this.a(var1, this.eg, this.eh, true, var2);
      } else {
         c3d_b var10000;
         int var10001;
         byte[] var10002;
         byte[] var10003;
         byte[] var10004;
         byte[] var10005;
         if (this.ci == 3) {
            if (this.selectedMap == 13) {
               this.b(var1, this.ei, this.ej, this.ek, this.el, true, var2);
               return;
            }

            var10000 = this;
            var10001 = var1;
            var10002 = this.ei;
            var10003 = this.ej;
            var10004 = this.ek;
            var10005 = this.el;
         } else {
            if (this.ci == 4) {
               this.bl = 1;
               this.a(var1, this.eq, this.er, this.eq, this.er, true, var2);
               return;
            }

            if (this.ci == 5) {
               if (this.selectedMap != 2 && this.selectedMap != 8 && this.selectedMap != 9 && this.selectedMap != 10 && this.selectedMap != 11 && this.selectedMap != 12) {
                  this.a(var1, this.em, this.en, this.eo, this.ep, true, var2);
                  return;
               }

               this.b(var1, this.em, this.en, this.eo, this.ep, true, var2);
               return;
            }

            if (this.ci != 6) {
               return;
            }

            int var4 = this.aD;
            int var5 = this.aF;
            this.a(var1, this.es, this.et, this.eu, this.ev, true, var2);
            this.aD = var4;
            this.aF = var5;
            var10000 = this;
            var10001 = var1;
            var10002 = this.ew;
            var10003 = this.ex;
            var10004 = this.ey;
            var10005 = this.ez;
         }

         var10000.c(var10001, var10002, var10003, var10004, var10005, false, var2);
      }
   }

   private void a(int var1, byte[] var2, byte[] var3, boolean var4, int var5) {
      if (this.ck != 4) {
         int var6 = var4 ? 2 : 1;
         if (var5 == 1 && this.bk != var6) {
            while(this.aJ < var1) {
               this.aF = this.aD >> 16;
               this.be = var2[this.aF];
               if (this.be != -1) {
                  this.bG[this.aJ] = this.bF[this.be];
               }

               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aK] = this.bF[this.be];
               }

               this.aJ += 240;
               this.aK += 240;
               this.aD += this.aH;
            }

            if (!this.bm && var2[this.aG] != -1) {
               this.bG[this.aJ] = this.bF[var2[this.aG]];
            }

            if (!this.bn && var3[this.aG] != -1) {
               this.bG[this.aK] = this.bF[var3[this.aG]];
            }
         }

         if (var5 == 2 && this.bk != var6) {
            while(this.aK < var1) {
               this.aF = this.aD >> 16;
               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aK] = this.bF[this.be];
               }

               this.aK += 240;
               this.aD += this.aH;
            }

            if (this.ck == 2) {
               return;
            }

            if (!this.bn && var3[this.aG] != -1) {
               this.bG[this.aK] = this.bF[var3[this.aG]];
            }
         }

         if (var5 == 3 && this.bk != var6) {
            this.aD += (var1 - this.aL) / 240 * this.aH;
         }

      }
   }

   private void a(int var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5, boolean var6, int var7) {
      int var8 = var6 ? 2 : 1;
      if (var7 == 1 && this.bk != var8) {
         while(true) {
            if (this.aJ >= var1) {
               if (this.bl == 0 && !this.bm && var2[this.aG] != -1) {
                  this.bG[this.aJ] = this.bF[var2[this.aG]];
               }

               if (this.bl == 0 && !this.bn && var3[this.aG] != -1) {
                  this.bG[this.aK] = this.bF[var3[this.aG]];
               }

               if (!this.bo && var4[this.aG] != -1) {
                  this.bG[this.aL] = this.bF[var4[this.aG]];
               }

               if (this.aM != this.cj + 25200 || var5[this.aG] == -1) {
                  return;
               }
               break;
            }

            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aM] = this.bF[this.be];
            }

            this.be = var4[this.aF];
            if (this.be != -1) {
               this.bG[this.aL] = this.bF[this.be];
            }

            if (this.bl == 0) {
               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aK] = this.bF[this.be];
               }

               this.be = var2[this.aF];
               if (this.be != -1) {
                  this.bG[this.aJ] = this.bF[this.be];
               }
            }

            this.aJ += 240;
            this.aK += 240;
            this.aL += 240;
            this.aM += 240;
            this.aD += this.aH;
         }
      } else if (var7 == 2 && this.bk != var8) {
         while(this.aK < var1) {
            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aM] = this.bF[this.be];
            }

            this.be = var4[this.aF];
            if (this.be != -1) {
               this.bG[this.aL] = this.bF[this.be];
            }

            if (this.bl == 0) {
               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aK] = this.bF[this.be];
               }
            }

            this.aK += 240;
            this.aL += 240;
            this.aM += 240;
            this.aD += this.aH;
         }

         if (this.ck == 2) {
            return;
         }

         if (this.bl == 0 && !this.bn && var3[this.aG] != -1) {
            this.bG[this.aK] = this.bF[var3[this.aG]];
         }

         if (!this.bo && var4[this.aG] != -1) {
            this.bG[this.aL] = this.bF[var4[this.aG]];
         }

         if (this.aM != this.cj + 25200 || var5[this.aG] == -1) {
            return;
         }
      } else if (var7 == 3 && this.bk != var8) {
         while(this.aL < var1) {
            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aM] = this.bF[this.be];
            }

            this.be = var4[this.aF];
            if (this.be != -1) {
               this.bG[this.aL] = this.bF[this.be];
            }

            this.aL += 240;
            this.aM += 240;
            this.aD += this.aH;
         }

         if (this.ck == 3) {
            return;
         }

         if (!this.bo && var4[this.aG] != -1) {
            this.bG[this.aL] = this.bF[var4[this.aG]];
         }

         if (this.aM != this.cj + 25200 || var5[this.aG] == -1) {
            return;
         }
      } else {
         if (var7 != 4 || this.bk == var8) {
            return;
         }

         while(this.aM < var1) {
            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aM] = this.bF[this.be];
            }

            this.aM += 240;
            this.aD += this.aH;
         }

         if (this.ck == 4) {
            return;
         }

         if (this.aM != this.cj + 25200 || var5[this.aG] == 0) {
            return;
         }
      }

      this.bG[this.aM] = this.bF[var5[this.aG]];
   }

   private void b(int var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5, boolean var6, int var7) {
      int var8 = var6 ? 2 : 1;
      int[] var10000;
      int var10001;
      int[] var10002;
      byte[] var10003;
      if (var7 == 1 && this.bk != var8) {
         while(true) {
            if (this.aY >= var1) {
               if (this.bl == 0 && !this.bu && var2[this.aG] != -1) {
                  this.bG[this.aY] = this.bF[var2[this.aG]];
               }

               if (this.bl == 0 && !this.bt && var3[this.aG] != -1) {
                  this.bG[this.aX] = this.bF[var3[this.aG]];
               }

               if (this.bs || var4[this.aG] == -1) {
                  return;
               }

               var10000 = this.bG;
               var10001 = this.aW;
               var10002 = this.bF;
               var10003 = var4;
               break;
            }

            this.aF = this.aD >> 16;
            if (this.aF < var5.length) {
               this.be = var5[this.aF];
            }

            if (this.be != -1) {
               this.bG[this.aV] = this.bF[this.be];
            }

            if (this.aF < var4.length) {
               this.be = var4[this.aF];
            }

            if (this.be != -1) {
               this.bG[this.aW] = this.bF[this.be];
            }

            if (this.bl == 0) {
               if (this.aF < var3.length) {
                  this.be = var3[this.aF];
               }

               if (this.be != -1) {
                  this.bG[this.aX] = this.bF[this.be];
               }

               if (this.aF < var2.length) {
                  this.be = var2[this.aF];
               }

               if (this.be != -1) {
                  this.bG[this.aY] = this.bF[this.be];
               }
            }

            this.aY += 240;
            this.aX += 240;
            this.aW += 240;
            this.aV += 240;
            this.aD += this.aH;
         }
      } else {
         if (var7 == 2 && this.bk != var8) {
            while(this.aX < var1) {
               this.aF = this.aD >> 16;
               this.be = var5[this.aF];
               if (this.be != -1) {
                  this.bG[this.aV] = this.bF[this.be];
               }

               this.be = var4[this.aF];
               if (this.be != -1) {
                  this.bG[this.aW] = this.bF[this.be];
               }

               if (this.bl == 0) {
                  this.be = var3[this.aF];
                  if (this.be != -1) {
                     this.bG[this.aX] = this.bF[this.be];
                  }
               }

               this.aX += 240;
               this.aW += 240;
               this.aV += 240;
               this.aD += this.aH;
            }

            if (this.ck == 2) {
               return;
            }

            if (this.bl == 0 && !this.bt && var3[this.aG] != -1) {
               this.bG[this.aX] = this.bF[var3[this.aG]];
            }

            if (!this.bs && var4[this.aG] != -1) {
               this.bG[this.aW] = this.bF[var4[this.aG]];
            }

            if (this.aV != this.cj + 25200 || var5[this.aG] == -1) {
               return;
            }
         } else if (var7 == 3 && this.bk != var8) {
            while(this.aW < var1) {
               this.aF = this.aD >> 16;
               this.be = var5[this.aF];
               if (this.be != -1) {
                  this.bG[this.aV] = this.bF[this.be];
               }

               this.be = var4[this.aF];
               if (this.be != -1) {
                  this.bG[this.aW] = this.bF[this.be];
               }

               this.aW += 240;
               this.aV += 240;
               this.aD += this.aH;
            }

            if (this.ck == 3) {
               return;
            }

            if (!this.bs && var4[this.aG] != -1) {
               this.bG[this.aW] = this.bF[var4[this.aG]];
            }

            if (this.aV != this.cj + 25200 || var5[this.aG] == -1) {
               return;
            }
         } else {
            if (var7 != 4 || this.bk == var8) {
               return;
            }

            while(this.aV < var1) {
               this.aF = this.aD >> 16;
               this.be = var5[this.aF];
               if (this.be != -1) {
                  this.bG[this.aV] = this.bF[this.be];
               }

               this.aV += 240;
               this.aD += this.aH;
            }

            if (this.ck == 4) {
               return;
            }

            if (this.aV != this.cj + 25200 || var5[this.aG] == 0) {
               return;
            }
         }

         var10000 = this.bG;
         var10001 = this.aV;
         var10002 = this.bF;
         var10003 = var5;
      }

      var10000[var10001] = var10002[var10003[this.aG]];
   }

   private void b(int var1, byte[] var2, byte[] var3, boolean var4, int var5) {
      int var6 = this.aZ - var1 + this.cj;
      if (this.ck != 4) {
         int var7 = var4 ? 2 : 1;
         if (var5 == 1 && this.bk != var7) {
            while(this.aQ > var6) {
               this.aF = this.aD >> 16;
               this.be = var2[this.aF];
               if (this.be != -1) {
                  this.bG[this.aQ] = this.bF[this.be];
               }

               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aP] = this.bF[this.be];
               }

               this.aP -= 240;
               this.aQ -= 240;
               this.aD += this.aH;
            }

            if (!this.bm && var2[this.aG] != -1) {
               this.bG[this.aQ] = this.bF[var2[this.aG]];
            }

            if (!this.bn && var3[this.aG] != -1) {
               this.bG[this.aP] = this.bF[var3[this.aG]];
            }
         }

         if (var5 == 2 && this.bk != var7) {
            while(this.aP > var6) {
               this.aF = this.aD >> 16;
               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aP] = this.bF[this.be];
               }

               this.aP -= 240;
               this.aD += this.aH;
            }

            if (this.ck == 2) {
               return;
            }

            if (!this.bn && var3[this.aG] != -1) {
               this.bG[this.aP] = this.bF[var3[this.aG]];
            }
         }

         if (var5 == 3 && this.bk != var7) {
            this.aD += (this.aO - var6) / 240 * this.aH;
         }

      }
   }

   private void c(int var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5, boolean var6, int var7) {
      int var8 = this.aZ - var1 + this.cj;
      int var9 = var6 ? 2 : 1;
      if (var7 == 1 && this.bk != var9) {
         while(true) {
            if (this.aQ <= var8) {
               if (this.bl == 0 && !this.bm && var2[this.aG] != -1) {
                  this.bG[this.aQ] = this.bF[var2[this.aG]];
               }

               if (this.bl == 0 && !this.bn && var3[this.aG] != -1) {
                  this.bG[this.aP] = this.bF[var3[this.aG]];
               }

               if (!this.bo && var4[this.aG] != -1) {
                  this.bG[this.aO] = this.bF[var4[this.aG]];
               }

               if (this.aN != this.cj + 25440 || var5[this.aG] == -1) {
                  return;
               }
               break;
            }

            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aN] = this.bF[this.be];
            }

            this.be = var4[this.aF];
            if (this.be != -1) {
               this.bG[this.aO] = this.bF[this.be];
            }

            if (this.bl == 0) {
               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aP] = this.bF[this.be];
               }

               this.be = var2[this.aF];
               if (this.be != -1) {
                  this.bG[this.aQ] = this.bF[this.be];
               }
            }

            this.aN -= 240;
            this.aO -= 240;
            this.aP -= 240;
            this.aQ -= 240;
            this.aD += this.aH;
         }
      } else if (var7 == 2 && this.bk != var9) {
         while(this.aP > var8) {
            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aN] = this.bF[this.be];
            }

            this.be = var4[this.aF];
            if (this.be != -1) {
               this.bG[this.aO] = this.bF[this.be];
            }

            if (this.bl == 0) {
               this.be = var3[this.aF];
               if (this.be != -1) {
                  this.bG[this.aP] = this.bF[this.be];
               }
            }

            this.aN -= 240;
            this.aO -= 240;
            this.aP -= 240;
            this.aD += this.aH;
         }

         if (this.ck == 2) {
            return;
         }

         if (this.bl == 0 && !this.bn && var3[this.aG] != -1) {
            this.bG[this.aP] = this.bF[var3[this.aG]];
         }

         if (!this.bo && var4[this.aG] != -1) {
            this.bG[this.aO] = this.bF[var4[this.aG]];
         }

         if (this.aN != this.cj + 25440 || var5[this.aG] == -1) {
            return;
         }
      } else if (var7 == 3 && this.bk != var9) {
         while(this.aO > var8) {
            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aN] = this.bF[this.be];
            }

            this.be = var4[this.aF];
            if (this.be != -1) {
               this.bG[this.aO] = this.bF[this.be];
            }

            this.aN -= 240;
            this.aO -= 240;
            this.aD += this.aH;
         }

         if (this.ck == 3) {
            return;
         }

         if (!this.bo && var4[this.aG] != -1) {
            this.bG[this.aO] = this.bF[var4[this.aG]];
         }

         if (this.aN != this.cj + 25440 || var5[this.aG] == -1) {
            return;
         }
      } else {
         if (var7 != 4 || this.bk == var9) {
            return;
         }

         while(this.aN > var8) {
            this.aF = this.aD >> 16;
            this.be = var5[this.aF];
            if (this.be != -1) {
               this.bG[this.aN] = this.bF[this.be];
            }

            this.aN -= 240;
            this.aD += this.aH;
         }

         if (this.ck == 4) {
            return;
         }

         if (this.aN != this.cj + 25440 || var5[this.aG] == -1) {
            return;
         }
      }

      this.bG[this.aN] = this.bF[var5[this.aG]];
   }

   private void l() {
      label111: {
         if (this.hU[2]) {
            this.a(this.cX, this.cZ, 0);
            if (this.hA || this.hU[5] || this.ht || this.hu || this.eO) {
               break label111;
            }
         } else {
            if (!this.hU[8]) {
               break label111;
            }

            this.a(this.cY, this.da, 0);
            if (this.hA || this.hU[5]) {
               break label111;
            }
         }

         this.F(23);
      }

      label93: {
         c3d_b var10000;
         long var10001;
         long var10002;
         byte var10003;
         if (this.hU[1]) {
            var10000 = this;
            var10001 = this.cX;
            var10002 = this.cZ;
            var10003 = 90;
         } else {
            if (!this.hU[3]) {
               break label93;
            }

            var10000 = this;
            var10001 = this.cX;
            var10002 = this.cZ;
            var10003 = -90;
         }

         var10000.a(var10001, var10002, var10003);
      }

      if (this.hU[7]) {
         this.gJ += this.gN;
         if (this.selectedMap == 12) {
            this.fF -= 2 * this.gN;
            if (this.fF < 0) {
               this.fF += 180;
               --this.iK;
               this.iK = (byte)(this.iK + 4);
               this.iK = (byte)(this.iK % 4);
               if (this.iK == 0) {
                  this.if_ = 180;
                  return;
               }

               if (this.il) {
                  this.if_ = 360;
                  return;
               }

               this.if_ = 0;
               return;
            }
         }
      } else if (this.hU[9]) {
         this.gJ -= this.gN;
         if (this.selectedMap == 12) {
            this.fF += 2 * this.gN;
            if (this.fF >= 180) {
               this.fF %= 180;
               ++this.iK;
               this.iK = (byte)(this.iK % 4);
               if (this.iK == 0) {
                  this.if_ = 180;
                  return;
               }

               if (this.il) {
                  this.if_ = 360;
                  return;
               }

               this.if_ = 0;
               return;
            }
         }
      } else if (this.hU[4]) {
         this.gJ += this.gL;
         if (this.selectedMap == 12) {
            this.fF -= 2 * this.gL;
            if (this.fF < 0) {
               this.fF += 180;
               --this.iK;
               this.iK = (byte)(this.iK + 4);
               this.iK = (byte)(this.iK % 4);
               if (this.iK == 0) {
                  this.if_ = 180;
                  return;
               }

               if (this.il) {
                  this.if_ = 360;
                  return;
               }

               this.if_ = 0;
               return;
            }
         }
      } else if (this.hU[6]) {
         this.gJ -= this.gL;
         if (this.selectedMap == 12) {
            this.fF += 2 * this.gL;
            if (this.fF >= 180) {
               this.fF %= 180;
               ++this.iK;
               this.iK = (byte)(this.iK % 4);
               if (this.iK == 0) {
                  this.if_ = 180;
                  return;
               }

               if (this.il) {
                  this.if_ = 360;
                  return;
               }

               this.if_ = 0;
               return;
            }
         }
      } else if (this.hY == -10000 && this.ik) {
         this.a(this.id, this.iH, this.iI, this.ie);
         ++this.id;
         if (this.id == 8) {
            this.ik = false;
         }
      }

   }

   private void a(int var1, long var2, long var4, int var6) {
      this.a(var2 >> (var1 >> 1), var4 >> (var1 >> 1), var6);
   }

   private void a(long var1, long var3, int var5) {
      long[] var6 = new long[2];
      int var7 = this.gJ + var5;
      var6[0] = this.hF[0] - (var1 * this.t(var7) >> 16);
      var6[1] = this.hF[1] + (var1 * this.u(var7) >> 16);
      if (this.ji) {
         this.hF[0] = var6[0];
         this.hF[1] = var6[1];
      } else {
         this.fs = false;
         if (!this.a(var6, var1 >> 1, var7, false, -1)) {
            if (this.fs) {
               var6[0] = this.hF[0] - ((var1 >> 1) * this.t(var7) >> 16);
               var6[1] = this.hF[1] + ((var1 >> 1) * this.u(var7) >> 16);
            }

            this.eY = -1;
            this.as = -1;
            if (this.a(var6)) {
               this.hF[0] = var6[0];
               this.hF[1] = var6[1];
            } else {
               label57: {
                  c3d_b var10000;
                  if (this.eY >= this.gS && this.eY < this.gT) {
                     this.as = this.eY;
                     this.ga = false;
                     if (this.selectedMap != 1 && this.selectedMap != 2) {
                        break label57;
                     }

                     this.z();
                     if (this.hz) {
                        this.a(100);
                     }

                     var10000 = this;
                  } else {
                     var10000 = this;
                  }

                  var10000.ga = true;
               }

               int var8 = 0;

               while(this.eY != -1) {
                  this.a(this.eY, var3, var7);
                  ++var8;
                  if (var8 >= 2) {
                     break;
                  }
               }

            }
         }
      }
   }

   private boolean a(long[] var1) {
      this.db = this.hF[0];
      this.dc = this.hF[1];
      this.dd = var1[0];
      this.de = var1[1];
      int var3 = this.cQ[this.hh].length;
      short var10000 = 0;

      while(true) {
         int var4 = var10000;
         if (var10000 >= var3) {
            var4 = this.dn[this.hh].length;
            var10000 = 0;

            while(true) {
               short var10 = var10000;
               if (var10000 >= var4) {
                  this.eY = -1;
                  return true;
               }

               short var6 = this.dn[this.hh][var10];
               short var7 = this.do_[this.hh][var10];
               var10000 = var6;

               while(true) {
                  short var8 = var10000;
                  if (var10000 > var7) {
                     var10000 = (short)(var10 + 1);
                     break;
                  }

                  if (this.r(var8)) {
                     this.eY = var8;
                     if ((this.selectedMap != 3 || var8 != 121) && (this.selectedMap != 7 || var8 != 153 && var8 != 169 && var8 != 168 && var8 != 87 && var8 != 88)) {
                        if (this.selectedMap == 2 && (var8 == 4 || var8 == 10 || var8 == 17 || var8 == 24 || var8 == 130 || var8 == 136 || var8 == 142)) {
                           this.fx = true;
                           long[] var15;
                           byte var16;
                           long var17;
                           if (var8 != 4 && var8 != 10 && var8 != 7 && var8 != 24) {
                              var15 = this.hF;
                              var16 = 0;
                              var17 = var15[0] - 40000L;
                           } else {
                              var15 = this.hF;
                              var16 = 0;
                              var17 = var15[0] + 40000L;
                           }

                           var15[var16] = var17;
                        }
                     } else {
                        if (!this.fU) {
                           this.fU = true;
                           if (this.selectedMap < this.hb) {
                              this.hb = this.selectedMap;
                           }

                           this.fS = true;
                           this.fC = 3;
                           this.fX = true;
                           if (var8 != 121) {
                              this.dW[var8] = 0;
                           } else {
                              this.dW[var8] = 17;
                           }
                        } else if (this.dW[var8] != 0 && var8 != 121 || this.dW[var8] != 17 && var8 == 121) {
                           int[] var13 = this.gx;
                           var13[3] += 3;
                           byte[] var14;
                           short var10001;
                           byte var10002;
                           if (var8 != 121) {
                              var14 = this.dW;
                              var10001 = var8;
                              var10002 = 0;
                           } else {
                              var14 = this.dW;
                              var10001 = var8;
                              var10002 = 17;
                           }

                           var14[var10001] = var10002;
                           this.ht = true;
                           this.hn = 3;
                           this.go = this.gl;
                        }

                        if (var8 == 87) {
                           this.hP[0][0] = 78;
                           this.hP[0][1] = 0;
                           this.hP[0][2] = 0;
                        }

                        if (var8 == 88) {
                           this.hP[10][0] = 79;
                           this.hP[10][1] = 0;
                           this.hP[10][2] = 0;
                        }
                     }

                     return false;
                  }

                  var10000 = (short)(var8 + 1);
               }
            }
         }

         for(int var5 = this.gW + 4 * this.cQ[this.hh][var4]; var5 < this.gW + 4 * (this.cQ[this.hh][var4] + 1); ++var5) {
            if (this.r(var5)) {
               this.eY = var5;
               return false;
            }
         }

         var10000 = (short)(var4 + 1);
      }
   }

   private boolean r(int var1) {
      if (this.bS[var1] == 1) {
         return false;
      } else {
         long var2 = (long)(this.dP[1][var1] - this.dP[3][var1]);
         long var4 = (long)(this.dP[2][var1] - this.dP[0][var1]);
         if ((var2 * this.db >> 16) + (var4 * this.dc >> 16) + (long)this.dM[var1] > 0L) {
            return false;
         } else if ((var2 * this.dd >> 16) + (var4 * this.de >> 16) + (long)this.dM[var1] < 0L) {
            return false;
         } else {
            this.a((short)((short)var1), (short)((short)(var1 + 1)), 1);
            if ((this.df * this.dd >> 16) + (this.dg * this.de >> 16) + this.dj > 0L) {
               return false;
            } else {
               return (this.dh * this.dd >> 16) + (this.di * this.de >> 16) + this.dk <= 0L;
            }
         }
      }
   }

   private void a(int var1, long var2, int var4) {
      long[] var6;
      (var6 = new long[2])[0] = this.hF[0];
      var6[1] = this.hF[1];
      long var7 = (long)(this.dP[1][var1] - this.dP[3][var1]);
      long var9 = (long)(this.dP[2][var1] - this.dP[0][var1]);
      long var11 = -(var7 * this.hF[0] >> 16) - (var9 * this.hF[1] >> 16);
      int var5 = this.e(var1, var4) ? 1 : -1;
      long[] var10000;
      byte var10001;
      long var10002;
      if (this.eA[var1] != 0) {
         var6[0] -= (long)var5 * var2 * this.t(this.eA[var1]) >> 16;
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
         this.hF[0] = var6[0];
         this.hF[1] = var6[1];
      } else {
         c3d_b var13;
         if (this.eY >= this.gS && this.eY < this.gT) {
            this.as = this.eY;
            var13 = this;
            var10001 = 0;
         } else {
            var13 = this;
            var10001 = 1;
         }

         var13.ga = (boolean)var10001;
      }
   }

   private boolean e(int var1, int var2) {
      return this.u(var2 - this.eA[var1]) >= 0L;
   }

   private boolean a(long[] var1, long var2, int var4, boolean var5, int var6) {
      long var7 = var1[0];
      long var9 = var1[1];
      int var12 = this.cR[this.hh].length;

      for(int var14 = 0; var14 < var12; ++var14) {
         short var11 = this.cR[this.hh][var14];
         int var13 = this.selectedMap == 11 && var11 == 19 ? 2 : 0;
         if (a(var7 - ((long)this.cx[var11][0] * 75000L >> 16)) < 30000L << var13 && a(var9 - ((long)this.cx[var11][1] * 75000L >> 16)) < 30000L << var13 && this.cE[this.cO[var11]] == 1 && var11 != var6) {
            if ((this.selectedMap == 3 && (this.cO[var11] == 49 || this.cO[var11] == 50) || this.selectedMap == 6 && (this.cO[var11] == 38 || this.cO[var11] == 39) || this.selectedMap == 7 && this.cO[var11] >= 35 && this.cO[var11] <= 36 || this.selectedMap == 9 && this.cO[var11] >= 38 && this.cO[var11] <= 39 || this.selectedMap == 11 && this.cO[var11] >= 39 && this.cO[var11] <= 40) && !var5) {
               return this.b(var11, var2, var4);
            }

            if ((this.selectedMap == 7 || this.selectedMap == 6) && this.cO[var11] == 34) {
               if (!this.fU) {
                  this.fU = true;
                  if (this.selectedMap < this.hb) {
                     this.hb = this.selectedMap;
                  }

                  this.fX = true;
                  int var37 = v(this.I() % 3);
                  int[] var49 = this.gx;
                  var49[3] += 1 + var37;
               } else {
                  if (this.cN[var11] <= 0) {
                     return false;
                  }

                  int var38 = v(this.I() % 3);
                  int[] var50 = this.gx;
                  var50[3] += 1 + var38;
                  this.ht = true;
                  this.hn = 3;
                  this.go = this.gl;
               }

               this.cN[var11] = -1;
               return false;
            }

            if (var13 > 0) {
               this.cV[var11] = true;
            }

            if (this.selectedMap == 12 && var11 == 19 && this.hD) {
               this.hC = true;
               this.hD = false;
               this.hU[2] = false;
               this.aa();
               this.iO = this.gl;
               return true;
            }

            if (this.selectedMap == 12 && var11 == 19 && !this.hD) {
               this.cV[var11] = false;
               if (this.cO[var11] == 30) {
                  this.cO[var11] = 31;
               }

               return true;
            }

            if (this.selectedMap == 1 && this.cO[var11] >= 30 && this.cO[var11] <= 33 || this.selectedMap == 2 && this.cO[var11] >= 17 && this.cO[var11] <= 19 || this.selectedMap == 3 && this.cO[var11] >= 42 && this.cO[var11] <= 44 || this.selectedMap == 6 && this.cO[var11] >= 35 && this.cO[var11] <= 37 || this.selectedMap == 12 && this.cO[var11] >= 34 && this.cO[var11] <= 36 || this.selectedMap == 8 && this.cO[var11] >= 30 && this.cO[var11] <= 32) {
               --this.gz;
               if (this.gz <= 100) {
                  this.gF = 100;
               }

               if (this.gz <= 0 && !this.fy) {
                  this.gz = 0;
                  this.ij = true;
                  this.fz = false;
                  this.J();
                  this.gz = this.gE;
                  if (this.gz > 100) {
                     this.gF = 200;
                  }

                  for(int var36 = 0; var36 < 4; ++var36) {
                     this.gx[var36] = this.gy[var36];
                  }

                  this.fH = this.gG;
                  if (this.gx[this.fH] > 0) {
                     this.gb = true;
                  }

                  this.fK = 0;
                  this.fE = 0;
                  this.fZ = false;
                  this.fM = 0;
                  this.fD = 40;
                  return false;
               }

               if (this.cO[var11] != 33) {
                  return false;
               }
            }

            if (this.selectedMap == 1 && var11 == 101) {
               ++this.selectedMap;
               this.hZ = 0;
               if (this.selectedMap != 12) {
                  if (this.jL < this.selectedMap) {
                     this.jL = this.selectedMap;
                  }

                  this.jH[this.selectedMap - 1] = this.fH;
                  this.jI[this.selectedMap - 1] = this.gz;

                  for(int var18 = 0; var18 < 4; ++var18) {
                     this.jK[this.selectedMap - 1][var18] = this.gx[var18];
                  }

                  this.jJ[this.selectedMap - 1] = this.gA;

                  try {
                     if (this.jz != null) {
                        this.jz.stop();
                     }
                  } catch (Exception var17) {
                  }

                  this.ac();
               }

               this.fR = 0;
               this.hB = true;
               this.hr = true;
               this.gG = this.fH;
               this.gE = this.gz;

               for(int var19 = 0; var19 < 4; ++var19) {
                  this.gy[var19] = this.gx[var19];
               }

               return false;
            }

            if (this.selectedMap == 2 && this.cO[var11] == 54) {
               this.fw = true;

               for(int var15 = 0; var15 < var12; ++var15) {
                  if (this.cO[this.cR[this.hh][var15]] == 54) {
                     this.cO[this.cR[this.hh][var15]] = 56;
                  }
               }
            }

            if (this.selectedMap == 12 && var11 == 188) {
               this.fW = true;
               this.fV = true;
               this.fT = true;
            }

            if ((this.selectedMap == 4 || this.selectedMap == 5) && this.cO[var11] == 38 && this.cG[var11] != 30) {
               return false;
            }

            if (var11 < 188) {
               if (this.cO[var11] == 23) {
                  if (this.gx[this.cL[var11]] == 777) {
                     return false;
                  }

                  int var20 = v(this.I() % 11);
                  int[] var10000 = this.gx;
                  byte var10001 = this.cL[var11];
                  var10000[var10001] += 10 + var20;
                  if (this.gx[this.cL[var11]] > 777) {
                     this.gx[this.cL[var11]] = 777;
                  }

                  this.ht = true;
                  this.hn = this.cL[var11];
                  this.go = this.gl;
                  this.cO[var11] = 22;
               }

               if (this.cO[var11] == 24) {
                  if (this.gz >= 100) {
                     return false;
                  }

                  int var21 = v(this.I() % 11);
                  if (this.gz < 100) {
                     this.gz += 10 + var21;
                     this.hu = true;
                     this.gp = this.gl;
                     this.cO[var11] = 22;
                  }

                  if (this.gz > this.gF) {
                     this.gz = this.gF;
                  }
               }

               if (this.cO[var11] == 25) {
                  if (this.gx[this.cL[var11]] == 777 && this.gz >= 100) {
                     return false;
                  }

                  if (this.gx[this.cL[var11]] < 777 && this.gz >= 100) {
                     int var35 = v(this.I() % 11);
                     int[] var48 = this.gx;
                     byte var58 = this.cL[var11];
                     var48[var58] += 10 + var35;
                     if (this.gx[this.cL[var11]] > 777) {
                        this.gx[this.cL[var11]] = 777;
                     }

                     this.ht = true;
                     this.hn = this.cL[var11];
                     this.go = this.gl;
                     this.cO[var11] = 24;
                     return false;
                  }

                  if (this.gx[this.cL[var11]] == 777 && this.gz < 100) {
                     int var34 = v(this.I() % 11);
                     if (this.gz < 100) {
                        this.gz += 10 + var34;
                        this.hu = true;
                        this.gp = this.gl;
                     }

                     if (this.gz > this.gF) {
                        this.gz = this.gF;
                     }

                     this.cO[var11] = 23;
                     return false;
                  }

                  int var22 = v(this.I() % 11);
                  int[] var40 = this.gx;
                  byte var51 = this.cL[var11];
                  var40[var51] += 10 + var22;
                  if (this.gx[this.cL[var11]] > 777) {
                     this.gx[this.cL[var11]] = 777;
                  }

                  this.ht = true;
                  this.hn = (byte)(this.cN[var11] - 5);
                  this.go = this.gl;
                  int var16 = v(this.I() % 11);
                  if (this.gz < 100) {
                     this.gz += 10 + var16;
                     this.hu = true;
                     this.gp = this.gl;
                  }

                  if (this.gz > this.gF) {
                     this.gz = this.gF;
                  }

                  this.cO[var11] = 22;
               }
            }

            if (this.cO[var11] == this.dl || this.cO[var11] == 15 || (this.selectedMap == 4 || this.selectedMap == 5) && this.cO[var11] == 38 || this.selectedMap == 7 && this.cO[var11] == 42 || this.selectedMap == 10 && this.cO[var11] == 39 || this.selectedMap == 11 && this.cO[var11] == 46 || this.selectedMap == 8 && this.cO[var11] == 39) {
               if (this.cN[var11] <= 3 && this.cN[var11] >= 1) {
                  if (this.gx[this.cN[var11] - 1] == 777) {
                     return false;
                  }

                  int var33 = v(this.I() % 11);
                  int[] var47 = this.gx;
                  int var57 = this.cN[var11] - 1;
                  var47[var57] += 10 + var33;
                  if (this.gx[this.cN[var11] - 1] > 777) {
                     this.gx[this.cN[var11] - 1] = 777;
                  }

                  this.ht = true;
                  this.hn = (byte)(this.cN[var11] - 1);
                  this.go = this.gl;
               } else if (this.cN[var11] == 4) {
                  if (this.gz >= 100) {
                     return false;
                  }

                  int var29 = v(this.I() % 11);
                  if (this.gz < 100) {
                     this.gz += 10 + var29;
                     this.hu = true;
                     this.gp = this.gl;
                  }

                  if (this.gz > this.gF) {
                     this.gz = this.gF;
                  }
               } else if (this.cN[var11] >= 5) {
                  if (this.gx[this.cN[var11] - 5] == 777 && this.gz >= 100) {
                     return false;
                  }

                  if (this.gx[this.cN[var11] - 5] < 777 && this.gz >= 100) {
                     int var32 = v(this.I() % 11);
                     int[] var46 = this.gx;
                     int var56 = this.cN[var11] - 5;
                     var46[var56] += 10 + var32;
                     if (this.gx[this.cN[var11] - 5] > 777) {
                        this.gx[this.cN[var11] - 5] = 777;
                     }

                     this.ht = true;
                     this.hn = (byte)(this.cN[var11] - 5);
                     this.go = this.gl;
                     this.cN[var11] = 4;
                     return false;
                  }

                  if (this.gx[this.cN[var11] - 5] == 777 && this.gz < 100) {
                     int var31 = v(this.I() % 11);
                     if (this.gz < 100) {
                        this.gz += 10 + var31;
                        this.hu = true;
                        this.gp = this.gl;
                     }

                     if (this.gz > this.gF) {
                        this.gz = this.gF;
                     }

                     byte[] var45 = this.cN;
                     var45[var11] = (byte)(var45[var11] - 4);
                     return false;
                  }

                  int var30 = v(this.I() % 11);
                  int[] var44 = this.gx;
                  int var55 = this.cN[var11] - 5;
                  var44[var55] += 10 + var30;
                  if (this.gx[this.cN[var11] - 5] > 777) {
                     this.gx[this.cN[var11] - 5] = 777;
                  }

                  this.ht = true;
                  this.hn = (byte)(this.cN[var11] - 5);
                  this.go = this.gl;
                  int var39 = v(this.I() % 11);
                  if (this.gz < 100) {
                     this.gz += 10 + var39;
                     this.hu = true;
                     this.gp = this.gl;
                  }

                  if (this.gz > this.gF) {
                     this.gz = this.gF;
                  }
               }

               this.cN[var11] = -1;
               return false;
            }

            if (var11 < 188) {
               return true;
            }

            if (!this.cU[var11]) {
               return false;
            }

            if (this.cJ[var11] == this.dm + 2) {
               return false;
            }

            if (this.cJ[var11] == this.dm + 3) {
               if (this.gx[this.cK[var11]] == 777) {
                  return false;
               }

               int var23 = v(this.I() % 21);
               int[] var41 = this.gx;
               byte var52 = this.cK[var11];
               var41[var52] += 25 + var23;
               this.ht = true;
               this.hn = this.cK[var11];
               this.go = this.gl;
            } else if (this.cJ[var11] == this.dm + 4) {
               if (this.gz == this.gF && this.selectedMap != 7 && this.selectedMap != 4 || this.gz == 200) {
                  return false;
               }

               int var24 = v(this.I() % 21);
               if (this.gz < 100) {
                  this.gz += 25 + var24;
                  this.hu = true;
                  this.gp = this.gl;
               }

               if ((this.selectedMap == 7 || this.selectedMap == 4) && this.gz != 200) {
                  this.gz = 200;
                  this.gF = 200;
                  this.hu = true;
                  this.gp = this.gl;
               }
            } else if (this.cJ[var11] == this.dm + 5) {
               if (this.gx[this.cK[var11]] == 777 && (this.gz == this.gF && this.selectedMap != 7 && this.selectedMap != 4 || this.gz == 200)) {
                  return false;
               }

               if (this.gx[this.cK[var11]] == 777 && this.gz != this.gF) {
                  this.cJ[var11] = (byte)(this.dm + 3);
                  int var27 = v(this.I() % 21);
                  this.cO[var11] = this.cJ[var11];
                  if (this.gz < 100) {
                     this.gz += 25 + var27;
                     this.hu = true;
                     this.gp = this.gl;
                  }

                  if ((this.selectedMap == 7 || this.selectedMap == 4) && this.gz != 200) {
                     this.gz = 200;
                     this.gF = 200;
                     this.hu = true;
                     this.gp = this.gl;
                  }

                  if (this.gz > this.gF) {
                     this.gz = this.gF;
                  }

                  return false;
               }

               if (this.gx[this.cK[var11]] != 777 && (this.gz == this.gF && this.selectedMap != 7 && this.selectedMap != 4 || this.gz == 200)) {
                  this.cJ[var11] = (byte)(this.dm + 4);
                  this.cO[var11] = this.cJ[var11];
                  int var26 = v(this.I() % 21);
                  int[] var43 = this.gx;
                  byte var54 = this.cK[var11];
                  var43[var54] += 25 + var26;
                  if (this.gx[this.cK[var11]] > 777) {
                     this.gx[this.cK[var11]] = 777;
                  }

                  this.ht = true;
                  this.hn = this.cK[var11];
                  this.go = this.gl;
                  return false;
               }

               this.ht = true;
               this.hu = true;
               this.hn = this.cK[var11];
               this.go = this.gl;
               this.gp = this.gl;
               int var25 = v(this.I() % 21);
               int[] var42 = this.gx;
               byte var53 = this.cK[var11];
               var42[var53] += 25 + var25;
               if (this.gz < 100) {
                  this.gz += 25;
               } else {
                  this.hu = false;
               }

               if ((this.selectedMap == 7 || this.selectedMap == 4) && this.gz != 200) {
                  this.gz = 200;
                  this.gF = 200;
               }
            } else if (this.cJ[var11] == this.dm + 6) {
               int var28 = v(this.I() % 2);
               if (this.fH != 3) {
                  this.gA += 2 + var28;
               } else {
                  if (this.gB == 0 && this.fK != 2) {
                     this.gb = true;
                     this.gc = false;
                  }

                  this.gB += 2 + var28;
               }

               this.hv = true;
               this.gq = this.gl;
            }

            if (this.gB > 777) {
               this.gB = 777;
            }

            if (this.gz > this.gF) {
               this.gz = this.gF;
            }

            if (this.hu || this.ht || this.hv) {
               this.cJ[var11] = (byte)(this.dm + 2);
            }

            this.cO[var11] = this.cJ[var11];
            return false;
         }
      }

      if (this.selectedMap == 12) {
         this.cV[19] = true;
      }

      return false;
   }

   private boolean b(int var1, long var2, int var4) {
      long[] var5;
      (var5 = new long[2])[0] = (long)this.cx[var1][0] * 75000L >> 16;
      var5[1] = (long)this.cx[var1][1] * 75000L >> 16;
      var5[0] -= var2 * this.t(var4) >> 16;
      var5[1] += var2 * this.u(var4) >> 16;
      if (!this.a(var5)) {
         return true;
      } else if (!this.a(var5, var2, var4, true, var1)) {
         this.cx[var1][0] = (int)((var5[0] << 16) / 75000L);
         this.cx[var1][1] = (int)((var5[1] << 16) / 75000L);
         this.fs = true;
         return false;
      } else {
         return true;
      }
   }

   private void s(int var1) {
      this.dP = new int[4][var1];
      this.bR = new byte[var1];
   }

   private void f(int var1, int var2) {
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

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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

   private void m() {
      this.dp = new long[this.gP];
      this.dq = new long[this.gP];
      this.dL = new int[this.gP];
      this.dM = new int[this.gP];
      this.eA = new byte[this.gP];
      this.cu = new long[this.cO.length];
      this.cv = new long[this.cO.length];
      this.cw = new long[this.cO.length];
      this.cB = new int[this.cO.length];
      this.cz = new int[this.cO.length];
      this.ct = new long[this.cO.length];
   }

   private void n() {
      this.dp = null;
      this.dq = null;
      System.gc();
      this.bU = new short[7][3][3];
   }

   private void a(boolean var1) {
      this.b(var1);
      this.jq = null;
      this.jr = null;
      if (!this.ji) {
         this.jo = (int[][])null;
      }

      this.jp = null;
      this.hL = null;
      this.hO = null;
      this.fc = (short[][])null;
      this.eS = null;
      this.gi = (int[][])null;
      this.gf = null;
      this.gg = null;
      this.gj = (int[][])null;
      this.dr = null;
      this.ds = null;
      this.dt = null;
      this.du = null;
      this.dv = null;
      this.dw = null;
      this.dx = null;
      this.dy = null;
      this.dz = null;
      this.dA = null;
      this.dB = null;
      this.dC = null;
      this.dD = null;
      this.dE = null;
      this.dF = null;
      this.dG = null;
      this.dH = null;
      this.dI = null;
      this.dJ = null;
      this.dK = null;
      this.dY = null;
      this.dZ = null;
      this.ea = null;
      this.eb = null;
      this.ec = null;
      this.ed = null;
      this.ee = null;
      this.ef = null;
      this.eg = null;
      this.eh = null;
      this.ei = null;
      this.ej = null;
      this.ek = null;
      this.el = null;
      this.em = null;
      this.en = null;
      this.eo = null;
      this.ep = null;
      this.eq = null;
      this.er = null;
      this.es = null;
      this.et = null;
      this.eu = null;
      this.ev = null;
      this.ew = null;
      this.ex = null;
      this.ey = null;
      this.ez = null;
      this.bI = (int[][])null;
      this.fa = null;
      this.dL = null;
      this.dM = null;
      this.eA = null;
      this.cu = null;
      this.cv = null;
      this.cB = null;
      this.cw = null;
      this.cz = null;
      this.ct = null;
      this.bU = (short[][][])null;
      System.gc();
   }

   private void b(boolean var1) {
      this.bG = null;
      this.bH = (int[][])null;
      this.bV = null;
      this.bQ = null;
      if (!var1) {
         System.gc();
      }

   }

   private void c(boolean var1) {
      this.e = null;
      this.f = null;
      this.h = null;
      this.i = null;
      this.j = null;
      if (!this.ji) {
         this.l = null;
         this.js = null;
         this.m = null;
         this.jt = null;
         this.n = null;
         this.o = null;
      }

      if (var1) {
         System.gc();
      }

   }

   private void o() {
      this.fb = (short[][])null;
      this.fd = null;
      this.ff = null;
      this.fe = null;
      System.gc();
   }

   private void p() {
      int var2 = this.gT;

      for(int var1 = 0; var1 < this.gR; ++var1) {
         if (this.eF[var1] == 1) {
            this.g(-1, var1);
            this.a(this.eB[var1], (long)this.eH[var1], (long)this.eP, this.eD[var1], this.eE[var1], var2, 0);
         } else {
            this.a(this.eB[var1], (long)this.eH[var1], (long)this.eJ[var1], this.eD[var1], this.eE[var1], var2, 0);
         }

         this.a((short)((short)var2), (short)((short)(var2 + 3)), 1);
         var2 += 3;
      }

   }

   private int a(int[] var1, long var2, long var4, int var6, int var7, int var8, int var9) {
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

   private void d(boolean var1) {
      int var4 = this.gT;

      for(int var2 = 0; var2 < this.gR; ++var2) {
         label114: {
            byte var10000;
            if (this.eF[var2] == 8) {
               if (!var1) {
                  break label114;
               }

               var10000 = 12;
            } else {
               if (var1) {
                  break label114;
               }

               var10000 = 30;
            }

            byte var3 = var10000;
            if (this.eF[var2] != -1) {
               if (this.eF[var2] == 1) {
                  if (this.eO && this.eN[var2] != -1) {
                     label78: {
                        this.g(1, var2);
                        this.a(this.eB[var2], (long)this.eH[var2], (long)this.eQ, this.eD[var2], this.eE[var2], var4, 0);
                        this.a((short)((short)var4), (short)((short)(var4 + 3)), 1);
                        this.eF[var2] = -1;
                        this.eO = false;
                        this.eN[var2] = -1;
                        c3d_b var6;
                        byte var7;
                        long var8;
                        long var10003;
                        short var10004;
                        byte var10005;
                        if (var2 == 5) {
                           var6 = this;
                           var7 = 0;
                           var8 = 2957768L;
                           var10003 = 1532768L;
                           var10004 = 180;
                           var10005 = 7;
                        } else if (var2 == 8) {
                           var6 = this;
                           var7 = 1;
                           var8 = 1607768L;
                           var10003 = 1832768L;
                           var10004 = 180;
                           var10005 = 7;
                        } else if (var2 == 10) {
                           var6 = this;
                           var7 = 1;
                           var8 = 1167232L;
                           var10003 = 1457768L;
                           var10004 = -90;
                           var10005 = 7;
                        } else if (var2 == 11) {
                           var6 = this;
                           var7 = 1;
                           var8 = 2057768L;
                           var10003 = 1457768L;
                           var10004 = 90;
                           var10005 = 7;
                        } else {
                           if (var2 == 13) {
                              var6 = this;
                              var7 = 0;
                              var8 = 1090960L;
                              var10003 = 3332768L;
                              var10004 = -90;
                           } else if (var2 == 14) {
                              var6 = this;
                              var7 = 0;
                              var8 = 1990960L;
                              var10003 = 3332768L;
                              var10004 = -90;
                           } else {
                              if (var2 != 15) {
                                 break label78;
                              }

                              var6 = this;
                              var7 = 0;
                              var8 = 1607768L;
                              var10003 = 2957768L;
                              var10004 = 180;
                           }

                           var10005 = 12;
                        }

                        var6.a(var7, var8, var10003, var10004, var10005);
                     }

                     this.ft = true;
                  }

                  var4 += 3;
                  continue;
               }

               if (this.eN[var2] == -1) {
                  this.bS[var4 + 1] = 1;
               } else if (this.eN[var2] < this.eF[var2]) {
                  this.eO = true;
                  if ((this.selectedMap == 1 || this.selectedMap == 2) && var2 == 0) {
                     this.im = true;
                  }

                  this.bS[var4 + 1] = 0;
                  this.g(-1, var2);
                  this.a(this.eB[var2], (long)this.eH[var2], (long)this.eJ[var2], this.eD[var2], this.eE[var2], var4, 0);
                  this.a((short)((short)var4), (short)((short)(var4 + 3)), 1);
               } else {
                  label128: {
                     int[] var5;
                     int var10001;
                     int var10002;
                     if (this.eN[var2] < var3) {
                        var5 = this.eN;
                        var10001 = var2;
                        var10002 = var5[var2] + 1;
                     } else if (this.eN[var2] < var3 + this.eF[var2]) {
                        if (a(this.hF[0] - ((long)this.eC[var2][0] * 75000L >> 16)) >= 75000L || a(this.hF[1] - ((long)this.eC[var2][1] * 75000L >> 16)) >= 75000L) {
                           if ((this.selectedMap == 1 || this.selectedMap == 2) && var2 == 0) {
                              this.im = true;
                           }

                           this.g(1, var2);
                           this.a(this.eB[var2], (long)this.eH[var2], (long)this.eJ[var2], this.eD[var2], this.eE[var2], var4, 0);
                           this.a((short)((short)var4), (short)((short)(var4 + 3)), 1);
                           break label128;
                        }

                        var5 = this.eN;
                        var10001 = var2;
                        var10002 = this.eF[var2] - (this.eN[var2] - var3);
                     } else {
                        this.eO = false;
                        var5 = this.eN;
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

   private void g(int var1, int var2) {
      int[] var3;
      int var10001;
      int var10002;
      if (this.eF[var2] == 1) {
         var3 = this.eJ;
         var3[var2] += var1 * this.eR;
         this.eL[var2] = (int)((long)this.eL[var2] - (long)(var1 * v(this.eR)) * 96L);
         var3 = this.eM;
         var10001 = var2;
         var10002 = (int)((long)this.eM[var2] + (long)(var1 * v(this.eR)) * 96L);
      } else {
         int[] var4 = this.eJ;
         var4[var2] += var1 * this.eK[var2];
         this.eL[var2] = (int)((long)this.eL[var2] - (long)(var1 * v(this.eK[var2])) * 96L);
         this.eM[var2] = (int)((long)this.eM[var2] + (long)(var1 * v(this.eK[var2])) * 96L);
         var3 = this.eN;
         var10001 = var2;
         var10002 = var3[var2] + 1;
      }

      var3[var10001] = var10002;
   }

   private void q() {
      int var1 = 0;
      int var2 = 0;
      var2 = this.selectedMap != 10 && !this.ji ? 0 : 1;
      long var4 = this.ji ? 75000L + (75000L >> var2) : 75000L << var2;

      for(int var6 = this.gW; var6 < this.gP; var6 += 4) {
         if (!this.dV[var1]) {
            long var7 = -(this.gv - this.dR[0][var1]);
            long var9 = -(this.gw - this.dR[1][var1]);
            if (a(var7) < var4 && a(var9) < var4) {
               int[] var10000;
               int var10001;
               int var10002;
               if (this.dN[var1] > 0) {
                  var10000 = this.dO;
                  var10001 = var1;
                  var10002 = var10000[var1] + 5;
               } else {
                  var10000 = this.dO;
                  var10001 = var1;
                  var10002 = var10000[var1] - 5;
               }

               var10000[var10001] = var10002;
               this.a(this.dS[0][var1], this.dS[1][var1], this.dU[0][var1], this.dU[1][var1], this.dO[var1], var6, this.dW[var6], this.dW[var6 + 1], this.dW[var6 + 2], this.dW[var6 + 3], (byte)var1, (byte)0, this.dX[var1]);
               this.a((short)((short)var6), (short)((short)(var6 + 4)), 2);
               if (this.dO[var1] == this.dN[var1]) {
                  this.dV[var1] = true;
               }
            }
         }

         ++var1;
      }

   }

   private void r() {
      boolean var1 = this.eO;

      for(int var2 = 0; var2 < this.gR; ++var2) {
         long var3 = (this.selectedMap != 1 || var2 != 8 && var2 != 10 && var2 != 11 && var2 != 5) && (this.selectedMap != 2 || var2 != 13 && var2 != 14 && var2 != 15) ? 75000L : 37500L;
         if (a(this.hF[0] - ((long)this.eC[var2][0] * 75000L >> 16)) < var3 && a(this.hF[1] - ((long)this.eC[var2][1] * 75000L >> 16)) < var3) {
            if (var2 == this.gK) {
               ++this.selectedMap;
               if (this.selectedMap == 12) {
                  this.fH = 2;
               }

               label271: {
                  c3d_b var23;
                  byte var24;
                  if (this.selectedMap != 6 && this.selectedMap != 9) {
                     if (this.selectedMap != 1) {
                        break label271;
                     }

                     var23 = this;
                     var24 = 2;
                  } else {
                     var23 = this;
                     var24 = 3;
                  }

                  var23.he = var24;
               }

               this.hZ = 0;
               this.ib = 1;
               if (this.selectedMap != 13) {
                  if (this.jL < this.selectedMap) {
                     this.jL = this.selectedMap;
                  }

                  this.jH[this.selectedMap - 1] = this.fH;
                  this.jI[this.selectedMap - 1] = this.gz;

                  for(int var11 = 0; var11 < 4; ++var11) {
                     this.jK[this.selectedMap - 1][var11] = this.gx[var11];
                  }

                  this.jJ[this.selectedMap - 1] = this.gA;

                  try {
                     if (this.jz != null) {
                        this.jz.stop();
                     }
                  } catch (Exception var8) {
                  }

                  this.ac();
               }

               if (this.selectedMap >= 13) {
                  this.hC = true;

                  try {
                     if (this.jz != null) {
                        this.jz.stop();
                     }
                  } catch (Exception var7) {
                  }

                  this.jL = 13;
                  this.ac();
                  this.aa();
                  return;
               }

               this.hB = true;
               this.hr = true;
               this.gG = this.fH;
               this.gE = this.gz;

               for(int var12 = 0; var12 < 4; ++var12) {
                  this.gy[var12] = this.gx[var12];
               }

               return;
            }

            if (var2 == 10 && this.selectedMap == 3) {
               for(int var10 = 1; var10 < 3; ++var10) {
                  ++this.selectedMap;
                  this.hZ = 0;
                  this.ib = 1;
                  if (this.selectedMap != 13) {
                     if (this.jL < this.selectedMap) {
                        this.jL = this.selectedMap;
                     }

                     this.jH[this.selectedMap - 1] = this.fH;
                     this.jI[this.selectedMap - 1] = this.gz;

                     for(int var13 = 0; var13 < 4; ++var13) {
                        this.jK[this.selectedMap - 1][var13] = this.gx[var13];
                     }

                     this.jJ[this.selectedMap - 1] = this.gA;

                     try {
                        if (this.jz != null) {
                           this.jz.stop();
                        }
                     } catch (Exception var9) {
                     }

                     this.ac();
                  }

                  if (this.selectedMap < 13) {
                     this.hB = true;
                     this.hr = true;
                     this.gG = this.fH;
                     this.gE = this.gz;

                     for(int var14 = 0; var14 < 4; ++var14) {
                        this.gy[var14] = this.gx[var14];
                     }

                     this.cU[13] = false;
                     this.cU[14] = false;
                  }
               }

               return;
            }

            label277: {
               int[][] var16;
               byte var10001;
               if (this.selectedMap == 2 && var2 == 4 && this.cy[4][2] != 3) {
                  ++this.cO[68];
                  ++this.cO[71];
                  this.cy[4][2] = 3;
                  this.cy[4][3] = 100;
                  this.cy[7][2] = 3;
                  var16 = this.cy;
                  var10001 = 7;
               } else if (this.selectedMap == 2 && var2 == 6 && this.cy[45][2] != 3) {
                  ++this.cO[109];
                  ++this.cO[70];
                  this.cy[45][2] = 3;
                  this.cy[45][3] = 100;
                  this.cy[6][2] = 3;
                  var16 = this.cy;
                  var10001 = 6;
               } else if (this.selectedMap == 2 && var2 == 8 && this.cy[2][2] != 3) {
                  ++this.cO[66];
                  ++this.cO[69];
                  this.cy[2][2] = 3;
                  this.cy[2][3] = 100;
                  this.cy[5][2] = 3;
                  var16 = this.cy;
                  var10001 = 5;
               } else {
                  if (this.selectedMap != 2 || var2 != 10 || this.cy[43][2] == 3) {
                     break label277;
                  }

                  ++this.cO[107];
                  ++this.cO[108];
                  this.cy[43][2] = 3;
                  this.cy[43][3] = 100;
                  this.cy[44][2] = 3;
                  var16 = this.cy;
                  var10001 = 44;
               }

               var16[var10001][3] = 100;
            }

            if (this.eN[var2] == -1 && this.eF[var2] != -1 && (this.hh == this.eG[var2] || !this.eO)) {
               var1 = true;
               this.eN[var2] = 0;
               if (!this.hA) {
                  this.F(19);
               }

               if (this.hh != this.eG[var2]) {
                  this.eS = null;
                  System.gc();
                  this.hh = this.eG[var2];
                  this.eS = new a(this, this.fc[this.hh][0], (d)null);
                  int var5 = this.fc[this.hh].length;

                  for(int var6 = 1; var6 < var5; ++var6) {
                     a.a(this.eS, this.fc[this.hh][var6]);
                  }
               }
            }
         }
      }

      this.eO = var1;
   }

   private void s() {
      this.fa = new int[91];
      this.fa[1] = 1146;
      int var1 = 1146;

      for(int var2 = 2; var2 <= 90; ++var2) {
         var1 += this.a[var2 - 2];
         this.fa[var2] = this.fa[var2 - 1] + var1;
      }

      this.a = null;
   }

   private long t(int var1) {
      if (var1 < 0) {
         return -this.t(-var1);
      } else if (var1 >= 90 & var1 < 180) {
         return (long)this.fa[180 - var1];
      } else if (var1 >= 180 & var1 < 270) {
         return (long)(-this.fa[var1 - 180]);
      } else if (var1 >= 270 & var1 < 360) {
         return (long)(-this.fa[90 - (var1 - 270)]);
      } else {
         return var1 >= 360 ? this.t(var1 % 360) : (long)this.fa[var1];
      }
   }

   private long u(int var1) {
      return this.t(90 - var1);
   }

   private static int v(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   private static long a(long var0) {
      return var0 > 0L ? var0 : -var0;
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.eT = (long)var1 * (17000L * this.t(this.eA[var6]) >> 16) + ((long)this.dP[1][var6] * 75000L >> 16);
      this.eU = (long)var2 * (17000L * this.u(90 - this.eA[var6]) >> 16) + ((long)this.dP[0][var6] * 75000L >> 16);
      this.eW = (long)var3 * (17000L * this.u(90 + this.eA[var6]) >> 16) + ((long)this.dP[2][var6] * 75000L >> 16);
      this.eV = (long)var4 * (17000L * this.t(90 - this.eA[var6]) >> 16) + ((long)this.dP[1][var6] * 75000L >> 16);
      this.eX = (long)var5 * (17000L * this.t(90 + this.eA[var6]) >> 16) + ((long)this.dP[3][var6] * 75000L >> 16);
   }

   private void a(short var1, short var2, int var3) {
      short var10000 = var1;

      while(true) {
         short var14 = var10000;
         if (var10000 >= var2) {
            return;
         }

         long var10 = (long)(this.dP[1][var14] - this.dP[3][var14]);
         long var12 = (long)(this.dP[2][var14] - this.dP[0][var14]);
         this.dL[var14] = (int)(-(var10 * (long)this.dP[0][var14] >> 16) - (var12 * (long)this.dP[1][var14] >> 16));
         if (var3 == 0 || var3 == 2) {
            label63: {
               byte[] var16;
               short var10001;
               byte var10002;
               if (var10 == 0L) {
                  var16 = this.eA;
                  var10001 = var14;
                  var10002 = -90;
               } else {
                  long var4;
                  long var6 = (var4 = (var12 << 16) / var10) < 0L ? -var4 : var4;
                  this.eA[var14] = 0;
                  if (var6 > 3746989L) {
                     var16 = this.eA;
                     var10001 = var14;
                     var10002 = 89;
                  } else {
                     byte var17 = this.eA[var14];

                     while(true) {
                        byte var15 = var17;
                        if ((this.t(var15) << 16) / this.t(90 - var15) >= var6) {
                           var16 = this.eA;
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

                  var16 = this.eA;
                  var10001 = var14;
                  var10002 = (byte)(-this.eA[var14]);
               }

               var16[var10001] = var10002;
            }

            if (var3 == 0) {
               this.dp[var14] = var10;
               this.dq[var14] = var12;
            }
         }

         long var8;
         c3d_b var19;
         byte var21;
         byte var23;
         byte var10003;
         byte var10004;
         byte var10005;
         if (this.dP[1][var14] <= this.dP[3][var14]) {
            var8 = (17000L * this.u(this.eA[var14]) >> 16) + ((long)this.dP[0][var14] * 75000L >> 16);
            if (this.eA[var14] != -90) {
               var19 = this;
               var21 = 1;
               var23 = 1;
               var10003 = 1;
               var10004 = -1;
               var10005 = 1;
            } else if (this.dP[0][var14] < this.dP[2][var14]) {
               var19 = this;
               var21 = 1;
               var23 = 1;
               var10003 = 1;
               var10004 = 1;
               var10005 = 1;
            } else {
               var19 = this;
               var21 = -1;
               var23 = -1;
               var10003 = -1;
               var10004 = 1;
               var10005 = 1;
            }
         } else {
            var8 = -(17000L * this.u(this.eA[var14]) >> 16) + ((long)this.dP[0][var14] * 75000L >> 16);
            var19 = this;
            var21 = -1;
            var23 = -1;
            var10003 = -1;
            var10004 = 1;
            var10005 = -1;
         }

         var19.a(var21, var23, var10003, var10004, var10005, var14);
         this.dM[var14] = (int)(-(var10 * var8 >> 16) - (var12 * this.eT >> 16));
         this.df = var12;
         this.dg = -var10;
         this.dh = -var12;
         this.di = var10;
         this.dj = (long)((int)(-(var12 * this.eU >> 16) + (var10 * this.eV >> 16)));
         this.dk = (long)((int)((var12 * this.eW >> 16) - (var10 * this.eX >> 16)));
         if (((var12 * (long)this.dP[0][var14] >> 16) * 75000L >> 16) + ((-var10 * (long)this.dP[1][var14] >> 16) * 75000L >> 16) + this.dj >= 0L) {
            this.df = -var12;
            this.dg = var10;
            this.dh = var12;
            this.di = -var10;
            this.dj = -this.dj;
            this.dk = -this.dk;
         }

         var10000 = (short)(var14 + 1);
      }
   }

   private void t() {
      this.a((short)0, (short)((short)this.gP), 0);
   }

   private void w(int var1) {
      this.fb = new short[this.gP][];
      this.fd = new short[this.gP];
      int var14 = this.dn[var1].length;
      short var10000 = 0;

      while(true) {
         short var16 = var10000;
         if (var10000 >= var14) {
            return;
         }

         short var19 = this.dn[var1][var16];
         short var20 = this.do_[var1][var16];
         var10000 = var19;

         while(true) {
            short var15 = var10000;
            if (var10000 > var20) {
               var10000 = (short)(var16 + 1);
               break;
            }

            this.fb[var15] = new short[127];
            long var6 = (long)this.dP[0][var15];
            long var8 = (long)this.dP[1][var15];
            long var10 = (long)this.dP[2][var15];
            long var12 = (long)this.dP[3][var15];
            short var23 = 0;
            var10000 = 0;

            while(true) {
               short var18 = var10000;
               if (var10000 >= var14) {
                  var10000 = (short)(var15 + 1);
                  break;
               }

               short var21 = this.dn[var1][var18];
               short var22 = this.do_[var1][var18];
               var10000 = var21;

               while(true) {
                  short var17 = var10000;
                  if (var10000 > var22) {
                     this.fd[var15] = var23;
                     var10000 = (short)(var18 + 1);
                     break;
                  }

                  long var2 = (this.dp[var17] * var6 >> 16) + (this.dq[var17] * var8 >> 16) + (long)this.dL[var17];
                  long var4 = (this.dp[var17] * var10 >> 16) + (this.dq[var17] * var12 >> 16) + (long)this.dL[var17];
                  if (var2 * var4 < 0L) {
                     this.fb[var15][var23] = var17;
                     ++var23;
                  }

                  var10000 = (short)(var17 + 1);
               }
            }
         }
      }
   }

   private void x(int var1) {
      this.ff = new boolean[this.gP];
      this.fe = new short[this.gP];
      int var2 = this.dn[var1].length;
      short var10000 = 0;

      while(true) {
         short var5 = var10000;
         if (var10000 >= var2) {
            return;
         }

         short var3 = this.dn[var1][var5];
         short var4 = this.do_[var1][var5];
         var10000 = var3;

         while(true) {
            short var6 = var10000;
            if (var10000 > var4) {
               var10000 = (short)(var5 + 1);
               break;
            }

            if (!this.ff[var6]) {
               this.a(var6, var1);
            }

            var10000 = (short)(var6 + 1);
         }
      }
   }

   private void a(short var1, int var2) {
      int var3 = this.dn[var2].length;
      short var10000 = 0;

      while(true) {
         short var7 = var10000;
         if (var10000 >= var3) {
            this.fe[this.eZ] = var1;
            this.ff[var1] = true;
            ++this.eZ;
            return;
         }

         short var4 = this.dn[var2][var7];
         short var5 = this.do_[var2][var7];
         var10000 = var4;

         while(true) {
            short var8 = var10000;
            if (var10000 > var5) {
               var10000 = (short)(var7 + 1);
               break;
            }

            if (!this.ff[var8]) {
               short var6 = this.fd[var8];

               for(int var9 = 0; var9 < var6; ++var9) {
                  if (this.fb[var8][var9] == var1) {
                     this.a(var8, var2);
                  }
               }
            }

            var10000 = (short)(var8 + 1);
         }
      }
   }

   private void y(int var1) {
      this.eZ = 0;
      this.w(var1);
      this.x(var1);
      int var2 = 0;
      short var10000 = 0;

      while(true) {
         short var4 = var10000;
         if (var10000 >= this.dn[var1].length) {
            this.fc[var1] = new short[var2];
            var10000 = 0;

            while(true) {
               short var5 = var10000;
               if (var10000 >= var2) {
                  return;
               }

               this.fc[var1][var5] = this.fe[var5];
               var10000 = (short)(var5 + 1);
            }
         }

         var10000 = this.dn[var1][var4];

         while(true) {
            short var3 = var10000;
            if (var10000 > this.do_[var1][var4]) {
               var10000 = (short)(var4 + 1);
               break;
            }

            ++var2;
            var10000 = (short)(var3 + 1);
         }
      }
   }

   private void h(int var1, int var2) {
      this.fq = false;
      this.fo = (int)(a((long)this.cx[var1][0] - this.gv) >> 16);
      this.fp = (int)(a((long)this.cx[var1][1] - this.gw) >> 16);
      if (this.fo <= var2 && this.fp <= var2) {
         this.fh = (long)this.cx[var1][0] * 75000L >> 16;
         this.fi = (long)this.cx[var1][1] * 75000L >> 16;
         this.fj = this.hF[1] - this.fi;
         this.fk = this.fh - this.hF[0];
         this.fl = -(this.fj * this.hF[0] >> 16) - (this.fk * this.hF[1] >> 16);
         this.fm = this.fj * 75000L >> 16;
         this.fn = this.fk * 75000L >> 16;
         int var3 = this.cQ[this.hh].length;
         short var10000 = 0;

         while(true) {
            int var4 = var10000;
            if (var10000 >= var3) {
               var4 = this.dn[this.hh].length;
               var10000 = 0;

               while(true) {
                  short var10 = var10000;
                  if (var10000 >= var4) {
                     if (this.selectedMap == 3) {
                        for(int var11 = 92; var11 < 97; ++var11) {
                           if (!this.z(var11)) {
                              this.fq = false;
                              return;
                           }
                        }
                     }

                     if (this.selectedMap == 6) {
                        for(int var12 = 75; var12 < 87; ++var12) {
                           if (!this.z(var12)) {
                              this.fq = false;
                              return;
                           }
                        }
                     }

                     this.fq = true;
                     return;
                  }

                  short var6 = this.dn[this.hh][var10];
                  short var7 = this.do_[this.hh][var10];
                  var10000 = var6;

                  while(true) {
                     short var8 = var10000;
                     if (var10000 > var7) {
                        var10000 = (short)(var10 + 1);
                        break;
                     }

                     if (this.bR[var8] != 1 && !this.A(var8)) {
                        this.fq = false;
                        return;
                     }

                     var10000 = (short)(var8 + 1);
                  }
               }
            }

            for(int var5 = this.gW + 4 * this.cQ[this.hh][var4]; var5 < this.gW + 4 * (this.cQ[this.hh][var4] + 1); ++var5) {
               if (!this.A(var5)) {
                  this.fq = false;
                  return;
               }
            }

            var10000 = (short)(var4 + 1);
         }
      }
   }

   private boolean z(int var1) {
      long var2 = (long)this.cx[var1][0] * 75000L >> 16;
      long var4 = (long)this.cx[var1][1] * 75000L >> 16;
      long var6 = a(var2 - this.fh) + a(var4 - this.fi);
      long var8 = a(var2 - this.hF[0]) + a(var4 - this.hF[1]);
      long var10 = var6 + var8;
      long var12 = a(this.fh - this.hF[0]) + a(this.fi - this.hF[1]);
      return a(var10 - var12) >= 17000L;
   }

   private boolean A(int var1) {
      long var2 = (this.fm * (long)this.dP[0][var1] >> 16) + (this.fn * (long)this.dP[1][var1] >> 16) + this.fl;
      long var4 = (this.fm * (long)this.dP[2][var1] >> 16) + (this.fn * (long)this.dP[3][var1] >> 16) + this.fl;
      if (var2 * var4 < 0L) {
         long var6 = (long)(this.dP[1][var1] - this.dP[3][var1]);
         long var8 = (long)(this.dP[2][var1] - this.dP[0][var1]);
         var2 = (var6 * this.hF[0] >> 16) + (var8 * this.hF[1] >> 16) + ((long)this.dL[var1] * 75000L >> 16);
         var4 = (var6 * this.fh >> 16) + (var8 * this.fi >> 16) + ((long)this.dL[var1] * 75000L >> 16);
         if (var2 * var4 < 0L) {
            return false;
         }
      }

      return true;
   }

   private void B(int var1) {
      for(int var4 = 0; var4 < this.gH; ++var4) {
         if (!this.cU[var4]) {
            if ((this.cO[var4] == 9 || this.cO[var4] == 10) && this.cG[var4] <= 0) {
               this.cO[var4] = 8;
            } else {
               c3d_b var10000;
               int var10001;
               byte var10002;
               label393: {
                  if (this.cG[var4] <= 0 || this.cG[var4] == 30 && (this.selectedMap == 6 || this.selectedMap == 7 || this.selectedMap == 4 || this.selectedMap == 5 || this.selectedMap == 11 || this.selectedMap == 12)) {
                     if (this.cG[var4] != 30) {
                        var10000 = this;
                        var10001 = var4;
                        var10002 = 2;
                        break label393;
                     }

                     if (this.selectedMap != 7 && this.selectedMap != 6 && this.selectedMap != 11) {
                        var10000 = this;
                        var10001 = var4;
                        var10002 = 1;
                        break label393;
                     }

                     if (this.selectedMap != 11) {
                        var10000 = this;
                        var10001 = var4;
                        var10002 = 4;
                        break label393;
                     }

                     var10000 = this;
                  } else {
                     var10000 = this;
                  }

                  var10001 = var4;
                  var10002 = 0;
               }

               var10000.h(var10001, var10002);
               if (this.selectedMap != 4 && this.selectedMap != 5) {
                  if ((this.selectedMap == 7 || this.selectedMap == 6 || this.selectedMap == 11) && this.cG[var4] == 30) {
                     if (this.fq) {
                        if (this.I() % this.gD == 0 || this.selectedMap == 11 && this.cO[var4] == 30) {
                           this.cT[var4] = true;
                           this.cO[var4] = 32;
                           this.gz -= this.gC * this.hq;
                           if (this.gz < 100) {
                              this.gF = 100;
                           }

                           if (this.gz <= 0 && !this.fy) {
                              this.gz = 0;
                              this.ij = true;
                              this.fz = false;
                              this.J();
                              this.gz = this.gE;
                              if (this.gz > 100) {
                                 this.gF = 200;
                              }

                              for(int var8 = 0; var8 < 4; ++var8) {
                                 this.gx[var8] = this.gy[var8];
                              }

                              this.fH = this.gG;
                              if (this.gx[this.fH] > 0) {
                                 this.gb = true;
                              }

                              this.fK = 0;
                              return;
                           }
                        } else if (this.cT[var4]) {
                           this.cO[var4] = 31;
                        } else {
                           this.cO[var4] = 30;
                        }
                     } else {
                        this.cO[var4] = this.cG[var4];
                     }
                     continue;
                  }
               } else {
                  if (this.cG[var4] == 30 && !this.fZ && (this.cO[var4] != 31 || this.I() % 15 == 0)) {
                     if (this.cO[var4] < 31) {
                        this.cO[var4] = 31;
                     }

                     if (this.fq) {
                        this.cT[var4] = true;
                        if (this.cO[var4] != 34) {
                           if (this.ge[var4] != 1) {
                              ++this.cO[var4];
                              var10002 = this.ge[var4]++;
                           } else {
                              --this.cO[var4];
                              int[] var11 = this.ge;
                              var11[var4] += 9;
                           }
                        } else {
                           this.cO[var4] = 31;
                           this.ge[var4] = -1;
                           this.fZ = true;
                        }
                     } else {
                        byte[] var12;
                        if (this.cT[var4]) {
                           var12 = this.cO;
                           var10001 = var4;
                           var10002 = 31;
                        } else {
                           var12 = this.cO;
                           var10001 = var4;
                           var10002 = 30;
                        }

                        var12[var10001] = (byte)var10002;
                     }
                  }

                  if (this.cG[var4] == 30) {
                     continue;
                  }
               }

               if ((this.selectedMap == 7 || this.selectedMap == 4) && this.cG[var4] == 37) {
                  if (this.cO[var4] == 37) {
                     this.cO[var4] = 38;
                  } else {
                     this.cO[var4] = 37;
                  }
               } else if (this.cG[var4] <= 35 || this.selectedMap >= 10 && this.cG[var4] == 47) {
                  this.fr = false;
                  if (this.selectedMap == 12 && this.cG[var4] == 30 && this.fq) {
                     this.fr = true;
                     if (!this.cV[var4]) {
                        this.cO[var4] = (byte)(63 - this.cO[var4]);
                     }

                     int var2 = this.fo + this.fp;
                     this.gz -= this.fA[var2] * this.hq >> 1;
                     if (this.gz < 100) {
                        this.gF = 100;
                     }

                     if (this.gz <= 0 && !this.fy) {
                        this.gz = 0;
                        this.ij = true;
                        this.fz = false;
                        this.J();
                        this.gz = this.gE;
                        if (this.gz > 100) {
                           this.gF = 200;
                        }

                        for(int var7 = 0; var7 < 4; ++var7) {
                           this.gx[var7] = this.gy[var7];
                        }

                        this.fH = this.gG;
                        if (this.gx[this.fH] > 0) {
                           this.gb = true;
                        }

                        this.fK = 0;
                        return;
                     }
                  }

                  if (this.fq) {
                     int var3 = this.I();
                     int var6 = this.fo + this.fp;
                     if ((var3 % 1 == 0 || this.cO[var4] == 8 && this.cF[var4] != -1 || this.cT[var4]) && this.cG[var4] < 0) {
                        this.cO[var4] = 8;
                        this.cT[var4] = true;
                        if (this.I() % 2 == 0) {
                           this.cO[var4] = 9;
                           if (this.I() % 2 == 0) {
                              this.gz -= this.fA[var6] * this.hq;
                              if (this.gz < 100) {
                                 this.gF = 100;
                              }

                              if (this.gz <= 0 && !this.fy) {
                                 this.gz = 0;
                                 this.ij = true;
                                 this.fz = false;
                                 this.J();
                                 this.gz = this.gE;
                                 if (this.gz > 100) {
                                    this.gF = 200;
                                 }

                                 for(int var5 = 0; var5 < 4; ++var5) {
                                    this.gx[var5] = this.gy[var5];
                                 }

                                 this.fH = this.gG;
                                 if (this.gx[this.fH] > 0) {
                                    this.gb = true;
                                 }

                                 this.fK = 0;
                                 return;
                              }
                           }
                        }
                        continue;
                     }
                  } else {
                     this.cT[var4] = false;
                  }

                  if ((var1 == 1 || this.cG[var4] > 0) && this.cV[var4]) {
                     if (this.cF[var4] == -1) {
                        if (this.cG[var4] < 0) {
                           this.cO[var4] = 8;
                        }
                     } else {
                        if (this.cO[var4] >= 8 && this.cG[var4] < 0) {
                           this.cO[var4] = 0;
                        }

                        this.C(var4);
                        if (this.cI[var4] == 1) {
                           if (this.cH[var4] < this.cF[var4]) {
                              int[] var13 = this.cx[var4];
                              var13[0] = (int)((long)var13[0] - ((7498L << this.y) * this.t(this.cC[var4]) >> 16));
                              var13 = this.cx[var4];
                              var13[1] = (int)((long)var13[1] + ((7498L << this.y) * this.u(this.cC[var4]) >> 16));
                              ++this.cH[var4];
                           } else if (this.cH[var4] == this.cF[var4]) {
                              if (this.cG[var4] < 0) {
                                 this.cO[var4] = 8;
                              }

                              ++this.cH[var4];
                           } else {
                              this.cH[var4] = 1;
                              this.cI[var4] = 2;
                              if (this.cG[var4] > 0 && this.selectedMap > 10) {
                                 ++this.ib;
                                 this.ib %= this.v;
                                 if (this.z && this.ib == 1 && this.w == 0) {
                                    this.ib = 5;
                                    this.z = false;
                                    this.v = 8;
                                    this.w = 6;
                                 }

                                 if (this.ib == 0) {
                                    if (this.selectedMap == 12) {
                                       this.cI[var4] = 1;
                                    } else {
                                       this.D(var4);
                                    }
                                 }

                                 this.cC[var4] = this.A[this.selectedMap - 11][this.ib + this.x][0];
                                 this.cF[var4] = (byte)(this.A[this.selectedMap - 11][this.ib + this.x][1] >> this.y);
                                 if (this.x != this.w && this.ib == 5) {
                                    this.ib = -1;
                                    this.x = this.w;
                                 }
                              }
                           }
                        } else if (this.cH[var4] < this.cF[var4]) {
                           int[] var17 = this.cx[var4];
                           var17[0] = (int)((long)var17[0] + ((7498L << this.y) * this.t(this.cC[var4]) >> 16));
                           var17 = this.cx[var4];
                           var17[1] = (int)((long)var17[1] - ((7498L << this.y) * this.u(this.cC[var4]) >> 16));
                           ++this.cH[var4];
                        } else if (this.cH[var4] == this.cF[var4]) {
                           if (this.cG[var4] < 0) {
                              this.cO[var4] = 8;
                           }

                           ++this.cH[var4];
                        } else {
                           this.cH[var4] = 1;
                           this.cI[var4] = 1;
                           if (this.cG[var4] > 0 && this.selectedMap > 10) {
                              ++this.ib;
                              this.ib %= this.v;
                              if (this.z && this.ib == 4 && this.w == 6) {
                                 this.ib = 14;
                                 this.z = false;
                                 this.v = 20;
                                 this.w = 16;
                                 this.x = 0;
                              }

                              this.cC[var4] = this.A[this.selectedMap - 11][this.ib + this.x][0];
                              this.cF[var4] = (byte)(this.A[this.selectedMap - 11][this.ib + this.x][1] >> this.y);
                              if (this.x != this.w && this.ib == 16) {
                                 this.ib = 0;
                                 this.x = this.w;
                                 this.v = 5;
                                 this.cM[var4] = 100;
                                 this.z = false;
                              }
                           }
                        }
                     }
                  }
               } else if (this.fq) {
                  this.cO[var4] = (byte)(this.cG[var4] + 1);
               } else if (this.cO[var4] != (byte)(this.cG[var4] + 1)) {
                  this.cO[var4] = this.cG[var4];
               }
            }
         }
      }

   }

   private void C(int var1) {
      this.cS[var1] = !this.cS[var1];
   }

   private void D(int var1) {
      this.cV[var1] = false;
   }

   private void u() {
      this.fA = new int[5];
      this.fA[0] = 10;
      this.fA[1] = 6;
      this.fA[2] = 4;
      this.fA[3] = 2;
      this.fA[4] = 2;
   }

   private void b(Graphics var1) {
      var1.setColor(85, 0, 0);
      var1.drawRect(this.c[this.fI], -1, 55, 41);
      var1.setColor(175, 0, 0);
      var1.drawRect(this.c[this.fH], -1, 55, 41);
   }

   private void a(Graphics var1, byte var2) {
      label128: {
         c3d_b var10000;
         short var10001;
         if (this.hg == -1) {
            if (var2 == this.fH) {
               var10000 = this;
               var10001 = 125;
            } else {
               var10000 = this;
               var10001 = 35;
            }
         } else {
            long var3;
            long var4;
            if (this.gl - this.go < 187L) {
               var10000 = this;
               var3 = this.gl;
               var4 = this.go;
            } else {
               label142: {
                  long var10003;
                  if (this.gl - this.go >= 187L && this.gl - this.go < 375L) {
                     var10000 = this;
                     var3 = 200L;
                     var4 = this.gl - this.go;
                     var10003 = 187L;
                  } else {
                     if (this.gl - this.go >= 375L && this.gl - this.go < 562L) {
                        var10000 = this;
                        var3 = this.gl - this.go;
                        var4 = 375L;
                        break label142;
                     }

                     if (this.gl - this.go >= 562L && this.gl - this.go < 750L) {
                        var10000 = this;
                        var3 = 200L;
                        var4 = this.gl - this.go;
                        var10003 = 562L;
                     } else {
                        if (this.gl - this.go >= 750L && this.gl - this.go < 937L) {
                           var10000 = this;
                           var3 = this.gl - this.go;
                           var4 = 750L;
                           break label142;
                        }

                        if (this.gl - this.go >= 937L && this.gl - this.go < 1125L) {
                           var10000 = this;
                           var3 = 200L;
                           var4 = this.gl - this.go;
                           var10003 = 937L;
                        } else {
                           if (this.gl - this.go >= 1125L && this.gl - this.go < 1312L) {
                              var10000 = this;
                              var3 = this.gl - this.go;
                              var4 = 1125L;
                              break label142;
                           }

                           if (this.gl - this.go >= 1312L && this.gl - this.go < 1500L) {
                              var10000 = this;
                              var3 = 200L;
                              var4 = this.gl - this.go;
                              var10003 = 1312L;
                           } else {
                              if (this.gl - this.go >= 1500L && this.gl - this.go < 1687L) {
                                 var10000 = this;
                                 var3 = this.gl - this.go;
                                 var4 = 1500L;
                                 break label142;
                              }

                              if (this.gl - this.go >= 1687L && this.gl - this.go < 1875L) {
                                 var10000 = this;
                                 var3 = 200L;
                                 var4 = this.gl - this.go;
                                 var10003 = 1687L;
                              } else {
                                 if (this.gl - this.go >= 1875L && this.gl - this.go < 2062L) {
                                    var10000 = this;
                                    var3 = this.gl - this.go;
                                    var4 = 1875L;
                                    break label142;
                                 }

                                 if (this.gl - this.go >= 2062L && this.gl - this.go < 2250L) {
                                    var10000 = this;
                                    var3 = 200L;
                                    var4 = this.gl - this.go;
                                    var10003 = 2062L;
                                 } else {
                                    if (this.gl - this.go >= 2250L && this.gl - this.go < 2437L) {
                                       var10000 = this;
                                       var3 = this.gl - this.go;
                                       var4 = 2250L;
                                       break label142;
                                    }

                                    if (this.gl - this.go >= 2437L && this.gl - this.go < 2625L) {
                                       var10000 = this;
                                       var3 = 200L;
                                       var4 = this.gl - this.go;
                                       var10003 = 2437L;
                                    } else {
                                       if (this.gl - this.go >= 2625L && this.gl - this.go < 2812L) {
                                          var10000 = this;
                                          var3 = this.gl - this.go;
                                          var4 = 2625L;
                                          break label142;
                                       }

                                       if (this.gl - this.go < 2812L || this.gl - this.go >= 3000L) {
                                          break label128;
                                       }

                                       var10000 = this;
                                       var3 = 200L;
                                       var4 = this.gl - this.go;
                                       var10003 = 2812L;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  var4 -= var10003;
               }
            }

            var10001 = (short)((int)(var3 - var4));
         }

         var10000.hg = var10001;
      }

      var1.setColor(this.hg + 50, 0, 0);
      var1.drawRect(this.c[var2], -1, 55, 41);
      if (this.fW) {
         var1.drawRect(this.c[1], -1, 55, 41);
      }

      if (var2 != this.ho) {
         this.hg = -1;
         this.a(var1, this.ho);
         this.ho = var2;
      }

   }

   private void a(Image var1, int[] var2, int var3, int var4, int var5, int var6, boolean var7) {
      if (var7) {
         int[] var12 = new int[var2.length];
         var1.getRGB(var12, 0, var3, var5, var6, var3, var4);
         int var10 = 0;

         for(int var8 = 0; var8 < var4; ++var8) {
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

      int var14 = var2.length;

      for(int var13 = 0; var13 < var14; ++var13) {
         if (var2[var13] == this.Q) {
            var2[var13] = 0;
         }
      }

   }

   private void a(int var1, int var2, int var3, int var4, Graphics var5) {
      if (this.gh[var2] > var4 || var2 == 2) {
         if (var2 != 2 || this.gh[1] > var4 || this.ii) {
            if (var2 != 2 || this.gh[0] > var4 || !this.ii) {
               label120: {
                  c3d_b var10000;
                  short var10001;
                  if (this.fH == 1) {
                     this.gs = 217 + v(this.I()) % 15;
                     var10000 = this;
                     var10001 = 200;
                  } else {
                     if (this.fH != 0) {
                        break label120;
                     }

                     if (this.fY) {
                        var10000 = this;
                        var10001 = 215;
                     } else {
                        var10000 = this;
                        var10001 = 0;
                     }

                     var10000.gs = var10001 + v(this.I()) % 17;
                     var10000 = this;
                     var10001 = 205;
                  }

                  var10000.gt = var10001 - v(this.I()) % 7;
                  this.gu = v(this.I()) % 3 + 6;
               }

               if (var1 == 0) {
                  var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                  var5.drawRGB(this.gi[var3 + 2], 0, this.gd[var3], 0, 266 - this.gh[var3] + var4, this.gd[var3], this.gh[var3] - var4, true);
                  if (var2 != 0 || var3 != 0) {
                     var5.drawRGB(this.gi[this.gu], 0, this.gd[6], this.gs, this.gt, this.gd[6], this.gh[6], true);
                     return;
                  }
               } else {
                  if (var1 == 1) {
                     if (var2 == 0) {
                        var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                        return;
                     }

                     var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                     var5.drawRGB(this.gi[this.gu], 0, this.gd[6], this.gs, this.gt, this.gd[6], this.gh[6], true);
                     return;
                  }

                  if (var1 == 2) {
                     if (!this.fW) {
                        if (var2 == 0) {
                           if (this.fK != 0 && this.gl - this.iC <= 500L) {
                              var5.drawRGB(this.gi[4], 0, this.gd[4], 240 - this.gd[4], 266 - this.gh[4] + var4, this.gd[4], this.gh[4] - var4, true);
                              return;
                           }

                           var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                           return;
                        }

                        if (this.gl - this.iC > 500L) {
                           var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                           return;
                        }

                        var5.drawRGB(this.gi[4], 0, this.gd[4], 240 - this.gd[4], 266 - this.gh[4] + var4, this.gd[4], this.gh[4] - var4, true);
                        return;
                     }

                     if (var2 == 0 && var3 == 0) {
                        if (this.fK != 0 && this.gl - this.iC <= 500L) {
                           var5.drawRGB(this.gi[4], 0, this.gd[4], 240 - this.gd[4], 266 - this.gh[4] + var4, this.gd[4], this.gh[4] - var4, true);
                           var5.drawRGB(this.gi[var3 + 2], 0, this.gd[var3], 0, 266 - this.gh[var3] + var4 + 4, this.gd[var3], this.gh[var3] - var4 - 4, true);
                           return;
                        }

                        var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                        var5.drawRGB(this.gi[5], 0, this.gd[5], 0, 266 - this.gh[5] + var4 + 4, this.gd[5], this.gh[5] - var4 - 4, true);
                        return;
                     }

                     if (this.gl - this.iC > 500L) {
                        var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                        var5.drawRGB(this.gi[var3 + 2], 0, this.gd[var3], 0, 266 - this.gh[var3] + var4 + 4, this.gd[var3], this.gh[var3] - var4 - 4, true);
                        return;
                     }

                     Graphics var8;
                     int[] var11;
                     byte var12;
                     int var13;
                     int var14;
                     int var15;
                     int var16;
                     int[] var17;
                     int var18;
                     if (var2 == 0) {
                        var8 = var5;
                        var11 = this.gi[var2];
                        var12 = 0;
                        var13 = this.gd[var2];
                        var14 = 240 - this.gd[var2];
                        var15 = 266 - this.gh[var2] + var4;
                        var16 = this.gd[var2];
                        var17 = this.gh;
                        var18 = var2;
                     } else {
                        var8 = var5;
                        var11 = this.gi[4];
                        var12 = 0;
                        var13 = this.gd[4];
                        var14 = 240 - this.gd[4];
                        var15 = 266 - this.gh[4] + var4;
                        var16 = this.gd[4];
                        var17 = this.gh;
                        var18 = 4;
                     }

                     var8.drawRGB(var11, var12, var13, var14, var15, var16, var17[var18] - var4, true);
                     if (var3 == 0) {
                        var5.drawRGB(this.gi[var3 + 2], 0, this.gd[var3], 0, 266 - this.gh[var3] + var4 + 4, this.gd[var3], this.gh[var3] - var4 - 4, true);
                        return;
                     }

                     var5.drawRGB(this.gi[5], 0, this.gd[5], 0, 266 - this.gh[5] + var4 + 4, this.gd[5], this.gh[5] - var4 - 4, true);
                     return;
                  }

                  if (var1 == 3) {
                     if (var2 == 0) {
                        var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2], 266 - this.gh[var2] + var4, this.gd[var2], this.gh[var2] - var4, true);
                        return;
                     }

                     if (var2 == 1) {
                        var5.drawRGB(this.gi[var2], 0, this.gd[var2], 240 - this.gd[var2] + 5, 266 - this.gh[var2] + var4, this.gd[var2] - 5, this.gh[var2] - var4, true);
                        this.fK = 2;
                        this.ii = false;
                        this.gc = true;
                        return;
                     }

                     Graphics var7;
                     int[] var10;
                     byte var10002;
                     int var10003;
                     int var10004;
                     int var10005;
                     int var10006;
                     int[] var10007;
                     byte var10008;
                     if (!this.ii) {
                        var7 = var5;
                        var10 = this.gi[1];
                        var10002 = 0;
                        var10003 = this.gd[1];
                        var10004 = 240 - this.gd[1];
                        var10005 = 266 - this.gh[1] + var4;
                        var10006 = this.gd[1];
                        var10007 = this.gh;
                        var10008 = 1;
                     } else {
                        var7 = var5;
                        var10 = this.gi[0];
                        var10002 = 0;
                        var10003 = this.gd[0];
                        var10004 = 240 - this.gd[0];
                        var10005 = 266 - this.gh[0] + var4;
                        var10006 = this.gd[0];
                        var10007 = this.gh;
                        var10008 = 0;
                     }

                     var7.drawRGB(var10, var10002, var10003, var10004, var10005, var10006, var10007[var10008] - var4, true);
                     this.ar = -1;
                  }
               }

            }
         }
      }
   }

   private void v() {
      this.gf = new int['\uf4b0'];
      this.b("/s" + this.r).getRGB(this.gf, 0, 540, 0, 0, 540, 106);
   }

   private void w() {
      this.gg = new int['움'];

      for(int var2 = 0; var2 < 48960; ++var2) {
         int[] var10000;
         int var10001;
         int var10002;
         if (v(this.I()) % 300 == 0) {
            int var1;
            var1 = (var1 = v(this.I()) % 80 + 75) << 16 | var1 << 8 | var1;
            this.gg[var2] = -var1;
            this.gg[var2 + 240] = -var1;
            this.gg[var2 + 240 + 240] = -var1;
            this.gg[var2 + 240 + 240 + 240] = -var1;
            this.gg[var2 + 960] = -var1;
            this.gg[var2 + 1200] = -var1;
            this.gg[var2 + 1440] = -var1;
            var10000 = this.gg;
            var10001 = var2 + 1680;
            var10002 = -var1;
         } else {
            var10000 = this.gg;
            var10001 = var2;
            var10002 = 0;
         }

         var10000[var10001] = var10002;
      }

   }

   private void x() {
      this.gg = new int['움'];
      this.I();
      int var1 = 0;
      var1 = -11776930;
      int var2;
      int var3 = ((var2 = v(this.I()) % 240) & 7) + 26;
      int var4 = 0;

      for(int var5 = 0; var5 <= var3; ++var5) {
         this.gg[var2 + var4] = var1;
         var4 += 240;
      }

   }

   private void a(Graphics var1, int var2, int var3) {
      var1.drawRGB(this.gg, 0, 240, 0, 54, 240, 212, true);
      int var4;
      var4 = (var4 = v(this.I()) % 80 + 75) << 16 | var4 << 8 | var4;
      boolean var5 = true;
      if (this.hU[2]) {
         var5 = false;

         for(int var6 = 50400; var6 >= var2; var6 -= 240) {
            for(int var7 = 239; var7 >= 120; --var7) {
               int[] var10000;
               int var10001;
               int[] var10002;
               int var10003;
               int var10004;
               if (var7 > 120 + this.gN) {
                  var10000 = this.gg;
                  var10001 = var7 + var6;
                  var10002 = this.gg;
                  var10003 = var7;
                  var10004 = var6;
               } else {
                  var10000 = this.gg;
                  var10001 = var7 + var6;
                  var10002 = this.gg;
                  var10003 = var6 + 240 + var7;
                  var10004 = 120;
               }

               var10000[var10001] = var10002[var10003 + var10004 - this.gN - var2];
            }
         }

         for(int var11 = 50400; var11 >= var2; var11 -= 240) {
            for(int var21 = 0; var21 < 120; ++var21) {
               int[] var27;
               int var30;
               int[] var33;
               int var36;
               if (var21 < 120 - this.gN) {
                  var27 = this.gg;
                  var30 = var21 + var11;
                  var33 = this.gg;
                  var36 = var21 + var11;
               } else {
                  var27 = this.gg;
                  var30 = var21 + var11;
                  var33 = this.gg;
                  var36 = var11 + 240 + var21 - 120;
               }

               var27[var30] = var33[var36 + this.gN - var2];
            }
         }
      } else if (this.hU[8]) {
         var5 = false;

         for(int var12 = 50400; var12 >= var2; var12 -= 240) {
            for(int var22 = 120; var22 >= 0; --var22) {
               int[] var28;
               int var31;
               int[] var34;
               int var37;
               int var39;
               if (var22 > this.gN) {
                  var28 = this.gg;
                  var31 = var22 + var12;
                  var34 = this.gg;
                  var37 = var22;
                  var39 = var12;
               } else {
                  var28 = this.gg;
                  var31 = var22 + var12;
                  var34 = this.gg;
                  var37 = var12 + 240 + var22;
                  var39 = 120;
               }

               var28[var31] = var34[var37 + var39 - this.gN - var2];
            }
         }

         for(int var13 = 50400; var13 >= var2; var13 -= 240) {
            for(int var23 = 121; var23 < 240; ++var23) {
               int[] var29;
               int var32;
               int[] var35;
               int var38;
               if (var23 < 239 - this.gN) {
                  var29 = this.gg;
                  var32 = var23 + var13;
                  var35 = this.gg;
                  var38 = var23 + var13;
               } else {
                  var29 = this.gg;
                  var32 = var23 + var13;
                  var35 = this.gg;
                  var38 = var13 + 240 + var23 - 120;
               }

               var29[var32] = var35[var38 + this.gN - var2];
            }
         }
      }

      if (!this.hU[1] && !this.hU[4]) {
         if (this.hU[3] || this.hU[6]) {
            var5 = false;

            for(int var15 = 50400; var15 >= var2; var15 -= 240) {
               for(int var24 = 0; var24 < 240; ++var24) {
                  this.gg[var24 + var15] = this.gg[var24 + var15 + this.gL - var2];
               }
            }
         }
      } else {
         var5 = false;

         for(int var14 = 50879; var14 >= var2 + this.gL; --var14) {
            this.gg[var14] = this.gg[var14 - this.gL - var2];
         }
      }

      if (this.hU[7]) {
         var5 = false;

         for(int var16 = 50879; var16 >= var2 + this.gN; --var16) {
            this.gg[var16] = this.gg[var16 - this.gN - var2];
         }
      } else if (this.hU[9]) {
         var5 = false;

         for(int var17 = 50400; var17 >= var2; var17 -= 240) {
            for(int var25 = 0; var25 < 240; ++var25) {
               this.gg[var25 + var17] = this.gg[var25 + var17 + this.gN - var2];
            }
         }
      }

      if (var5) {
         for(int var18 = 50879; var18 >= var2; --var18) {
            this.gg[var18] = this.gg[var18 - var2];
         }
      }

      for(int var19 = 0; var19 < var2; ++var19) {
         this.gg[var19] = 0;
      }

      int var20 = 0;
      if (var3 < var2) {
         while(var20 < var2) {
            int var9 = (var20 += v(this.I()) % 600 + var3) & 7;
            int var8 = 0;

            for(int var26 = 0; var26 <= var9; ++var26) {
               this.gg[var20 + var8] = -var4;
               var8 += 240;
            }
         }
      }

   }

   private void a(Graphics var1, int var2) {
      var1.drawRGB(this.gg, 0, 240, 0, 54, 240, 212, true);
      int var3 = -11776930;

      for(int var5 = 50879; var5 >= var2; --var5) {
         this.gg[var5] = this.gg[var5 - var2];
      }

      for(int var9 = 0; var9 < var2; ++var9) {
         this.gg[var9] = 0;
      }

      int var10;
      for(int var10000 = (var2 << 1) - (var2 >> 3) - v(this.I()) % var2; var10000 < var2; var10000 = var10 + var2) {
         int var8 = ((var10 = v(this.I()) % 240) & 7) + 26;
         int var7 = 0;

         for(int var6 = 0; var6 <= var8 >> 2; ++var6) {
            this.gg[var10 + var7] = var3;
            var7 += 240;
         }

         for(int var11 = (var8 >> 2) + (var8 >> 3); var11 <= (var8 >> 1) + (var8 >> 3); ++var11) {
            this.gg[var10 + var7] = var3;
            var7 += 240;
         }

         for(int var12 = (var8 >> 1) + (var8 >> 2); var12 <= var8; ++var12) {
            this.gg[var10 + var7] = var3;
            var7 += 240;
         }
      }

   }

   private void y() {
      this.b("/ff" + this.r);
      int var2 = this.selectedMap != 2 ? 4 : 8;
      this.gj = new int[var2][];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.gj[var3] = new int[480];
      }

      for(int var5 = 0; var5 < var2; ++var5) {
         for(int var4 = 0; var4 < 240; var4 += 2) {
            int[] var10000;
            int var10001;
            int var10002;
            int var10003;
            byte var10004;
            if (this.selectedMap != 2) {
               this.gj[var5][var4 + 1] = -16777216 + ((var5 << 5) + 50 << 8 | 0 | 0);
               var10000 = this.gj[var5];
               var10001 = var4 + 240;
               var10002 = -16777216;
               var10003 = (var5 << 5) + 50;
               var10004 = 8;
            } else {
               this.gj[var5][var4 + 1] = -16777216 + (200 - (var5 << 4) << 16 | 0 | 0);
               this.gj[var5][var4 + 240] = -16777216 + (200 - (var5 << 4) << 16 | 0 | 0);
               if (var5 != 7) {
                  continue;
               }

               this.gj[var5][var4] = -16777216 + (200 - (var5 << 4) << 16 | 0 | 0);
               var10000 = this.gj[var5];
               var10001 = var4 + 240 + 1;
               var10002 = -16777216;
               var10003 = 200 - (var5 << 4);
               var10004 = 16;
            }

            var10000[var10001] = var10002 + (var10003 << var10004 | 0 | 0);
         }
      }

   }

   private void a(int var1, Graphics var2) {
      for(int var3 = 54; var3 < 266; var3 += 2) {
         var2.drawRGB(this.gj[var1], 0, 240, 0, var3, 240, 2, true);
      }

   }

   private void z() {
      if ((this.fO == 53 && this.fK == 1 || this.as != -1) && (this.gb || this.gc)) {
         int var1;
         boolean var2;
         if (this.cl > this.cm && this.ar != -1) {
            var1 = this.cm;
            var2 = false;
         } else {
            var1 = this.cl;
            var2 = true;
            this.bW = this.bY;
            this.bX = this.bZ;
         }

         c3d_b var10000;
         int var10001;
         if (var1 <= 4 - this.fH) {
            var10000 = this;
            var10001 = 0;
         } else {
            var10000 = this;
            var10001 = v(this.I() % (var1 << 1));
         }

         var10000.cp = var10001;
         if (this.cp <= 3 - this.fH || this.fH == 3 || !this.ga || (this.ar < this.gS || this.ar > this.gT) && !var2) {
            if (this.cq != -1 && this.as == -1 && var2 && this.fH != 3 && !this.gc) {
               this.e(var2);
            } else if ((this.ar != -1 || this.as != -1) && (this.fH != 3 && this.gx[this.fH] > 0 || !this.ga)) {
               this.A();
            }

            if (this.fH == 3 && this.ga && !this.gc && this.as == -1) {
               this.e(var2);
               if (this.ar >= this.gS && this.ar <= this.gT) {
                  this.A();
               }

               this.gb = false;
               this.fK = 1;
               this.iG = this.gl;
            }
         }

         this.as = -1;
         this.ga = true;
      }

      this.ar = -1;
      this.cq = -1;
   }

   private void A() {
      if (this.as != -1) {
         this.ar = this.as;
      }

      if (this.ar != -1 && (this.gl - this.iC >= 500L || this.fH != 2)) {
         if (this.ar >= this.gS && this.ar < this.gT) {
            int var1;
            for(int var2 = var1 = this.ar - (this.ar - this.gS) % 4; var2 < var1 + 4; ++var2) {
               this.bS[var2] = 1;
            }

            int var4 = this.ar - this.gS >> 2;
            int var3 = 188 + var4;
            this.cU[var3] = true;
            this.cW[var3] = true;
            if ((this.selectedMap == 1 || this.selectedMap == 2) && !this.ga) {
               ++this.cO[var3];
            }
         }

         if (this.fH != 3 && this.ga && !this.hw) {
            this.cx[65][0] = (int)this.ca;
            this.cx[65][1] = (int)this.cb;
            byte[] var5;
            byte var10001;
            byte var10002;
            if (this.cO[65] != 29) {
               var5 = this.cO;
               var10001 = 65;
               var10002 = (byte)(var5[65] + 1);
            } else {
               var5 = this.cO;
               var10001 = 65;
               var10002 = 28;
            }

            var5[var10001] = var10002;
         }

      }
   }

   private void e(boolean var1) {
      if (this.cq == 19 && this.selectedMap == 11) {
         this.cV[this.cq] = true;
      }

      if (this.cq != -1 && var1 && (this.cq != 19 || this.selectedMap != 11) && (this.fH != 2 || this.gl - this.iC > 500L)) {
         this.cU[this.cq] = true;
         if (this.fH == 3) {
            this.b(this.cq, this.cX << 3, this.gJ);
         }

         if (this.fH != 3 && this.ga && !this.hw && (this.selectedMap != 2 && this.selectedMap != 3 && this.selectedMap != 4 && this.selectedMap != 5 || this.cG[this.cq] != 30)) {
            this.cx[64][0] = this.cx[this.cq][0];
            this.cx[64][1] = this.cx[this.cq][1];
            byte[] var10000;
            byte var10001;
            byte var10002;
            if (this.cO[64] != 27) {
               var10000 = this.cO;
               var10001 = 64;
               var10002 = (byte)(var10000[64] + 1);
            } else {
               var10000 = this.cO;
               var10001 = 64;
               var10002 = 26;
            }

            var10000[var10001] = var10002;
         }
      }

   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      for(int var13 = 0; var13 < this.gH; ++var13) {
         if (this.cU[var13] && this.cG[var13] >= var4 && this.cG[var13] <= var5) {
            label255: {
               byte[] var10000;
               int var10001;
               byte var10002;
               if (this.fH != 3 && this.fH != 2) {
                  if (this.cG[var13] < 0) {
                     var10000 = this.cM;
                     var10001 = var13;
                     var10002 = (byte)(var10000[var13] - v(this.cG[var13]) * (this.fH + 1));
                  } else if (this.cG[var13] != 30 || this.selectedMap != 4 && this.selectedMap != 5) {
                     if (this.cG[var13] != 30 || this.selectedMap != 6 && this.selectedMap != 7 && this.selectedMap != 11) {
                        if (this.cG[var13] != 30 || this.selectedMap != 12) {
                           break label255;
                        }

                        int var21;
                        byte var22;
                        if (!this.fW) {
                           var10000 = this.cM;
                           var10001 = var13;
                           var10002 = var10000[var13];
                           var21 = this.fH + 1;
                           var22 = 1;
                        } else {
                           var10000 = this.cM;
                           var10001 = var13;
                           var10002 = var10000[var13];
                           var21 = this.fH + 1;
                           var22 = 2;
                        }

                        var10000[var10001] = (byte)(var10002 - (var21 << var22));
                        if (this.cM[var13] > 0 || this.x >= 10) {
                           break label255;
                        }

                        this.z = true;
                        var10000 = this.cM;
                        var10001 = var13;
                        var10002 = 100;
                     } else {
                        var10000 = this.cM;
                        var10001 = var13;
                        var10002 = (byte)(var10000[var13] - 35 * (this.fH + 1));
                     }
                  } else {
                     var10000 = this.cM;
                     var10001 = var13;
                     var10002 = (byte)(var10000[var13] - 12 * (this.fH + 1));
                  }
               } else if (this.fH == 2) {
                  if (this.cG[var13] < 0) {
                     if (!this.fW) {
                        var10000 = this.cM;
                        var10001 = var13;
                        var10002 = (byte)(var10000[var13] - v(this.cG[var13]) * (this.fH + 2));
                     } else {
                        var10000 = this.cM;
                        var10001 = var13;
                        var10002 = (byte)(var10000[var13] - (v(this.cG[var13]) * (this.fH + 1) << 1));
                     }
                  } else if (this.cG[var13] != 30 || this.selectedMap != 4 && this.selectedMap != 5) {
                     if (this.cG[var13] != 30 || this.selectedMap != 6 && this.selectedMap != 7 && this.selectedMap != 11) {
                        if (this.cG[var13] != 30 || this.selectedMap != 12) {
                           break label255;
                        }

                        int var10003;
                        byte var10004;
                        if (!this.fW) {
                           var10000 = this.cM;
                           var10001 = var13;
                           var10002 = var10000[var13];
                           var10003 = this.fH + 2;
                           var10004 = 1;
                        } else {
                           var10000 = this.cM;
                           var10001 = var13;
                           var10002 = var10000[var13];
                           var10003 = this.fH + 2;
                           var10004 = 2;
                        }

                        var10000[var10001] = (byte)(var10002 - (var10003 << var10004));
                        if (this.cM[var13] > 0 || this.x >= 10) {
                           break label255;
                        }

                        this.z = true;
                        var10000 = this.cM;
                        var10001 = var13;
                        var10002 = 100;
                     } else {
                        var10000 = this.cM;
                        var10001 = var13;
                        var10002 = (byte)(var10000[var13] - 35 * (this.fH + 1));
                     }
                  } else {
                     var10000 = this.cM;
                     var10001 = var13;
                     var10002 = (byte)(var10000[var13] - 12 * (this.fH + 2));
                  }
               } else {
                  var10000 = this.cM;
                  var10001 = var13;
                  var10002 = 0;
               }

               var10000[var10001] = var10002;
            }

            if (this.cM[var13] > 0) {
               this.cU[var13] = false;
               if (this.selectedMap != 12) {
                  this.cF[var13] = -1;
               }

               if (this.I() % 3 == 0 && this.cG[var13] < 0) {
                  this.cO[var13] = 10;
               }

               return;
            }

            if (this.cM[var13] <= 0) {
               this.cM[var13] = 0;
               if ((this.selectedMap == 2 && (this.cO[5] == 40 || this.cO[5] == 27) || this.selectedMap == 6 && (this.cO[11] == 40 || this.cO[11] == 27) || this.selectedMap == 7 && (this.cO[15] == 27 || this.cO[15] == 44) && (this.cO[16] == 27 || this.cO[16] == 44) && (this.cO[17] == 27 || this.cO[17] == 44)) && this.fR == 0) {
                  this.fR = 1;
               }

               if (this.cO[var13] >= var1 && this.cO[var13] <= var12 && this.cO[var13] != var6 && this.cO[var13] != var7 && this.cO[var13] != var8 && this.cO[var13] != var9 && this.cO[var13] != var10 && this.cO[var13] != var11) {
                  this.cO[var13] = (byte)var2;
               } else if (this.cO[var13] >= var2 && this.cO[var13] < var3 && this.cO[var13] != var6 && this.cO[var13] != var7 && this.cO[var13] != var8 && this.cO[var13] != var9 && this.cO[var13] != var10 && this.cO[var13] != var11) {
                  ++this.cO[var13];
                  this.hx = true;
                  this.cx[64][0] = 0;
                  this.cx[64][1] = 0;
                  if (this.cO[var13] == var3) {
                     this.fQ = this.I();
                  }
               } else if (this.cO[var13] == var3 && this.selectedMap == 12 && var13 == 19) {
                  if (!this.hD) {
                     this.iE = this.gl;
                  }

                  this.hD = true;
                  this.jL = 13;
                  this.ac();
               }

               if (this.cD[var13] != 255) {
                  this.dW[this.cD[var13]] = this.hp;
               }
            }
         }
      }

   }

   private void B() {
      for(int var1 = 188; var1 < 188 + this.gQ; ++var1) {
         if (this.cU[var1]) {
            byte[] var10000;
            int var10001;
            byte var10002;
            if (this.cO[var1] < this.dm + 1) {
               var10000 = this.cO;
               var10001 = var1;
               var10002 = (byte)(var10000[var1] + 1);
            } else {
               var10000 = this.cO;
               var10001 = var1;
               var10002 = this.cJ[var1];
            }

            var10000[var10001] = var10002;
         }
      }

   }

   private void C() {
      if ((this.hU[0] || this.fJ < 5) && this.selectedMap != 12) {
         if (this.fS) {
            return;
         }

         if (this.fJ < 5) {
            ++this.fJ;
         }

         if (this.fJ == 5) {
            this.fJ = 6;
            return;
         }

         c3d_b var10000;
         int var10001;
         byte var10002;
         if (this.fU) {
            var10000 = this;
            var10001 = this.fH + 1;
            var10002 = 4;
         } else {
            var10000 = this;
            var10001 = this.fH + 1;
            var10002 = 3;
         }

         var10000.fC = var10001 % var10002;
         this.fL = 0;
         this.fN = -1;
         this.fS = true;
         if (this.gx[this.fH] <= 0) {
            this.hU[0] = false;
            return;
         }
      } else if (this.hY == -10000 && !this.fS) {
         this.fL = 0;
         this.fN = -1;
      }

   }

   private void b(int var1, int var2, int var3) {
      ++this.fN;
      if (this.fN < var2) {
         this.fL += var1 * 2;
      } else if (this.fN < var3) {
         this.fL -= var1 * 2;
      } else {
         if (this.fN == var3) {
            this.fL -= var1 * 2;
            this.fN = -1;
         }

      }
   }

   private void D() {
      if (this.gx[this.fH] <= 0) {
         this.gx[this.fH] = 0;
         this.hX = -10000;
         this.hU[5] = false;
         if (this.selectedMap != 12) {
            boolean[] var1;
            byte var2;
            boolean var4;
            if (!this.fS) {
               var1 = this.hU;
               var2 = 0;
               var4 = true;
            } else {
               var1 = this.hU;
               var2 = 0;
               var4 = false;
            }

            var1[var2] = var4;
         }

      } else {
         if (this.fK != 2) {
            this.fK = 1 - this.fK;
         }

         if (this.fK == 1 && this.fO == 53) {
            if (this.fH != 3) {
               if (this.fH != 2 || this.gl - this.iC > 500L) {
                  int var3;
                  int[] var10000;
                  int var10001;
                  int var10003;
                  if (!this.fW) {
                     var10000 = this.gx;
                     var10001 = this.fH;
                     var3 = var10000[var10001];
                     var10003 = 1 + this.fH;
                  } else {
                     var10000 = this.gx;
                     var10001 = this.fH;
                     var3 = var10000[var10001];
                     var10003 = 1 + this.fH << 1;
                  }

                  var10000[var10001] = var3 - var10003;
                  if (!this.hA) {
                     this.F(15 + this.fH);
                  }

                  if (this.hz) {
                     this.a(100);
                  }
               }
            } else {
               int var10002 = this.gx[this.fH]--;
               if (!this.hA) {
                  this.F(15 + this.fH);
               }
            }

            if (this.gx[this.fH] <= 0) {
               this.gx[this.fH] = 0;
               this.hX = -10000;
               this.hU[5] = false;
            }
         }

      }
   }

   private void E() {
      if (this.fS) {
         this.b(10, 4, 7);
         if (this.fN == 4) {
            this.fI = this.fH;
            this.fH = this.fC;
            this.gb = true;
            if (this.fH == 0) {
               this.ia = 0;
               this.ii = false;
               this.fK = 0;
            }

            this.fT = true;
            return;
         }

         if (this.fN == -1) {
            this.fS = false;
         }
      }

   }

   private void F() {
      for(int var1 = 25313; var1 < 25315; ++var1) {
         this.bG[var1] = 16777215;
         this.bG[var1 + 11] = 16777215;
      }

      for(int var11 = 23879; var11 < 24359; var11 += 240) {
         this.bG[var11] = 16777215;
         this.bG[var11 + 2640] = 16777215;
      }

   }

   private void G() {
      char var2 = '\u0000';

      for(int var1 = 0; var1 < 480; ++var1) {
         this.bG[var1] = 10616832;
         this.bG[var1 + 240] = 6619136;
         this.bG[var1 + 240 + 240] = 3932160;
         this.bG[var1 + 240 + 240 + 240] = 2621440;
         this.bG['욿' - var1] = 10616832;
         this.bG['욿' - var1 - 240] = 6619136;
         this.bG['욿' - var1 - 240 - 240] = 3932160;
         this.bG['욿' - var1 - 240 - 240 - 240] = 2621440;
      }

      var2 = '욿';

      for(int var3 = 0; var3 < var2; var3 += 240) {
         this.bG[var3] = 10616832;
         if (var3 > 0 && var3 < var2 - 240) {
            this.bG[var3 + 1] = 6619136;
         }

         if (var3 > 240 && var3 < var2 - 240 - 240) {
            this.bG[var3 + 2] = 3932160;
         }

         if (var3 > 480 && var3 < var2 - 240 - 240 - 240) {
            this.bG[var3 + 3] = 2621440;
         }

         this.bG[var3 + 239] = 10616832;
         if (var3 > 0 && var3 < var2 - 240) {
            this.bG[var3 + 238] = 6619136;
         }

         if (var3 > 240 && var3 < var2 - 240 - 240) {
            this.bG[var3 + 239 - 2] = 3932160;
         }

         if (var3 > 480 && var3 < var2 - 240 - 240 - 240) {
            this.bG[var3 + 239 - 3] = 2621440;
         }
      }

   }

   private void H() {
      if (this.o == null) {
         this.readMetadata();
      }

      this.S();
      if (this.jo == null) {
         this.R();
      }

   }

   private static void c(Graphics var0) {
      var0.setColor(0, 0, 0);
      var0.fillRect(0, 0, 240, 320);
   }

   private int I() {
      return this.fg.nextInt();
   }

   private void E(int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         short var3 = this.cR[this.hh][var2];
         if (this.cW[var3] && (this.cO[var3] == this.hj || this.cs) && (this.bN[this.cO[var3]] != 2 || !this.n(var3) || a((long)this.cx[var3][0] - this.gv) >> 16 < 6L && a((long)this.cx[var3][1] - this.gw) >> 16 < 6L)) {
            this.o(var3);
         }
      }

      c3d_b var10000;
      byte var10001;
      if (this.fH == 0) {
         var10000 = this;
         var10001 = 5;
      } else if (this.fH == 1) {
         var10000 = this;
         var10001 = 5;
      } else if (this.fH == 2) {
         var10000 = this;
         var10001 = 7;
      } else {
         var10000 = this;
         var10001 = 30;
      }

      var10000.fP = var10001;
      this.cn = 0;
      this.k();
   }

   private void a(int var1, int var2, Graphics var3) {
      int var4 = var1;

      for(int var5 = 0; var5 < 3; ++var5) {
         var3.drawRGB(this.jp, 0, 15, var2 + 15 * var5, 286, 15, 14, false);
      }

      for(int var7 = 2; var4 != 0; --var7) {
         int var6 = var4 % 10;
         var3.drawRGB(this.jp, var6 * 15 * 14, 15, var2 + 15 * var7, 286, 15, 14, false);
         var4 /= 10;
      }

   }

   private void J() {
      label118: {
         c3d_b var10000;
         label133: {
            this.F(14);
            if (!this.ft && !this.fu && !this.fw) {
               this.hL = new short[240];
               this.hO = new byte[240];
               this.hJ = new int[8];
               this.ic = 5;
               if (!this.fz) {
                  for(int var9 = 0; var9 < 4; ++var9) {
                     for(int var12 = 0; var12 < 2; ++var12) {
                        this.hJ[2 * var9 + var12] = 10616832;
                     }
                  }
               } else {
                  for(int var8 = 0; var8 < 4; ++var8) {
                     for(int var11 = 0; var11 < 2; ++var11) {
                        this.hJ[2 * var8 + var11] = 41472;
                     }
                  }
               }

               for(int var10 = 0; var10 < 240; var10 += 2) {
                  this.hL[var10] = (short)(-(v(this.I()) % 60));
                  this.hO[var10] = (byte)v(this.I() % 2);
               }

               this.hL[0] = 0;
            } else {
               if (this.ft) {
                  this.hS = 30;
                  this.ic = 100;
                  this.hJ = new int[2438];
                  this.b("/k" + this.r).getRGB(this.hJ, 0, 106, 0, 0, 106, 23);
                  int var4 = this.hJ.length;

                  for(int var7 = 0; var7 < var4; ++var7) {
                     if (this.hJ[var7] == this.Q) {
                        this.hJ[var7] = 0;
                     }
                  }

                  var10000 = this;
                  break label133;
               }

               if (this.fu) {
                  this.hS = 63;
               } else {
                  if (!this.fw) {
                     break label118;
                  }

                  this.hS = 144;
                  this.ic = 100;
                  int[] var3 = new int[576];
                  this.hJ = new int[9216];
                  this.b("/dd" + this.r).getRGB(var3, 0, 16, 94, 192, 16, 36);
                  int var5 = var3.length;

                  for(int var1 = 0; var1 < var5; ++var1) {
                     if (var3[var1] == this.Q) {
                        var3[var1] = 0;
                     }
                  }

                  for(int var6 = 0; var6 < 64; ++var6) {
                     for(int var2 = 0; var2 < 9216; var2 += 64) {
                        this.hJ[var6 + var2] = var3[(var6 >> 2) + (var2 >> 8 << 4)];
                     }
                  }
               }
            }

            var10000 = this;
         }

         var10000.fy = true;
         this.hT = false;
      }

      this.iF = this.gl;
   }

   private void d(Graphics var1) {
      if (!this.ft && !this.fu && !this.fw && !this.hT) {
         for(int var2 = 0; var2 < 240; var2 += 2) {
            Graphics var10000;
            int[] var10001;
            byte var10002;
            byte var10003;
            int var10004;
            short var10005;
            byte var10006;
            int var10007;
            label77: {
               if (this.hO[var2] == 1) {
                  if (this.hL[var2] >= -3 && this.hL[var2] <= -1) {
                     var10000 = var1;
                     var10001 = this.hJ;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = 0;
                     var10006 = 2;
                     var10007 = 4 + this.hL[var2];
                     break label77;
                  }

                  if (this.hL[var2] >= 0 && this.hL[var2] <= this.hR - 1 - 4) {
                     var10000 = var1;
                     var10001 = this.hJ;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = this.hL[var2];
                     var10006 = 2;
                     var10007 = 4;
                     break label77;
                  }

                  if (this.hL[var2] < this.hR - 1 - 3 || this.hL[var2] >= this.hR) {
                     continue;
                  }
               } else {
                  if (this.hL[var2] >= -1 && this.hL[var2] <= -1) {
                     var10000 = var1;
                     var10001 = this.hJ;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = 0;
                     var10006 = 2;
                     var10007 = 2 + this.hL[var2];
                     break label77;
                  }

                  if (this.hL[var2] >= 0 && this.hL[var2] <= this.hR - 1 - 2) {
                     var10000 = var1;
                     var10001 = this.hJ;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = this.hL[var2];
                     var10006 = 2;
                     var10007 = 2;
                     break label77;
                  }

                  if (this.hL[var2] < this.hR - 1 - 1 || this.hL[var2] >= this.hR) {
                     continue;
                  }
               }

               var10000 = var1;
               var10001 = this.hJ;
               var10002 = 0;
               var10003 = 2;
               var10004 = var2;
               var10005 = this.hL[var2];
               var10006 = 2;
               var10007 = this.hR - this.hL[var2];
            }

            var10000.drawRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007, false);
         }

      } else {
         if (this.ft) {
            if (this.hS <= 23) {
               var1.drawRGB(this.hJ, 0, 106, 52, 235, 106, 23 - this.hS, true);
               return;
            }
         } else {
            if (this.fu) {
               if (this.hS >> 3 >= 0) {
                  this.a(7 - (this.hS >> 3), var1);
                  return;
               }

               this.fu = false;
            } else {
               if (!this.fw) {
                  return;
               }

               if (this.hS >= 0) {
                  var1.drawRGB(this.hJ, 0, 64, 0, 122 + this.hS, 64, 144 - this.hS, true);
                  if (122 + this.hS + 80 < 212) {
                     var1.drawRGB(this.hJ, 0, 64, 88, 122 + this.hS + 80, 64, 144 - this.hS - 80, true);
                  }

                  if (122 + this.hS + 40 < 212) {
                     var1.drawRGB(this.hJ, 0, 64, 176, 122 + this.hS + 40, 64, 144 - this.hS - 40, true);
                     return;
                  }

                  return;
               }

               this.fw = false;
            }

            this.fz = false;
            this.J();
         }

      }
   }

   private void K() {
      if (!this.ft && !this.fu && !this.fw) {
         if (!this.hT) {
            boolean var2 = true;

            for(int var1 = 0; var1 < 240; var1 += 2) {
               if (this.hL[var1] >= 0 && this.hL[var1] < this.hR) {
                  var2 = false;
               }

               short[] var3;
               int var4;
               short var5;
               byte var10003;
               if (this.hO[var1] == 1) {
                  var3 = this.hL;
                  var4 = var1;
                  var5 = var3[var1];
                  var10003 = 4;
               } else {
                  if (this.hO[var1] != 0) {
                     continue;
                  }

                  var3 = this.hL;
                  var4 = var1;
                  var5 = var3[var1];
                  var10003 = 2;
               }

               var3[var4] = (short)(var5 + var10003);
            }

            if (var2) {
               this.hT = true;
               this.fx = false;
            }

         }
      } else {
         c3d_b var10000;
         int var10001;
         byte var10002;
         if (this.ft) {
            var10000 = this;
            var10001 = this.hS;
            var10002 = 1;
         } else {
            var10000 = this;
            var10001 = this.hS;
            var10002 = 48;
         }

         var10000.hS = var10001 - var10002;
         if (this.hS == -1 && this.ft) {
            this.hT = true;
            this.ft = false;
         }

      }
   }

   private void L() {
      boolean var1 = true;
      if (v(this.I()) % 3 != 0) {
         var1 = false;
      }

      for(int var2 = 42; var2 < 42 + this.gI; ++var2) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (this.cU[var2]) {
            var10000 = this.cO;
            var10001 = var2;
            var10002 = this.hl;
         } else if (this.cG[var2] == -1) {
            if (!var1) {
               continue;
            }

            if (this.cO[var2] == this.hj) {
               var10000 = this.cO;
               var10001 = var2;
               var10002 = this.hk;
            } else {
               var10000 = this.cO;
               var10001 = var2;
               var10002 = this.hj;
            }
         } else if (this.cG[var2] == -2) {
            if (!var1) {
               continue;
            }

            var10000 = this.cO;
            var10001 = var2;
            var10002 = this.hk;
         } else {
            if (this.cG[var2] == 127 || !var1) {
               continue;
            }

            if (this.cO[var2] == this.hj) {
               this.cO[var2] = this.hk;
               var10000 = this.cP;
               var10001 = this.cG[var2];
               var10002 = 1;
            } else {
               this.cO[var2] = this.hj;
               var10000 = this.cP;
               var10001 = this.cG[var2];
               var10002 = 0;
            }
         }

         var10000[var10001] = var10002;
      }

   }

   private void M() {
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

   private void N() {
      if (this.fJ > 4 || this.gY != 3) {
         if (this.hY < 0) {
            this.hY = this.getGameAction(this.hY);
         }

         label117: {
            c3d_b var10000;
            byte var10001;
            if (this.hY == 1) {
               var10000 = this;
               var10001 = 50;
            } else if (this.hY == 6) {
               var10000 = this;
               var10001 = 56;
            } else if (this.hY == 2) {
               var10000 = this;
               var10001 = 52;
            } else if (this.hY == 5) {
               var10000 = this;
               var10001 = 54;
            } else {
               if (this.hY != 8) {
                  break label117;
               }

               var10000 = this;
               var10001 = 53;
            }

            var10000.hY = var10001;
         }

         if (this.gY == 3 && !this.hr && !this.hB) {
            if (this.hY == 48) {
               this.hU[0] = true;
            }

            if (this.hY == 49) {
               this.hU[1] = true;
            }

            if (this.hY == 50) {
               this.hU[2] = true;
            }

            if (this.hY == 51) {
               this.hU[3] = true;
            }

            if (this.hY == 52) {
               this.hU[4] = true;
            }

            if (this.hY == 53) {
               this.hU[5] = true;
               this.iC = this.gl;
            }

            if (this.hY == 54) {
               this.hU[6] = true;
            }

            if (this.hY == 55) {
               this.hU[7] = true;
            }

            if (this.hY == 56) {
               this.hU[8] = true;
            }

            if (this.hY == 57) {
               this.hU[9] = true;
            }
         }

         this.hX = this.hY;
         if (this.gY == 3) {
            if (this.hU[4] || this.hU[6]) {
               this.gL = this.gO;
               this.gm = this.gl;
            }

            if (this.fS) {
               this.hU[0] = false;
            }

            if (this.hU[5]) {
               if (this.gx[this.fH] <= 0) {
                  this.hU[5] = false;
               }

               c3d_b var1;
               boolean var2;
               if (this.I() % 2 == 0) {
                  var1 = this;
                  var2 = true;
               } else {
                  var1 = this;
                  var2 = false;
               }

               var1.fY = var2;
            }

            if (this.hY == 42) {
               this.hy = !this.hy;
               if (this.hy) {
                  this.jw[4] = 209;
                  this.jx[4] = 25;
                  return;
               }

               this.jw[4] = 211;
               this.jx[4] = 26;
               return;
            }
         } else {
            this.V();
         }

      }
   }

   private void O() {
      this.L();
      c3d_b var10000;
      int var10001;
      if (this.gX != 3) {
         var10000 = this;
         var10001 = this.gX + 1;
      } else {
         var10000 = this;
         var10001 = 0;
      }

      var10000.gX = var10001;
      this.B(this.gX % 2);
      if (this.selectedMap == 2 && !this.hr) {
         for(int var1 = 104; var1 < 107; ++var1) {
            int[] var2 = this.cx[var1];
            var2[0] = (int)((long)var2[0] + this.hW[var1 - 104]);
            ++this.hV[var1 - 104];
            if (this.hV[var1 - 104] == 25) {
               this.hW[var1 - 104] = -this.hW[var1 - 104];
               this.hV[var1 - 104] = 0;
            }

            if (a(this.gv - (long)this.cx[var1][0]) < 30000L && a(this.gw - (long)this.cx[var1][1]) < 30000L) {
               this.fu = true;
               this.cx[var1][0] = (int)(this.gv + (10000L * this.S >> 16));
               this.cx[var1][1] = (int)(this.gw + (10000L * this.T >> 16));
            }
         }

         if (v(this.cx[0][0] - this.cx[104][0]) < 20000 && v(this.cx[0][1] - this.cx[104][1]) < 20000) {
            this.cU[0] = true;
            this.cM[0] = 0;
         }

         if (v(this.cx[1][0] - this.cx[106][0]) < 20000 && v(this.cx[1][1] - this.cx[106][1]) < 20000) {
            this.cU[1] = true;
            this.cM[1] = 0;
         }

         if (v(this.cx[10][0] - this.cx[148][0]) < 5000 && v(this.cx[10][1] - this.cx[148][1]) < 5000) {
            label243: {
               this.cF[10] = -1;
               byte[] var7;
               byte var10002;
               if (!this.cU[10]) {
                  ++this.cO[147];
                  ++this.cO[148];
                  ++this.cO[149];
                  if (this.cO[148] != 56) {
                     break label243;
                  }

                  this.cU[10] = true;
                  var7 = this.cM;
                  var10001 = 10;
                  var10002 = 0;
               } else {
                  if (this.cO[148] <= 54) {
                     break label243;
                  }

                  --this.cO[147];
                  --this.cO[148];
                  var7 = this.cO;
                  var10001 = 149;
                  var10002 = (byte)(var7[149] - 1);
               }

               var7[var10001] = var10002;
            }
         }

         if (v(this.cx[9][0] - this.cx[138][0]) < 5000 && v(this.cx[9][1] - this.cx[138][1]) < 5000) {
            label245: {
               this.cF[9] = -1;
               byte[] var13;
               byte var31;
               if (!this.cU[9]) {
                  ++this.cO[138];
                  ++this.cO[139];
                  ++this.cO[140];
                  if (this.cO[138] != 56) {
                     break label245;
                  }

                  this.cU[9] = true;
                  var13 = this.cM;
                  var10001 = 9;
                  var31 = 0;
               } else {
                  if (this.cO[138] <= 54) {
                     break label245;
                  }

                  --this.cO[138];
                  --this.cO[139];
                  var13 = this.cO;
                  var10001 = 140;
                  var31 = (byte)(var13[140] - 1);
               }

               var13[var10001] = var31;
            }
         }

         if (v(this.cx[11][0] - this.cx[151][0]) < 5000 && v(this.cx[11][1] - this.cx[151][1]) < 5000) {
            label193: {
               this.cF[11] = -1;
               byte[] var19;
               byte var32;
               if (!this.cU[11]) {
                  ++this.cO[150];
                  ++this.cO[151];
                  ++this.cO[152];
                  if (this.cO[151] != 56) {
                     break label193;
                  }

                  this.cU[11] = true;
                  var19 = this.cM;
                  var10001 = 11;
                  var32 = 0;
               } else {
                  if (this.cO[151] <= 54) {
                     break label193;
                  }

                  --this.cO[150];
                  --this.cO[151];
                  var19 = this.cO;
                  var10001 = 152;
                  var32 = (byte)(var19[152] - 1);
               }

               var19[var10001] = var32;
            }
         }
      }

      if (!this.fy) {
         label249: {
            byte var33;
            byte var10003;
            byte var10004;
            byte var10005;
            byte var10006;
            if ((this.fQ & 1) != 0 && this.fH != 3) {
               var10000 = this;
               var10001 = 0;
               var33 = 13;
               var10003 = 15;
               var10004 = -100;
               var10005 = 0;
               var10006 = 12;
            } else {
               var10000 = this;
               var10001 = 0;
               var33 = 10;
               var10003 = 12;
               var10004 = -100;
               var10005 = 0;
               var10006 = 26;
            }

            var10000.a(var10001, var33, var10003, var10004, var10005, var10006, 33, -1, -1, -1, -1, 9);
            byte var10007;
            byte var10008;
            byte var10009;
            byte var10010;
            byte var10011;
            byte var10012;
            if (this.selectedMap != 2 && this.selectedMap != 3) {
               label252: {
                  if (this.selectedMap == 6) {
                     var10000 = this;
                     var10001 = 30;
                     var33 = 33;
                     var10003 = 34;
                  } else {
                     if (this.selectedMap == 8) {
                        var10000 = this;
                        var10001 = 36;
                        var33 = 38;
                        var10003 = 39;
                        var10004 = 1;
                        var10005 = 100;
                        var10006 = 41;
                        var10007 = -1;
                        var10008 = -1;
                        var10009 = -1;
                        var10010 = -1;
                        var10011 = -1;
                        var10012 = 37;
                        break label252;
                     }

                     if (this.selectedMap == 7) {
                        if ((this.fQ & 3) != 0) {
                           var10000 = this;
                           var10001 = 30;
                           var33 = 33;
                           var10003 = 34;
                        } else {
                           var10000 = this;
                           var10001 = 30;
                           var33 = 41;
                           var10003 = 42;
                        }

                        var10000.a(var10001, var33, var10003, 1, 100, 41, -1, -1, -1, -1, -1, 32);
                        var10000 = this;
                        var10001 = 39;
                        var33 = 41;
                        var10003 = 42;
                        var10004 = 1;
                        var10005 = 100;
                        var10006 = 34;
                        var10007 = -1;
                        var10008 = -1;
                        var10009 = -1;
                        var10010 = -1;
                        var10011 = -1;
                        var10012 = 40;
                        break label252;
                     }

                     if (this.selectedMap == 4 || this.selectedMap == 5) {
                        this.a(30, 35, 38, 1, 100, 27, -1, -1, -1, -1, -1, 34);
                        if ((this.fQ & 3) != 0) {
                           var10000 = this;
                           var10001 = 39;
                           var33 = 41;
                           var10003 = 42;
                           var10004 = 1;
                           var10005 = 100;
                           var10006 = 27;
                           var10007 = -1;
                           var10008 = -1;
                           var10009 = -1;
                           var10010 = -1;
                           var10011 = -1;
                           var10012 = 40;
                        } else {
                           var10000 = this;
                           var10001 = 39;
                           var33 = 36;
                           var10003 = 38;
                           var10004 = 1;
                           var10005 = 100;
                           var10006 = 27;
                           var10007 = -1;
                           var10008 = -1;
                           var10009 = -1;
                           var10010 = -1;
                           var10011 = -1;
                           var10012 = 40;
                        }
                        break label252;
                     }

                     if (this.selectedMap == 10) {
                        var10000 = this;
                        var10001 = 36;
                        var33 = 38;
                        var10003 = 39;
                        var10004 = 1;
                        var10005 = 100;
                        var10006 = 41;
                        var10007 = -1;
                        var10008 = -1;
                        var10009 = -1;
                        var10010 = -1;
                        var10011 = -1;
                        var10012 = 37;
                        break label252;
                     }

                     if (this.selectedMap == 11) {
                        this.a(30, 33, 34, 1, 100, 41, -1, -1, -1, -1, -1, 32);
                        var10000 = this;
                        var10001 = 43;
                        var33 = 45;
                        var10003 = 46;
                        var10004 = 1;
                        var10005 = 100;
                        var10006 = 34;
                        var10007 = -1;
                        var10008 = -1;
                        var10009 = -1;
                        var10010 = -1;
                        var10011 = -1;
                        var10012 = 44;
                        break label252;
                     }

                     if (this.selectedMap != 12) {
                        break label249;
                     }

                     var10000 = this;
                     var10001 = 30;
                     var33 = 33;
                     var10003 = 33;
                  }

                  var10004 = 1;
                  var10005 = 100;
                  var10006 = 41;
                  var10007 = -1;
                  var10008 = -1;
                  var10009 = -1;
                  var10010 = -1;
                  var10011 = -1;
                  var10012 = 32;
               }
            } else {
               this.a(30, 38, 39, 1, 100, 41, -1, -1, -1, -1, -1, 33);
               var10000 = this;
               var10001 = 34;
               var33 = 40;
               var10003 = 41;
               var10004 = 1;
               var10005 = 100;
               var10006 = 39;
               var10007 = -1;
               var10008 = -1;
               var10009 = -1;
               var10010 = -1;
               var10011 = -1;
               var10012 = 37;
            }

            var10000.a(var10001, var33, var10003, var10004, var10005, var10006, var10007, var10008, var10009, var10010, var10011, var10012);
         }
      }

      if (this.selectedMap == 1) {
         if (a(this.gv - (long)this.cx[99][0]) <= 131072L && this.ib == 1 && a(this.gw - (long)this.cx[99][1]) <= 131072L && this.ib == 1) {
            this.cx[99][0] = 753664;
            this.cx[99][1] = 1245184;
            this.ib = 2;
         }

         if (a(this.gv - (long)this.cx[99][0]) <= 131072L && this.ib == 2 && a(this.gw - (long)this.cx[99][1]) <= 131072L && this.ib == 2) {
            this.cx[99][0] = 1835008;
            this.cx[99][1] = 1474560;
            this.ib = 3;
         }

         if (a(this.gv - (long)this.cx[99][0]) <= 131072L && this.ib == 3 && a(this.gw - (long)this.cx[99][1]) <= 131072L && this.ib == 3) {
            this.cx[99][0] = 1409024;
            this.cx[99][1] = 1277952;
            this.ib = 4;
         }

         if (a(this.gv - (long)this.cx[99][0]) <= 131072L && this.ib == 4 && a(this.gw - (long)this.cx[99][1]) <= 131072L && this.ib == 4) {
            this.cx[99][0] = 1146880;
            this.cx[99][1] = 2129920;
            this.ib = 1;
         }
      }

      if (this.selectedMap == 2) {
         if (a(this.gv - (long)this.cx[72][0]) <= 131072L && this.ib == 1 && a(this.gw - (long)this.cx[72][1]) <= 131072L && this.ib == 1) {
            this.cx[72][0] = 720896;
            this.cx[72][1] = 1114112;
            this.ib = 2;
         }

         if (a(this.gv - (long)this.cx[72][0]) <= 131072L && this.ib == 2 && a(this.gw - (long)this.cx[72][1]) <= 131072L && this.ib == 2) {
            this.cx[72][0] = 884736;
            this.cx[72][1] = 2392064;
            this.ib = 1;
         }
      }

   }

   public final void keyPressed(int var1) {
      this.hX = var1;
   }

   public final void keyReleased(int var1) {
      if (this.gY == 3) {
         int var2 = var1;
         if (var1 < 0) {
            var2 = this.getGameAction(var1);
         }

         label87: {
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
                  break label87;
               }

               var10000 = 53;
            }

            var2 = var10000;
         }

         if (var2 == 50) {
            this.iH = this.cX;
            this.iI = this.cZ;
            this.ik = true;
            this.id = 1;
            this.ie = 0;
         } else if (var2 == 56) {
            this.iH = this.cY;
            this.iI = this.da;
            this.ik = true;
            this.id = 1;
            this.ie = 0;
         } else if (var2 == 49) {
            this.iH = this.cX;
            this.iI = this.cZ;
            this.ik = true;
            this.id = 1;
            this.ie = 90;
         } else if (var2 == 51) {
            this.iH = this.cX;
            this.iI = this.cZ;
            this.ik = true;
            this.id = 1;
            this.ie = -90;
         } else if (var2 == 53) {
            this.iC = this.gl;
         } else {
            this.ik = false;
         }

         if (var2 == 48) {
            this.hU[0] = false;
         }

         if (var2 == 49) {
            this.hU[1] = false;
         }

         if (var2 == 50) {
            this.hU[2] = false;
         }

         if (var2 == 51) {
            this.hU[3] = false;
         }

         if (var2 == 52) {
            this.hU[4] = false;
         }

         if (var2 == 53) {
            this.hU[5] = false;
         }

         if (var2 == 54) {
            this.hU[6] = false;
         }

         if (var2 == 55) {
            this.hU[7] = false;
         }

         if (var2 == 56) {
            this.hU[8] = false;
         }

         if (var2 == 57) {
            this.hU[9] = false;
         }
      }

      if (!this.P()) {
         this.hX = -10000;
      }

   }

   private boolean P() {
      if (this.gY == 3) {
         return this.hU[0] || this.hU[1] || this.hU[2] || this.hU[3] || this.hU[4] || this.hU[5] || this.hU[6] || this.hU[7] || this.hU[8] || this.hU[9];
      } else {
         return false;
      }
   }

   private void Q() {
      this.T();
      if (this.iS != 20) {
         if (this.gl - this.gr > 3000L) {
            this.jm = false;
         }
      } else if (this.gl - this.gr > 10000L) {
         this.jm = false;
         this.ji = false;
         this.jo = (int[][])null;
         this.b(false);
         if (this.selectedMap == 0) {
            this.selectedMap = 1;
            this.he = 2;
            this.hZ = 0;
            this.ib = 1;
         }

         this.iV = 8;
         this.jg = true;
         this.jh = false;
         this.gY = 2;
         this.iS = 0;
         this.iU = 0;
         return;
      }

      if (!this.jm) {
         int var1;
         if ((var1 = this.ja) < this.l.length) {
            if (this.iY != var1) {
               this.hF[0] = (long)this.l[var1] * 75000L >> 1;
               this.hF[1] = (long)this.l[var1 + 1] * 75000L >> 1;
               this.gJ = this.l[var1 + 2] * 2;
               this.iZ = 0;
            }

            int var2;
            int var3 = (var2 = var1 >> 2) == 0 ? 0 : 1;
            if (this.hF[var3] <= (long)this.l[var1 + 3] * 75000L >> 1) {
               this.a(this.cX, this.cZ, 0);
               this.iY = var1;
               ++this.iZ;
            } else {
               if (this.ja == 8 && (this.gl - this.iD <= 3000L || !this.io)) {
                  if (!this.io) {
                     this.io = true;
                     this.iD = this.gl;
                  }
               } else {
                  this.iZ = 0;
                  this.ja += 4;
                  this.io = false;
               }

               if (this.ja >= this.l.length) {
                  this.gr = this.gl;
                  this.jm = true;
               } else {
                  if (!this.io) {
                     this.gr = this.gl;
                     this.jm = true;
                     this.eS = null;
                     System.gc();
                     this.hh = 1;
                     this.eS = new a(this, this.fc[this.hh][0], (d)null);
                     int var4 = this.fc[this.hh].length;

                     for(int var5 = 1; var5 < var4; ++var5) {
                        a.a(this.eS, this.fc[this.hh][var5]);
                     }
                  }

               }
            }
         }
      }
   }

   private void R() {
      Image var4 = this.b("/f" + this.r);
      this.jb = var4.getWidth();
      this.jc = var4.getHeight() - 112;
      this.jq = new int[this.jb * this.jc];
      var4.getRGB(this.jq, 0, this.jb, 0, 112, this.jb, this.jc);
      this.jo = new int[70][240];
      int var3 = 0;

      for(int var1 = 0; var1 < 7; ++var1) {
         for(int var2 = 0; var2 < 10; ++var2) {
            var4.getRGB(this.jo[var3], 0, 15, var2 * 15, var1 * 16, 15, 16);
            ++var3;
         }
      }

   }

   private void a(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      int var9 = var1;

      for(int var7 = var2; var7 <= var3; ++var7) {
         int var8;
         for(var8 = 0; var8 < this.n[var7]; ++var8) {
            var6.drawRGB(this.jo[this.o[var9]], 0, 15, var4 + 15 * var8, 22 * (var7 - var2 + var5) + this.iP - 5, 15, 16, false);
            ++var9;
         }

         if (this.hB && this.selectedMap != 13) {
            var6.drawRGB(this.jo[48], 0, 15, var4 + 15 * var8, 22 * (var7 - var2 + var5) + this.iP - 5, 15, 16, false);
         }
      }

   }

   private void b(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      int var10 = this.jt[22];

      for(int var7 = 1; var7 <= this.jf; ++var7) {
         var10 += this.n[this.js[22] + var7 - 1];
      }

      int var11;
      int var16;
      label62: {
         var11 = var5;
         int var10001;
         if (this.jL > 8) {
            var16 = this.js[22] + 7;
            var10001 = this.jf;
         } else {
            if (this.jL != 0) {
               var16 = this.js[22] + this.jL - 1;
               break label62;
            }

            var16 = this.js[22];
            var10001 = this.jL;
         }

         var16 += var10001;
      }

      int var12 = var16;

      for(int var13 = this.js[22] + this.jf; var13 <= var12; ++var13) {
         for(int var8 = 0; var8 < this.n[var13]; ++var8) {
            var6.drawRGB(this.jo[this.o[var10]], 0, 15, var4 + 15 * var8, 22 * var11 + this.iP - 5, 15, 16, false);
            ++var10;
         }

         ++var11;
      }

      if (this.jL > 8) {
         --var11;
      }

      if (this.jf == this.jL - 7 || this.jL < 8) {
         int var9 = var1;

         int var14;
         for(var14 = var2; var14 < var3; ++var14) {
            var9 += this.n[var14];
         }

         for(int var15 = 0; var15 < this.n[var14]; ++var15) {
            var6.drawRGB(this.jo[this.o[var9]], 0, 15, var4 + 15 * var15, 22 * var11 + this.iP - 5, 15, 16, false);
            ++var9;
         }
      }

   }

   private void S() {
      int var3 = 0;
      this.js = new int[this.m.length];
      this.jt = new int[this.m.length];

      for(int var1 = 1; var1 < this.js.length; ++var1) {
         this.js[var1] = this.js[var1 - 1] + this.m[var1 - 1];
         this.jt[var1] = this.jt[var1 - 1];

         for(int var2 = 1; var2 <= this.m[var1 - 1]; ++var2) {
            int[] var10000 = this.jt;
            var10000[var1] += this.n[var3];
            ++var3;
         }
      }

   }

   private void e(Graphics var1) {
      byte var3;
      label80: {
         var3 = 15;
         byte var10000;
         if (this.iS <= 5) {
            var10000 = 21;
         } else if (this.iS == 14) {
            var10000 = 15;
         } else {
            if (this.iS != 23) {
               break label80;
            }

            var10000 = 2;
         }

         var3 = var10000;
      }

      if (this.iS != 1) {
         int var8;
         byte var10001;
         if (this.iS == 0 && !this.jh) {
            var8 = this.js[this.iS] + this.m[this.iS];
            var10001 = 2;
         } else {
            var8 = this.js[this.iS] + this.m[this.iS];
            var10001 = 1;
         }

         int var5 = var8 - var10001;
         this.a(this.jt[this.iS], this.js[this.iS], var5, var3, 5, var1);
      } else {
         this.b(this.jt[this.iS], this.js[this.iS], this.js[this.iS] + this.m[this.iS] - 1, var3, 5, var1);
      }

      if (this.iS == 3) {
         for(int var2 = this.jD != 0 ? 1 : 0; var2 < this.jw.length; ++var2) {
            this.a(this.jw[var2], this.jx[var2], this.jx[var2], 185, 4 + var2 + 1, var1);
         }

         if (this.jD != 0) {
            c3d_b var9;
            byte var10;
            if (this.jD == 100) {
               this.jC[0] = 1;
               this.jC[1] = 0;
               this.jC[2] = 0;
               var9 = this;
               var10 = 3;
            } else {
               this.jC[0] = this.jD / 10;
               this.jC[1] = 0;
               var9 = this;
               var10 = 2;
            }

            var9.jE = var10;

            for(int var7 = this.jx[0]; var7 <= this.jx[0]; ++var7) {
               for(int var6 = 0; var6 < this.jE; ++var6) {
                  var1.drawRGB(this.jo[this.jC[var6]], 0, 15, 185 + 15 * var6, 22 * (var7 - this.jx[0] + 4 + 1) + this.iP - 5, 15, 16, false);
               }
            }
         }
      }

      if (this.iS <= 5) {
         this.f(var1);
      }

      if (!this.hC) {
         var1.drawRGB(this.jq, 0, this.jb, 240 - this.jb >> 1, 35 + this.iP, this.jb, this.jc, false);
      }

   }

   private void f(Graphics var1) {
      var1.drawRGB(this.jo[66], 0, 15, 4, 22 * (this.iU + 4 + 1) + this.iP - 5, 15, 16, false);
   }

   private void T() {
      this.iQ = 192 + this.I() % 16;
      this.iR = 208 + this.I() % 4;
      if (this.gl - this.iN > 1000L) {
         this.iP = v(this.I() % 3);
         this.iN = this.gl;
      } else {
         this.iP = 0;
      }
   }

   private void U() {
      label28: {
         long var1 = this.gl - this.iO;
         c3d_b var10000;
         if (this.gY == 1) {
            this.jl = true;
            if (var1 <= 6000L) {
               break label28;
            }

            if (var1 > 6000L) {
               this.gY = 4;
               this.iO = this.gl;
               break label28;
            }

            var10000 = this;
         } else {
            if (this.gY != 4) {
               break label28;
            }

            this.jl = true;
            if (var1 <= 6000L) {
               break label28;
            }

            if (var1 > 6000L) {
               this.gY = 2;
               break label28;
            }

            var10000 = this;
         }

         var10000.jl = false;
      }

      this.T();
   }

   private void V() {
      if (!this.hC) {
         if (this.gY == 2) {
            this.iT = this.iS;
            int var1 = this.iS != 4 ? 0 : 1;
            if (this.iS >= 6) {
               if (this.X()) {
                  this.W();
                  return;
               }
            } else if (this.hY == 50) {
               label281: {
                  int var15;
                  c3d_b var10000;
                  label280: {
                     byte var10002;
                     label279: {
                        if (this.iS == 1) {
                           this.iV = this.iU;
                           if (this.iU == var1) {
                              if (this.jf > 0) {
                                 --this.jf;
                                 break label281;
                              }

                              if (this.jL > 7) {
                                 this.iU = 7;
                                 this.jf = this.jL - 7;
                                 break label281;
                              }

                              if (this.jL == 0) {
                                 var10000 = this;
                                 var15 = this.jL + 1;
                              } else {
                                 var10000 = this;
                                 var15 = this.jL;
                              }
                              break label280;
                           }

                           var10000 = this;
                           var15 = this.iU;
                        } else {
                           if (this.iS > 5) {
                              break label281;
                           }

                           this.iV = this.iU;
                           if (this.iU != var1) {
                              var10000 = this;
                              var15 = this.iU;
                           } else {
                              if (this.iS == 0 && !this.jh) {
                                 var10000 = this;
                                 var15 = this.m[this.iS];
                                 var10002 = 2;
                                 break label279;
                              }

                              var10000 = this;
                              var15 = this.m[this.iS];
                           }
                        }

                        var10002 = 1;
                     }

                     var15 -= var10002;
                  }

                  var10000.iU = var15;
               }

               if (!this.hA) {
                  this.F(20);
                  return;
               }
            } else if (this.hY == 56) {
               label475: {
                  c3d_b var9;
                  int var16;
                  if (this.iS != 1) {
                     label484: {
                        if (this.iS > 5) {
                           break label475;
                        }

                        this.iV = this.iU;
                        if (this.iS == 0 && !this.jh) {
                           if (this.iU != this.m[this.iS] - 2) {
                              var9 = this;
                              var16 = this.iU + 1;
                              break label484;
                           }

                           var9 = this;
                        } else {
                           if (this.iU != this.m[this.iS] - 1) {
                              var9 = this;
                              var16 = this.iU + 1;
                              break label484;
                           }

                           var9 = this;
                        }

                        var16 = var1;
                     }
                  } else {
                     this.iV = this.iU;
                     if ((this.iU == 7 || this.jL <= 7) && (this.iU >= this.jL || this.jL > 7) && (this.iU != 0 || this.jL != 0)) {
                        if (this.jf != this.jL - 7 && this.jL > 7) {
                           ++this.jf;
                           break label475;
                        }

                        if (this.iU == 7 || this.iU >= this.jL + 1 && this.jL == 0 || this.iU == this.jL) {
                           this.iU = var1;
                           this.jf = 0;
                        }
                        break label475;
                     }

                     var9 = this;
                     var16 = this.iU + 1;
                  }

                  var9.iU = var16;
               }

               if (!this.hA) {
                  this.F(20);
                  return;
               }
            } else if (this.hY != 52 && this.hY != 54) {
               if (this.iS == 0) {
                  if (this.iU == 4) {
                     if (!this.jh) {
                        return;
                     }

                     this.jo = (int[][])null;
                     this.jq = null;
                     this.c(false);
                     System.gc();
                     this.gZ = -1;
                     this.ha = -1;
                     this.gY = 3;
                     if (this.hA) {
                        this.F(this.selectedMap);
                     } else {
                        try {
                           this.jz.stop();
                        } catch (Exception var6) {
                           this.jF = false;
                           this.jD = 0;
                        }
                     }
                  }

                  this.iW = this.iU;
                  this.iX = this.iV;
                  this.iS = this.iU + 1;
               } else if (this.iS == 1) {
                  if (this.iU == 1 && this.jL == 0 || this.iU == this.jL && this.jL != 0 || this.iU == 7 && this.jf == this.jL - 7) {
                     this.iS = 0;
                     this.iU = 0;
                     return;
                  }

                  if (this.iU == 7 && !this.hs && this.jf == 5 || this.iU == 6 && !this.hs && this.jf == 6) {
                     this.jk = true;
                     this.ji = true;
                     this.hZ = 0;
                     this.iY = -1;
                     this.iZ = 0;
                     this.ja = 0;
                  }

                  try {
                     if (this.jz != null) {
                        this.jz.stop();
                     }
                  } catch (Exception var5) {
                  }

                  this.jq = null;
                  System.gc();
                  this.hr = true;
                  this.hB = true;
                  this.jm = false;
                  this.gY = 3;
                  if (this.jL == 0) {
                     this.jL = 1;
                     this.jH[0] = 0;
                     this.jI[0] = 99;
                     this.jK[0][0] = 64;
                     this.jK[0][1] = 128;
                     this.jK[0][2] = 256;
                     this.jK[0][3] = 5;
                     this.jJ[0] = 0;
                     this.ac();
                  }

                  if ((this.iU != 7 || this.jf != 5) && !this.ji) {
                     label489: {
                        this.selectedMap = this.iU + this.jf + 1;
                        this.fE = 0;
                        this.fZ = false;
                        this.fM = 0;
                        this.fD = 40;
                        this.fK = 0;
                        this.ia = 0;
                        c3d_b var14;
                        byte var21;
                        if (this.selectedMap != 6 && this.selectedMap != 9) {
                           if (this.selectedMap != 1) {
                              break label489;
                           }

                           var14 = this;
                           var21 = 2;
                        } else {
                           var14 = this;
                           var21 = 3;
                        }

                        var14.he = var21;
                     }

                     this.hZ = 0;
                     this.ib = 1;
                     this.fH = this.jH[this.selectedMap - 1];
                     this.gz = this.jI[this.selectedMap - 1];
                     if (this.gz > 100) {
                        this.gF = 200;
                     }

                     for(int var2 = 0; var2 < 4; ++var2) {
                        this.gx[var2] = this.jK[this.selectedMap - 1][var2];
                     }

                     this.gA = this.jJ[this.selectedMap - 1];
                     this.gE = this.gz;

                     for(int var8 = 0; var8 < 4; ++var8) {
                        this.gy[var8] = this.gx[var8];
                     }
                  } else {
                     this.selectedMap = 0;
                     this.hZ = 0;
                     this.ib = 1;
                  }

                  this.Y();
               } else {
                  if (this.iS == 2) {
                     c3d_b var13;
                     byte var20;
                     if (this.iU == 6) {
                        this.iU = this.iS - 1;
                        var13 = this;
                        var20 = 0;
                     } else if (this.iU == 0) {
                        var13 = this;
                        var20 = 6;
                     } else if (this.iU == 1) {
                        var13 = this;
                        var20 = 9;
                     } else if (this.iU == 2) {
                        var13 = this;
                        var20 = 11;
                     } else if (this.iU == 3) {
                        var13 = this;
                        var20 = 12;
                     } else if (this.iU == 4) {
                        var13 = this;
                        var20 = 14;
                     } else {
                        if (this.iU != 5) {
                           return;
                        }

                        var13 = this;
                        var20 = 23;
                     }

                     var13.iS = var20;
                     return;
                  }

                  if (this.iS == 3) {
                     if (this.iU == 6) {
                        this.iU = this.iS - 1;
                        this.iS = 0;
                        this.Y();
                     }

                     return;
                  }

                  if (this.iS == 4) {
                     if (this.iU == 1) {
                        try {
                           if (this.jz != null) {
                              this.jz.stop();
                              this.jz.close();
                           }
                        } catch (Exception var4) {
                        }

                        this.ac();

                        try {
                           this.jG.closeRecordStore();
                        } catch (Exception var3) {
                        }

                        Castle3D.a().destroyApp(false);
                     } else {
                        this.iS = 0;
                     }
                  }
               }

               if (this.iS != 4 || this.iU != 1) {
                  this.W();
               }

               if (!this.hA) {
                  this.F(20);
               }
            } else {
               if (this.iS == 3) {
                  if (this.iU == 6) {
                     return;
                  }

                  if (this.iU != 0) {
                     label369: {
                        c3d_b var10;
                        int var17;
                        label368: {
                           if (this.jw[this.iU] == 211) {
                              this.jw[this.iU] = 209;
                              this.jx[this.iU] = 25;
                              if (this.iU != 1) {
                                 if (this.iU != 2) {
                                    break label369;
                                 }

                                 this.jw[this.iU - 1] = 211;
                                 this.jx[this.iU - 1] = 26;
                                 if (this.jD == 0) {
                                    break label369;
                                 }

                                 this.hA = false;
                                 var10 = this;
                                 var17 = 20;
                                 break label368;
                              }

                              this.jw[this.iU + 1] = 211;
                              this.jx[this.iU + 1] = 26;
                              if (this.jD == 0) {
                                 break label369;
                              }

                              this.hA = true;
                              if (this.selectedMap != -1) {
                                 var10 = this;
                                 var17 = this.selectedMap;
                                 break label368;
                              }

                              var10 = this;
                           } else {
                              this.jw[this.iU] = 211;
                              this.jx[this.iU] = 26;
                              if (this.iU == 1) {
                                 this.jw[this.iU + 1] = 209;
                                 this.jx[this.iU + 1] = 25;
                                 if (this.jD == 0) {
                                    break label369;
                                 }

                                 this.hA = false;
                                 var10 = this;
                                 var17 = 20;
                                 break label368;
                              }

                              if (this.iU != 2) {
                                 break label369;
                              }

                              this.jw[this.iU - 1] = 209;
                              this.jx[this.iU - 1] = 25;
                              if (this.jD == 0) {
                                 break label369;
                              }

                              this.hA = true;
                              if (this.selectedMap != -1) {
                                 var10 = this;
                                 var17 = this.selectedMap;
                                 break label368;
                              }

                              var10 = this;
                           }

                           var17 = 0;
                        }

                        var10.F(var17);
                     }
                  }

                  if (this.iU == 0 && this.jF) {
                     label340: {
                        c3d_b var11;
                        int var18;
                        if (this.hY == 52) {
                           if (this.jD == 0) {
                              break label340;
                           }

                           var11 = this;
                           var18 = this.jD - 10;
                        } else {
                           if (this.jD == 100) {
                              break label340;
                           }

                           if (this.jD == 0) {
                              this.jD += 10;
                              if (this.selectedMap != -1 && this.hA) {
                                 var11 = this;
                                 var18 = this.selectedMap;
                              } else if (this.hA) {
                                 var11 = this;
                                 var18 = 0;
                              } else {
                                 var11 = this;
                                 var18 = 20;
                              }

                              var11.F(var18);
                              if (this.jF) {
                                 break label340;
                              }

                              var11 = this;
                              var18 = 0;
                           } else {
                              var11 = this;
                              var18 = this.jD + 10;
                           }
                        }

                        var11.jD = var18;
                     }

                     if (this.jz != null) {
                        this.jA.setLevel(this.jD);
                        if (this.jD == 0) {
                           try {
                              this.jz.stop();
                           } catch (Exception var7) {
                           }
                        }
                     }
                  }

                  this.jg = true;
               }

               if (!this.hA) {
                  this.F(20);
                  return;
               }
            }
         }

      }
   }

   private void W() {
      label14: {
         c3d_b var10000;
         int var10001;
         if (this.iT != 0) {
            this.iU = this.iW;
            var10000 = this;
            var10001 = this.iX;
         } else {
            this.iU = 0;
            this.iV = 1;
            if (this.iS != 4) {
               break label14;
            }

            this.iU = 1;
            var10000 = this;
            var10001 = 2;
         }

         var10000.iV = var10001;
      }

      this.jg = true;
   }

   private boolean X() {
      if (this.iS >= 6 && this.iS != 21 && this.iS != 10 && this.iS != 16 && this.iS != 28 && this.iS != 13 && this.iS != 14 && this.iS != 23) {
         c3d_b var2;
         int var4;
         if (this.iS != 8) {
            if (this.iS != 12) {
               if (this.iS != 11) {
                  var2 = this;
                  var4 = this.iS + 1;
               } else {
                  var2 = this;
                  var4 = 15;
               }
            } else {
               var2 = this;
               var4 = 21;
            }
         } else {
            var2 = this;
            var4 = 27;
         }

         var2.iS = var4;
         return true;
      } else {
         label64: {
            c3d_b var10000;
            byte var10001;
            if (this.iS == 28) {
               this.iU = 0;
               var10000 = this;
               var10001 = 1;
            } else if (this.iS >= 9 && this.iS <= 10) {
               this.iU = 1;
               var10000 = this;
               var10001 = 2;
            } else if (this.iS == 16) {
               this.iU = 2;
               var10000 = this;
               var10001 = 3;
            } else {
               label57: {
                  if (this.iS == 21) {
                     var10000 = this;
                     var10001 = 3;
                  } else {
                     if (this.iS >= 14 && this.iS <= 18) {
                        this.iU = 4;
                        var10000 = this;
                        var10001 = 3;
                        break label57;
                     }

                     if (this.iS != 23) {
                        break label64;
                     }

                     var10000 = this;
                     var10001 = 5;
                  }

                  var10000.iU = var10001;
                  var10000 = this;
                  var10001 = 4;
               }
            }

            var10000.iV = var10001;
         }

         this.iS = 2;
         return false;
      }
   }

   private void Y() {
      c3d_b var10000;
      boolean var10001;
      if (this.jx[1] == 25) {
         var10000 = this;
         var10001 = 1;
      } else {
         var10000 = this;
         var10001 = 0;
      }

      var10000.hA = (boolean)var10001;
      if (this.jx[3] == 25) {
         var10000 = this;
         var10001 = (boolean)1;
      } else {
         var10000 = this;
         var10001 = (boolean)0;
      }

      var10000.hz = var10001;
      if (this.jx[4] == 25) {
         var10000 = this;
         var10001 = (boolean)1;
      } else {
         var10000 = this;
         var10001 = (boolean)0;
      }

      var10000.hy = var10001;
      if (this.jx[5] == 25) {
         var10000 = this;
         var10001 = 4;
      } else {
         var10000 = this;
         var10001 = 1;
      }

      var10000.hq = var10001;
   }

   private void g(Graphics var1) {
      if (this.gY != 3) {
         c(var1);
         if (this.gY == 1) {
            if (this.jo == null) {
               this.R();
               Image var3 = this.b("/n" + this.r);
               this.jd = var3.getWidth();
               this.je = var3.getHeight();
               this.jr = new int[this.jd * this.je];
               var3.getRGB(this.jr, 0, this.jd, 0, 0, this.jd, this.je);
               this.iU = 0;
               this.iV = 7;
               this.H();
               this.iS = 0;
               this.jw = new short[6];
               this.jx = new byte[6];

               for(int var2 = 0; var2 < this.jw.length; ++var2) {
                  this.jw[var2] = 209;
                  this.jx[var2] = 25;
               }

               this.jw[0] = 211;
               this.jx[0] = 26;
               byte[] var10000;
               byte var10001;
               if (!this.hA) {
                  this.jw[1] = 211;
                  var10000 = this.jx;
                  var10001 = 1;
               } else {
                  this.jw[2] = 211;
                  var10000 = this.jx;
                  var10001 = 2;
               }

               var10000[var10001] = 26;
               if (!this.hz) {
                  this.jw[3] = 211;
                  this.jx[3] = 26;
               }

               if (!this.hy) {
                  this.jw[4] = 211;
                  this.jx[4] = 26;
               }

               if (this.hq == 1) {
                  this.jw[5] = 211;
                  this.jx[5] = 26;
               }

               this.jg = true;
               this.iP = 0;
               this.F(0);
               this.selectedMap = -1;
               this.iO = System.currentTimeMillis();
            } else if (this.jl) {
               var1.drawRGB(this.jr, 0, this.jd, 240 - this.jd >> 1, (320 - this.je >> 1) + this.iP, this.jd, this.je, false);
            }
         } else if (this.gY == 4) {
            if (this.jl) {
               var1.drawRGB(this.jq, 14 * this.jb, this.jb, 240 - this.jb >> 1, (320 - this.jc >> 1) + this.iP, this.jb, this.jc - 14, false);
            }
         } else if (this.gY == 2) {
            if (this.jg) {
               if (this.jh || this.iV == 8) {
                  this.H();
               }

               c(var1);
               this.e(var1);
               this.jg = false;
            } else {
               this.e(var1);
            }
         }

         if (this.gY == 1 || this.gY == 2 || this.gY == 4) {
            this.b(0, (Graphics)var1);
         }

      }
   }

   private void Z() {
      this.ju = new int[320];
      this.jv = new int[320];

      for(int var1 = 0; var1 < 320; ++var1) {
         this.ju[var1] = 9074531;
         this.jv[var1] = 5129016;
      }

   }

   private void b(int var1, Graphics var2) {
      var2.drawRGB(this.ju, 0, 1, this.iQ, var1, 1, 319 - (var1 << 1), false);
      var2.drawRGB(this.jv, 0, 1, this.iR, var1, 1, 319 - (var1 << 1), false);
   }

   private void aa() {
      if (this.hY == 35 || this.hC) {
         this.b(false);
         this.iU = 4;
         this.iV = 3;
         this.jg = true;
         this.jh = true;
         this.gY = 2;
         if (!this.hC) {
            this.iS = 0;
         } else {
            this.iS = 1;
            this.iU = 7;
            this.jf = 5;
            this.hs = false;
            this.hY = 53;
            this.jL = 13;
            this.hC = false;
            this.V();
         }

         this.gi = (int[][])null;
         System.gc();
         this.fT = true;
      }

   }

   private void a(boolean var1, Graphics var2) {
      try {
         Image var3 = this.b("/i" + this.r);
         var2.drawImage(var3, 0, 0, 20);
         var2.drawImage(var3, 0, 212, 20);
         if (!this.fU || this.selectedMap == 12) {
            var2.setColor(70, 0, 0);
            var2.fillRect(this.c[3], -1, 55, 41);
            if (this.selectedMap == 12) {
               var2.fillRect(this.c[0], -1, 55, 41);
               var2.fillRect(this.c[1], -1, 55, 41);
               this.fB = new int[2296];
               var3.getRGB(this.fB, 0, 56, this.c[2], 0, 56, 41);
            }
         }

         if (var1) {
            this.jp = new int[2100];

            for(int var4 = 0; var4 < 10; ++var4) {
               var3.getRGB(this.jp, var4 * 15 * 14, 15, var4 * 15, 108, 15, 14);
            }

            if (var1) {
               Image var6 = this.b("/ii" + this.r);
               this.jn = new int[4][600];
               var6.getRGB(this.jn[3], 0, 24, 0, 0, 24, 25);
               var6.getRGB(this.jn[1], 0, 24, 24, 0, 24, 25);
               var6.getRGB(this.jn[0], 0, 24, 48, 0, 24, 25);
               var3.getRGB(this.jn[2], 0, 24, 156, 69, 24, 25);
            }
         }

      } catch (Exception var5) {
      }
   }

   private Image b(String var1) {
      try {
         int var4;
         InputStream var5;
         byte[] var3 = new byte[(var4 = (var5 = this.getClass().getResourceAsStream(var1)).read() & 255 | (var5.read() & 255) << 8) + 4];
         var5.read(var3, 4, var4);
         var3[0] = -119;
         var3[1] = 80;
         var3[2] = 78;
         var3[3] = 71;
         return Image.createImage(var3, 0, var4 + 4);
      } catch (Exception var6) {
         return null;
      }
   }

   private void F(int var1) {
      if (this.jD != 0) {
         Runtime.getRuntime().totalMemory();
         this.jF = true;
         if (this.ig == var1) {
            if (this.gl - this.iA > this.iB) {
               try {
                  this.jz.start();
               } catch (Exception var5) {
                  this.jF = false;
                  this.jD = 0;
               }

               this.iA = this.gl;
               return;
            }
         } else {
            try {
               if (this.jz != null) {
                  this.jz.stop();
                  this.jz.close();
               }

               this.jB = null;
               this.jz = null;
               System.gc();
               this.jB = this.getClass().getResourceAsStream("/" + this.jy[var1] + ".mid");
               this.jz = Manager.createPlayer(this.jB, "audio/midi");
               this.jz.realize();
               if (var1 < 15) {
                  this.jz.setLoopCount(1000);
               } else {
                  this.jz.setLoopCount(1);
                  c3d_b var10000;
                  long var10001;
                  if (var1 != 21 && var1 != 22) {
                     var10000 = this;
                     var10001 = this.jz.getDuration() / 1000L;
                  } else {
                     var10000 = this;
                     var10001 = 3000L;
                  }

                  var10000.iB = var10001;
               }

               this.jA = (VolumeControl)this.jz.getControl("VolumeControl");
               this.jA.setLevel(this.jD);
               this.jz.start();
               this.ig = var1;
               return;
            } catch (Exception var6) {
               this.jF = false;
               this.jD = 0;
            }
         }

      }
   }

   private void ab() throws Exception {
      this.jG = RecordStore.openRecordStore("a1", true);
      int var1 = this.mapFiles.length;
      this.jH = new int[var1];
      this.jI = new int[var1];
      this.jK = new int[var1][4];
      this.gx = new int[4];
      this.gy = new int[4];
      this.jJ = new int[var1];

      try {
         RecordEnumeration var2;
         if ((var2 = this.jG.enumerateRecords((RecordFilter)null, (RecordComparator)null, false)).numRecords() == 0) {
            this.jL = 0;
            int var11 = this.jH.length;

            for(int var12 = 0; var12 < var11; ++var12) {
               this.jH[var12] = -1;
               this.jI[var12] = -1;

               for(int var13 = 0; var13 < 4; ++var13) {
                  this.jK[var12][var13] = -1;
               }

               this.jJ[var12] = -1;
            }

            this.b.numColors();
            this.jD = 50;
            this.hz = true;
            this.hq = 1;
            this.hy = true;
            this.hA = true;
         } else {
            byte[] var4 = var2.nextRecord();
            ByteArrayInputStream var5 = new ByteArrayInputStream(var4);
            DataInputStream var6 = new DataInputStream(var5);
            int var7 = this.jH.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               this.jH[var8] = var6.readInt();
               if (this.jH[var8] != -1) {
                  ++this.jL;
               }

               this.jI[var8] = var6.readInt();

               for(int var9 = 0; var9 < 4; ++var9) {
                  this.jK[var8][var9] = var6.readInt();
               }
            }

            this.jD = var6.readInt();
            this.hz = var6.readBoolean();
            this.hq = var6.readByte();
            this.hy = var6.readBoolean();
            if (var6.readBoolean()) {
               this.jL = 13;
            }

            this.hA = var6.readBoolean();
            this.hb = var6.readInt();
         }
      } catch (Exception var10) {
      }
   }

   private void ac() {
      try {
         RecordEnumeration var2;
         if ((var2 = this.jG.enumerateRecords((RecordFilter)null, (RecordComparator)null, false)).numRecords() != 0) {
            int var1 = var2.nextRecordId();
            this.jG.deleteRecord(var1);
         }

         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         DataOutputStream var5 = new DataOutputStream(var4);

         for(int var6 = 0; var6 < this.jH.length; ++var6) {
            var5.writeInt(this.jH[var6]);
            var5.writeInt(this.jI[var6]);

            for(int var7 = 0; var7 < 4; ++var7) {
               var5.writeInt(this.jK[var6][var7]);
            }
         }

         var5.writeInt(this.jD);
         var5.writeBoolean(this.hz);
         var5.writeByte(this.hq);
         var5.writeBoolean(this.hy);
         DataOutputStream var10000;
         boolean var10001;
         if (this.jL == 13) {
            var10000 = var5;
            var10001 = true;
         } else {
            var10000 = var5;
            var10001 = false;
         }

         var10000.writeBoolean(var10001);
         var5.writeBoolean(this.hA);
         var5.writeInt(this.hb);
         this.jG.addRecord(var4.toByteArray(), 0, var4.toByteArray().length);
      } catch (Exception var8) {
      }
   }

   static int[][] a(c3d_b var0) {
      return var0.dP;
   }

   static int[] b(c3d_b var0) {
      return var0.dL;
   }

   static long[] c(c3d_b var0) {
      return var0.hF;
   }

   static int d(c3d_b var0) {
      return var0.hX;
   }

   static int e(c3d_b var0) {
      return var0.hY;
   }

   static boolean a(c3d_b var0, boolean var1) {
      return var0.ih = var1;
   }

   static int a(c3d_b var0, int var1) {
      return var0.hY = var1;
   }

   static int f(c3d_b var0) {
      return var0.gY;
   }

   static int b(c3d_b var0, int var1) {
      return var0.hX = var1;
   }

   static boolean g(c3d_b var0) {
      return var0.ih;
   }

   static void h(c3d_b var0) {
      var0.N();
   }

   static boolean i(c3d_b var0) {
      return var0.hD;
   }

   static boolean[] j(c3d_b var0) {
      return var0.hU;
   }

   static long a(c3d_b var0, long var1) {
      return var0.gl = var1;
   }

   static long b(c3d_b var0, long var1) {
      return var0.iq = var1;
   }

   static long k(c3d_b var0) {
      return var0.gl;
   }

   static long l(c3d_b var0) {
      return var0.ip;
   }

   static long c(c3d_b var0, long var1) {
      return var0.ip = var1;
   }

   static long m(c3d_b var0) {
      return var0.iq;
   }

   static long d(c3d_b var0, long var1) {
      return var0.cZ = var1;
   }

   static int c(c3d_b var0, int var1) {
      return var0.gO = var1;
   }

   static int d(c3d_b var0, int var1) {
      return var0.gM = var1;
   }

   static int e(c3d_b var0, int var1) {
      return var0.gN = var1;
   }

   static int n(c3d_b var0) {
      return var0.gO;
   }

   static int o(c3d_b var0) {
      return var0.gM;
   }

   static long p(c3d_b var0) {
      return var0.cZ;
   }

   static boolean q(c3d_b var0) {
      return var0.ji;
   }

   static long f(c3d_b var0, int var1) {
      return var0.cZ >>= var1;
   }

   static long e(c3d_b var0, long var1) {
      return var0.cX = var1;
   }

   static long f(c3d_b var0, long var1) {
      return var0.cY = var1;
   }

   static long r(c3d_b var0) {
      return var0.cX;
   }

   static long g(c3d_b var0, long var1) {
      return var0.da = var1;
   }

   static long s(c3d_b var0) {
      return var0.iE;
   }

   static boolean b(c3d_b var0, boolean var1) {
      return var0.hC = var1;
   }

   static boolean c(c3d_b var0, boolean var1) {
      return var0.hD = var1;
   }

   static void t(c3d_b var0) {
      var0.aa();
   }

   static long h(c3d_b var0, long var1) {
      return var0.iO = var1;
   }

   static boolean u(c3d_b var0) {
      return var0.hE;
   }

   static boolean d(c3d_b var0, boolean var1) {
      return var0.hE = var1;
   }

   static boolean v(c3d_b var0) {
      return var0.hr;
   }

   static void w(c3d_b var0) {
      var0.Q();
   }

   static int x(c3d_b var0) {
      return var0.ja;
   }

   static int y(c3d_b var0) {
      return var0.hZ;
   }

   static long z(c3d_b var0) {
      return var0.ir;
   }

   static void A(c3d_b var0) {
      var0.M();
   }

   static long i(c3d_b var0, long var1) {
      return var0.ir = var1;
   }

   static int B(c3d_b var0) {
      return var0.hZ++;
   }

   static int g(c3d_b var0, int var1) {
      return var0.hZ = var1;
   }

   static void C(c3d_b var0) {
      var0.r();
   }

   static void D(c3d_b var0) {
      var0.q();
   }

   static long E(c3d_b var0) {
      return var0.iy;
   }

   static void e(c3d_b var0, boolean var1) {
      var0.d(var1);
   }

   static long j(c3d_b var0, long var1) {
      return var0.iy = var1;
   }

   static void F(c3d_b var0) {
      var0.L();
   }

   static int G(c3d_b var0) {
      return var0.cr;
   }

   static int[][] H(c3d_b var0) {
      return var0.cy;
   }

   static long[] I(c3d_b var0) {
      return var0.iJ;
   }

   static byte[] J(c3d_b var0) {
      return var0.cO;
   }

   static long K(c3d_b var0) {
      return var0.iu;
   }

   static void L(c3d_b var0) {
      var0.U();
   }

   static long k(c3d_b var0, long var1) {
      return var0.iu = var1;
   }

   static boolean M(c3d_b var0) {
      return var0.fy;
   }

   static long N(c3d_b var0) {
      return var0.it;
   }

   static int O(c3d_b var0) {
      return var0.ic;
   }

   static void P(c3d_b var0) {
      var0.K();
   }

   static long l(c3d_b var0, long var1) {
      return var0.it = var1;
   }

   static long Q(c3d_b var0) {
      return var0.iF;
   }

   static boolean R(c3d_b var0) {
      return var0.hT;
   }

   static boolean f(c3d_b var0, boolean var1) {
      return var0.hr = var1;
   }

   static boolean g(c3d_b var0, boolean var1) {
      return var0.hB = var1;
   }

   static boolean S(c3d_b var0) {
      return var0.ft;
   }

   static boolean h(c3d_b var0, boolean var1) {
      return var0.ft = var1;
   }

   static boolean T(c3d_b var0) {
      return var0.fu;
   }

   static boolean i(c3d_b var0, boolean var1) {
      return var0.fu = var1;
   }

   static Player U(c3d_b var0) {
      return var0.jz;
   }

   static long V(c3d_b var0) {
      return var0.go;
   }

   static boolean j(c3d_b var0, boolean var1) {
      return var0.ht = var1;
   }

   static short a(c3d_b var0, short var1) {
      return var0.hg = var1;
   }

   static long W(c3d_b var0) {
      return var0.gp;
   }

   static boolean k(c3d_b var0, boolean var1) {
      return var0.hu = var1;
   }

   static long X(c3d_b var0) {
      return var0.gq;
   }

   static boolean l(c3d_b var0, boolean var1) {
      return var0.hv = var1;
   }

   static int Y(c3d_b var0) {
      return var0.fJ;
   }

   static void Z(c3d_b var0) {
      var0.l();
   }

   static long aa(c3d_b var0) {
      return var0.gm;
   }

   static int h(c3d_b var0, int var1) {
      return var0.gL = var1;
   }

   static void ab(c3d_b var0) {
      var0.C();
   }

   static boolean ac(c3d_b var0) {
      return var0.im;
   }

   static long ad(c3d_b var0) {
      return var0.iv;
   }

   static boolean ae(c3d_b var0) {
      return var0.in;
   }

   static void a(c3d_b var0, long var1, long var3, int var5) {
      var0.a(var1, var3, var5);
   }

   static byte af(c3d_b var0) {
      byte var10002 = var0.iL;
      var0.iL = (byte)(var10002 + 1);
      return var10002;
   }

   static byte ag(c3d_b var0) {
      return var0.iL;
   }

   static boolean m(c3d_b var0, boolean var1) {
      return var0.in = var1;
   }

   static byte a(c3d_b var0, byte var1) {
      return var0.iL = var1;
   }

   static long m(c3d_b var0, long var1) {
      return var0.iv = var1;
   }

   static int ah(c3d_b var0) {
      return var0.selectedMap;
   }

   static long ai(c3d_b var0) {
      return var0.ix;
   }

   static long n(c3d_b var0, long var1) {
      return var0.ix = var1;
   }

   static int aj(c3d_b var0) {
      return var0.I();
   }

   static int i(c3d_b var0, int var1) {
      return v(var1);
   }

   static boolean ak(c3d_b var0) {
      return var0.hx;
   }

   static long al(c3d_b var0) {
      return var0.is;
   }

   static int j(c3d_b var0, int var1) {
      return var0.fG += var1;
   }

   static long o(c3d_b var0, long var1) {
      return var0.is = var1;
   }

   static boolean n(c3d_b var0, boolean var1) {
      return var0.il = var1;
   }

   static boolean am(c3d_b var0) {
      return var0.il;
   }

   static int k(c3d_b var0, int var1) {
      return var0.bh = var1;
   }

   static int an(c3d_b var0) {
      return var0.bi;
   }

   static int ao(c3d_b var0) {
      return var0.bj;
   }

   static byte b(c3d_b var0, byte var1) {
      return var0.iM = var1;
   }

   static int[][] ap(c3d_b var0) {
      return var0.cx;
   }

   static boolean aq(c3d_b var0) {
      return var0.hw;
   }

   static int l(c3d_b var0, int var1) {
      return var0.ar = var1;
   }

   static int ar(c3d_b var0) {
      return var0.hi;
   }

   static void as(c3d_b var0) {
      var0.A();
   }

   static short at(c3d_b var0) {
      return var0.hf;
   }

   static short au(c3d_b var0) {
      return var0.he;
   }

   static boolean o(c3d_b var0, boolean var1) {
      return var0.hw = var1;
   }

   static short b(c3d_b var0, short var1) {
      return var0.hf = var1;
   }

   static int av(c3d_b var0) {
      return var0.fK;
   }

   static boolean p(c3d_b var0, boolean var1) {
      return var0.gb = var1;
   }

   static long aw(c3d_b var0) {
      return var0.gn;
   }

   static int m(c3d_b var0, int var1) {
      return var0.fO = var1;
   }

   static boolean ax(c3d_b var0) {
      return var0.gb;
   }

   static void ay(c3d_b var0) {
      var0.D();
   }

   static boolean az(c3d_b var0) {
      return var0.fY;
   }

   static boolean q(c3d_b var0, boolean var1) {
      return var0.fY = var1;
   }

   static boolean aA(c3d_b var0) {
      return var0.gc;
   }

   static void aB(c3d_b var0) {
      var0.z();
   }

   static void aC(c3d_b var0) {
      var0.B();
   }

   static void aD(c3d_b var0) {
      var0.O();
   }

   static boolean aE(c3d_b var0) {
      return var0.fS;
   }

   static void a(c3d_b var0, int var1, int var2, int var3) {
      var0.b(var1, var2, var3);
   }

   static long p(c3d_b var0, long var1) {
      return var0.gn = var1;
   }

   static long aF(c3d_b var0) {
      return var0.iw;
   }

   static void aG(c3d_b var0) {
      var0.E();
   }

   static long q(c3d_b var0, long var1) {
      return var0.iw = var1;
   }

   static long aH(c3d_b var0) {
      return var0.iz;
   }

   static boolean r(c3d_b var0, boolean var1) {
      return var0.im = var1;
   }

   static long r(c3d_b var0, long var1) {
      return var0.iz = var1;
   }

   static long aI(c3d_b var0) {
      return var0.iG;
   }

   static boolean aJ(c3d_b var0) {
      return var0.ii;
   }

   static int n(c3d_b var0, int var1) {
      return var0.ia += var1;
   }

   static int aK(c3d_b var0) {
      return var0.ia;
   }

   static int[] aL(c3d_b var0) {
      return var0.gh;
   }

   static boolean s(c3d_b var0, boolean var1) {
      return var0.ii = var1;
   }

   static int o(c3d_b var0, int var1) {
      return var0.ia -= var1;
   }

   static int p(c3d_b var0, int var1) {
      return var0.fK = var1;
   }

   static int[] aM(c3d_b var0) {
      return var0.gx;
   }

   static int aN(c3d_b var0) {
      return var0.fH;
   }

   static boolean t(c3d_b var0, boolean var1) {
      return var0.gc = var1;
   }
}

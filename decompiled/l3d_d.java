// Source code is decompiled from a .class file using FernFlower decompiler.
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

public final class l3d_d extends Canvas {
   private int c = 10;
   private int d = 10;
   private int e = 10;
   private final short[] f = new short[]{3, 62, 121, 180};
   private short[] g;
   private short[] h;
   private short[] i;
   private short[] j;
   private byte[] k;
   private byte[] l;
   private byte[] m;
   private byte[] n;
   private byte[] o;
   private byte[] p;
   private byte[] q;
   private byte[] r;
   private byte[][] loadedMap;
   private byte[] lumpsSizes = new byte[]{5, 82, 10, 8};
   private String dataExt = ".b3d";
   private String[] mapFiles = new String[]{"/b", "/t", "/s", "/h", "/c", "/m", "/x", "/y", "/z"};
   private String[] spriteFiles = new String[]{"/p", "/r", "/pp", "/rr"};
   private byte[][] x = new byte[][]{{1, 1, -1, 1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {1, -1, 1, 1}};
   private Image y;
   private Image z;
   private byte[][][][] A;
   private byte[][][] B;
   private int[] C;
   private int[] D;
   private int[] E;
   private byte F;
   private int G;
   private int H;
   private int[] I;
   private int[][] J;
   private int[] K;
   private int L;
   private int M;
   private int N;
   private int O;
   private long P;
   private long Q;
   private long R;
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
   private int an;
   private int ao;
   private int ap;
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
   private byte aU;
   private byte aV;
   private boolean aW;
   private boolean aX;
   private boolean aY;
   private boolean aZ;
   private boolean ba;
   private long[] bb;
   private long[] bc;
   private long[] bd;
   private int[] be;
   private int[] bf;
   private int[] bg;
   private int[] bh;
   private int[] bi;
   private int[] bj;
   private int[] bk;
   private int[][] bl;
   private int[][] bm;
   private short[][] bn;
   private short[] bo;
   private short[] bp;
   private short[] bq;
   private short[] br;
   private short[] bs;
   private short[] bt;
   private byte[] bu;
   private byte[] bv;
   private byte[] bw;
   private byte[] bx;
   private short[][][] by;
   private boolean[] bz;
   private long bA;
   private long bB;
   private long bC;
   private long bD;
   private long bE;
   private long bF;
   private long bG;
   private long bH;
   private long bI;
   private long bJ;
   private int bK;
   private int bL;
   private int bM;
   private int bN;
   private int bO;
   private int bP;
   private int bQ;
   private int bR;
   private int bS;
   private int bT;
   private int bU;
   private int bV;
   private boolean bW;
   private long[] bX;
   private long[] bY;
   private long[] bZ;
   private long[] ca;
   private int[][] cb;
   private int[][] cc;
   private int[] cd;
   private int[] ce;
   private int[] cf;
   private short[] cg;
   private short[] ch;
   private short[] ci;
   private byte[] cj;
   private byte[] ck;
   private byte[] cl;
   private byte[] cm;
   private byte[] cn;
   private byte[] co;
   private byte[] cp;
   private byte[] cq;
   private byte[] cr;
   private byte[][] cs;
   private boolean[] ct;
   private boolean[] cu;
   private boolean[] cv;
   private boolean[] cw;
   private long cx;
   private long cy;
   private long cz;
   private long cA;
   private long cB;
   private long cC;
   private long cD;
   private long cE;
   private long cF;
   private long cG;
   private long cH;
   private long cI;
   private long cJ;
   private long cK;
   private int cL;
   private byte cM;
   private short[][] cN;
   private short[][] cO;
   private long cP;
   private long[] cQ;
   private long[] cR;
   private int[] cS;
   private int[] cT;
   private int[] cU;
   private int[] cV;
   private int[] cW;
   private int[] cX;
   private int[] cY;
   private int[] cZ;
   private int[] da;
   private int[] db;
   private int[] dc;
   private int[] dd;
   private int[] de;
   private int[] df;
   private int[][] dg;
   private byte[] dh;
   private byte[] di;
   private byte[] dj;
   private byte[] dk;
   private byte[] dl;
   private byte[] dm;
   private byte[] dn;
   private byte[] do_;
   private byte[] dp;
   private byte[] dq;
   private byte[] dr;
   private byte[] ds;
   private byte[] dt;
   private byte[] du;
   private byte[] dv;
   private byte[] dw;
   private byte[] dx;
   private byte[] dy;
   private byte[] dz;
   private byte[] dA;
   private byte[] dB;
   private byte[] dC;
   private byte[] dD;
   private byte[] dE;
   private byte[] dF;
   private byte[] dG;
   private int[][] dH;
   private int[][] dI;
   private byte[] dJ;
   private byte[] dK;
   private byte[] dL;
   private byte[] dM;
   private int[] dN;
   private int[] dO;
   private int[] dP;
   private int[] dQ;
   private int[] dR;
   private int[] dS;
   private int[] dT;
   private boolean dU;
   private int dV;
   private int dW;
   private int dX;
   private c dY;
   private long dZ;
   private long ea;
   private long eb;
   private long ec;
   private long ed;
   private int ee;
   private int ef;
   private int[] eg;
   private short[][] eh;
   private short[][] ei;
   private short[] ej;
   private short[] ek;
   byte[] a;
   private boolean[] el;
   private Random em;
   private long en;
   private long eo;
   private long ep;
   private long eq;
   private long er;
   private long es;
   private long et;
   private int eu;
   private int ev;
   private boolean ew;
   private boolean ex;
   private boolean ey;
   private boolean ez;
   private int[] eA;
   private int eB;
   private int eC = 40;
   private int eD;
   private int eE;
   private int eF;
   private int eG;
   private int eH;
   private int eI;
   private int eJ;
   private int eK;
   private int eL;
   private int eM;
   private int eN;
   private short eO;
   private boolean eP;
   private boolean eQ;
   private boolean eR;
   private boolean eS;
   private boolean eT = true;
   private boolean eU = true;
   private boolean eV;
   private int[] eW;
   private int[] eX;
   private int[] eY;
   private int[][] eZ;
   private int[][] fa;
   private Timer fb;
   private int fc;
   private int fd;
   private int fe;
   private long ff;
   private long fg;
   private long fh;
   private long fi;
   private long fj;
   private long fk;
   private long fl;
   private long fm;
   private long fn;
   private int fo;
   private int fp;
   private int fq;
   private int fr;
   private int fs;
   private int ft;
   private int fu;
   private int fv = 100;
   private int fw;
   private int fx;
   private int fy;
   private int fz;
   private int fA;
   private int fB;
   private int fC;
   private int fD;
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
   private int selectedMap;
   private short fR;
   private short fS;
   private short fT;
   private int fU;
   private int fV;
   private byte fW;
   private byte fX;
   private byte fY;
   private byte fZ;
   private byte ga;
   private byte gb;
   private boolean gc;
   private boolean gd;
   private boolean ge;
   private boolean gf;
   private boolean gg;
   private boolean gh;
   private boolean gi;
   private boolean gj;
   private boolean gk;
   private boolean gl;
   private boolean gm;
   private long[] gn;
   private int[] go;
   private int[] gp;
   private int[] gq;
   private int[] gr;
   private int[] gs;
   private short[] gt;
   private short[] gu;
   private short[][] gv;
   private byte[] gw;
   private byte[][] gx;
   private byte[][] gy;
   private int gz;
   private int gA = 35;
   private boolean gB;
   private int gC;
   private int gD;
   private int gE;
   private int gF;
   private int gG;
   private int gH;
   private boolean gI;
   private boolean gJ;
   private boolean gK;
   private boolean gL;
   private long gM;
   private long gN;
   private long gO;
   private long gP;
   private long gQ;
   private long gR;
   private long gS;
   private long gT;
   private long gU;
   private long gV;
   private long gW;
   private long gX;
   private long[] gY;
   private boolean[] gZ;
   private boolean[] ha;
   private int hb;
   private int hc;
   private int hd;
   private long he;
   private long hf;
   private boolean hg;
   private boolean hh;
   private long hi;
   private long hj;
   private int hk;
   private int hl;
   private int hm;
   private int hn;
   private int ho;
   private int hp;
   private int hq;
   private int hr;
   private int hs;
   private int ht;
   private int hu;
   private int hv;
   private int hw;
   private int hx;
   private int hy;
   private int hz;
   private int hA;
   private boolean hB;
   private boolean hC;
   private boolean hD;
   private boolean hE;
   private boolean hF;
   private boolean hG;
   private boolean hH;
   private int[][] hI;
   private int[] hJ;
   private int[] hK;
   private int[] hL;
   private int[] hM;
   private int[] hN;
   private int[] hO;
   private int[] hP;
   private int[] hQ;
   private int[] hR;
   private short[] hS;
   private byte[] hT;
   Display b;
   private String[] hU = new String[]{"0", "1", "1", "3", "4", "5", "6", "7", "8", "9", "o", "s"};
   private Player hV;
   private VolumeControl hW;
   private InputStream hX;
   private int[] hY;
   private int hZ;
   private int ia;
   private boolean ib;
   private RecordStore ic;
   private int[] id;
   private int[] ie;
   private int[] if;
   private int[] ig;
   private int ih;

   public l3d_d() {
      this.setFullScreenMode(true);
      this.em = new Random();
      this.fb = new Timer();
      this.hj = System.currentTimeMillis();
      this.b = Display.getDisplay(Laboratory3D.a());
      this.fN = 1;
      this.gI = false;
      this.hy = 0;
      this.hz = 0;
      this.hw = 0;
      this.hx = 0;
      this.X();
      this.gZ = new boolean[10];
      this.ha = new boolean[10];
      this.hY = new int[3];
      this.ib = true;
      this.ih = 0;

      try {
         this.Z();
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
      this.h(var1);
      if (this.fN == 3 && !this.gk) {
         if (this.hC) {
            this.a(false, var1);
         }

         if (this.hD && this.hH) {
            d(var1);
            this.hE = true;
            if (this.hF) {
               this.hF = false;
            }
         } else {
            if (this.hD && this.hE) {
               var1.setColor(0, 0, 0);
               var1.fillRect(0, 0, 240, 54);
               var1.fillRect(0, 266, 240, 54);
               this.hE = false;
            }

            this.b(var1);
         }
      }

      int var2;
      if (this.fN == 3 && this.gk) {
         this.D();
         d(var1);
         int var3 = this.hP[22];
         if (this.hD) {
            this.selectedMap = 10;
         }

         int var4 = this.hO[22] + this.selectedMap - 1;

         for(var2 = this.hO[22]; var2 < var4; ++var2) {
            var3 += this.q[var2];
         }

         this.a(var3, var4, var4, 240 - this.q[var2] * 15 >> 1, 7, var1);
         this.a(true);
         this.c(true);
         this.gm = true;
         this.gk = false;
      }

      label87: {
         l3d_d var10000;
         byte var10001;
         if (this.hD && this.hH && !this.gm) {
            this.hn = 17 + (this.hv >> 2);
            var2 = this.hn != 17 && this.hn == 18 ? 33 : 20;
            this.a(this.hP[this.hn], this.hO[this.hn], this.hO[this.hn] + this.p[this.hn] - 1, var2, 6, var1);
            var10000 = this;
            var10001 = 0;
         } else {
            if (!this.hD || this.gm) {
               break label87;
            }

            var10000 = this;
            var10001 = 54;
         }

         var10000.b(var10001, (Graphics)var1);
      }

      this.fb.schedule(new b(this, (a)null), 0L);
   }

   private int a() {
      return abs(this.E());
   }

   private void a(Graphics var1) {
      var1.setColor(128, 128, 128);
      int var2 = this.a() % (this.d + 1);
      int var3 = this.hD ? this.e + 54 : this.e;

      for(int var4 = 0; var4 < var2; ++var4) {
         int var5 = this.a() % 240;
         int var6 = this.a() % (320 - (var3 << 1)) + var3;
         int var7 = var5 + this.E() % this.e;
         int var8 = var6 + this.E() % this.e;
         var1.drawLine(var5, var6, var7, var8);
      }

   }

   private void b(Graphics var1) {
      l3d_d var10000;
      if (this.eO == 6) {
         label345: {
            ++this.selectedMap;
            byte var21;
            if (this.selectedMap != 4 && this.selectedMap != 9) {
               if (this.selectedMap != 1) {
                  break label345;
               }

               var10000 = this;
               var21 = 2;
            } else {
               var10000 = this;
               var21 = 3;
            }

            var10000.fS = var21;
         }

         this.gE = 0;
         if (this.selectedMap != 12) {
            if (this.ih < this.selectedMap) {
               this.ih = this.selectedMap;
            }

            this.id[this.selectedMap - 1] = this.eE;
            this.ie[this.selectedMap - 1] = this.fo;
            this.if[this.selectedMap - 1] = this.fp;
            this.ig[this.selectedMap - 1] = this.fq;

            try {
               if (this.hV != null) {
                  this.hV.stop();
               }
            } catch (Exception var7) {
            }

            this.aa();
         }

         this.eO = 0;
         this.gk = true;
         this.gc = true;
         this.fw = this.eE;
         this.fs = this.fo;
         this.ft = this.fp;
         this.fu = this.fq;
         this.u();
         this.cv[15] = false;
         this.cv[16] = false;
         this.cv[17] = false;
      } else {
         if (this.eO >= 1 && this.eO <= 5) {
            ++this.eO;
         }

         int var10001;
         if (this.gc) {
            this.b.numColors();
            boolean var3 = false;
            Runtime.getRuntime().totalMemory();
            this.gz = var1.getClipHeight();
            if (this.h == null) {
               this.readMetadata();
            }

            this.initCosTable();
            this.loadMap();
            this.m();
            this.s();
            this.ei = new short[7][];

            for(int var2 = 0; var2 < 7; ++var2) {
               this.y(var2);
            }

            this.o();
            if (this.hD) {
               this.fU = 0;
            }

            this.dY = new c(this, this.ei[this.fU][0], (a)null);

            for(int var6 = 1; var6 < this.ei[this.fU].length; ++var6) {
               c.a(this.dY, this.ei[this.fU][var6]);
            }

            this.p();
            this.eP = false;
            this.eB = this.eE;
            if (!this.hD) {
               this.a(true, var1);
            }

            this.n();
            this.t();
            this.ge = false;
            this.gf = false;
            this.gg = false;
            this.fO = -1;
            this.fP = -1;
            this.eI = 0;
            this.eK = -1;
            this.eQ = true;
            this.eW = new int[9];
            this.eY = new int[9];
            this.ez = false;
            this.an = -1;
            this.bU = -1;
            this.ao = -1;
            this.dU = false;
            if (this.hD) {
               d(var1);
            }

            this.gc = false;
            this.hH = true;
            this.fl = System.currentTimeMillis();
            this.gC = -10000;
            this.I();
            this.K();
            if (this.selectedMap == 20) {
               this.eP = false;
               var10000 = this;
               var10001 = 1;
            } else {
               var10000 = this;
               var10001 = 6;
            }

            var10000.eG = var10001;
            this.C(this.selectedMap);
            if (this.hD) {
               return;
            }
         }

         this.hC = false;
         if (this.ez) {
            if (this.gL) {
               this.a(0, 6, (Graphics)var1);
               this.gL = false;
            }

            this.e(var1);
         } else {
            if (this.bk == null) {
               this.bk = new int['챪'];
            }

            int var10003;
            int var10004;
            if (this.eQ && !this.hD) {
               Image var8;
               label302: {
                  this.eZ = new int[9][];
                  var8 = this.readImage("/w" + this.dataExt);
                  this.eW[0] = this.j[this.eE * 8 + 2];
                  this.eY[0] = this.j[this.eE * 8 + 3];
                  this.eZ[0] = new int[this.eW[0] * this.eY[0]];
                  this.a(var8, this.eZ[0], this.eW[0], this.eY[0], this.j[this.eE * 8], this.j[this.eE * 8 + 1], false);
                  this.eW[1] = this.j[this.eE * 8 + 4 + 2];
                  this.eY[1] = this.j[this.eE * 8 + 4 + 3];
                  this.eZ[1] = new int[this.eW[1] * this.eY[1]];
                  this.a(var8, this.eZ[1], this.eW[1], this.eY[1], this.j[this.eE * 8 + 4], this.j[this.eE * 8 + 4 + 1], false);
                  Image var10;
                  int[] var10002;
                  short var10005;
                  short var10006;
                  boolean var10007;
                  if (this.eE == 0) {
                     this.eZ[2] = new int[this.eW[0] * this.eY[0]];
                     this.a(var8, this.eZ[2], this.eW[0], this.eY[0], this.j[this.eE * 8], this.j[this.eE * 8 + 1], true);
                     this.eZ[3] = new int[this.eW[1] * this.eY[1]];
                     var10000 = this;
                     var10 = var8;
                     var10002 = this.eZ[3];
                     var10003 = this.eW[1];
                     var10004 = this.eY[1];
                     var10005 = this.j[this.eE * 8 + 4];
                     var10006 = this.j[this.eE * 8 + 4 + 1];
                     var10007 = true;
                  } else {
                     if (this.eE != 3) {
                        break label302;
                     }

                     this.eW[2] = this.j[34];
                     this.eY[2] = this.j[35];
                     this.eZ[2] = new int[this.eW[2] * this.eY[2]];
                     var10000 = this;
                     var10 = var8;
                     var10002 = this.eZ[2];
                     var10003 = this.eW[2];
                     var10004 = this.eY[2];
                     var10005 = this.j[32];
                     var10006 = this.j[33];
                     var10007 = false;
                  }

                  var10000.a(var10, var10002, var10003, var10004, var10005, var10006, var10007);
               }

               if (this.eE == 2) {
                  this.eW[4] = this.j[38];
                  this.eY[4] = this.j[39];
                  this.eZ[4] = new int[this.eW[4] * this.eY[4]];
                  this.a(var8, this.eZ[4], this.eW[4], this.eY[4], this.j[36], this.j[37], false);
               }

               this.eW[6] = this.j[42];
               this.eY[6] = this.j[43];
               this.eZ[6] = new int[this.eW[6] * this.eY[6]];
               this.a(var8, this.eZ[6], this.eW[6], this.eY[6], this.j[40], this.j[41], false);
               this.eW[7] = this.j[46];
               this.eY[7] = this.j[47];
               this.eZ[7] = new int[this.eW[7] * this.eY[7]];
               this.a(var8, this.eZ[7], this.eW[7], this.eY[7], this.j[44], this.j[45], false);
               this.eW[8] = this.j[50];
               this.eY[8] = this.j[51];
               this.eZ[8] = new int[this.eW[8] * this.eY[8]];
               this.a(var8, this.eZ[8], this.eW[8], this.eY[8], this.j[48], this.j[49], false);
               this.c(var1);
               this.eQ = false;
            }

            this.bl = new int[2][240];
            this.bz = new boolean[240];
            this.bu = new byte[240];
            this.av = -1;
            this.aw = 240;
            this.e();
            this.fm = (this.gn[0] << 16) / 75000L;
            this.fn = (this.gn[1] << 16) / 75000L;
            this.d();
            this.a(this.dY);
            int var9 = this.cs[this.fU].length;
            this.bK = 0;
            this.bW = false;
            this.B(var9);
            this.bK = 0;
            this.bW = true;
            this.B(var9);
            if (!this.hD && this.gi) {
               this.B();
            }

            if (this.fo < this.fP) {
               this.C();
            }

            var1.drawRGB(this.bk, 240 * (3 - this.hd), 240, 0, 54, 240, 212, false);
            if (!this.hD) {
               if (this.fp != this.fO) {
                  this.a(this.fr, 189, (Graphics)var1);
               }

               if (this.fo != this.fP) {
                  this.a(this.fo, 6, (Graphics)var1);
               }
            }

            if (!this.hD) {
               if (this.ex) {
                  this.fo = 0;
                  this.a(this.fo, 6, (Graphics)var1);
                  this.F();
                  this.fo = this.fs;
                  if (this.fo > 100) {
                     this.fv = 200;
                  }

                  this.fp = this.ft;
                  this.fq = this.fu;
                  this.eE = this.fw;
                  if (this.eE == 3) {
                     var10000 = this;
                     var10001 = this.fq;
                  } else {
                     var10000 = this;
                     var10001 = this.fp;
                  }

                  var10000.fr = var10001;
                  if (this.fr > 0) {
                     this.eU = true;
                  }

                  return;
               }

               int var11;
               label347: {
                  if (this.eL == 53 && this.fr > 0) {
                     if (this.cb[65][0] != 0 && this.cb[65][1] != 0 && this.eH == 0) {
                        this.cb[65][0] = 0;
                        this.cb[65][1] = 0;
                     }

                     if (this.eE == 1) {
                        var10000 = this;
                        var10001 = this.eE;
                        var11 = this.eH;
                        var10003 = 0;
                        var10004 = this.eH * 2;
                        break label347;
                     }

                     if (this.eE == 2) {
                        var10000 = this;
                        var10001 = this.eE;
                        var11 = this.eH;
                        var10003 = 0;
                        var10004 = 0;
                        break label347;
                     }

                     if (this.eE == 0) {
                        if (this.eH == 0) {
                           var10000 = this;
                           var10001 = this.eE;
                           var11 = 0;
                           var10003 = 0;
                           var10004 = 0;
                        } else if (this.eR) {
                           var10000 = this;
                           var10001 = this.eE;
                           var11 = this.eH;
                           var10003 = 0;
                           var10004 = 0;
                        } else {
                           var10000 = this;
                           var10001 = this.eE;
                           var11 = 0;
                           var10003 = this.eH;
                           var10004 = 0;
                        }
                        break label347;
                     }

                     var10000 = this;
                  } else {
                     this.cb[65][0] = 0;
                     this.cb[65][1] = 0;
                     if (this.eE != 3) {
                        var10000 = this;
                        var10001 = this.eE;
                        var11 = 0;
                        var10003 = 0;
                        var10004 = this.eI;
                        break label347;
                     }

                     if (this.eU || this.eH == 0) {
                        var10000 = this;
                        var10001 = this.eE;
                        var11 = 0;
                        var10003 = 0;
                        var10004 = this.eI;
                        break label347;
                     }

                     var10000 = this;
                  }

                  var10001 = this.eE;
                  var11 = this.eH;
                  var10003 = 0;
                  var10004 = this.gG;
               }

               var10000.a(var10001, var11, var10003, var10004, var1);
               if (this.eE == 3) {
                  var1.drawRGB(this.hK, 0, 24, 156, 281, 24, 25, true);
               } else {
                  var1.drawRGB(this.hL, 0, 24, 156, 281, 24, 25, true);
               }
            }

            if (this.ge) {
               var1.drawRGB(this.go, 0, 28, 210, 236, 28, 28, false);
            }

            if (this.gf) {
               Graphics var12;
               int[] var13;
               byte var14;
               short var15;
               byte var16;
               byte var17;
               byte var19;
               byte var20;
               if (this.selectedMap != 7 && this.selectedMap != 8) {
                  var12 = var1;
                  var13 = this.gp;
                  var14 = 0;
                  var16 = 26;
                  var19 = 2;
                  var15 = 238;
                  var17 = 26;
                  var20 = 26;
               } else {
                  var12 = var1;
                  var13 = this.gp;
                  var14 = 0;
                  var16 = 48;
                  var19 = 2;
                  var15 = 240;
                  var17 = 48;
                  var20 = 24;
               }

               var12.drawRGB(var13, var14, var16, var19, var15, var17, var20, false);
            }

            if (this.gg) {
               var1.drawRGB(this.gq, 0, 28, 210, 236, 28, 28, false);
            }

            boolean var18;
            if (this.fr > 0 && this.eH != 2) {
               var10000 = this;
               var18 = false;
            } else {
               var10000 = this;
               var18 = true;
            }

            var10000.eV = var18;
            this.fO = this.fr;
            this.fP = this.fo;
            if (this.eS) {
               label349: {
                  if (this.eD >= 0 && this.eD <= 3) {
                     var10000 = this;
                     var10001 = this.eC - 10;
                  } else {
                     if (this.eD < 20 || this.eD > 23) {
                        break label349;
                     }

                     var10000 = this;
                     var10001 = this.eC + 10;
                  }

                  var10000.eC = var10001;
               }

               this.eJ = this.eD % 4;
               this.a(this.eJ, var1);
               this.fo -= this.gb;
               if (this.fo <= 100) {
                  this.fv = 100;
               }

               if (this.fo <= 0 && !this.ez) {
                  this.fo = 0;
                  this.a(this.fo, 6, (Graphics)var1);
                  this.F();
                  this.fo = this.fs;
                  if (this.fo > 100) {
                     this.fv = 200;
                  }

                  this.fp = this.ft;
                  this.fq = this.fu;
                  this.eE = this.fw;
                  if (this.eE == 3) {
                     var10000 = this;
                     var10001 = this.fq;
                  } else {
                     var10000 = this;
                     var10001 = this.fp;
                  }

                  var10000.fr = var10001;
                  if (this.fr > 0) {
                     this.eU = true;
                  }

                  this.eH = 0;
                  this.eD = 0;
                  this.eS = false;
                  this.eJ = 0;
                  this.eC = 40;
                  return;
               }

               if (this.eD == 23) {
                  this.eD = 0;
                  this.eS = false;
                  this.eJ = 0;
                  this.eC = 40;
               } else {
                  ++this.eD;
               }
            }

            if (this.ey) {
               this.fo -= 50;
               if (this.fo <= 100) {
                  this.fv = 100;
               }

               if (this.fo <= 0 && !this.ez) {
                  this.fo = 0;
                  this.a(this.fo, 6, (Graphics)var1);
                  this.F();
                  this.fo = this.fs;
                  if (this.fo > 100) {
                     this.fv = 200;
                  }

                  this.fp = this.ft;
                  this.fq = this.fu;
                  this.eE = this.fw;
                  if (this.eE == 3) {
                     var10000 = this;
                     var10001 = this.fq;
                  } else {
                     var10000 = this;
                     var10001 = this.fp;
                  }

                  var10000.fr = var10001;
                  if (this.fr > 0) {
                     this.eU = true;
                  }

                  this.ey = false;
                  this.eH = 0;
                  return;
               }

               this.ey = false;
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
      byte[] var4 = this.readBinary("/a" + this.dataExt);
      short[] var5 = new short[12];

      int var1;
      for(var1 = 0; var1 < 12; ++var1) {
         var5[var1] = readShort(var4, var2);
         var2 += 2;
      }

      short var3 = var5[0];
      this.h = new short[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.h[var1] = readShort(var4, var2);
         var2 += 2;
      }

      var3 = var5[1];
      this.i = new short[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.i[var1] = readShort(var4, var2);
         var2 += 2;
      }

      var3 = var5[2];
      this.k = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.k[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[3];
      this.l = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.l[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[4];
      this.m = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.m[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[5];
      this.n = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.n[var1] = (byte)(readShort(var4, var2) - 128);
         var2 += 2;
      }

      var3 = var5[6];
      this.j = new short[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         short[] var10000;
         int var10001;
         int var10002;
         if (var4[var2] >= 0) {
            var10000 = this.j;
            var10001 = var1;
            var10002 = var4[var2];
         } else {
            var10000 = this.j;
            var10001 = var1;
            var10002 = 256 + var4[var2];
         }

         var10000[var10001] = (short)(var10002 * 2);
         ++var2;
      }

      var3 = var5[7];
      this.o = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.o[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[8];
      this.p = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.p[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[9];
      this.q = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.q[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[10];
      this.r = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.r[var1] = var4[var2];
         ++var2;
      }

      var3 = var5[11];
      this.a = new byte[var3];

      for(var1 = 0; var1 < var3; ++var1) {
         this.a[var1] = var4[var2];
         ++var2;
      }

   }

   private void loadMap() {
      boolean var3 = false;
      int var5 = this.selectedMap == 0 ? 1 : this.selectedMap;
      l3d_d var10000;
      StringBuffer var10001;
      String var10002;
      if (!this.hD) {
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
      this.loadedMap = new byte[6][];
      int var4 = var7 * 4;
      this.loadedMap[0] = new byte[var4];
      int var11 = 6;

      int var2;
      for(var2 = 0; var2 < var4; var2 += 4) {
         this.loadedMap[0][var2] = (byte)((var6[var11 + 1] & 240) >> 4);
         this.loadedMap[0][var2 + 1] = (byte)(var6[var11 + 1] & 15);
         this.loadedMap[0][var2 + 2] = (byte)((var6[var11] & 240) >> 4);
         this.loadedMap[0][var2 + 3] = (byte)(var6[var11] & 15);
         var11 += 2;
      }

      this.loadedMap[1] = new byte[this.lumpsSizes[0]];
      this.g = new short[5];
      byte var12 = this.lumpsSizes[0];

      for(var2 = 0; var2 < var12; ++var2) {
         short var1 = readShort(var6, var11);
         this.g[var2] = var1;
         byte[] var13;
         int var14;
         int var15;
         if (var1 >= 128) {
            var13 = this.loadedMap[1];
            var14 = var2;
            var15 = 127 - var1;
         } else {
            var13 = this.loadedMap[1];
            var14 = var2;
            var15 = var1;
         }

         var13[var14] = (byte)var15;
         var11 += 2;
      }

      this.loadedMap[2] = new byte[var8];

      for(var2 = 0; var2 < var8; ++var2) {
         this.loadedMap[2][var2] = var6[var11];
         ++var11;
      }

      var12 = this.lumpsSizes[1];
      this.loadedMap[3] = new byte[var12];

      for(var2 = 0; var2 < var12; ++var2) {
         this.loadedMap[3][var2] = var6[var11];
         ++var11;
      }

      this.loadedMap[4] = new byte[var9];

      for(var2 = 0; var2 < var9; ++var2) {
         this.loadedMap[4][var2] = var6[var11];
         ++var11;
      }

      var12 = this.lumpsSizes[2];
      this.loadedMap[5] = new byte[var12];

      for(var2 = 0; var2 < var12; ++var2) {
         this.loadedMap[5][var2] = var6[var11];
         ++var11;
      }

      short[] footer = new short[var12 = this.lumpsSizes[3]];

      for(var2 = 0; var2 < var12; ++var2) {
         footer[var2] = readShort(var6, var11);
         var11 += 2;
      }

      this.loadMapInner(footer);
      this.n = null;
      this.A = (byte[][][][])null;
      this.I = null;
      System.gc();
   }

   private void loadMapInner(short[] footer) {
      this.A = new byte[3][][][];
      this.loadMapPart((byte[])this.loadedMap[0], (byte[])this.loadedMap[1], (byte[])this.l, 0);
      this.loadMapPart((byte[])this.loadedMap[2], (byte[])this.loadedMap[3], (byte[])this.m, 1);
      this.modifyBigLumps01(this.A[0], this.A[1]);
      this.modifyBigLump1(this.A[1]);
      this.loadMapPart((byte[])this.loadedMap[4], (byte[])this.loadedMap[5], (byte[])this.k, 2);
      this.loadSpritesPart1(this.A[2]);
      this.loadSpritesPart2(this.A[2]);
      this.loadSpritesPart3(this.A[2]);
      this.loadedMap = (byte[][])null;
      this.A[2] = (byte[][][])null;
      this.c(false);
      System.gc();
      this.initFloorCeilingColor(footer);
      this.loadTextures(this.A[0], this.A[1], footer);
      this.hg = false;
      this.L();
   }

   private void loadMapPart(byte[] lumpA, byte[] lumpB, byte[] mapMetadata, int A_idx) {
      int var8 = 0;
      int var10 = lumpB.length;
      this.A[A_idx] = new byte[var10][][];

      for(int var5 = 0; var5 < var10; ++var5) {
         int var9 = lumpB[var5] < 0 ? 127 - lumpB[var5] : lumpB[var5];
         this.A[A_idx][var5] = new byte[var9][mapMetadata[var5]];

         for(int var6 = 0; var6 < var9; ++var6) {
            byte var11 = mapMetadata[var5];

            for(int var7 = 0; var7 < var11; ++var7) {
               this.A[A_idx][var5][var6][var7] = lumpA[var8];
               ++var8;
            }
         }
      }

   }

   private void modifyBigLumps01(byte[][][] bigLump0, byte[][][] bigLump1) {
      boolean var3 = false;
      int var11 = 0;
      int var12 = 0;
      int var17 = bigLump0[0].length + bigLump1[7].length + bigLump1[12].length * 4 + bigLump1[20].length * 3 + bigLump1[33].length * 4 + bigLump1[41].length * 4;
      int var7 = bigLump1[51].length + 1;
      this.bf = new int[var7];
      this.bf[0] = var17;

      int var4;
      for(var4 = 1; var4 < var7; ++var4) {
         this.bf[var4] = this.bf[var4 - 1] + bigLump1[51][var4 - 1][2];
      }

      var17 = this.bf[var4 - 1];
      this.s(var17);
      this.bw = new byte[var17];
      var7 = bigLump1[31].length;

      for(var4 = 0; var4 < var7; ++var4) {
         this.bw[bigLump1[31][var4][0] + 128] = bigLump1[31][var4][1];
      }

      var7 = bigLump0[0].length;
      int var8 = bigLump1[7].length;

      for(var4 = 0; var4 < var7; ++var4) {
         if (var11 < var8 && var12 == bigLump1[7][var11][0] + 128) {
            if (var11 != 0) {
               this.dg[2][var12 - 1] = bigLump1[7][var11 - 1][1];
               this.dg[3][var12 - 1] = bigLump1[7][var11 - 1][2];
            }

            this.dg[0][var12] = bigLump1[7][var11][1];
            this.dg[1][var12] = bigLump1[7][var11][2];
            ++var11;
            ++var12;
         }

         long var13 = (long)(bigLump0[0][var4][0] - 7);
         long var15 = (long)(bigLump0[0][var4][1] - 7);
         this.dg[0][var12] = (int)(var13 + (long)this.dg[0][var12 - 1]);
         this.dg[1][var12] = (int)(var15 + (long)this.dg[1][var12 - 1]);
         this.dg[2][var12 - 1] = this.dg[0][var12];
         this.dg[3][var12 - 1] = this.dg[1][var12];
         ++var12;
      }

      this.dg[2][var12 - 1] = bigLump1[7][var11 - 1][1];
      this.dg[3][var12 - 1] = bigLump1[7][var11 - 1][2];

      for(int var18 = 0; var18 < var12; ++var18) {
         for(var4 = 0; var4 < 4; ++var4) {
            int[] var10000 = this.dg[var4];
            var10000[var18] <<= 16;
         }
      }

      this.fF = var12;
      var12 = 0;
      var11 = 0;
      this.dh = new byte[var17];
      var7 = bigLump0[1].length;
      int var9 = bigLump1[7].length;
      int var10 = bigLump1[10].length;

      int var5;
      int var6;
      for(var4 = 0; var4 < var7; ++var4) {
         var8 = bigLump0[1][var4].length;

         label159:
         for(var5 = 0; var5 < var8; ++var5) {
            if (var11 < var9 && var12 == bigLump1[7][var11][0] + 128) {
               if (var11 != 0) {
                  this.dh[var12 - 1] = bigLump1[7][var11 - 1][4];
               }

               this.dh[var12] = bigLump1[7][var11][3];
               ++var11;
               ++var12;
            }

            int var10001;
            byte[] var10002;
            byte[] var19;
            int var10003;
            if (bigLump0[1][var4][var5] == 15) {
               var6 = 0;

               while(true) {
                  if (var6 >= var10) {
                     continue label159;
                  }

                  if (bigLump1[10][var6][0] + 128 == var12) {
                     var19 = this.dh;
                     var10001 = var12;
                     var10002 = bigLump1[10][var6];
                     var10003 = 1;
                     break;
                  }

                  ++var6;
               }
            } else {
               var19 = this.dh;
               var10001 = var12;
               var10002 = bigLump0[1][var4];
               var10003 = var5;
            }

            var19[var10001] = var10002[var10003];
            ++var12;
         }
      }

      this.dh[var12 - 1 - bigLump1[8][0][4]] = bigLump1[7][var11 - 1][4];
      var7 = bigLump0[2].length;
      var8 = bigLump1[29].length;

      for(var4 = 0; var4 < var7; ++var4) {
         for(var5 = 0; var5 < 5; ++var5) {
            if (bigLump0[2][var4][var5] != 15) {
               if (bigLump0[2][var4][var5] == 7) {
                  bigLump0[2][var4][var5] = -7;
               } else if (bigLump0[2][var4][var5] != 0) {
                  bigLump0[2][var4][var5] = (byte)(bigLump0[2][var4][var5] - 7);
               }
            } else {
               for(var6 = 0; var6 < var8; ++var6) {
                  if (bigLump1[29][var6][0] == var4 && bigLump1[29][var6][1] == var5) {
                     bigLump0[2][var4][var5] = bigLump1[29][var6][2];
                     break;
                  }
               }
            }
         }
      }

      for(var4 = 0; var4 < var7; ++var4) {
         var8 = bigLump0[2][var4].length;

         for(var5 = 6; var5 < var8; ++var5) {
            bigLump0[2][var4][var5] = (byte)(bigLump0[2][var4][var5] * 3);
         }
      }

      var7 = bigLump0[3].length;

      for(var4 = 0; var4 < var7; ++var4) {
         for(var5 = 1; var5 <= 2; ++var5) {
            bigLump0[3][var4][var5] = (byte)(bigLump0[3][var4][var5] * 3);
         }
      }

      var7 = bigLump0[4].length;

      for(var4 = 0; var4 < var7; ++var4) {
         var8 = bigLump0[4][var4].length;

         for(var5 = 0; var5 < var8; ++var5) {
            bigLump0[4][var4][var5] = (byte)(bigLump0[4][var4][var5] * 3);
         }
      }

   }

   private void modifyBigLump1(byte[][][] bigLump1) {
      this.cN = new short[7][];
      this.cO = new short[7][];
      this.fI = this.fF;
      this.fJ = this.fI + 4 * bigLump1[12].length;
      this.fK = this.fJ + 3 * bigLump1[20].length;

      int var2;
      int var3;
      int var6;
      int var10;
      int var12;
      int var13;
      int var14;
      int var10001;
      int var10002;
      for(var2 = 0; var2 < 7; ++var2) {
         var12 = bigLump1[var2].length + bigLump1[var2 + 13].length + bigLump1[var2 + 21].length + bigLump1[var2 + 42].length + bigLump1[var2 + 52].length;
         this.cN[var2] = new short[var12];
         this.cO[var2] = new short[var12];
         var10 = bigLump1[var2].length;

         for(var3 = 0; var3 < var10; ++var3) {
            this.cN[var2][var3] = (short)(bigLump1[var2][var3][0] + 128);
            this.cO[var2][var3] = (short)(bigLump1[var2][var3][1] + 128);
         }

         var10 = bigLump1[var2 + 13].length + var3;

         short[] var10000;
         for(var6 = var3; var6 < var10; ++var6) {
            var13 = bigLump1[var2 + 13][var6 - var3][0];
            this.cN[var2][var6] = (short)(this.fI + var13 * 4);
            this.cO[var2][var6] = (short)(this.cN[var2][var6] + 3);
            if (abs(var14 = bigLump1[12][var13][3] % 90) <= 3) {
               var10000 = this.cO[var2];
               var10001 = var6;
               var10002 = var10000[var6] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cN[var2];
               var10001 = var6;
               var10002 = var10000[var6] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[12][var13][3] = (byte)(bigLump1[12][var13][3] - var14);
         }

         var10 = bigLump1[var2 + 21].length + var6;

         int var7;
         for(var7 = var6; var7 < var10; ++var7) {
            this.cN[var2][var7] = (short)(this.fJ + abs(bigLump1[var2 + 21][var7 - var6][0]) % 60 * 3);
            this.cO[var2][var7] = (short)(this.cN[var2][var7] + 2);
            if (bigLump1[var2 + 21][var7 - var6][0] < 0) {
               var10000 = this.cN[var2];
               var10001 = var7;
               var10002 = var10000[var7] + 2;
            } else {
               if (bigLump1[var2 + 21][var7 - var6][0] < 60) {
                  continue;
               }

               var10000 = this.cO[var2];
               var10001 = var7;
               var10002 = var10000[var7] - 2;
            }

            var10000[var10001] = (short)var10002;
         }

         var10 = bigLump1[var2 + 42].length + var7;

         int var8;
         for(var8 = var7; var8 < var10; ++var8) {
            var13 = bigLump1[var2 + 42][var8 - var7][0];
            this.cN[var2][var8] = (short)(this.fK + var13 * 4);
            this.cO[var2][var8] = (short)(this.cN[var2][var8] + 3);
            if (abs(var14 = bigLump1[41][var13][2] % 90) <= 3) {
               var10000 = this.cO[var2];
               var10001 = var8;
               var10002 = var10000[var8] - abs(var14);
            } else {
               if (abs(var14) > 6) {
                  continue;
               }

               var10000 = this.cN[var2];
               var10001 = var8;
               var10002 = var10000[var8] + (abs(var14) - 3);
            }

            var10000[var10001] = (short)var10002;
            bigLump1[41][var13][2] = (byte)(bigLump1[41][var13][2] - var14);
         }

         var10 = bigLump1[var2 + 52].length + var8;

         for(int var9 = var8; var9 < var10; ++var9) {
            this.cN[var2][var9] = (short)this.bf[bigLump1[var2 + 52][var9 - var8][0]];
            this.cO[var2][var9] = (short)(this.bf[bigLump1[var2 + 52][var9 - var8][0] + 1] - 1);
         }
      }

      l3d_d var25;
      byte var26;
      long var28;
      if (this.selectedMap != 11) {
         var25 = this;
         var26 = bigLump1[8][0][0];
         var28 = (long)bigLump1[8][0][1] * 75000L;
      } else {
         var25 = this;
         var26 = bigLump1[8][0][0];
         var28 = (long)bigLump1[8][0][1] * 75000L + 32768L;
      }

      var25.initStartingPos(var26, var28, (long)bigLump1[8][0][2] * 75000L, bigLump1[8][0][3] * 2, bigLump1[8][0][7]);
      this.cM = (byte)(13 + bigLump1[8][0][5]);
      this.cL = bigLump1[8][0][6];
      var12 = this.fF;
      this.fG = bigLump1[12].length;
      var13 = 106 + this.fG;
      this.cq = new byte[var13];
      this.cb = new int[var13][2];
      this.cw = new boolean[var13];
      this.cn = new byte[var13];
      this.cr = new byte[var13];
      var10 = bigLump1[12].length;

      byte[] var27;
      for(var3 = 0; var3 < var10; ++var3) {
         var14 = 128 + bigLump1[12][var3][0] << 16 >> 2;
         int var15 = 128 + bigLump1[12][var3][1] << 16 >> 2;
         var6 = 106 + var3;
         this.cb[var6][0] = var14;
         this.cb[var6][1] = var15;
         this.cq[var6] = (byte)(this.cM - 1);
         this.cw[var6] = false;
         this.cn[var6] = (byte)(this.cM + 2 + bigLump1[12][var3][4]);
         if (bigLump1[12][var3][4] > 4) {
            var27 = this.cn;
            var27[var6] = (byte)(var27[var6] - 4);
            this.cr[var6] = 1;
         }

         var12 = this.modifyBigLump1_subfunction1((long)var14, (long)var15, 16384L, 16384L, bigLump1[12][var3][3], var12, bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], (byte)1, (byte)0);
      }

      this.fH = bigLump1[20].length;
      this.dH = new int[this.fH][2];
      this.dJ = new byte[this.fH];
      this.dK = new byte[this.fH];
      this.dN = new int[this.fH];
      this.dO = new int[this.fH];
      this.dL = new byte[this.fH];
      this.dP = new int[this.fH];
      this.dQ = new int[this.fH];
      this.dR = new int[this.fH];
      this.dS = new int[this.fH];
      this.dI = new int[this.fH][2];
      this.dT = new int[this.fH];
      this.dM = new byte[this.fH];
      var10 = bigLump1[20].length;

      for(var3 = 0; var3 < var10; ++var3) {
         this.dH[var3][0] = 128 + bigLump1[20][var3][0] << 16 >> 2;
         this.dH[var3][1] = 128 + bigLump1[20][var3][1] << 16 >> 2;
         byte var30;
         if (bigLump1[20][var3][2] * bigLump1[20][var3][3] >= 0) {
            this.dJ[var3] = 0;
            var27 = this.dK;
            var10001 = var3;
            var30 = 1;
         } else {
            this.dJ[var3] = 1;
            var27 = this.dK;
            var10001 = var3;
            var30 = 0;
         }

         var27[var10001] = var30;
         this.dN[var3] = (bigLump1[20][var3][2] << 16) / 127;
         this.dO[var3] = (bigLump1[20][var3][3] << 16) / 127;
         this.dV = this.dO[var3];
         this.dL[var3] = bigLump1[59][var3][3];
         this.dR[var3] = 0;
         this.dS[var3] = 6225920;
         int[] var29;
         if (this.dO[var3] > 0) {
            var29 = this.dP;
            var10001 = var3;
            var10002 = 65536;
         } else {
            var29 = this.dP;
            var10001 = var3;
            var10002 = -65536;
         }

         var29[var10001] = var10002;
         this.dW = this.dP[var3];
         this.dQ[var3] = (this.dP[var3] - this.dO[var3]) / this.dL[var3];
         this.dX = this.dQ[var3];
         this.dI[var3][this.dJ[var3]] = this.dH[var3][this.dJ[var3]] + this.dP[var3];
         this.dI[var3][this.dK[var3]] = this.dH[var3][this.dK[var3]];
         this.dT[var3] = -1;
         this.dM[var3] = bigLump1[28][var3][0];
         this.modifyBigLump1_subfunction2(bigLump1[59][var3][0], bigLump1[59][var3][1], bigLump1[59][var3][2], var12);
         this.modifyBigLump1_subfunction3(this.dH[var3], (long)this.dN[var3], (long)this.dP[var3], this.dJ[var3], this.dK[var3], var12, 0);
         var12 = this.modifyBigLump1_subfunction3(this.dH[var3], (long)this.dN[var3], (long)this.dO[var3], this.dJ[var3], this.dK[var3], var12, 1);
      }

      this.fF = var12;
      this.bx = new byte[bigLump1[30].length * 7];
      this.bp = new short[32 + bigLump1[30].length];
      int var5 = 0;
      var10 = bigLump1[30].length;

      int var11;
      for(var3 = 0; var3 < var10; ++var3) {
         this.bp[32 + var3] = 96;
         var11 = bigLump1[30][var3].length;

         for(int var4 = 0; var4 < var11; ++var4) {
            this.bx[var5] = bigLump1[30][var3][var4];
            ++var5;
         }
      }

      var12 = this.fF;
      var10 = bigLump1[41].length;

      long var16;
      long var24;
      for(var3 = 0; var3 < var10; ++var3) {
         var24 = (long)(128 + bigLump1[41][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[41][var3][1] << 16 >> 2);
         long var18 = (long)((bigLump1[60][var3][0] << 16) / 42 >> 1);
         long var20 = (long)((bigLump1[60][var3][1] << 16) / 42 >> 1);
         var12 = this.modifyBigLump1_subfunction1(var24, var16, var18, var20, bigLump1[41][var3][2], var12, bigLump1[61][var3][0], bigLump1[61][var3][1], bigLump1[61][var3][2], bigLump1[61][var3][3], bigLump1[62][var3][0], bigLump1[62][var3][1]);
      }

      this.fF = var12;
      this.gx = new byte[7][];
      this.gy = new byte[7][];
      this.gv = new short[7][];
      this.gu = new short[15];
      this.gs = new int[7];
      this.modifyBigLump1_subfunction4(0, 49, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(1, 70, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(2, 72, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(3, 74, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(4, 76, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(5, 78, (byte[][][])bigLump1);
      this.modifyBigLump1_subfunction4(6, 80, (byte[][][])bigLump1);
      this.gE = 0;
      var12 = this.fF;
      this.fL = var12;
      var10 = bigLump1[51].length;
      this.be = new int[var10];

      for(var3 = 0; var3 < var10; ++var3) {
         var24 = (long)(128 + bigLump1[51][var3][0] << 16 >> 2);
         var16 = (long)(128 + bigLump1[51][var3][1] << 16 >> 2);
         long var22 = (long)((bigLump1[51][var3][3] << 16) / 60);
         this.be[var3] = bigLump1[51][var3][6];
         var12 = this.modifyBigLump1_subfunction5(var24, var16, bigLump1[51][var3][2], var22, var12, bigLump1[51][var3][4], bigLump1[51][var3][5], bigLump1[51][var3][7], bigLump1[51][var3][8]);
      }

      this.fF = var12;
      this.cs = new byte[7][];

      for(var2 = 63; var2 < 70; ++var2) {
         var10 = bigLump1[var2].length;
         var11 = bigLump1[var2 - 50].length;
         this.cs[var2 - 63] = new byte[var10 + var11];

         for(var3 = 0; var3 < var10; ++var3) {
            this.cs[var2 - 63][var3] = bigLump1[var2][var3][0];
         }

         var6 = var3;

         for(var3 = 0; var3 < var11; ++var3) {
            this.cs[var2 - 63][var6] = (byte)(106 + bigLump1[var2 - 50][var3][0]);
            ++var6;
         }
      }

   }

   private void modifyBigLump1_subfunction4(int var1, int var2, byte[][][] var3) {
      int var4 = var2;
      if (var3[var2].length != 0) {
         int var7 = var3[var2][0].length;
         this.gx[var1] = new byte[var7];

         for(int var6 = 0; var6 < var7; ++var6) {
            this.gx[var1][var6] = var3[var4][0][var6];
         }

         int[] var10000;
         int var10001;
         byte var10002;
         if (this.gx[var1][1] != this.gx[var1][2]) {
            var10000 = this.gs;
            var10001 = var1;
            var10002 = 2;
         } else {
            var10000 = this.gs;
            var10001 = var1;
            var10002 = 1;
         }

         var10000[var10001] = var10002;
         var4 = var2 + 1;
         this.gv[var1] = new short[var3[var4].length];
         this.gy[var1] = new byte[var3[var4].length];
         var7 = var3[var4].length;

         for(int var5 = 0; var5 < var7; ++var5) {
            this.gv[var1][var5] = (short)(var3[var4][var5][0] + 128);
            this.gy[var1][var5] = 0;
         }

      }
   }

   private void loadSpritesPart1(byte[][][] bigLump2) {
      int var6 = bigLump2[4].length;
      this.cj = new byte[var6];
      this.cg = new short[var6];
      this.ck = new byte[64];
      this.eX = new int[32];
      this.ch = new short[var6];
      this.cl = new byte[var6];
      this.ct = new boolean[var6];
      this.cm = new byte[var6];
      this.cv = new boolean[106 + this.fG];
      this.ce = new int[64 + this.fG];
      this.co = new byte[var6];
      this.cu = new boolean[var6];
      this.cp = new byte[var6];

      int var3;
      for(var3 = 0; var3 < var6; ++var3) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (bigLump2[4][var3][2] == -1) {
            var10000 = this.cq;
            var10001 = var3;
            var10002 = 10;
         } else {
            var10000 = this.cq;
            var10001 = var3;
            var10002 = 0;
         }

         var10000[var10001] = var10002;
         this.cb[var3][0] = 128 + bigLump2[4][var3][0] << 16 >> 2;
         this.cb[var3][1] = 128 + bigLump2[4][var3][1] << 16 >> 2;
         this.cj[var3] = bigLump2[4][var3][2];
         this.cg[var3] = (short)(bigLump2[4][var3][3] * 2);
         this.ck[var3] = bigLump2[4][var3][4];
         if (this.ck[var3] > 0) {
            this.cq[var3] = this.ck[var3];
         }

         this.eX[var3] = -1;
         this.ch[var3] = (short)(bigLump2[4][var3][5] + 128);
         this.ct[var3] = true;
         this.cm[var3] = 1;
         this.cl[var3] = 1;
         this.cv[var3] = false;
         this.cw[var3] = true;
         this.cr[var3] = bigLump2[4][var3][6];
         this.cp[var3] = bigLump2[4][var3][7];
         this.cu[var3] = false;
         if (this.ck[var3] > 0 && (this.ck[var3] != 41 || this.selectedMap != 5 && this.selectedMap != 8)) {
            var10000 = this.co;
            var10001 = var3;
            var10002 = 0;
         } else {
            var10000 = this.co;
            var10001 = var3;
            var10002 = 100;
         }

         var10000[var10001] = var10002;
      }

      this.fx = bigLump2[4].length;
      this.fW = bigLump2[8][0][0];
      this.fX = bigLump2[8][0][1];
      this.fY = bigLump2[8][0][2];
      this.ga = bigLump2[8][0][3];
      this.fZ = bigLump2[8][0][4];
      this.fy = bigLump2[7].length;
      int var4 = 32;
      int var5 = bigLump2[7].length;

      for(var3 = 0; var3 < var5; ++var3) {
         this.cq[var4] = this.fW;
         this.cb[var4][0] = 128 + bigLump2[7][var3][0] << 16 >> 2;
         this.cb[var4][1] = 128 + bigLump2[7][var3][1] << 16 >> 2;
         this.ck[var4] = bigLump2[7][var3][2];
         this.cw[var4] = true;
         this.cr[var4] = bigLump2[7][var3][3];
         ++var4;
      }

      var4 = 64;
      var5 = bigLump2[9].length;
      this.cc = new int[var5][4];
      this.bV = var5;
      this.gY = new long[var5];

      for(int var2 = 0; var2 < var5; ++var2) {
         this.gY[var2] = 0L;
      }

      for(var3 = 0; var3 < var5; ++var3) {
         this.cq[var4] = bigLump2[9][var3][0];
         this.cb[var4][0] = 128 + bigLump2[9][var3][1] << 16 >> 2;
         this.cb[var4][1] = 128 + bigLump2[9][var3][2] << 16 >> 2;
         this.cc[var3][0] = var4;
         this.cc[var3][1] = 1;
         this.cc[var3][2] = bigLump2[9][var3][3];
         this.cc[var3][3] = bigLump2[9][var3][4] * 25;
         this.cw[var4] = true;
         ++var4;
      }

   }

   private void loadSprites_subfunction1(short[] var1, int var2, int var3) {
      this.bs[var2] = var1[var3 + 2];
      this.bt[var2] = var1[var3 + 3];
      int var4 = this.bt[var2] / var1[var3 + 5];
      this.bn[var1[var3 + 4]][var2] = this.bn[var1[var3 + 4]][this.I[var1[var3 + 4]]];
      this.bn[var1[var3 + 4]][this.I[var1[var3 + 4]] + 1] = (short)(this.bn[var1[var3 + 4]][this.I[var1[var3 + 4]]] + this.bs[var2] * var4);
      int var10002 = this.I[var1[var3 + 4]]++;
      this.bq[var2] = var1[var3 + 4];
      this.br[var2] = var1[var3 + 5];
      this.bg[var2] = (var1[var3 + 5] << 16 >> 3) * this.bs[var2] / this.bt[var2];
      int[] var10000 = this.bg;
      var10000[var2] >>= 1;
   }

   private void a(int var1, int var2, int[] var3) {
      a(this.do_, this.dp, this.bn[1][var1], this.bs[var1], var2, 0, var3, false);
   }

   private void b(int var1, int var2, int[] var3) {
      a(this.di, this.dj, this.bn[0][var1], this.bs[var1], var2, 0, var3, true);
      a(this.dk, this.dl, this.bn[0][var1], this.bs[var1], var2, 4, var3, false);
      a(this.dm, this.dn, this.bn[0][var1], this.bs[var1], var2, 2, var3, false);
   }

   private void c(int var1, int var2, int[] var3) {
      a(this.dq, this.dr, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 0, var3, true);
   }

   private void d(int var1, int var2, int[] var3) {
      a(this.ds, this.dt, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 2, var3, false);
      a(this.du, this.dv, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 0, var3, false);
   }

   private void e(int var1, int var2, int[] var3) {
      a(this.dw, this.dx, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 0, var3, true);
   }

   private void f(int var1, int var2, int[] var3) {
      a(this.dy, this.dz, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 0, var3, true);
      a(this.dA, this.dB, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 2, var3, true);
      a(this.dC, this.dD, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 6, var3, false);
      a(this.dE, this.dF, this.bn[this.bq[var1]][var1], this.bs[var1], var2, 4, var3, false);
   }

   private void loadSpritesPart2(byte[][][] bigLump2) {
      Image var7 = null;
      Image var8 = null;
      var7 = this.readImage("/e" + this.dataExt);
      l3d_d var10000;
      StringBuffer var10001;
      String var10002;
      if (this.selectedMap != 7) {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = "/ee";
      } else {
         var10000 = this;
         var10001 = new StringBuffer();
         var10002 = "/eeeee";
      }

      var8 = var10000.readImage(var10001.append(var10002).append(this.dataExt).toString());
      int[] var9 = new int[2];
      var7.getRGB(var9, 0, 2, 0, 0, 2, 1);
      this.N = var9[0];
      this.O = var9[1];
      this.bn = new short[7][];
      this.I = new int[this.bn.length];
      int var2 = this.bn.length;
      int var3 = (13 + bigLump2[5].length + 2) * 2;

      int var10;
      for(var10 = 0; var10 < var2; ++var10) {
         this.bn[var10] = new short[var3];
         this.I[var10] = 13 + bigLump2[5].length + 2;
         int var4 = this.bn[var10].length;

         for(int var11 = 0; var11 < var4; ++var11) {
            this.bn[var10][var11] = 0;
         }
      }

      int var14 = 13 + bigLump2[5].length;
      this.ci = new short[var14];
      this.bq = new short[var14];
      this.br = new short[var14];
      this.bg = new int[var14];
      this.bs = new short[var14];
      this.bt = new short[var14];
      int var13 = 0;
      var2 = this.h.length;

      for(var10 = 0; var10 < var2; var10 += 7) {
         this.loadSprites_subfunction1(this.h, var13, var10);
         this.ci[var13] = this.h[var10 + 6];
         ++var13;
      }

      var13 = 13;
      var2 = bigLump2[5].length;

      for(int var12 = 0; var12 < var2; ++var12) {
         var10 = (bigLump2[5][var12][0] < 0 ? -bigLump2[5][var12][0] : bigLump2[5][var12][0]) * 7;
         this.loadSprites_subfunction1(this.i, var13, var10);
         this.ci[var13] = this.i[var10 + 6];
         ++var13;
      }

      int var16 = this.bn[0][this.I[0]] + 10;
      int var17 = this.bn[1][this.I[1]] + 10;
      int var18 = this.bn[2][this.I[2]] + 10;
      int var19 = this.bn[3][this.I[3]] + 10;
      int var20 = this.bn[4][this.I[4]] + 10;
      int var21 = this.bn[6][this.I[6]] + 10;
      this.loadSprites_subfunction2(var16, var17, bigLump2[1].length, var18, var19, var20, var21);
      var13 = 0;
      short var22 = 0;
      var2 = this.h.length;

      for(var10 = 0; var10 < var2; var10 += 7) {
         int[] var5 = new int[this.h[var10 + 2] * this.h[var10 + 3]];
         int[] var6 = new int[this.h[var10 + 2] * this.h[var10 + 3]];
         var7.getRGB(var5, 0, this.h[var10 + 2], this.h[var10 + 0], this.h[var10 + 1], this.h[var10 + 2], this.h[var10 + 3]);
         var8.getRGB(var6, 0, this.h[var10 + 2], this.h[var10 + 0], this.h[var10 + 1], this.h[var10 + 2], this.h[var10 + 3]);
         this.combineLayers(var5, var6, this.bm, var22, bigLump2[0][0], bigLump2[0][1]);
         var22 = (short)(var22 + 50);
         int var15 = this.bt[var13] / this.br[var13];
         if (this.bq[var13] == 0) {
            this.b(var13, var15, var5);
         } else if (this.bq[var13] == 1) {
            this.a(var13, var15, var5);
         }

         ++var13;
      }

   }

   private void loadSpritesPart3(byte[][][] bigLump2) {
      int[][] var8 = new int[bigLump2[5].length][];
      int[][] var9 = new int[bigLump2[5].length][];
      boolean var2 = false;
      int var7 = bigLump2[5].length;

      int var4;
      for(int var5 = 0; var5 <= 1; ++var5) {
         Image var10 = this.readImage(this.spriteFiles[var5] + this.dataExt);
         Image var11 = this.readImage(this.spriteFiles[var5 + 2] + this.dataExt);

         for(var4 = 0; var4 < var7; ++var4) {
            if (var5 == 0) {
               if (bigLump2[5][var4][0] < 0) {
                  continue;
               }
            } else {
               if (bigLump2[5][var4][0] >= 0) {
                  continue;
               }

               bigLump2[5][var4][0] = (byte)(-bigLump2[5][var4][0]);
            }

            int var3 = bigLump2[5][var4][0] * 7;
            var8[var4] = new int[this.i[var3 + 2] * this.i[var3 + 3]];
            var9[var4] = new int[this.i[var3 + 2] * this.i[var3 + 3]];
            var10.getRGB(var8[var4], 0, this.i[var3 + 2], this.i[var3 + 0], this.i[var3 + 1], this.i[var3 + 2], this.i[var3 + 3]);
            var11.getRGB(var9[var4], 0, this.i[var3 + 2], this.i[var3 + 0], this.i[var3 + 1], this.i[var3 + 2], this.i[var3 + 3]);
         }
      }

      short var13 = 650;
      var7 = bigLump2[5].length;

      for(var4 = 0; var4 < var7; ++var4) {
         this.combineLayers(var8[var4], var9[var4], this.bm, var13, bigLump2[6][var4], bigLump2[1][var4]);
         var13 = (short)(var13 + 50);
      }

      var7 = 13 + bigLump2[5].length;

      for(int var12 = 13; var12 < var7; ++var12) {
         int var6 = this.bt[var12] / this.br[var12];
         if (this.bq[var12] == 0) {
            this.b(var12, var6, var8[var12 - 13]);
         } else if (this.bq[var12] == 1) {
            this.a(var12, var6, var8[var12 - 13]);
         } else if (this.bq[var12] == 2) {
            this.c(var12, var6, var8[var12 - 13]);
         } else if (this.bq[var12] == 3) {
            this.d(var12, var6, var8[var12 - 13]);
         } else if (this.bq[var12] == 4) {
            this.e(var12, var6, var8[var12 - 13]);
         } else if (this.bq[var12] == 6) {
            this.f(var12, var6, var8[var12 - 13]);
         }
      }

      this.B = (byte[][][])null;
      System.gc();
   }

   private void loadTextures_subfunction6(byte[][][] var1, byte[][][] var2, int var3, int var4, int var5, int var6, int var7) {
      byte var8 = var2[9][var3][0];
      byte var9 = var1[2][var3][5];
      int var10 = this.n[6 * var8] + 128;
      if (this.L != var3 && var5 != var6) {
         if (var4 == 0) {
            if (var9 != 12) {
               this.y = this.readImage("/" + String.valueOf(var10) + this.dataExt);
            } else {
               Image var11 = this.readImage("/" + String.valueOf(var10) + this.dataExt);
               this.y = Image.createImage(var11, 0, 0, var11.getWidth(), var11.getHeight(), 5);
            }
         } else {
            this.z = this.readImage("/" + String.valueOf(var10) + this.dataExt);
         }
      }

      if (this.L != var3) {
         Image var10000;
         int[] var10001;
         if (var4 == 0) {
            var10000 = this.y;
            var10001 = this.E;
         } else {
            this.C = new int[this.G * this.H];
            var10000 = this.z;
            var10001 = this.C;
         }

         var10000.getRGB(var10001, 0, this.G, var1[4][var3][0], var1[4][var3][1], this.G, this.H);
         l3d_d var14;
         if (var4 != 0) {
            var14 = this;
            var10001 = this.C;
         } else {
            var14 = this;
            var10001 = this.E;
         }

         var14.loadTextures_subfunction1(var10001, var1, var2, var3);
         if (var4 == 0 && var7 == var3) {
            this.L = var3;
            this.D = new int[this.G * this.H];
            this.loadTextures_subfunction7(this.D, this.E, 0, 0, this.G, this.G, this.H);
         }

      } else {
         int var13 = this.D.length;

         for(int var12 = 0; var12 < var13; ++var12) {
            this.E[var12] = this.D[var12];
         }

      }
   }

   private void loadTextures_subfunction1(int[] var1, byte[][][] var2, byte[][][] var3, int var4) {
      byte var5 = var2[2][var4][0];
      byte var6 = var2[2][var4][1];
      byte var7 = var2[2][var4][2];
      byte var8 = var2[2][var4][3];
      byte var9 = var2[2][var4][4];
      boolean var10 = var3[9][var4][0] == 1 || var3[9][var4][0] == 11 || var3[9][var4][0] == 15;
      if (var5 != 0 || var6 != 0 || var7 != 0 || var8 != 0 || var9 != 0) {
         this.loadTextures_subfunction3(var1, var5, var6, var7, var8, var9, var10);
      }

   }

   private void loadTextures(byte[][][] bigLump0, byte[][][] bigLump1, short[] footer) {
      int var20 = 0;
      this.J = new int[bigLump1[9].length][];
      this.K = new int[bigLump1[9].length];
      int var19 = bigLump1.length;

      int var4;
      for(var4 = 0; var4 < var19; ++var4) {
         if (var4 != 9 && var4 != 32) {
            bigLump1[var4] = (byte[][])null;
         }
      }

      bigLump0[0] = (byte[][])null;
      System.gc();
      var19 = bigLump0[4].length;

      int var24;
      for(var4 = 0; var4 < var19; ++var4) {
         var24 = bigLump1[9][var4][0];
         if (bigLump0[4][var4][2] == 0) {
            bigLump0[4][var4][2] = (byte)(this.n[6 * var24 + 3] + 128);
         }

         if (bigLump0[4][var4][3] == 0) {
            bigLump0[4][var4][3] = (byte)(this.n[6 * var24 + 4] + 128);
         }
      }

      var19 = bigLump1[9].length;

      int var5;
      int[] var10001;
      int var10002;
      int var10003;
      int var10004;
      byte var10006;
      int var10007;
      for(var4 = 0; var4 <= 2; ++var4) {
         Image var32 = this.readImage("/" + String.valueOf(var4) + this.dataExt);

         for(var5 = 0; var5 < var19; ++var5) {
            byte var26 = bigLump1[9][var5][0];
            int var21 = this.n[6 * var26] + 128;
            int var22 = bigLump0[4][var5][2] * 2;
            int var23 = bigLump0[4][var5][3] * 2;
            if (var21 == var4) {
               label154: {
                  this.J[var20] = new int[var22 * var23];
                  this.K[var5] = var20;
                  int var27 = var26 != 125 ? (this.n[6 * var26 + 1] + 128 + bigLump0[4][var5][0]) * 2 : 548;
                  int var28 = (this.n[6 * var26 + 2] + 128 + bigLump0[4][var5][1]) * 2;
                  var32.getRGB(this.J[var20], 0, var22, var27, var28, var22, var23);
                  Image var10000;
                  int var10005;
                  if (bigLump1[9][var5][0] == 79) {
                     this.go = new int[784];
                     var10000 = var32;
                     var10001 = this.go;
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else if (bigLump1[9][var5][0] == 78) {
                     this.gp = new int[676];
                     var10000 = var32;
                     var10001 = this.gp;
                     var10002 = 0;
                     var10003 = 26;
                     var10004 = var27 + 4;
                     var10005 = var28 + 4;
                     var10006 = 26;
                     var10007 = 26;
                  } else if (bigLump1[9][var5][0] == 80) {
                     this.gq = new int[784];
                     var10000 = var32;
                     var10001 = this.gq;
                     var10002 = 0;
                     var10003 = 28;
                     var10004 = var27 + 4;
                     var10005 = var28 + 2;
                     var10006 = 28;
                     var10007 = 28;
                  } else {
                     if (bigLump1[9][var5][0] != 55) {
                        break label154;
                     }

                     this.gp = new int[1152];
                     var10000 = var32;
                     var10001 = this.gp;
                     var10002 = 0;
                     var10003 = 48;
                     var10004 = var27;
                     var10005 = var28;
                     var10006 = 48;
                     var10007 = 24;
                  }

                  var10000.getRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007);
               }

               this.loadTextures_subfunction1(this.J[var20], bigLump0, bigLump1, var5);
               ++var20;
            }
         }
      }

      this.bi = new int[bigLump0[3].length + 1];
      int var17 = 0;
      this.bi[0] = 0;
      this.bh = new int[bigLump0[3].length + 1];
      this.bo = new short[bigLump0[3].length * 9];
      int var10 = footer[6] * 2 * 2;
      int var11 = footer[7] * 2 * 2;
      this.loadTextures_subfunction2(var10, var11);
      int var14 = 0;
      this.L = -1;
      byte var7 = -1;
      boolean var9 = false;
      var19 = bigLump0[3].length;

      for(var4 = 0; var4 < var19; ++var4) {
         byte var8 = var7;
         byte var6 = bigLump1[32][var4][0];
         this.M = bigLump1[9][var6][0];
         byte var31 = var4 != var19 - 1 ? bigLump1[32][var4 + 1][0] : -1;
         var7 = bigLump1[9][var6][0];
         this.G = bigLump0[4][var6][2] * 2;
         this.H = bigLump0[4][var6][3] * 2;
         this.F = bigLump0[2][var6][5];
         if (this.F >= 1 && this.F <= 5) {
            this.G *= 2;
         }

         if (this.F >= 4 && this.F <= 9) {
            this.H *= 2;
         }

         int var15 = this.G;
         int var16 = this.H;
         this.E = new int[var15 * var16];
         l3d_d var34;
         if (bigLump0[3][var4][3] != 1 && bigLump0[3][var4][3] != 2) {
            if (this.n[6 * var7] + 128 > 2) {
               this.loadTextures_subfunction6((byte[][][])bigLump0, (byte[][][])bigLump1, var6, 0, var8, var7, var31);
               var34 = this;
               var10001 = this.E;
            } else {
               var34 = this;
               var10001 = this.J[this.K[var6]];
            }

            var34.loadTextures_subfunction8(var10001, var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], 0, 0);
         }

         int var12 = bigLump0[3][var4][1] * 2;
         int var13 = bigLump0[3][var4][2] == 0 ? this.G : bigLump0[3][var4][2] * 2;
         boolean var33 = false;
         var24 = bigLump0[3][var4][0] == bigLump0[3][var4][1] ? var13 : (bigLump0[3][var4][3] != 2 ? this.G : 96);
         byte var25 = bigLump0[3][var4][0];
         if (bigLump0[3][var4][3] == 1) {
            var14 = this.loadTextures_subfunction16(bigLump1[32][var4][0], bigLump1[32][var4][1], (byte)var4, (byte)var12, (byte)var13, (short)140, var14, (short)26, (byte)(var12 + 23));
         } else if (bigLump0[3][var4][3] == 2) {
            var14 = this.loadTextures_subfunction16(bigLump1[32][var4][0], bigLump1[32][var4][1], (byte)var4, (byte)var12, (byte)var13, (short)((byte)var24), var14, (short)0, (byte)var12);
         } else {
            var14 = this.loadTextures_subfunction16((byte)var25, (byte)var4, (byte)var4, (byte)var12, (byte)var13, (short)((byte)var24), var14, (short)0, (byte)var12);

            for(var5 = 1; var5 <= 3 && bigLump1[32][var4][var5] != var6; ++var5) {
               var6 = bigLump1[32][var4][var5];
               this.G = bigLump0[4][var6][2] * 2;
               this.H = bigLump0[4][var6][3] * 2;
               this.F = bigLump0[2][var6][5];
               if (this.F >= 1 && this.F <= 5) {
                  this.G *= 2;
               }

               if (this.F >= 4 && this.F <= 9) {
                  this.H *= 2;
               }

               if (this.n[6 * bigLump1[9][var6][0]] + 128 > 2) {
                  this.loadTextures_subfunction6((byte[][][])bigLump0, (byte[][][])bigLump1, var6, var5, -1, -2, -1);
                  var34 = this;
                  var10001 = this.C;
               } else {
                  var34 = this;
                  var10001 = this.J[this.K[var6]];
               }

               var34.loadTextures_subfunction8(var10001, var15, bigLump0[4][var6][2] * 2, bigLump0[4][var6][3] * 2, bigLump0[2][var6][5], bigLump0[2][var6][6] * 2, bigLump0[2][var6][7] * 2);
            }

            this.bi[var4] = this.bi[var17];
            this.bi[var17 + 1] = this.bi[var17] + var13 * 12;
            ++var17;
            int[] var10008;
            boolean var10009;
            int[] var35;
            byte var36;
            if (bigLump0[3][var4][3] != 0) {
               loadTextures_subfunction18(this.cS, this.cT, this.bi[var4], var12, var13, 12, 0, var15, this.E, true);
               var35 = this.cU;
               var10001 = this.cV;
               var10002 = this.bi[var4];
               var10003 = var12;
               var10004 = var13;
               var36 = 12;
               var10006 = 2;
               var10007 = var15;
               var10008 = this.E;
               var10009 = true;
            } else {
               loadTextures_subfunction18(this.cS, this.cT, this.bi[var4], var12, var13, 12, 0, var15, this.E, true);
               loadTextures_subfunction18(this.cU, this.cV, this.bi[var4], var12, var13, 12, 2, var15, this.E, true);
               loadTextures_subfunction18(this.cW, this.cX, this.bi[var4], var12, var13, 12, 6, var15, this.E, false);
               var35 = this.cY;
               var10001 = this.cZ;
               var10002 = this.bi[var4];
               var10003 = var12;
               var10004 = var13;
               var36 = 12;
               var10006 = 4;
               var10007 = var15;
               var10008 = this.E;
               var10009 = false;
            }

            loadTextures_subfunction18(var35, var10001, var10002, var10003, var10004, var36, var10006, var10007, var10008, var10009);
         }
      }

      this.C = null;
      this.D = null;
      this.E = null;
      this.J = (int[][])null;
      this.K = null;
      this.y = null;
      this.z = null;
      System.gc();
   }

   private static void loadTextures_subfunction18(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int[] var8, boolean var9) {
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

   private int loadTextures_subfunction16(byte var1, byte var2, byte var3, byte var4, byte var5, short var6, int var7, short var8, byte var9) {
      this.bh[var3] = var7;
      int var10 = this.loadTextures_subfunction17((byte)0, var1, (short)var8, var7);
      var10 = this.loadTextures_subfunction17(var9, var2, (short)0, var10);
      var10 = this.loadTextures_subfunction17((byte)(var9 + var5), var1, (short)((byte)(var4 + var5)), var10);
      this.bh[var3 + 1] = var10;
      this.bp[var3] = var6;
      return var10;
   }

   private int loadTextures_subfunction17(byte var1, byte var2, short var3, int var4) {
      this.bo[var4] = (short)var1;
      int var5 = var4 + 1;
      this.bo[var5] = (short)var2;
      ++var5;
      this.bo[var5] = var3;
      ++var5;
      return var5;
   }

   private void loadTextures_subfunction3(int[] var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      int var10 = 1;
      boolean var11 = false;
      int var12 = var1.length;
      int[] var13 = new int[257];
      int[] var14 = new int[257];

      for(int var8 = 0; var8 < var12; ++var8) {
         int var16;
         if ((var16 = var1[var8]) != this.N) {
            int var9 = var16 & 255;
            int var20;
            if ((var20 = var13[var9]) > 0) {
               var1[var8] = var14[var20];
            } else {
               var13[var9] = var10;
               var1[var8] = this.loadTextures_subfunction4(var2, var3, var4, var5, var6, var9, var7);
               var14[var10] = var1[var8];
               ++var10;
            }
         }
      }

   }

   private int loadTextures_subfunction4(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
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
         var9[var8] = loadTextures_subfunction5((int)(var9[var8] + var15), var16);
         var9[var8] = loadTextures_subfunction5((int)(var10 + (var9[var8] - var10) * (var4 + var14) / var14), var16);
      }

      return var9[0] << var11 | var9[1] << var12 | var9[2] << var13;
   }

   private static int loadTextures_subfunction5(int var0, int var1) {
      if (var0 > var1) {
         return var1;
      } else {
         return var0 < 0 ? 0 : var0;
      }
   }

   private void combineLayers(int[] var1, int[] var2, int[][] var3, short var4, byte[] var5, byte[] var6) {
      boolean var11 = false;
      byte var12 = 1;
      int var13 = var1.length;
      byte[] var14 = new byte[256];
      int[] var15 = new int[50];
      short var17 = var4;
      short var18 = 0;

      int var7;
      int var10;
      int var16;
      byte var21;
      for(var7 = 0; var7 < var13; ++var7) {
         if ((var16 = var1[var7]) == this.N) {
            var1[var7] = -1;
         } else {
            var10 = var16 & 255;
            if ((var21 = var14[var10]) > 0) {
               var1[var7] = var15[var21];
            } else {
               var14[var10] = var12;
               var15[var12] = var18;
               ++var12;
               int var19 = this.loadTextures_subfunction4(var5[0], var5[1], var5[2], var5[3], var5[4], var10, false);
               int var20 = this.loadTextures_subfunction4(var6[0], var6[1], var6[2], var6[3], var6[4], var10, false);
               var3[0][var17] = (int)((long)var19 | 0L);
               var3[1][var17] = (int)((long)var20 | 0L);
               var1[var7] = var18++;
               ++var17;
            }
         }
      }

      this.B = new byte[32][32][32];
      var15 = new int[50];

      for(var7 = 0; var7 < var13; ++var7) {
         if ((var16 = var2[var7]) != this.N) {
            int var8 = (var16 & 16711680) >> 19;
            int var9 = (var16 & '\uff00') >> 11;
            var10 = (var16 & 255) >> 3;
            if ((var21 = this.B[var8][var9][var10]) > 0) {
               var1[var7] = var15[var21];
            } else {
               this.B[var8][var9][var10] = var12;
               var15[var12] = var18;
               ++var12;
               if (var2[var7] != this.N) {
                  var3[0][var17] = (int)((long)var16 | 0L);
                  var3[1][var17] = (int)((long)var16 | 0L);
               }

               var1[var7] = var18++;
               ++var17;
            }
         }
      }

   }

   private void loadTextures_subfunction8(int[] var1, int var2, int var3, int var4, byte var5, int var6, int var7) {
      if (var5 == 0) {
         if (this.M != 26 && this.M != 27 && this.M != 28 && this.M != 1 && this.M != 91 && this.M != 114 && this.M != 15 && this.M != 99 && this.M != 100 && this.M != 11 && this.M != 10 && this.M != 22 && this.M != 23 && this.M != 39 && this.M != 38 && this.M != 40 && this.M != 41 && this.M != 42 && this.M != 43 && this.M != 44 && this.M != 46 && this.M != 39 && this.M != 37 && this.M != 12) {
            this.loadTextures_subfunction7(this.E, var1, var6, var7, var2, var3, var4);
         } else {
            this.loadTextures_subfunction7(this.E, var1, var6, var7, var2, var3, var4);
            this.loadTextures_subfunction9((int[])this.E, (int[])this.E, 0, 0, var2, var3, var4);
         }
      } else if (var5 == 1) {
         if (this.M == 103 || this.M == 104) {
            this.loadTextures_subfunction9((int[])var1, (int[])var1, 0, 0, var3, var3, var4);
         }

         this.loadTextures_subfunction10(this.E, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 2) {
         this.loadTextures_subfunction11(this.E, var1, var6, var7, var2, var3, var4);
      } else if (var5 == 3) {
         this.loadTextures_subfunction12(this.E, var1, var6, var7, var2, var3, var4);
      } else {
         if (var5 != 5) {
            if (var5 == 6) {
               this.loadTextures_subfunction13(this.E, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 == 10) {
               this.loadTextures_subfunction14(this.E, var1, var6, var7, var2, var3, var4);
               return;
            }

            if (var5 != 11) {
               return;
            }
         }

         this.loadTextures_subfunction15(this.E, var1, var6, var7, var2, var3, var4, var5);
      }
   }

   private void loadTextures_subfunction9(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int[] var10000;
            int var10001;
            int var10002;
            label25: {
               int var13;
               if ((var13 = var2[var10]) != this.N) {
                  if (var13 != this.O) {
                     var10000 = var1;
                     var10001 = var8;
                     var10002 = var13;
                     break label25;
                  }

                  var10000 = var1;
                  var10001 = var8;
                  var10002 = this.aS;
               } else {
                  var10000 = var1;
                  var10001 = var8;
                  var10002 = this.aT;
               }

               var10002 &= 16777215;
            }

            var10000[var10001] = var10002;
            ++var10;
         }

         var11 += var5;
      }

   }

   private void loadTextures_subfunction7(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.N) {
               var1[var8] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   private void loadTextures_subfunction10(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;
      int var16 = var4 + var7;

      for(int var10 = var4; var10 < var16; ++var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.N) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 += var5;
      }

   }

   private void loadTextures_subfunction11(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = (var4 + var7 - 1) * var5 + var3;
      int var13 = 2 * var6 - 1;
      int var11 = 0;

      for(int var10 = var4 + var7 - 1; var10 >= var4; --var10) {
         int var14 = var12 + var6;
         int var9 = var12 + var13;

         for(int var8 = var12; var8 < var14; ++var8) {
            int var15;
            if ((var15 = var2[var11]) != this.N) {
               var1[var8] = var15;
               var1[var9] = var15;
            }

            ++var11;
            --var9;
         }

         var12 -= var5;
      }

   }

   private void loadTextures_subfunction12(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var11 = var4 * var5 + var3;
      int var10 = 0;
      int var14 = var4 + var7;

      for(int var9 = var4; var9 < var14; ++var9) {
         int var12 = var11 + var6;

         for(int var8 = var11; var8 < var12; ++var8) {
            int var13;
            if ((var13 = var2[var10]) != this.N) {
               var1[var8] = var13;
               var1[var8 + var6] = var13;
            }

            ++var10;
         }

         var11 += var5;
      }

   }

   private void loadTextures_subfunction15(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
            if ((var20 = var2[var14]) != this.N) {
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

   private void loadTextures_subfunction13(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      int var12 = var4 * var5 + var3;
      int var9 = var5 * var7;
      int var11 = 0;
      int var15 = var4 + var7;

      for(int var10 = var4; var10 < var15; ++var10) {
         int var13 = var12 + var6;

         for(int var8 = var12; var8 < var13; ++var8) {
            int var14;
            if ((var14 = var2[var11]) != this.N) {
               var1[var8] = var14;
               var1[var8 + var9] = var14;
            }

            ++var11;
         }

         var12 += var5;
      }

   }

   private void loadTextures_subfunction14(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
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
            if ((var13 = var2[var10]) != this.N) {
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
            if ((var13 = var2[var10]) != this.N) {
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
         this.bv[var18] = var15;
         if (var16 != 6) {
            this.bw[var18] = var16;
         }

         for(int var17 = 0; var17 < 4; var17 += 2) {
            int[] var10000;
            int var10001;
            long var10002;
            if (var9 == 0) {
               this.dg[var17][var18] = (int)((long)this.x[var19][var17] * var7 + var1);
               var10000 = this.dg[var17 + 1];
               var10001 = var18;
               var10002 = (long)this.x[var19][var17 + 1] * var5;
            } else {
               this.dg[var17][var18] = (int)(((long)this.x[var19][var17] * var7 * this.sin(var9) >> 16) - ((long)this.x[var19][var17 + 1] * var5 * this.cos(var9) >> 16) + var1);
               var10000 = this.dg[var17 + 1];
               var10001 = var18;
               var10002 = ((long)this.x[var19][var17] * var7 * this.cos(var9) >> 16) + ((long)this.x[var19][var17 + 1] * var5 * this.sin(var9) >> 16);
            }

            var10000[var10001] = (int)(var10002 + var3);
         }

         ++var19;
      }

      this.dh[var10] = var11;
      var18 = var10 + 1;
      this.dh[var18] = var12;
      ++var18;
      this.dh[var18] = var13;
      ++var18;
      this.dh[var18] = var14;
      if (var16 == 6) {
         this.bw[var18] = 3;
      }

      return var18 + 1;
   }

   private int modifyBigLump1_subfunction5(long var1, long var3, int var5, long var6, int var8, int var9, byte var10, byte var11, int var12) {
      int var15 = 360 / var5;
      int var14 = var12 * 4;

      int var13;
      for(var13 = var8; var13 < var8 + var5; ++var13) {
         this.dg[0][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.dg[1][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         var14 -= var15;
         this.dg[2][var13] = (int)((var6 * this.cos(var14) >> 16) + var1);
         this.dg[3][var13] = (int)((var6 * this.sin(var14) >> 16) + var3);
         this.bv[var13] = var10;
         this.dh[var13] = (byte)var9;
         this.bw[var13] = var11;
      }

      return var13;
   }

   private void modifyBigLump1_subfunction2(byte var1, byte var2, byte var3, int var4) {
      this.dh[var4] = var1;
      int var5 = var4 + 1;
      this.dh[var5] = var2;
      ++var5;
      this.dh[var5] = var3;
      this.bw[var5] = 3;
   }

   private void initStartingPos(int var1, long var2, long var4, int var6, int var7) {
      this.gn = new long[2];
      this.fU = var1;
      this.gn[0] = var2;
      this.gn[1] = var4;
      this.fz = var6;
      this.fA = var7;
   }

   private void initFloorCeilingColor(short[] footer) {
      l3d_d var10000;
      int var10001;
      if (!this.hD) {
         this.aS = footer[0] << 16 | footer[1] << 8 | footer[2];
         var10000 = this;
         var10001 = footer[3] << 16 | footer[4] << 8 | footer[5];
      } else {
         this.aS = 1644825;
         var10000 = this;
         var10001 = 2960685;
      }

      var10000.aT = var10001;
      this.aS = (int)((long)this.aS | 0L);
      this.aT = (int)((long)this.aT | 0L);
   }

   private void a(c var1) {
      if (this.av <= this.aw) {
         l3d_d var10000;
         c var10001;
         if (c.a(var1)) {
            if (c.b(var1) != null) {
               this.a(c.b(var1));
            }

            if (this.av > this.aw) {
               return;
            }

            if (this.b(c.c(var1))) {
               this.d(c.c(var1));
            }

            if (c.d(var1) == null) {
               return;
            }

            var10000 = this;
            var10001 = c.d(var1);
         } else {
            if (c.d(var1) != null) {
               this.a(c.d(var1));
            }

            if (c.b(var1) == null) {
               return;
            }

            var10000 = this;
            var10001 = c.b(var1);
         }

         var10000.a(var10001);
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
      return (this.bb[var1] * (long)this.dg[var3][var2] >> 16) + (this.bc[var1] * (long)this.dg[var3 + 1][var2] >> 16) + this.bd[var1] <= 0L;
   }

   private void d() {
      this.bb = new long[3];
      this.bc = new long[3];
      this.bd = new long[3];
      this.bb[0] = -this.cos(this.fz + 135);
      this.bc[0] = this.sin(this.fz + 135);
      this.bb[1] = this.cos(this.fz + 45);
      this.bc[1] = -this.sin(this.fz + 45);
      this.bb[2] = -this.cos(this.fz + 180);
      this.bc[2] = this.sin(this.fz + 180);

      for(int var1 = 0; var1 < 3; ++var1) {
         this.bd[var1] = -(this.bb[var1] * this.fm >> 16) - (this.bc[var1] * this.fn >> 16);
      }

      this.ak = this.bb[2];
      this.al = this.bc[2];
      this.am = this.bd[2];
   }

   private void c(int var1) {
      long var2 = this.cos(this.fz + 90);
      long var4 = -this.sin(this.fz + 90);
      long var6 = (var2 * this.fm >> 16) + (var4 * this.fn >> 16);
      long var8 = (long)(this.dg[1][var1] - this.dg[3][var1]);
      long var10 = (long)(this.dg[2][var1] - this.dg[0][var1]);
      long var12;
      long var14 = ((var12 = (long)(-this.de[var1])) * var4 >> 16) - (var10 * var6 >> 16);
      long var16 = (var8 * var6 >> 16) - (var12 * var2 >> 16);
      l3d_d var10000;
      long var10001;
      long var18;
      if ((var18 = (var8 * var4 >> 16) - (var10 * var2 >> 16)) != 0L) {
         this.bE = (var14 << 16) / var18;
         this.bF = (var16 << 16) / var18;
         long var20 = 58982L;
         this.bE = (this.fm * (65536L - var20) >> 16) + (this.bE * var20 >> 16);
         var10000 = this;
         var10001 = (this.fn * (65536L - var20) >> 16) + (this.bF * var20 >> 16);
      } else {
         this.bE = -10000L;
         var10000 = this;
         var10001 = -10000L;
      }

      var10000.bF = var10001;
   }

   private void e() {
      this.P = -this.cos(this.fz);
      this.Q = this.sin(this.fz);
      this.R = this.Q;
      this.S = -this.P;
   }

   private void d(int var1) {
      this.ap = this.bw[var1];
      this.ar = var1;
      this.as = this.dh[var1];
      if (this.ap != 1) {
         this.e(var1);
         this.f();
         if (this.h()) {
            l3d_d var10000;
            byte var10001;
            if (this.X <= this.Y) {
               var10000 = this;
               var10001 = -1;
            } else {
               var10000 = this;
               var10001 = 1;
            }

            var10000.ay = var10001;
            this.i();
         }
      }
   }

   private void f() {
      l3d_d var10000;
      byte var10001;
      if (this.X < 6552L && this.Y > 6552L) {
         this.Z = (6552L - this.X << 16) / (this.Y - this.X);
         this.X = 6552L;
         this.T += (this.U - this.T) * this.Z >> 16;
         var10000 = this;
         var10001 = 1;
      } else if (this.X > 6552L && this.Y < 6552L) {
         this.Z = (6552L - this.Y << 16) / (this.X - this.Y);
         this.Y = 6552L;
         this.U += (this.T - this.U) * this.Z >> 16;
         var10000 = this;
         var10001 = 2;
      } else {
         var10000 = this;
         var10001 = 3;
      }

      var10000.ax = var10001;
   }

   private void g() {
      if (this.ax == 1) {
         this.ai += (this.aj - this.ai) * this.Z >> 16;
      } else {
         if (this.ax == 2) {
            this.aj -= (this.aj - this.ai) * this.Z >> 16;
         }

      }
   }

   private void e(int var1) {
      long var2 = ((long)this.dg[0][var1] * 75000L >> 16) - this.gn[0];
      long var4 = ((long)this.dg[1][var1] * 75000L >> 16) - this.gn[1];
      this.T = (var2 * this.R >> 16) + (var4 * this.S >> 16);
      this.X = (var2 * this.P >> 16) + (var4 * this.Q >> 16);
      var2 = ((long)this.dg[2][var1] * 75000L >> 16) - this.gn[0];
      var4 = ((long)this.dg[3][var1] * 75000L >> 16) - this.gn[1];
      this.U = (var2 * this.R >> 16) + (var4 * this.S >> 16);
      this.Y = (var2 * this.P >> 16) + (var4 * this.Q >> 16);
   }

   private boolean h() {
      this.T = 7864320L * this.T / this.X + 7831552L;
      this.U = 7864320L * this.U / this.Y + 7831552L;
      this.at = (int)(this.T >> 16);
      this.au = (int)(this.U >> 16);
      if (this.at >= this.au) {
         return false;
      } else if (this.at >= this.aw) {
         return false;
      } else if (this.au <= this.av) {
         return false;
      } else {
         this.W = 283701411840L / this.Y + 7110656L;
         this.V = 283701411840L / this.X + 7110656L;
         return true;
      }
   }

   private void f(int var1) {
      byte var5 = this.dG[var1];
      this.aq = this.bp[this.as];
      l3d_d var10000;
      int[] var10001;
      if (this.ap != 2 && this.ap != 5 && this.ap != 7) {
         this.da = this.cZ;
         this.db = this.cY;
         this.dc = this.cX;
         var10000 = this;
         var10001 = this.cW;
      } else {
         this.da = this.cV;
         this.db = this.cU;
         this.dc = this.cT;
         var10000 = this;
         var10001 = this.cS;
      }

      var10000.dd = var10001;
      int var12;
      if (var5 != -90 && var5 != 0) {
         var10000 = this;
         var12 = (int)(a(((long)(this.dg[1][var1] - this.dg[3][var1]) << 16) / this.sin(var5)) * 75000L >> 16 >> 16);
      } else {
         int[][] var10002;
         byte var10003;
         if (var5 == -90) {
            var10000 = this;
            var12 = this.dg[2][var1];
            var10002 = this.dg;
            var10003 = 0;
         } else {
            var10000 = this;
            var12 = this.dg[1][var1];
            var10002 = this.dg;
            var10003 = 3;
         }

         var12 = abs(var12 - var10002[var10003][var1]) >> 16;
      }

      var10000.aR = var12;
      if (this.aq == 48) {
         this.aR *= 2;
      }

      if (this.aR == 0) {
         this.aR = 1;
      }

      if (this.aq == 24) {
         this.aR *= 4;
      }

      this.ai = 0L;
      this.aj = (long)(this.aq * this.aR - 1 << 16);
      int var2;
      int var7;
      int var8;
      if (var1 >= this.fJ && var1 < this.fK) {
         label145: {
            var7 = (var1 - this.fJ) / 3;
            var8 = (var1 - this.fJ) % 3;
            if (this.ap != 3 && this.ap != 7) {
               if (var8 == 0) {
                  this.ai = (long)this.dR[var7];
                  break label145;
               }

               if (var8 != 2) {
                  break label145;
               }
            } else if (var8 != 0) {
               if (var8 == 2) {
                  this.ai = (long)this.dR[var7];
               }
               break label145;
            }

            this.aj = (long)this.dS[var7];
         }
      } else if (var1 >= this.fL) {
         var7 = this.bf.length;
         var8 = 0;

         for(var2 = 1; var2 < var7; ++var2) {
            if (var1 < this.bf[var2]) {
               var8 = var2 - 1;
               break;
            }
         }

         int var9 = var1 - this.bf[var8];
         int var10 = this.aq / this.be[var8];
         this.ai = (long)(var9 * var10 << 16);
         this.aj = (long)(var9 * var10 + var10 - 1 << 16);
      }

      if (this.ap == 3 || this.ap == 7) {
         long var11 = this.aj;
         this.aj = this.ai;
         this.ai = var11;
      }

      this.g();
      this.aa = (this.aj << 16) / this.Y - (this.ai << 16) / this.X;
      this.ab = this.U - this.T;
      this.ac = 4294967296L / this.Y - 4294967296L / this.X;
      long var13;
      long var15;
      if (this.ay == 1) {
         this.ag = this.V;
         this.ad = (this.ac << 16) / this.ab;
         this.ae = (this.aa << 16) / this.ab;
         this.ah = (this.ai << 16) / this.X;
         var10000 = this;
         var15 = 4294967296L;
         var13 = this.X;
      } else {
         this.ag = this.W;
         this.ad = -(this.ac << 16) / this.ab;
         this.ae = -(this.aa << 16) / this.ab;
         this.ah = (this.aj << 16) / this.Y;
         var10000 = this;
         var15 = 4294967296L;
         var13 = this.Y;
      }

      var10000.af = var15 / var13;
      int var6 = this.as < 32 ? 1 : 7;

      for(var7 = 0; var7 < var6; ++var7) {
         int[] var14;
         if (var6 == 1) {
            var14 = this.bh;
            var12 = this.as;
         } else {
            var14 = this.bh;
            var12 = this.bx[(this.as - 32) * var6 + var7];
         }

         int var3 = var14[var12];

         for(var2 = 0; var2 < 3; ++var2) {
            for(int var4 = 0; var4 < 3; ++var4) {
               this.by[var7][var2][var4] = this.bo[var3];
               ++var3;
            }
         }
      }

   }

   private void i() {
      long var6;
      l3d_d var10000;
      int var10001;
      int var26;
      byte var36;
      boolean var37;
      boolean var38;
      int var39;
      int var40;
      label436: {
         label435: {
            var38 = false;
            var39 = this.aS;
            var40 = this.aT;
            var36 = this.bv[this.ar];
            var37 = false;
            var26 = 0;
            int var21 = (int)(this.V >> 16);
            int var22 = (int)(this.W >> 16);
            long var2 = (long)(this.au - this.at);
            long var4 = (long)(var22 - var21 << 16);
            var6 = (this.ay == 1 ? var4 : -var4) / var2;
            if (this.ay == 1) {
               if (this.au >= this.aw) {
                  this.au = this.aw - 1;
               }

               if (var36 != 0) {
                  break label436;
               }

               if (this.at <= this.av + 1) {
                  this.av = this.au;
               }

               if (this.au < this.aw - 1) {
                  break label436;
               }

               if (this.at >= 0) {
                  var10000 = this;
                  var10001 = this.at;
                  break label435;
               }

               var10000 = this;
            } else {
               if (this.at <= this.av) {
                  this.at = this.av + 1;
               }

               if (var36 != 0) {
                  break label436;
               }

               if (this.at <= this.av + 1) {
                  if (this.au <= 239) {
                     var10000 = this;
                     var10001 = this.au;
                  } else {
                     var10000 = this;
                     var10001 = 239;
                  }

                  var10000.av = var10001;
               }

               if (this.au < this.aw - 1) {
                  break label436;
               }

               if (this.at >= 0) {
                  var10000 = this;
                  var10001 = this.at;
                  break label435;
               }

               var10000 = this;
            }

            var10001 = 0;
         }

         var10000.aw = var10001;
      }

      int var25 = this.as < 32 ? 1 : 7;
      byte var27;
      int var44;
      if (this.ay == 1) {
         var27 = 1;
         this.bN = this.at;
         var44 = this.au;
      } else {
         var27 = -1;
         this.bN = this.au;
         var44 = this.at;
      }

      int var28 = var44;
      if (this.an == -1) {
         if (this.selectedMap != 6 && this.ar >= this.fL && this.ar < this.fL + 72) {
            this.bE = (long)this.dg[0][this.ar];
            this.bF = (long)this.dg[1][this.ar];
         } else {
            this.c(this.ar);
         }

         this.eu = (int)(a(this.bE - this.fm) >> 16);
         this.ev = (int)(a(this.bF - this.fn) >> 16);
         if (this.eu <= this.eM && this.ev <= this.eM) {
            var38 = true;
         }
      }

      int var35 = var28 + var27;

      while(true) {
         while(true) {
            while(this.bN != var35) {
               if (this.bN >= 0 && this.bN <= 239) {
                  int var10002;
                  int[] var47;
                  label399: {
                     byte var45;
                     int[][] var46;
                     label398: {
                        if (var36 == 0) {
                           if (this.bz[this.bN]) {
                              this.bN += var27;
                              ++var26;
                              continue;
                           }

                           if (!var37) {
                              this.f(this.ar);
                              var37 = true;
                           }

                           this.bz[this.bN] = true;
                           if (var26 != 0) {
                              this.ag += (long)var26 * var6;
                              this.ah += (long)var26 * this.ae;
                              this.af += (long)var26 * this.ad;
                              var26 = 0;
                           }

                           if (this.bu[this.bN] == 0) {
                              var46 = this.bl;
                              var45 = 0;
                              break label398;
                           }

                           var10000 = this;
                        } else {
                           if (this.bz[this.bN] || this.bu[this.bN] == var36) {
                              this.bN += var27;
                              ++var26;
                              continue;
                           }

                           if (!var37) {
                              this.f(this.ar);
                              var37 = true;
                           }

                           if (this.bu[this.bN] * var36 == 2) {
                              this.bz[this.bN] = true;
                           }

                           if (var26 != 0) {
                              this.ag += (long)var26 * var6;
                              this.ah += (long)var26 * this.ae;
                              this.af += (long)var26 * this.ad;
                              var26 = 0;
                           }

                           if (this.bu[this.bN] == 0) {
                              if (var36 == 1) {
                                 var47 = this.bl[0];
                                 var10001 = this.bN;
                                 var10002 = (int)this.af;
                              } else {
                                 var47 = this.bl[0];
                                 var10001 = this.bN;
                                 var10002 = -((int)this.af);
                              }

                              var47[var10001] = var10002;
                              this.bu[this.bN] = var36;
                              break label399;
                           }

                           var10000 = this;
                        }

                        var46 = var10000.bl;
                        var45 = 1;
                     }

                     var46[var45][this.bN] = (int)this.af;
                  }

                  int var14;
                  int var12 = (var14 = (int)((this.ah << 16) / this.af >> 16)) % this.aq;
                  int var13 = var25 == 7 ? var14 / this.aq % var25 : 0;
                  if (var12 < 0 || var13 < 0) {
                     var12 = 0;
                     var13 = 0;
                  }

                  if (this.ap != 0) {
                     label469: {
                        if (this.ap != 5 && this.ap != 10) {
                           if (this.ap == 15) {
                              var44 = this.aq - 1 - var12;
                           } else {
                              if (this.ap == 20) {
                                 if (var13 != 0) {
                                    break label469;
                                 }
                              } else if (this.ap != 25 || var13 != this.aR - 1) {
                                 break label469;
                              }

                              var44 = var12 % 24;
                           }
                        } else {
                           if (var14 / this.aq != 1) {
                              break label469;
                           }

                           var44 = this.aq - 1 - var12;
                        }

                        var12 = var44;
                     }
                  }

                  int var19 = this.aq != 140 ? this.aq : 96;
                  this.aA = 0;

                  for(int var8 = 2; var8 >= 0; --var8) {
                     if (var12 >= this.by[var13][var8][0]) {
                        this.aA = this.bi[this.by[var13][var8][1]] + (var12 - this.by[var13][var8][0] + this.by[var13][var8][2]) % var19 * 12;
                        break;
                     }
                  }

                  this.az = this.aA << 16;
                  this.aB = this.aA + 11;
                  int var24 = (int)(this.ag >> 16);
                  int var23 = 217 - var24;
                  int var29;
                  if ((var29 = 108 - var23) == 0) {
                     this.ah += this.ae;
                     this.af += this.ad;
                     this.bN += var27;
                  } else {
                     int var17;
                     label343: {
                        label342: {
                           int var30;
                           int var15 = (var30 = var29 + 1) >> 2;
                           int var16 = var30 - (var15 << 2);
                           this.aC = 3014656 / var29;
                           this.aD = this.bN + var23 * 240;
                           this.aK = this.bN + var24 * 240;
                           this.aL = this.bN + '쭰';
                           int var18 = (var17 = var15 * 240) + 240;
                           if (var16 == 0) {
                              this.aE = this.aD + var17;
                              this.aF = this.aE + var17;
                              this.aG = this.aF + var17;
                              this.aJ = this.aK - var17;
                              var10000 = this;
                              var10001 = this.aJ;
                              var10002 = var17;
                           } else {
                              if (var16 == 1) {
                                 this.aE = this.aD + var17;
                                 this.aF = this.aE + var17;
                                 this.aG = this.aF + var18;
                                 this.aJ = this.aK - var17;
                                 this.aI = this.aJ - var17;
                                 var10000 = this;
                                 var10001 = this.aI;
                                 var10002 = var18;
                                 break label342;
                              }

                              if (var16 == 2) {
                                 this.aE = this.aD + var17;
                                 this.aF = this.aE + var18;
                                 this.aG = this.aF + var17;
                                 var10000 = this;
                                 var10001 = this.aK;
                                 var10002 = var17;
                              } else {
                                 if (var16 != 3) {
                                    break label343;
                                 }

                                 this.aE = this.aD + var18;
                                 this.aF = this.aE + var18;
                                 this.aG = this.aF + var17;
                                 var10000 = this;
                                 var10001 = this.aK;
                                 var10002 = var18;
                              }

                              var10000.aJ = var10001 - var10002;
                              var10000 = this;
                              var10001 = this.aJ;
                              var10002 = var18;
                           }

                           var10000.aI = var10001 - var10002;
                           var10000 = this;
                           var10001 = this.aI;
                           var10002 = var17;
                        }

                        var10000.aH = var10001 - var10002;
                     }

                     if (var24 > 0) {
                        label330: {
                           label329: {
                              int var31 = this.bN;
                              int var32 = this.aD - 240;
                              int var33 = this.aK + 240;
                              int var34 = this.aL;
                              if (this.bv[this.ar] == 0) {
                                 if (this.bu[this.bN] == 0) {
                                    while(var31 < var32) {
                                       this.bk[var31] = var39;
                                       this.bk[var32] = var39;
                                       this.bk[var33] = var40;
                                       this.bk[var34] = var40;
                                       var31 += 240;
                                       var32 -= 240;
                                       var33 += 240;
                                       var34 -= 240;
                                    }

                                    if (var31 != var32) {
                                       break label330;
                                    }

                                    this.bk[var31] = var39;
                                    var47 = this.bk;
                                    var10001 = var33;
                                    var10002 = var40;
                                    break label329;
                                 }

                                 if (this.bu[this.bN] != 1) {
                                    while(var33 < var34) {
                                       this.bk[var33] = var40;
                                       this.bk[var34] = var40;
                                       var33 += 240;
                                       var34 -= 240;
                                    }

                                    if (var33 != var34) {
                                       break label330;
                                    }

                                    var47 = this.bk;
                                    var10001 = var33;
                                    var10002 = var40;
                                    break label329;
                                 }

                                 while(var31 < var32) {
                                    this.bk[var31] = var39;
                                    this.bk[var32] = var39;
                                    var31 += 240;
                                    var32 -= 240;
                                 }

                                 if (var31 != var32) {
                                    break label330;
                                 }
                              } else {
                                 if (this.bv[this.ar] == 1) {
                                    while(var33 < var34) {
                                       this.bk[var33] = var40;
                                       this.bk[var34] = var40;
                                       var33 += 240;
                                       var34 -= 240;
                                    }

                                    if (var33 != var34) {
                                       break label330;
                                    }

                                    var47 = this.bk;
                                    var10001 = var33;
                                    var10002 = var40;
                                    break label329;
                                 }

                                 while(var31 < var32) {
                                    this.bk[var31] = var39;
                                    this.bk[var32] = var39;
                                    var31 += 240;
                                    var32 -= 240;
                                 }

                                 if (var31 != var32) {
                                    break label330;
                                 }
                              }

                              var47 = this.bk;
                              var10001 = var31;
                              var10002 = var39;
                           }

                           var47[var10001] = var10002;
                        }
                     }

                     this.aW = true;
                     this.aX = true;
                     this.aY = true;
                     if (this.aE - this.aD != var17) {
                        this.aW = false;
                     }

                     if (this.aF - this.aE != var17) {
                        this.aX = false;
                     }

                     if (this.aG - this.aF != var17) {
                        this.aY = false;
                     }

                     this.ag += var6;
                     if (var36 == 1) {
                        ++this.aB;
                        int var20 = this.aA;
                        this.aA = this.aB;
                        this.aB = var20;
                        this.az = (this.aA << 16) - 1;
                        this.aC = -this.aC;
                     }

                     label280: {
                        this.aZ = true;
                        this.ba = true;
                        boolean var49;
                        if (this.aD >= this.bN) {
                           this.h(this.aD + var17);
                           this.aZ = true;
                           var10000 = this;
                           var49 = true;
                        } else {
                           int var41;
                           if (this.aD < this.bN && this.aE >= this.bN) {
                              this.j(this.aE + this.bN - this.aD);
                              var41 = this.aD + var17;
                              this.aD = this.bN;
                              this.aK = this.bN + '쭰';
                              this.h(var41);
                              this.aZ = true;
                              var10000 = this;
                              var49 = true;
                           } else if (this.aE < this.bN && this.aF >= this.bN) {
                              this.l(this.aF + this.bN - this.aE);
                              var41 = this.aE + var17;
                              this.aE = this.bN;
                              this.aJ = this.bN + '쭰';
                              this.j(var41);
                              this.aZ = false;
                              var10000 = this;
                              var49 = true;
                           } else {
                              if (this.aF >= this.bN || this.aG < this.bN) {
                                 break label280;
                              }

                              label268: {
                                 if (var36 == 0) {
                                    if (this.bu[this.bN] == 0) {
                                       this.m(this.aG + this.bN - this.aF);
                                       break label268;
                                    }

                                    if (this.bu[this.bN] != 1) {
                                       this.b(this.aG + this.bN - this.aF, this.cZ);
                                       break label268;
                                    }
                                 } else if (var36 == 1) {
                                    this.b(this.aG + this.bN - this.aF, this.cS);
                                    break label268;
                                 }

                                 this.a(this.aG + this.bN - this.aF, this.cV);
                              }

                              var41 = this.aF + var17;
                              this.aF = this.bN;
                              this.aI = this.bN + '쭰';
                              this.l(var41);
                              this.aZ = false;
                              var10000 = this;
                              var49 = false;
                           }
                        }

                        var10000.ba = var49;
                     }

                     if (this.aG >= this.bN) {
                        label482: {
                           int[] var10003;
                           int[] var10004;
                           int[] var48;
                           int[] var50;
                           if (var36 == 0 && this.bu[this.bN] == 0) {
                              this.a(this.cS, this.cT, this.cU, this.cV);
                              var10000 = this;
                              var50 = this.dd;
                              var48 = this.dc;
                              var10003 = this.db;
                              var10004 = this.da;
                           } else {
                              if (var36 == 0 && this.bu[this.bN] == 1 || var36 == 2) {
                                 this.a(this.cS, this.cT, this.cU, this.cV);
                                 break label482;
                              }

                              if (var36 == 0 && this.bu[this.bN] == 2) {
                                 var10000 = this;
                                 var50 = this.dd;
                                 var48 = this.dc;
                                 var10003 = this.db;
                                 var10004 = this.da;
                              } else {
                                 var10000 = this;
                                 var50 = this.cV;
                                 var48 = this.cU;
                                 var10003 = this.cT;
                                 var10004 = this.cS;
                              }
                           }

                           var10000.b(var50, var48, var10003, var10004);
                        }
                     }

                     this.ah += this.ae;
                     this.af += this.ad;
                     this.bN += var27;
                     byte var43;
                     short var51;
                     if (this.eE != 3 && this.ar >= this.fI && this.ar < this.fJ) {
                        var43 = 92;
                        var51 = 148;
                     } else {
                        var43 = 113;
                        var51 = 127;
                     }

                     short var42 = var51;
                     if (var38 && this.bN >= var43 && this.bN <= var42) {
                        int var11 = this.eu + this.ev;
                        this.an = this.ar;
                        this.bQ = var11;
                        this.bA = this.bE;
                        this.bB = this.bF;
                     }
                  }
               } else {
                  this.bN += var27;
                  ++var26;
               }
            }

            return;
         }
      }
   }

   private void a(int[] var1, int[] var2, int[] var3, int[] var4) {
      if (this.aZ && !this.aW) {
         this.bk[this.aD] = var1[this.aB];
      }

      if (this.ba && !this.aX) {
         this.bk[this.aE] = var2[this.aB];
      }

      if (!this.aY) {
         this.bk[this.aF] = var3[this.aB];
      }

      int[] var10000;
      int var10001;
      if (this.aG == this.bN + 25920) {
         var10000 = this.bk;
         var10001 = this.aG;
      } else {
         var10000 = this.bk;
         var10001 = this.aG - 240;
      }

      var10000[var10001] = var4[this.aB];
   }

   private void b(int[] var1, int[] var2, int[] var3, int[] var4) {
      if (this.aZ && !this.aW) {
         this.bk[this.aK] = var1[this.aB];
      }

      if (this.ba && !this.aX) {
         this.bk[this.aJ] = var2[this.aB];
      }

      if (!this.aY) {
         this.bk[this.aI] = var3[this.aB];
      }

      int[] var10000;
      int var10001;
      if (this.aH == this.bN + 26160) {
         var10000 = this.bk;
         var10001 = this.aH;
      } else {
         var10000 = this.bk;
         var10001 = this.aH + 240;
      }

      var10000[var10001] = var4[this.aB];
   }

   private void g(int var1) {
      int var2;
      for(var2 = this.aA; this.aD < var1; this.az += this.aC) {
         var2 = this.az >> 16;
         this.bk[this.aD] = this.cS[var2];
         this.bk[this.aE] = this.cT[var2];
         this.bk[this.aF] = this.cU[var2];
         this.bk[this.aG] = this.cV[var2];
         this.bk[this.aH] = this.da[var2];
         this.bk[this.aI] = this.db[var2];
         this.bk[this.aJ] = this.dc[var2];
         this.bk[this.aK] = this.dd[var2];
         this.aD += 240;
         this.aE += 240;
         this.aF += 240;
         this.aG += 240;
         this.aH -= 240;
         this.aI -= 240;
         this.aJ -= 240;
         this.aK -= 240;
      }

      this.aA = var2;
   }

   private void h(int var1) {
      if (this.bv[this.ar] == 0) {
         if (this.bu[this.bN] == 0) {
            this.g(var1);
            return;
         }

         if (this.bu[this.bN] != 1) {
            this.b(var1, this.cW, this.cX, this.cY, this.cZ);
            return;
         }
      } else if (this.bv[this.ar] == 1) {
         this.b(var1, this.cV, this.cU, this.cT, this.cS);
         return;
      }

      this.a(var1, this.cS, this.cT, this.cU, this.cV);
   }

   private void i(int var1) {
      int var2;
      for(var2 = this.aA; this.aE < var1; this.az += this.aC) {
         var2 = this.az >> 16;
         this.bk[this.aE] = this.cT[var2];
         this.bk[this.aF] = this.cU[var2];
         this.bk[this.aG] = this.cV[var2];
         this.bk[this.aH] = this.da[var2];
         this.bk[this.aI] = this.db[var2];
         this.bk[this.aJ] = this.dc[var2];
         this.aE += 240;
         this.aF += 240;
         this.aG += 240;
         this.aH -= 240;
         this.aI -= 240;
         this.aJ -= 240;
      }

      this.aA = var2;
   }

   private void j(int var1) {
      if (this.bv[this.ar] == 0) {
         if (this.bu[this.bN] == 0) {
            this.i(var1);
            return;
         }

         if (this.bu[this.bN] != 1) {
            this.b(var1, this.cX, this.cY, this.cZ);
            return;
         }
      } else if (this.bv[this.ar] == 1) {
         this.b(var1, this.cU, this.cT, this.cS);
         return;
      }

      this.a(var1, this.cT, this.cU, this.cV);
   }

   private void k(int var1) {
      int var2;
      for(var2 = this.aA; this.aF < var1; this.az += this.aC) {
         var2 = this.az >> 16;
         this.bk[this.aF] = this.cU[var2];
         this.bk[this.aG] = this.cV[var2];
         this.bk[this.aH] = this.da[var2];
         this.bk[this.aI] = this.db[var2];
         this.aF += 240;
         this.aG += 240;
         this.aH -= 240;
         this.aI -= 240;
      }

      this.aA = var2;
   }

   private void l(int var1) {
      if (this.bv[this.ar] == 0) {
         if (this.bu[this.bN] == 0) {
            this.k(var1);
            return;
         }

         if (this.bu[this.bN] != 1) {
            this.b(var1, this.cY, this.cZ);
            return;
         }
      } else if (this.bv[this.ar] == 1) {
         this.b(var1, this.cT, this.cS);
         return;
      }

      this.a(var1, this.cU, this.cV);
   }

   private void m(int var1) {
      int var2;
      for(var2 = this.aA; this.aG < var1; this.az += this.aC) {
         var2 = this.az >> 16;
         this.bk[this.aG] = this.cV[var2];
         this.bk[this.aH] = this.da[var2];
         this.aG += 240;
         this.aH -= 240;
      }

      this.aA = var2;
   }

   private void a(int var1, int[] var2, int[] var3, int[] var4, int[] var5) {
      int var6;
      for(var6 = this.aA; this.aD < var1; this.az += this.aC) {
         var6 = this.az >> 16;
         this.bk[this.aD] = var2[var6];
         this.bk[this.aE] = var3[var6];
         this.bk[this.aF] = var4[var6];
         this.bk[this.aG] = var5[var6];
         this.aD += 240;
         this.aE += 240;
         this.aF += 240;
         this.aG += 240;
      }

      this.aA = var6;
   }

   private void b(int var1, int[] var2, int[] var3, int[] var4, int[] var5) {
      int var6 = this.aA;

      for(int var7 = this.aL - var1 + this.bN; this.aK > var7; this.az += this.aC) {
         var6 = this.az >> 16;
         this.bk[this.aK] = var2[var6];
         this.bk[this.aJ] = var3[var6];
         this.bk[this.aI] = var4[var6];
         this.bk[this.aH] = var5[var6];
         this.aH -= 240;
         this.aI -= 240;
         this.aJ -= 240;
         this.aK -= 240;
      }

      this.aA = var6;
   }

   private void a(int var1, int[] var2, int[] var3, int[] var4) {
      int var5;
      for(var5 = this.aA; this.aE < var1; this.az += this.aC) {
         var5 = this.az >> 16;
         this.bk[this.aE] = var2[var5];
         this.bk[this.aF] = var3[var5];
         this.bk[this.aG] = var4[var5];
         this.aE += 240;
         this.aF += 240;
         this.aG += 240;
      }

      this.aA = var5;
   }

   private void b(int var1, int[] var2, int[] var3, int[] var4) {
      int var5 = this.aA;

      for(int var6 = this.aL - var1 + this.bN; this.aJ > var6; this.az += this.aC) {
         var5 = this.az >> 16;
         this.bk[this.aJ] = var2[var5];
         this.bk[this.aI] = var3[var5];
         this.bk[this.aH] = var4[var5];
         this.aH -= 240;
         this.aI -= 240;
         this.aJ -= 240;
      }

      this.aA = var5;
   }

   private void a(int var1, int[] var2, int[] var3) {
      int var4;
      for(var4 = this.aA; this.aF < var1; this.az += this.aC) {
         var4 = this.az >> 16;
         this.bk[this.aF] = var2[var4];
         this.bk[this.aG] = var3[var4];
         this.aF += 240;
         this.aG += 240;
      }

      this.aA = var4;
   }

   private void b(int var1, int[] var2, int[] var3) {
      int var4 = this.aA;

      for(int var5 = this.aL - var1 + this.bN; this.aI > var5; this.az += this.aC) {
         var4 = this.az >> 16;
         this.bk[this.aI] = var2[var4];
         this.bk[this.aH] = var3[var4];
         this.aH -= 240;
         this.aI -= 240;
      }

      this.aA = var4;
   }

   private void a(int var1, int[] var2) {
      int var3;
      for(var3 = this.aA; this.aG < var1; this.az += this.aC) {
         var3 = this.az >> 16;
         this.bk[this.aG] = var2[var3];
         this.aG += 240;
      }

      this.aA = var3;
   }

   private void b(int var1, int[] var2) {
      int var3 = this.aA;

      for(int var4 = this.aL - var1 + this.bN; this.aH > var4; this.az += this.aC) {
         var3 = this.az >> 16;
         this.bk[this.aH] = var2[var3];
         this.aH -= 240;
      }

      this.aA = var3;
   }

   private boolean n(int var1) {
      return (this.ak * (long)this.cb[var1][0] >> 16) + (this.al * (long)this.cb[var1][1] >> 16) + this.am <= 0L;
   }

   private void o(int var1) {
      int var3;
      if (var1 < this.fx && this.cq[var1] < 8 && !this.cv[var1]) {
         label94: {
            l3d_d var10000;
            byte var10001;
            byte var10002;
            byte var10003;
            byte var10004;
            if ((var3 = (var3 = (this.fz < 0 ? 360 - abs(this.fz) % 360 : this.fz % 360) - this.cg[var1]) < 0 ? 360 - abs(var3) % 360 : var3 % 360) >= 0 && var3 < 45 || var3 >= 315 && var3 < 360) {
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

      this.p(var1);
      if (this.bJ >= 6552L) {
         this.j();
         int var2 = (int)(this.bG >> 16);
         var3 = (int)(this.bH >> 16);
         if (var2 <= 239) {
            if (var3 >= 0) {
               if (var3 != var2) {
                  this.bY[this.bK] = this.bG;
                  this.bZ[this.bK] = this.bH;
                  this.ca[this.bK] = this.bI;
                  this.cf[this.bK] = var1;
                  this.cd[this.bK] = this.bK;
                  this.bX[this.bK] = this.bJ;
                  ++this.bK;
               }
            }
         }
      }
   }

   private void a(int var1, int var2, int var3, int var4, int var5) {
      byte[] var10000;
      int var10001;
      int var10002;
      if (this.cm[var5] == 1) {
         if (this.ct[var5]) {
            var10000 = this.cq;
            var10001 = var5;
            var10002 = var1;
         } else {
            var10000 = this.cq;
            var10001 = var5;
            var10002 = var2;
         }
      } else if (this.ct[var5]) {
         var10000 = this.cq;
         var10001 = var5;
         var10002 = var3;
      } else {
         var10000 = this.cq;
         var10001 = var5;
         var10002 = var4;
      }

      var10000[var10001] = (byte)var10002;
   }

   private void p(int var1) {
      long var2 = ((long)this.cb[var1][0] * 75000L >> 16) - this.gn[0];
      long var4 = ((long)this.cb[var1][1] * 75000L >> 16) - this.gn[1];
      this.bJ = (var2 * this.P >> 16) + (var4 * this.Q >> 16);
      int[] var10000;
      byte var10001;
      if (this.bW) {
         var10000 = this.bg;
         var10001 = this.cq[var1];
      } else {
         var10000 = this.bg;
         var10001 = this.fZ;
      }

      long var6 = (long)var10000[var10001];
      this.bG = (var2 * this.R >> 16) + (var4 * this.S >> 16) - (var6 * 75000L >> 16);
      this.bH = (var2 * this.R >> 16) + (var4 * this.S >> 16) + (var6 * 75000L >> 16);
   }

   private void j() {
      this.bG = 7864320L * this.bG / this.bJ + 7831552L;
      this.bI = 283701411840L / this.bJ + 7110656L;
      this.bH = 7864320L * this.bH / this.bJ + 7831552L;
   }

   private void k() {
      int[] var6 = new int[this.bK];

      int var1;
      for(var1 = 0; var1 < this.bK; var6[var1] = var1++) {
      }

      this.bP = 10000;

      for(var1 = 0; var1 < this.bK; ++var1) {
         for(int var2 = var1 + 1; var2 < this.bK; ++var2) {
            int var5 = var6[var2];
            int var4 = var6[var1];
            if (this.bX[var5] > this.bX[var4]) {
               var6[var1] = var5;
               var6[var2] = var4;
            }
         }

         this.q(var6[var1]);
      }

   }

   private void q(int var1) {
      boolean var26 = false;
      this.bG = this.bY[var1];
      this.bH = this.bZ[var1];
      this.bI = this.ca[var1];
      this.bL = this.cf[var1];
      l3d_d var10000;
      int var10001;
      if (this.bW) {
         var10000 = this;
         var10001 = this.cq[this.bL];
      } else {
         var10000 = this;
         var10001 = this.fZ;
      }

      var10000.bS = var10001;
      short var19 = this.bs[this.bS];
      int var20 = this.bt[this.bS] / this.br[this.bS];
      short var21 = this.bn[this.bq[this.bS]][this.bS];
      this.bJ = this.bX[var1];
      this.bM = this.bq[this.bS];

      int var14;
      for(int var27 = var14 = this.bS * 50; var27 < var14 + 50; ++var27) {
         this.bj[var27 - var14] = this.bm[this.cr[this.bL]][var27];
      }

      int var9 = (int)(this.bG >> 16);
      int var10 = (int)(this.bH >> 16);
      long var2 = (long)((var19 - 1 << 16) / (var10 - var9));
      long var6 = 0L;
      long var4 = 4294967296L / this.bJ;
      int var22 = 0;
      int var12 = (int)(this.bI >> 16);
      int var13 = 217 - var12;
      int var23;
      if ((var23 = 108 - var13) != 0) {
         this.aC = (var20 * 4 - 1 << 16) / var23;
         int var24;
         int var15 = (var24 = var23 + 1) >> 2;
         int var16 = var24 - (var15 << 2);
         int var17;
         int var18 = (var17 = var15 * 240) + 240;
         if (var10 > 239) {
            var10 = 239;
         }

         boolean var35 = false;
         var10000 = this;
         var10001 = var9;

         while(true) {
            var10000.bN = var10001;
            int var28;
            int var29;
            if (this.bN > var10) {
               if (this.eE == 3 && this.bL < 64 && var35) {
                  var28 = (int)(a((long)this.cb[this.bL][0] - this.bA) >> 16);
                  var29 = (int)(a((long)this.cb[this.bL][1] - this.bB) >> 16);
                  if (var28 <= 1 && var29 <= 1) {
                     this.ce[this.bR] = this.bL;
                     ++this.bR;
                  }
               }

               return;
            }

            if (this.bN < 0) {
               ++var22;
            } else {
               label186: {
                  byte var32;
                  label168: {
                     if (this.bl[1][this.bN] != 0) {
                        if (var4 <= (long)this.bl[1][this.bN]) {
                           ++var22;
                           break label186;
                        }

                        if (var4 <= (long)abs(this.bl[0][this.bN])) {
                           if (this.bl[0][this.bN] > 0) {
                              var10000 = this;
                              var32 = 1;
                           } else {
                              var10000 = this;
                              var32 = 2;
                           }
                           break label168;
                        }

                        var10000 = this;
                     } else {
                        if (var4 <= (long)abs(this.bl[0][this.bN])) {
                           ++var22;
                           break label186;
                        }

                        var10000 = this;
                     }

                     var32 = 0;
                  }

                  var10000.aU = var32;
                  if (var22 != 0) {
                     var6 += (long)var22 * var2;
                     var22 = 0;
                  }

                  int var8 = (int)(var6 >> 16) % var19;
                  this.aA = var21 + var8 * var20;
                  this.aB = this.aA + var20 - 1;
                  this.az = this.aA << 16;
                  if (!this.cv[this.bL] && this.bL < 64) {
                     this.eu = (int)(a((long)this.cb[this.bL][0] - this.fm) >> 16);
                     this.ev = (int)(a((long)this.cb[this.bL][1] - this.fn) >> 16);
                     if (this.eu <= this.eM && this.ev <= this.eM && (this.eE != 3 || this.bL < 32)) {
                        var26 = true;
                     }
                  }

                  label151: {
                     int var10002;
                     label150: {
                        this.aD = this.bN + var13 * 240;
                        this.aK = this.bN + var12 * 240;
                        this.aL = this.bN + '쭰';
                        if (var16 == 0) {
                           this.aE = this.aD + var17;
                           this.aF = this.aE + var17;
                           this.aG = this.aF + var17;
                           this.aJ = this.aK - var17;
                           var10000 = this;
                           var10001 = this.aJ;
                           var10002 = var17;
                        } else {
                           if (var16 == 1) {
                              this.aE = this.aD + var17;
                              this.aF = this.aE + var17;
                              this.aG = this.aF + var18;
                              this.aJ = this.aK - var17;
                              this.aI = this.aJ - var17;
                              var10000 = this;
                              var10001 = this.aI;
                              var10002 = var18;
                              break label150;
                           }

                           if (var16 == 2) {
                              this.aE = this.aD + var17;
                              this.aF = this.aE + var18;
                              this.aG = this.aF + var17;
                              var10000 = this;
                              var10001 = this.aK;
                              var10002 = var17;
                           } else {
                              if (var16 != 3) {
                                 break label151;
                              }

                              this.aE = this.aD + var18;
                              this.aF = this.aE + var18;
                              this.aG = this.aF + var17;
                              var10000 = this;
                              var10001 = this.aK;
                              var10002 = var18;
                           }

                           var10000.aJ = var10001 - var10002;
                           var10000 = this;
                           var10001 = this.aJ;
                           var10002 = var18;
                        }

                        var10000.aI = var10001 - var10002;
                        var10000 = this;
                        var10001 = this.aI;
                        var10002 = var17;
                     }

                     var10000.aH = var10001 - var10002;
                  }

                  this.aW = true;
                  this.aX = true;
                  this.aY = true;
                  if (this.aE - this.aD != var17) {
                     this.aW = false;
                  }

                  if (this.aF - this.aE != var17) {
                     this.aX = false;
                  }

                  if (this.aG - this.aF != var17) {
                     this.aY = false;
                  }

                  label135: {
                     this.bO = 1;
                     byte var33;
                     if (this.aD >= this.bN) {
                        this.bO = 1;
                        var10000 = this;
                        var10001 = this.aD + var17;
                        var33 = 1;
                     } else if (this.aD < this.bN && this.aE >= this.bN) {
                        this.bO = 2;
                        this.b(this.aE + this.bN - this.aD, 2);
                        var28 = this.aD + var17;
                        this.aD = this.bN;
                        this.aK = this.bN + '쭰';
                        var10000 = this;
                        var10001 = var28;
                        var33 = 1;
                     } else if (this.aE < this.bN && this.aF >= this.bN) {
                        this.bO = 3;
                        this.b(this.aF + this.bN - this.aE, 3);
                        var28 = this.aE + var17;
                        this.aE = this.bN;
                        this.aJ = this.bN + '쭰';
                        var10000 = this;
                        var10001 = var28;
                        var33 = 2;
                     } else {
                        if (this.aF >= this.bN || this.aG < this.bN) {
                           break label135;
                        }

                        this.bO = 4;
                        this.b(this.aG + this.bN - this.aF, 4);
                        var28 = this.aF + var17;
                        this.aF = this.bN;
                        this.aI = this.bN + '쭰';
                        var10000 = this;
                        var10001 = var28;
                        var33 = 3;
                     }

                     var10000.b(var10001, var33);
                  }

                  var6 += var2;
                  short var34;
                  byte var36;
                  if (this.eE == 3) {
                     var36 = 113;
                     var34 = 127;
                  } else {
                     var36 = 92;
                     var34 = 148;
                  }

                  var29 = var34;
                  var35 = true;
                  int var25;
                  if (var26 && this.bN >= var36 && this.bN <= var29 && (var25 = this.eu + this.ev) < this.bP) {
                     if (this.eE == 3) {
                        this.bC = (long)this.cb[this.bL][0];
                        this.bD = (long)this.cb[this.bL][1];
                        long var30 = 58982L;
                        this.bC = (this.fm * (65536L - var30) >> 16) + (this.bC * var30 >> 16);
                        this.bD = (this.fn * (65536L - var30) >> 16) + (this.bD * var30 >> 16);
                     }

                     this.bU = this.bL;
                     this.bP = var25;
                     if (this.bP < this.bQ && this.eE == 3) {
                        this.bA = this.bC;
                        this.bB = this.bD;
                     }
                  }
               }
            }

            var10000 = this;
            var10001 = this.bN + 1;
         }
      }
   }

   private void b(int var1, int var2) {
      this.aV = 0;
      if (this.bM == 0) {
         int var3 = this.az;
         this.aM = this.aD;
         this.aN = this.aE;
         this.aO = this.aF;
         this.aP = this.aG;
         this.b(var1, this.dk, this.dl, this.dm, this.dn, false, var2);
         this.az = var3;
         this.aD = this.aM;
         this.aE = this.aN;
         this.aF = this.aO;
         this.aG = this.aP;
         this.aV = 1;
         this.a(var1, this.di, this.dj, this.di, this.dj, true, var2);
      } else if (this.bM == 1) {
         this.b(var1, this.do_, this.dp, false, var2);
      } else if (this.bM == 2) {
         this.a(var1, this.dq, this.dr, true, var2);
      } else {
         l3d_d var10000;
         int var10001;
         byte[] var10002;
         byte[] var10003;
         byte[] var10004;
         byte[] var10005;
         if (this.bM == 3) {
            var10000 = this;
            var10001 = var1;
            var10002 = this.ds;
            var10003 = this.dt;
            var10004 = this.du;
            var10005 = this.dv;
         } else {
            if (this.bM == 4) {
               this.aV = 1;
               this.a(var1, this.dw, this.dx, this.dw, this.dx, true, var2);
               return;
            }

            if (this.bM == 5) {
               this.a(var1, this.ds, this.dt, this.du, this.dv, true, var2);
               return;
            }

            if (this.bM != 6) {
               return;
            }

            int var4 = this.az;
            int var5 = this.aA;
            this.a(var1, this.dy, this.dz, this.dA, this.dB, true, var2);
            this.az = var4;
            this.aA = var5;
            var10000 = this;
            var10001 = var1;
            var10002 = this.dC;
            var10003 = this.dD;
            var10004 = this.dE;
            var10005 = this.dF;
         }

         var10000.b(var10001, var10002, var10003, var10004, var10005, false, var2);
      }
   }

   private void a(int var1, byte[] var2, byte[] var3, boolean var4, int var5) {
      if (this.bO != 4) {
         int var6 = var4 ? 2 : 1;
         if (var5 == 1 && this.aU != var6) {
            while(this.aD < var1) {
               this.aA = this.az >> 16;
               this.aQ = var2[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aD] = this.bj[this.aQ];
               }

               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aE] = this.bj[this.aQ];
               }

               this.aD += 240;
               this.aE += 240;
               this.az += this.aC;
            }

            if (!this.aW && var2[this.aB] != -1) {
               this.bk[this.aD] = this.bj[var2[this.aB]];
            }

            if (!this.aX && var3[this.aB] != -1) {
               this.bk[this.aE] = this.bj[var3[this.aB]];
            }
         }

         if (var5 == 2 && this.aU != var6) {
            while(this.aE < var1) {
               this.aA = this.az >> 16;
               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aE] = this.bj[this.aQ];
               }

               this.aE += 240;
               this.az += this.aC;
            }

            if (this.bO == 2) {
               return;
            }

            if (!this.aX && var3[this.aB] != -1) {
               this.bk[this.aE] = this.bj[var3[this.aB]];
            }
         }

         if (var5 == 3 && this.aU != var6) {
            this.az += (var1 - this.aF) / 240 * this.aC;
         }

      }
   }

   private void a(int var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5, boolean var6, int var7) {
      int var8 = var6 ? 2 : 1;
      if (var7 == 1 && this.aU != var8) {
         while(true) {
            if (this.aD >= var1) {
               if (this.aV == 0 && !this.aW && var2[this.aB] != -1) {
                  this.bk[this.aD] = this.bj[var2[this.aB]];
               }

               if (this.aV == 0 && !this.aX && var3[this.aB] != -1) {
                  this.bk[this.aE] = this.bj[var3[this.aB]];
               }

               if (!this.aY && var4[this.aB] != -1) {
                  this.bk[this.aF] = this.bj[var4[this.aB]];
               }

               if (this.aG != this.bN + 25920 || var5[this.aB] == -1) {
                  return;
               }
               break;
            }

            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aG] = this.bj[this.aQ];
            }

            this.aQ = var4[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aF] = this.bj[this.aQ];
            }

            if (this.aV == 0) {
               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aE] = this.bj[this.aQ];
               }

               this.aQ = var2[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aD] = this.bj[this.aQ];
               }
            }

            this.aD += 240;
            this.aE += 240;
            this.aF += 240;
            this.aG += 240;
            this.az += this.aC;
         }
      } else if (var7 == 2 && this.aU != var8) {
         while(this.aE < var1) {
            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aG] = this.bj[this.aQ];
            }

            this.aQ = var4[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aF] = this.bj[this.aQ];
            }

            if (this.aV == 0) {
               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aE] = this.bj[this.aQ];
               }
            }

            this.aE += 240;
            this.aF += 240;
            this.aG += 240;
            this.az += this.aC;
         }

         if (this.bO == 2) {
            return;
         }

         if (this.aV == 0 && !this.aX && var3[this.aB] != -1) {
            this.bk[this.aE] = this.bj[var3[this.aB]];
         }

         if (!this.aY && var4[this.aB] != -1) {
            this.bk[this.aF] = this.bj[var4[this.aB]];
         }

         if (this.aG != this.bN + 25920 || var5[this.aB] == -1) {
            return;
         }
      } else if (var7 == 3 && this.aU != var8) {
         while(this.aF < var1) {
            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aG] = this.bj[this.aQ];
            }

            this.aQ = var4[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aF] = this.bj[this.aQ];
            }

            this.aF += 240;
            this.aG += 240;
            this.az += this.aC;
         }

         if (this.bO == 3) {
            return;
         }

         if (!this.aY && var4[this.aB] != -1) {
            this.bk[this.aF] = this.bj[var4[this.aB]];
         }

         if (this.aG != this.bN + 25920 || var5[this.aB] == -1) {
            return;
         }
      } else {
         if (var7 != 4 || this.aU == var8) {
            return;
         }

         while(this.aG < var1) {
            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aG] = this.bj[this.aQ];
            }

            this.aG += 240;
            this.az += this.aC;
         }

         if (this.bO == 4) {
            return;
         }

         if (this.aG != this.bN + 25920 || var5[this.aB] == 0) {
            return;
         }
      }

      this.bk[this.aG] = this.bj[var5[this.aB]];
   }

   private void b(int var1, byte[] var2, byte[] var3, boolean var4, int var5) {
      int var6 = this.aL - var1 + this.bN;
      if (this.bO != 4) {
         int var7 = var4 ? 2 : 1;
         if (var5 == 1 && this.aU != var7) {
            while(this.aK > var6) {
               this.aA = this.az >> 16;
               this.aQ = var2[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aK] = this.bj[this.aQ];
               }

               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aJ] = this.bj[this.aQ];
               }

               this.aJ -= 240;
               this.aK -= 240;
               this.az += this.aC;
            }

            if (!this.aW && var2[this.aB] != -1) {
               this.bk[this.aK] = this.bj[var2[this.aB]];
            }

            if (!this.aX && var3[this.aB] != -1) {
               this.bk[this.aJ] = this.bj[var3[this.aB]];
            }
         }

         if (var5 == 2 && this.aU != var7) {
            while(this.aJ > var6) {
               this.aA = this.az >> 16;
               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aJ] = this.bj[this.aQ];
               }

               this.aJ -= 240;
               this.az += this.aC;
            }

            if (this.bO == 2) {
               return;
            }

            if (!this.aX && var3[this.aB] != -1) {
               this.bk[this.aJ] = this.bj[var3[this.aB]];
            }
         }

         if (var5 == 3 && this.aU != var7) {
            this.az += (this.aI - var6) / 240 * this.aC;
         }

      }
   }

   private void b(int var1, byte[] var2, byte[] var3, byte[] var4, byte[] var5, boolean var6, int var7) {
      int var8 = this.aL - var1 + this.bN;
      int var9 = var6 ? 2 : 1;
      if (var7 == 1 && this.aU != var9) {
         while(true) {
            if (this.aK <= var8) {
               if (this.aV == 0 && !this.aW && var2[this.aB] != -1) {
                  this.bk[this.aK] = this.bj[var2[this.aB]];
               }

               if (this.aV == 0 && !this.aX && var3[this.aB] != -1) {
                  this.bk[this.aJ] = this.bj[var3[this.aB]];
               }

               if (!this.aY && var4[this.aB] != -1) {
                  this.bk[this.aI] = this.bj[var4[this.aB]];
               }

               if (this.aH != this.bN + 26160 || var5[this.aB] == -1) {
                  return;
               }
               break;
            }

            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aH] = this.bj[this.aQ];
            }

            this.aQ = var4[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aI] = this.bj[this.aQ];
            }

            if (this.aV == 0) {
               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aJ] = this.bj[this.aQ];
               }

               this.aQ = var2[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aK] = this.bj[this.aQ];
               }
            }

            this.aH -= 240;
            this.aI -= 240;
            this.aJ -= 240;
            this.aK -= 240;
            this.az += this.aC;
         }
      } else if (var7 == 2 && this.aU != var9) {
         while(this.aJ > var8) {
            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aH] = this.bj[this.aQ];
            }

            this.aQ = var4[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aI] = this.bj[this.aQ];
            }

            if (this.aV == 0) {
               this.aQ = var3[this.aA];
               if (this.aQ != -1) {
                  this.bk[this.aJ] = this.bj[this.aQ];
               }
            }

            this.aH -= 240;
            this.aI -= 240;
            this.aJ -= 240;
            this.az += this.aC;
         }

         if (this.bO == 2) {
            return;
         }

         if (this.aV == 0 && !this.aX && var3[this.aB] != -1) {
            this.bk[this.aJ] = this.bj[var3[this.aB]];
         }

         if (!this.aY && var4[this.aB] != -1) {
            this.bk[this.aI] = this.bj[var4[this.aB]];
         }

         if (this.aH != this.bN + 26160 || var5[this.aB] == -1) {
            return;
         }
      } else if (var7 == 3 && this.aU != var9) {
         while(this.aI > var8) {
            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aH] = this.bj[this.aQ];
            }

            this.aQ = var4[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aI] = this.bj[this.aQ];
            }

            this.aH -= 240;
            this.aI -= 240;
            this.az += this.aC;
         }

         if (this.bO == 3) {
            return;
         }

         if (!this.aY && var4[this.aB] != -1) {
            this.bk[this.aI] = this.bj[var4[this.aB]];
         }

         if (this.aH != this.bN + 26160 || var5[this.aB] == -1) {
            return;
         }
      } else {
         if (var7 != 4 || this.aU == var9) {
            return;
         }

         while(this.aH > var8) {
            this.aA = this.az >> 16;
            this.aQ = var5[this.aA];
            if (this.aQ != -1) {
               this.bk[this.aH] = this.bj[this.aQ];
            }

            this.aH -= 240;
            this.az += this.aC;
         }

         if (this.bO == 4) {
            return;
         }

         if (this.aH != this.bN + 26160 || var5[this.aB] == -1) {
            return;
         }
      }

      this.bk[this.aH] = this.bj[var5[this.aB]];
   }

   private void l() {
      l3d_d var10000;
      if ((this.gZ[2] || this.gZ[8] || this.gZ[1] || this.gZ[3]) && this.ff - this.cP > 50L) {
         label98: {
            boolean var10001;
            if (this.hd < 3 && this.hh) {
               ++this.hd;
               if (this.hd != 3) {
                  break label98;
               }

               var10000 = this;
               var10001 = false;
            } else {
               if (this.hd <= -3 || this.hh) {
                  break label98;
               }

               --this.hd;
               if (this.hd != -3) {
                  break label98;
               }

               var10000 = this;
               var10001 = true;
            }

            var10000.hh = var10001;
         }

         this.cP = this.ff;
      }

      long var1;
      long var10002;
      label67: {
         if (this.gZ[2]) {
            var10000 = this;
            var1 = this.cx;
            var10002 = this.cz;
         } else {
            if (!this.gZ[8]) {
               break label67;
            }

            var10000 = this;
            var1 = this.cy;
            var10002 = this.cA;
         }

         var10000.a(var1, var10002, 0);
      }

      label61: {
         byte var10003;
         if (this.gZ[1]) {
            var10000 = this;
            var1 = this.cx;
            var10002 = this.cz;
            var10003 = 90;
         } else {
            if (!this.gZ[3]) {
               break label61;
            }

            var10000 = this;
            var1 = this.cx;
            var10002 = this.cz;
            var10003 = -90;
         }

         var10000.a(var1, var10002, var10003);
      }

      label55: {
         int var2;
         if (this.gZ[7]) {
            var10000 = this;
            var2 = this.fz + this.fD;
         } else {
            if (!this.gZ[9]) {
               break label55;
            }

            var10000 = this;
            var2 = this.fz - this.fD;
         }

         var10000.fz = var2;
      }

      if (this.gZ[4]) {
         this.fz += this.fB;
      } else if (this.gZ[6]) {
         this.fz -= this.fB;
      } else {
         if (this.gD == -10000 && this.hg) {
            this.a(this.hb, this.he, this.hf, this.hc);
            ++this.hb;
            if (this.hb == 4) {
               this.hg = false;
            }
         }

      }
   }

   private void a(int var1, long var2, long var4, int var6) {
      this.a(var2 >> (var1 >> 1), var4 >> (var1 >> 1), var6);
   }

   private void a(long var1, long var3, int var5) {
      long[] var6 = new long[2];
      int var7 = this.fz + var5;
      var6[0] = this.gn[0] - (var1 * this.cos(var7) >> 16);
      var6[1] = this.gn[1] + (var1 * this.sin(var7) >> 16);
      if (this.hD) {
         this.gn[0] = var6[0];
         this.gn[1] = var6[1];
      } else if (!this.b(var6)) {
         this.ee = -1;
         this.ao = -1;
         if (this.a(var6)) {
            this.gn[0] = var6[0];
            this.gn[1] = var6[1];
         } else {
            label53: {
               l3d_d var10000;
               if (this.ee >= this.fI && this.ee < this.fJ) {
                  this.ao = this.ee;
                  this.eT = false;
                  if (this.selectedMap != 1 && this.selectedMap != 2) {
                     break label53;
                  }

                  this.v();
                  if (this.gj) {
                     this.a(100);
                  }

                  var10000 = this;
               } else {
                  var10000 = this;
               }

               var10000.eT = true;
            }

            int var8 = 0;

            while(this.ee != -1) {
               this.a(this.ee, var3, var7);
               ++var8;
               if (var8 >= 2) {
                  break;
               }
            }

         }
      }
   }

   private boolean a(long[] var1) {
      this.cB = this.gn[0];
      this.cC = this.gn[1];
      this.cD = var1[0];
      this.cE = var1[1];
      int var2 = this.cN[this.fU].length;
      short var10000 = 0;

      while(true) {
         short var3 = var10000;
         if (var10000 >= var2) {
            this.ee = -1;
            return true;
         }

         short var4 = this.cN[this.fU][var3];
         short var5 = this.cO[this.fU][var3];
         var10000 = var4;

         while(true) {
            short var6 = var10000;
            if (var10000 > var5) {
               var10000 = (short)(var3 + 1);
               break;
            }

            if (this.r(var6)) {
               this.ee = var6;
               return false;
            }

            var10000 = (short)(var6 + 1);
         }
      }
   }

   private boolean r(int var1) {
      if (this.bw[var1] == 1) {
         return false;
      } else {
         long var2 = (long)(this.dg[1][var1] - this.dg[3][var1]);
         long var4 = (long)(this.dg[2][var1] - this.dg[0][var1]);
         if ((var2 * this.cB >> 16) + (var4 * this.cC >> 16) + (long)this.df[var1] > 0L) {
            return false;
         } else if ((var2 * this.cD >> 16) + (var4 * this.cE >> 16) + (long)this.df[var1] < 0L) {
            return false;
         } else {
            this.a((short)((short)var1), (short)((short)(var1 + 1)), 1);
            if ((this.cF * this.cD >> 16) + (this.cG * this.cE >> 16) + this.cJ > 0L) {
               return false;
            } else {
               return (this.cH * this.cD >> 16) + (this.cI * this.cE >> 16) + this.cK <= 0L;
            }
         }
      }
   }

   private void a(int var1, long var2, int var4) {
      long[] var6;
      (var6 = new long[2])[0] = this.gn[0];
      var6[1] = this.gn[1];
      long var7 = (long)(this.dg[1][var1] - this.dg[3][var1]);
      long var9 = (long)(this.dg[2][var1] - this.dg[0][var1]);
      long var11 = -(var7 * this.gn[0] >> 16) - (var9 * this.gn[1] >> 16);
      int var5 = this.c(var1, var4) ? 1 : -1;
      long[] var10000;
      byte var10001;
      long var10002;
      if (this.dG[var1] != 0) {
         var6[0] -= (long)var5 * var2 * this.cos(this.dG[var1]) >> 16;
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
         this.gn[0] = var6[0];
         this.gn[1] = var6[1];
      } else {
        l3d_d var13;
         boolean var14;
         if (this.ee >= this.fI && this.ee < this.fJ) {
            this.ao = this.ee;
            var13 = this;
            var14 = false;
         } else {
            var13 = this;
            var14 = true;
         }

         var13.eT = var14;
      }
   }

   private boolean c(int var1, int var2) {
      return this.sin(var2 - this.dG[var1]) >= 0L;
   }

   private boolean b(long[] var1) {
      long var2 = var1[0];
      long var4 = var1[1];
      int var7 = this.cs[this.fU].length;

      for(int var8 = 0; var8 < var7; ++var8) {
         byte var6 = this.cs[this.fU][var8];
         if (a(var2 - ((long)this.cb[var6][0] * 75000L >> 16)) < 30000L && a(var4 - ((long)this.cb[var6][1] * 75000L >> 16)) < 30000L && this.ci[this.cq[var6]] == 1) {
            if (this.selectedMap == 1 && (this.cq[var6] == this.cL || this.cq[var6] == 26 || this.cq[var6] == 33) && var6 >= 64) {
               return false;
            }

            if (this.selectedMap == 7 && (this.cq[var6] == 47 || this.cq[var6] == 48 || this.cq[var6] == 49)) {
               --this.fo;
               if (this.fo <= 100) {
                  this.fv = 100;
               }

               if (this.fo <= 0 && !this.ez) {
                  this.fo = 0;
                  this.gL = true;
                  this.F();
                  this.fo = this.fs;
                  if (this.fo > 100) {
                     this.fv = 200;
                  }

                  this.fp = this.ft;
                  this.fq = this.fu;
                  this.eE = this.fw;
                  l3d_d var10000;
                  int var10001;
                  if (this.eE == 3) {
                     var10000 = this;
                     var10001 = this.fq;
                  } else {
                     var10000 = this;
                     var10001 = this.fp;
                  }

                  var10000.fr = var10001;
                  if (this.fr > 0) {
                     this.eU = true;
                  }

                  this.eH = 0;
                  this.eD = 0;
                  this.eS = false;
                  this.eJ = 0;
                  this.eC = 40;
                  return false;
               }
            }

            int var9;
            if (this.cq[var6] != this.cL && this.cq[var6] != 26 && this.cq[var6] != 33) {
               if (var6 < 106) {
                  return true;
               }

               if (!this.cv[var6]) {
                  return false;
               }

               if (this.cn[var6] == this.cM + 2) {
                  return false;
               }

               if (this.cn[var6] == this.cM + 3) {
                  if (this.fp == 777) {
                     return false;
                  }

                  var9 = abs(this.E() % 21);
                  if (this.eE == 3) {
                     this.fp += 25 + var9;
                  } else {
                     this.fr += 25 + var9;
                  }

                  this.ge = true;
                  this.fi = this.ff;
               } else if (this.cn[var6] == this.cM + 4) {
                  if (this.fo == this.fv && this.selectedMap != 7 && this.selectedMap != 8 || this.fo == 200) {
                     return false;
                  }

                  var9 = abs(this.E() % 21);
                  if (this.fo < 100) {
                     this.fo += 25 + var9;
                     this.gf = true;
                     this.fj = this.ff;
                  }

                  if ((this.selectedMap == 7 || this.selectedMap == 8) && this.fo != 200) {
                     this.fo = 200;
                     this.fv = 200;
                     this.gf = true;
                     this.fj = this.ff;
                  }
               } else if (this.cn[var6] != this.cM + 5) {
                  if (this.cn[var6] == this.cM + 6) {
                     var9 = abs(this.E() % 2);
                     if (this.eE != 3) {
                        this.fq += 2 + var9;
                     } else {
                        this.fr += 2 + var9;
                     }

                     this.gg = true;
                     this.fk = this.ff;
                  }
               } else {
                  if (this.fp == 777 && (this.fo == this.fv && this.selectedMap != 7 && this.selectedMap != 8 || this.fo == 200)) {
                     return false;
                  }

                  if (this.fp == 777 && this.fo != this.fv) {
                     this.cn[var6] = (byte)(this.cM + 3);
                     var9 = abs(this.E() % 21);
                     this.cq[var6] = this.cn[var6];
                     if (this.fo < 100) {
                        this.fo += 25 + var9;
                        this.gf = true;
                        this.fj = this.ff;
                     }

                     if ((this.selectedMap == 7 || this.selectedMap == 8) && this.fo != 200) {
                        this.fo = 200;
                        this.fv = 200;
                        this.gf = true;
                        this.fj = this.ff;
                     }

                     if (this.fo > this.fv) {
                        this.fo = this.fv;
                     }

                     return false;
                  }

                  if (this.fp != 777 && (this.fo == this.fv && this.selectedMap != 7 && this.selectedMap != 8 || this.fo == 200)) {
                     this.cn[var6] = (byte)(this.cM + 4);
                     this.cq[var6] = this.cn[var6];
                     var9 = abs(this.E() % 21);
                     if (this.eE == 3) {
                        this.fp += 25 + var9;
                     } else {
                        this.fr += 25 + var9;
                     }

                     if (this.fp > 777) {
                        this.fp = 777;
                     }

                     this.ge = true;
                     this.fi = this.ff;
                     return false;
                  }

                  this.ge = true;
                  this.gf = true;
                  this.fi = this.ff;
                  this.fj = this.ff;
                  var9 = abs(this.E() % 21);
                  if (this.eE == 3) {
                     this.fp += 25 + var9;
                  } else {
                     this.fr += 25 + var9;
                  }

                  if (this.fo < 100) {
                     this.fo += 25;
                  } else {
                     this.gf = false;
                  }

                  if ((this.selectedMap == 7 || this.selectedMap == 8) && this.fo != 200) {
                     this.fo = 200;
                     this.fv = 200;
                  }
               }

               if (this.fr > 777) {
                  this.fr = 777;
               }

               if (this.fo > this.fv) {
                  this.fo = this.fv;
               }

               if (this.gf || this.ge || this.gg) {
                  this.cn[var6] = (byte)(this.cM + 2);
               }

               this.cq[var6] = this.cn[var6];
               return false;
            }

            if (this.cp[var6] == 1) {
               if (this.fr == 777) {
                  return false;
               }

               var9 = abs(this.E() % 11);
               if (this.eE == 3) {
                  this.fp += 10 + var9;
               } else {
                  this.fr += 10 + var9;
               }

               if (this.fr > 777) {
                  this.fr = 777;
               }

               this.ge = true;
               this.fi = this.ff;
            } else if (this.cp[var6] == 2) {
               if (this.fo == 100) {
                  return false;
               }

               var9 = abs(this.E() % 11);
               if (this.fo < 100) {
                  this.fo += 10 + var9;
                  this.gf = true;
                  this.fj = this.ff;
               }

               if (this.fo > this.fv) {
                  this.fo = this.fv;
               }
            } else if (this.cp[var6] == 3) {
               if (this.fr == 777) {
                  return false;
               }

               var9 = abs(this.E() % 2);
               if (this.eE != 3) {
                  this.fq += 1 + var9;
               } else {
                  this.fr += 1 + var9;
               }

               if (this.fr > 777) {
                  this.fr = 777;
               }

               this.gg = true;
               this.fk = this.ff;
            }

            this.cp[var6] = -1;
            return false;
         }
      }

      return false;
   }

   private void s(int var1) {
      this.dg = new int[4][var1];
      this.bv = new byte[var1];
   }

   private void loadTextures_subfunction2(int var1, int var2) {
      this.cS = new int[var1];
      this.cT = new int[var1];
      this.cU = new int[var1];
      this.cV = new int[var1];
      this.cW = new int[var2];
      this.cX = new int[var2];
      this.cY = new int[var2];
      this.cZ = new int[var2];
   }

   private void loadSprites_subfunction2(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.bm = new int[2][(13 + var3) * 50];
      this.bj = new int[50];
      this.di = new byte[var1];
      this.dj = new byte[var1];
      this.dk = new byte[var1];
      this.dl = new byte[var1];
      this.dm = new byte[var1];
      this.dn = new byte[var1];
      this.do_ = new byte[var2];
      this.dp = new byte[var2];
      this.dq = new byte[var4];
      this.dr = new byte[var4];
      this.ds = new byte[var5];
      this.dt = new byte[var5];
      this.du = new byte[var5];
      this.dv = new byte[var5];
      this.dw = new byte[var6];
      this.dx = new byte[var6];
      this.dy = new byte[var7];
      this.dz = new byte[var7];
      this.dA = new byte[var7];
      this.dB = new byte[var7];
      this.dC = new byte[var7];
      this.dD = new byte[var7];
      this.dE = new byte[var7];
      this.dF = new byte[var7];
   }

   private void m() {
      this.cQ = new long[this.fF];
      this.cR = new long[this.fF];
      this.de = new int[this.fF];
      this.df = new int[this.fF];
      this.dG = new byte[this.fF];
      this.bY = new long[this.cq.length];
      this.bZ = new long[this.cq.length];
      this.ca = new long[this.cq.length];
      this.cf = new int[this.cq.length];
      this.cd = new int[this.cq.length];
      this.bX = new long[this.cq.length];
   }

   private void n() {
      this.cQ = null;
      this.cR = null;
      System.gc();
      this.by = new short[7][3][3];
   }

   private void a(boolean var1) {
      this.b(var1);
      this.hM = null;
      this.hN = null;
      if (!this.hD) {
         this.hI = (int[][])null;
      }

      this.hJ = null;
      this.gt = null;
      this.gw = null;
      this.ei = (short[][])null;
      this.dY = null;
      this.eZ = (int[][])null;
      this.cS = null;
      this.cT = null;
      this.cU = null;
      this.cV = null;
      this.cW = null;
      this.cX = null;
      this.cY = null;
      this.cZ = null;
      this.da = null;
      this.db = null;
      this.dc = null;
      this.dd = null;
      this.di = null;
      this.dj = null;
      this.dk = null;
      this.dl = null;
      this.dm = null;
      this.dn = null;
      this.do_ = null;
      this.dp = null;
      this.dq = null;
      this.dr = null;
      this.ds = null;
      this.dt = null;
      this.du = null;
      this.dv = null;
      this.dw = null;
      this.dx = null;
      this.bm = (int[][])null;
      this.eg = null;
      this.de = null;
      this.df = null;
      this.dG = null;
      this.bY = null;
      this.bZ = null;
      this.cf = null;
      this.ca = null;
      this.cd = null;
      this.bX = null;
      this.by = (short[][][])null;
      if (!var1) {
         System.gc();
      }

   }

   private void b(boolean var1) {
      this.bk = null;
      this.bl = (int[][])null;
      this.bz = null;
      this.bu = null;
      if (!var1) {
         System.gc();
      }

   }

   private void c(boolean var1) {
      this.h = null;
      this.i = null;
      this.k = null;
      this.l = null;
      this.m = null;
      if (!this.hD) {
         this.o = null;
         this.hO = null;
         this.p = null;
         this.hP = null;
         this.q = null;
         this.r = null;
      }

      if (var1) {
         System.gc();
      }

   }

   private void o() {
      this.eh = (short[][])null;
      this.ej = null;
      this.el = null;
      this.ek = null;
      System.gc();
   }

   private void p() {
      int var2 = this.fJ;

      for(int var1 = 0; var1 < this.fH; ++var1) {
         if (this.dL[var1] == 1) {
            this.modifyBigLump1_subfunction3(this.dH[var1], (long)this.dN[var1], (long)this.dV, this.dJ[var1], this.dK[var1], var2, 0);
         } else {
            this.modifyBigLump1_subfunction3(this.dH[var1], (long)this.dN[var1], (long)this.dP[var1], this.dJ[var1], this.dK[var1], var2, 0);
         }

         this.a((short)((short)var2), (short)((short)(var2 + 3)), 1);
         var2 += 3;
      }

   }

   private int modifyBigLump1_subfunction3(int[] var1, long var2, long var4, int var6, int var7, int var8, int var9) {
      char var10 = 0;
      if (this.selectedMap == 1 || this.selectedMap == 2) {
         var10 = '耀';
      }

      if (var9 == 0) {
         this.dg[var6][var8] = var1[var6] + var10;
         this.dg[var7][var8] = (int)((long)var1[var7] - (var2 >> 1));
         this.dg[var6 + 2][var8] = (int)((long)var1[var6] + var4 + (long)var10);
         this.dg[var7 + 2][var8] = (int)((long)var1[var7] - (var2 >> 1));
      }

      int var11 = var8 + 1;
      this.dg[var6][var11] = this.dg[var6 + 2][var11 - 1];
      this.dg[var7][var11] = this.dg[var7 + 2][var11 - 1];
      this.dg[var6 + 2][var11] = this.dg[var6][var11];
      this.dg[var7 + 2][var11] = (int)((long)this.dg[var7][var11 - 1] + var2);
      ++var11;
      if (var9 == 0) {
         this.dg[var6][var11] = this.dg[var6 + 2][var11 - 1];
         this.dg[var7][var11] = this.dg[var7 + 2][var11 - 1];
         this.dg[var6 + 2][var11] = (int)((long)this.dg[var6][var11] - var4);
         this.dg[var7 + 2][var11] = this.dg[var7][var11];
      }

      return var11 + 1;
   }

   private void d(boolean var1) {
      int var4 = this.fJ;

      for(int var2 = 0; var2 < this.fH; ++var2) {
         label79: {
            byte var10000;
            if (this.dL[var2] == 8) {
               if (!var1) {
                  break label79;
               }

               var10000 = 12;
            } else {
               if (var1) {
                  break label79;
               }

               var10000 = 30;
            }

            byte var3 = var10000;
            if (this.dL[var2] != -1) {
               if (this.dL[var2] == 1) {
                  if (this.dU && this.dT[var2] != -1) {
                     label53: {
                        this.e(-1, var2);
                        this.modifyBigLump1_subfunction3(this.dH[var2], (long)this.dN[var2], (long)this.dW, this.dJ[var2], this.dK[var2], var4, 0);
                        this.a((short)((short)var4), (short)((short)(var4 + 3)), 1);
                        this.dL[var2] = -1;
                        this.dU = false;
                        this.dT[var2] = -1;
                        l3d_d var6;
                        byte var7;
                        long var8;
                        long var10003;
                        short var10004;
                        if (var2 == 5) {
                           var6 = this;
                           var7 = 0;
                           var8 = 2957768L;
                           var10003 = 1532768L;
                           var10004 = 180;
                        } else if (var2 == 8) {
                           var6 = this;
                           var7 = 1;
                           var8 = 1607768L;
                           var10003 = 1832768L;
                           var10004 = 180;
                        } else if (var2 == 10) {
                           var6 = this;
                           var7 = 1;
                           var8 = 1167232L;
                           var10003 = 1457768L;
                           var10004 = -90;
                        } else {
                           if (var2 != 11) {
                              break label53;
                           }

                           var6 = this;
                           var7 = 1;
                           var8 = 2057768L;
                           var10003 = 1457768L;
                           var10004 = 90;
                        }

                        var6.initStartingPos(var7, var8, var10003, var10004, 7);
                     }

                     this.ex = true;
                  }

                  var4 += 3;
                  continue;
               }

               if (this.dT[var2] == -1) {
                  this.bw[var4 + 1] = 1;
               } else if (this.dT[var2] < this.dL[var2]) {
                  this.dU = true;
                  this.bw[var4 + 1] = 0;
                  this.e(-1, var2);
                  this.modifyBigLump1_subfunction3(this.dH[var2], (long)this.dN[var2], (long)this.dP[var2], this.dJ[var2], this.dK[var2], var4, 0);
                  this.a((short)((short)var4), (short)((short)(var4 + 3)), 1);
               } else {
                  label91: {
                     int[] var5;
                     int var10001;
                     int var10002;
                     if (this.dT[var2] < var3) {
                        var5 = this.dT;
                        var10001 = var2;
                        var10002 = var5[var2] + 1;
                     } else if (this.dT[var2] < var3 + this.dL[var2]) {
                        if (a(this.gn[0] - ((long)this.dI[var2][0] * 75000L >> 16)) >= 75000L || a(this.gn[1] - ((long)this.dI[var2][1] * 75000L >> 16)) >= 75000L) {
                           this.e(1, var2);
                           this.modifyBigLump1_subfunction3(this.dH[var2], (long)this.dN[var2], (long)this.dP[var2], this.dJ[var2], this.dK[var2], var4, 0);
                           this.a((short)((short)var4), (short)((short)(var4 + 3)), 1);
                           break label91;
                        }

                        var5 = this.dT;
                        var10001 = var2;
                        var10002 = this.dL[var2] - (this.dT[var2] - var3);
                     } else {
                        this.dU = false;
                        var5 = this.dT;
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
      int[] var10000;
      int var10001;
      long var10002;
      int var10003;
      int var10004;
      if (this.dL[var2] == 1) {
         var10000 = this.dP;
         var10000[var2] += var1 * this.dX;
         this.dR[var2] = (int)((long)this.dR[var2] - (long)(var1 * abs(this.dX)) * 96L);
         var10000 = this.dS;
         var10001 = var2;
         var10002 = (long)this.dS[var2];
         var10003 = var1;
         var10004 = this.dX;
      } else {
         var10000 = this.dP;
         var10000[var2] += var1 * this.dQ[var2];
         this.dR[var2] = (int)((long)this.dR[var2] - (long)(var1 * abs(this.dQ[var2])) * 96L);
         var10000 = this.dS;
         var10001 = var2;
         var10002 = (long)this.dS[var2];
         var10003 = var1;
         var10004 = this.dQ[var2];
      }

      var10000[var10001] = (int)(var10002 + (long)(var10003 * abs(var10004)) * 96L);
      int var3 = this.dT[var2]++;
   }

   private void q() {
      boolean var1 = this.dU;

      for(int var2 = 0; var2 < this.fH; ++var2) {
         if (a(this.gn[0] - ((long)this.dI[var2][0] * 75000L >> 16)) < 75000L && a(this.gn[1] - ((long)this.dI[var2][1] * 75000L >> 16)) < 75000L) {
            if (var2 == this.fA) {
               label105: {
                  ++this.selectedMap;
                  l3d_d var10000;
                  byte var10001;
                  if (this.selectedMap != 4 && this.selectedMap != 9) {
                     if (this.selectedMap != 1) {
                        break label105;
                     }

                     var10000 = this;
                     var10001 = 2;
                  } else {
                     var10000 = this;
                     var10001 = 3;
                  }

                  var10000.fS = var10001;
               }

               this.gE = 0;
               if (this.selectedMap != 10) {
                  if (this.ih < this.selectedMap) {
                     this.ih = this.selectedMap;
                  }

                  this.id[this.selectedMap - 1] = this.eE;
                  this.ie[this.selectedMap - 1] = this.fo;
                  this.if[this.selectedMap - 1] = this.fp;
                  this.ig[this.selectedMap - 1] = this.fq;

                  try {
                     if (this.hV != null) {
                        this.hV.stop();
                     }
                  } catch (Exception var6) {
                  }

                  this.aa();
               }

               if (this.selectedMap < 10) {
                  this.gk = true;
                  this.gc = true;
                  this.fw = this.eE;
                  this.fs = this.fo;
                  this.ft = this.fp;
                  this.fu = this.fq;
                  this.u();
                  this.cv[13] = false;
                  this.cv[14] = false;
                  return;
               }

               this.gl = true;

               try {
                  if (this.hV != null) {
                     this.hV.stop();
                  }
               } catch (Exception var5) {
               }

               this.ih = 10;
               this.aa();
               this.Y();
               return;
            }

            if (this.dT[var2] == -1 && this.dL[var2] != -1 && (this.fU == this.dM[var2] || !this.dU)) {
               var1 = true;
               this.dT[var2] = 0;
               if (this.fU != this.dM[var2]) {
                  this.dY = null;
                  System.gc();
                  this.fU = this.dM[var2];
                  this.dY = new c(this, this.ei[this.fU][0], (a)null);
                  int var3 = this.ei[this.fU].length;

                  for(int var4 = 1; var4 < var3; ++var4) {
                     c.a(this.dY, this.ei[this.fU][var4]);
                  }
               }
            }
         }
      }

      this.dU = var1;
   }

   private void initCosTable() {
      this.eg = new int[91];
      this.eg[1] = 1146;
      int var1 = 1146;

      for(int var2 = 2; var2 <= 90; ++var2) {
         var1 += this.a[var2 - 2];
         this.eg[var2] = this.eg[var2 - 1] + var1;
      }

      this.a = null;
   }

   private long cos(int var1) {
      if (var1 < 0) {
         return -this.cos(-var1);
      } else if (var1 >= 90 & var1 < 180) {
         return (long)this.eg[180 - var1];
      } else if (var1 >= 180 & var1 < 270) {
         return (long)(-this.eg[var1 - 180]);
      } else if (var1 >= 270 & var1 < 360) {
         return (long)(-this.eg[90 - (var1 - 270)]);
      } else {
         return var1 >= 360 ? this.cos(var1 % 360) : (long)this.eg[var1];
      }
   }

   private long sin(int var1) {
      return this.cos(90 - var1);
   }

   private static int abs(int var0) {
      return var0 > 0 ? var0 : -var0;
   }

   private static long a(long var0) {
      return var0 > 0L ? var0 : -var0;
   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.dZ = (long)var1 * (17000L * this.cos(this.dG[var6]) >> 16) + ((long)this.dg[1][var6] * 75000L >> 16);
      this.ea = (long)var2 * (17000L * this.sin(90 - this.dG[var6]) >> 16) + ((long)this.dg[0][var6] * 75000L >> 16);
      this.ec = (long)var3 * (17000L * this.sin(90 + this.dG[var6]) >> 16) + ((long)this.dg[2][var6] * 75000L >> 16);
      this.eb = (long)var4 * (17000L * this.cos(90 - this.dG[var6]) >> 16) + ((long)this.dg[1][var6] * 75000L >> 16);
      this.ed = (long)var5 * (17000L * this.cos(90 + this.dG[var6]) >> 16) + ((long)this.dg[3][var6] * 75000L >> 16);
   }

   private void a(short var1, short var2, int var3) {
      short var10000 = var1;

      while(true) {
         short var14 = var10000;
         if (var10000 >= var2) {
            return;
         }

         long var10 = (long)(this.dg[1][var14] - this.dg[3][var14]);
         long var12 = (long)(this.dg[2][var14] - this.dg[0][var14]);
         this.de[var14] = (int)(-(var10 * (long)this.dg[0][var14] >> 16) - (var12 * (long)this.dg[1][var14] >> 16));
         byte var10002;
         if (var3 == 0 || var3 == 2) {
            label63: {
               byte[] var16;
               short var10001;
               if (var10 == 0L) {
                  var16 = this.dG;
                  var10001 = var14;
                  var10002 = -90;
               } else {
                  long var4;
                  long var6 = (var4 = (var12 << 16) / var10) < 0L ? -var4 : var4;
                  this.dG[var14] = 0;
                  if (var6 > 3746989L) {
                     var16 = this.dG;
                     var10001 = var14;
                     var10002 = 89;
                  } else {
                     byte var17 = this.dG[var14];

                     while(true) {
                        byte var15 = var17;
                        if ((this.cos(var15) << 16) / this.cos(90 - var15) >= var6) {
                           var16 = this.dG;
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

                  var16 = this.dG;
                  var10001 = var14;
                  var10002 = (byte)(-this.dG[var14]);
               }

               var16[var10001] = var10002;
            }

            if (var3 == 0) {
               this.cQ[var14] = var10;
               this.cR[var14] = var12;
            }
         }

         long var8;
         l3d_d var18;
         byte var19;
         byte var10003;
         byte var10004;
         byte var10005;
         if (this.dg[1][var14] <= this.dg[3][var14]) {
            var8 = (17000L * this.sin(this.dG[var14]) >> 16) + ((long)this.dg[0][var14] * 75000L >> 16);
            if (this.dG[var14] != -90) {
               var18 = this;
               var19 = 1;
               var10002 = 1;
               var10003 = 1;
               var10004 = -1;
               var10005 = 1;
            } else if (this.dg[0][var14] < this.dg[2][var14]) {
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
            var8 = -(17000L * this.sin(this.dG[var14]) >> 16) + ((long)this.dg[0][var14] * 75000L >> 16);
            var18 = this;
            var19 = -1;
            var10002 = -1;
            var10003 = -1;
            var10004 = 1;
            var10005 = -1;
         }

         var18.a(var19, var10002, var10003, var10004, var10005, var14);
         this.df[var14] = (int)(-(var10 * var8 >> 16) - (var12 * this.dZ >> 16));
         this.cF = var12;
         this.cG = -var10;
         this.cH = -var12;
         this.cI = var10;
         this.cJ = (long)((int)(-(var12 * this.ea >> 16) + (var10 * this.eb >> 16)));
         this.cK = (long)((int)((var12 * this.ec >> 16) - (var10 * this.ed >> 16)));
         if (((var12 * (long)this.dg[0][var14] >> 16) * 75000L >> 16) + ((-var10 * (long)this.dg[1][var14] >> 16) * 75000L >> 16) + this.cJ >= 0L) {
            this.cF = -var12;
            this.cG = var10;
            this.cH = var12;
            this.cI = -var10;
            this.cJ = -this.cJ;
            this.cK = -this.cK;
         }

         var10000 = (short)(var14 + 1);
      }
   }

   private void s() {
      this.a((short)0, (short)((short)this.fF), 0);
   }

   private void w(int var1) {
      this.eh = new short[this.fF][];
      this.ej = new short[this.fF];
      int var14 = this.cN[var1].length;
      short var10000 = 0;

      while(true) {
         short var16 = var10000;
         if (var10000 >= var14) {
            return;
         }

         short var19 = this.cN[var1][var16];
         short var20 = this.cO[var1][var16];
         var10000 = var19;

         while(true) {
            short var15 = var10000;
            if (var10000 > var20) {
               var10000 = (short)(var16 + 1);
               break;
            }

            this.eh[var15] = new short[70];
            long var6 = (long)this.dg[0][var15];
            long var8 = (long)this.dg[1][var15];
            long var10 = (long)this.dg[2][var15];
            long var12 = (long)this.dg[3][var15];
            short var23 = 0;
            var10000 = 0;

            while(true) {
               short var18 = var10000;
               if (var10000 >= var14) {
                  var10000 = (short)(var15 + 1);
                  break;
               }

               short var21 = this.cN[var1][var18];
               short var22 = this.cO[var1][var18];
               var10000 = var21;

               while(true) {
                  short var17 = var10000;
                  if (var10000 > var22) {
                     this.ej[var15] = var23;
                     var10000 = (short)(var18 + 1);
                     break;
                  }

                  long var2 = (this.cQ[var17] * var6 >> 16) + (this.cR[var17] * var8 >> 16) + (long)this.de[var17];
                  long var4 = (this.cQ[var17] * var10 >> 16) + (this.cR[var17] * var12 >> 16) + (long)this.de[var17];
                  if (var2 * var4 < 0L) {
                     this.eh[var15][var23] = var17;
                     ++var23;
                  }

                  var10000 = (short)(var17 + 1);
               }
            }
         }
      }
   }

   private void x(int var1) {
      this.el = new boolean[this.fF];
      this.ek = new short[this.fF];
      int var2 = this.cN[var1].length;
      short var10000 = 0;

      while(true) {
         short var5 = var10000;
         if (var10000 >= var2) {
            return;
         }

         short var3 = this.cN[var1][var5];
         short var4 = this.cO[var1][var5];
         var10000 = var3;

         while(true) {
            short var6 = var10000;
            if (var10000 > var4) {
               var10000 = (short)(var5 + 1);
               break;
            }

            if (!this.el[var6]) {
               this.a(var6, var1);
            }

            var10000 = (short)(var6 + 1);
         }
      }
   }

   private void a(short var1, int var2) {
      int var3 = this.cN[var2].length;
      short var10000 = 0;

      while(true) {
         short var7 = var10000;
         if (var10000 >= var3) {
            this.ek[this.ef] = var1;
            this.el[var1] = true;
            ++this.ef;
            return;
         }

         short var4 = this.cN[var2][var7];
         short var5 = this.cO[var2][var7];
         var10000 = var4;

         while(true) {
            short var8 = var10000;
            if (var10000 > var5) {
               var10000 = (short)(var7 + 1);
               break;
            }

            if (!this.el[var8]) {
               short var6 = this.ej[var8];

               for(int var9 = 0; var9 < var6; ++var9) {
                  if (this.eh[var8][var9] == var1) {
                     this.a(var8, var2);
                  }
               }
            }

            var10000 = (short)(var8 + 1);
         }
      }
   }

   private void y(int var1) {
      this.ef = 0;
      this.w(var1);
      this.x(var1);
      int var2 = 0;
      short var10000 = 0;

      while(true) {
         short var4 = var10000;
         short var3;
         if (var10000 >= this.cN[var1].length) {
            this.ei[var1] = new short[var2];
            var10000 = 0;

            while(true) {
               var3 = var10000;
               if (var10000 >= var2) {
                  return;
               }

               this.ei[var1][var3] = this.ek[var3];
               var10000 = (short)(var3 + 1);
            }
         }

         var10000 = this.cN[var1][var4];

         while(true) {
            var3 = var10000;
            if (var10000 > this.cO[var1][var4]) {
               var10000 = (short)(var4 + 1);
               break;
            }

            ++var2;
            var10000 = (short)(var3 + 1);
         }
      }
   }

   private void f(int var1, int var2) {
      this.ew = false;
      this.eu = (int)(a((long)this.cb[var1][0] - this.fm) >> 16);
      this.ev = (int)(a((long)this.cb[var1][1] - this.fn) >> 16);
      if (this.eu <= var2 && this.ev <= var2) {
         this.en = (long)this.cb[var1][0] * 75000L >> 16;
         this.eo = (long)this.cb[var1][1] * 75000L >> 16;
         this.ep = this.gn[1] - this.eo;
         this.eq = this.en - this.gn[0];
         this.er = -(this.ep * this.gn[0] >> 16) - (this.eq * this.gn[1] >> 16);
         this.es = this.ep * 75000L >> 16;
         this.et = this.eq * 75000L >> 16;
         int var3 = this.cN[this.fU].length;
         short var10000 = 0;

         while(true) {
            short var4 = var10000;
            if (var10000 >= var3) {
               this.ew = true;
               break;
            }

            short var5 = this.cN[this.fU][var4];
            short var6 = this.cO[this.fU][var4];
            var10000 = var5;

            while(true) {
               short var7 = var10000;
               if (var10000 > var6) {
                  var10000 = (short)(var4 + 1);
                  break;
               }

               if (this.bv[var7] != 1 && !this.z(var7)) {
                  this.ew = false;
                  return;
               }

               var10000 = (short)(var7 + 1);
            }
         }
      }

   }

   private boolean z(int var1) {
      long var2 = (this.es * (long)this.dg[0][var1] >> 16) + (this.et * (long)this.dg[1][var1] >> 16) + this.er;
      long var4 = (this.es * (long)this.dg[2][var1] >> 16) + (this.et * (long)this.dg[3][var1] >> 16) + this.er;
      if (var2 * var4 < 0L) {
         long var6 = (long)(this.dg[1][var1] - this.dg[3][var1]);
         long var8 = (long)(this.dg[2][var1] - this.dg[0][var1]);
         var2 = (var6 * this.gn[0] >> 16) + (var8 * this.gn[1] >> 16) + ((long)this.de[var1] * 75000L >> 16);
         var4 = (var6 * this.en >> 16) + (var8 * this.eo >> 16) + ((long)this.de[var1] * 75000L >> 16);
         if (var2 * var4 < 0L) {
            return false;
         }
      }

      return true;
   }

   private void A(int var1) {
      for(int var4 = 0; var4 < this.fx; ++var4) {
         if (!this.cv[var4]) {
            byte[] var5;
            byte var6;
            int var10001;
            if ((this.cq[var4] == 9 || this.cq[var4] == 10) && this.ck[var4] <= 0) {
               var5 = this.cq;
               var10001 = var4;
               var6 = 8;
            } else {
               l3d_d var10000;
               int var10002;
               if (this.ck[var4] > 0 && this.ck[var4] != 41) {
                  var10000 = this;
                  var10001 = var4;
                  var10002 = 0;
               } else if (this.ck[var4] != 41) {
                  var10000 = this;
                  var10001 = var4;
                  var10002 = 2;
               } else {
                  var10000 = this;
                  var10001 = var4;
                  var10002 = 1;
               }

               var10000.f(var10001, var10002);
               int[] var9;
               if ((this.selectedMap == 5 || this.selectedMap == 8) && this.ck[var4] == 41) {
                  if (this.cq[var4] < 41) {
                     this.cq[var4] = 41;
                  }

                  if (this.ew) {
                     if (this.cq[var4] != 45) {
                        byte var10003;
                        if (this.eX[var4] != 1) {
                           ++this.cq[var4];
                           var9 = this.eX;
                           var10001 = var4;
                           var10002 = var9[var4];
                           var10003 = 1;
                        } else {
                           --this.cq[var4];
                           var9 = this.eX;
                           var10001 = var4;
                           var10002 = var9[var4];
                           var10003 = 9;
                        }

                        var9[var10001] = var10002 + var10003;
                        this.eS = true;
                     } else {
                        this.cq[var4] = 41;
                        this.eX[var4] = -1;
                     }
                     continue;
                  }

                  var5 = this.cq;
                  var10001 = var4;
                  var6 = 41;
               } else if ((this.selectedMap == 7 || this.selectedMap == 8) && this.ck[var4] == 37) {
                  if (this.cq[var4] == 37) {
                     var5 = this.cq;
                     var10001 = var4;
                     var6 = 38;
                  } else {
                     var5 = this.cq;
                     var10001 = var4;
                     var6 = 37;
                  }
               } else if (this.ck[var4] > 0) {
                  if (this.ew) {
                     var5 = this.cq;
                     var10001 = var4;
                     var6 = (byte)(this.ck[var4] + 1);
                  } else {
                     if (this.cq[var4] == (byte)(this.ck[var4] + 1)) {
                        continue;
                     }

                     var5 = this.cq;
                     var10001 = var4;
                     var6 = this.ck[var4];
                  }
               } else {
                  if (this.ew) {
                     int var3 = this.E();
                     int var2 = this.eu + this.ev;
                     if (var3 % 1 == 0 || this.cq[var4] == 8 && this.cj[var4] != -1 || this.cu[var4]) {
                        this.cq[var4] = 8;
                        this.cu[var4] = true;
                        if (this.E() % 2 == 0) {
                           this.cq[var4] = 9;
                           if (this.E() % 2 == 0) {
                              this.fo -= this.eA[var2] * this.gb;
                              if (this.fo < 100) {
                                 this.fv = 100;
                              }

                              if (this.fo <= 0 && !this.ez) {
                                 this.fo = 0;
                                 this.gL = true;
                                 this.F();
                                 this.fo = this.fs;
                                 if (this.fo > 100) {
                                    this.fv = 200;
                                 }

                                 this.fp = this.ft;
                                 this.fq = this.fu;
                                 this.eE = this.fw;
                                 if (this.eE == 3) {
                                    var10000 = this;
                                    var10001 = this.fq;
                                 } else {
                                    var10000 = this;
                                    var10001 = this.fp;
                                 }

                                 var10000.fr = var10001;
                                 if (this.fr > 0) {
                                    this.eU = true;
                                 }

                                 this.eH = 0;
                                 return;
                              }
                           }
                        }
                        continue;
                     }
                  } else {
                     this.cu[var4] = false;
                  }

                  if (var1 != 1) {
                     continue;
                  }

                  if (this.cj[var4] == -1) {
                     var5 = this.cq;
                     var10001 = var4;
                     var6 = 8;
                  } else {
                     if (this.cq[var4] >= 8) {
                        this.cq[var4] = 0;
                     }

                     boolean[] var7;
                     boolean var8;
                     if (this.ct[var4]) {
                        var7 = this.ct;
                        var10001 = var4;
                        var8 = false;
                     } else {
                        var7 = this.ct;
                        var10001 = var4;
                        var8 = true;
                     }

                     var7[var10001] = var8;
                     if (this.cm[var4] == 1) {
                        if (this.cl[var4] < this.cj[var4]) {
                           var9 = this.cb[var4];
                           var9[0] = (int)((long)var9[0] - (7498L * this.cos(this.cg[var4]) >> 16));
                           var9 = this.cb[var4];
                           var9[1] = (int)((long)var9[1] + (7498L * this.sin(this.cg[var4]) >> 16));
                           var5 = this.cl;
                           var10001 = var4;
                           var6 = (byte)(var5[var4] + 1);
                        } else if (this.cl[var4] == this.cj[var4]) {
                           this.cq[var4] = 8;
                           var5 = this.cl;
                           var10001 = var4;
                           var6 = (byte)(var5[var4] + 1);
                        } else {
                           this.cl[var4] = 1;
                           var5 = this.cm;
                           var10001 = var4;
                           var6 = 2;
                        }
                     } else if (this.cl[var4] < this.cj[var4]) {
                        var9 = this.cb[var4];
                        var9[0] = (int)((long)var9[0] + (7498L * this.cos(this.cg[var4]) >> 16));
                        var9 = this.cb[var4];
                        var9[1] = (int)((long)var9[1] - (7498L * this.sin(this.cg[var4]) >> 16));
                        var5 = this.cl;
                        var10001 = var4;
                        var6 = (byte)(var5[var4] + 1);
                     } else if (this.cl[var4] == this.cj[var4]) {
                        this.cq[var4] = 8;
                        var5 = this.cl;
                        var10001 = var4;
                        var6 = (byte)(var5[var4] + 1);
                     } else {
                        this.cl[var4] = 1;
                        var5 = this.cm;
                        var10001 = var4;
                        var6 = 1;
                     }
                  }
               }
            }

            var5[var10001] = var6;
         }
      }

   }

   private void t() {
      this.eA = new int[5];
      this.eA[0] = 10;
      this.eA[1] = 6;
      this.eA[2] = 4;
      this.eA[3] = 2;
      this.eA[4] = 2;
   }

   private void c(Graphics var1) {
      var1.setColor(85, 0, 0);
      var1.drawRect(this.f[this.eF], -1, 55, 41);
      var1.setColor(175, 0, 0);
      var1.drawRect(this.f[this.eE], -1, 55, 41);
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
         if (var2[var8] == this.N) {
            var2[var8] = 0;
         }
      }

   }

   private void a(int var1, int var2, int var3, int var4, Graphics var5) {
      if (this.eY[var2] > var4 || var2 == 2) {
         label78: {
            l3d_d var10000;
            short var10001;
            if (this.eE == 1) {
               this.fc = 217 + abs(this.E()) % 15;
               var10000 = this;
               var10001 = 200;
            } else {
               if (this.eE != 0) {
                  break label78;
               }

               if (this.eR) {
                  var10000 = this;
                  var10001 = 215;
               } else {
                  var10000 = this;
                  var10001 = 0;
               }

               var10000.fc = var10001 + abs(this.E()) % 17;
               var10000 = this;
               var10001 = 205;
            }

            var10000.fd = var10001 - abs(this.E()) % 7;
            this.fe = abs(this.E()) % 3 + 6;
         }

         if (var1 == 0) {
            var5.drawRGB(this.eZ[var2], 0, this.eW[var2], 240 - this.eW[var2], 266 - this.eY[var2] + var4, this.eW[var2], this.eY[var2] - var4, true);
            var5.drawRGB(this.eZ[var3 + 2], 0, this.eW[var3], 0, 266 - this.eY[var3] + var4, this.eW[var3], this.eY[var3] - var4, true);
            if (var2 != 0 || var3 != 0) {
               var5.drawRGB(this.eZ[this.fe], 0, this.eW[6], this.fc, this.fd, this.eW[6], this.eY[6], true);
               return;
            }
         } else {
            if (var1 == 1) {
               if (var2 == 0) {
                  var5.drawRGB(this.eZ[var2], 0, this.eW[var2], 240 - this.eW[var2], 266 - this.eY[var2] + var4, this.eW[var2], this.eY[var2] - var4, true);
                  return;
               }

               var5.drawRGB(this.eZ[var2], 0, this.eW[var2], 240 - this.eW[var2], 266 - this.eY[var2] + var4, this.eW[var2], this.eY[var2] - var4, true);
               var5.drawRGB(this.eZ[this.fe], 0, this.eW[6], this.fc, this.fd, this.eW[6], this.eY[6], true);
               return;
            }

            if (var1 == 2) {
               if (var2 == 0) {
                  if (this.eH != 0 && this.ff - this.gR <= 500L) {
                     var5.drawRGB(this.eZ[4], 0, this.eW[4], 240 - this.eW[4], 266 - this.eY[4] + var4, this.eW[4], this.eY[4] - var4, true);
                     return;
                  }

                  var5.drawRGB(this.eZ[var2], 0, this.eW[var2], 240 - this.eW[var2], 266 - this.eY[var2] + var4, this.eW[var2], this.eY[var2] - var4, true);
                  return;
               }

               if (this.ff - this.gR > 500L) {
                  var5.drawRGB(this.eZ[var2], 0, this.eW[var2], 240 - this.eW[var2], 266 - this.eY[var2] + var4, this.eW[var2], this.eY[var2] - var4, true);
                  return;
               }

               var5.drawRGB(this.eZ[4], 0, this.eW[4], 240 - this.eW[4], 266 - this.eY[4] + var4, this.eW[4], this.eY[4] - var4, true);
               return;
            }

            if (var1 == 3) {
               if (var2 == 0) {
                  var5.drawRGB(this.eZ[var2], 0, this.eW[var2], 240 - this.eW[var2], 266 - this.eY[var2] + var4, this.eW[var2], this.eY[var2] - var4, true);
                  return;
               }

               if (var2 == 1) {
                  var5.drawRGB(this.eZ[var2], 0, this.eW[var2], 240 - this.eW[var2], 266 - this.eY[var2] - 34 + var4, this.eW[var2], this.eY[var2] - var4, true);
                  var5.drawRGB(this.eZ[0], 0, this.eW[0], 240 - this.eW[0] + 15, 266 - this.eY[0] + var4, this.eW[0] - 15, this.eY[0] - var4, true);
                  this.eH = 2;
                  this.gK = false;
                  this.eV = true;
                  return;
               }

               Graphics var6;
               int[] var7;
               byte var10002;
               int var10003;
               int var10004;
               int var10005;
               int var10006;
               if (var4 == 0) {
                  var5.drawRGB(this.eZ[2], 0, this.eW[2], 240 - this.eW[2], 266 - this.eY[2] - 25 + var4, this.eW[2], this.eY[2] - var4, true);
                  var6 = var5;
                  var7 = this.eZ[0];
                  var10002 = 0;
                  var10003 = this.eW[0];
                  var10004 = 240 - this.eW[0] + 15;
                  var10005 = 266 - this.eY[0] + var4;
                  var10006 = this.eW[0] - 15;
               } else {
                  var6 = var5;
                  var7 = this.eZ[0];
                  var10002 = 0;
                  var10003 = this.eW[0];
                  var10004 = 240 - this.eW[0];
                  var10005 = 266 - this.eY[0] + var4;
                  var10006 = this.eW[0];
               }

               var6.drawRGB(var7, var10002, var10003, var10004, var10005, var10006, this.eY[0] - var4, true);
               this.an = -1;
            }
         }

      }
   }

   private void u() {
      Image var1 = this.readImage("/ff" + this.dataExt);
      this.fa = new int[4][];
      this.fa[0] = new int[7080];
      var1.getRGB(this.fa[0], 0, 120, 0, 188, 120, 59);
      this.fa[1] = new int[8280];
      var1.getRGB(this.fa[1], 0, 120, 0, 119, 120, 69);
      this.fa[2] = new int[7080];
      var1.getRGB(this.fa[2], 0, 120, 0, 60, 120, 59);
      this.fa[3] = new int[7200];
      var1.getRGB(this.fa[3], 0, 120, 0, 0, 120, 60);
   }

   private void a(int var1, Graphics var2) {
      for(int var4 = 0; var4 < 4; ++var4) {
         int var3 = this.fa[var4].length;

         for(int var5 = 0; var5 < var3; ++var5) {
            if (this.fa[var4][var5] == this.N) {
               this.fa[var4][var5] = 0;
            }
         }
      }

      Graphics var10000;
      int[] var10001;
      byte var10002;
      byte var10003;
      byte var10004;
      int var10005;
      byte var10006;
      byte var10007;
      if (var1 == 0) {
         var2.drawRGB(this.fa[0], 0, 120, 0, 207 + this.eC, 120, 59 - this.eC, true);
         var10000 = var2;
         var10001 = this.fa[1];
         var10002 = 0;
         var10003 = 120;
         var10004 = 120;
         var10005 = 197 + this.eC;
         var10006 = 120;
         var10007 = 69;
      } else {
         label32: {
            int[][] var6;
            if (var1 == 1) {
               var2.drawRGB(this.fa[1], 0, 120, 0, 197 + this.eC, 120, 69 - this.eC, true);
               var10000 = var2;
               var6 = this.fa;
               var10002 = 2;
            } else {
               if (var1 == 2) {
                  var2.drawRGB(this.fa[2], 0, 120, 0, 207 + this.eC, 120, 59 - this.eC, true);
                  var10000 = var2;
                  var10001 = this.fa[3];
                  var10002 = 0;
                  var10003 = 120;
                  var10004 = 120;
                  var10005 = 206 + this.eC;
                  var10006 = 120;
                  var10007 = 60;
                  break label32;
               }

               if (var1 != 3) {
                  return;
               }

               var2.drawRGB(this.fa[3], 0, 120, 0, 206 + this.eC, 120, 60 - this.eC, true);
               var10000 = var2;
               var6 = this.fa;
               var10002 = 0;
            }

            var10001 = var6[var10002];
            var10002 = 0;
            var10003 = 120;
            var10004 = 120;
            var10005 = 207 + this.eC;
            var10006 = 120;
            var10007 = 59;
         }
      }

      var10000.drawRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007 - this.eC, true);
   }

   private void v() {
      if ((this.eL == 53 && this.eH == 1 || this.ao != -1) && (this.eU || this.eV)) {
         if (this.gj) {
            this.a(100);
         }

         int var1;
         boolean var2;
         if (this.bP > this.bQ && this.an != -1) {
            var1 = this.bQ;
            var2 = false;
         } else {
            var1 = this.bP;
            var2 = true;
            this.bA = this.bC;
            this.bB = this.bD;
         }

         l3d_d var10000;
         int var10001;
         if (var1 <= 3 - this.eE) {
            var10000 = this;
            var10001 = 0;
         } else {
            var10000 = this;
            var10001 = abs(this.E() % (var1 << 1));
         }

         var10000.bT = var10001;
         if (this.bT <= 2 - this.eE || this.eE == 3 || !this.eT || (this.an < this.fI || this.an > this.fJ) && !var2) {
            if (this.bU != -1 && this.ao == -1 && var2 && this.eE != 3 && !this.eV) {
               this.e(var2);
            } else if ((this.an != -1 || this.ao != -1) && (this.eE != 3 && this.fr > 0 || !this.eT)) {
               this.w();
            }

            if (this.eE == 3 && this.eT && !this.eV && this.ao == -1) {
               this.e(var2);
               if (this.an >= this.fL && this.an <= this.fL + 72 && this.selectedMap != 6) {
                  this.w();
               }

               if (this.selectedMap == 4 && this.eE == 3 && (this.an == 19 || this.an == 20 || this.an == 21 || this.an == 25 || this.an == 26 || this.an == 27 || this.an == 33 || this.an == 34 || this.an == 35 || this.an == 45 || this.an == 53 || this.an == 71 || this.an == 75 || this.an == 83 || this.an == 91)) {
                  this.dh[this.an] = 3;
                  this.gu[this.fR] = (short)this.an;
                  ++this.fR;
               }

               for(int var3 = this.fI; var3 < this.fJ; var3 += 4) {
                  long var4 = a((long)this.dg[0][var3] - this.bA);
                  long var6 = a((long)this.dg[1][var3] - this.bB);
                  if (var4 <= 98304L && var6 <= 98304L) {
                     this.an = var3;
                     this.w();
                  }
               }

               this.eU = false;
               this.eH = 1;
               this.gX = this.ff;
            }
         }

         this.ao = -1;
         this.eT = true;
      }

      this.an = -1;
      this.bU = -1;
   }

   private void w() {
      if (this.ao != -1) {
         this.an = this.ao;
      }

      if (this.an != -1 && (this.ff - this.gR >= 500L || this.eE != 2)) {
         byte[] var10000;
         int var1;
         int var2;
         int var3;
         if (this.an >= this.fL && this.an <= this.fL + 72 && this.selectedMap != 6) {
            for(var2 = var1 = this.an - (this.an - this.fL) % 12; var2 < var1 + 12; ++var2) {
               this.bw[var2] = 1;
            }

            this.cb[64][0] = (int)this.bE;
            this.cb[64][1] = (int)this.bF;
            this.cq[64] = 28;
            this.cc[0][1] = 1;
            int var10001;
            byte var10002;
            int var4;
            if (!this.gh) {
               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bE) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bF) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 4 && this.an >= this.fL && this.an <= this.fL + 11) {
               this.dh[21] = 3;
               this.gu[this.fR] = 21;
               ++this.fR;
            }

            if (this.selectedMap == 4 && this.an >= this.fL + 48 && this.an <= this.fL + 59) {
               this.dh[45] = 3;
               this.gu[this.fR] = 45;
               ++this.fR;
            }

            if (this.selectedMap == 4 && this.an >= this.fL + 12 && this.an <= this.fL + 23) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 24;
               this.cb[64][0] = 884736;
               this.cb[64][1] = 1867776;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.eU = false;
               this.cc[0][1] = 1;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 4 && this.an >= this.fL + 24 && this.an <= this.fL + 35) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 36;
               this.cb[64][0] = 950272;
               this.cb[64][1] = 1802240;
               this.cq[64] = 28;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 4 && this.an >= this.fL + 36 && this.an <= this.fL + 47) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 12;
               this.cb[64][0] = 884736;
               this.cb[64][1] = 1736704;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 9 && this.an >= this.fL && this.an <= this.fL + 11) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 12;
               this.cb[64][0] = 2588672;
               this.cb[64][1] = 753664;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 9 && this.an >= this.fL + 12 && this.an <= this.fL + 23) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 24;
               this.cb[64][0] = 2654208;
               this.cb[64][1] = 688128;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 9 && this.an >= this.fL + 24 && this.an <= this.fL + 35) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL;
               this.cb[64][0] = 2588672;
               this.cb[64][1] = 622592;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 1 && this.an >= this.fL + 12 && this.an <= this.fL + 23) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 60;
               this.cb[64][0] = 1736704;
               this.cb[64][1] = 294912;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 1 && this.an >= this.fL + 60 && this.an <= this.fL + 71) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 12;
               this.cb[64][0] = 1802240;
               this.cb[64][1] = 360448;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 1 && this.an >= this.fL + 24 && this.an <= this.fL + 35) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 36;
               this.cb[64][0] = 1671168;
               this.cb[64][1] = 294912;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }

            if (this.selectedMap == 1 && this.an >= this.fL + 36 && this.an <= this.fL + 47) {
               this.gh = true;
               ++this.fT;
               this.fV = this.fL + 24;
               this.cb[64][0] = 1605632;
               this.cb[64][1] = 294912;
               this.bC = (long)this.cb[64][0];
               this.bD = (long)this.cb[64][1];
               this.cq[64] = 28;
               this.cc[0][1] = 1;
               this.eU = false;
               if (a(this.fm - this.bC) >> 16 < 2L && a(this.fn - this.bD) >> 16 < 2L) {
                  this.ey = true;
               }

               for(var2 = 0; var2 < 32; ++var2) {
                  var3 = (int)(a((long)this.cb[var2][0] - this.bC) >> 16);
                  var4 = (int)(a((long)this.cb[var2][1] - this.bD) >> 16);
                  if (var3 < 2 && var4 < 2) {
                     this.cv[var2] = true;
                     this.co[var2] = 0;
                     if (this.ck[var2] < 0) {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 33;
                     } else {
                        var10000 = this.cq;
                        var10001 = var2;
                        var10002 = 27;
                     }

                     var10000[var10001] = var10002;
                  }
               }
            }
         } else if (this.an >= this.fI && this.an < this.fJ) {
            for(var2 = var1 = this.an - (this.an - this.fI) % 4; var2 < var1 + 4; ++var2) {
               this.bw[var2] = 1;
            }

            var2 = this.an - this.fI >> 2;
            var3 = 106 + var2;
            this.cv[var3] = true;
            this.cw[var3] = true;
            if ((this.selectedMap == 1 || this.selectedMap == 2) && !this.eT) {
               ++this.cq[var3];
            }
         }

         if (this.eE != 3 && this.eT && !this.gh) {
            this.cb[65][0] = (int)this.bE;
            this.cb[65][1] = (int)this.bF;
            byte var5;
            byte var6;
            if (this.cq[65] != 36) {
               var10000 = this.cq;
               var5 = 65;
               var6 = (byte)(var10000[65] + 1);
            } else {
               var10000 = this.cq;
               var5 = 65;
               var6 = 34;
            }

            var10000[var5] = var6;
         }

      }
   }

   private void e(boolean var1) {
      if (this.bU != -1 && var1 && (this.eE != 2 || this.ff - this.gR > 500L)) {
         this.cv[this.bU] = true;
      }

      for(int var2 = 0; var2 < this.bR; ++var2) {
         if (this.cv[this.ce[var2]] && this.ce[var2] < 32) {
            byte[] var10000;
            int var10001;
            byte var10002;
            if (this.ck[this.ce[var2]] >= 0 && (this.ck[this.ce[var2]] != 41 || this.selectedMap != 5 && this.selectedMap != 8)) {
               var10000 = this.cq;
               var10001 = this.ce[var2];
               var10002 = 27;
            } else {
               var10000 = this.cq;
               var10001 = this.ce[var2];
               var10002 = 33;
            }

            var10000[var10001] = var10002;
         }

         this.cv[this.ce[var2]] = true;
      }

      if (this.eE == 3 && this.eU && this.eT) {
         this.cb[64][0] = (int)this.bA;
         this.cb[64][1] = (int)this.bB;
         this.cq[64] = 28;
         this.cc[0][1] = 1;
         if (a(this.fm - this.bA) >> 16 < 1L && a(this.fn - this.bB) >> 16 < 1L) {
            this.ey = true;
         }
      }

   }

   private void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12) {
      for(int var13 = 0; var13 < this.fx; ++var13) {
         if (this.cv[var13] && this.ck[var13] >= var4 && this.ck[var13] <= var5) {
            label139: {
               byte[] var10000;
               int var10001;
               byte var10002;
               if (this.eE != 3) {
                  if (this.ck[var13] < 0) {
                     var10000 = this.co;
                     var10001 = var13;
                     var10002 = (byte)(var10000[var13] - abs(this.ck[var13]) * (this.eE + 1));
                  } else {
                     if (this.ck[var13] != 41) {
                        break label139;
                     }

                     var10000 = this.co;
                     var10001 = var13;
                     var10002 = (byte)(var10000[var13] - 12 * (this.eE + 1));
                  }
               } else {
                  var10000 = this.co;
                  var10001 = var13;
                  var10002 = 0;
               }

               var10000[var10001] = var10002;
            }

            if (this.co[var13] > 0) {
               this.cv[var13] = false;
               this.cj[var13] = -1;
               if (this.E() % 3 == 0 && this.ck[var13] < 0) {
                  this.cq[var13] = 10;
               }

               return;
            }

            if (this.co[var13] <= 0) {
               this.co[var13] = 0;
               if ((this.selectedMap == 2 && (this.cq[5] == 40 || this.cq[5] == 27) || this.selectedMap == 4 && (this.cq[11] == 40 || this.cq[11] == 27) || this.selectedMap == 7 && (this.cq[15] == 27 || this.cq[15] == 44) && (this.cq[16] == 27 || this.cq[16] == 44) && (this.cq[17] == 27 || this.cq[17] == 44)) && this.eO == 0) {
                  this.eO = 1;
               }

               if (this.cq[var13] >= var1 && this.cq[var13] <= var12 && this.cq[var13] != var6 && this.cq[var13] != var7 && this.cq[var13] != var8 && this.cq[var13] != var9 && this.cq[var13] != var10 && this.cq[var13] != var11) {
                  this.cq[var13] = (byte)var2;
                  if (this.ck[var13] == 41 && (this.selectedMap == 5 || this.selectedMap == 8)) {
                     this.cb[64][0] = this.cb[var13][0];
                     this.cb[64][1] = this.cb[var13][1];
                     this.cq[64] = 28;
                     this.cc[0][1] = 1;
                  }
               } else if (this.cq[var13] >= var2 && this.cq[var13] < var3 && this.cq[var13] != var6 && this.cq[var13] != var7 && this.cq[var13] != var8 && this.cq[var13] != var9 && this.cq[var13] != var10 && this.cq[var13] != var11) {
                  ++this.cq[var13];
                  if (this.cq[var13] == 12 || this.cq[var13] == 33) {
                     this.eN = this.E();
                  }
               }

               if (this.ch[var13] != 255) {
                  this.dh[this.ch[var13]] = this.ga;
               }
            }
         }
      }

   }

   private void x() {
      for(int var1 = 106; var1 < 106 + this.fG; ++var1) {
         if (this.cv[var1]) {
            byte[] var10000;
            int var10001;
            byte var10002;
            if (this.cq[var1] < this.cM + 1) {
               var10000 = this.cq;
               var10001 = var1;
               var10002 = (byte)(var10000[var1] + 1);
            } else {
               var10000 = this.cq;
               var10001 = var1;
               var10002 = this.cn[var1];
            }

            var10000[var10001] = var10002;
         }
      }

   }

   private void y() {
      if (!this.gZ[0] && this.eG >= 5) {
         if (this.gD == -10000 && !this.eP) {
            this.eI = 0;
            this.eK = -1;
         }

      } else if (!this.eP) {
         if (this.eG < 5) {
            ++this.eG;
         }

         if (this.eG == 5) {
            this.eG = 6;
         } else {
            this.eB = (this.eE + 1) % 4;
            this.eI = 0;
            this.eK = -1;
            this.eP = true;
         }
      }
   }

   private void b(int var1, int var2, int var3) {
      ++this.eK;
      if (this.eK < var2) {
         this.eI += var1 * 2;
      } else if (this.eK < var3) {
         this.eI -= var1 * 2;
      } else {
         if (this.eK == var3) {
            this.eI -= var1 * 2;
            this.eK = -1;
         }

      }
   }

   private void z() {
      if (this.fr > 0) {
         if (this.eH != 2) {
            this.eH = 1 - this.eH;
         }

         if (this.eH == 1 && this.eL == 53) {
            label26: {
               l3d_d var10000;
               int var10001;
               int var10002;
               if (this.eE != 3) {
                  if (this.eE == 2 && this.ff - this.gR <= 500L) {
                     break label26;
                  }

                  var10000 = this;
                  var10001 = this.fr;
                  var10002 = 1 + this.eE;
               } else {
                  var10000 = this;
                  var10001 = this.fr;
                  var10002 = 1;
               }

               var10000.fr = var10001 - var10002;
            }

            if (this.fr <= 0) {
               this.fr = 0;
               this.gC = -10000;
            }
         }

      }
   }

   private void A() {
      if (this.eP) {
         this.b(10, 4, 7);
         if (this.eK == 4) {
            this.eF = this.eE;
            this.eE = this.eB;
            this.eU = true;
            if (this.eE == 3) {
               this.fp = this.fr;
               this.fr = this.fq;
            } else if (this.eE == 0) {
               this.fq = this.fr;
               this.fr = this.fp;
               this.gG = 0;
               this.gK = false;
               this.eH = 0;
            }

            this.eQ = true;
            return;
         }

         if (this.eK == -1) {
            this.eP = false;
         }
      }

   }

   private void B() {
      int var1;
      for(var1 = 26032; var1 < 26038; ++var1) {
         this.bk[var1] = 16777215;
         this.bk[var1 + 9] = 16777215;
      }

      for(var1 = 24359; var1 < 25799; var1 += 240) {
         this.bk[var1] = 16777215;
         this.bk[var1 + 2160] = 16777215;
      }

   }

   private void C() {
      boolean var2 = false;

      int var1;
      for(var1 = 0; var1 < 480; ++var1) {
         this.bk[var1] = 10616832;
         this.bk[var1 + 240] = 6619136;
         this.bk[var1 + 240 + 240] = 3932160;
         this.bk[var1 + 240 + 240 + 240] = 2621440;
         this.bk['챟' - var1] = 10616832;
         this.bk['챟' - var1 - 240] = 6619136;
         this.bk['챟' - var1 - 240 - 240] = 3932160;
         this.bk['챟' - var1 - 240 - 240 - 240] = 2621440;
      }

      char var3 = '챟';

      for(var1 = 0; var1 < var3; var1 += 240) {
         this.bk[var1] = 10616832;
         this.bk[var1 + 1] = 6619136;
         this.bk[var1 + 2] = 3932160;
         this.bk[var1 + 3] = 2621440;
         this.bk[var1 + 238] = 10616832;
         this.bk[var1 + 239] = 6619136;
         this.bk[var1 + 239 - 2] = 3932160;
         this.bk[var1 + 239 - 3] = 2621440;
      }

   }

   private void D() {
      if (this.r == null) {
         this.readMetadata();
      }

      this.Q();
      if (this.hI == null) {
         this.P();
      }

   }

   private static void d(Graphics var0) {
      var0.setColor(0, 0, 0);
      var0.fillRect(0, 0, 240, 320);
   }

   private int E() {
      return this.em.nextInt();
   }

   private void B(int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         byte var3 = this.cs[this.fU][var2];
         if (this.cw[var3] && (this.cq[var3] == this.fW || this.bW) && (this.br[this.cq[var3]] != 2 || !this.n(var3) || a((long)this.cb[var3][0] - this.fm) >> 16 < 6L && a((long)this.cb[var3][1] - this.fn) >> 16 < 6L)) {
            this.o(var3);
         }
      }

      l3d_d var10000;
      byte var10001;
      if (this.eE == 0) {
         var10000 = this;
         var10001 = 5;
      } else if (this.eE == 1) {
         var10000 = this;
         var10001 = 5;
      } else if (this.eE == 2) {
         var10000 = this;
         var10001 = 5;
      } else {
         var10000 = this;
         var10001 = 30;
      }

      var10000.eM = var10001;
      this.bR = 0;
      this.k();
   }

   private void a(int var1, int var2, Graphics var3) {
      int var4 = var1;

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         var3.drawRGB(this.hJ, 0, 15, var2 + 15 * var5, 286, 15, 14, false);
      }

      for(var5 = 2; var4 != 0; --var5) {
         int var6 = var4 % 10;
         var3.drawRGB(this.hJ, var6 * 15 * 14, 15, var2 + 15 * var5, 286, 15, 14, false);
         var4 /= 10;
      }

   }

   private void F() {
      this.C(11);
      int var1;
      if (!this.ex) {
         this.gt = new short[240];
         this.gw = new byte[240];
         this.gr = new int[8];
         this.gH = 5;

         for(var1 = 0; var1 < 4; ++var1) {
            for(int var2 = 0; var2 < 2; ++var2) {
               this.gr[2 * var1 + var2] = 10616832;
            }
         }

         for(var1 = 0; var1 < 240; var1 += 2) {
            this.gt[var1] = (short)(-(abs(this.E()) % 60));
            this.gw[var1] = (byte)abs(this.E() % 2);
         }

         this.gt[0] = 0;
      } else {
         this.gH = 100;
         this.gr = new int[3275];
         this.readImage("/k" + this.dataExt).getRGB(this.gr, 0, 131, 0, 0, 131, 25);
         int var4 = this.gr.length;

         for(var1 = 0; var1 < var4; ++var1) {
            if (this.gr[var1] == this.N) {
               this.gr[var1] = 0;
            }
         }
      }

      this.ez = true;
      this.gB = false;
      this.gV = this.ff;
   }

   private void e(Graphics var1) {
      if (this.ex) {
         if (this.gA <= 25) {
            var1.drawRGB(this.gr, 0, 131, 32, 239, 131, 25 - this.gA, true);
         }

      } else {
         for(int var2 = 0; var2 < 240; var2 += 2) {
            Graphics var10000;
            int[] var10001;
            byte var10002;
            byte var10003;
            int var10004;
            short var10005;
            byte var10006;
            int var10007;
            label58: {
               if (this.gw[var2] == 1) {
                  if (this.gt[var2] >= -3 && this.gt[var2] <= -1) {
                     var10000 = var1;
                     var10001 = this.gr;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = 0;
                     var10006 = 2;
                     var10007 = 4 + this.gt[var2];
                     break label58;
                  }

                  if (this.gt[var2] >= 0 && this.gt[var2] <= this.gz - 1 - 4) {
                     var10000 = var1;
                     var10001 = this.gr;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = this.gt[var2];
                     var10006 = 2;
                     var10007 = 4;
                     break label58;
                  }

                  if (this.gt[var2] < this.gz - 1 - 3 || this.gt[var2] >= this.gz) {
                     continue;
                  }
               } else {
                  if (this.gt[var2] >= -1 && this.gt[var2] <= -1) {
                     var10000 = var1;
                     var10001 = this.gr;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = 0;
                     var10006 = 2;
                     var10007 = 2 + this.gt[var2];
                     break label58;
                  }

                  if (this.gt[var2] >= 0 && this.gt[var2] <= this.gz - 1 - 2) {
                     var10000 = var1;
                     var10001 = this.gr;
                     var10002 = 0;
                     var10003 = 2;
                     var10004 = var2;
                     var10005 = this.gt[var2];
                     var10006 = 2;
                     var10007 = 2;
                     break label58;
                  }

                  if (this.gt[var2] < this.gz - 1 - 1 || this.gt[var2] >= this.gz) {
                     continue;
                  }
               }

               var10000 = var1;
               var10001 = this.gr;
               var10002 = 0;
               var10003 = 2;
               var10004 = var2;
               var10005 = this.gt[var2];
               var10006 = 2;
               var10007 = this.gz - this.gt[var2];
            }

            var10000.drawRGB(var10001, var10002, var10003, var10004, var10005, var10006, var10007, false);
         }

      }
   }

   private void G() {
      if (this.ex) {
         --this.gA;
         if (this.gA == 0) {
            this.gB = true;
            this.gA = 35;
         }

      } else if (!this.gB) {
         boolean var2 = true;

         for(int var1 = 0; var1 < 240; var1 += 2) {
            if (this.gt[var1] >= 0 && this.gt[var1] < this.gz) {
               var2 = false;
            }

            short[] var10000;
            int var10001;
            short var10002;
            byte var10003;
            if (this.gw[var1] == 1) {
               var10000 = this.gt;
               var10001 = var1;
               var10002 = var10000[var1];
               var10003 = 4;
            } else {
               if (this.gw[var1] != 0) {
                  continue;
               }

               var10000 = this.gt;
               var10001 = var1;
               var10002 = var10000[var1];
               var10003 = 2;
            }

            var10000[var10001] = (short)(var10002 + var10003);
         }

         if (var2) {
            this.gB = true;
         }

      }
   }

   private void H() {
      boolean var1 = true;
      if (abs(this.E()) % 3 != 0) {
         var1 = false;
      }

      for(int var2 = 32; var2 < 32 + this.fy; ++var2) {
         byte[] var10000;
         int var10001;
         byte var10002;
         if (this.cv[var2]) {
            this.cq[var2] = this.fY;
            if (this.selectedMap != 6) {
               continue;
            }

            if (var2 == 37) {
               this.dh[155] = 5;
               this.dh[152] = 5;
            }

            if (var2 == 36) {
               this.dh[150] = 5;
               this.dh[157] = 5;
            }

            if (var2 == 35) {
               this.dh[148] = 5;
               this.dh[159] = 5;
            }

            if (var2 == 34) {
               this.dh[182] = 5;
               this.dh[185] = 5;
            }

            if (var2 == 33) {
               this.dh[180] = 5;
               this.dh[187] = 5;
            }

            if (var2 == 32) {
               this.dh[178] = 5;
               this.dh[179] = 5;
            }

            if (var2 != 40) {
               continue;
            }

            this.dh[161] = 4;
            this.dh[162] = 4;
            this.dh[163] = 4;
            this.dh[164] = 4;
            this.dh[165] = 4;
            this.dh[166] = 50;
            this.dh[170] = 4;
            this.dh[174] = 4;
            this.dh[175] = 4;
            var10000 = this.dh;
            var10001 = 172;
            var10002 = 5;
         } else if (this.ck[var2] == -1) {
            if (!var1) {
               continue;
            }

            if (this.cq[var2] == this.fW) {
               this.cq[var2] = this.fX;
               if (this.selectedMap != 6) {
                  continue;
               }

               this.dh[148] = 5;
               this.dh[150] = 5;
               this.dh[152] = 5;
               this.dh[155] = 5;
               this.dh[157] = 5;
               this.dh[159] = 5;
               this.dh[161] = 4;
               this.dh[162] = 4;
               this.dh[163] = 4;
               this.dh[164] = 4;
               this.dh[165] = 4;
               this.dh[166] = 50;
               this.dh[170] = 4;
               this.dh[172] = 5;
               this.dh[174] = 4;
               this.dh[175] = 4;
               this.dh[178] = 5;
               this.dh[180] = 5;
               this.dh[182] = 5;
               this.dh[185] = 5;
               this.dh[187] = 5;
               var10000 = this.dh;
               var10001 = 189;
               var10002 = 5;
            } else {
               this.cq[var2] = this.fW;
               if (this.selectedMap != 6) {
                  continue;
               }

               if (this.cq[34] != this.fY) {
                  this.dh[182] = 6;
                  this.dh[185] = 6;
               }

               if (this.cq[33] != this.fY) {
                  this.dh[180] = 6;
                  this.dh[187] = 6;
               }

               if (this.cq[32] != this.fY) {
                  this.dh[178] = 6;
                  this.dh[189] = 6;
               }

               if (this.cq[40] != this.fY) {
                  this.dh[161] = 0;
                  this.dh[162] = 0;
                  this.dh[163] = 0;
                  this.dh[164] = 0;
                  this.dh[165] = 0;
                  this.dh[166] = 0;
                  this.dh[170] = 0;
                  this.dh[172] = 6;
                  this.dh[174] = 0;
                  this.dh[175] = 0;
               }

               if (this.cq[35] != this.fY) {
                  this.dh[148] = 6;
                  this.dh[159] = 6;
               }

               if (this.cq[36] != this.fY) {
                  this.dh[150] = 6;
                  this.dh[157] = 6;
               }

               if (this.cq[37] == this.fY) {
                  continue;
               }

               this.dh[155] = 6;
               var10000 = this.dh;
               var10001 = 152;
               var10002 = 6;
            }
         } else if (this.ck[var2] == -2) {
            if (!var1) {
               continue;
            }

            var10000 = this.cq;
            var10001 = var2;
            var10002 = this.fX;
         } else {
            if (this.ck[var2] == 127 || !var1) {
               continue;
            }

            if (this.cq[var2] == this.fW) {
               this.cq[var2] = this.fX;
               var10000 = this.cr;
               var10001 = this.ck[var2];
               var10002 = 1;
            } else {
               this.cq[var2] = this.fW;
               var10000 = this.cr;
               var10001 = this.ck[var2];
               var10002 = 0;
            }
         }

         var10000[var10001] = var10002;
      }

   }

   private void I() {
      for(int var2 = 0; var2 <= 6; ++var2) {
         if (this.gv[var2] != null) {
            for(int var1 = 0; var1 < this.gv[var2].length; ++var1) {
               boolean var3 = true;
               if (this.selectedMap == 4) {
                  for(int var4 = 0; var4 < this.fR; ++var4) {
                     if (this.gu[var4] == this.gv[var2][var1]) {
                        var3 = false;
                     }
                  }
               }

               if (var3) {
                  this.dh[this.gv[var2][var1]] = this.gx[var2][this.gy[var2][var1]];
               }

               if (var3) {
                  byte[] var10000;
                  int var10001;
                  byte var10002;
                  if (this.gy[var2][var1] < this.gs[var2]) {
                     var10000 = this.gy[var2];
                     var10001 = var1;
                     var10002 = (byte)(var10000[var1] + 1);
                  } else {
                     var10000 = this.gy[var2];
                     var10001 = var1;
                     var10002 = 0;
                  }

                  var10000[var10001] = var10002;
               }
            }
         }
      }

   }

   private void J() {
      if (this.eG > 4 || this.fN != 3) {
         boolean var1 = !this.gZ[5];
         if (this.gD < 0) {
            this.gD = this.getGameAction(this.gD);
         }

         l3d_d var10000;
         label89: {
            byte var10001;
            if (this.gD == 1) {
               var10000 = this;
               var10001 = 50;
            } else if (this.gD == 6) {
               var10000 = this;
               var10001 = 56;
            } else if (this.gD == 2) {
               var10000 = this;
               var10001 = 52;
            } else if (this.gD == 5) {
               var10000 = this;
               var10001 = 54;
            } else {
               if (this.gD != 8) {
                  break label89;
               }

               var10000 = this;
               var10001 = 53;
            }

            var10000.gD = var10001;
         }

         if (this.fN == 3 && this.gD >= 48 && this.gD <= 57) {
            if (this.ha[this.gD - 48]) {
               this.gD = -10000;
               this.gC = -10000;
               return;
            }

            this.gZ[this.gD - 48] = true;
         }

         this.gC = this.gD;
         if (this.fN == 3) {
            if (this.gZ[4] || this.gZ[6]) {
               this.fB = this.fE;
               this.fg = this.ff;
            }

            if (this.eP && this.gC == 53) {
               this.gZ[5] = false;
            }

            if (this.eP || this.gZ[5]) {
               this.gZ[0] = false;
            }

            if (this.gZ[5]) {
               if (this.fr <= 0) {
                  this.gZ[5] = false;
               }

               boolean var2;
               if (this.E() % 2 == 0) {
                  var10000 = this;
                  var2 = true;
               } else {
                  var10000 = this;
                  var2 = false;
               }

               var10000.eR = var2;
               if (this.gC == 53 && var1) {
                  this.gR = this.ff;
                  return;
               }
            }
         } else {
            this.T();
         }

      }
   }

   private void K() {
      this.H();
      l3d_d var10000;
      int var10001;
      if (this.fM != 3) {
         var10000 = this;
         var10001 = this.fM + 1;
      } else {
         var10000 = this;
         var10001 = 0;
      }

      var10000.fM = var10001;
      this.A(this.fM % 2);
      if (!this.ez) {
         byte var1;
         byte var10002;
         byte var10003;
         byte var10004;
         byte var10005;
         byte var10006;
         byte var10007;
         if (this.eN % 2 == 0 && this.eE != 3) {
            var10000 = this;
            var1 = 0;
            var10002 = 10;
            var10003 = 12;
            var10004 = -100;
            var10005 = 0;
            var10006 = 26;
            var10007 = 33;
         } else if (this.eE != 3) {
            var10000 = this;
            var1 = 0;
            var10002 = 24;
            var10003 = 26;
            var10004 = -100;
            var10005 = 0;
            var10006 = 12;
            var10007 = 33;
         } else {
            var10000 = this;
            var1 = 0;
            var10002 = 33;
            var10003 = 33;
            var10004 = -100;
            var10005 = 0;
            var10006 = 12;
            var10007 = 26;
         }

         label62: {
            var10000.a(var1, var10002, var10003, var10004, var10005, var10006, var10007, -1, -1, -1, -1, 9);
            if (this.selectedMap == 1) {
               if (this.eE != 3) {
                  var10000 = this;
                  var1 = 37;
                  var10002 = 39;
                  var10003 = 41;
                  var10004 = 1;
                  var10005 = 100;
                  var10006 = 27;
                  break label62;
               }

               var10000 = this;
            } else {
               if (this.eE != 3) {
                  var10000 = this;
                  var1 = 37;
                  var10002 = 39;
                  var10003 = 40;
                  var10004 = 1;
                  var10005 = 100;
                  var10006 = 27;
                  break label62;
               }

               var10000 = this;
            }

            var1 = 37;
            var10002 = 27;
            var10003 = 27;
            var10004 = 1;
            var10005 = 100;
            var10006 = 40;
         }

         var10000.a(var1, var10002, var10003, var10004, var10005, var10006, -1, -1, -1, -1, -1, 38);
         if (this.selectedMap != 1) {
            byte var2;
            byte var3;
            byte var10008;
            byte var10009;
            byte var10010;
            byte var10011;
            byte var10012;
            if (this.selectedMap != 5 && this.selectedMap != 8) {
               if (this.eE != 3) {
                  var10000 = this;
                  var1 = 41;
                  var10002 = 43;
                  var10003 = 44;
                  var10004 = 1;
                  var10005 = 100;
                  var3 = 27;
               } else {
                  var10000 = this;
                  var1 = 41;
                  var10002 = 27;
                  var10003 = 27;
                  var10004 = 1;
                  var10005 = 100;
                  var3 = 44;
               }

               var2 = -1;
               var10008 = -1;
               var10009 = -1;
               var10010 = -1;
               var10011 = -1;
               var10012 = 42;
            } else {
               var10000 = this;
               var1 = 41;
               var10002 = 33;
               var10003 = 33;
               var10004 = 1;
               var10005 = 100;
               var3 = -1;
               var2 = -1;
               var10008 = -1;
               var10009 = -1;
               var10010 = -1;
               var10011 = -1;
               var10012 = 45;
            }

            var10000.a(var1, var10002, var10003, var10004, var10005, var3, var2, var10008, var10009, var10010, var10011, var10012);
         }

         if (this.eE != 3) {
            var10000 = this;
            var1 = 46;
            var10002 = 48;
            var10003 = 49;
            var10004 = 1;
            var10005 = 100;
            var10006 = 27;
         } else {
            var10000 = this;
            var1 = 46;
            var10002 = 27;
            var10003 = 27;
            var10004 = 1;
            var10005 = 100;
            var10006 = 49;
         }

         var10000.a(var1, var10002, var10003, var10004, var10005, var10006, -1, -1, -1, -1, -1, 47);
         if (this.eE != 3) {
            var10000 = this;
            var1 = 50;
            var10002 = 52;
            var10003 = 53;
            var10004 = 1;
            var10005 = 100;
            var10006 = 27;
         } else {
            var10000 = this;
            var1 = 50;
            var10002 = 27;
            var10003 = 27;
            var10004 = 1;
            var10005 = 100;
            var10006 = 53;
         }

         var10000.a(var1, var10002, var10003, var10004, var10005, var10006, -1, -1, -1, -1, -1, 51);
      }

   }

   public final void keyPressed(int var1) {
      this.gC = var1;
   }

   public final void keyReleased(int var1) {
      int var2;
      if (this.fN == 3) {
         var2 = var1;
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
            this.he = this.cx;
            this.hf = this.cz;
            this.hg = true;
            this.hb = 1;
            this.hc = 0;
            this.hd = 0;
         } else if (var2 == 56) {
            this.he = this.cy;
            this.hf = this.cA;
            this.hg = true;
            this.hb = 1;
            this.hc = 0;
            this.hd = 0;
         } else if (var2 == 49) {
            this.he = this.cx;
            this.hf = this.cz;
            this.hg = true;
            this.hb = 1;
            this.hc = 90;
            this.hd = 0;
         } else if (var2 == 51) {
            this.he = this.cx;
            this.hf = this.cz;
            this.hg = true;
            this.hb = 1;
            this.hc = -90;
            this.hd = 0;
         } else if (var2 == 53) {
            this.gR = this.ff;
         } else {
            this.hg = false;
         }

         if (var2 >= 48 && var2 <= 57) {
            this.ha[var2 - 48] = true;
            this.gZ[var2 - 48] = false;
         }
      }

      if (!this.M()) {
         this.gC = -10000;
      } else {
         for(var2 = 0; var2 < 9; ++var2) {
            if (this.gZ[var2]) {
               this.gC = var2 + 48;
            }
         }

      }
   }

   private void L() {
      for(int var1 = 0; var1 < 9; ++var1) {
         this.gZ[var1] = false;
      }

      this.gC = -10000;
      this.eL = -10000;
   }

   private boolean M() {
      if (this.fN == 3) {
         return this.gZ[0] || this.gZ[1] || this.gZ[2] || this.gZ[3] || this.gZ[4] || this.gZ[5] || this.gZ[6] || this.gZ[7] || this.gZ[8] || this.gZ[9];
      } else {
         return false;
      }
   }

   private void N() {
      for(int var1 = 0; var1 < 10; ++var1) {
         this.ha[var1] = false;
      }

   }

   private void O() {
      label66: {
         this.R();
         if (this.hn != 20) {
            if (this.ff - this.fl <= 3000L) {
               break label66;
            }
         } else if (this.ff - this.fl <= 10000L) {
            break label66;
         }

         this.hH = false;
      }

      if (!this.hH) {
         int var1;
         if ((var1 = this.hv) < this.o.length) {
            if (this.ht != var1) {
               this.gn[0] = (long)this.o[var1] * 75000L >> 1;
               this.gn[1] = (long)this.o[var1 + 1] * 75000L >> 1;
               this.fz = this.o[var1 + 2] * 2;
               this.hu = 0;
            }

            int var2 = var1 >> 2;
            if (this.gn[1] <= (long)this.o[var1 + 3] * 75000L >> 1 && var2 != 1 || this.gn[1] >= (long)this.o[var1 + 3] * 75000L >> 1 && var2 == 1) {
               this.a(this.cx, this.cz, 0);
               this.ht = var1;
               ++this.hu;
            } else {
               this.hu = 0;
               this.hv += 4;
               l3d_d var10000;
               byte var10001;
               if (this.dh[19] == 38) {
                  var10000 = this;
                  var10001 = -1;
               } else {
                  var10000 = this;
                  var10001 = 0;
               }

               var10000.gE = var10001;
               if (this.hv >= this.o.length) {
                  this.hD = false;
                  this.hI = (int[][])null;
                  this.b(false);
                  if (this.selectedMap == 0) {
                     this.selectedMap = 1;
                     this.fS = 2;
                     this.gE = 0;
                  }

                  this.hq = 8;
                  this.hB = true;
                  this.hC = false;
                  this.fN = 2;
                  this.hn = 1;

                  try {
                     if (this.hV != null) {
                        this.hV.stop();
                     }
                  } catch (Exception var5) {
                  }

                  this.C(0);
               } else {
                  this.fl = this.ff;
                  this.hH = true;
               }
            }
         }
      }
   }

   private void P() {
      Image var4 = this.readImage("/f" + this.dataExt);
      this.hw = var4.getWidth();
      this.hx = var4.getHeight() - 112;
      this.hM = new int[this.hw * this.hx];
      var4.getRGB(this.hM, 0, this.hw, 0, 112, this.hw, this.hx);
      this.hI = new int[70][240];
      int var3 = 0;

      for(int var1 = 0; var1 < 7; ++var1) {
         for(int var2 = 0; var2 < 10; ++var2) {
            var4.getRGB(this.hI[var3], 0, 15, var2 * 15, var1 * 16, 15, 16);
            ++var3;
         }
      }

   }

   private void a(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      int var9 = var1;

      for(int var7 = var2; var7 <= var3; ++var7) {
         int var8;
         for(var8 = 0; var8 < this.q[var7]; ++var8) {
            var6.drawRGB(this.hI[this.r[var9]], 0, 15, var4 + 15 * var8, 22 * (var7 - var2 + var5) + this.hk - 5, 15, 16, false);
            ++var9;
         }

         if (this.gk && this.selectedMap != 10) {
            var6.drawRGB(this.hI[48], 0, 15, var4 + 15 * var8, 22 * (var7 - var2 + var5) + this.hk - 5, 15, 16, false);
         }
      }

   }

   private void b(int var1, int var2, int var3, int var4, int var5, Graphics var6) {
      int var10 = this.hP[22];

      int var7;
      for(var7 = 1; var7 <= this.hA; ++var7) {
         var10 += this.q[this.hO[22] + var7 - 1];
      }

      int var11;
      int var10000;
      label62: {
         var11 = var5;
         int var10001;
         if (this.ih > 8) {
            var10000 = this.hO[22] + 7;
            var10001 = this.hA;
         } else {
            if (this.ih != 0) {
               var10000 = this.hO[22] + this.ih - 1;
               break label62;
            }

            var10000 = this.hO[22];
            var10001 = this.ih;
         }

         var10000 += var10001;
      }

      int var12 = var10000;

      int var8;
      for(var7 = this.hO[22] + this.hA; var7 <= var12; ++var7) {
         for(var8 = 0; var8 < this.q[var7]; ++var8) {
            var6.drawRGB(this.hI[this.r[var10]], 0, 15, var4 + 15 * var8, 22 * var11 + this.hk - 5, 15, 16, false);
            ++var10;
         }

         ++var11;
      }

      if (this.ih > 8) {
         --var11;
      }

      if (this.hA == this.ih - 7 || this.ih < 8) {
         int var9 = var1;

         for(var7 = var2; var7 < var3; ++var7) {
            var9 += this.q[var7];
         }

         for(var8 = 0; var8 < this.q[var7]; ++var8) {
            var6.drawRGB(this.hI[this.r[var9]], 0, 15, var4 + 15 * var8, 22 * var11 + this.hk - 5, 15, 16, false);
            ++var9;
         }
      }

   }

   private void Q() {
      int var3 = 0;
      this.hO = new int[this.p.length];
      this.hP = new int[this.p.length];

      for(int var1 = 1; var1 < this.hO.length; ++var1) {
         this.hO[var1] = this.hO[var1 - 1] + this.p[var1 - 1];
         this.hP[var1] = this.hP[var1 - 1];

         for(int var2 = 1; var2 <= this.p[var1 - 1]; ++var2) {
            int[] var10000 = this.hP;
            var10000[var1] += this.q[var3];
            ++var3;
         }
      }

   }

   private void f(Graphics var1) {
      int var10000;
      byte var3;
      byte var4;
      label93: {
         var3 = 15;
         var4 = 5;
         if (this.hn <= 5) {
            var10000 = 21;
         } else if (this.hn == 12) {
            var10000 = 30;
         } else if (this.hn == 14) {
            var10000 = 15;
         } else if (this.hn == 15) {
            var10000 = 30;
         } else if (this.hn == 16) {
            var10000 = 30;
         } else {
            if (this.hn == 21) {
               var3 = 40;
               var4 = 7;
               break label93;
            }

            if (this.hn != 23) {
               break label93;
            }

            var10000 = 14;
         }

         var3 = (byte)var10000;
      }

      byte var10001;
      if (this.hn != 1) {
         if (this.hn == 0 && !this.hC) {
            var10000 = this.hO[this.hn] + this.p[this.hn];
            var10001 = 2;
         } else {
            var10000 = this.hO[this.hn] + this.p[this.hn];
            var10001 = 1;
         }

         int var5 = var10000 - var10001;
         this.a(this.hP[this.hn], this.hO[this.hn], var5, var3, var4, var1);
      } else {
         this.b(this.hP[this.hn], this.hO[this.hn], this.hO[this.hn] + this.p[this.hn] - 1, var3, var4, var1);
      }

      if (this.hn == 3) {
         int var2;
         for(var2 = this.hZ != 0 ? 1 : 0; var2 < this.hS.length; ++var2) {
            this.a(this.hS[var2], this.hT[var2], this.hT[var2], 185, 4 + var2 + 1, var1);
         }

         if (this.hZ != 0) {
            l3d_d var7;
            if (this.hZ == 100) {
               this.hY[0] = 1;
               this.hY[1] = 0;
               this.hY[2] = 0;
               var7 = this;
               var10001 = 3;
            } else {
               this.hY[0] = this.hZ / 10;
               this.hY[1] = 0;
               var7 = this;
               var10001 = 2;
            }

            var7.ia = var10001;

            for(var2 = this.hT[0]; var2 <= this.hT[0]; ++var2) {
               for(int var6 = 0; var6 < this.ia; ++var6) {
                  var1.drawRGB(this.hI[this.hY[var6]], 0, 15, 185 + 15 * var6, 22 * (var2 - this.hT[0] + 4 + 1) + this.hk - 5, 15, 16, false);
               }
            }
         }
      }

      if (this.hn <= 5) {
         this.g(var1);
      }

      if (!this.gl) {
         var1.drawRGB(this.hM, 0, this.hw, 240 - this.hw >> 1, 50 + this.hk, this.hw, this.hx, false);
      }

   }

   private void g(Graphics var1) {
      var1.drawRGB(this.hI[66], 0, 15, 4, 22 * (this.hp + 4 + 1) + this.hk - 5, 15, 16, false);
   }

   private void R() {
      this.hl = 192 + this.E() % 16;
      this.hm = 208 + this.E() % 4;
      if (this.ff - this.hi > 1000L) {
         this.hk = abs(this.E() % 3);
         this.hi = this.ff;
      } else {
         this.hk = 0;
      }
   }

   private void S() {
      label28: {
         long var1 = this.ff - this.hj;
         l3d_d var10000;
         if (this.fN == 1) {
            this.hG = true;
            if (var1 <= 6000L) {
               break label28;
            }

            if (var1 > 6000L) {
               this.fN = 4;
               this.hj = this.ff;
               break label28;
            }

            var10000 = this;
         } else {
            if (this.fN != 4) {
               break label28;
            }

            this.hG = true;
            if (var1 <= 6000L) {
               break label28;
            }

            if (var1 > 6000L) {
               this.fN = 2;
               break label28;
            }

            var10000 = this;
         }

         var10000.hG = false;
      }

      this.R();
   }

   private void T() {
      if (!this.gl) {
         if (this.fN == 2) {
            this.ho = this.hn;
            int var1 = this.hn != 4 ? 0 : 1;
            if (this.hn >= 6) {
               if (this.V()) {
                  this.U();
                  return;
               }
            } else if (this.gD == 50) {
               if (this.hn == 1) {
                  this.hq = this.hp;
                  if (this.hp != var1) {
                     --this.hp;
                     return;
                  }

                  if (this.hA > 0) {
                     --this.hA;
                     return;
                  }

                  if (this.ih > 7) {
                     this.hp = 7;
                     this.hA = this.ih - 7;
                     return;
                  }

                  if (this.ih == 0) {
                     this.hp = this.ih + 1;
                     return;
                  }

                  this.hp = this.ih;
                  return;
               }

               if (this.hn <= 5) {
                  this.hq = this.hp;
                  if (this.hp != var1) {
                     --this.hp;
                     return;
                  }

                  if (this.hn == 0 && !this.hC) {
                     this.hp = this.p[this.hn] - 2;
                     return;
                  }

                  this.hp = this.p[this.hn] - 1;
                  return;
               }
            } else if (this.gD == 56) {
               if (this.hn != 1) {
                  if (this.hn <= 5) {
                     this.hq = this.hp;
                     if (this.hn == 0 && !this.hC) {
                        if (this.hp != this.p[this.hn] - 2) {
                           ++this.hp;
                           return;
                        }

                        this.hp = var1;
                        return;
                     }

                     if (this.hp != this.p[this.hn] - 1) {
                        ++this.hp;
                        return;
                     }

                     this.hp = var1;
                     return;
                  }
               } else {
                  this.hq = this.hp;
                  if (this.hp != 7 && this.ih > 7 || this.hp < this.ih && this.ih <= 7 || this.hp == 0 && this.ih == 0) {
                     ++this.hp;
                     return;
                  }

                  if (this.hA != this.ih - 7 && this.ih > 7) {
                     ++this.hA;
                     return;
                  }

                  if (this.hp == 7 || this.hp >= this.ih + 1 && this.ih == 0 || this.hp == this.ih) {
                     this.hp = var1;
                     this.hA = 0;
                     return;
                  }
               }
            } else {
               int var10001;
               l3d_d var7;
               if (this.gD != 52 && this.gD != 54) {
                  if (this.hn == 0) {
                     if (this.hp == 4) {
                        if (!this.hC) {
                           return;
                        }

                        this.hI = (int[][])null;
                        this.hM = null;
                        this.c(false);
                        System.gc();
                        this.fO = -1;
                        this.fP = -1;
                        this.fN = 3;
                        this.W();
                     }

                     this.hr = this.hp;
                     this.hs = this.hq;
                     this.hn = this.hp + 1;
                  } else {
                     byte var8;
                     if (this.hn == 1) {
                        if (this.hp == 1 && this.ih == 0 || this.hp == this.ih && this.ih != 0 || this.hp == 7 && this.hA == this.ih - 7) {
                           this.hn = 0;
                           this.hp = 0;
                           return;
                        }

                        if (this.hp == 7 && !this.gd && this.hA == 2 || this.hp == 6 && !this.gd && this.hA == 3) {
                           this.hF = true;
                           this.hD = true;
                           this.gE = 0;
                           this.ht = -1;
                           this.hu = 0;
                           this.hv = 0;
                        }

                        try {
                           if (this.hV != null) {
                              this.hV.stop();
                           }
                        } catch (Exception var6) {
                        }

                        this.hM = null;
                        System.gc();
                        this.gc = true;
                        this.gk = true;
                        this.hH = false;
                        this.fN = 3;
                        if (this.ih == 0) {
                           this.ih = 1;
                           this.id[0] = 0;
                           this.ie[0] = 83;
                           this.if[0] = 210;
                           this.ig[0] = 0;
                           this.aa();
                        }

                        if ((this.hp != 7 || this.hA != 5) && !this.hD) {
                           label387: {
                              this.selectedMap = this.hp + this.hA + 1;
                              this.eD = 0;
                              this.eS = false;
                              this.eJ = 0;
                              this.eC = 40;
                              this.eH = 0;
                              this.gG = 0;
                              if (this.selectedMap != 4 && this.selectedMap != 9) {
                                 if (this.selectedMap != 1) {
                                    break label387;
                                 }

                                 var7 = this;
                                 var8 = 2;
                              } else {
                                 var7 = this;
                                 var8 = 3;
                              }

                              var7.fS = var8;
                           }

                           this.gE = 0;
                           this.eE = this.id[this.selectedMap - 1];
                           this.fo = this.ie[this.selectedMap - 1];
                           if (this.fo > 100) {
                              this.fv = 200;
                           }

                           this.fp = this.if[this.selectedMap - 1];
                           this.fq = this.ig[this.selectedMap - 1];
                           if (this.eE == 3) {
                              var7 = this;
                              var10001 = this.fq;
                           } else {
                              var7 = this;
                              var10001 = this.fp;
                           }

                           var7.fr = var10001;
                           this.fs = this.fo;
                           this.ft = this.fp;
                           this.fu = this.fq;
                           this.u();
                        } else {
                           this.selectedMap = 0;
                           this.gE = 0;
                        }

                        this.W();
                     } else {
                        if (this.hn == 2) {
                           if (this.hp == 6) {
                              this.hp = this.hn - 1;
                              var7 = this;
                              var8 = 0;
                           } else if (this.hp == 0) {
                              var7 = this;
                              var8 = 6;
                           } else if (this.hp == 1) {
                              var7 = this;
                              var8 = 9;
                           } else if (this.hp == 2) {
                              var7 = this;
                              var8 = 11;
                           } else if (this.hp == 3) {
                              var7 = this;
                              var8 = 12;
                           } else if (this.hp == 4) {
                              var7 = this;
                              var8 = 14;
                           } else {
                              if (this.hp != 5) {
                                 return;
                              }

                              var7 = this;
                              var8 = 23;
                           }

                           var7.hn = var8;
                           return;
                        }

                        if (this.hn == 3) {
                           if (this.hp == 4) {
                              this.hp = this.hn - 1;
                              this.hn = 0;
                           }

                           return;
                        }

                        if (this.hn == 4) {
                           if (this.hp == 1) {
                              try {
                                 if (this.hV != null) {
                                    this.hV.stop();
                                    this.hV.close();
                                 }
                              } catch (Exception var5) {
                              }

                              this.aa();

                              try {
                                 this.ic.closeRecordStore();
                              } catch (Exception var4) {
                              }

                              Laboratory3D.a().destroyApp(false);
                           } else {
                              this.hn = 0;
                           }
                        }
                     }
                  }

                  if (this.hn == 4 && this.hp == 1) {
                     return;
                  }

                  this.U();
               } else if (this.hn == 3) {
                  if (this.hp == 4) {
                     return;
                  }

                  if (this.hp != 0) {
                     byte[] var10000;
                     byte var10002;
                     if (this.hS[this.hp] == 197) {
                        this.hS[this.hp] = 195;
                        var10000 = this.hT;
                        var10001 = this.hp;
                        var10002 = 23;
                     } else {
                        this.hS[this.hp] = 197;
                        var10000 = this.hT;
                        var10001 = this.hp;
                        var10002 = 24;
                     }

                     var10000[var10001] = var10002;
                  }

                  if (this.hp == 0 && this.ib) {
                     label260: {
                        if (this.gD == 52) {
                           if (this.hZ == 0) {
                              break label260;
                           }

                           var7 = this;
                           var10001 = this.hZ - 10;
                        } else {
                           if (this.hZ == 100) {
                              break label260;
                           }

                           if (this.hZ == 0) {
                              this.hZ += 10;
                              if (this.selectedMap != -1) {
                                 var7 = this;
                                 var10001 = this.selectedMap;
                              } else {
                                 var7 = this;
                                 var10001 = 0;
                              }

                              var7.C(var10001);
                              if (this.ib) {
                                 break label260;
                              }

                              var7 = this;
                              var10001 = 0;
                           } else {
                              var7 = this;
                              var10001 = this.hZ + 10;
                           }
                        }

                        var7.hZ = var10001;
                     }

                     if (this.hV != null) {
                        this.hW.setLevel(this.hZ);
                        if (this.hZ == 0) {
                           try {
                              this.hV.stop();
                           } catch (Exception var3) {
                           }
                        }
                     }
                  }

                  this.hB = true;
                  return;
               }
            }
         }

      }
   }

   private void U() {
      label14: {
         l3d_d var10000;
         int var10001;
         if (this.ho != 0) {
            this.hp = this.hr;
            var10000 = this;
            var10001 = this.hs;
         } else {
            this.hp = 0;
            this.hq = 1;
            if (this.hn != 4) {
               break label14;
            }

            this.hp = 1;
            var10000 = this;
            var10001 = 2;
         }

         var10000.hq = var10001;
      }

      this.hB = true;
   }

   private boolean V() {
      l3d_d var10000;
      int var10001;
      if (this.hn >= 6 && this.hn != 27 && this.hn != 10 && this.hn != 11 && this.hn != 28 && this.hn != 13 && this.hn != 14 && this.hn != 23) {
         if (this.hn != 8) {
            if (this.hn != 12) {
               var10000 = this;
               var10001 = this.hn + 1;
            } else {
               var10000 = this;
               var10001 = 28;
            }
         } else {
            var10000 = this;
            var10001 = 27;
         }

         var10000.hn = var10001;
         return true;
      } else {
         label61: {
            if (this.hn == 27) {
               this.hp = 0;
               var10000 = this;
               var10001 = 1;
            } else if (this.hn >= 9 && this.hn <= 10) {
               this.hp = 1;
               var10000 = this;
               var10001 = 2;
            } else if (this.hn == 11) {
               this.hp = 2;
               var10000 = this;
               var10001 = 3;
            } else {
               label54: {
                  if (this.hn == 28) {
                     var10000 = this;
                     var10001 = 3;
                  } else {
                     if (this.hn >= 14 && this.hn <= 18) {
                        this.hp = 4;
                        var10000 = this;
                        var10001 = 3;
                        break label54;
                     }

                     if (this.hn != 23) {
                        break label61;
                     }

                     var10000 = this;
                     var10001 = 5;
                  }

                  var10000.hp = var10001;
                  var10000 = this;
                  var10001 = 4;
               }
            }

            var10000.hq = var10001;
         }

         this.hn = 2;
         return false;
      }
   }

   private void W() {
      l3d_d var10000;
      boolean var10001;
      if (this.hT[1] == 23) {
         var10000 = this;
         var10001 = true;
      } else {
         var10000 = this;
         var10001 = false;
      }

      var10000.gj = var10001;
      byte var1;
      if (this.hT[2] == 23) {
         var10000 = this;
         var1 = 4;
      } else {
         var10000 = this;
         var1 = 1;
      }

      var10000.gb = var1;
      if (this.hT[3] == 23) {
         var10000 = this;
         var10001 = true;
      } else {
         var10000 = this;
         var10001 = false;
      }

      var10000.gi = var10001;
   }

   private void h(Graphics var1) {
      if (this.fN != 3) {
         d(var1);
         if (this.fN == 1) {
            if (this.hI == null) {
               this.P();
               Image var3 = this.readImage("/n" + this.dataExt);
               this.hy = var3.getWidth();
               this.hz = var3.getHeight();
               this.hN = new int[this.hy * this.hz];
               var3.getRGB(this.hN, 0, this.hy, 0, 0, this.hy, this.hz);
               this.hp = 0;
               this.hq = 7;
               this.D();
               this.hn = 0;
               this.hS = new short[4];
               this.hT = new byte[4];

               for(int var2 = 0; var2 < this.hS.length; ++var2) {
                  this.hS[var2] = 195;
                  this.hT[var2] = 23;
               }

               this.hS[0] = 197;
               this.hT[0] = 24;
               if (!this.gj) {
                  this.hS[1] = 197;
                  this.hT[1] = 24;
               }

               if (this.gb == 1) {
                  this.hS[2] = 197;
                  this.hT[2] = 24;
               }

               if (!this.gi) {
                  this.hS[3] = 197;
                  this.hT[3] = 24;
               }

               this.hB = true;
               this.hk = 0;
               this.C(0);
               this.selectedMap = -1;
               this.hj = System.currentTimeMillis();
            } else if (this.hG) {
               var1.drawRGB(this.hN, 0, this.hy, 240 - this.hy >> 1, (320 - this.hz >> 1) + this.hk, this.hy, this.hz, false);
            }
         } else if (this.fN == 4) {
            if (this.hG) {
               var1.drawRGB(this.hM, 6 * this.hw, this.hw, 240 - this.hw >> 1, (320 - this.hx >> 1) + this.hk, this.hw, this.hx - 6, false);
            }
         } else if (this.fN == 2) {
            if (this.hB) {
               if (this.hC || this.hq == 8) {
                  this.D();
               }

               d(var1);
               this.f(var1);
               this.hB = false;
            } else {
               this.f(var1);
            }
         }

         if (this.fN == 1 || this.fN == 2 || this.fN == 4) {
            this.b(0, (Graphics)var1);
         }

      }
   }

   private void X() {
      this.hQ = new int[320];
      this.hR = new int[320];

      for(int var1 = 0; var1 < 320; ++var1) {
         this.hQ[var1] = 7884880;
         this.hR[var1] = 3942440;
      }

   }

   private void b(int var1, Graphics var2) {
      var2.drawRGB(this.hQ, 0, 1, this.hl, var1, 1, 319 - (var1 << 1), false);
      var2.drawRGB(this.hR, 0, 1, this.hm, var1, 1, 319 - (var1 << 1), false);
      if (this.a() % this.c == 0) {
         this.a(var2);
      }

   }

   private void Y() {
      if (this.gD == 35 || this.gD == 42 || this.gl) {
         this.b(false);
         this.hp = 4;
         this.hq = 3;
         this.hB = true;
         this.hC = true;
         this.fN = 2;
         if (!this.gl) {
            this.hn = 0;
         } else {
            this.hn = 1;
            this.hp = 7;
            this.hA = 2;
            this.gd = false;
            this.gD = 53;
            this.ih = 10;
            this.gl = false;
            this.T();
         }

         this.eZ = (int[][])null;
         System.gc();
         this.eQ = true;
      }

   }

   private void a(boolean var1, Graphics var2) {
      try {
         Image var3 = this.readImage("/i" + this.dataExt);
         var2.drawImage(var3, 0, 0, 20);
         var2.drawImage(var3, 0, 212, 20);
         if (var1) {
            this.hJ = new int[2100];

            for(int var4 = 0; var4 < 10; ++var4) {
               var3.getRGB(this.hJ, var4 * 15 * 14, 15, var4 * 15, 108, 15, 14);
            }

            if (var1) {
               Image var6 = this.readImage("/ii" + this.dataExt);
               this.hK = new int[600];
               this.hL = new int[600];
               var6.getRGB(this.hK, 0, 24, 0, 0, 24, 25);
               var3.getRGB(this.hL, 0, 24, 156, 69, 24, 25);
            }
         }

      } catch (Exception var5) {
      }
   }

   private Image readImage(String var1) {
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

   private void C(int var1) {
      if (this.hZ != 0) {
         Runtime.getRuntime().totalMemory();
         this.ib = true;

         try {
            if (this.hV != null) {
               this.hV.stop();
               this.hV.close();
            }

            this.hX = null;
            this.hV = null;
            this.hX = this.getClass().getResourceAsStream("/" + this.hU[var1] + ".mid");
            this.hV = Manager.createPlayer(this.hX, "audio/midi");
            this.hV.realize();
            if (var1 != 10) {
               this.hV.setLoopCount(1000);
            }

            this.hW = (VolumeControl)((VolumeControl)this.hV.getControl("VolumeControl"));
            this.hW.setLevel(this.hZ);
            this.hV.start();
         } catch (Exception var5) {
            this.ib = false;
            this.hZ = 0;
         }
      }
   }

   private void Z() throws Exception {
      this.ic = RecordStore.openRecordStore("a1", true);
      int var1 = this.mapFiles.length;
      this.id = new int[var1];
      this.ie = new int[var1];
      this.if = new int[var1];
      this.ig = new int[var1];

      try {
         RecordEnumeration var2;
         if ((var2 = this.ic.enumerateRecords((RecordFilter)null, (RecordComparator)null, false)).numRecords() != 0) {
            byte[] var10 = var2.nextRecord();
            ByteArrayInputStream var11 = new ByteArrayInputStream(var10);
            DataInputStream var6 = new DataInputStream(var11);
            int var7 = this.id.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               this.id[var8] = var6.readInt();
               if (this.id[var8] != -1) {
                  ++this.ih;
               }

               this.ie[var8] = var6.readInt();
               this.if[var8] = var6.readInt();
               this.ig[var8] = var6.readInt();
            }

            this.hZ = var6.readInt();
            this.gj = var6.readBoolean();
            this.gb = var6.readByte();
            this.gi = var6.readBoolean();
            if (var6.readBoolean()) {
               this.ih = 10;
            }

         } else {
            this.ih = 0;
            int var4 = this.id.length;

            for(int var5 = 0; var5 < var4; ++var5) {
               this.id[var5] = -1;
               this.ie[var5] = -1;
               this.if[var5] = -1;
               this.ig[var5] = -1;
            }

            this.b.numColors();
            this.hZ = 50;
            this.gj = true;
            this.gb = 1;
            this.gi = true;
         }
      } catch (Exception var9) {
      }
   }

   private void aa() {
      try {
         RecordEnumeration var2;
         if ((var2 = this.ic.enumerateRecords((RecordFilter)null, (RecordComparator)null, false)).numRecords() != 0) {
            int var1 = var2.nextRecordId();
            this.ic.deleteRecord(var1);
         }

         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         DataOutputStream var5 = new DataOutputStream(var4);

         for(int var6 = 0; var6 < this.id.length; ++var6) {
            var5.writeInt(this.id[var6]);
            var5.writeInt(this.ie[var6]);
            var5.writeInt(this.if[var6]);
            var5.writeInt(this.ig[var6]);
         }

         var5.writeInt(this.hZ);
         var5.writeBoolean(this.gj);
         var5.writeByte(this.gb);
         var5.writeBoolean(this.gi);
         DataOutputStream var10000;
         boolean var10001;
         if (this.ih == 10) {
            var10000 = var5;
            var10001 = true;
         } else {
            var10000 = var5;
            var10001 = false;
         }

         var10000.writeBoolean(var10001);
         this.ic.addRecord(var4.toByteArray(), 0, var4.toByteArray().length);
      } catch (Exception var7) {
      }
   }

   static int[][] a(l3d_d var0) {
      return var0.dg;
   }

   static int[] b(l3d_d var0) {
      return var0.de;
   }

   static long[] c(l3d_d var0) {
      return var0.gn;
   }

   static int d(l3d_d var0) {
      return var0.gC;
   }

   static int e(l3d_d var0) {
      return var0.gD;
   }

   static boolean a(l3d_d var0, boolean var1) {
      return var0.gI = var1;
   }

   static int a(l3d_d var0, int var1) {
      return var0.gD = var1;
   }

   static int f(l3d_d var0) {
      return var0.fN;
   }

   static int b(l3d_d var0, int var1) {
      return var0.gC = var1;
   }

   static boolean g(l3d_d var0) {
      return var0.gI;
   }

   static void h(l3d_d var0) {
      var0.J();
   }

   static long a(l3d_d var0, long var1) {
      return var0.ff = var1;
   }

   static long b(l3d_d var0, long var1) {
      return var0.gN = var1;
   }

   static long i(l3d_d var0) {
      return var0.ff;
   }

   static long j(l3d_d var0) {
      return var0.gM;
   }

   static long c(l3d_d var0, long var1) {
      return var0.gM = var1;
   }

   static long k(l3d_d var0) {
      return var0.gN;
   }

   static long d(l3d_d var0, long var1) {
      return var0.cz = var1;
   }

   static long l(l3d_d var0) {
      return var0.cz;
   }

   static int c(l3d_d var0, int var1) {
      return var0.fE = var1;
   }

   static int d(l3d_d var0, int var1) {
      return var0.fC = var1;
   }

   static int e(l3d_d var0, int var1) {
      return var0.fD = var1;
   }

   static int m(l3d_d var0) {
      return var0.fE;
   }

   static int n(l3d_d var0) {
      return var0.fC;
   }

   static boolean o(l3d_d var0) {
      return var0.hD;
   }

   static long f(l3d_d var0, int var1) {
      return var0.cz >>= var1;
   }

   static long e(l3d_d var0, long var1) {
      return var0.cx = var1;
   }

   static long f(l3d_d var0, long var1) {
      return var0.cy = var1;
   }

   static long p(l3d_d var0) {
      return var0.cx;
   }

   static long g(l3d_d var0, long var1) {
      return var0.cA = var1;
   }

   static boolean q(l3d_d var0) {
      return var0.gm;
   }

   static boolean b(l3d_d var0, boolean var1) {
      return var0.gm = var1;
   }

   static boolean r(l3d_d var0) {
      return var0.gc;
   }

   static void s(l3d_d var0) {
      var0.O();
   }

   static int t(l3d_d var0) {
      return var0.hv;
   }

   static int u(l3d_d var0) {
      return var0.gE;
   }

   static long v(l3d_d var0) {
      return var0.gO;
   }

   static void w(l3d_d var0) {
      var0.I();
   }

   static long h(l3d_d var0, long var1) {
      return var0.gO = var1;
   }

   static int x(l3d_d var0) {
      return var0.gE++;
   }

   static int g(l3d_d var0, int var1) {
      return var0.gE = var1;
   }

   static void y(l3d_d var0) {
      var0.q();
   }

   static long z(l3d_d var0) {
      return var0.gT;
   }

   static void c(l3d_d var0, boolean var1) {
      var0.d(var1);
   }

   static long i(l3d_d var0, long var1) {
      return var0.gT = var1;
   }

   static void A(l3d_d var0) {
      var0.H();
   }

   static int B(l3d_d var0) {
      return var0.bV;
   }

   static int[][] C(l3d_d var0) {
      return var0.cc;
   }

   static long[] D(l3d_d var0) {
      return var0.gY;
   }

   static byte[] E(l3d_d var0) {
      return var0.cq;
   }

   static long F(l3d_d var0) {
      return var0.gQ;
   }

   static void G(l3d_d var0) {
      var0.S();
   }

   static long j(l3d_d var0, long var1) {
      return var0.gQ = var1;
   }

   static boolean H(l3d_d var0) {
      return var0.ez;
   }

   static long I(l3d_d var0) {
      return var0.gP;
   }

   static int J(l3d_d var0) {
      return var0.gH;
   }

   static void K(l3d_d var0) {
      var0.G();
   }

   static long k(l3d_d var0, long var1) {
      return var0.gP = var1;
   }

   static long L(l3d_d var0) {
      return var0.gV;
   }

   static boolean M(l3d_d var0) {
      return var0.gB;
   }

   static boolean d(l3d_d var0, boolean var1) {
      return var0.gc = var1;
   }

   static boolean e(l3d_d var0, boolean var1) {
      return var0.gk = var1;
   }

   static boolean N(l3d_d var0) {
      return var0.ex;
   }

   static boolean f(l3d_d var0, boolean var1) {
      return var0.ex = var1;
   }

   static Player O(l3d_d var0) {
      return var0.hV;
   }

   static long P(l3d_d var0) {
      return var0.fi;
   }

   static boolean g(l3d_d var0, boolean var1) {
      return var0.ge = var1;
   }

   static long Q(l3d_d var0) {
      return var0.fj;
   }

   static boolean h(l3d_d var0, boolean var1) {
      return var0.gf = var1;
   }

   static long R(l3d_d var0) {
      return var0.fk;
   }

   static boolean i(l3d_d var0, boolean var1) {
      return var0.gg = var1;
   }

   static int S(l3d_d var0) {
      return var0.eG;
   }

   static void T(l3d_d var0) {
      var0.l();
   }

   static boolean[] U(l3d_d var0) {
      return var0.gZ;
   }

   static long V(l3d_d var0) {
      return var0.fg;
   }

   static int h(l3d_d var0, int var1) {
      return var0.fB = var1;
   }

   static void W(l3d_d var0) {
      var0.y();
   }

   static void X(l3d_d var0) {
      var0.Y();
   }

   static int Y(l3d_d var0) {
      return var0.selectedMap;
   }

   static long Z(l3d_d var0) {
      return var0.gW;
   }

   static boolean aa(l3d_d var0) {
      return var0.gJ;
   }

   static void a(l3d_d var0, long var1, long var3, int var5) {
      var0.a(var1, var3, var5);
   }

   static int ab(l3d_d var0) {
      return var0.gF++;
   }

   static int ac(l3d_d var0) {
      return var0.gF;
   }

   static boolean j(l3d_d var0, boolean var1) {
      return var0.gJ = var1;
   }

   static int i(l3d_d var0, int var1) {
      return var0.gF = var1;
   }

   static long l(l3d_d var0, long var1) {
      return var0.gW = var1;
   }

   static int[][] ad(l3d_d var0) {
      return var0.cb;
   }

   static boolean ae(l3d_d var0) {
      return var0.gh;
   }

   static int j(l3d_d var0, int var1) {
      return var0.an = var1;
   }

   static int af(l3d_d var0) {
      return var0.fV;
   }

   static void ag(l3d_d var0) {
      var0.w();
   }

   static short ah(l3d_d var0) {
      return var0.fT;
   }

   static short ai(l3d_d var0) {
      return var0.fS;
   }

   static boolean k(l3d_d var0, boolean var1) {
      return var0.gh = var1;
   }

   static short a(l3d_d var0, short var1) {
      return var0.fT = var1;
   }

   static int aj(l3d_d var0) {
      return var0.eH;
   }

   static boolean l(l3d_d var0, boolean var1) {
      return var0.eU = var1;
   }

   static long ak(l3d_d var0) {
      return var0.fh;
   }

   static int k(l3d_d var0, int var1) {
      return var0.eL = var1;
   }

   static boolean al(l3d_d var0) {
      return var0.eU;
   }

   static void am(l3d_d var0) {
      var0.z();
   }

   static boolean an(l3d_d var0) {
      return var0.eR;
   }

   static boolean m(l3d_d var0, boolean var1) {
      return var0.eR = var1;
   }

   static boolean ao(l3d_d var0) {
      return var0.eV;
   }

   static void ap(l3d_d var0) {
      var0.v();
   }

   static void aq(l3d_d var0) {
      var0.x();
   }

   static void ar(l3d_d var0) {
      var0.K();
   }

   static boolean as(l3d_d var0) {
      return var0.eP;
   }

   static void a(l3d_d var0, int var1, int var2, int var3) {
      var0.b(var1, var2, var3);
   }

   static long m(l3d_d var0, long var1) {
      return var0.fh = var1;
   }

   static long at(l3d_d var0) {
      return var0.gS;
   }

   static void au(l3d_d var0) {
      var0.A();
   }

   static long n(l3d_d var0, long var1) {
      return var0.gS = var1;
   }

   static long av(l3d_d var0) {
      return var0.gU;
   }

   static long o(l3d_d var0, long var1) {
      return var0.gU = var1;
   }

   static long aw(l3d_d var0) {
      return var0.gX;
   }

   static boolean ax(l3d_d var0) {
      return var0.gK;
   }

   static int l(l3d_d var0, int var1) {
      return var0.gG += var1;
   }

   static int ay(l3d_d var0) {
      return var0.gG;
   }

   static int[] az(l3d_d var0) {
      return var0.eY;
   }

   static boolean n(l3d_d var0, boolean var1) {
      return var0.gK = var1;
   }

   static int m(l3d_d var0, int var1) {
      return var0.gG -= var1;
   }

   static int n(l3d_d var0, int var1) {
      return var0.eH = var1;
   }

   static int aA(l3d_d var0) {
      return var0.fr;
   }

   static boolean o(l3d_d var0, boolean var1) {
      return var0.eV = var1;
   }

   static void aB(l3d_d var0) {
      var0.N();
   }
}

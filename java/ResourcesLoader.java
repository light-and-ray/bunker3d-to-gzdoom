import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourcesLoader {
   public String ROOT_JAR = "../jars/b3d.d";
   public byte c;
   public boolean e;
   public int f = 10;
   public int g = 10;
   public int h = 10;
   public final short[] i = new short[]{1, 81, 161};
   public short[] unusedMapRawLump1;
   public short[] FOE_METADATA;       // i +   0  1  2  3  4  5  6
                                       // val   x  y  w  h
   public short[] l;
   public short[] m;
   public byte[] n;
   public byte[] o;
   public byte[] p;
   public byte[] q;
   public byte[] r;
   public byte[] s;
   public byte[] t;
   public byte[] u;
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
   public byte[][] loadedMap;
   public byte[] lumpsSizes = new byte[]{5, 72, 10, 8};
   public String dataExt = ".b3d";
   public String[] mapFiles = new String[]{"/d", "/b", "/o", "/x", "/m", "/t", "/g", "/y", "/l"};
   public byte[] z;
   public String[] spriteFiles = new String[]{"/p", "/r", "/pp", "/rr"};
   public byte[][] B = new byte[][]{{1, 1, -1, 1}, {-1, 1, -1, -1}, {-1, -1, 1, -1}, {1, -1, 1, 1}};
   public byte[][][][] E;
   public byte[][][] F;
   public int[] G;
   public int[] H;
   public int[] I;
   public byte J;
   public int K;
   public int L;
   public int[] M;
   public int[][] N;
   public int[] O;
   public int P;
   public int Q;
   public int BACKGROUND_COLOR;
   public int selectedMap;
   public boolean gB;
   public int[] bi;
   public int[][] cW;
   public byte[] by;
   public byte[] bz;
   public int eX;
   public byte[] cX;
   byte[] a;






   public ResourcesLoader() {
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

   public static short readShort(byte[] data, int offset) {
      return (short)(data[offset] & 255 | (data[offset + 1] & 255) << 8);
   }



   public void readMetadata() {
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


   public void loadMap() {
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

   public void a(short[] footer) {
      this.E = new byte[3][][][];
      this.loadMapPart((byte[])this.loadedMap[0], (byte[])this.loadedMap[1], (byte[])this.o, 0);
      this.loadMapPart((byte[])this.loadedMap[2], (byte[])this.loadedMap[3], (byte[])this.p, 1);
      this.modifyBigLumps01(this.E[0], this.E[1]);
      // this.modifyBigLump1(this.E[1]);
      if (!this.gB) {
         // this.loadMapPart((byte[])this.loadedMap[4], (byte[])this.loadedMap[5], (byte[])this.n, 2);
         // this.b(this.E[2]);
         // E[2][0] - palettes ?
         // this.readFoe(this.E[2]);
         // this.d(this.E[2]);
      }

      // this.loadedMap = (byte[][])null;
      // this.E[2] = (byte[][][])null;
      // this.c(false);
      // System.gc();
      // this.b(footer);
      // this.a(this.E[0], this.E[1], footer);
      // this.gf = false;
      // this.M();
      if (this.selectedMap == 9) {
         // this.b();
      }

      // this.eg = 0;
      // this.ee = false;
      // this.ef = 0;
   }



   public void loadMapPart(byte[] lumpA, byte[] lumpB, byte[] mapMetadata, int E_idx) {
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

   public void initMapArrays(int var1) {
      this.cW = new int[4][var1];
      this.by = new byte[var1];
   }

   public void modifyBigLumps01(byte[][][] bigLump0, byte[][][] bigLump1) {
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

}
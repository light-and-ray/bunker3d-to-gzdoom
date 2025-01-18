from tools import create1DList, create2DList
from drawMap import draw_lines


class BigLumpModifier:
    def __init__(self, metadata):
        self.B = [[1, 1, -1, 1], [-1, 1, -1, -1], [-1, -1, 1, -1], [1, -1, 1, 1]]
        self.a = metadata['a']
        self.dL = [0] * 91
        self.dL[1] = 1146
        var1 = 1146
        self.gB = False

        for var2 in range(2, 91):
            var1 += self.a[var2 - 2]
            self.dL[var2] = self.dL[var2 - 1] + var1


    def modifyBigLumps01(self, big_lump0, big_lump1):
        var3 = False
        lineSeqIdx = 0
        lineIdx = 0
        totalNumberOfLines = len(big_lump0[0]) + len(big_lump1[7]) + len(big_lump1[12]) * 4 + len(big_lump1[20]) * 3 + len(big_lump1[33]) * 4 + len(big_lump1[41]) * 4
        length = len(big_lump1[51]) + 1
        self.bi = [0] * length
        self.bi[0] = totalNumberOfLines

        for i in range(1, length):
            self.bi[i] = self.bi[i - 1] + big_lump1[51][i - 1][2]
            print('!!!', self.bi[i])

        totalNumberOfLines = self.bi[-1]
        self.initMapArrays(totalNumberOfLines)
        self.bz = [0] * totalNumberOfLines
        length = len(big_lump1[31])

        for i in range(length):
            self.bz[(big_lump1[31][i][0] + 128) & 0xFF] = big_lump1[31][i][1]

        length = len(big_lump0[0])
        var8 = len(big_lump1[7])

        for i in range(length):
            # start new line sequence
            # big_lump1[7] - starting points for sequences
            if lineSeqIdx < var8 and lineIdx == ((big_lump1[7][lineSeqIdx][0] + 128) & 0xFF):
                if lineSeqIdx!= 0:
                    self.cW[2][lineIdx - 1] = big_lump1[7][lineSeqIdx - 1][1]
                    self.cW[3][lineIdx - 1] = big_lump1[7][lineSeqIdx - 1][2]

                self.cW[0][lineIdx] = big_lump1[7][lineSeqIdx][1]
                self.cW[1][lineIdx] = big_lump1[7][lineSeqIdx][2]
                lineSeqIdx += 1
                lineIdx += 1

            var13 = big_lump0[0][i][0] - 7
            var15 = big_lump0[0][i][1] - 7
            self.cW[0][lineIdx] = int(var13 + self.cW[0][lineIdx - 1])
            self.cW[1][lineIdx] = int(var15 + self.cW[1][lineIdx - 1])
            self.cW[2][lineIdx - 1] = self.cW[0][lineIdx]
            self.cW[3][lineIdx - 1] = self.cW[1][lineIdx]
            lineIdx += 1

        self.cW[2][lineIdx - 1] = big_lump1[7][lineSeqIdx - 1][1]
        self.cW[3][lineIdx - 1] = big_lump1[7][lineSeqIdx - 1][2]

        for var18 in range(lineIdx):
            for i in range(4):
                self.cW[i][var18] <<= 16

        self.eX = lineIdx
        lineIdx = 0
        lineSeqIdx = 0
        self.cX = [0] * totalNumberOfLines
        length = len(big_lump0[1])
        var9 = len(big_lump1[7])
        var10 = len(big_lump1[10])

        for i in range(length):
            var8 = len(big_lump0[1][i])

            for var5 in range(var8):
                if lineSeqIdx < var9 and lineIdx == ((big_lump1[7][lineSeqIdx][0] + 128) & 0xFF):
                    if lineSeqIdx!= 0:
                        self.cX[lineIdx - 1] = big_lump1[7][lineSeqIdx - 1][4]

                    self.cX[lineIdx] = big_lump1[7][lineSeqIdx][3]
                    lineSeqIdx += 1
                    lineIdx += 1

                if big_lump0[1][i][var5] == 15:
                    var6 = 0
                    while var6 < var10:
                        if ((big_lump1[10][var6][0] + 128) & 0xFF) == lineIdx:
                            self.cX[lineIdx] = big_lump1[10][var6][1]
                            break
                        var6 += 1
                else:
                    self.cX[lineIdx] = big_lump0[1][i][var5]
                lineIdx += 1

        self.cX[lineIdx - 1 - big_lump1[8][0][4]] = big_lump1[7][lineSeqIdx - 1][4]
        length = len(big_lump0[2])

        for i in range(length):
            for var5 in range(5):
                if big_lump0[2][i][var5]!= 15:
                    if big_lump0[2][i][var5] == 7:
                        big_lump0[2][i][var5] = -7
                    elif big_lump0[2][i][var5]!= 0:
                        big_lump0[2][i][var5] = big_lump0[2][i][var5] - 7
                else:
                    for var6 in range(len(big_lump1[29])):
                        if big_lump1[29][var6][0] == i and big_lump1[29][var6][1] == var5:
                            big_lump0[2][i][var5] = big_lump1[29][var6][2]
                            break

        for i in range(length):
            var8 = len(big_lump0[2][i])

            for var5 in range(6, var8):
                big_lump0[2][i][var5] = big_lump0[2][i][var5] * 3

        length = len(big_lump0[3])

        for i in range(length):
            for var5 in range(1, 3):
                big_lump0[3][i][var5] = big_lump0[3][i][var5] * 3

        length = len(big_lump0[4])

        for i in range(length):
            var8 = len(big_lump0[4][i])

            for var5 in range(var8):
                big_lump0[4][i][var5] = big_lump0[4][i][var5] * 3


    def modifyBigLump1(self, bigLump1):
        self.cD = create2DList(7, 0)
        self.cE = create2DList(7, 0)
        self.fa = self.eX
        self.fb = self.fa + 4 * len(bigLump1[12])
        self.fc = self.fb + 3 * len(bigLump1[20])

        # SPRITE DECORATIONS (?)
        for var2 in range(7):
            var12 = len(bigLump1[var2]) + len(bigLump1[var2 + 13]) + len(bigLump1[var2 + 21]) + len(bigLump1[var2 + 42]) + len(bigLump1[var2 + 52])
            self.cD[var2] = create1DList(var12)
            self.cE[var2] = create1DList(var12)
            var10 = len(bigLump1[var2])
            var3 = 0
            while var3 < var10:
                self.cD[var2][var3] = (bigLump1[var2][var3][0] + 128) & 0xFF
                self.cE[var2][var3] = (bigLump1[var2][var3][1] + 128) & 0xFF
                var3 += 1

            var10 = len(bigLump1[var2 + 13]) + var3

            var6 = var3
            while var6 < var10:
                var13 = bigLump1[var2 + 13][var6 - var3][0]
                self.cD[var2][var6] = (self.fa + var13 * 4) & 0xFFFF
                self.cE[var2][var6] = (self.cD[var2][var6] + 3) & 0xFFFF
                var14 = bigLump1[12][var13][3] % 90
                if abs(var14) <= 3:
                    self.cE[var2][var6] = (self.cE[var2][var6] - abs(var14)) & 0xFFFF
                elif abs(var14) > 6:
                    var6 += 1
                    continue
                else:
                    self.cD[var2][var6] = (self.cD[var2][var6] + (abs(var14) - 3)) & 0xFFFF
                bigLump1[12][var13][3] = (bigLump1[12][var13][3] - var14) & 0xFF
                var6 += 1
            var10 = len(bigLump1[var2 + 21]) + var6

            var7 = var6
            while var7 < var10:
                self.cD[var2][var7] = (self.fb + abs(bigLump1[var2 + 21][var7 - var6][0]) % 60 * 3) & 0xFFFF
                self.cE[var2][var7] = (self.cD[var2][var7] + 2) & 0xFFFF
                if bigLump1[var2 + 21][var7 - var6][0] < 0:
                    self.cD[var2][var7] = (self.cD[var2][var7] + 2) & 0xFFFF
                elif bigLump1[var2 + 21][var7 - var6][0] < 60:
                    var7 += 1
                    continue
                else:
                    self.cE[var2][var7] = (self.cE[var2][var7] - 2) & 0xFFFF
                var7 += 1

            var10 = len(bigLump1[var2 + 42]) + var7

            var8 = var7
            while var8 < var10:
                var13 = bigLump1[var2 + 42][var8 - var7][0]
                self.cD[var2][var8] = (self.fc + var13 * 4) & 0xFFFF
                self.cE[var2][var8] = (self.cD[var2][var8] + 3) & 0xFFFF
                var14 = bigLump1[41][var13][2] % 90
                if abs(var14) <= 3:
                    self.cE[var2][var8] = (self.cE[var2][var8] - abs(var14)) & 0xFFFF
                elif abs(var14) > 6:
                    var8 += 1
                    continue
                else:
                    self.cD[var2][var8] = (self.cD[var2][var8] + (abs(var14) - 3)) & 0xFFFF
                bigLump1[41][var13][2] = (bigLump1[41][var13][2] - var14) & 0xFF
                var8 += 1

            var10 = len(bigLump1[var2 + 52]) + var8

            var9 = var8
            while var9 < var10:
                self.cD[var2][var9] = self.bi[bigLump1[var2 + 52][var9 - var8][0]]
                self.cE[var2][var9] = (self.bi[bigLump1[var2 + 52][var9 - var8][0] + 1] - 1) & 0xFFFF
                var9 += 1

        self.fillThisFields(bigLump1[8][0][0], bigLump1[8][0][1] * 75000, bigLump1[8][0][2] * 75000, bigLump1[8][0][3] * 2, bigLump1[8][0][7])
        self.cC = (16 + bigLump1[8][0][5]) & 0xFF
        self.cB = bigLump1[8][0][6]
        var12 = self.eX
        self.eY = len(bigLump1[12])
        var24 = 48 + self.eY
        self.cg = create1DList(var24)
        self.bT = create2DList(var24, 2)
        self.cm = [False] * var24
        self.cd = create1DList(var24)
        self.ch = create1DList(var24)
        var10 = len(bigLump1[12])

        for var3 in range(var10):
            var14 = ((128 + bigLump1[12][var3][0] & 0xFF) << 16 >> 2)
            var15 = ((128 + bigLump1[12][var3][1] & 0xFF) << 16 >> 2)
            var6 = 48 + var3
            self.bT[var6][0] = var14
            self.bT[var6][1] = var15
            self.cg[var6] = (self.cC - 1) & 0xFF
            self.cm[var6] = False
            self.cd[var6] = (self.cC + 2 + bigLump1[12][var3][4]) & 0xFF
            if bigLump1[12][var3][4] > 3:
                self.cd[var6] = (self.cd[var6] - 4) & 0xFF
                self.ch[var6] = 1
            var12 = self.modifyBigLump1_subfunction1(var14, var15, 16384, 16384, bigLump1[12][var3][3], var12, bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], bigLump1[12][var3][2], 1, 0)

        self.eZ = len(bigLump1[20])
        self.dp = create2DList(self.eZ, 2)
        self.dr = create1DList(self.eZ)
        self.ds = create1DList(self.eZ)
        self.dv = create1DList(self.eZ)
        self.dw = create1DList(self.eZ)
        self.dt = create1DList(self.eZ)
        self.dx = create1DList(self.eZ)
        self.dy = create1DList(self.eZ)
        self.dz = create1DList(self.eZ)
        self.dA = create1DList(self.eZ)
        self.dq = create2DList(self.eZ, 2)
        self.dB = create1DList(self.eZ)
        self.du = create1DList(self.eZ)
        var10 = len(bigLump1[20])

        for var3 in range(var10):
            self.dp[var3][0] = ((128 + bigLump1[20][var3][0] & 0xFF) << 16 >> 2)
            self.dp[var3][1] = ((128 + bigLump1[20][var3][1] & 0xFF) << 16 >> 2)
            if bigLump1[20][var3][2] * bigLump1[20][var3][3] >= 0:
                self.dr[var3] = 0
                self.ds[var3] = 1
            else:
                self.dr[var3] = 1
                self.ds[var3] = 0
            self.dv[var3] = (bigLump1[20][var3][2] << 16) // 127
            self.dw[var3] = (bigLump1[20][var3][3] << 16) // 127
            self.dt[var3] = bigLump1[59][var3][3]
            self.dz[var3] = 0
            self.dA[var3] = 6225920
            if self.dw[var3] > 0:
                self.dx[var3] = 65536
            else:
                self.dx[var3] = -65536
            self.dy[var3] = (self.dx[var3] - self.dw[var3]) // self.dt[var3]
            self.dq[var3][self.dr[var3]] = self.dp[var3][self.dr[var3]] + self.dx[var3]
            self.dq[var3][self.ds[var3]] = self.dp[var3][self.ds[var3]]
            self.dB[var3] = -1
            self.du[var3] = bigLump1[28][var3][0]
            if not self.gB or var3!= 0 and var3!= 1:
                var30 = bigLump1[59][var3][0]
                var31 = bigLump1[59][var3][1]
                var10003 = bigLump1[59][var3][2]
            else:
                var30 = 7
                var31 = bigLump1[59][var3][1]
                var10003 = 7
            self.modifyBigLump1_subfunction2(var30, var31, var10003, var12)
            self.modifyBigLump1_subfunction3(self.dp[var3], self.dv[var3], self.dx[var3], self.dr[var3], self.ds[var3], var12, 0)
            var12 = self.modifyBigLump1_subfunction3(self.dp[var3], self.dv[var3], self.dw[var3], self.dr[var3], self.ds[var3], var12, 1)

        self.eX = var12
        self.bA = create1DList(len(bigLump1[30]) * 7)
        self.bs = create1DList(32 + len(bigLump1[30]))
        var5 = 0
        var10 = len(bigLump1[30])

        for var3 in range(var10):
            self.bs[32 + var3] = 96
            var11 = len(bigLump1[30][var3])

            for var4 in range(var11):
                self.bA[var5] = bigLump1[30][var3][var4]
                var5 += 1

        var12 = self.eX
        var10 = len(bigLump1[41])

        for var3 in range(var10):
            var25 = ((128 + bigLump1[41][var3][0]) & 0xFF << 16 >> 2)
            var16 = ((128 + bigLump1[41][var3][1]) & 0xFF << 16 >> 2)
            var18 = (bigLump1[60][var3][0] << 16) // 42 // 2
            var20 = (bigLump1[60][var3][1] << 16) // 42 // 2
            var12 = self.modifyBigLump1_subfunction1(var25, var16, var18, var20, bigLump1[41][var3][2], var12, bigLump1[61][var3][0], bigLump1[61][var3][1], bigLump1[61][var3][2], bigLump1[61][var3][3], bigLump1[62][var3][0], bigLump1[62][var3][1])

        self.eX = var12
        self.fG = create2DList(2, 0)
        self.fH = create2DList(2, 0)
        self.fE = create2DList(2, 0)
        self.modifyBigLump1_subfunction4(0, 49, bigLump1)
        self.modifyBigLump1_subfunction4(1, 70, bigLump1)
        var12 = self.eX
        self.fd = var12
        var10 = len(bigLump1[51])

        for var3 in range(var10):
            var25 = ((128 + bigLump1[51][var3][0] & 0xFF) << 16 >> 2)
            var16 = ((128 + bigLump1[51][var3][1] & 0xFF) << 16 >> 2)
            var22 = (bigLump1[51][var3][3] << 16) // 60
            self.bh[var3] = bigLump1[51][var3][6]
            var12 = self.modifyBigLump1_subfunction5(var25, var16, bigLump1[51][var3][2], var22, var12, bigLump1[51][var3][4], bigLump1[51][var3][5], bigLump1[51][var3][7], bigLump1[51][var3][8])

        self.eX = var12
        self.ci = create2DList(7, 0)

        for var2 in range(63, 70):
            var10 = len(bigLump1[var2])
            var11 = len(bigLump1[var2 - 50])
            self.ci[var2 - 63] = create1DList(var10 + var11)

            for var3 in range(var10):
                self.ci[var2 - 63][var3] = bigLump1[var2][var3][0]

            var6 = var3

            for var3 in range(var11):
                self.ci[var2 - 63][var6] = (48 + bigLump1[var2 - 50][var3][0]) & 0xFF
                var6 += 1

    def fillThisFields(self, var1, var2, var4, var6, var7):
        self.fz = create1DList(2, default=0)
        self.fk = var1
        self.fz[0] = var2
        self.fz[1] = var4
        self.eR = var6
        self.eS = var7

    # some CRATES (work) + sth else (doesn't)
    def modifyBigLump1_subfunction1(self, var1, var3, var5, var7, var9, var10, var11, var12, var13, var14, var15, var16):
        var19 = 0

        for var18 in range(var10, var10 + 4):
            self.by[var18] = var15
            if var16 != 6:
                self.bz[var18] = var16

            for var17 in range(0, 4, 2):
                if var9 == 0:
                    self.cW[var17][var18] = int((self.B[var19][var17] * var7 + var1))
                    self.cW[var17 + 1][var18] = int((self.B[var19][var17 + 1] * var5 + var3))
                else:
                    self.cW[var17][var18] = int(((self.B[var19][var17] * var7 * self.s(var9) >> 16) -
                                                (self.B[var19][var17 + 1] * var5 * self.r(var9) >> 16) + var1))
                    self.cW[var17 + 1][var18] = int(((self.B[var19][var17] * var7 * self.r(var9) >> 16) +
                                                    (self.B[var19][var17 + 1] * var5 * self.s(var9) >> 16) + var3))

            var19 += 1

        self.cX[var10] = var11
        var18 = var10 + 1
        self.cX[var18] = var12
        var18 += 1
        self.cX[var18] = var13
        var18 += 1
        self.cX[var18] = var14
        if var16 == 6:
            self.bz[var18] = 3

        return var18 + 1

    def modifyBigLump1_subfunction2(self, var1, var2, var3, var4):
        self.cX[var4] = var1 & 0xFF
        var5 = var4 + 1
        self.cX[var5] = var2 & 0xFF
        var5 += 1
        self.cX[var5] = var3 & 0xFF
        self.bz[var5] = 3

    # DOORS (left horizontal work, other doesn't)
    def modifyBigLump1_subfunction3(self, var1, var2, var4, var6, var7, var8, var9):
        if var9 == 0:
            self.cW[var6][var8] = var1[var6]
            self.cW[var7][var8] = int((var1[var7] - (var2 >> 1)))
            self.cW[var6 + 2][var8] = int((var1[var6] + var4))
            self.cW[var7 + 2][var8] = int((var1[var7] - (var2 >> 1)))

        var10 = var8 + 1
        self.cW[var6][var10] = self.cW[var6 + 2][var10 - 1]
        self.cW[var7][var10] = self.cW[var7 + 2][var10 - 1]
        self.cW[var6 + 2][var10] = self.cW[var6][var10]
        self.cW[var7 + 2][var10] = int((self.cW[var7][var10 - 1] + var2))
        var10 += 1
        if var9 == 0:
            self.cW[var6][var10] = self.cW[var6 + 2][var10 - 1]
            self.cW[var7][var10] = self.cW[var7 + 2][var10 - 1]
            self.cW[var6 + 2][var10] = int((self.cW[var6][var10] - var4))
            self.cW[var7 + 2][var10] = self.cW[var7][var10]
        # draw_lines(self.cW)
        # input('PRESS ANY KEY')

        return var10 + 1

    def modifyBigLump1_subfunction4(self, var1, var2, var3):
        var4 = var2
        if var3[var2] and len(var3[var2]) != 0:
            var7 = len(var3[var2][0])
            self.fG[var1] = create1DList(var7, default=0)

            for var6 in range(var7):
                self.fG[var1][var6] = var3[var4][0][var6] & 0xFF

            if self.fG[var1][1] != self.fG[var1][2]:
                self.ff = 2
            else:
                self.ff = 1

            var8 = 128 if self.fG[var1][0] < 10 else 299
            var4 = var2 + 1
            self.fE[var1] = create1DList(len(var3[var4]), default=0)
            self.fH[var1] = create1DList(len(var3[var4]), default=0)
            var7 = len(var3[var4])

            for var5 in range(var7):
                self.fE[var1][var5] = (var3[var4][var5][0] + var8) & 0xFF
                self.fH[var1][var5] = 0

    def modifyBigLump1_subfunction5(self, var1, var3, var5, var6, var8, var9, var10, var11, var12):
        print('!!! modifyBigLump1_subfunction5')
        var15 = 360 // var5
        var14 = var12 * 4
        var13 = var8
        for var13 in range(var8, var8 + var5):
            self.cW[0][var13] = int((var6 * self.r(var14) >> 16) + var1)
            self.cW[1][var13] = int((var6 * self.s(var14) >> 16) + var3)
            var14 -= var15
            self.cW[2][var13] = int((var6 * self.r(var14) >> 16) + var1)
            self.cW[3][var13] = int((var6 * self.s(var14) >> 16) + var3)
            self.by[var13] = var10
            self.cX[var13] = var9
            self.bz[var13] = var11

        return var8 + var5

    def r(self, var1):
        if var1 < 0:
            return -self.r(-var1)
        elif var1 >= 90 and var1 < 180:
            return self.dL[180 - var1]
        elif var1 >= 180 and var1 < 270:
            return -self.dL[var1 - 180]
        elif var1 >= 270 and var1 < 360:
            return -self.dL[90 - (var1 - 270)]
        else:
            return self.r(var1 % 360) if var1 >= 360 else self.dL[var1]

    def s(self, var1):
        return self.r(90 - var1)

    def initMapArrays(self, var1):
        self.cW = [[0 for _ in range(var1)] for _ in range(4)]
        self.by = [0 for _ in range(var1)]

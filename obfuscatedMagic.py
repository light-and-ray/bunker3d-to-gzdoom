def q(var1):
    cW = [[0 for _ in range(var1)] for _ in range(4)]
    by = [0 for _ in range(var1)]
    return cW, by

# loads base geometry
def modifyBigLumps01(big_lump0, big_lump1):
    var3 = False
    var11 = 0
    var12 = 0
    var17 = len(big_lump0[0]) + len(big_lump1[7]) + len(big_lump1[12]) * 4 + len(big_lump1[20]) * 3 + len(big_lump1[33]) * 4 + len(big_lump1[41]) * 4

    length = len(big_lump1[51]) + 1
    bi = [0 for _ in range(length)]
    bi[0] = var17

    for i in range(1, length):
        bi[i] = bi[i - 1] + big_lump1[51][i - 1][2]

    var17 = bi[-1]
    cW, by = q(var17)
    bz = [0 for _ in range(var17)]

    for i in range(len(big_lump1[31])):
        bz[big_lump1[31][i][0] + 128] = big_lump1[31][i][1]

    length = len(big_lump0[0])
    var8 = len(big_lump1[7])

    for i in range(length):
        if var11 < var8 and var12 == big_lump1[7][var11][0] + 128:
            if var11!= 0:
                cW[2][var12 - 1] = big_lump1[7][var11 - 1][1]
                cW[3][var12 - 1] = big_lump1[7][var11 - 1][2]

            cW[0][var12] = big_lump1[7][var11][1]
            cW[1][var12] = big_lump1[7][var11][2]
            var11 += 1
            var12 += 1

        var13 = big_lump0[0][i][0] - 7
        var15 = big_lump0[0][i][1] - 7
        cW[0][var12] = int(var13 + cW[0][var12 - 1])
        cW[1][var12] = int(var15 + cW[1][var12 - 1])
        cW[2][var12 - 1] = cW[0][var12]
        cW[3][var12 - 1] = cW[1][var12]
        var12 += 1

    cW[2][var12 - 1] = big_lump1[7][var11 - 1][1]
    cW[3][var12 - 1] = big_lump1[7][var11 - 1][2]

    for var18 in range(var12):
        for i in range(4):
            cW[i][var18] <<= 16

    eX = var12
    var12 = 0
    var11 = 0
    cX = [0 for _ in range(var17)]
    length = len(big_lump0[1])
    var9 = len(big_lump1[7])
    var10 = len(big_lump1[10])

    for i in range(length):
        var8 = len(big_lump0[1][i])

        for var5 in range(var8):
            if var11 < var9 and var12 == big_lump1[7][var11][0] + 128:
                if var11!= 0:
                    cX[var12 - 1] = big_lump1[7][var11 - 1][4]

                cX[var12] = big_lump1[7][var11][3]
                var11 += 1
                var12 += 1

            if big_lump0[1][i][var5] == 15:
                var6 = 0
                while var6 < var10:
                    if big_lump1[10][var6][0] + 128 == var12:
                        cX[var12] = big_lump1[10][var6][1]
                        break
                    var6 += 1
            else:
                cX[var12] = big_lump0[1][i][var5]
            var12 += 1

    cX[var12 - 1 - big_lump1[8][0][4]] = big_lump1[7][var11 - 1][4]

    length = len(big_lump0[2])
    var8 = len(big_lump1[29])

    for i in range(length):
        for var5 in range(5):
            if big_lump0[2][i][var5]!= 15:
                if big_lump0[2][i][var5] == 7:
                    big_lump0[2][i][var5] = -7
                elif big_lump0[2][i][var5]!= 0:
                    big_lump0[2][i][var5] -= 7
            else:
                for var6 in range(var8):
                    if big_lump1[29][var6][0] == i and big_lump1[29][var6][1] == var5:
                        big_lump0[2][i][var5] = big_lump1[29][var6][2]
                        break

    for i in range(length):
        var8 = len(big_lump0[2][i])
        for var5 in range(6, var8):
            big_lump0[2][i][var5] *= 3

    length = len(big_lump0[3])

    for i in range(length):
        for var5 in range(1, 3):
            big_lump0[3][i][var5] *= 3

    length = len(big_lump0[4])

    for i in range(length):
        var8 = len(big_lump0[4][i])
        for var5 in range(var8):
            big_lump0[4][i][var5] *= 3

    return cW, by, bi, bz, cX, eX



class BigLumpModifier:
    def __init__(self, metadata):
        self.B = [[1, 1, -1, 1], [-1, 1, -1, -1], [-1, -1, 1, -1], [1, -1, 1, 1]]
        self.a = metadata['a']
        self.dL = [0] * 91
        self.dL[1] = 1146
        var1 = 1146

        for var2 in range(2, 91):
            var1 += self.a[var2 - 2]
            self.dL[var2] = self.dL[var2 - 1] + var1

    def modify_big_lumps01(self, big_lump0, big_lump1):
        var3 = False
        var11 = 0
        var12 = 0
        var17 = len(big_lump0[0]) + len(big_lump1[7]) + len(big_lump1[12]) * 4 + len(big_lump1[20]) * 3 + len(big_lump1[33]) * 4 + len(big_lump1[41]) * 4
        length = len(big_lump1[51]) + 1
        self.bi = [0] * length
        self.bi[0] = var17

        for i in range(1, length):
            self.bi[i] = self.bi[i - 1] + big_lump1[51][i - 1][2]

        var17 = self.bi[-1]
        self.q(var17)
        self.bz = [0] * var17
        length = len(big_lump1[31])

        for i in range(length):
            self.bz[big_lump1[31][i][0] + 128] = big_lump1[31][i][1]

        length = len(big_lump0[0])
        var8 = len(big_lump1[7])

        for i in range(length):
            if var11 < var8 and var12 == big_lump1[7][var11][0] + 128:
                if var11!= 0:
                    self.cW[2][var12 - 1] = big_lump1[7][var11 - 1][1]
                    self.cW[3][var12 - 1] = big_lump1[7][var11 - 1][2]

                self.cW[0][var12] = big_lump1[7][var11][1]
                self.cW[1][var12] = big_lump1[7][var11][2]
                var11 += 1
                var12 += 1

            var13 = big_lump0[0][i][0] - 7
            var15 = big_lump0[0][i][1] - 7
            self.cW[0][var12] = int(var13 + self.cW[0][var12 - 1])
            self.cW[1][var12] = int(var15 + self.cW[1][var12 - 1])
            self.cW[2][var12 - 1] = self.cW[0][var12]
            self.cW[3][var12 - 1] = self.cW[1][var12]
            var12 += 1

        self.cW[2][var12 - 1] = big_lump1[7][var11 - 1][1]
        self.cW[3][var12 - 1] = big_lump1[7][var11 - 1][2]

        for var18 in range(var12):
            for i in range(4):
                self.cW[i][var18] <<= 16

        self.eX = var12
        var12 = 0
        var11 = 0
        self.cX = [0] * var17
        length = len(big_lump0[1])
        var9 = len(big_lump1[7])
        var10 = len(big_lump1[10])

        for i in range(length):
            var8 = len(big_lump0[1][i])

            for var5 in range(var8):
                if var11 < var9 and var12 == big_lump1[7][var11][0] + 128:
                    if var11!= 0:
                        self.cX[var12 - 1] = big_lump1[7][var11 - 1][4]

                    self.cX[var12] = big_lump1[7][var11][3]
                    var11 += 1
                    var12 += 1

                if big_lump0[1][i][var5] == 15:
                    var6 = 0
                    while var6 < var10:
                        if big_lump1[10][var6][0] + 128 == var12:
                            self.cX[var12] = big_lump1[10][var6][1]
                            break
                        var6 += 1
                else:
                    self.cX[var12] = big_lump0[1][i][var5]
                var12 += 1

        self.cX[var12 - 1 - big_lump1[8][0][4]] = big_lump1[7][var11 - 1][4]
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

    def modify_big_lump1(self, big_lump1):
        # Initialize class fields
        self.cD = [[0 for _ in range(7)] for _ in range(7)]
        self.cE = [[0 for _ in range(7)] for _ in range(7)]
        self.fa = self.eX
        self.fb = self.fa + 4 * len(big_lump1[12])
        self.fc = self.fb + 3 * len(big_lump1[20])

        # Initialize important data
        important_data = {
            'cD': [],
            'cE': [],
            'fa': self.fa,
            'fb': self.fb,
            'fc': self.fc,
            'eX': self.eX,
            'eY': len(big_lump1[12]),
            'eZ': len(big_lump1[20]),
            'bA': [],
            'bs': [],
            'fG': [],
            'fH': [],
            'fE': [],
            'fd': self.eX,
            'bh': [],
            'ci': []
        }

        # Call subfunctions
        for var2 in range(7):
            var12 = len(big_lump1[var2]) + len(big_lump1[var2 + 13]) + len(big_lump1[var2 + 21]) + len(big_lump1[var2 + 42]) + len(big_lump1[var2 + 52])
            self.cD[var2] = [0 for _ in range(var12)]
            self.cE[var2] = [0 for _ in range(var12)]
            important_data['cD'].append(self.cD[var2])
            important_data['cE'].append(self.cE[var2])

        self.fill_this_fields(big_lump1[8][0][0], big_lump1[8][0][1] * 75000, big_lump1[8][0][2] * 75000, big_lump1[8][0][3] * 2, big_lump1[8][0][7])

        var12 = self.eX
        important_data['eY'] = len(big_lump1[12])
        important_data['eZ'] = len(big_lump1[20])

        # Call subfunction 1
        for var3 in range(len(big_lump1[12])):
            var14 = 128 + big_lump1[12][var3][0] << 16 >> 2
            var15 = 128 + big_lump1[12][var3][1] << 16 >> 2
            var6 = 48 + var3
            var12 = self.modify_big_lump1_subfunction1(var14, var15, 16384, 16384, big_lump1[12][var3][3], var12, big_lump1[12][var3][2], big_lump1[12][var3][2], big_lump1[12][var3][2], big_lump1[12][var3][2], 1, 0)

        self.eZ = len(big_lump1[20])
        self.dr = [None] * self.eZ
        self.ds = [None] * self.eZ
        self.dv = [None] * self.eZ
        self.dw = [None] * self.eZ
        self.dt = [None] * self.eZ
        self.dz = [None] * self.eZ
        self.dA = [None] * self.eZ
        self.dx = [None] * self.eZ
        self.dy = [None] * self.eZ
        self.dp = [[None] * 2] * self.eZ
        self.dq = [[None] * 2] * self.eZ
        self.dB = [None] * self.eZ
        self.du = [None] * self.eZ


        # Call subfunction 2 and 3
        for var3 in range(len(big_lump1[20])):
            self.dp[var3][0] = 128 + big_lump1[20][var3][0] << 16 >> 2
            self.dp[var3][1] = 128 + big_lump1[20][var3][1] << 16 >> 2
            var28 = big_lump1[20][var3][2] * big_lump1[20][var3][3]
            if var28 >= 0:
                self.dr[var3] = 0
                self.ds[var3] = 1
            else:
                self.dr[var3] = 1
                self.ds[var3] = 0

            self.dv[var3] = (big_lump1[20][var3][2] << 16) // 127
            self.dw[var3] = (big_lump1[20][var3][3] << 16) // 127
            self.dt[var3] = big_lump1[59][var3][3]
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
            self.du[var3] = big_lump1[28][var3][0]
            self.modify_big_lump1_subfunction2(big_lump1[59][var3][0], big_lump1[59][var3][1], big_lump1[59][var3][2], var12)
            var12 = self.modify_big_lump1_subfunction3(self.dp[var3], self.dv[var3], self.dx[var3], self.dr[var3], self.ds[var3], var12, 0)
            var12 = self.modify_big_lump1_subfunction3(self.dp[var3], self.dv[var3], self.dw[var3], self.dr[var3], self.ds[var3], var12, 1)

        # important_data['bA'] = self.bA
        # important_data['bs'] = self.bs
        self.fG = [[], []]
        self.fE = [[], []]
        self.fH = [[], []]
        important_data['fG'] = self.fG
        important_data['fH'] = self.fH
        important_data['fE'] = self.fE

        # Call subfunction 4
        self.modify_big_lump1_subfunction4(0, 49, big_lump1)
        self.modify_big_lump1_subfunction4(1, 70, big_lump1)

        important_data['fd'] = self.eX
        # important_data['bh'] = self.bh

        # Call subfunction 5
        for var3 in range(len(big_lump1[51])):
            var25 = (128 + big_lump1[51][var3][0] << 16 >> 2)
            var16 = (128 + big_lump1[51][var3][1] << 16 >> 2)
            var22 = (big_lump1[51][var3][3] << 16) // 60
            self.bh[var3] = big_lump1[51][var3][6]
            var12 = self.modify_big_lump1_subfunction5(var25, var16, big_lump1[51][var3][2], var22, var12, big_lump1[51][var3][4], big_lump1[51][var3][5], big_lump1[51][var3][7], big_lump1[51][var3][8])

        # important_data['ci'] = self.ci

        return important_data


    def fill_this_fields(self, var1, var2, var4, var6, var7):
        self.fz = [0, 0]
        self.fk = var1
        self.fz[0] = var2
        self.fz[1] = var4
        self.eR = var6
        self.eS = var7

    def modify_big_lump1_subfunction1(self, var1, var3, var5, var7, var9, var10, var11, var12, var13, var14, var15, var16):
        var19 = 0
        for var18 in range(var10, var10 + 4):
            self.by[var18] = var15
            if var16!= 6:
                self.bz[var18] = var16
            for var17 in range(0, 4, 2):
                if var9 == 0:
                    self.cW[var17][var18] = int((self.B[var19][var17] * var7) + var1)
                    self.cW[var17 + 1][var18] = int((self.B[var19][var17 + 1] * var5) + var3)
                else:
                    self.cW[var17][var18] = int(((self.B[var19][var17] * var7 * self.s(var9)) >> 16) - ((self.B[var19][var17 + 1] * var5 * self.r(var9)) >> 16) + var1)
                    self.cW[var17 + 1][var18] = int(((self.B[var19][var17] * var7 * self.r(var9)) >> 16) + ((self.B[var19][var17 + 1] * var5 * self.s(var9)) >> 16))
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

    def modify_big_lump1_subfunction2(self, var1, var2, var3, var4):
        self.cX[var4] = var1
        var5 = var4 + 1
        self.cX[var5] = var2
        var5 += 1
        self.cX[var5] = var3
        self.bz[var5] = 3

    def modify_big_lump1_subfunction3(self, var1, var2, var4, var6, var7, var8, var9):
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
        return var10 + 1

    def modify_big_lump1_subfunction4(self, var1, var2, var3):
        var4 = var2
        if len(var3[var2])!= 0:
            var7 = len(var3[var2][0])
            self.fG[var1] = [0] * var7
            for var6 in range(var7):
                self.fG[var1][var6] = var3[var4][0][var6]
            if self.fG[var1][1]!= self.fG[var1][2]:
                self.ff = 2
            else:
                self.ff = 1
            var8 = self.fG[var1][0] < 10 and 128 or 299
            var4 = var2 + 1
            self.fE[var1] = [0] * len(var3[var4])
            self.fH[var1] = [0] * len(var3[var4])
            var7 = len(var3[var4])
            for var5 in range(var7):
                self.fE[var1][var5] = (var3[var4][var5][0] + var8)
                self.fH[var1][var5] = 0

    def modify_big_lump1_subfunction5(self, var1, var3, var5, var6, var8, var9, var10, var11, var12):
        var15 = 360 // var5
        var14 = var12 * 4
        for var13 in range(var8, var8 + var5):
            self.cW[0][var13] = int(((var6 * self.r(var14)) >> 16) + var1)
            self.cW[1][var13] = int(((var6 * self.s(var14)) >> 16) + var3)
            var14 -= var15
            self.cW[2][var13] = int(((var6 * self.r(var14)) >> 16) + var1)
            self.cW[3][var13] = int(((var6 * self.s(var14)) >> 16) + var3)
            self.by[var13] = var10
            self.cX[var13] = var9
            self.bz[var13] = var11
        return var13

    def q(self, var1):
        self.cW = [[0 for _ in range(var1)] for _ in range(4)]
        self.by = [0 for _ in range(var1)]

    def r(self, var1):
        if var1 < 0:
            return -self.r(-var1)
        elif 90 <= var1 < 180:
            return self.dL[180 - var1]
        elif 180 <= var1 < 270:
            return -self.dL[var1 - 180]
        elif 270 <= var1 < 360:
            return -self.dL[90 - (var1 - 270)]
        else:
            return self.r(var1 % 360) if var1 >= 360 else self.dL[var1]

    def s(self, var1):
        return self.r(90 - var1)
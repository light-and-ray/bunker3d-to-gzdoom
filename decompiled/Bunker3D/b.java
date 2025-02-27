// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.TimerTask;

final class b extends TimerTask {
   private final b3d_a a;

   private b(b3d_a var1) {
      this.a = var1;
   }

   public final void run() {
      a.a(this.a, a.d(this.a));
      if (a.e(this.a) != a.f(this.a) && a.f(this.a) != -10000) {
         a.a(this.a, true);
      } else {
         a.a(this.a, false);
      }

      a.b(this.a, a.f(this.a));
      if (a.g(this.a) != 3) {
         a.c(this.a, -10000);
      }

      if (a.h(this.a)) {
         a.i(this.a);
      }

      a.a(this.a, System.currentTimeMillis());
      a.b(this.a, a.j(this.a) - a.k(this.a));
      a.c(this.a, a.j(this.a));
      if (a.l(this.a) != 0L) {
         a.d(this.a, a.l(this.a) * 200L);
      } else {
         a.d(this.a, 3000L);
      }

      if (a.m(this.a) < 3000L) {
         a.d(this.a, 3000L);
      } else if (a.m(this.a) > 20000L) {
         a.d(this.a, 20000L);
      }

      if (a.n(this.a)) {
         a.d(this.a, 1);
      }

      a.d(this.a, a.m(this.a) * 75000L >> 16);
      a.e(this.a, a.m(this.a));
      a.f(this.a, -a.o(this.a));
      a.g(this.a, -a.m(this.a));
      if (a.p(this.a)) {
         a.b(this.a, false);
      } else if (a.n(this.a) && !a.q(this.a)) {
         a.r(this.a);
         if (a.j(this.a) - a.s(this.a) > 50L) {
            a.t(this.a);
            a.h(this.a, a.j(this.a));
         }
      } else if (a.g(this.a) != 3) {
         if (a.j(this.a) - a.u(this.a) > 30L) {
            a.v(this.a);
            a.i(this.a, a.j(this.a));
         }
      } else if (a.w(this.a)) {
         if (a.j(this.a) - a.x(this.a) > 30L) {
            a.y(this.a);
            a.j(this.a, a.j(this.a));
            if (a.j(this.a) - a.z(this.a) > 8000L && a.A(this.a)) {
               a.c(this.a, true);
               a.d(this.a, true);

               try {
                  if (a.B(this.a) != null) {
                     a.B(this.a).stop();
                  }
               } catch (Exception var2) {
               }
            }
         }
      } else if (!a.q(this.a)) {
         if (a.j(this.a) - a.C(this.a) > 3000L) {
            a.e(this.a, false);
         }

         if (a.j(this.a) - a.D(this.a) > 3000L) {
            a.f(this.a, false);
         }

         if (a.E(this.a) > 4) {
            a.F(this.a);
         }

         if ((a.G(this.a)[4] || a.G(this.a)[6]) && a.j(this.a) - a.H(this.a) > 500L) {
            a.e(this.a, a.I(this.a));
         }

         a.J(this.a);
         a.K(this.a);
         a.L(this.a);
         if (a.M(this.a) != 1 && a.M(this.a) != 7) {
            if (a.M(this.a) == 9 && a.j(this.a) - a.s(this.a) > 100L) {
               a.t(this.a);
               a.h(this.a, a.j(this.a));
            }
         } else if (a.j(this.a) - a.s(this.a) > 50L) {
            a.t(this.a);
            a.h(this.a, a.j(this.a));
         }

         if (a.j(this.a) - a.N(this.a) > 100L) {
            if (a.G(this.a)[5]) {
               a.f(this.a, 53);
            } else if ((a.G(this.a)[1] || a.G(this.a)[2] || a.G(this.a)[3] || a.G(this.a)[8]) && !a.G(this.a)[0]) {
               a.f(this.a, 49);
            } else {
               a.f(this.a, -10000);
            }

            a.O(this.a);
            if (a.P(this.a) == 1) {
               if (a.Q(this.a)) {
                  a.g(this.a, false);
               } else {
                  a.g(this.a, true);
               }
            }

            a.R(this.a);
            a.S(this.a);
            a.T(this.a);
            if (!a.n(this.a) && !a.U(this.a) && (a.G(this.a)[1] || a.G(this.a)[2] || a.G(this.a)[3] || a.G(this.a)[8])) {
               a.a(this.a, 2, 2, 3);
            }

            a.k(this.a, a.j(this.a));
         }

         if (a.j(this.a) - a.V(this.a) > 50L) {
            a.W(this.a);
            a.l(this.a, a.j(this.a));
         }

         if (a.j(this.a) - a.X(this.a) > 75L) {
            a.h(this.a, true);
            a.m(this.a, a.j(this.a));
         }

         if (a.j(this.a) - a.Y(this.a) > 100L) {
            a.h(this.a, false);
            a.n(this.a, a.j(this.a));
         }
      }

      a.Z(this.a);
      this.a.repaint();
   }

   b(b3d_a var1, c var2) {
      this(var1);
   }
}

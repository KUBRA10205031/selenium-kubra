package Day1_SeleniumMaven;

import org.junit.*;

public class C02_JunitAnnotations {


     /*
     1.test
     2.test
     3.test
     4.test ( geliştirme aşamasında bu yüzden rapora dahil olmasın)

     -->> Her testimizden önce ve sonra çalışması gereken kod bloklarımız (methodlarımız) mevcut
      -->> Tüm testlerin öncesinde ve sonrasında çalışması gereken methodlarımız mevcut.
      */


        //   1.  @Test   : Marks a method as a TEST CASE.
        //   2.  @Before : Runs before EACH @Test annotation.
        //   3.  @After  : Runs after EACH @Test annotation.
        //   4.  @BeforeClass : Runs before each class only once.
        //   5.  @AfterClass : Runs after each class only once.
        //   6.  @Ignore  : Skipping a test case.

        @Test  //main methoduna benzer methodlarımızı çalıştırmaya yarar.
        public void test01(){
            System.out.println("1. Test yapılıyor...");

        }
        @Test
        public void test02(){
            System.out.println("2. Test yapılıyor...");
        }
        @Test
        public void test03(){
            System.out.println("3. Test yapılıyor...");
        }

        @Test
        @Ignore
        public void test04(){
            System.out.println("4. Test geliştirme aşamasında ...");
        }

        @Before
        public void beforEach(){
            System.out.println("method öncesi kod blogu çalıştı.");
        }

        @After
        public void afterEach(){
            System.out.println("method sonrası kod blogu çalıştı.");
        }

        @BeforeClass
        public static void beforeAll(){
            System.out.println("methodların öncesindeki kod blogu çalıştı.");
        }

        @AfterClass
        public static void afterAll(){
            System.out.println("methodların sonrasındaki kod blogu çalıştı.");
        }





















    }


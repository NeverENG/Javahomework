
package homework1;

class complex{
    double Imaginary;
    double Real;

    public complex(double r, double i){
        Real = r;
        Imaginary = i;
    }

    public complex add(complex c){
        complex temp = new complex(0.0,0.0);
        temp.Real = this.Real + c.Real;
        temp.Imaginary = this.Imaginary + c.Imaginary;
        return temp;
    }

    public complex subtract(complex c){
        complex temp = new complex(0.0,0.0);
        temp.Real = this.Real - c.Real;
        temp.Imaginary = this.Imaginary - c.Imaginary;
        return temp;
    }

    public static void main(String[] args){
        complex Complex1 = new complex(2.0,3.0);
        complex Complex2 = new complex(1.0,2.0);
        complex Complex3 = Complex1.add(Complex2);
        System.out.println(Complex3.Real+Complex3.Imaginary);
        complex Complex4 = Complex1.subtract(Complex2);
        System.out.println(Complex4.Real+Complex4.Imaginary);
    }
}
package btLyThuyet.interfaceInJava;

public class PhanMenMayTinh implements MayTinhBoTui, SapXep{

    // May Tinh Bo Tui

    @Override
    public double cong(double a, double b) {
        return a + b;
    }

    @Override
    public double tru(double a, double b) {
        return a - b;
    }

    @Override
    public double nhan(double a, double b) {
        return a * b;
    }

    @Override
    public double chia(double a, double b) {
        return a / b;
    }

    // Sap Xep


    @Override
    public void sapXepTang(double[] arr) {
        int n = arr.length;
        double key;
        int i, j;
        for (i = 1; i < n; i++)
        {
            key = arr[i];
            j = i-1;

       /* Di chuyển các phần tử có giá trị lớn hơn giá trị
       key về sau một vị trí so với vị trí ban đầu
       của nó */
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    @Override
    public void sapXepGiam(double[] arr) {
        int n = arr.length;
        double key;
        int i, j;
        for (i = 1; i < n; i++)
        {
            key = arr[i];
            j = i-1;

       /* Di chuyển các phần tử có giá trị lớn hơn giá trị
       key về sau một vị trí so với vị trí ban đầu
       của nó */
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }
}

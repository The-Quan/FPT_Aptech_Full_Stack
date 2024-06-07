using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex3
{
    public class Window
    {
        protected int top{ set; get;}
        protected int left{ set; get;}
        // hàm tạo lấy hai số nguyên để
        //sửa vị trí trên bảng điều khiển
        public Window(int top, int left){
            this.top = top;
            this.left = left;
        }
        public virtual void DrawWindow(){
            Console.WriteLine("Window: drawing window at {0} {1}", top,left);
        }
        //những thành viên này được bảo vệ và do đó có thể nhìn thấy được
        //đến các phương thức của lớp dẫn xuất. Chúng tôi sẽ kiểm tra điều này
        //ở phần sau của chương
    }
}
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;

namespace Ex3
{
    public class Button : Window
    {
        public Button(int top, int left) : base(top, left)
        {
        }
        //một phiên bản bị ghi đè (từ khóa ghi chú) vì trong
        //phương pháp dẫn xuất chúng tôi thay đổi hành vi
        public override void DrawWindow()
        {
          Console.WriteLine("Drawing a button at {0}, {1}\n", top,left);
        }
    }
}
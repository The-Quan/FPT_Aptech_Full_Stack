using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ex3
{
    public class ListBox : Window
    {
        private string listBoxContents;
        public ListBox(int top, int left, string contents) : base(top, left)
        { // hàm tạo cơ sở cuộc gọi
            listBoxContents = contents;
        }
        //một phiên bản bị ghi đè (từ khóa ghi chú) vì trong
        //phương pháp dẫn xuất chúng tôi thay đổi hành vi
        public override void DrawWindow()
        {
            base.DrawWindow(); //gọi phương thức cơ bản\
            Console.WriteLine("Wriring string to the listBox: {0}" , listBoxContents);
        }
    }
}
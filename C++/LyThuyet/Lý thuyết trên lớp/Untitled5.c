#include <stdio.h>
int main()
{
	int ary[5];//ary [0],ary[1],ary[2],ary[3],ary[4]
	//ten cua mang chinh la dia chi 
	ary[2]=20; 
	printf("dia chi cua mang : %d",&ary[0]);
	printf("\ndia chi cua mang : %d\n", &ary+0);
	printf("dia chi cua mang 1: %d",&ary[1]);
	printf("\ndia chi cua mang 2: %d\n", &ary+1);
	printf("gia tri thu hai cua mang: %d\n",ary[2]);
	printf("gia tri cua ot mang: %d",*(ary+2));
		return 0;
	// su dung mang nhu con tro hoac nguoc lai 
 } 

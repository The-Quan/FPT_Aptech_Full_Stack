#include<stdio.h>
int main(){
	int *prt;//day la 1 mang dong
	int i,n;
	//con tro co the cap phat bo nho "dong"(theo nhu cau su dung)
	ptr = (int*)malloc(n*sizeof(int));//cap phat n phan tu mang
	
	//gia trij=
	//con tro           mang
	//*(ptr +0) <=> ptr[0]
	//*(ptr+4) <=> ptr[4]
	ptintf("\n ban muon luu bao nhieu pt mang: ");
	scanf("%d",&n);
	ptr = (int*)malloc(n*sizeo(int));
	for (i=0;i<n;i++){
		scanf("%d",&ptr[i]);//con tro: scanf("%d",prt+i)
	}
	for (i=0;i<n;i++){
		printf("\ngia tri pt mang thu %d la: %d",i+1,ptr[i];//*(ptr+i)
	}
	//dia chi 
	//con tro      mang
	//ptr +0  <=> &ptr[0]
	//ptr +1  <=> &ptr[1]
	//ptr+2 <=> &ptr[2]
	
	int ary[5];//arry
	*(ary+0);//pointer
	//dia chi
	&ary[0];
	ary +0;
	=> mang la hang con tro 
	return  0;
}

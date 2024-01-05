#include<stdio.h>
int main(){
	int *prt;
	int n,i;
		ptr  = (int*)malloc(n*sizeof(int));
	ptintf("\n ban muon luu bao nhieu pt mang: ");
	scanf("%d",&n);

	printf("\n nhap gia tri %d pt mang: ")
	for (i=0;i<n;i++){
		scanf("%d",&ptr[i]);//con tro: scanf("%d",prt+i)
	}
	for (i=0;i<n;i++){
		printf("\ngia tri pt mang thu %d la: %d",i+1,ptr[i];//*(ptr+i)
	}
	return 0;
}

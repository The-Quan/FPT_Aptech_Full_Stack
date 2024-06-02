using System;
class ReferenceType{
    public int valueVal;
}

class TestReferenceType{
    static void Test(ReferenceType referenceType){
        int temp = 0;
        referenceType.valueVal = temp * 2;
    }
    static void Main(string[] args){
        ReferenceType type = new ReferenceType();
        type.valueVal = 5;
        Test(type);
        Console.WriteLine("the value of the variable is {0}", type.valueVal);
    }
    
}
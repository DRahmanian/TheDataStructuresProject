// CS311 Yoshii Complete all functions with their comments

// ====================================================
//HW#: HW3P1 slist  inheriting from llist
//Your name: Darius Rahmanian
//Complier:  g++
//File type: slist.cpp implementation file
//=====================================================

using namespace std;
#include<iostream>
#include"slist.h" 

// ** Make sure llist constructor and destructors have couts in them



// do not change this one
slist::slist()
{ cout << "slist constructor:" << endl;}


// positions always start at 1
//The search method iterates through the list until the key value is found, if it is not, return 0
//internal test displays "not found" when indicated key element has not been found within the list
int slist::search(el_t key){
    Node* p = Front;
    int elemNum = 1;
    while (p != NULL) {
        if (p->Elem == key)
            return elemNum;
        else 
            cout << "-not found" << endl;
            
     
         p = p->Next;
        elemNum++;
    }
    return 0;
}

// don't forget to throw OutOfRange for bad pos 
//the replace method first checks for an out of bounds exception for which it then iterates through the list to replace the indicated element at the specified position
void slist::replace(el_t element, int pos){
    if (pos<1 || pos> Count)
        throw OutOfRange();
    Node* p = Front;
    for (int i = 1; i < pos; i++)
        p = p->Next;
    p->Elem = element;
}
//the operator assignment function allows for the length and element values of two lists to be compared
//internal test outputs the counts of each list being compared
bool slist::operator==(const slist& OtherOne)
{// if this->count and OtheOne.Count are not the same then return false
    Node* N1 = this->Front;
    Node* N2 = OtherOne.Front;
    if (this->Count != OtherOne.Count) {
        cout << "Checking the counts of each List" << endl;
        cout << this->Count << endl;
        cout << OtherOne.Count << endl;

        
        return false;
    }else {
        for (int i = 1; i < this->Count; i++) {
            N1 = N1->Next;
            N2 = N2->Next;
            if (N1->Elem != N2->Elem) { return false; }
;
            
        }
        return true;


    }
    
    
       
   

    }
    
   


public class Anchor
{
    Element first; //przetrzymujemy tutaj adres obecnego elementu na poczatku listy
    Element x; //zmienna pomocnicza do poruszania sie po liscie

    //dodawanie elementow z przodu
    void insertAtTheFront(int i)
    {
        Element el = new Element(); //tworzenie nowego elementu
        el.value = i; //wczytywanie wartosci calkowitej
        el.next = this.first; //podpinanie nowostworzonego elementu do listy od przodu (lub ustawianie na null jesli to pierwszy element)
        this.first = el; //ustawienie kotwicy na obecny poczatek listy
    }

    void insertAtTheEnd(int i)
    {
        if (this.first == null) insertAtTheFront(i); //sprawdzamy czy lista nie jest pusta (jesli tak, to nie ma znaczenia z ktorej strony dodamy element)
        else
        {
            Element el = new Element(); //tworzenie nowego elementu
            el.value = i; //wczytywanie wartosci calkowitej
            x = this.first; //ustawiamy sie na poczatku listy
            while (x.next != null) x = x.next; //docieramy do konca listy
            x.next = el; //podpinamy ostatni element do nowoutworzonego
            el.next = null; //nowy element jest teraz ostatnim na liscie
        }
    }

    void removeFirst()
    {
        if(this.first == null) System.out.println("REQUESTED LIST HAS NO ELEMENTS, IN ORDER TO REMOVE - CREATE ONE FIRST"); //sprawdzanie czy istnieja elementy do usuniecia
        else this.first = this.first.next; //wskazujemy drugi element na liscie jako pierwszy (nie ma teraz referencji na pierwszy element wiec powinien zostac usuniety przez garbage collector)
    }

    void removeLast()
    {
        if(this.first == null) System.out.println("REQUESTED LIST HAS NO ELEMENTS, IN ORDER TO REMOVE - CREATE ONE FIRST"); //sprawdzanie czy istnieja elementy do usuniecia
        else
        {
            x = this.first; //ustawiamy sie na poczatku listy
            while (x.next.next != null) x = x.next; //docieramy na przedostatni element listy
            x.next = null; //przedostatni element jest teraz ostatnim na lisci (ostatni zostanie usuniety przez garbage collector, poniewaz nie ma na niego referencji)
        }
    }

    @Override

    public String toString()
    {
        String list = ""; //tworzymy i inicjalizujemy stringa do przechowania wartosci odczytanych z listy
        x = this.first; //ustawiamy sie na poczatku listy
        while (x.next != null)
        {
            list = list + x.value + " "; //dopisujac kolejne wartosci elementow oddzielone spacjami
            x = x.next; //docieramy do konca listy
        }
        list = list + x.value + " "; //trzeba pamietac o ostatnim elemencie
        return list; //a nastepnie je zwracamy w postaci lancucha znakow
    }

    public boolean equals(Object o)
    {
        //biezaca lista
        x = this.first; //ustawiamy sie na poczatku listy
        //lista porownywana
        Anchor oo = (Anchor) o; //tworzymy kopie obiektu kotwicy wskazujacej na poczatek porownywanej listy
        Element y = oo.first; //ustawiamy sie na poczatku listy
        //porownywanie wartosci elementow list
        do
        {
            if(x.value != y.value) return false; //wartosci odpowiadajacych elementow sa rozne
            x = x.next;
            y = y.next;
        }while (x.next != null && y.next !=null); //sprawdzamy do zakonczenia przynajmniej jednej z dwoch list
        if (x.next == null && y.next ==null) return true; //wszystkie elementy zawieraja te same liczby w tej samej kolejnosci
        else return false; //porownywane listy sa roznej dlugosci
    }

    public Anchor clone()
    {
        Anchor a = new Anchor(); //tworzymy kopie kotwicy
        x = this.first; //ustawiamy sie na poczatku listy
        while(x.next != null)
        {
            a.insertAtTheEnd(x.value); //przekazywanie biezacych wartosci elementow do nowotworzonych elementow klona
            x = x.next; //docieramy do konca listy
        }
        a.insertAtTheEnd(x.value); //przekazywanie biezacych wartosci elementow do nowotworzonych elementow klona
        return a;
    }

    void revert()
    {
        Element y = new Element(); //druga zmienna pomocnicza do zapisywania referencji na element z ktorego przybylismy
        Element z = new Element(); //trzecia zmienna pomocnicza do zapisywania referencji na element na ktory bedziemy skakac
        x = this.first; //ustawiamy sie na poczatku listy
        y = null; //pierwszy element stanie sie ostatnim wiec "next" bedzie wskazywalo na null
        while(x.next != null) //faktycznie dla jednego elementu petla sie nie wykona, ale nie ma to znaczenia
        {
            z = x.next; //zapisujemy w "z" referencje na nastepny element
            x.next = y; //referencja na nastepny element staje sie referencja na poprzedni element
            y = x; //zapamietujemy swoja pozycje przed skokiem na nastepny element
            x = z; //skaczemy na nastepny element
        }
        x.next = y; //referencja na nastepny element staje sie referencja na poprzedni element
        this.first = x; //kotwica musi teraz wskazywac na ostatni element ktory stal sie pierwszym
    }

}

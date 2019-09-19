public class Main
{
    public static void main(String[] args)
    {
        Anchor list1 = new Anchor();
        Anchor list2 = new Anchor();

        //dodawanie elementow do listy
        list1.insertAtTheFront(2);
        list1.insertAtTheFront(1);
        list1.insertAtTheEnd(3);
        list1.insertAtTheFront(0);
            //wyswietlanie
            System.out.println("Nasza lista:");
            System.out.print(list1.toString());
            System.out.println("");

        //klonowanie
        list2=list1.clone();
            //wyswietlanie
            System.out.println("Klon naszej listy:");
            System.out.print(list2);
            System.out.println("");

        //porownanie list
        System.out.print("Czy listy sa takie same? : " + list1.equals(list2));
        System.out.println("");
        System.out.println("");

        //sprawdzenie czy klon byl gleboki
            //usuwanie elementu
            list2.removeFirst();
            list2.removeLast();
            //wyswietlanie
            System.out.println("Nasze listy po usunieciu pierwszego i ostatniego elementu klona:");
            System.out.print("Lista: " + list1.toString());
            System.out.println("");
            System.out.print("Klon:  " + list2.toString());
            System.out.println("");
            //porownanie list
            System.out.print("Czy listy sa takie same? : " + list1.equals(list2));
            System.out.println("");
            System.out.println("");

        //porownanie list
        //System.out.print(list1.equals(list2));

        //odwracanie kolejnosci
        list1.revert();
        list2.revert();
            //wyswietlanie
            System.out.println("Nasza odwrocona lista:");
            System.out.print(list1.toString());
            System.out.println("");
            System.out.println("Nasz odwrocony klon:");
            System.out.print(list2.toString());


    }
}

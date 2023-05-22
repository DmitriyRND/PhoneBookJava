public class Contact {
    String nomerPhon;
    String nameContact;
    public Contact(String nomerPhon,String nameContact){
        this.nomerPhon = nomerPhon;
        this.nameContact = nameContact;
    }

    public void infoContact(){
        System.out.println(nameContact + " " + nomerPhon);
    }
}

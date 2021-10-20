import java.util.Scanner;
public class TestRunner {
    public static void main(String[] args) {
        int num = 0;
        Inventory noblesInv = new Inventory();
        Bookstore nobles = new Bookstore(noblesInv);
        Scanner sc = new Scanner(System.in);
        while (num != 4) {
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Register a new member.");
            System.out.println("\t 2. Register a new product to the inventory system.");
            System.out.println("\t 3. Purchase a product for a member.");
            System.out.println("\t 4. Exit");
            num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    System.out.println("What is the member name?");
                    String nam = sc.nextLine();
                    System.out.println("Is this a premium member?");
                    String prem = sc.nextLine();
                    boolean mem = false;
                    boolean pay = false;
                    if (prem.contains("y") || prem.contains("Y")) {
                        System.out.println("Does this member want to pay their monthly fee?");
                        String paid = sc.nextLine();
                        mem = true;
                        if (paid.contains("y") || paid.contains("Y")) {
                            pay = true;
                        }

                    }
                    nobles.newMembership(nam, mem, pay);
                    System.out.println("Thank-you. Member ID " + nobles.getMemberNum() + " has been registered.");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("What type of product are you registering? DVD, CD, or Book?");
                    String type = sc.nextLine();
                    switch (type) {
                        case "DVD":
                            System.out.println("What is the price of the product?");
                            double pri = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("What is the name of the product?");
                            String name = sc.nextLine();
                            Product newProd = new DVD(pri, name, nobles.getProdID());
                            nobles.addItemToInv(newProd);
                            System.out.println("Thank-you. Product ID " + nobles.getProdID() + " has been registered.");
                            break;
                        case "CD":
                            System.out.println("What is the price of the product?");
                            double pric = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("What is the name of the product?");
                            String namee = sc.nextLine();
                            Product newPrd = new CD(pric, namee, nobles.getProdID());
                            nobles.addItemToInv(newPrd);
                            System.out.println("Thank-you. Product ID " + nobles.getProdID() + " has been registered.");
                            break;
                        case "Book":
                            System.out.println("What is the price of the product?");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("What is the name of the product?");
                            String nameee = sc.nextLine();
                            System.out.println("Who is the author of the product?");
                            String author = sc.nextLine();
                            Product newProod = new Book(price, nameee, author, nobles.getProdID());
                            nobles.addItemToInv(newProod);
                            System.out.println("Thank-you. Product ID " + nobles.getProdID() + " has been registered.");
                            break;
                        default:
                            System.out.println("That is not a valid type of product. Please restart the process.");
                            System.out.println();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("What is the member ID?");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Membership meim = nobles.searchMemberById(id);
                    if(meim == null){
                        System.out.println("There are no members with this ID in the system. Please register a new member.");
                        System.out.println();
                        break;
                    }
                    System.out.println("What type of product would the member like to purchase?");
                    String ty = sc.nextLine();
                    Product purchased = nobles.searchById(ty);
                    nobles.purchaseProduct(purchased, meim);
                    System.out.println("Thank-you. Product " + purchased.getName() + " has been purchased.");
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Sorry, but you need to enter a 1, 2, 3 or a 4");

            }
        }
    }
    }


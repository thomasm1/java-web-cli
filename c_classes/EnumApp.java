public class EnumApp {
    
    public static void main(String[] args) {
        
        Coin coin = Coin.ETH;
        
        switch(coin) {
        case BTC:
            System.out.println("Bitcoin");
            break;
        case ETH:
            System.out.println("Ethereum");
            break;
        case LTC:
            System.out.println("Litecoin");
            break;
        default:
            break;

        }
        
        System.out.println(Coin.ETH);
        System.out.println("Enum symbol as a string: " + Coin.ETH.symbol());
        
        System.out.println(Coin.ETH.getClass());
        
        System.out.println(Coin.ETH instanceof Enum);
        
        System.out.println(Coin.LTC.getSymbol());
        
        Coin coin2 = Coin.valueOf("BTC");
        
        System.out.println(coin2);
    }

}

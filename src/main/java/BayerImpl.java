import java.util.Map;

public interface BayerImpl {
    public void printList(Map<Integer, Product> products); // показывает продукты возможные к покупке

    public void cheque(Map<Integer, Product> products); // формирует чек из выбранного, считает итого

}

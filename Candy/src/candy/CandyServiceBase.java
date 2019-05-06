package candy;

/**
 * ������ ��������� ������, ������� ����������
 */
public abstract class CandyServiceBase {
 
    /**
     * ������ �������� ��� ������������� ������ ��������� ����������� ������
     * @param candyEaters
     */
    public CandyServiceBase(ICandyEater[] candyEaters) {
    }
 
    /**
     * �������� ������� �� ��������
     * @param candy
     */
    public abstract void addCandy(ICandy candy);
}
package candy;

/**
 * ��������� ���������� ������, ��� ����� �������, �� ��� ��� �������.
 */
public interface ICandyEater {
 
    /**
     * ������ �������, ����� ������ �����
     * @param candy
     */
    void eat(ICandy candy) throws Exception;
}
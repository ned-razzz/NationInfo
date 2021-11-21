package Control;

//THis class just Reference for separation consonant
public class ReferenceTrans {
	final static String[] CHO = {"��","��","��","��","��","��","��","��",
			"��", "��","��","��","��","��","��","��","��","��","��"}; 
	final static String[] JOONG = {"��","��","��","��","��","��","��","��",
			"��","��", "��","��","��","��","��","��","��","��","��","��","��"}; 
	final static String[] JONG = {"","��","��","��","��","��","��","��",
			"��","��","��","��", "��","��","��","��","��","��","��","��","��",
			"��","��","��","��","��","��","��"}; 
	public static void main(String[] args) { 
		String text = "�ȳ��ϼ���. �߰������� �����ϰ�, ��Ÿ���� �ڹ�Ĩ����Ǫġ�� �����䤻��"; 
		for(int i = 0; i < text.length(); i++) { 
			char uniVal = text.charAt(i); // �ѱ��� ��츸 �����ؾ� �ϱ� ������ 0xAC00���� �Ʒ��� ������ �����Ѵ� 
			if(uniVal >= 0xAC00) { 
				System.out.print(uniVal + "=>"); 
				uniVal = (char)(uniVal - 0xAC00); 
				char cho = (char)(uniVal/28/21); 
				char joong = (char) ((uniVal)/28%21); 
				char jong = (char) (uniVal % 28); // ������ ù��°�� ä���̱� ������ 
				System.out.println(CHO[cho] + JOONG[joong] + JONG[jong]); 
			} else { 
				System.out.println(uniVal + "=>" + uniVal); 
			}
		}
	}
}

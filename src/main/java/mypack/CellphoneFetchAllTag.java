package mypack;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CellphoneFetchAllTag extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			CellphoneDAO dao=CellphoneDAOFactory.createCellphone();
			String result=dao.fetchAll();
			JspWriter out=pageContext.getOut();
			out.println(result);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return SKIP_BODY;
		
	}

	
}

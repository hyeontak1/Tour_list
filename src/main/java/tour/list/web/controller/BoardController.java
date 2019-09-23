package tour.list.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tour.list.web.helper.PageData;
import tour.list.web.helper.WebHelper;
import tour.list.web.model.board;
import tour.list.web.service.boardService;


@Controller
public class BoardController {
	//객체주입
	@Autowired
	WebHelper webHelper;
	
	@Autowired
	boardService boardService;
	
	//"/프로젝트이름"에 해당하는 ContextPath 변수 주입
	@Value("#{servletContext.contextPath}")
	String contextPath;
	
	@RequestMapping(value = "/board/list.do",method=RequestMethod.GET)
	public ModelAndView list(Model model) {
		//필요한 변수값 생성
		//검색어
		String keyword = webHelper.getString("page","");
		
		//페이지 번호(기본값 1)
		int nowPage = webHelper.getInt("page",1);
		//전체 게시글 수
		int totalCount=0;
		//한 페이지당 표시할 목록 수 
		int listCount=10;
		//한 그룹당 표시할 페이지 번호 수
		int pageCount=5;
		
		/**데이터 조회하기*/
		board input = new board();
		input.setTitle(keyword);
		input.setWrite(keyword);
		
		List<board> output=null;
		PageData pageData = null;
		
		try {
			totalCount =boardService.getBoardCount(input);
			pageData = new PageData(nowPage,totalCount,listCount,pageCount);
			
			//SQL의 LIMIT절에서 사용될 값을 Beans의 static 변수에 저장
			board.setOffset(pageData.getOffset());
			board.setListCount(pageData.getListCount());
			
			output=boardService.getBoardList(input);
		}catch(Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		model.addAttribute("keyword",keyword);
		model.addAttribute("output",output);
		model.addAttribute("pageData",pageData);
		
		String viewPath="board/list";
		return  new ModelAndView(viewPath);
	}
	
	@RequestMapping(value="/board/view.do",method = RequestMethod.GET)
	public ModelAndView view(Model model) {
		int deptno=webHelper.getInt("idBoard");
		
		if(deptno==0) {
			return webHelper.redirect(null, "학과번호가 없습니다");
		}
		
		board input=new board();
		input.setIdBoard(deptno);
		
		board output = null;
		
		try {
			output=boardService.getBoardItem(input);
		}catch(Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		model.addAttribute("output",output);
		
		String viewPath="board/view";
		return  new ModelAndView(viewPath);
	}
	
	@RequestMapping(value="/board/add.do",method = RequestMethod.GET)
	public String add(Model model) {
		
		
		return "board/add";
	}
	
	@RequestMapping(value="/board/add_ok.do",method = RequestMethod.POST)
	public ModelAndView add_ok(Model model) {
		/**사용자가 입력한 파라미터 수신 및 유효성 검사*/
		String title = webHelper.getString("title");
		String write = webHelper.getString("write");
		
		//학과 이름은 필수항목이므로 입력 여부를 검사
		if(title==null) {
			return webHelper.redirect(null, "제목을 입력하세요");
		}
		
		if(write==null) {
			return webHelper.redirect(null, "내용을 입력하세요");
		}
		
		/**데이터 저장하기*/
		//저장할 값들을 Beans에 담는다.
		board input= new board();
		input.setTitle(title);
		input.setWrite(write);
		
		try {
			//데이터 저장
			boardService.addBoard(input);
			
		}catch(Exception e) {
			return webHelper.redirect(null,e.getLocalizedMessage());
		}
		
		return  webHelper.redirect(contextPath + "/board/view.do?idBoard="+input.getIdBoard(), "저장되었습니다" );
	}
	
	@RequestMapping(value="/board/edit.do",method = RequestMethod.GET)
	public ModelAndView edit(Model model) {
		
		int idBoard =webHelper.getInt("idBoard");
		
		if(idBoard==0) {
			return webHelper.redirect(null, "쓴 글이 없습니다");
		}
		
		board input =new board();
		input.setIdBoard(idBoard);
		
		board output =null;
		
		try {
			output=boardService.getBoardItem(input);
		}catch(Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		model.addAttribute("output",output);
		
		String viewPath="board/edit";
		return  new ModelAndView(viewPath);
	}
	
	@RequestMapping(value="/board/edit_ok.do",method = RequestMethod.GET)
	public ModelAndView edit_ok(Model model) {
		
		int idBoard=webHelper.getInt("idBoard");
		String title=webHelper.getString("title");
		String write = webHelper.getString("write");
		
		if(idBoard==0) {
			return webHelper.redirect(null, "번호가 없습니다");
		}
		
		if(title==null) {
			return webHelper.redirect(null, "제목을 입력하세요");
		}
		
		if(write==null) {
			return webHelper.redirect(null, "내용을 입력하세요");
		}
		
		board input=new board();
		input.setIdBoard(idBoard);
		input.setTitle(title);
		input.setWrite(write);
		
		try {
			boardService.editBoard(input);
		}catch(Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		return  webHelper.redirect(contextPath + "/board/view.do?idBoard="+input.getIdBoard(), "수정되었습니다" );
	}
	
	@RequestMapping(value="/board/delete_ok.do",method = RequestMethod.GET)
	public ModelAndView delete_ok(Model model) {
		
		int idBoard=webHelper.getInt("idBoard");
		
		if(idBoard==0) {
			return webHelper.redirect(null, "번호가 없습니다");
		}
		
		board input=new board();
		input.setIdBoard(idBoard);
		
		try {
			boardService.deleteBoard(input);
		}catch(Exception e) {
			return webHelper.redirect(null, e.getLocalizedMessage());
		}
		
		return  webHelper.redirect(contextPath + "/board/list.do=", "삭제되었습니다" );
	}
}

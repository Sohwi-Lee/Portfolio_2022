package controller;

import controller.action.Action;
import controller.action.EventCommentWriteAction;
import controller.action.EventDelAction;
import controller.action.EventEditAction;
import controller.action.EventEditViewAction;
import controller.action.EventWriteAction;
import controller.action.IndexAction;
import controller.action.JoinAction;
import controller.action.EventLikeAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.NoticeCommentWriteAction;
import controller.action.NoticeDelAction;
import controller.action.NoticeLikeAction;
import controller.action.NoticeWriteAction;
import controller.action.RemoveUserAction;
import controller.action.ReservateAction;
import controller.action.ReservateRemoveAction;
import controller.action.ReviewWriteAction;
import controller.action.ToEventPageAction;
import controller.action.ToEventViewPageAction;
import controller.action.ToEventWritePageAction;
import controller.action.ToJoinPageAction;
import controller.action.ToLoginPageAction;
import controller.action.ToMyPageAction;
import controller.action.ToMyPageEditAction;
import controller.action.ToNoticePageAction;
import controller.action.ToNoticeViewPageAction;
import controller.action.ToReserveChkPageAction;
import controller.action.ToReservePageAction;
import controller.action.ToReviewPageAction;
import controller.action.myPageEditAction;

// Factory Method : 생성디자인패턴
public class ActionFactory {
	
	// 싱글톤 처리 : 생성디자인패턴
	private ActionFactory() {}
	private static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {return instance;}
	
	// command pattern : 행위디자인
	public Action getAction(String command,String idx) {
		Action action = null;
		//System.out.println("Command::"+command);
		System.out.println("Idx::"+idx);
		if(command.equals("IndexRecommend")) {action = new IndexAction();}
		if(command.equals("login")) {action = new LoginAction();}
		if(command.equals("로그아웃") || command.equals("logout")) {action = new LogoutAction();}
		if(command.equals("reservate")) {action = new ReservateAction();}
		if(command.equals("reserveCancel")) {action = new ReservateRemoveAction();}
		if(command.equals("delUser")) {action = new RemoveUserAction();}
		if(command.equals("가입하기") || command.equals("join")) {action = new JoinAction();}
		if(command.equals("eventWrite")) {action = new EventWriteAction();}
		if(command.equals("noticeWrite")) {action = new NoticeWriteAction();}
		if(command.equals("reviewWrite")) {action = new ReviewWriteAction();}
		if(command.equals("eventDel")) {action = new EventDelAction();}
		if(command.equals("noticeDel")) {action = new NoticeDelAction();}
		if(command.equals("editMyInfo")) {action = new myPageEditAction();}
		
		// header link
		if(command.equals("이벤트")) {action = new ToEventPageAction();}
		if(command.equals("이벤트글쓰기")) {action = new ToEventWritePageAction();}
		if(command.equals("공지사항")) {action = new ToNoticePageAction();}
		if(command.equals("이용후기")) {action = new ToReviewPageAction();}
		if(command.equals("예약하기")) {action = new ToReservePageAction();}
		if(command.equals("예약확인")) {action = new ToReserveChkPageAction();}
		if(command.equals("로그인")) {action = new ToLoginPageAction();}
		if(command.equals("회원가입")) {action = new ToJoinPageAction();}
		if(command.equals("마이페이지")) {action = new ToMyPageAction();}
		
		// board view page
		if(command.equals("eventView")) {action = new ToEventViewPageAction(idx);}
		if(command.equals("eventEdit")) {action = new EventEditViewAction();}
		if(command.equals("eventEditFin")) {action = new EventEditAction(idx);}
		if(command.equals("noticeView")) {action = new ToNoticeViewPageAction(idx);}
		if(command.equals("like_E")) {action = new EventLikeAction(idx);}
		if(command.equals("like_N")) {action = new NoticeLikeAction(idx);}
		
		// edit page
		if(command.equals("myEdit")) {action = new ToMyPageEditAction();}
		
		if(command.equals("commentWrite_E")) {action = new EventCommentWriteAction(idx);}
		if(command.equals("commentWrite_N")) {action = new NoticeCommentWriteAction(idx);}

		return action;
	}

}

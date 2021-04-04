package view;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.BoardDAO;
import model.BoardVO;

public class Rent_Controller implements Initializable {
	// 카테고리별 버튼
	@FXML
	private Button btnAll;
	@FXML
	private Button btnDigital;
	@FXML
	private Button btnInterior;
	@FXML
	private Button btnKids;
	@FXML
	private Button btnSports;
	@FXML
	private Button btnWomanThing;
	@FXML
	private Button btnWomanCloth;
	@FXML
	private Button btnManThing;
	@FXML
	private Button btnHobby;
	@FXML
	private Button btnBeauty;
	@FXML
	private Button btnPet;
	@FXML
	private Button btnBook;
	@FXML
	private Button btnPlant;
	// 나머지 객체
	@FXML
	private AnchorPane ap;
	// 검색하는 버튼
	@FXML
	private Button btnFinder;
	// 검색어 입력 textField
	@FXML
	private TextField textField;
	// 오른쪽 밑 floating btn
	@FXML
	private Button btnFloating;
	@FXML
	private Label lab_ctg;
	// list불러올 AnchorPane
    @FXML
    private AnchorPane boardListAc;
    @FXML
    private VBox tmp;
    
    private BoardDAO boardDAO = new BoardDAO();
    
	private ObservableList<BoardVO> boardVOObservanbleList = FXCollections.observableArrayList();
	
	private ArrayList<BoardVO> boardVOList;
	
	private ListView<BoardVO> listView = new ListView<>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	
	// board리스트 뿌리는 메소드
	public void getBoardList() {
		listView.setPrefSize(boardListAc.getPrefWidth(), boardListAc.getPrefHeight());
		listView.setItems(boardVOObservanbleList);
		listView.setCellFactory(boardVOListView -> new ListCell<BoardVO>() {
			@Override
			public void updateItem(BoardVO boardVO, boolean empty) {
				super.updateItem(boardVO, empty);

				if (empty || boardVO == null) {
					setText(null);
					setGraphic(null);
				} else {
					Image image = new Image(boardVO.getImageUrl());
					ImageView imageView = new ImageView();
					imageView.setFitHeight(100);
					imageView.setFitWidth(100);
					imageView.setImage(image);
					
					System.out.println(boardVO.getTitle());
					System.out.println(boardVO.getPrice());
					System.out.println(boardVO.getImageUrl());
					setText(null);
					setGraphic(null);
					setText(boardVO.getTitle() + "\n" + boardVO.getPrice() + "\n" + boardVO.getTime());
					setGraphic(imageView);
				}
			}
		});
		boardListAc.getChildren().setAll(listView);
	}
	
	// 카테고리별 버튼이 눌렸을 떄
	public void ctgBtnClicked(ActionEvent actionEvent) {
		int ctgId = 0;
		boardListAc.getChildren().clear();
		if (actionEvent.getSource() == btnAll) {
			boardVOList = boardDAO.getAllBoardList();
			boardVOObservanbleList.setAll(boardVOList);
			getBoardList();
			System.out.println("btnAll pressed");
		} else if (actionEvent.getSource() == btnDigital) {
			ctgId = 1;
			boardVOList = boardDAO.getOneCtgBoardList(ctgId);
			boardVOObservanbleList.setAll(boardVOList);
			getBoardList();
			System.out.println("btnDigital pressed");
		} else if (actionEvent.getSource() == btnInterior) {
			ctgId = 2;
			boardVOList = boardDAO.getOneCtgBoardList(ctgId);
			boardVOObservanbleList.setAll(boardVOList);
			getBoardList();
			System.out.println("btnInterior pressed");
		} else if (actionEvent.getSource() == btnKids) {
			ctgId = 3;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnSports) {
			ctgId = 4;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnWomanThing) {
			ctgId = 5;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnWomanCloth) {
			ctgId = 6;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnManThing) {
			ctgId = 7;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnHobby) {
			ctgId = 8;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnBeauty) {
			ctgId = 9;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnPet) {
			ctgId = 10;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnBook) {
			ctgId = 11;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		} else if (actionEvent.getSource() == btnPlant) {
			ctgId = 12;
			boardDAO.getOneCtgBoardList(ctgId);
			System.out.println("pressed");
		}	
	}
	
	// find아이콘 click시
	public void findClicked(ActionEvent actionEvent) {
		if (actionEvent.getSource() == btnFinder) {
			boardListAc.getChildren().clear();
			String findTxt = textField.getText();
			boardVOList = boardDAO.boardListBySearch(findTxt);
			boardVOObservanbleList.setAll(boardVOList);
			
			getBoardList();
			
			System.out.println("btnDigital pressed");
			boardDAO.boardListBySearch(findTxt);
			
			findWindow();
		}
	}

	// 검색어를 입력하세요 창
	public void findWindow() {
		System.out.println("findWindow 호출");
		btnFinder.setOpacity(1);
	}
	
	// floating 버튼 클릭시
	public void btnFloatingClicked(ActionEvent actionEvent) {
		System.out.println("floating버튼 clicked");
		loadPage("Post");
	}
	
	// 다른 페이지로 이동 메소드
	private void loadPage(String page) {
		try {
			System.out.println("../view/" + page + ".fxml");
			Node node;
			node = (Node) FXMLLoader.load(getClass().getResource("../view/" + page + ".fxml"));
			ap.getChildren().setAll(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
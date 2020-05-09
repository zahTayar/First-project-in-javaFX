package View;
import javafx.stage.*;
import javafx.geometry.Insets;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.Random;

import javafx.beans.value.ChangeListener;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

import javafx.event.EventHandler;
public class View {
	//define parameters
	
	Line lineBody,lineNose,lineLeg1,lineLeg2,lineHan1,lineHan2;
	ChoiceBox what ;
	RadioButton rbRED,rbGRE,rbBLUE;
	Button Reset,addShape,Fall,getUp,deletBal;
	Group root;
	CheckBox cbEyes,cbNose,cbMouth;
	VBox vbColors,vbOrgans;
	Circle cRighEy,cLefEy,CHad,circle;
	Rectangle recMouth;
	ToggleGroup tgr;
	ArrayList <Circle> arr;
	BorderPane bp;
	Text T1;
	public View(Stage stage) {
		root=new Group();
		
		
		//handle the shape of the man
		lineBody=new Line(300,150,300,300);
		lineBody.setStroke(Color.BLACK);
		CHad=new Circle(300,100,50);
		CHad.setFill(Color.TRANSPARENT);
		CHad.setStroke(Color.BLACK);
		lineLeg1=new Line(300,300,250,400);
		lineLeg1.setStroke(Color.BLACK);
		lineLeg2=new Line(300,300,350,400);
		lineLeg2.setStroke(Color.BLACK);
		lineHan1=new Line (300,180,250,240);
		lineHan1.setStroke(Color.BLACK);
		lineHan2=new Line (300,180,350,240);
		lineHan2.setStroke(Color.BLACK);
		
		//handle with button
		Reset=new Button("reset");
		addShape=new Button ("Add Shape");
		Fall=new Button("FALL");
		getUp=new Button("GetUp");
		deletBal=new Button("Delete All Balls");
		
		//handlle radio buttons
		 vbColors=new VBox(10);
		tgr=new ToggleGroup();
		rbRED=new RadioButton("RED");
		rbRED.setToggleGroup(tgr);
		rbGRE=new RadioButton("GREEN");
		rbGRE.setToggleGroup(tgr);
		rbBLUE=new RadioButton("BLUE");
		rbBLUE.setToggleGroup(tgr);
		vbColors.getChildren().addAll(rbBLUE,rbGRE,rbRED);
		
		//handle check box
		cbEyes=new CheckBox("Eyes");
		cbMouth=new CheckBox("Mouth");
		cbNose=new CheckBox("Nose");
		vbOrgans=new VBox (10);
		vbOrgans.getChildren().addAll(cbEyes,cbMouth,cbNose);
		//choice
		what=new ChoiceBox();
		what.getItems().addAll("1","2","3","4");
		
		//border
		 bp=new BorderPane();
//		 bp.setMargin(root,new Insets(0,80,0,0));
		 bp.setCenter(root);
		 bp.setMargin(vbColors, new Insets (250,0,250,40));
		 bp.setLeft(vbColors);
		 bp.setMargin(vbOrgans, new Insets(250,40,250,0));
		 bp.setRight(vbOrgans);
		 what.setLayoutX(250);
		 what.setLayoutY(10);
		 addShape.setLayoutX(350);
		 addShape.setLayoutY(450);
		 Fall.setLayoutX(300);
		 Fall.setLayoutY(450);
		 getUp.setLayoutX(200);
		 getUp.setLayoutY(350);
		 deletBal.setLayoutX(180);
		 deletBal.setLayoutY(450);

		 //circles
		 arr=new ArrayList<>();
		 
	
		
		
		//add children
		root.getChildren().addAll(lineBody,CHad,lineHan1,lineHan2,lineLeg2,lineLeg1,what,addShape,Fall,deletBal);
		
		
		
		
		
		
		
		
		
		
		
		
		Scene scene=new Scene(bp,600,600);
		scene.setFill(Color.BLUE);
		stage.setScene(scene);
		stage.show();
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

    public Button getFall() {
		return Fall;
	}

	public void setFall(Button fall) {
		Fall = fall;
	}

	public Circle drewCircle() {
    	Random rnd=new Random();
    	circle=new Circle(rnd.nextInt(550),rnd.nextInt(550),20);
		circle.setFill(Color.YELLOW);
		circle.setStroke(Color.BLACK);
		
		bp.getChildren().addAll(circle);
		arr.add(circle);
    	return circle;
    }
//	public void updateAfterCi2() {
//		for(int i=0;i<arr.size();i++) {
//			bp.getChildren().add(arr.get(i));
//		}
		
		
		
//	}
	public void updateAfterCi() {
		
		for(int i=0;i<arr.size();i++) {
			bp.getChildren().remove(arr.get(i));
		}
		for(int i=0;i<arr.size();i++) {
			bp.getChildren().add(arr.get(i));
		}
	
		
		
	}
//	public void updateShape() {
//		root.getChildren().addAll(arr);
//	}
//	
	public void drewEyes() {
		 //eyes
		 cRighEy=new Circle (285,80,8);
		 cRighEy.setFill(Color.TRANSPARENT);
		 cRighEy.setStroke(Color.BLACK);
		 cLefEy=new Circle (315,80,8);
		 cLefEy.setFill(Color.TRANSPARENT);
		 cLefEy.setStroke(Color.BLACK);	
		 
		 root.getChildren().addAll(cRighEy,cLefEy);
		 
		 }
	public void drewNose() {
		//nose
		 lineNose=new Line(300,90,300,110);
		 lineNose.setStroke(Color.BLACK);
		 root.getChildren().add(lineNose);
	}
	public void drewMouth() {
		//mouth
		recMouth=new Rectangle(290,120,20,15);
		 recMouth.setFill(Color.TRANSPARENT);
		 recMouth.setStroke(Color.BLACK);
		 root.getChildren().add(recMouth);
	}
	public void changeColor(int ColoKind ) {
		if (ColoKind==1) {
			recMouth.setStroke(Color.RED);
			cLefEy.setStroke(Color.RED);
			cRighEy.setStroke(Color.RED);
			lineNose.setStroke(Color.RED);
		}else if (ColoKind==2) {
			recMouth.setStroke(Color.GREEN);
			cLefEy.setStroke(Color.GREEN);
			cRighEy.setStroke(Color.GREEN);
			lineNose.setStroke(Color.GREEN);
		}else {
			recMouth.setStroke(Color.BLUE);
			cLefEy.setStroke(Color.BLUE);
			cRighEy.setStroke(Color.BLUE);
			lineNose.setStroke(Color.BLUE);
			}
	}
	public void addListenerToggle(ChangeListener<Toggle> cl) {
		tgr.selectedToggleProperty().addListener(cl);
	}
	public void addListenerToWhat(ChangeListener<String> clW) {
		what.getSelectionModel().selectedItemProperty().addListener(clW);
	}
	public void printMassage(int kind) {
		root.getChildren().clear();
		if(kind==1) {
			T1=new Text(10,20,"message number 1");
			
			}else if (kind==2) {
				T1=new Text(10,20,"message number 2");
			}else if (kind==3) {
				T1=new Text(10,20,"message number 3");
			}else if (kind==4) {
				T1=new Text(10,20,"message number 4");
			}else  T1=new Text(10,20,"The Colors are for the face\n"+ ", but if he dont have face, This is a problem");
				root.getChildren().add(T1);
				bp.setBottom(Reset);
				bp.setMargin(Reset, new Insets (-200,0,300,260));
				
		
	}
	public void updateAfterReset() {
		root.getChildren().clear();
		for(int i=0;i<arr.size();i++) {
			bp.getChildren().remove(arr.get(i));
		}
		try{
			rbBLUE.setSelected(false);
			rbGRE.setSelected(false);
			rbRED.setSelected(false);
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		
		bp.setBottom(null);
		root.getChildren().addAll(lineBody,CHad,lineHan1,lineHan2,lineLeg2,lineLeg1,what);
	}
//	public void updateAfterCirc() {
//		root.getChildren().clear();
//		
//		bp.setBottom(null);
//		root.getChildren().addAll(lineBody,CHad,lineHan1,lineHan2,lineLeg2,lineLeg1,what);
//		root.getChildren().addAll(arr);
//	}
	public void addEachCircleEvent(int index,EventHandler <MouseEvent> event) {
		arr.get(index).addEventHandler(MouseEvent.MOUSE_CLICKED, event);
		
	}
	public Circle getCircle() {
		return circle;
	}
//	public void showAlert(String mes) { 
//	    Alert alert = new Alert(Alert.AlertType.INFORMATION);
//	    alert.setTitle("Error");
//	    alert.setHeaderText("Look, an Information Dialog");
//	    alert.setContentText(mes);
//	    alert.showAndWait();
//	}
	public void changeCirColo(int index,Color color) {
		
		
		if(color==Color.YELLOW) {
			arr.get(index).setFill(Color.GREEN);
		}else	if(color==Color.GREEN) {
			arr.get(index).setFill(Color.YELLOW);
		}
		
		
	}
	public void ufterDelete() {
		bp.getChildren().removeAll(arr);
	}
	public void addEventToDeleteBall(EventHandler event) {
		deletBal.setOnAction(event);
		
	}
	public void addEventToGetUP(EventHandler event) {
		getUp.setOnAction(event);
		
	}
	public void addEventToFall(EventHandler event) {
		Fall.setOnAction(event);
	}
	public void addEventToAddShape(EventHandler event) {
		addShape.setOnAction(event);
	}
	public void addEventToResetGame(EventHandler event) {
		Reset.setOnAction(event);
		
	}
	public Color getColor(int index) {
		return (Color)arr.get(index).getFill();
	}
	
	public ArrayList<Circle> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Circle> arr) {
		this.arr = arr;
	}

	public void addEvenToOrgan(CheckBox cb,EventHandler event) {
		cb.setOnAction(event);
	}

	public Line getLineBody() {
		return lineBody;
	}

	public void setLineBody(Line lineBody) {
		this.lineBody = lineBody;
	}

	public Line getLineNose() {
		return lineNose;
	}

	public void setLineNose(Line lineNose) {
		this.lineNose = lineNose;
	}

	public Line getLineLeg1() {
		return lineLeg1;
	}

	public void setLineLeg1(Line lineLeg1) {
		this.lineLeg1 = lineLeg1;
	}

	public Line getLineLeg2() {
		return lineLeg2;
	}

	public void setLineLeg2(Line lineLeg2) {
		this.lineLeg2 = lineLeg2;
	}

	public Line getLineHan1() {
		return lineHan1;
	}

	public void setLineHan1(Line lineHan1) {
		this.lineHan1 = lineHan1;
	}

	public Line getLineHan2() {
		return lineHan2;
	}

	public void setLineHan2(Line lineHan2) {
		this.lineHan2 = lineHan2;
	}

	public RadioButton getRbRED() {
		return rbRED;
	}

	public void setRbRED(RadioButton rbRED) {
		this.rbRED = rbRED;
	}

	public RadioButton getRbGRE() {
		return rbGRE;
	}

	public void setRbGRE(RadioButton rbGRE) {
		this.rbGRE = rbGRE;
	}

	public RadioButton getRbBLUE() {
		return rbBLUE;
	}

	public void setRbBLUE(RadioButton rbBLUE) {
		this.rbBLUE = rbBLUE;
	}

	public CheckBox getCbEyes() {
		return cbEyes;
	}

	public void setCbEyes(CheckBox cbEyes) {
		this.cbEyes = cbEyes;
	}

	public CheckBox getCbNose() {
		return cbNose;
	}

	public void setCbNose(CheckBox cbNose) {
		this.cbNose = cbNose;
	}

	public CheckBox getCbMouth() {
		return cbMouth;
	}

	public void setCbMouth(CheckBox cbMouth) {
		this.cbMouth = cbMouth;
	}

	public VBox getVbColors() {
		return vbColors;
	}

	public void setVbColors(VBox vbColors) {
		this.vbColors = vbColors;
	}

	public VBox getVbOrgans() {
		return vbOrgans;
	}

	public void setVbOrgans(VBox vbOrgans) {
		this.vbOrgans = vbOrgans;
	}

	public Circle getcRighEy() {
		return cRighEy;
	}

	public void setcRighEy(Circle cRighEy) {
		this.cRighEy = cRighEy;
	}

	public Circle getcLefEy() {
		return cLefEy;
	}

	public void setcLefEy(Circle cLefEy) {
		this.cLefEy = cLefEy;
	}

	public Circle getCHad() {
		return CHad;
	}

	public void setCHad(Circle cHad) {
		CHad = cHad;
	}

	public Rectangle getRecMouth() {
		return recMouth;
	}

	public void setRecMouth(Rectangle recMouth) {
		this.recMouth = recMouth;
	}

	public ToggleGroup getTgr() {
		return tgr;
	}

	public void setTgr(ToggleGroup tgr) {
		this.tgr = tgr;
	}

	public BorderPane getBp() {
		return bp;
	}

	public void setBp(BorderPane bp) {
		this.bp = bp;
	}

	public void deletEyes() {
		root.getChildren().removeAll(cRighEy,cLefEy);
	}
	public void deletMouth() {
		root.getChildren().removeAll(recMouth);
	}
	public void deletNose() {
		root.getChildren().removeAll(lineNose);
	}

	public void updateUfterFall() {
		root.getChildren().clear();
		lineBody=new Line(150,500,370,500);
		lineBody.setStroke(Color.BLACK);
		CHad=new Circle(100,500,50);
		CHad.setFill(Color.TRANSPARENT);
		CHad.setStroke(Color.BLACK);
		lineLeg1=new Line(370,500,400,470);
		lineLeg1.setStroke(Color.BLACK);
		lineLeg2=new Line(370,500,340,530);
		lineLeg2.setStroke(Color.BLACK);
		lineHan1=new Line (300,500,350,450);
		lineHan1.setStroke(Color.BLACK);
		lineHan2=new Line (300,500,250,550);
		lineHan2.setStroke(Color.BLACK);
		root.getChildren().addAll(lineBody,CHad,lineLeg1,lineLeg2,lineHan1,lineHan2,getUp);
		
	}
	public void updateUfterGetUp() {
		root.getChildren().clear();
		lineBody=new Line(300,150,300,300);
		lineBody.setStroke(Color.BLACK);
		CHad=new Circle(300,100,50);
		CHad.setFill(Color.TRANSPARENT);
		CHad.setStroke(Color.BLACK);
		lineLeg1=new Line(300,300,250,400);
		lineLeg1.setStroke(Color.BLACK);
		lineLeg2=new Line(300,300,350,400);
		lineLeg2.setStroke(Color.BLACK);
		lineHan1=new Line (300,180,250,240);
		lineHan1.setStroke(Color.BLACK);
		lineHan2=new Line (300,180,350,240);
		lineHan2.setStroke(Color.BLACK);
		root.getChildren().addAll(lineBody,CHad,lineHan1,lineHan2,lineLeg2,lineLeg1,what,addShape,Fall,deletBal);
	}


	

}

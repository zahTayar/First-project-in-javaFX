package Controller;
import java.util.Random;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.*;
public class Controller {
	private Model.Model theModel;
	private View.View theView;
	
	public Controller(Model.Model model,View.View view) {
		theModel=model;
		theView=view;
		
		theView.addEvenToOrgan(theView.getCbMouth(),new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (theView.getCbMouth().isSelected()) {

					theView.drewMouth();
				}else theView.deletMouth();
			}
		});
		theView.addEvenToOrgan(theView.getCbEyes(), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (theView.getCbEyes().isSelected()) {
					theView.drewEyes();
				} else theView.deletEyes();
				
			}
			
			
			
		}
			);
		theView.addEvenToOrgan(theView.getCbNose(), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				 if (theView.getCbNose().isSelected()) {
					theView.drewNose();
				  }else theView.deletNose();
				
				
			}
		});
		
	
		
		
		
		
		
		
		theView.addListenerToggle(new ChangeListener<Toggle>() {
			
		
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				try {
				if (newValue==theView.getRbRED()) {
					theView.changeColor(1);					
				}else if (newValue==theView.getRbGRE()) {
					theView.changeColor(2);
				}else theView.changeColor(3);
				}catch(Exception e) {
					if (newValue.isSelected())
						theView.printMassage(5);
					else System.out.println(e.getMessage());
					}
				
			}

			
				
			}
		);
		
		
		theView.addListenerToWhat(new ChangeListener <String>() {

			
			public void changed(ObservableValue<? extends String> arg0, String old, String new1) {
				if (new1=="1") {
					theView.printMassage(1);
					
				}else if (new1=="2") {
					theView.printMassage(2);
					
				}else if (new1=="3") {
					theView.printMassage(3);
					
				}else  if (new1=="4") {
					theView.printMassage(4);
					
				}
				
			}
			
		});
		theView.addEventToResetGame(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.updateAfterReset();
				
			}
		});
		theView.addEventToAddShape(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			    	theView.drewCircle();
			    	for (int i=0;i<theView.getArr().size();i++) {
			    		theModel.getAllCircle().add(theView.getArr().get(i));
			    	}
			    	
		
	
				

				
				
//		            theModel.setAllCircle(theView.getArr());
			for (int i=0;i<theView.getArr().size();i++) {
				int index=i;
				theView.addEachCircleEvent(index,new EventHandler<MouseEvent>() {
					

					@Override
					public void handle(MouseEvent event) {
//						int index=theView.getArr().indexOf(event.getTarget());
//						theView.changeCirColo(index, theView.getColor(index));
//						if((Color)theView.getArr().get(index).getFill()==Color.YELLOW)
//						theView.getArr().get(index).setFill(Color.GREEN);
//						else theView.getArr().get(index).setFill(Color.YELLOW);
						theView.getArr().get(index).setFill(Color.RED);
						
						theView.updateAfterCi();
					}
						
				});
//				theView.updateAfterCi();
			}
			
			
			}
		});
		theView.addEventToFall(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.updateUfterFall();				
			}
		});
		theView.addEventToGetUP(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.updateUfterGetUp();
				
			}
		});
		theView.addEventToDeleteBall(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				theView.ufterDelete();
				
			}
		});
			
		

		

		
		
		
		
	}

}

package application.model;

import java.util.ArrayList;

import javafx.scene.image.Image;



public class ImageList {
	
	//initialise images
	Image img1 = new Image("file:img/CatWoman.png");
	Image img2 = new Image("file:img/Superman.png");
	Image img3 = new Image("file:img/batman.png");
	
	private void addImages() {
	//add images to a list
	ArrayList<Image> imgList = new ArrayList<Image>();
	imgList.add(img1);
	imgList.add(img2);	
	imgList.add(img3);

	ArrayList<String> namesList = new ArrayList<String>();
	namesList.add("Cat Woman");
	namesList.add("Superman");	
	namesList.add("Batman");

	}
}
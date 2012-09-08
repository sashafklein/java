/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	// Dimensions of boxes and spacing in between.
	private static final double WIDTH = 170;
	private static final double HEIGHT = 60;
	private static final double SPACE = 35;
	
	public void run() {
		
		/** X coordinates for the boxes.
		 * p means program, g means graphics, c means console,
		 * and d means dialog.
		 */
		double pX = (getWidth() / 2) - (WIDTH / 2);
		double gX = (getWidth() / 2) - ((3 * WIDTH) / 2) - SPACE;
		double cX = (getWidth() / 2) - (WIDTH / 2);
		double dX = (getWidth() / 2) + (WIDTH / 2) + SPACE;
		
		/** Y coordinates for the boxes.
		 */
		double pY = (getHeight() / 2) - HEIGHT - (SPACE / 2);
		double gY = (getHeight() / 2) + (SPACE / 2);
		double cY = (getHeight() / 2) + (SPACE / 2);
		double dY = (getHeight() / 2) + (SPACE / 2);
		
		/** Declares boxes and puts them on screen.
		 */
		GRect program = new GRect(pX, pY, WIDTH, HEIGHT);
		GRect graphics = new GRect(gX, gY, WIDTH, HEIGHT);
		GRect console = new GRect(cX, cY, WIDTH, HEIGHT);
		GRect dialog = new GRect(dX, dY, WIDTH, HEIGHT);
		add(program);
		add(graphics);
		add(console);
		add(dialog);
		
		/** Declares and styles labels.
		 */
		GLabel Program = new GLabel("Program");
		Program.setFont("Helvetica-16");
		GLabel Graphics = new GLabel("GraphicsProgram");
		Graphics.setFont("Helvetica-16");
		GLabel Console = new GLabel("ConsoleProgram");
		Console.setFont("Helvetica-16");
		GLabel Dialog = new GLabel("DialogProgram");
		Dialog.setFont("Helvetica-16");
		
		/** Calculates coordinates for labels.
		 */
		double PX = pX + ((WIDTH - Program.getWidth()) / 2);
		double PY = pY + ((HEIGHT + Program.getAscent()) / 2);
		double GX = gX + ((WIDTH - Graphics.getWidth()) / 2);
		double GY = gY + ((HEIGHT + Graphics.getAscent()) / 2);
		double CX = cX + ((WIDTH - Console.getWidth()) / 2);
		double CY = cY + ((HEIGHT + Console.getAscent()) / 2);
		double DX = dX + ((WIDTH - Dialog.getWidth()) / 2);
		double DY = gY + ((HEIGHT + Dialog.getAscent()) / 2);
		
		/** Locates and prints labels.
		 */
		Program.setLocation(PX, PY);
		add(Program);
		Graphics.setLocation(GX, GY);
		add(Graphics);
		Console.setLocation(CX, CY);
		add(Console);
		Dialog.setLocation(DX, DY);
		add(Dialog);
		
		/** Coordinates for lines.
		 * 
		 */
		double lineX1 = pX + (WIDTH / 2);
		double gLineX = gX + WIDTH / 2;
		double cLineX = cX + WIDTH / 2;
		double dLineX = dX + WIDTH / 2;
		
		double lineY1 = pY + HEIGHT;
		double lineY2 = lineY1 + SPACE;
		
		/**
		 * Declare, locate, and print lines.
		 */
		GLine gLine = new GLine(lineX1, lineY1, gLineX, lineY2);
		add(gLine);
		GLine cLine = new GLine(lineX1, lineY1, cLineX, lineY2);
		add(cLine);
		GLine dLine = new GLine(lineX1, lineY1, dLineX, lineY2);
		add(dLine);
	}
}


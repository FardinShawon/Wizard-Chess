package project;

import java.awt.Graphics;

public class PossibleMovesHighlight {
	
	
	static int x;
	static int y;
	static int square;
	int position;
	static int hflag;
	static Graphics g;
	
	PossibleMovesHighlight(int y, int x, int square, Graphics g)
	{
		PossibleMovesHighlight.x=x;
		PossibleMovesHighlight.y=y;	
		PossibleMovesHighlight.square=square;
		PossibleMovesHighlight.g=g;
		position=x*8+y;
		System.out.println(x+""+y);
		Draw();
	}
	
	
	public void Draw()
	{
		if("P".equals(AlphaBetaChess.chessBoard[x][y]))
		{
			System.out.println("P");
			posibleP(position);
		}
		else if("R".equals(AlphaBetaChess.chessBoard[x][y]))
		{
			System.out.println("R");
			posibleR(position);
		}
		else if("B".equals(AlphaBetaChess.chessBoard[x][y]))
		{
			System.out.println("B");
			posibleB(position);
		}
		else if("K".equals(AlphaBetaChess.chessBoard[x][y]))
		{
			System.out.println("K");
			posibleK(position);
		}
		else if("Q".equals(AlphaBetaChess.chessBoard[x][y]))
		{
			System.out.println("Q");
			posibleQ(position);
		}
		else if("A".equals(AlphaBetaChess.chessBoard[x][y]))
		{
			System.out.println("A");
			posibleA(position);
		}
	}
	
	
	//pawn
    public static String posibleP(int pos) {
        String list="", oldPiece;
        int r=pos/8, c=pos%8;
        for (int j=-1; j<=1; j+=2) {
        	
        	//capture
            try {
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r-1][c+j].charAt(0)) && pos>=16) {
                	hflag =0;
                	
                    oldPiece=AlphaBetaChess.chessBoard[r-1][c+j];
                    AlphaBetaChess.chessBoard[r][c]=" ";
                    AlphaBetaChess.chessBoard[r-1][c+j]="P";
                    if (kingSafe()) {
                        list=list+r+c+(r-1)+(c+j)+oldPiece;

                        hflag=1;
                    }
                    AlphaBetaChess.chessBoard[r][c]="P";
                    AlphaBetaChess.chessBoard[r-1][c+j]=oldPiece;
                    
                  //paint
                    if(hflag==1)
                    {
                    	HighLight h = new HighLight((c+j)*square, (r-1)*square, square);
                    	h.paintComponent(g);
                    	hflag=0;
                    } 
                }
            } catch (Exception e) {}
            
          //promotion && capture
            try {
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r-1][c+j].charAt(0)) && pos<16) {
                	hflag=0;
                	
                    String[] temp={"Q","R","B","K"};
                    for (int k=0; k<4; k++) {
                        oldPiece=AlphaBetaChess.chessBoard[r-1][c+j];
                        AlphaBetaChess.chessBoard[r][c]=" ";
                        AlphaBetaChess.chessBoard[r-1][c+j]=temp[k];
                        if (kingSafe()) {
                            //column1,column2,captured-piece,new-piece,P
                            list=list+c+(c+j)+oldPiece+temp[k]+"P";
                            
                            hflag=1;
                        }
                        AlphaBetaChess.chessBoard[r][c]="P";
                        AlphaBetaChess.chessBoard[r-1][c+j]=oldPiece;
                        
                      //paint
                        if(hflag==1)
                        {
                        	HighLight h = new HighLight((c+j)*square, (r-1)*square, square);
                        	h.paintComponent(g);
                        	hflag=0;
                        } 
                    }
                }
            } catch (Exception e) {}
        }
        
      //move one up
        try {
            if (" ".equals(AlphaBetaChess.chessBoard[r-1][c]) && pos>=16) {
            	hflag=0;
            	
                oldPiece=AlphaBetaChess.chessBoard[r-1][c];
                AlphaBetaChess.chessBoard[r][c]=" ";
                AlphaBetaChess.chessBoard[r-1][c]="P";
                if (kingSafe()) {
                    list=list+r+c+(r-1)+c+oldPiece;
                    
                    hflag=1;
                }
                AlphaBetaChess.chessBoard[r][c]="P";
                AlphaBetaChess.chessBoard[r-1][c]=oldPiece;
                
                if(hflag==1)
                {
                	HighLight h = new HighLight(c*square, (r-1)*square, square);
                	h.paintComponent(g);
                	hflag=0;
                } 
            }
        } catch (Exception e) {}
        
        
      //promotion && no capture
        try {
            if (" ".equals(AlphaBetaChess.chessBoard[r-1][c]) && pos<16) {
            	hflag=0;
            	
                String[] temp={"Q","R","B","K"};
                for (int k=0; k<4; k++) {
                    oldPiece=AlphaBetaChess.chessBoard[r-1][c];
                    AlphaBetaChess.chessBoard[r][c]=" ";
                    AlphaBetaChess.chessBoard[r-1][c]=temp[k];
                    if (kingSafe()) {
                        //column1,column2,captured-piece,new-piece,P
                        list=list+c+c+oldPiece+temp[k]+"P";
                        
                        hflag=1;
                    }
                    AlphaBetaChess.chessBoard[r][c]="P";
                    AlphaBetaChess.chessBoard[r-1][c]=oldPiece;
                    
                    
                    //paint
                    if(hflag==1)
                    {
                    	HighLight h = new HighLight(c*square, (r-1)*square, square);
                    	h.paintComponent(g);
                    	hflag=0;
                    } 
                }
            }
        } catch (Exception e) {}
        
        
      //move two up
        try {
            if (" ".equals(AlphaBetaChess.chessBoard[r-1][c]) && " ".equals(AlphaBetaChess.chessBoard[r-2][c]) && pos>=48) {
            	hflag=0;
            	
            	oldPiece=AlphaBetaChess.chessBoard[r-2][c];
                AlphaBetaChess.chessBoard[r][c]=" ";
                AlphaBetaChess.chessBoard[r-2][c]="P";
                if (kingSafe()) {
                    list=list+r+c+(r-2)+c+oldPiece;
                    
                    hflag=1;
                }
                AlphaBetaChess.chessBoard[r][c]="P";
                AlphaBetaChess.chessBoard[r-2][c]=oldPiece;
                
              //paint
                if(hflag==1)
                {
                	HighLight h = new HighLight(c*square, (r-2)*square, square);
                	h.paintComponent(g);
                	hflag=0;
                } 
            }
        } catch (Exception e) {}
        return list;
    }
    
    
    
    //rock
    public static String posibleR(int pos) {
        String list="", oldPiece;
        int r=pos/8, c=pos%8;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            try {
                while(" ".equals(AlphaBetaChess.chessBoard[r][c+temp*j]))
                {
                	hflag=0;
                	
                    oldPiece=AlphaBetaChess.chessBoard[r][c+temp*j];
                    AlphaBetaChess.chessBoard[r][c]=" ";
                    AlphaBetaChess.chessBoard[r][c+temp*j]="R";
                    if (kingSafe()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                        
                        hflag=1;
                    }
                    AlphaBetaChess.chessBoard[r][c]="R";
                    AlphaBetaChess.chessBoard[r][c+temp*j]=oldPiece;
                                       
                    //paint
                    if(hflag==1)
                    {
                    	HighLight h = new HighLight((c+temp*j)*square, r*square, square);
                    	h.paintComponent(g);
                    	hflag=0;
                    } 
                    temp++;
                }
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r][c+temp*j].charAt(0))) {
                	hflag=0;
                	
                    oldPiece=AlphaBetaChess.chessBoard[r][c+temp*j];
                    AlphaBetaChess.chessBoard[r][c]=" ";
                    AlphaBetaChess.chessBoard[r][c+temp*j]="R";
                    if (kingSafe()) {
                        list=list+r+c+r+(c+temp*j)+oldPiece;
                        
                        hflag=1;
                    }
                    AlphaBetaChess.chessBoard[r][c]="R";
                    AlphaBetaChess.chessBoard[r][c+temp*j]=oldPiece;
                                       
                    //paint
                    if(hflag==1)
                    {
                    	HighLight h = new HighLight((c+temp*j)*square, r*square, square);
                     	h.paintComponent(g);
                    	hflag=0;
                    } 
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(AlphaBetaChess.chessBoard[r+temp*j][c]))
                {
                	hflag=0;
                	
                    oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c];
                    AlphaBetaChess.chessBoard[r][c]=" ";
                    AlphaBetaChess.chessBoard[r+temp*j][c]="R";
                    if (kingSafe()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                        
                     hflag=1;
                    }
                    AlphaBetaChess.chessBoard[r][c]="R";
                    AlphaBetaChess.chessBoard[r+temp*j][c]=oldPiece;
                    
                  //paint
                    if(hflag==1)
                    {
                    	HighLight h = new HighLight(c*square, (r+temp*j)*square, square);
                    	h.paintComponent(g);
                    	hflag=0;
                    } 
                    temp++;
                }
                if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+temp*j][c].charAt(0))) {
                	hflag=0;
                	
                    oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c];
                    AlphaBetaChess.chessBoard[r][c]=" ";
                    AlphaBetaChess.chessBoard[r+temp*j][c]="R";
                    if (kingSafe()) {
                        list=list+r+c+(r+temp*j)+c+oldPiece;
                        
                        hflag=1; 
                    }
                    AlphaBetaChess.chessBoard[r][c]="R";
                    AlphaBetaChess.chessBoard[r+temp*j][c]=oldPiece;
                    
                  //paint
                    if(hflag==1)
                    {
                    	HighLight h = new HighLight(c*square, (r+temp*j)*square, square);
                     	h.paintComponent(g);
                    	hflag=0;
                    } 
                }
            } catch (Exception e) {}
            temp=1;
        }
        return list;
    }
    
    
    
    //knight
    public static String posibleK(int pos) {
        String list="", oldPiece;
        int r=pos/8, c=pos%8;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                try {
                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+j][c+k*2].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r+j][c+k*2])) {
                        hflag=0;
                       
                    	oldPiece=AlphaBetaChess.chessBoard[r+j][c+k*2];
                        AlphaBetaChess.chessBoard[r][c]=" ";
                        if (kingSafe()) {
                            list=list+r+c+(r+j)+(c+k*2)+oldPiece;
                            
                            hflag=1;
                        }
                        AlphaBetaChess.chessBoard[r][c]="K";
                        AlphaBetaChess.chessBoard[r+j][c+k*2]=oldPiece;
                        
                      //paint
                        if(hflag==1)
                        {
                        	HighLight h = new HighLight((c+k*2)*square, (r+j)*square, square);
                         	h.paintComponent(g);
                        	hflag=0;
                        } 
                    }
                } catch (Exception e) {}
                try {
                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+j*2][c+k].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r+j*2][c+k])) {
                        hflag=0;
                        
                    	oldPiece=AlphaBetaChess.chessBoard[r+j*2][c+k];
                        AlphaBetaChess.chessBoard[r][c]=" ";
                        
                        if (kingSafe()) {
                            list=list+r+c+(r+j*2)+(c+k)+oldPiece;
                            
                           hflag=1;
                        }                      
                        AlphaBetaChess.chessBoard[r][c]="K";
                        AlphaBetaChess.chessBoard[r+j*2][c+k]=oldPiece;
                        
                      //paint
                        if(hflag==1)
                        {
                        	HighLight h = new HighLight((c+k)*square, (r+j*2)*square, square);
                        	h.paintComponent(g);
                        	hflag=0;
                        } 
                    }
                } catch (Exception e) {}
            }
        }
        return list;
    }
    
    
    
    //bishop
    public static String posibleB(int pos) {
        String list="", oldPiece;
        int r=pos/8, c=pos%8;
        int temp=1;
        for (int j=-1; j<=1; j+=2) {
            for (int k=-1; k<=1; k+=2) {
                try {
                    while(" ".equals(AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]))
                    {
                    	hflag=0;
                    	
                        oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c+temp*k];
                        AlphaBetaChess.chessBoard[r][c]=" ";
                        AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]="B";
                        
                        if (kingSafe()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                            
                        	hflag=1;
                        }
                        AlphaBetaChess.chessBoard[r][c]="B";
                        AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        
                        
                        //paint
                        if(hflag==1)
                        {
                        	HighLight h = new HighLight((c+temp*k)*square, (r+temp*j)*square, square);
                        	h.paintComponent(g);
                        	hflag=0;
                        } 
                        temp++;
                    }
                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                    	hflag=0;
                    	
                        oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c+temp*k];
                        AlphaBetaChess.chessBoard[r][c]=" ";
                        AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]="B";
                        
                        if (kingSafe()) {
                            list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                       
                            hflag=1;
                        }
                        AlphaBetaChess.chessBoard[r][c]="B";
                        AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]=oldPiece;
                        
                        
                        //paint
                        if(hflag==1)
                        {
                        	HighLight h = new HighLight((c+temp*k)*square, (r+temp*j)*square, square);
                        	h.paintComponent(g);
                        	hflag=0;
                        }
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        return list;
    }
    
    
    
    //queen
    public static String posibleQ(int pos) {
        String list="", oldPiece;
        int r=pos/8, c=pos%8;
        int temp=1;
        for (int j=-1; j<=1; j++) {
            for (int k=-1; k<=1; k++) {
                if (j!=0 || k!=0) {
                    try {
                        while(" ".equals(AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]))
                        {
                        	hflag=0;
                        	
                            oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c+temp*k];
                            AlphaBetaChess.chessBoard[r][c]=" ";
                            AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]="Q";
                            
                            if (kingSafe()) {
                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                                
                                hflag=1;
                            }                        
                            AlphaBetaChess.chessBoard[r][c]="Q";
                            AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]=oldPiece;
                            
                            
                            //paint
                            if(hflag==1)
                            {
                            	HighLight h = new HighLight((c+temp*k)*square, (r+temp*j)*square, square);
                            	h.paintComponent(g);
                            	hflag=0;
                            }
                            temp++;
                        }
                        if (Character.isLowerCase(AlphaBetaChess.chessBoard[r+temp*j][c+temp*k].charAt(0))) {
                        	hflag=0;
                        	
                            oldPiece=AlphaBetaChess.chessBoard[r+temp*j][c+temp*k];
                            AlphaBetaChess.chessBoard[r][c]=" ";
                            AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]="Q";
                            
                            if (kingSafe()) {
                                list=list+r+c+(r+temp*j)+(c+temp*k)+oldPiece;
                              
                              hflag=1;  
                            }                              
                            AlphaBetaChess.chessBoard[r][c]="Q";
                            AlphaBetaChess.chessBoard[r+temp*j][c+temp*k]=oldPiece;
                            
                          //paint
                            if(hflag==1)
                            {
                            	HighLight h = new HighLight((c+temp*k)*square, (r+temp*j)*square, square);
                            	h.paintComponent(g);
                            	hflag=0;
                            } 
                        }
                    } catch (Exception e) {}
                    temp=1;
                }
            }
        }
        return list;
    }
    
    
    
    //king
    public static String posibleA(int pos) {
        String list="", oldPiece;
        int r=pos/8, c=pos%8;
        for (int j=0;j<9;j++) {
            if (j!=4) {
                try {
                    if (Character.isLowerCase(AlphaBetaChess.chessBoard[r-1+j/3][c-1+j%3].charAt(0)) || " ".equals(AlphaBetaChess.chessBoard[r-1+j/3][c-1+j%3])) {
                        hflag=0;
                        
                    	oldPiece=AlphaBetaChess.chessBoard[r-1+j/3][c-1+j%3];
                        AlphaBetaChess.chessBoard[r][c]=" ";
                        AlphaBetaChess.chessBoard[r-1+j/3][c-1+j%3]="A";
                        int kingTemp=AlphaBetaChess.kingPositionC;
                        AlphaBetaChess.kingPositionC=pos+(j/3)*8+j%3-9;
                        
                        if (kingSafe()) {
                            list=list+r+c+(r-1+j/3)+(c-1+j%3)+oldPiece;
                            
                         hflag=1;
                        }
                        AlphaBetaChess.chessBoard[r][c]="A";
                        AlphaBetaChess.chessBoard[r-1+j/3][c-1+j%3]=oldPiece;
                        AlphaBetaChess.kingPositionC=kingTemp;
                        
                      //paint
                        if(hflag==1)
                        {
                        	HighLight h = new HighLight((c-1+j%3)*square, (r-1+j/3)*square, square);
                        	h.paintComponent(g);
                        	hflag=0;
                        }  
                    }
                } catch (Exception e) {}
            }
        }
        //need to add casting later
        return list;
    } 
    
    
    
    //king safe
    public static boolean kingSafe() {
    	
        //bishop/queen
        int temp=1;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    while(" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8+temp*j])) {temp++;}
                    if ("b".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8+temp*j]) ||
                            "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8+temp*j])) {
                        return false;
                    }
                } catch (Exception e) {}
                temp=1;
            }
        }
        
        //rook/queen
        for (int i=-1; i<=1; i+=2) {
            try {
                while(" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8][AlphaBetaChess.kingPositionC%8+temp*i])) {temp++;}
                if ("r".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8][AlphaBetaChess.kingPositionC%8+temp*i]) ||
                        "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8][AlphaBetaChess.kingPositionC%8+temp*i])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
            try {
                while(" ".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8])) {temp++;}
                if ("r".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8]) ||
                        "q".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+temp*i][AlphaBetaChess.kingPositionC%8])) {
                    return false;
                }
            } catch (Exception e) {}
            temp=1;
        }
        
        //knight
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                try {
                    if ("k".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+i][AlphaBetaChess.kingPositionC%8+j*2])) {
                        return false;
                    }
                } catch (Exception e) {}
                try {
                    if ("k".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+i*2][AlphaBetaChess.kingPositionC%8+j])) {
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
        
        //pawn
        if (AlphaBetaChess.kingPositionC>=16) {
            try {
                if ("p".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8-1][AlphaBetaChess.kingPositionC%8-1])) {
                    return false;
                }
            } catch (Exception e) {}
            try {
                if ("p".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8-1][AlphaBetaChess.kingPositionC%8+1])) {
                    return false;
                }
            } catch (Exception e) {}
            
            //king
            for (int i=-1; i<=1; i++) {
                for (int j=-1; j<=1; j++) {
                    if (i!=0 || j!=0) {
                        try {
                            if ("a".equals(AlphaBetaChess.chessBoard[AlphaBetaChess.kingPositionC/8+i][AlphaBetaChess.kingPositionC%8+j])) {
                                return false;
                            }
                        } catch (Exception e) {}
                    }
                }
            }
        }
        return true;
    }



	
	

}

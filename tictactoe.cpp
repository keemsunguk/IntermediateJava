#include <iostream>
#include "tictactoe.h"

using namespace std;


void main()
{
	TTT ttt;

	int my_turn = ttt.DecideTurn();  //1 = computer, 0 = my turn

	if(my_turn == 1) {  //computer first
		ttt.GetCenter();
		ttt.ShowMap();
	}

	int flag = 0;
	while (flag == 0) {
		flag = ttt.GetInput();
	}

	if( ttt.IsCenterEmpty()) {
		ttt.GetCenter();
		ttt.ShowMap();
		flag = 0;
		while (flag == 0) {
			flag = ttt.GetInput();
		}
	}
	ttt.ShowMap();

	bool loop_flag = true;
	bool defend_flag = false;
	bool attack_flag = false;

	while (loop_flag) {
		if(ttt.CheckMate()) {
			ttt.ShowMap();
			loop_flag = false;
			cout << ">>> GAME OVER <<<" << endl;
			break;
		}
		defend_flag = ttt.Defend();
		if (!defend_flag) {
			attack_flag = ttt.Attack();
			cout << "attacked" << endl;
		}  

		ttt.ShowMap();
		if ( !defend_flag && !attack_flag ) {
			loop_flag = false;
			cout << ">>> GAME OVER <<<" << endl;
		} else {
			int small_flag = 0;
			while (small_flag == 0) {
				small_flag = ttt.GetInput();
			}
			loop_flag = ttt.IsGameOn();
		}
		ttt.ShowMap();
	}
			
}


////Constructor ///
TTT::TTT() 
{
	empty = 0;
	player = 1;	//Human Player
	comp = 2;  //Computer

	for(int i = 0; i < 9; i++) {
		tttmap[i] = empty;
	}
}
//////////////////////////////////
// 1 = computer, 0 = my turn
int TTT::DecideTurn()
{
	 //initialize random seed
	srand ( time(NULL) );
	int rno = rand();
	return (rno%2);
}
///////////////////////////
bool TTT::IsCenterEmpty()
{
	if(tttmap[4] == empty) return true;
	else return false;
}
///////////////////////////
void TTT::GetCenter()
{
	tttmap[4] = comp;
}
///////////////////////////
void TTT::ShowMap()
{
	cout << "---+---+---+" << endl;
	for(int i = 0; i < 3 ; i++) {
		for(int j = 0; j < 3; j++) {
			if (tttmap[j+i*3] == 0) cout << "   |";
			else if (tttmap[j+i*3] == 1) cout << " X |";
			else cout << " O |";
		}
		cout << endl << "---+---+---+" << endl;
	}
}
int TTT::GetInput()
{
	int my_position;
	int input_result = 0;

	cout << "---+---+---+" << endl;
	cout << " 1 | 2 | 3 " << endl;
	cout << "---+---+---+" << endl;
	cout << " 4 | 5 | 6 " << endl;
	cout << "---+---+---+" << endl;
	cout << " 7 | 8 | 9 " << endl;
	cout << "---+---+---+" << endl << endl;

	cout << "Select your entry number: ";
	cin >> my_position;

	if(my_position >=1 && my_position <=9) {
		if(tttmap[my_position -1] == 0) {
			tttmap[my_position -1] = player;
			input_result = 1;
		} else {
			cout << "Occupied!! Select another entry." << endl;
			input_result = 0;
		}
	} else {
		cout << "Please select from 1 to 9 only" << endl;
		input_result = 0;
	}
	return input_result;
}
//////////////////
bool TTT::Defend()
{

	if(tttmap[0] == player) {
		if(tttmap[1] == player) {
			if(tttmap[2] == empty) {
				tttmap[2] = comp;
				return true;
			}
		}else if(tttmap[2] == player) {
			if(tttmap[1] == empty) {
				tttmap[1] = comp;
				return true;
			}
		}
		if(tttmap[3] == player) {
			if(tttmap[6] == empty) {
				tttmap[6] = comp;
				return true;
			}
		} else if(tttmap[6] == player) {
			if(tttmap[3] == empty) {
				tttmap[3] = comp;
				return true;
			}
		}
		if(tttmap[4] == player) {
			if(tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		} else if(tttmap[8] == player) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		} 
	}
	//	case 1:
	if (tttmap[1] == player) {
		if(tttmap[4] == player) {
			if(tttmap[7] == empty) {
				tttmap[7] = comp;
				return true;
			}
		} else if(tttmap[7] == player) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		}
	}
//		case 2:
	if (tttmap[2] == player) {
		if(tttmap[4] == player) {
			if(tttmap[6] == empty) {
				tttmap[6] = comp;
				return true;
			}
		} else if(tttmap[6] == player) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		}
		if(tttmap[5] == player) {
			if(tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		} else if (tttmap[8] == player) {
			if(tttmap[5] == empty) {
				tttmap[5] = comp;
				return true;
			}
		}
	}
//		case 3:
	if (tttmap[3] == player) {
		if(tttmap[4] == player) {
			if(tttmap[5] == empty) {
				tttmap[5] = comp;
				return true;
			}
		} else if(tttmap[5] == player) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		} 
	}
	if (tttmap[4] == player) {
//		case 4:
		if(tttmap[5] == player) {
			if(tttmap[3] == empty) {
				tttmap[3] = comp;
				return true;
			}
		} else if(tttmap[6] == player) {
			if(tttmap[2] == empty) {
				tttmap[2] = comp;
				return true;
			}
		} else if(tttmap[7] == player) {
			if(tttmap[1] == empty) {
				tttmap[1] = comp;
				return true;
			}
		} else if(tttmap[8] == player) {
			if(tttmap[0] == empty) {
				tttmap[0] = comp;
				return true;
			}
		}
	}
	if (tttmap[6] == player) {
//		case 6:
		if(tttmap[7] == player) {
			if(tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		} else if (tttmap[8] == player) {
			if(tttmap[7] == empty) {
				tttmap[7] = comp;
				return true;
			}
		} 
	}
	if (tttmap[7] == player) {
	//	case 7:
		if(tttmap[8] == player) {
			if(tttmap[6] == empty) {
				tttmap[6] = comp;
				return true;
			}
		}
	}

	return false;
}
///////////////
bool TTT::CheckMate()
{
	if(tttmap[0] == comp) {
		if(tttmap[1] == comp) {
			if(tttmap[2] == empty) {
				tttmap[2] = comp;
				return true;
			}
		} else if(tttmap[2] == comp) {
			if(tttmap[1] == empty) {
				tttmap[1] = comp;
				return true;
			}
		}

		if(tttmap[3] == comp) {
			if(tttmap[6] == empty) {
				tttmap[6] = comp;
				return true;
			}
		} else if(tttmap[6] == comp) {
			if(tttmap[3] == empty) {
				tttmap[3] = comp;
				return true;
			}
		}

		if(tttmap[4] == comp) {
			if(tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		} else if(tttmap[8] == comp) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		} 
	}
		//	case 1:
	if (tttmap[1] == comp) {
		if(tttmap[4] == comp) {
			if(tttmap[7] == empty) {
				tttmap[7] = comp;
				return true;
			}
		} else if(tttmap[7] == comp) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		}
	}
	//		case 2:
	
	if (tttmap[2] == comp) {
		if(tttmap[4] == comp) {
			if(tttmap[6] == empty) {
				tttmap[6] = comp;
				return true;
			}
		} else if(tttmap[6] == comp) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		}
		if(tttmap[5] == comp) {
			if(tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		} else if (tttmap[8] == comp) {
			if(tttmap[5] == empty) {
				tttmap[5] = comp;
				return true;
			}
		}
	}

	//		case 3:
	if (tttmap[3] == comp) {
		if(tttmap[4] == comp) {
			if(tttmap[5] == empty) {
				tttmap[5] = comp;
				return true;
			}
		} else if(tttmap[5] == comp) {
			if(tttmap[4] == empty) {
				tttmap[4] = comp;
				return true;
			}
		} 
	}
	
	if (tttmap[4] == comp) {
	//		case 4:
		if(tttmap[5] == comp) {
			if(tttmap[3] == empty) {
				tttmap[3] = comp;
				return true;
			}
		} else if(tttmap[6] == comp) {
			if(tttmap[2] == empty) {
				tttmap[2] = comp;
				return true;
			}
		} else if(tttmap[7] == comp) {
			if(tttmap[1] == empty) {
				tttmap[1] = comp;
				return true;
			}
		} else if(tttmap[8] == comp) {
			if(tttmap[0] == empty) {
				tttmap[0] = comp;
				return true;
			}
		}
	}

	if (tttmap[6] == comp) {
	//		case 6:
		if(tttmap[7] == comp) {
			if(tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		} else if (tttmap[8] == comp) {
			if(tttmap[7] == empty) {
				tttmap[7] = comp;
				return true;
			}
		} 	
	}

	if (tttmap[7] == comp) {
		//	case 7:
		if(tttmap[8] == comp) {
			if(tttmap[6] == empty) {
				tttmap[6] = comp;
				return true;
			}
		}
	}
	return false;
}
///////////////////
bool TTT::Attack()
{
	if(tttmap[4] == comp) {
	//take corner
		if(tttmap[0] == empty && tttmap[8] == empty )  {
			tttmap[0] = comp;
			return true;
		} else if(tttmap[2] == empty && tttmap[6] == empty )  {
			tttmap[2] = comp;
			return true;
		} 

	//if corners are taken
		if(tttmap[1] == empty && tttmap[7] == empty)  {
			tttmap[1] = comp;
			return true;
		} else if(tttmap[3] == empty && tttmap[5] == empty)  {
			tttmap[3] = comp;
			return true;
		}
	} else {
		if (tttmap[0] == empty) {
		//take corner
			if( (tttmap[3] == empty && tttmap[6] == empty )|| 
				(tttmap[2] == empty && tttmap[8] == empty )){
				tttmap[0] = comp;
				return true;
			} 
		} else if(tttmap[2] == empty && tttmap[5] == empty && tttmap[8] == empty) {
			//if corners are taken
			tttmap[2] = comp;
			return true;
		} else if(tttmap[6] == empty && tttmap[7] == empty&& tttmap[8] == empty)  {
			tttmap[6] = comp;
			return true;
		} else if (tttmap[0] == comp) {
			if(tttmap[1] == empty && tttmap[2] == empty) {
				tttmap[2] = comp;
				return true;
			} else if(tttmap[3] == empty && tttmap[6] == empty) {
				tttmap[3] = comp;
				return true;
			}
		} else if (tttmap[6] == comp) {
			if(tttmap[7] == empty && tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		} else if(tttmap[2] == comp) {
			if(tttmap[5] == empty && tttmap[8] == empty) {
				tttmap[8] = comp;
				return true;
			}
		}
	}

	return false;
}

bool TTT::IsGameOn()
{
	int map_sum = tttmap[0]+tttmap[1]+tttmap[2]+tttmap[3]+tttmap[6];

	if( map_sum != empty) { 
		if(tttmap[0] == tttmap[1] && tttmap[1] == tttmap[2] && tttmap[0] != empty) {
			return false;
		} else if (tttmap[0] == tttmap[3] && tttmap[3] == tttmap[6] && tttmap[0] != empty) {
			return false;
		} else if (tttmap[0] == tttmap[4] && tttmap[4] == tttmap[8] && tttmap[0] != empty) {
			return false;
		} else if (tttmap[1] == tttmap[4] && tttmap[4] == tttmap[7] && tttmap[1] != empty) {
			return false;
		} else if (tttmap[2] == tttmap[4] && tttmap[4] == tttmap[6] && tttmap[2] != empty) {
			return false;
		} else if (tttmap[2] == tttmap[5] && tttmap[5] == tttmap[8] && tttmap[2] != empty) {
			return false;
		} else if (tttmap[3] == tttmap[4] && tttmap[4] == tttmap[5] && tttmap[3] != empty) {
			return false;
		} else if (tttmap[6] == tttmap[7] && tttmap[7] == tttmap[8] && tttmap[6] != empty) {
			return false;
		} 
	}
	return true;
}
////////////////// i +=3
//https://leetcode.com/problems/search-a-2d-matrix/



class Solution {
				public boolean searchMatrix(int[][] matrix, int target)
				{
						int row = findRow(matrix,target);
						if(row==-1)
								return false;
						int left  =0;
						int right = matrix[0].length-1;
					  // search element in finded row.
						while(left<=right)
						{

								int mid = left+(right-left)/2;
								if(matrix[row][mid]==target)
										return true;
								else if(matrix[row][mid]<target)
										left = mid+1;
								else
										right = mid-1;
						}
						return false;
				}

				// This function search row where element might be lies.
				public int findRow(int [][]matrix ,int target)
				{

							int upRow = 0;
							int downRow = matrix.length-1;
							int cols = matrix[0].length;

							while(upRow<=downRow)
							{

									int mid = upRow+(downRow-upRow)/2;
									if(target>=matrix[mid][0]&&target<=matrix[mid][cols-1])
											return mid;
									else if(target<matrix[mid][0])
											downRow=mid-1;
									else
											upRow = mid+1;
							}
							return -1;
			 }
}


//TC:- O(logM + logN) 
//logM for searching target row and logN for seraching target element in target row.
//SC:- O(1)


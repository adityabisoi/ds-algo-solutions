#include <iostream>
#include <vector>
#include <algorithm>
#include <new>

typedef long long ll;

using namespace std;

int main()
{
	long int n,q,i,j,k,a,b;
	
	cin>>n>>q;
	
	// adjacency list
	vector< vector<long int> > nodes, copy;
	for(i=0;i<n;i++)
	{	vector<long int> row;
		nodes.push_back(row);
	}		
	for(i=0;i<n-1;i++)
	{	cin>>a>>b;
		nodes[a-1].push_back(b);
		nodes[b-1].push_back(a);
	}
	
	// preprocessing arrays
	long int N = 2*n-1, results[q], *firstindex, *rootdist, *eulerarray, *parent;
	firstindex = new long int[N];
	rootdist = new long int[n];
	eulerarray = new long int[N];
	parent = new long int[n];

	// -------- euler tour----------------
	copy = nodes;
	long int idx,crnode=1, dist=0, nextnode;
	parent[crnode-1] = 0; 
	rootdist[crnode-1] = 0;
	firstindex[crnode-1] = 0;

	i = 0;
	while(i<N-1)
	{	eulerarray[i] = crnode;
		if (copy[crnode-1].size()>1 && copy[crnode-1][0]==parent[crnode-1])
			idx = 1;
		else
			idx = 0;

		nextnode = copy[crnode-1][idx];		
		
		// if going up 
		if (nextnode==parent[crnode-1])
			dist--;
		//going down
		else
		{	dist++;
			parent[nextnode-1] = crnode;
			rootdist[nextnode-1] = dist;
			firstindex[nextnode-1] = i+1;
		}

		copy[crnode-1].erase(copy[crnode-1].begin()+idx);
		crnode = nextnode;
		i++;
	}
	eulerarray[i] = 1;
	// -------------------------------------------
	
	// -------------- rmqtable -------------------
	vector< vector <long int> > rmqtable;
	for(i=0;i<N-1;i++)
	{	vector<long int> row;
		rmqtable.push_back(row);
	}
	
	long int inc=2,val;
	for(i=0;i<N-1;i++)
	{	val = min(eulerarray[i],eulerarray[i+1]);
		rmqtable[i].push_back(val);
	}

	while(inc<N-1)
	{	i = 0;
		while (i+inc<N-1)
		{	val = min(rmqtable[i].back(),rmqtable[i+inc/2].back());
			rmqtable[i].push_back(val);
			i++;
		}
		inc = inc * 2;		
	}	

	// ---------------------------------------------	

	//log2 and pow2 array calculation
	vector<long int> log2array, pow2array;
	log2array.push_back(0);
	i =1;
	long int li;
	val = 1;
	while (i<2*n-1)
	{	li = 2*i;
		while(i<=li)
		{	log2array.push_back(val);
			i++;
		}
		val++;
	}
	pow2array.push_back(1);
	for(i=1;i<val;i++)
		pow2array.push_back(pow2array.back()*2);	
	
	// -------------------------------------------------------
	
	int exist[n];
	for(j=0;j<n;j++)
			exist[j] = 0;

	long int x,y,q1,q2,temp,l1,l2,l3,lca,denom = 1000000007,sum;
	long int query,S1,S2,Sq,S,Sqrq,S_qlcaq,t1,t2,tsqrq,temp1,temp2;

	for(i=0;i<q;i++)
	{	cin>>k;
		
		if(k*k<n)
		{	vector<long int> qset(k);
			for(j=0;j<k;j++)
			{	cin>>query;
				qset[j] = query;
			}
			
			// -------------------- RMQ TABLE METHOD --------------------
			//cout<<"rmq table "<<endl;
			sum = 0;
			for(x=0;x<k-1;x++)
			{	q1 = qset[x];
				for(y=x+1;y<k;y++)
				{	q2 = qset[y];
					l1 = firstindex[q1-1];
					l3 = firstindex[q2-1];			
					if (l1>l3)
					{	temp = l1;
						l1 = l3;
						l3 = temp;
					}
					long int logdiff = log2array[l3-l1-1];
					l2 = l3 - pow2array[logdiff];
					
					if (l1==l2)
						lca = rmqtable[l1][logdiff];
					else
						lca =  min(rmqtable[l1][logdiff], rmqtable[l2][logdiff]);
						
					dist = (rootdist[q1-1] + rootdist[q2-1] - 2*rootdist[lca-1]);
					dist = (dist*q1*q2)%denom;
					sum = (sum + dist)%denom; 
				}						
			}
			results[i] = sum;	
			// ---------------------------------------------------------					
		}

		else
		{	for(j=0;j<k;j++)
			{	cin>>query;
				exist[query-1] = 1;
			}
			
			// --------------- TREE TRAVERSAL METHOD -------------------
			//cout<< "tree TRAVERSAL"<<endl;
			vector<long int> opennodes;
			copy = nodes;
			crnode = 1;

			x=0, S1=0, S2=0, Sq=0, Sqrq=0, S_qlcaq=0,dist=0;
			while(x<k)
			{
				// visiting a query node for the first time
				if (exist[crnode-1]==1)
				{
					exist[crnode-1] = 0;

					tsqrq = ((ll)dist*(ll)crnode)%denom;
					temp2 = ((ll)crnode*(ll)Sqrq)%denom;
					t2 = ((ll)crnode*(ll)S_qlcaq)%denom;
					temp1 = ((ll)tsqrq*(ll)Sq)%denom;
					t1 = (temp1 + temp2)%denom;
					
					S1 = (S1 + t1)%denom;
					S2 = (S2 + t2)%denom;
					Sq = (Sq + crnode)%denom;
					Sqrq = (Sqrq+ tsqrq)%denom;
					S_qlcaq = (S_qlcaq + tsqrq)%denom;
					
					opennodes.push_back(crnode);
					opennodes.push_back(dist);
					x++;
				}

				// finding the next node in the tree
				if (copy[crnode-1].size()>1 && copy[crnode-1][0]==parent[crnode-1])
					idx = 1;
				else
					idx = 0;

				nextnode = copy[crnode-1][idx];
				
				// if going up 
				if (nextnode==parent[crnode-1])
				{	// updating the opennodes vector
					if (opennodes.size()>0 and opennodes.back()==dist)
					{	S_qlcaq = S_qlcaq - opennodes.rbegin()[1];
						if (opennodes.size()>2 and opennodes.rbegin()[2] == dist-1)
						{	opennodes.rbegin()[3] = (opennodes.rbegin()[3] + opennodes.rbegin()[1])%denom;
							opennodes.pop_back();
							opennodes.pop_back();
						}
						else
							opennodes.back()--;				
					}
					dist--;
				}	

				//going down
				else
					dist++;
				
				copy[crnode-1].erase(copy[crnode-1].begin()+idx);
				crnode = nextnode;	
			}

			sum = S1-2*S2;
			while (sum<0)
				sum = sum + denom;
			results[i] = sum%denom;
				
		}			
	}
	
	for(i=0;i<q;i++)
		cout<<results[i]<<endl;
	
    delete [] firstindex;
	delete [] eulerarray;
	delete [] rootdist;
	delete [] parent;
	return 0;
}

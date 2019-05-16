#!/usr/bin/env python3

import sqlite3
import pandas as pd
import random

''' Script to open connection to database file, add new column, and populate
		column with random integer for rating. '''

conn = sqlite3.connect('games.db')
c = conn.cursor()

tables = c.execute('SELECT name FROM sqlite_master WHERE type=\'table\';').fetchall()
game_list = c.execute('SELECT * FROM Listings;').fetchall()

print (tables)
print ('')

# Insert 'Rating' column to the 'Listing' table
# c.execute ('ALTER TABLE Listings ADD COLUMN \'Rating\' \'integer\'')

# Update 'Rating' column with random integer from 0 to 5
# for i in range(len(game_list)):
# 	rate = int(random.random() * 6)
# 	c.execute (f'UPDATE Listings SET Rating={rate} WHERE GameID={i + 1}')
	
query = 'SELECT * FROM Listings;'
print (pd.read_sql_query(query, conn).head(20))

conn.commit()
conn.close()
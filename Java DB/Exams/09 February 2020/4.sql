DELETE FROM players
WHERE id IN(
	SELECT player_id FROM players_coaches WHERE coach_id = player_id
)
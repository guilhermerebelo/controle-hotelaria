CREATE FUNCTION contem_locacao(dataInicial date, dataFinal date, quarto int) RETURNS int AS $$
BEGIN
   RETURN (
	select
		count(*) as r
	from
		Locacao as l
	where
		(l.data_inicial between dataInicial and dataFinal)
			or (l.data_final between dataInicial and dataFinal)
			or (l.data_inicial <= dataInicial and l.data_final >= dataFinal)
		and (l.id_quarto = quarto));
END
$$ LANGUAGE plpgsql;


create
	function contem_locacao_trigger() returns trigger as $contem_locacao_trigger$
begin
	if public.contem_locacao(new.data_inicial, new.data_final, new.id_quarto) > 0 then
		raise exception 'Existe uma locação em andamento';
end if;
return new;
end;

$contem_locacao_trigger$ language plpgsql;



create
	trigger contem_locacao_trigger before insert
		or update
			on
			locacao for each row execute procedure contem_locacao_trigger();
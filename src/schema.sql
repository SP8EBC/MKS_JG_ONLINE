--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.13
-- Dumped by pg_dump version 9.5.12

-- Started on 2018-08-18 22:44:42 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2168 (class 1262 OID 16384)
-- Name: mks_jg_online; Type: DATABASE; Schema: -; Owner: mks_jg_online_user
--

CREATE DATABASE mks_jg_online WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pl_PL.UTF-8' LC_CTYPE = 'pl_PL.UTF-8';


ALTER DATABASE mks_jg_online OWNER TO mks_jg_online_user;

\connect mks_jg_online

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12395)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2171 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 16400)
-- Name: competition_data; Type: TABLE; Schema: public; Owner: mks_jg_online_user
--

CREATE TABLE public.competition_data (
    id integer NOT NULL,
    competition_serial_number bigint,
    competition_id integer,
    competitor_name text,
    competitor_start_number integer,
    competitor_rank integer,
    competitor_partial_rank integer,
    club_name text,
    training_runs_times_str text[],
    scored_runs_times_str text[]
);


ALTER TABLE public.competition_data OWNER TO mks_jg_online_user;

--
-- TOC entry 183 (class 1259 OID 16398)
-- Name: competitionData_id_seq; Type: SEQUENCE; Schema: public; Owner: mks_jg_online_user
--

CREATE SEQUENCE public."competitionData_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."competitionData_id_seq" OWNER TO mks_jg_online_user;

--
-- TOC entry 2172 (class 0 OID 0)
-- Dependencies: 183
-- Name: competitionData_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mks_jg_online_user
--

ALTER SEQUENCE public."competitionData_id_seq" OWNED BY public.competition_data.id;


--
-- TOC entry 182 (class 1259 OID 16389)
-- Name: competitions; Type: TABLE; Schema: public; Owner: mks_jg_online_user
--

CREATE TABLE public.competitions (
    id integer NOT NULL,
    serial_num bigint,
    competitions_name text,
    date date,
    location text,
    track_name text,
    logo1 text,
    logo2 text,
    judge1 text,
    judge2 text,
    judge3 text,
    organizer text,
    comp_count integer
);


ALTER TABLE public.competitions OWNER TO mks_jg_online_user;

--
-- TOC entry 181 (class 1259 OID 16387)
-- Name: competitions_id_seq; Type: SEQUENCE; Schema: public; Owner: mks_jg_online_user
--

CREATE SEQUENCE public.competitions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.competitions_id_seq OWNER TO mks_jg_online_user;

--
-- TOC entry 2173 (class 0 OID 0)
-- Dependencies: 181
-- Name: competitions_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mks_jg_online_user
--

ALTER SEQUENCE public.competitions_id_seq OWNED BY public.competitions.id;


--
-- TOC entry 186 (class 1259 OID 16411)
-- Name: competitions_to_competition_mapping; Type: TABLE; Schema: public; Owner: mks_jg_online_user
--

CREATE TABLE public.competitions_to_competition_mapping (
    id integer NOT NULL,
    cmps_name text,
    competition_serial_number bigint
);


ALTER TABLE public.competitions_to_competition_mapping OWNER TO mks_jg_online_user;

--
-- TOC entry 185 (class 1259 OID 16409)
-- Name: competitions_to_competition_mapping_id_seq; Type: SEQUENCE; Schema: public; Owner: mks_jg_online_user
--

CREATE SEQUENCE public.competitions_to_competition_mapping_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.competitions_to_competition_mapping_id_seq OWNER TO mks_jg_online_user;

--
-- TOC entry 2174 (class 0 OID 0)
-- Dependencies: 185
-- Name: competitions_to_competition_mapping_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: mks_jg_online_user
--

ALTER SEQUENCE public.competitions_to_competition_mapping_id_seq OWNED BY public.competitions_to_competition_mapping.id;


--
-- TOC entry 2035 (class 2604 OID 16403)
-- Name: id; Type: DEFAULT; Schema: public; Owner: mks_jg_online_user
--

ALTER TABLE ONLY public.competition_data ALTER COLUMN id SET DEFAULT nextval('public."competitionData_id_seq"'::regclass);


--
-- TOC entry 2034 (class 2604 OID 16392)
-- Name: id; Type: DEFAULT; Schema: public; Owner: mks_jg_online_user
--

ALTER TABLE ONLY public.competitions ALTER COLUMN id SET DEFAULT nextval('public.competitions_id_seq'::regclass);


--
-- TOC entry 2036 (class 2604 OID 16414)
-- Name: id; Type: DEFAULT; Schema: public; Owner: mks_jg_online_user
--

ALTER TABLE ONLY public.competitions_to_competition_mapping ALTER COLUMN id SET DEFAULT nextval('public.competitions_to_competition_mapping_id_seq'::regclass);


--
-- TOC entry 2175 (class 0 OID 0)
-- Dependencies: 183
-- Name: competitionData_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mks_jg_online_user
--

SELECT pg_catalog.setval('public."competitionData_id_seq"', 27, true);


--
-- TOC entry 2160 (class 0 OID 16400)
-- Dependencies: 184
-- Data for Name: competition_data; Type: TABLE DATA; Schema: public; Owner: mks_jg_online_user
--

INSERT INTO public.competition_data (id, competition_serial_number, competition_id, competitor_name, competitor_start_number, competitor_rank, competitor_partial_rank, club_name, training_runs_times_str, scored_runs_times_str) VALUES (21, 234343243240, 0, 'baa Nk', 1, 0, 0, 'MKS Karkonosze Sporty Zimowe', '{}', '{00:00,00:00:01.100,00:00,00:00}');
INSERT INTO public.competition_data (id, competition_serial_number, competition_id, competitor_name, competitor_start_number, competitor_rank, competitor_partial_rank, club_name, training_runs_times_str, scored_runs_times_str) VALUES (22, 234343243240, 0, 'daa kz', 2, 0, 0, 'MKS Karkonosze Sporty Zimowe', '{}', '{00:00,00:00:01.234,00:00,00:00}');
INSERT INTO public.competition_data (id, competition_serial_number, competition_id, competitor_name, competitor_start_number, competitor_rank, competitor_partial_rank, club_name, training_runs_times_str, scored_runs_times_str) VALUES (23, 7687687687680, 1, 'Aąćż N', 1, 0, 0, 'MKS Karkonosze Sporty Zimowe', '{00:00}', '{00:00,00:00,00:00}');
INSERT INTO public.competition_data (id, competition_serial_number, competition_id, competitor_name, competitor_start_number, competitor_rank, competitor_partial_rank, club_name, training_runs_times_str, scored_runs_times_str) VALUES (24, 7687687687680, 1, 'Imi Nąz', 2, 0, 0, 'MKS Karkonosze Sporty Zimowe', '{00:00}', '{00:00,00:00,00:00}');
INSERT INTO public.competition_data (id, competition_serial_number, competition_id, competitor_name, competitor_start_number, competitor_rank, competitor_partial_rank, club_name, training_runs_times_str, scored_runs_times_str) VALUES (25, 7687687687680, 1, 'Im Naz', 3, 0, 0, 'MKS Karkonosze Sporty Zimowe', '{00:00}', '{00:00,00:00,00:00}');
INSERT INTO public.competition_data (id, competition_serial_number, competition_id, competitor_name, competitor_start_number, competitor_rank, competitor_partial_rank, club_name, training_runs_times_str, scored_runs_times_str) VALUES (26, 7687687687680, 1, 'ěřžšá Nazw', 4, 0, 0, 'MKS Karkonosze Sporty Zimowe', '{00:00}', '{00:00,00:00,00:00}');
INSERT INTO public.competition_data (id, competition_serial_number, competition_id, competitor_name, competitor_start_number, competitor_rank, competitor_partial_rank, club_name, training_runs_times_str, scored_runs_times_str) VALUES (27, 7687687687680, 1, 'Cazw Naz', 5, 0, 0, 'MKS Karkonosze Sporty Zimowe', '{00:00}', '{00:00,00:00,00:00}');


--
-- TOC entry 2158 (class 0 OID 16389)
-- Dependencies: 182
-- Data for Name: competitions; Type: TABLE DATA; Schema: public; Owner: mks_jg_online_user
--

INSERT INTO public.competitions (id, serial_num, competitions_name, date, location, track_name, logo1, logo2, judge1, judge2, judge3, organizer, comp_count) VALUES (5, 0, 'test', '2018-06-23', 'Zapora przy Łomnicy', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2);


--
-- TOC entry 2176 (class 0 OID 0)
-- Dependencies: 181
-- Name: competitions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mks_jg_online_user
--

SELECT pg_catalog.setval('public.competitions_id_seq', 5, true);


--
-- TOC entry 2162 (class 0 OID 16411)
-- Dependencies: 186
-- Data for Name: competitions_to_competition_mapping; Type: TABLE DATA; Schema: public; Owner: mks_jg_online_user
--

INSERT INTO public.competitions_to_competition_mapping (id, cmps_name, competition_serial_number) VALUES (1, 'test', 234343243240);
INSERT INTO public.competitions_to_competition_mapping (id, cmps_name, competition_serial_number) VALUES (2, 'test', 7687687687680);


--
-- TOC entry 2177 (class 0 OID 0)
-- Dependencies: 185
-- Name: competitions_to_competition_mapping_id_seq; Type: SEQUENCE SET; Schema: public; Owner: mks_jg_online_user
--

SELECT pg_catalog.setval('public.competitions_to_competition_mapping_id_seq', 2, true);


--
-- TOC entry 2040 (class 2606 OID 16408)
-- Name: competitionData_pkey; Type: CONSTRAINT; Schema: public; Owner: mks_jg_online_user
--

ALTER TABLE ONLY public.competition_data
    ADD CONSTRAINT "competitionData_pkey" PRIMARY KEY (id);


--
-- TOC entry 2042 (class 2606 OID 16419)
-- Name: competition_mapping_pkey; Type: CONSTRAINT; Schema: public; Owner: mks_jg_online_user
--

ALTER TABLE ONLY public.competitions_to_competition_mapping
    ADD CONSTRAINT competition_mapping_pkey PRIMARY KEY (id);


--
-- TOC entry 2038 (class 2606 OID 16397)
-- Name: competitions_primary_key; Type: CONSTRAINT; Schema: public; Owner: mks_jg_online_user
--

ALTER TABLE ONLY public.competitions
    ADD CONSTRAINT competitions_primary_key PRIMARY KEY (id);


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-08-18 22:44:42 CEST

--
-- PostgreSQL database dump complete
--


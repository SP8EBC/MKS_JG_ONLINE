--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.14
-- Dumped by pg_dump version 9.5.14

-- Started on 2018-09-01 18:47:38 CEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE mks_jg_online;
--
-- TOC entry 2162 (class 1262 OID 16384)
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
-- TOC entry 2165 (class 0 OID 0)
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
    scored_runs_times_str text[],
    total_scored_time_str text,
    birth_year integer
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
-- TOC entry 2167 (class 0 OID 0)
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
-- TOC entry 2169 (class 0 OID 0)
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
    competition_serial_number bigint,
    competition_type_name text
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
-- TOC entry 2171 (class 0 OID 0)
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
-- TOC entry 2164 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 184
-- Name: TABLE competition_data; Type: ACL; Schema: public; Owner: mks_jg_online_user
--

REVOKE ALL ON TABLE public.competition_data FROM PUBLIC;
REVOKE ALL ON TABLE public.competition_data FROM mks_jg_online_user;
GRANT ALL ON TABLE public.competition_data TO mks_jg_online_user;
GRANT ALL ON TABLE public.competition_data TO mks_jg_online;
GRANT SELECT ON TABLE public.competition_data TO mks_jg_online_ro;


--
-- TOC entry 2168 (class 0 OID 0)
-- Dependencies: 182
-- Name: TABLE competitions; Type: ACL; Schema: public; Owner: mks_jg_online_user
--

REVOKE ALL ON TABLE public.competitions FROM PUBLIC;
REVOKE ALL ON TABLE public.competitions FROM mks_jg_online_user;
GRANT ALL ON TABLE public.competitions TO mks_jg_online_user;
GRANT ALL ON TABLE public.competitions TO mks_jg_online;
GRANT SELECT ON TABLE public.competitions TO mks_jg_online_ro;


--
-- TOC entry 2170 (class 0 OID 0)
-- Dependencies: 186
-- Name: TABLE competitions_to_competition_mapping; Type: ACL; Schema: public; Owner: mks_jg_online_user
--

REVOKE ALL ON TABLE public.competitions_to_competition_mapping FROM PUBLIC;
REVOKE ALL ON TABLE public.competitions_to_competition_mapping FROM mks_jg_online_user;
GRANT ALL ON TABLE public.competitions_to_competition_mapping TO mks_jg_online_user;
GRANT ALL ON TABLE public.competitions_to_competition_mapping TO mks_jg_online;
GRANT SELECT ON TABLE public.competitions_to_competition_mapping TO mks_jg_online_ro;


-- Completed on 2018-09-01 18:47:39 CEST

--
-- PostgreSQL database dump complete
--


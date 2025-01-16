DROP TABLE keywords;
DROP TABLE bookkeywords;
DROP TABLE tags;
DROP TABLE bookformat;
DROP TABLE maturity;
DROP DATABASE mybooks;

CREATE DATABASE IF NOT EXISTS mybooks;

USE mybooks;


CREATE TABLE if NOT EXISTS bookFormat (
	formatId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	formatName VARCHAR(100) NOT NULL,
	description VARCHAR(100) NOT NULL
);

CREATE TABLE if NOT EXISTS maturity (
	maturityId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	maturityName VARCHAR(20) NOT NULL,
	description VARCHAR(200) NOT NULL
);


CREATE TABLE if NOT EXISTS keywords (
	keywordId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	keywordName VARCHAR(100) NOT NULL,
	description VARCHAR(100) NOT NULL
);


CREATE TABLE if NOT EXISTS hashtags (
	hashtagId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	hashtagName VARCHAR(100) NOT NULL,
	DESCRIPTION VARCHAR(400) NOT NULL
);


CREATE TABLE if NOT EXISTS books (
	bookId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	author VARCHAR(100) NOT NULL,
	starRating VARCHAR(50) NOT NULL,
	publisher VARCHAR(100) NOT NULL,
	dateRead INT NOT NULL,
	releaseYear INT NOT NULL,
	bookFormat VARCHAR(50) NOT NULL,
	pageCount INT NOT NULL,
	audioBook VARCHAR(20) NOT NULL,
	ageRating VARCHAR(50) NOT NULL,
	seriesNumber VARCHAR(20) NOT NULL,
	keyword1 VARCHAR(100) NOT NULL,
	keyword2 VARCHAR(100) NOT NULL,
	keyword3 VARCHAR(100) NOT NULL,
	hashtag1 VARCHAR(100) NOT NULL,
	hashtag2 VARCHAR(100) NOT NULL,
	hashtag3 VARCHAR(100) NOT NULL,
	hashtag4 VARCHAR(100) NOT NULL,
	hashtag5 VARCHAR(100) NOT NULL
);

CREATE TABLE if NOT EXISTS tbr (
	bookId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	author VARCHAR(100) NOT NULL,
	releaseYear INT NOT NULL,
	bookFormat VARCHAR(50) NOT NULL,
	pageCount INT NOT NULL,
	audioBook VARCHAR(20) NOT NULL,
	ageRating VARCHAR(50) NOT NULL,
	seriesNumber VARCHAR(20) NOT NULL,
	keyword1 VARCHAR(100) NOT NULL,
	keyword2 VARCHAR(100) NOT NULL,
	keyword3 VARCHAR(100) NOT NULL,
	hashtag1 VARCHAR(100) NOT NULL,
	hashtag2 VARCHAR(100) NOT NULL,
	hashtag3 VARCHAR(100) NOT NULL,
	hashtag4 VARCHAR(100) NOT NULL,
	hashtag5 VARCHAR(100) NOT NULL,
	recScore INT NOT NULL,
	keywordScore INT NOT NULL,
	authorScore INT NOT NULL,
	totalScore INT NOT NULL
);

INSERT INTO tbr (title,author,releaseYear,bookformat,pageCount,audioBook,ageRating,seriesNumber,keyword1,keyword2,keyword3,hashtag1,hashtag2,hashtag3,hashtag4,
hashtag5,recScore,keywordScore,authorScore,totalScore)
VALUES
('Spillover: Animal Infections and the Next Human Pandemic','David Quammen',2012,'Non-Fiction',592,'No','Adult','n/a','Science','Social Sci','Speculative','Biology','Infectious Diseases','Pandemics','Health','none',2,2,0,4);



INSERT INTO bookFormat (formatName, description)
VALUES
('Fiction','Long-form prose about made-up characters, places, events, ideas, and knowledge.'),
('NonFiction','Long-form prose about real-life characters, places, events, ideas, and knowledge.'),
('Poetry','Expression of feelings and ideas using distinctive styles and rhythms.'),
('Essays','Academic analysis on one or more chosen topic and/or theme.'),
('ShortStories','Short-form prose about made-up characters, places, events, ideas, and knowledge.'),
('CreativeNonFic','Short-form prose about real-life characters, places, events, ideas, and knowledge.'),
('Play','Dramatic work for stage or broadcast.'),
('Graphic Novel','Stories that have been drawn.');

INSERT INTO maturity (maturityName, description)
VALUES
('BoardBooks','0-3 y/o; max. 300 words'),
('PictureBooks','4-8 y/o; 600 - 1000 words'),
('EarlyReaders','5-8 y/o; Max. 2000 words'),
('ChapterBooks','6-10 y/o; 8.5k - 12k words; max. 20k words'),
('MiddleGrade','8-12 y/o; 30k - 50k words'),
('YoungAdult','12+ y/o; 45k-80k words; marketed toward teenagers and deal with teenage characters, problems, and perspective.'),
('Adult','20+; usually follows protagonists aged 20 and over');


INSERT INTO keywords (keywordName, DESCRIPTION)
VALUES
('None','Null Value'),
('Romance','Love stories'),
('Horror','Scary stories'),
('Mystery','Suspenseful stories'),
('Thriller','Extra suspenseful stories'),
('History','Old stories')	,
('SelfHelp','Helpful stories'),
('SciFi	','Tech stories')	,
('Fantasy','Magic stories'),
('Classic','Snobby stories'),
('Humor','Funny stories'),
('Literary','Modern snobby stories'),
('TrueCrime','Murder stories	'),
('Science','Informative stories'),
('Memoir/Autobiography','Narrative stories'),
('Biography','Narrative stories told by other people'),
('WomenFiction','Confusing catch-all'),
('GraphicNovel','Stories with pictures for adults'),
('Travel	','Stories about going places'),
('FairyTale','Whimsical stories'),
('Speculative',	'Contemplative stories	'),
('Satire	','Tongue-in-cheek stories'),
('Western','Cowboy stories'),
('Spirituality','Religious stories'),
('Bildungsroman','Coming of age stories'),
('Paranormal','Fantasy but with vampires, probably'),
('Action','Fast-paced stories'),
('SocialSci','Social stories'),
('AlternateHistory','What If Old stories'),
('Contemporary','Modern stories');


DROP TABLE hashtags;




INSERT INTO books (title, author, starRating, publisher, dateRead, releaseYear, bookFormat, pageCount, audioBook, ageRating, seriesNumber, keyword1, keyword2, keyword3, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5)
VALUES
('Mafia Nanny','Violet Matter','5/5','Webtoons',2024,2025,'Graphic Novel',288,'No','Adult','1','Romance','Mystery','Action','Forbidden Love','Office Romance','Bad Boy','PowerImbalance','Family'),
('Moby Dick','Herman Melville','2/3','Harper Brothers',2000,1851,'Fiction',5000,'Yes','Adult','n/a','Classic','Self-Help','Action','Whales','White Whales','Dang Whales','Power Imbalance','Family'),
('The Hot Zone','Richard Preston','5/5','Ballantine',2024,1994,'Non-Fiction',368,'Yes','Adult','n/a','Science','Biography','Thriller','Virology','Biology','Ebola','Infectious Diseases','Monkeys'),
('The Demon in the Freezer','Richard Preston','4/4','Ballantine',2025,2002,'Non-Fiction',292,'No','Adult','n/a','Science','Biography','Thriller','Virology','Biology','Smallpox','Infectious Diseases','Journalism'),
('Pride and Prejudice','Jane Austen','4.5/5','Whitehall',2019,1813,'Fiction',384,'Yes','Young Adult','n/a','Classic','Romance','Literary','Enemies to Lovers','Traditional Regency','Opposites Attract','Family','Slow burn'),
('The Rom-Commers','Katherine Center','5/5','St. Martins',2024,2024,'Fiction',336,'No','Adult','n/a','Romance','Humor','Contemporary','Enemies to Lovers','Slow burn', 'Stuck Together','Forced Proximity','Grumpy Sunshine'),
('Gut: The Inside Story of Our Bodys Most Underrated Organ','Giulia Enders','5/5','Greystone',2020,2014,'Non-Fiction',280,'No','Adult','n/a','Self Help','Science','None','Biology','Health','Wellness','Gut','none'),
('Treasure Island','Robert Louis Stevenson','3.5/5','Puffin + Pantone',2020,1883,'Fiction',303,'Yes','Young Adult','n/a','Classic','Literary','Travel','Pirates','Treasure Planet Was Better','Stranded','none','none'),
('Catcher in the Rye','J.D. Salinger','3/5','Little, Brown',2009,1951,'Fiction',288,'Yes','Young Adult','n/a','Classic','Literary','Bildungsroman','Angst','Identity','Teenage','Growing Up','Loss of Innocence'),
('Staring at the Sun: Overcoming the Terror of Death','Irvin Yalom','3/5','Jossey-Bass',2020,2009,'Non-Fiction',306,'No','Adult','n/a','Self Help','Social Sci','Science','Therapy','Existentialism','Death','Death Anxiety','Counseling'),
('Dune','Frank Herbert','3/5','Chilton Books',2020,1965,'Fiction',617,'Yes','Adult','1','Fantasy','Sci-Fi','Thriller','Spice','Political Drama','Subterfuge','Worms','Messiah Figure'),
('Tropic of Squalor','Mary Karr','5/5','Harper',2022,2018,'Poetry',86,'No','Adult','n/a','Spirituality','Memoir/Autobiography','Literary','Skepticism','Visceral','Numinous','Prayer','Divine'),
('The Love Hypothesis','Ali Hazelwood','5/5','Berkley',2023,2021,'Fiction',384,'Yes','Adult','n/a','Romance','Contemporary','Science','Fake Relationship','Stuck Together','Grumpy Sunshine','Open Door','STEMinist'),
('18 Tiny Deaths: The Untold Story of the Woman Who Invented Modern Forensics','Bruce Goldfarb','2.5/5','Sourcebooks',2023,2021,'Non-Fiction',368,'No','Adult','n/a','Science','Biography','History','Crime','Forensics','Dioramas','Investigations','none');





	

SELECT bookId, title, author
FROM books;

SELECT bookId, title, author, starRating, publisher, dateRead, releaseYear, bookFormat, pageCount, audioBook, ageRating, seriesNumber,
keyword1, keyword2, keyword3, hashtag1, hashtag2, hashtag3, hashtag4, hashtag5
FROM books;

SELECT hashtagName
FROM hashtags;

INSERT INTO hashtags (hashtagName, DESCRIPTION)
VALUES
('None','n/a'),
('Enemies To Lovers','the main characters are adversaries, enemies, opponents, and usually dislike the other character before a relationship develops.'),
('Fake Relationship','the main characters agree to enter into a fake relationship for varying reasons (e.g. satisfying conditions of a will, revenge on an ex, undercover as part of a mission, etc).'),
('Forbidden Love','two people who are madly in love but forced apart, whether by families, culture, geographical distance, or other factors.'),
('Friends To Lovers','the main characters are initially friends and enter a relationship throughout the story.'),
('Forced Proximity','where the main characters are in a small space together (e.g. a cabin during a snow storm, a sailboat out in the ocean, etc)'),
('Arranged Marriage','characters are forced into marriage due to external pressures, such as family debts, inheritance rules, or avoiding scandal'),
('Opposites Attract','people who are very different from each other in personality, interests, or lifestyle are drawn to one another romantically'),
('Second Chance','a romance in which main characters are former lovers who reconnect after a break up or separation.'),
('Amnesia',' involves a character losing their memory, often after a head injury. It can be a way to disrupt a relationship and force the characters to grow in new ways'),
('Best Friend/Sibling','the love interest is someone who is well established in the main characters life, either through being their best friend or by being siblings with one of their best friends'),
('Holiday Romance','romance that occurs while on holiday/on vacation'),
('Marriage','features characters who are married or get married'),
('Office Romance','romance that occurs in a work setting, either between co-workers or boss/employee'),
('Bad Boy','a male character archetype typically portrayed as rebellious, mysterious, and often with a rough exterior, who despite potentially problematic behaviors, is often seen as alluring and desirable by romantic interests due to their perceived confidence, intensity, and air of danger'),
('Betting','risking something of value, like time, effort, or emotional investment, on a romantic relationship with the expectation of a positive outcome'),
('Bride','a woman just married or about to be married'),
('Family','stories involving family, either real or found-family'),
('One Night Stand','(romance that starts from) a sexual encounter that happens once with no expectation of continuing a relationship with the other person'),
('Road Trip','two characters who are forced to travel together and develop a relationship'),
('Stuck Together','Similar to forced proximity; romantic setup where two characters end up stuck together, whether they like it or not'),
('Sweet Romance','light-hearted and heart-warming, without explicit content'),
('Age Gap','a significant amount of years between the ages of the main characters. Also referred to as May/December or December/May Romances'),
('Beautiful All Along','someones true beauty, whether physical or more deeply personal, has always been present and was simply not fully recognized or appreciated until a deeper connection was formed'),
('Billionaire','one character is significantly wealthier than the other(s).'),
('Only One Bed','a common forced proximity scene in which two characters need to share a bed.'),
('Bodyguard','one characters job is to protect the other character(s)'),
('Bully','main character(s) have tormented, teased, belittled, or derided the other main character(s) and others in the story. Usually followed by a redemption arc and a romantic relationship.'),
('Captor / Captive','where one character holds another character captive, for example in a kidnapping plot.'),
('Celebrity','main character(s) are famous.'),
('Fated Mates','the main characters are destined to be together (see Shifter or Paranormal).'),
('Grumpy / Sunshine','where one character has a happy/pleasant/bubbly personality and the other character is gruff/stoic/harsh.'),
('Hurt / Comfort','main character(s) are physically or emotionally hurt and receive comfort and support from the other main character(s)'),
('Marriage Of Convenience','the main characters must get married for reasons other than love (e.g. money or to avoid scandal).'),
('Power Imbalance','a romantic relationship between character(s) with varying levels of power, such as Teacher/Student, Boss/Employee, etc.'),
('Relationship Coach','one main character teaches another main character about physical intimacy, usually with the intention of not developing emotional attachments.'),
('Age Play',' roleplay where an adult adopts certain characteristics and mannerisms of a younger person (see DD/LG and DD/LB)'),
('Alpha','a character who is a natural leader, naturally dominates, or embodies stereotypically masculine characteristics, including being dominant, aggressive and confident.'),
('Alphahole','Alpha + Asshole. An alpha who takes things too far into jerk category.'),
('Angst','inner emotional turmoil of a character.'),
('Bi Awakening','a character discovers they’re bisexual or biromantic. Bi-awakening stories often start with the character believing they’re heterosexual, but can involve other sexualities as well.'),
('Bleak / Black Moment','the point of the story where all hope is lost, usually towards the end. In romance, it’s where you struggle to believe that these characters can ever work things out and live happily together.'),
('Bodice Ripper','usually refers to romance novels written in the 1970s and 80s that often featured older MMCs, nonconsent, and violence. Also called old skool or vintage romance.'),
('Category Romance','short romance novels of less than 200 pages with a certain number of books published in each line per month; the most famous publishers are Harlequin and Silhouette.'),
('Cinnamon Roll','a character who is is kind, innocent, cute/adorable, and pure.'),
('Clean / Sweet / Proper','books where minimal or no physical intimacy occurs. Note: this wording can be problematic as it implies a negative connotation of dirty for the inverse. However, these terms are the most commonly used ones in standard marketing. Closed door or Fade to black are preferred terms for romances where no/little on page intimacy.'),
('Closed Door','sex scenes occur, but are off-page. Also known as fade-to-black.'),
('December May','romance between significantly older FMC and younger MMC.'),
('Dubcon','sexual scenes that feature dubious consent. See related: relcon, noncon.'),
('Gay Awakening','a character discovers they’re gay or homoromantic. Gay awakening stories often start with the character believing they’re heterosexual, but can involve other sexualities as well.'),
('Georgian Romance','historical romance taking place between 1714 and 1795, during which the UK was ruled by a series of Hanoverian kings named George.'),
('Grovel','an extended apology or Grand Gesture called for when a character has done something Very Bad to their love interest and needs to make up for it. Grand Gestures for example are: public proclamations of love, quitting a job to follow the love interest around the world, etc.'),
('Himbo','male bimbo, or a male character whos cute but a little dumb.'),
('Inspirational','faith based romances, most often Christian.'),
('Insta Lust/Love','the characters fall in love or lust almost immediately after meeting.'),
('Interracial','romance featuring leads of different races, often abbreviated in acronyms like AMBW (Asian Man, Black Woman), BWWM (Black Woman, White Man), etc.'),
('May December','romance between significantly older MMC and younger FMCf.'),
('Menage','the main character has more than 1 romantic interest. It could mean that the main character has to choose or that the character is able to maintain multiple romantic relationships.'),
('Noncon','sexual scenes that feature non-consent. See related: dubcon.'),
('Open Door','sex scenes occur on page.'),
('Own Voices','books that are written by an author that shares a marginalized identity with the protagonist. For example, a Black author writing Black characters.'),
('Relcon','sexual scenes that feature reluctant consent. See related: dubcon, noncon.'),
('Reverse Harem','a romance between one FMC and multiple partners (usually male).'),
('Sapphic',' a romance between female character(s).'),
('Shifter','character who is able to shift into an animal form, like a werewolf. Can also sometimes be seen in sci-fi with alien or cyborg characters.'),
('Slow Burn','a romance where the relationship takes a while to develop.'),
('Toaster Oven','a female character who goes through a process of self-discovery and figures out that she isn’t as straight as she previously assumed.'),
('Traditional Regency','regency romance inspired by the mid-20th century author Georgette Heyer, often with low or no steam, and a lot of historical detail.'),
('Wallpaper Romance','a romance with a historical setting but characters who act in modern/anachronistic ways.'),
('Why Choose','a romance between one FMC and multiple partners (usually male).'),
('Love Triangle','a situation where two people are both romantically interested in the same third person, creating a complex dynamic of rivalry and often unrequited love between the three individuals involved'),
('Fluff','light, happy, and comforting piece of writing that often lacks a real message or plot'),
('Summoning','the act of calling or summoning a spirit, demon, deity or other supernatural agent'),
('Haunted House','a building or location that is believed to be inhabited by ghosts or other supernatural beings'),
('Demon','A being from hell, usually evil'),
('Ghost','an apparition of a dead person which is believed to appear or become manifest to the living, typically as a nebulous image.'),
('Vampire','a mythical creature that subsists by feeding on the vital essence of a living being; typically drink blood'),
('Cursed Artifact','artifacts imbued with a malevolent will or magic, transforming them into sources of misfortune, transformation, or doom for those who dare to wield or possess them'),
('Teen Summer','horror that usually involves teenagers on break from school, like at camp or similar settings'),
('Magical Realism','presents a realistic view of the world while incorporating magical elements, often blurring lines between speculation and reality'),
('Splitting Up','classic horror trope where a larger group breaks off into smaller or individual groups, leaving them vulnerable to attack from the monster or killer'),
('Classic Monster','monsters similar to Dracula, Frankensteins Monster, wolf man, mummy, the creature from the black lagoon, phantom of the opera, hunchback of notre dame, Dr. Jekyll and Mr. Hyde, the invisible man'),
('Psychological','n/a'),
('Secret Lab','n/a'),
('Mirrors','n/a'),
('Dolls','n/a'),
('Clowns','n/a'),
('Being Watched','n/a'),
('Stranger Danger','n/a'),
('Gore','n/a'),
('Hunted','n/a'),
('Werewolf','n/a'),
('BodyHorror','n/a'),
('Sexual Horror','n/a'),
('Rape/NonCon','n/a'),
('Gothic','n/a'),
('Survival','n/a'),
('Slasher','n/a'),
('Psycho','n/a'),
('Serial Killer','n/a'),
('Erotic','n/a'),
('Supernatural','n/a'),
('Zombie','n/a'),
('Lovecraftian','n/a'),
('Witch','n/a'),
('Violence','n/a'),
('Post Apocalyptic','n/a'),
('Splatterpunk','n/a'),
('Creature','n/a'),
('Cozy','n/a'),
('Police Procedural','n/a'),
('Detective','n/a'),
('Hardboiled','n/a'),
('Noir','n/a'),
('Caper','n/a'),
('Suspense','n/a'),
('Crime','n/a'),
('Spy','n/a'),
('Amateur Sleuth','n/a'),
('Locked Room','n/a'),
('Whodunit','n/a'),
('Legal','n/a'),
('Political','n/a'),
('Medical','n/a'),
('Techno','n/a'),
('Suspense','n/a'),
('Country','n/a'),
('War','n/a'),
('Culture','n/a'),
('Event','n/a'),
('Person','n/a'),
('Biology','n/a'),
('Personal Development','n/a'),
('Mindfulness','n/a'),
('Health/Wellness','n/a'),
('Relationships','n/a'),
('Career','n/a'),
('Finances','n/a'),
('Creativity','n/a'),
('Productivity','n/a'),
('Space Opera','n/a'),
('Cyberpunk','n/a'),
('Dystopian','n/a'),
('Steampunk','n/a'),
('Alternate History','n/a'),
('Apocalyptic','n/a'),
('Military','n/a'),
('Alien','n/a'),
('Time Travel','n/a'),
('Space Western','n/a'),
('Soft SciFi','n/a'),
('Parallel Universe','n/a'),
('Hard SciFi','n/a'),
('Solarpunk','n/a'),
('AI','n/a'),
('Cosmic Horror','n/a'),
('Afrofuturism','n/a'),
('Colonization','n/a'),
('Comic Light SciFi','n/a'),
('Dying Earth','n/a'),
('High','n/a'),
('Low','n/a'),
('Dark','n/a'),
('Contemporary','n/a'),
('Magical Realism','n/a'),
('Urban','n/a'),
('Grimdark','n/a'),
('Epic','n/a'),
('Sword Sorcery','n/a'),
('Mythic','n/a'),
('Portal','n/a'),
('Superhero','n/a'),
('Fable','n/a'),
('Light','n/a'),
('Slapstick','n/a'),
('Dry','n/a'),
('Sarcastic','n/a'),
('Absurdist','n/a'),
('Witty','n/a'),
('Puns','n/a'),
('Subtle','n/a'),
('Kidnapping','n/a'),
('Cults','n/a'),
('White Collar','n/a'),
('Thieves','n/a'),
('Missing Persons','n/a'),
('Organized Crime','n/a'),
('Hard Science','n/a'),
('Soft Science','n/a'),
('Immigrant','n/a'),
('Family','n/a'),
('Confessional','n/a'),
('Survivor','n/a'),
('ChickLit','n/a'),
('Devotional','n/a'),
('Academic','n/a'),
('Religious','n/a'),
('Theology','n/a'),
('Tales Of Terror','n/a'),
('Terrorism','n/a'),
('Intrigue','n/a'),
('Anthropology','n/a'),
('Economics','n/a'),
('Sociology','n/a'),
('Archaeology','n/a'),
('Linguistics','n/a'),
('Communication','n/a'),
('Political Sci','n/a'),
('Feminism','n/a'),
('Public Health','n/a'),
('Media Studies','n/a'),
('Geography','n/a');

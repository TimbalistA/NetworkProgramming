Laboratory Work #4
--
Task
--
Create a simple email client application which will give the possibility to send and read messages using an email account.

Theory
--
SMTP
--
SMTP is an acronym for Simple Mail Transfer Protocol. 
It is an Internet standard for electronic mail (e-mail) transmission across Internet Protocol (IP) networks. 
SMTP uses TCP port 25. SMTP connections secured by SSL are known by the shorthand SMTPS, though SMTPS is not a protocol in its own right.

JavaMail API has package com.sun.mail.smtp which act as SMTP protocol provider to access an SMTP server. 
Following table lists the classes included in this package:

* SMTPMessage -	This class is a specialization of the MimeMessage class that allows you to specify various SMTP options and parameters that will be used when this message is sent over SMTP.
* SMTPSSLTransport - This class implements the Transport abstract class using SMTP over SSL for message submission and transport.
* SMTPTransport	- This class implements the Transport abstract class using SMTP for message submission and transport.

POP
--
Post Office Protocol (POP) is an application-layer Internet standard protocol used by local e-mail 
clients to retrieve e-mail from a remote server over a TCP/IP connection. POP supports simple 
download-and-delete requirements for access to remote mailboxes. A POP3 server listens on well-known port 110.

Package com.sun.mail.pop3 is a POP3 protocol provider for the JavaMail API that provides access to a POP3 message store. 
The table below lists the classes in this package:

* POP3Folder -	A POP3 Folder (can only be "INBOX").
* POP3Message - A POP3 Message.
* POP3SSLStore -	A POP3 Message Store using SSL.
* POP3Store - A POP3 Message Store.
